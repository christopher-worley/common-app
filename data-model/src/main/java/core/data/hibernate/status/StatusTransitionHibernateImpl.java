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

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import core.data.model.status.Status;
import core.data.model.status.StatusTransition;
import core.data.model.status.StatusTransitionRole;
import core.data.model.util.DataUtil;

@Entity
@Table (name="status_transition")
public class StatusTransitionHibernateImpl implements StatusTransition
{
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="status_transition_id")
    private Integer statusTransitionId;
    
    @Column (name="description")
    private String description;
    
    @ManyToOne (targetEntity=StatusHibernateImpl.class)
    @JoinColumn (name="status_from_id")
    private Status statusFrom;
    
    @ManyToOne (targetEntity=StatusHibernateImpl.class)
    @JoinColumn (name="status_to_id")
    private Status StatusTo;
    
    @Column (name="key")
    private String key;
    
    @OneToMany (targetEntity=StatusTransitionRoleHibernateImpl.class)
    private List<StatusTransitionRole> statusTransitionRoles;

    /* (non-Javadoc)
     * @see core.data.model.status.StatusTransition#getDescription()
     */
    public String getDescription()
    {
        return description;
    }

    
    public Integer getId()
    {
        return getStatusTransitionId();
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
    
    /* (non-Javadoc)
     * @see core.data.model.status.StatusTransition#getStatusFrom()
     */
    public Status getStatusFrom()
    {
        return statusFrom;
    }

    /* (non-Javadoc)
     * @see core.data.model.status.StatusTransition#getStatusTo()
     */
    public Status getStatusTo()
    {
        return StatusTo;
    }

    /* (non-Javadoc)
     * @see core.data.model.status.StatusTransition#getStatusTransitionId()
     */
    public Integer getStatusTransitionId()
    {
        return statusTransitionId;
    }

    /* (non-Javadoc)
     * @see core.data.model.status.StatusTransition#getStatusTransitionRoles()
     */
    public List<StatusTransitionRole> getStatusTransitionRoles()
    {
        return statusTransitionRoles;
    }

    
    public boolean isEquivalent(Object object)
    {
        StatusTransition transition = (StatusTransition) object;
        return DataUtil.equals(getStatusTransitionId(), transition.getStatusTransitionId())
            && DataUtil.equals(getDescription(), transition.getDescription())
            && DataUtil.isEquivalent(getStatusFrom(), transition.getStatusFrom())
            && DataUtil.isEquivalent(getStatusTo(), transition.getStatusTo())
            && DataUtil.equals(getKey(), transition.getKey())
            && DataUtil.isEquivalent(getStatusTransitionRoles(), transition.getStatusTransitionRoles());
    }

    /* (non-Javadoc)
     * @see core.data.model.status.StatusTransition#setDescription(java.lang.String)
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    
    public void setId(Integer id)
    {
        setStatusTransitionId(id);
    }

    /**
     * Setter for key
     *
     * @param key the key to set
     */
    public void setKey(Object key)
    {
        this.key = (String) key;
    }

    /* (non-Javadoc)
     * @see core.data.model.status.StatusTransition#setStatusFrom(core.data.model.status.Status)
     */
    public void setStatusFrom(Status statusFrom)
    {
        this.statusFrom = statusFrom;
    }

    /* (non-Javadoc)
     * @see core.data.model.status.StatusTransition#setStatusTo(core.data.model.status.Status)
     */
    public void setStatusTo(Status statusTo)
    {
        StatusTo = statusTo;
    }

    /* (non-Javadoc)
     * @see core.data.model.status.StatusTransition#setStatusTransitionId(java.lang.Integer)
     */
    public void setStatusTransitionId(Integer statusFlowId)
    {
        this.statusTransitionId = statusFlowId;
    }

    /* (non-Javadoc)
     * @see core.data.model.status.StatusTransition#setStatusTransitionRoles(java.util.List)
     */
    public void setStatusTransitionRoles(List<StatusTransitionRole> statusTransitionRoles)
    {
        this.statusTransitionRoles = statusTransitionRoles;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    public String toString()
    {
        return "StatusTransition("
            + "statusTransitionId="
            + getStatusTransitionId()
            + ",description="
            + getDescription()
            + ",statusFrom="
            + getStatusFrom()
            + ",statusTo="
            + getStatusTo()
            + ",key="
            + getKey()
            // TODO: removed because the session is some times closed
            // + ",statusTransitionRoles="
            //+ DataUtil.getIds(getStatusTransitionRoles())
            + ")";
    }

}
