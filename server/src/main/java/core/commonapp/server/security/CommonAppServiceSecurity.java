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
package core.commonapp.server.security;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import core.commonapp.client.service.security.SecurityGroupService;
import core.data.cache.KeyedCache;
import core.data.cache.KeyedCacheStore;
import core.data.cache.security.PermissionKey;
import core.data.model.security.Permission;
import core.data.model.security.PermissionSecurityGroup;
import core.data.model.security.SecurityGroup;
import core.data.model.security.UserLogin;
import core.service.annotation.Security;
import core.service.exception.ServiceException;
import core.service.exception.ServiceSecurityException;
import core.service.result.ServiceResult;
import core.service.security.ServiceSecurity;
import core.service.session.ClientServiceSession;
import core.tooling.logging.LogFactory;
import core.tooling.logging.Logger;

public class CommonAppServiceSecurity implements ServiceSecurity
{
    /** logger for this class */
    Logger logger = LogFactory.getLogger(CommonAppServiceSecurity.class);

    /** security group service, object is lazy loaded in the getter */
    private SecurityGroupService securityGroupService = null;
    
    /** permission cache store */
    private KeyedCacheStore<Permission> permissionStore;
    
    @Autowired
    private KeyedCache keyedCache;
    
    @Autowired
    private ApplicationContext context;
    
    @Override
    public void authenticate(ClientServiceSession session, Class serviceInterface, Method method, Object[] args)
    {
        for (int index = 0; index < args.length; index++)
        {
            Object object = args[index];
            if ((object instanceof UserLogin))
            {
                UserLogin userLogin = (UserLogin) object;
                logger.debug("Authenticating service security for user (userLogin={0}).", userLogin);
    
                // get security groups and Security annotation
                Set<SecurityGroup> securityGroups = getSecurityGroups(userLogin);
                Security security = getMethodSecurity(serviceInterface, method);
    
                // go through security groups and permissions to match permission key
                for (SecurityGroup securityGroup : securityGroups)
                {
                    for (PermissionSecurityGroup permissionSecurityGroup : securityGroup.getPermissionSecurityGroups())
                    {
                        if (permissionSecurityGroup.getPermission().getKey().equals(security.permissionKey())
                                || permissionSecurityGroup.getPermission().getKey().equals(PermissionKey.KEY_ROOT))
                        {
                            return;
                        }
                    }
                }
                // permission was not found, throw security exception
                throw new ServiceSecurityException("User does not have permission to invoke service (userLoginId="
                        + userLogin.getUserLoginId()
                        + ",username="
                        + userLogin.getUsername()
                        + ",requiredPermission="
                        + security.permissionKey()
                        + ").");
            }
        }
        throw new IllegalArgumentException("Object cannot be handled.");
    }

    /**
     * Get the security annotation from the given method
     * 
     * @param serviceInterface
     * @param method
     * @throws IllegalArgumentException
     *             if no Security annotation exist on method
     * @return
     */
    private Security getMethodSecurity(Class serviceInterface, Method method)
    {
        Security security = method.getAnnotation(Security.class);
        if (security == null)
        {
            throw new IllegalArgumentException("This service method cannot be authenticated against (serviceInterface="
                    + serviceInterface.getName() + ",method=" + method.getName() + ").");
        }
        return security;
    }

    /**
     * lazy getter for permissionCache
     * 
     * @return
     */
    private KeyedCacheStore<Permission> getPermissionCache()
    {
        if (permissionStore == null)
        {
            permissionStore = keyedCache.getCacheStore(Permission.class);
        }
        return permissionStore;
    }

    /**
     * return list of security groups for user if the user
     * has no active security groups then return an empty 
     * list
     * 
     * @param userLogin
     * @return
     */
    private Set<SecurityGroup> getSecurityGroups(UserLogin userLogin)
    {
        ServiceResult<Set<SecurityGroup>> result = securityGroupService.findAllSecurityGroupsForUserLogin(userLogin);
        if (!result.isSuccess())
        {
            throw new ServiceException("Failed to get security groups for authentication: " + result.getMessage());
        }
        Set<SecurityGroup> securityGroups = result.getPayload();
        return securityGroups == null ? new HashSet<SecurityGroup>(0) : securityGroups;
    }

}
