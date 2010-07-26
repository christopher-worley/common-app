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
package core.data.hibernate.party;

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

import net.sf.gilead.pojo.java5.LightEntity;
import core.data.model.party.OrganizationUnit;
import core.data.model.party.RoleType;

@Entity
@Table(name="organization_unit")
public class OrganizationUnitHibernateImpl extends LightEntity  implements OrganizationUnit
{
    /**
     * 
     */
    private static final long serialVersionUID = -6945341627380991506L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "organization_unit_id", nullable = false)
    public Integer organizationUnitId;
    
    @ManyToOne (targetEntity=RoleTypeHibernateImpl.class, cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
    @JoinColumn(name = "role_type_id", nullable=false)
    public RoleType roleType;
    
    @ManyToOne (targetEntity=OrganizationUnitHibernateImpl.class)
    @JoinColumn(name="parent_organization_unit_id", nullable=true)
    public OrganizationUnit parentOrganizationUnit;
    
    @Column(name = "from_date")
    public Date fromDate;

    @Column(name = "thru_date")
    public Date thruDate;

    public Date getFromDate()
    {
        return fromDate;
    }
    
    public Integer getId()
    {
        return getOrganizationUnitId();
    }

    public Integer getOrganizationUnitId()
    {
        return organizationUnitId;
    }

    public OrganizationUnit getParentOrganizationUnit()
    {
        return parentOrganizationUnit;
    }

    public RoleType getRoleType()
    {
        return roleType;
    }

    public Date getThruDate()
    {
        return thruDate;
    }

    public boolean isEquivalent(Object object)
    {// TODO: implement isEquivalent
        return false;
    }

    public void setFromDate(Date fromDate)
    {
        this.fromDate = fromDate;
    }

    public void setId(Integer id)
    {
        setOrganizationUnitId(id);
    }

    public void setOrganizationUnitId(Integer organizationUnitId)
    {
        this.organizationUnitId = organizationUnitId;
    }

    public void setParentOrganizationUnit(OrganizationUnit parentOrganizationUnit)
    {
        this.parentOrganizationUnit = parentOrganizationUnit;
    }

    public void setRoleType(RoleType roleType)
    {
        this.roleType = roleType;
    }

    public void setThruDate(Date thruDate)
    {
        this.thruDate = thruDate;
    }
    
}
