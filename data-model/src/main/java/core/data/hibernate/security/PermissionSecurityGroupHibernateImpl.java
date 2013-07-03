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
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import core.data.model.DataObject;
import core.data.model.Expirable;
import core.data.model.security.Permission;
import core.data.model.security.PermissionSecurityGroup;
import core.data.model.security.SecurityGroup;

@Entity
@Table (name="permission_security_group")
public class PermissionSecurityGroupHibernateImpl implements DataObject, Expirable, Serializable, PermissionSecurityGroup
{
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="permission_security_group_id")
    private Integer permissionSecurityGroupId;
    
    @Column (name="from_date")
    private Date fromDate;
    
    @Column (name="thru_date")
    private Date thruDate;
    
    @ManyToOne (targetEntity=PermissionHibernateImpl.class, cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
    @JoinColumn (name="permission_id")
    private Permission permission;
    
    @ManyToOne (targetEntity=SecurityGroupHibernateImpl.class, cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
    @JoinColumn (name="security_group_id")
    private SecurityGroup securityGroup;

    /**
     * Getter for fromDate
     *
     * @return the fromDate
     */
    public Date getFromDate()
    {
        return fromDate;
    }

    /* (non-Javadoc)
     * @see core.data.hibernate.security.PermissionGroup#getGroup()
     */
    public SecurityGroup getSecurityGroup()
    {
        return securityGroup;
    }

    public Integer getId()
    {
        return getPermissionSecurityGroupId();
    }

    /* (non-Javadoc)
     * @see core.data.hibernate.security.PermissionGroup#getPermission()
     */
    public Permission getPermission()
    {
        return permission;
    }

    /* (non-Javadoc)
     * @see core.data.hibernate.security.PermissionGroup#getPermissionGroupId()
     */
    public Integer getPermissionSecurityGroupId()
    {
        return permissionSecurityGroupId;
    }

    /**
     * Getter for thruDate
     *
     * @return the thruDate
     */
    public Date getThruDate()
    {
        return thruDate;
    }

    public boolean isEquivalent(Object object)
    {
        if (object instanceof PermissionSecurityGroup) 
        {
            PermissionSecurityGroup right = (PermissionSecurityGroup) object;
            return getFromDate().equals(right.getFromDate())
                && getSecurityGroup().isEquivalent(right.getSecurityGroup())
                && getPermission().isEquivalent(right.getPermission())
                && getThruDate().equals(right.getThruDate());
        }
        return false;
    }

    /**
     * Setter for fromDate
     *
     * @param fromDate the fromDate to set
     */
    public void setFromDate(Date fromDate)
    {
        this.fromDate = fromDate;
    }

    /* (non-Javadoc)
     * @see core.data.hibernate.security.PermissionGroup#setGroup(core.data.model.security.Group)
     */
    public void setSecurityGroup(SecurityGroup group)
    {
        this.securityGroup = group;
    }

    public void setId(Integer id)
    {
        setPermissionSecurityGroupId(id);
    }

    /* (non-Javadoc)
     * @see core.data.hibernate.security.PermissionGroup#setPermission(core.data.model.security.Permission)
     */
    public void setPermission(Permission permission)
    {
        this.permission = permission;
    }

    /* (non-Javadoc)
     * @see core.data.hibernate.security.PermissionGroup#setPermissionGroupId(java.lang.Integer)
     */
    public void setPermissionSecurityGroupId(Integer permissionGroupId)
    {
        this.permissionSecurityGroupId = permissionGroupId;
    }

    /**
     * Setter for thruDate
     *
     * @param thruDate the thruDate to set
     */
    public void setThruDate(Date thruDate)
    {
        this.thruDate = thruDate;
    }

}
