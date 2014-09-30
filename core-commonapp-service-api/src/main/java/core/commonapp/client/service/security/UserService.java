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

import java.util.Set;

import core.data.cache.security.PermissionKey;
import core.data.model.party.Person;
import core.data.model.security.UserLogin;
import core.service.annotation.InformationBean;
import core.service.annotation.Service;
import core.service.annotation.Security;
import core.service.result.ServiceResult;

@InformationBean(beanName="userService")
@Service
public interface UserService
{

    /**
     * Create and persist <code>UserLogin</code> object
     * 
     * @param person
     * @param username
     * @param password
     * @return
     */
// TODO: Fix to pass in user login calling service
//    @Security(permissionKey=PermissionCache.KEY_CREATE_USER_LOGIN)
    public ServiceResult<UserLogin> createUserLogin(Person person, String username, String password);

    /**
     * Create and persist <code>UserLogin</code> object
     * 
     * @param userLogin
     * @return
     */
// TODO: Fix to pass in user login calling service
//    @Security(permissionKey=PermissionCache.KEY_CREATE_USER_LOGIN)
    public ServiceResult<UserLogin> createUserLogin(UserLogin userLogin);
    
    /**
     * Find all user login objects
     * 
     * @return
     */
    public ServiceResult<Set<UserLogin>> findAll();
    
    /**
     * Find all user logins with username like the given username string
     * 
     * @param userLogin
     * @param username
     */
    @Security(permissionKey=PermissionKey.KEY_MODIFY_USER_LOGIN)
    public ServiceResult<Set<UserLogin>> findAllLikeUsername(UserLogin userLogin, String username);

    /**
     * Find user login by id
     * 
     * @param id
     * @return
     */
    public ServiceResult<UserLogin> findById(Integer id);

    /**
     * find <code>UserLogin</code> object form database
     *
     * @param username
     * @param password
     * @return
     */
    public ServiceResult<UserLogin> findByUsernameAndPassword(String username, String password);
}
