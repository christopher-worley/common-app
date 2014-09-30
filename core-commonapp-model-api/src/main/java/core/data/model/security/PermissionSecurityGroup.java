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

public interface PermissionSecurityGroup extends DataObject, Expirable
{

    /**
     * Getter for security group
     *
     * @return the security group
     */
    public abstract SecurityGroup getSecurityGroup();

    /**
     * Getter for permission
     *
     * @return the permission
     */
    public abstract Permission getPermission();

    /**
     * Getter for permissionGroupId
     *
     * @return the permissionGroupId
     */
    public abstract Integer getPermissionSecurityGroupId();

    /**
     * Setter for security group
     *
     * @param group the security group to set
     */
    public abstract void setSecurityGroup(SecurityGroup group);

    /**
     * Setter for permission
     *
     * @param permission the permission to set
     */
    public abstract void setPermission(Permission permission);

    /**
     * Setter for permissionSecurityGroupId
     *
     * @param permissionSecurityGroupId the permissionSecurityGroupId to set
     */
    public abstract void setPermissionSecurityGroupId(Integer permissionGroupId);

}