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
package core.commonapp.client.dao.security;

import java.util.Set;

import core.data.model.security.UserLogin;
import core.service.annotation.InformationBean;
import core.service.annotation.Service;

@InformationBean(beanName="userLoginDAO")
public interface UserLoginDAO
{
    
    /**
     * determine of a <code>UserLogin</code> exist with the given username
     * 
     * @param username
     * @return
     */
    public boolean existByUsername(String username);
    
    /**
     * Find all <code>UserLogin</code> objects that are like the gien username
     * 
     * @param username
     * @return
     */
    public Set<UserLogin> findAllLikeUsername(String username);
    
    /**
     * Find user by id
     * 
     * @param id
     * @return
     */
    public UserLogin findById(Integer id);

    /**
     * Find <code>UserLogin</code> object by username and password fields
     * 
     * @param username
     * @param password
     * @return
     */
    public UserLogin findByUsernameAndPassword(String username, String password);

    /**
     * save user
     * 
     * @param user
     * @return
     */
    public UserLogin save(UserLogin user);

}
