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

import java.util.List;

import core.data.model.security.SecurityGroup;
import core.data.model.security.UserLogin;
import core.data.model.security.UserLoginSecurityGroup;

public interface UserLoginSecurityGroupDAO
{

    /**
     * Find all objects that have the matching <code>UserLogin</code> and
     * <code>SecurityGroup</code>
     * 
     * @param userLogin
     * @param securityGroup
     * @param includeOld true if you want to get expired relations
     * @return
     */
    public List<UserLoginSecurityGroup> findByUserLoginAndSecurityGroup(UserLogin userLogin, SecurityGroup securityGroup, boolean includeOld);
    
    /**
     * Find all for given security group
     * 
     * @param securityGroup
     * @param includeOld true if you want to get expired relations
     * @return
     */
    public List<UserLoginSecurityGroup> findBySecurityGroup(SecurityGroup securityGroup, boolean includeOld);
}
