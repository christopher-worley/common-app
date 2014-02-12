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
package core.data.model.security;

import core.data.model.DataObject;
import core.data.model.Expirable;

public interface UserLoginSecurityGroup extends DataObject, Expirable
{

    /**
     * Getter for group
     *
     * @return the group
     */
    public abstract SecurityGroup getSecurityGroup();

    /**
     * Getter for userLogin
     *
     * @return the userLogin
     */
    public abstract UserLogin getUserLogin();

    /**
     * Getter for userLoginSecurityGroupId
     *
     * @return the userLoginSecurityGroupId
     */
    public abstract Integer getUserLoginSecurityGroupId();

    /**
     * Setter for group
     *
     * @param group the group to set
     */
    public abstract void setSecurityGroup(SecurityGroup group);

    /**
     * Setter for userLogin
     *
     * @param userLogin the userLogin to set
     */
    public abstract void setUserLogin(UserLogin userLogin);

    /**
     * Setter for userLoginSecurityGroupId
     *
     * @param userLoginSecurityGroupId the userLoginSecurityGroupId to set
     */
    public abstract void setUserLoginSecurityGroupId(Integer userLoginSecurityGroupId);

}