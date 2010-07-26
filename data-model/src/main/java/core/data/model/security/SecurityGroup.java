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

import java.util.List;

import core.data.model.DataObject;
import core.data.model.Keyable;
import core.service.InformationBean;

@InformationBean(beanName="securityGroupModel")
public interface SecurityGroup extends DataObject, Keyable
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
     * Getter for permissions
     * 
     * @return
     */
    public List<PermissionSecurityGroup> getPermissionSecurityGroups();

    /**
     * Getter for security group id
     * 
     * @return
     */
    public Integer getSecurityGroupId();
    
    /**
     * Getter for userLoginSecurityGroups
     * 
     * @return
     */
    public List<UserLoginSecurityGroup> getUserLoginSecurityGroups();

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
     * Setter for permissions
     * 
     * @param permissions
     */
    public void setPermissionSecurityGroups(List<PermissionSecurityGroup> permissions);
    
    /**
     * Setter for security group id
     * 
     * @param securityGroupId
     */
    public void setSecurityGroupId(Integer securityGroupId);

    /**
     * Setter for userLoginSecurityGroups
     * 
     * @param userLoginSecurityGroups
     */
    public void setUserLoginSecurityGroups(List<UserLoginSecurityGroup> userLoginSecurityGroups);
}
