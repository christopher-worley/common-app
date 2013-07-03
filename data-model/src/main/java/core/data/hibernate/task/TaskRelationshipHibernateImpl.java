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
package core.data.hibernate.task;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import core.data.hibernate.security.UserLoginHibernateImpl;
import core.data.model.security.UserLogin;
import core.data.model.task.Task;
import core.data.model.task.TaskRelationship;
import core.data.model.task.TaskRelationshipType;
import core.data.model.util.DataUtil;

@Entity
@Table (name="task_relationship")
public class TaskRelationshipHibernateImpl implements TaskRelationship
{

    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="task_relationship_id")
    private Integer taskRelationshipId;
    
    @ManyToOne (targetEntity=TaskHibernateImpl.class)
    @JoinColumn (name="task_from_id")
    private Task taskFrom;
    
    @ManyToOne (targetEntity=TaskHibernateImpl.class)
    @JoinColumn (name="task_to_id")
    private Task taskTo;

    @ManyToOne (targetEntity=TaskRelationshipTypeHibernateImpl.class)
    @JoinColumn (name="task_relationship_type_id")
    private TaskRelationshipType taskRelationshipType;

    @Column (name="from_date")
    private Date fromDate;

    @Column (name="thru_date")
    private Date thruDate;
    
    /** who caused the relationship */
    @ManyToOne (targetEntity=UserLoginHibernateImpl.class)
    @JoinColumn (name="user_id")
    private UserLogin user;

    /** description why the relation ship exist */
    @Column (name="description")
    private String description;

    /* (non-Javadoc)
     * @see core.data.model.task.TaskRelationship#getDescription()
     */
    public String getDescription()
    {
        return description;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskRelationship#getFromDate()
     */
    public Date getFromDate()
    {
        return fromDate;
    }

    
    public Integer getId()
    {
        return getTaskRelationshipId();
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskRelationship#getTaskFrom()
     */
    public Task getTaskFrom()
    {
        return taskFrom;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskRelationship#getTaskRelationshipId()
     */
    public Integer getTaskRelationshipId()
    {
        return taskRelationshipId;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskRelationship#getTaskRelationshipType()
     */
    public TaskRelationshipType getTaskRelationshipType()
    {
        return taskRelationshipType;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskRelationship#getTaskTo()
     */
    public Task getTaskTo()
    {
        return taskTo;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskRelationship#getThruDate()
     */
    public Date getThruDate()
    {
        return thruDate;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskRelationship#getUser()
     */
    public UserLogin getUser()
    {
        return user;
    }

    
    public boolean isEquivalent(Object object)
    {
        TaskRelationship relationship = (TaskRelationship) object;
        return DataUtil.equals(getTaskRelationshipId(), relationship.getTaskRelationshipId())
            && DataUtil.isEquivalent(getTaskFrom(), relationship.getTaskFrom())
            && DataUtil.isEquivalent(getTaskTo(), relationship.getTaskTo())
            && DataUtil.isEquivalent(getTaskRelationshipType(), relationship.getTaskRelationshipType())
            && DataUtil.equals(getFromDate(), relationship.getFromDate())
            && DataUtil.equals(getThruDate(), relationship.getThruDate())
            && DataUtil.isEquivalent(getUser(), relationship.getUser())
            && DataUtil.equals(getDescription(), relationship.getDescription());
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskRelationship#setDescription(java.lang.String)
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskRelationship#setFromDate(java.sql.Date)
     */
    public void setFromDate(Date fromDate)
    {
        this.fromDate = fromDate;
    }

    
    public void setId(Integer id)
    {
        setTaskRelationshipId(id);
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskRelationship#setTaskFrom(core.data.model.task.Task)
     */
    public void setTaskFrom(Task taskFrom)
    {
        this.taskFrom = taskFrom;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskRelationship#setTaskRelationshipId(java.lang.Integer)
     */
    public void setTaskRelationshipId(Integer taskRelationshipId)
    {
        this.taskRelationshipId = taskRelationshipId;
    }
    
    /* (non-Javadoc)
     * @see core.data.model.task.TaskRelationship#setTaskRelationshipType(core.data.model.task.TaskRelationshipType)
     */
    public void setTaskRelationshipType(TaskRelationshipType taskRelationshipType)
    {
        this.taskRelationshipType = taskRelationshipType;
    }
    
    /* (non-Javadoc)
     * @see core.data.model.task.TaskRelationship#setTaskTo(core.data.model.task.Task)
     */
    public void setTaskTo(Task taskTo)
    {
        this.taskTo = taskTo;
    }
    
    /* (non-Javadoc)
     * @see core.data.model.task.TaskRelationship#setThruDate(java.sql.Date)
     */
    public void setThruDate(Date thruDate)
    {
        this.thruDate = thruDate;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskRelationship#setUser(core.data.model.security.UserLogin)
     */
    public void setUser(UserLogin user)
    {
        this.user = user;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    public String toString()
    {
        return "TaskRelationship("
            + "taskRelationshipId="
            + getTaskRelationshipId()
            + ",taskFrom="
            + DataUtil.getId(getTaskFrom())
            + ",taskThru="
            + DataUtil.getId(getTaskTo())
            + ",taskRealtionshipType="
            + getTaskRelationshipType()
            + ",description="
            + getDescription()
            + ",user="
            + getUser()
            + ",fromDate="
            + getFromDate()
            + ",thruDate="
            + getThruDate()
            + ")";
    }
}
