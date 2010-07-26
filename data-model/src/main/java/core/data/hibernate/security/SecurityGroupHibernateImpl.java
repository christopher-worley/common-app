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
package core.data.hibernate.security;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import net.sf.gilead.pojo.java5.LightEntity;
import core.data.model.DataObject;
import core.data.model.security.PermissionSecurityGroup;
import core.data.model.security.SecurityGroup;
import core.data.model.security.UserLoginSecurityGroup;

@Entity
@Table(name = "security_group")
public class SecurityGroupHibernateImpl extends LightEntity implements DataObject, Serializable, SecurityGroup
{

    /**
     * 
     */
    private static final long serialVersionUID = 3517183926580059842L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "security_group_id", nullable = false)
    private Integer securityGroupId;

    @Column(name = "code")
    private String code;

    @Column(name = "key")
    private String key;

    @Column(name = "description")
    private String description;
    
    @OneToMany (mappedBy="securityGroup", cascade={CascadeType.ALL}, targetEntity=PermissionSecurityGroupHibernateImpl.class)
    @JoinColumn(name="security_group_id")
    private List<PermissionSecurityGroup> permissionSecurityGroups;
    
    @OneToMany (mappedBy="securityGroup", cascade={CascadeType.ALL}, targetEntity=UserLoginSecurityGroupHibernateImpl.class)
    @JoinColumn(name="security_group_id")
    private List<UserLoginSecurityGroup> userLoginSecurityGroups;

    public String getCode()
    {
        return code;
    }

    public String getDescription()
    {
        return description;
    }

    public Integer getId()
    {
        return getSecurityGroupId();
    }

    public String getKey()
    {
        return key;
    }

    public List<PermissionSecurityGroup> getPermissionSecurityGroups()
    {
        return permissionSecurityGroups;
    }

    public Integer getSecurityGroupId()
    {
        return securityGroupId;
    }

    public List<UserLoginSecurityGroup> getUserLoginSecurityGroups()
    {
        return userLoginSecurityGroups;
    }

    public boolean isEquivalent(Object object)
    {
        if (object instanceof SecurityGroup) 
        {
            SecurityGroup right = (SecurityGroup) object;
            return getCode().equals(right.getCode())
                && getKey().equals(right.getKey())
                && getDescription().equals(right.getDescription());
        }
        return false;
    }


    public void setCode(String code)
    {
        this.code = code;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setId(Integer id)
    {
        setSecurityGroupId(id);
    }

    public void setKey(Object key)
    {
        this.key = (String) key;
    }

    public void setPermissionSecurityGroups(List<PermissionSecurityGroup> permissions)
    {
        this.permissionSecurityGroups = permissions;
    }

    public void setSecurityGroupId(Integer groupId)
    {
        this.securityGroupId = groupId;
    }

    public void setUserLoginSecurityGroups(List<UserLoginSecurityGroup> userLoginSecurityGroups)
    {
        this.userLoginSecurityGroups = userLoginSecurityGroups;
    }

}
