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
package core.commonapp.client.service.security;

import java.util.List;
import java.util.Set;

import core.data.model.security.Permission;
import core.data.model.security.PermissionSecurityGroup;
import core.data.model.security.SecurityGroup;
import core.data.model.security.UserLogin;
import core.data.model.security.UserLoginSecurityGroup;
import core.service.InformationBean;
import core.service.Service;
import core.service.result.ServiceResult;

@InformationBean(beanName = "securityGroupService")
@Service
public interface SecurityGroupService
{

    /**
     * 
     * @param userLogin
     * @param securityGroup
     * @param users
     * @return
     */
    public ServiceResult<List<UserLoginSecurityGroup>> addUsersToSecurityGroup(UserLogin userLogin,
            SecurityGroup securityGroup, List<UserLogin> users);

    /**
     * 
     * @param description
     * @param code
     * @return
     */
    public ServiceResult<SecurityGroup> createSecurityGroup(UserLogin userLogin, String description, String code);

    /**
     * 
     * @return
     */
    public ServiceResult<List<SecurityGroup>> findAllSecurityGroups();

    /**
     * This service returns all security groups for the given user.
     * 
     * NOTE: This is a private service, since this service only accepts one user
     * login you should not get security groups if the user being presented the
     * data is not the same user the data is for.
     * 
     * @param userLogin
     * @return
     */
    public ServiceResult<Set<SecurityGroup>> findAllSecurityGroupsForUserLogin(UserLogin userLogin);

    /**
     * 
     * @param userLogin
     * @param securityGroup
     * @param users
     * @return
     */
    public ServiceResult<List<UserLoginSecurityGroup>> removeUsersFromSecurityGroup(UserLogin userLogin,
            SecurityGroup securityGroup, List<UserLogin> users);

    /**
     * 
     * @param userLogin
     * @param securityGroup
     * @param permissions
     * @return
     */
    public ServiceResult<List<PermissionSecurityGroup>> saveSecurityGroup(UserLogin userLogin,
            SecurityGroup securityGroup, List<Permission> permissions);
}
