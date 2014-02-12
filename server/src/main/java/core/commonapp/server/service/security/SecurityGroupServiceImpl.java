/**
 * Copyright 2009 Core Information Solutions LLC
 *
 * This file is part of Core CommonApp Framework.
 *
 * Core CommonApp Framework is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Core CommonApp Framework is distributed in the hope that it will be  
 * useful, but WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General 
 * Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along 
 * with Core CommonApp Framework.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package core.commonapp.server.service.security;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import core.commonapp.client.dao.security.PermissionSecurityGroupDao;
import core.commonapp.client.dao.security.SecurityGroupDao;
import core.commonapp.client.dao.security.UserLoginSecurityGroupDao;
import core.commonapp.client.service.security.SecurityGroupService;
import core.commonapp.domain.InformationContext;
import core.data.cache.security.PermissionKey;
import core.data.model.security.Permission;
import core.data.model.security.PermissionSecurityGroup;
import core.data.model.security.SecurityGroup;
import core.data.model.security.UserLogin;
import core.data.model.security.UserLoginSecurityGroup;
import core.service.annotation.Security;
import core.service.exception.ServiceException;
import core.service.result.ServiceResult;

public class SecurityGroupServiceImpl implements SecurityGroupService, ApplicationContextAware
{

    @Autowired
    private PermissionSecurityGroupDao permissionSecurityGroupDao;
    
    @Autowired
    private UserLoginSecurityGroupDao userLoginSecurityGroupDao;
    
    @Autowired
    private SecurityGroupDao securityGroupDao;
    
    /** set when service is created */
    private InformationContext context;

    /**
	 * 
	 */
    public SecurityGroupServiceImpl()
    {
        super();
    }

    @Override
    @Security(permissionKey=PermissionKey.KEY_MODIFY_SECURITY_GROUP)
    public ServiceResult<List<UserLoginSecurityGroup>> addUsersToSecurityGroup(UserLogin userLogin, SecurityGroup securityGroup, List<UserLogin> users)
    {
        List<UserLoginSecurityGroup> userLoginGroups = new ArrayList<UserLoginSecurityGroup>(users.size());
        for (UserLogin userToAdd : users)
        {
            // Check if user already exist
            List<UserLoginSecurityGroup> exists = userLoginSecurityGroupDao.findByUserLoginAndSecurityGroup(userToAdd, securityGroup, false);
            if (exists.size() > 0) 
            {
                throw new ServiceException("User login already exist for security group (username=" + userLogin.getUsername() + ").");
            }
            
            // create relationship
            UserLoginSecurityGroup userLoginGroup = (UserLoginSecurityGroup) context.getBean(UserLoginSecurityGroup.class);
            userLoginGroup.setSecurityGroup(securityGroup);
            userLoginGroup.setUserLogin(userToAdd);
            // TODO: Handle service date
            userLoginGroup.setFromDate(new Date());
            userLoginSecurityGroupDao.save(userLoginGroup);
        }

        return ServiceResult.success("Added users to security group.", userLoginGroups);
    }

    @Override
    @Security(permissionKey=PermissionKey.KEY_CREATE_SECURITY_GROUP)
    public ServiceResult<SecurityGroup> createSecurityGroup(UserLogin userLogin, String description, String code)
    {
        if (code.indexOf(" ") > -1)
        {
            throw new ServiceException("Security group code cannot contain spaces.");
        }

        SecurityGroup securityGroup = (SecurityGroup) context.getBean("securityGroupModel");
        securityGroup.setDescription(description);
        securityGroup.setCode(code);
        securityGroup.setKey(code.toUpperCase());

        securityGroupDao.save(securityGroup);

        return ServiceResult.success("Security group created successfully", securityGroup);
    }

    @Override
    public ServiceResult<List<SecurityGroup>> findAllSecurityGroups()
    {
        List<SecurityGroup> securityGroups = securityGroupDao.findAll();
        return ServiceResult.success("Successfully found all security groups.", securityGroups);
    }

    @Override
    public ServiceResult<Set<SecurityGroup>> findAllSecurityGroupsForUserLogin(UserLogin userLogin)
    {
        Set<SecurityGroup> securityGroups = securityGroupDao.findAllByUserLogin(userLogin);
        return ServiceResult.success("Successfully found security groups for user.", securityGroups);
    }

    @Override
    @Security(permissionKey=PermissionKey.KEY_MODIFY_SECURITY_GROUP)
    public ServiceResult<List<UserLoginSecurityGroup>> removeUsersFromSecurityGroup(UserLogin userLogin, SecurityGroup securityGroup,
            List<UserLogin> users)
    {
        List<UserLoginSecurityGroup> existing = userLoginSecurityGroupDao.findBySecurityGroup(securityGroup, false);
        List<UserLoginSecurityGroup> modified = new ArrayList<UserLoginSecurityGroup>(existing.size());
        for (UserLogin userToRemove : users) 
        {
            UserLoginSecurityGroup toExpire = null;
            for (UserLoginSecurityGroup userLoginSecurityGroup : existing) 
            {
                if (userLoginSecurityGroup.getUserLogin().getId().equals(userToRemove.getId())) 
                {
                    toExpire = userLoginSecurityGroup;
                }
            }
            if (toExpire == null) 
            {
                throw new ServiceException("Cannot remove user from security group, user does not exist in group (username=" + userToRemove.getUsername() + ").");
            }
            // TODO: handle service date
            toExpire.setThruDate(new Date());
            modified.add((UserLoginSecurityGroup)userLoginSecurityGroupDao.save(toExpire));
        }
        return ServiceResult.success("Users removed from security group.", modified);
    }

    @Override
    @Security(permissionKey=PermissionKey.KEY_MODIFY_SECURITY_GROUP)
    public ServiceResult<List<PermissionSecurityGroup>> saveSecurityGroup(UserLogin userLogin, SecurityGroup securityGroup,
            List<Permission> permissions)
    {
        List<PermissionSecurityGroup> permissionGroups = new ArrayList<PermissionSecurityGroup>(permissions.size());
        // Check for existing permission
        List<PermissionSecurityGroup> existing = permissionSecurityGroupDao.findAllBySecurityGroup(securityGroup, false);
        
        // remove any existing relations not in permissions list
        for (PermissionSecurityGroup permissionSecurityGroup : existing) 
        {
            boolean found = false;
            for (Permission permission : permissions) 
            {
                if (permission.getId().equals(permissionSecurityGroup.getPermission().getPermissionId()))
                {
                    found = true;
                }
            }
            if (!found) 
            {
                // TODO: handle service date
                permissionSecurityGroup.setThruDate(new Date());
                permissionSecurityGroupDao.save(permissionSecurityGroup);
            }
            
        }

        // add new relations
        for (Permission permissionToAdd : permissions)
        {
            boolean found = false;
            for (PermissionSecurityGroup permissionSecurityGroup : existing) 
            {
                if (permissionToAdd.getId().equals(permissionSecurityGroup.getPermission().getId()))
                {
                    found = true;
                }
            }
            if (!found) 
            {
                // Create relationship
                PermissionSecurityGroup permissionGroup = (PermissionSecurityGroup) context.getBean(
                        "permissionSecurityGroupModel");
                permissionGroup.setPermission(permissionToAdd);
                permissionGroup.setSecurityGroup(securityGroup);
                // TODO: handle service date
                permissionGroup.setFromDate(new Date());
    
                permissionGroups.add(permissionGroup);
            }
        }
        
        permissionSecurityGroupDao.saveAll(permissionGroups);

        return ServiceResult.success("Added permissions to group successfully.", permissionGroups);
    }


    @Override
    public void setApplicationContext(ApplicationContext context)
    {
        this.context = new InformationContext(context);
    }

}
