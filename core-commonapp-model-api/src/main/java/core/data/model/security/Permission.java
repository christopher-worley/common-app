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
import core.data.model.Keyable;

/**
 * Authorizations associated with UserLogin or some other entity to provide
 * permission for task and any other usage needed
 * 
 * @author cworley
 * 
 */
public interface Permission extends DataObject, Keyable
{

    /**
     * Getter for code
     * 
     * @return
     */
    public String getCode();

    /**
     * Getter for description
     * 
     * @return
     */
    public String getDescription();

    /**
     * Getter for key
     * 
     * @return
     */
    public String getKey();

    /**
     * Getter for permission id
     * 
     * @return
     */
    public Integer getPermissionId();

    /**
     * Setter for code
     * 
     * @param code
     */
    public void setCode(String code);

    /**
     * Setter for description
     * 
     * @param description
     */
    public void setDescription(String description);

    /**
     * Setter for key
     * 
     * @param key
     */
    public void setKey(Object key);

    /**
     * Setter for permission
     * 
     * @param permissionId
     */
    public void setPermissionId(Integer permissionId);
}
