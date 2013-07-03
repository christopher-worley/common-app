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
package core.data.hibernate.status;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import core.data.hibernate.party.RoleTypeHibernateImpl;
import core.data.model.party.RoleType;
import core.data.model.status.StatusTransition;
import core.data.model.status.StatusTransitionRole;
import core.data.model.util.DataUtil;

@Entity
@Table (name="status_transition_role")
public class StatusTransitionRoleHibernateImpl implements StatusTransitionRole
{
 
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="status_transition_role_id")
    private Integer statusTransitionRoleId;
    
    @ManyToOne (targetEntity=StatusTransitionHibernateImpl.class) 
    @JoinColumn (name="status_flow_id")
    private StatusTransition statusTransition;

    @ManyToOne (targetEntity=RoleTypeHibernateImpl.class)
    @JoinColumn (name="role_type_id")
    private RoleType roleType;

    @Column (name="from_date")
    private Date fromDate;

    @Column (name="thru_date")
    private Date thruDate;

    /* (non-Javadoc)
     * @see core.data.model.status.StatusTransitionRole#getFromDate()
     */
    public Date getFromDate()
    {
        return fromDate;
    }

    
    public Integer getId()
    {
        return getStatusTransitionRoleId();
    }

    /* (non-Javadoc)
     * @see core.data.model.status.StatusTransitionRole#getRoleType()
     */
    public RoleType getRoleType()
    {
        return roleType;
    }

    /* (non-Javadoc)
     * @see core.data.model.status.StatusTransitionRole#getStatusTransition()
     */
    public StatusTransition getStatusTransition()
    {
        return statusTransition;
    }

    /* (non-Javadoc)
     * @see core.data.model.status.StatusTransitionRole#getStatusTransitionRoleId()
     */
    public Integer getStatusTransitionRoleId()
    {
        return statusTransitionRoleId;
    }

    /* (non-Javadoc)
     * @see core.data.model.status.StatusTransitionRole#getThruDate()
     */
    public Date getThruDate()
    {
        return thruDate;
    }

    
    public boolean isEquivalent(Object object)
    {
        StatusTransitionRole role = (StatusTransitionRole) object;
        return DataUtil.equals(getStatusTransitionRoleId(), role.getStatusTransitionRoleId())
            && DataUtil.isEquivalent(getStatusTransition(), role.getStatusTransition())
            && DataUtil.isEquivalent(getRoleType(), role.getRoleType())
            && DataUtil.equals(getFromDate(), role.getFromDate())
            && DataUtil.equals(getThruDate(), role.getThruDate());
    }

    /* (non-Javadoc)
     * @see core.data.model.status.StatusTransitionRole#setFromDate(java.sql.Date)
     */
    public void setFromDate(Date fromDate)
    {
        this.fromDate = fromDate;
    }

    
    public void setId(Integer id)
    {
        setStatusTransitionRoleId(id);
    }
    
    /* (non-Javadoc)
     * @see core.data.model.status.StatusTransitionRole#setRoleType(core.data.model.party.RoleType)
     */
    public void setRoleType(RoleType roleType)
    {
        this.roleType = roleType;
    }
    
    /* (non-Javadoc)
     * @see core.data.model.status.StatusTransitionRole#setStatusTransition(core.data.model.status.StatusTransition)
     */
    public void setStatusTransition(StatusTransition statusFlow)
    {
        this.statusTransition = statusFlow;
    }
    
    /* (non-Javadoc)
     * @see core.data.model.status.StatusTransitionRole#setStatusTransitionRoleId(java.lang.Integer)
     */
    public void setStatusTransitionRoleId(Integer statusTransitionRoleId)
    {
        this.statusTransitionRoleId = statusTransitionRoleId;
    }

    /* (non-Javadoc)
     * @see core.data.model.status.StatusTransitionRole#setThruDate(java.sql.Date)
     */
    public void setThruDate(Date thruDate)
    {
        this.thruDate = thruDate;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    public String toString()
    {
        return "StatusTransitionRole("
            + "statusTransitionRoleId="
            + getStatusTransitionRoleId()
            + ",statusTransition="
            + getStatusTransition()
            + ",roleType="
            + getRoleType()
            + ",fromDate="
            + getFromDate()
            + ",thruDate="
            + getThruDate()
            + ")";
    }

}
