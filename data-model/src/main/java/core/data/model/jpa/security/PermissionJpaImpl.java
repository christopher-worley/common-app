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
package core.data.model.jpa.security;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import core.data.model.DataObject;
import core.data.model.security.Permission;
import core.data.model.util.DataUtil;

@Entity
@Table(name = "permission")
public class PermissionJpaImpl implements Permission, DataObject, Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permission_id", nullable = false)
    private Integer permissionId;

    @Column(name = "code")
    private String code;

    @Column(name = "key")
    private String key;

    @Column(name = "description")
    private String description;

    public boolean equals(Object obj)
    {
        Permission right = (Permission) obj;
        return super.equals(obj)
            && DataUtil.equals(getPermissionId(), right.getPermissionId())
            && DataUtil.equals(getCode(), right.getCode())
            && DataUtil.equals(getKey(), right.getKey())
            && DataUtil.equals(getDescription(), right.getDescription());
    }

    /**
     * Getter for code
     * 
     * @return the code
     */
    public String getCode()
    {
        return code;
    }

    /**
     * Getter for description
     * 
     * @return the description
     */
    public String getDescription()
    {
        return description;
    }

    public Integer getId()
    {
        return getPermissionId();
    }

    /**
     * Getter for key
     * 
     * @return the key
     */
    public String getKey()
    {
        return key;
    }

    /**
     * Getter for permissionId
     * 
     * @return the permissionId
     */
    public Integer getPermissionId()
    {
        return permissionId;
    }

    public boolean isEquivalent(Object object)
    {
        if (object instanceof Permission)
        {
            Permission right = (Permission) object;
            return getDescription().equals(right.getDescription()) && getCode().equals(right.getCode())
                    && getKey().equals(right.getKey());
        }
        return false;
    }

    /**
     * Setter for code
     * 
     * @param code
     *            the code to set
     */
    public void setCode(String code)
    {
        this.code = code;
    }

    /**
     * Setter for description
     * 
     * @param description
     *            the description to set
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setId(Integer id)
    {
        setPermissionId(id);
    }

    /**
     * Setter for key
     * 
     * @param key
     *            the key to set
     */
    public void setKey(Object key)
    {
        this.key = (String) key;
    }

    /**
     * Setter for permissionId
     * 
     * @param permissionId
     *            the permissionId to set
     */
    public void setPermissionId(Integer permissionId)
    {
        this.permissionId = permissionId;
    }
}
