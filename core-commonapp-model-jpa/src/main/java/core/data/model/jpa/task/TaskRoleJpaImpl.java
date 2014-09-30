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
package core.data.model.jpa.task;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import core.data.model.jpa.party.PartyJpaImpl;
import core.data.model.jpa.party.RoleTypeJpaImpl;
import core.data.model.party.Party;
import core.data.model.party.RoleType;
import core.data.model.task.Task;
import core.data.model.task.TaskRole;
import core.data.model.util.DataUtil;

@Entity
@Table (name="task_role")
public class TaskRoleJpaImpl implements TaskRole
{
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="task_role_id", nullable=false)
    private Integer taskRoleId;
    
    @ManyToOne (cascade = CascadeType.MERGE, targetEntity=TaskJpaImpl.class)
    @JoinColumn (name="task_id")
    private Task task;
    
    @ManyToOne (targetEntity=PartyJpaImpl.class)
    @JoinColumn (name="party_id")
    private Party party;
    
    @ManyToOne (targetEntity=RoleTypeJpaImpl.class)
    @JoinColumn (name="role_type_id")
    private RoleType roleType;

    @Column (name="from_date")
    private Date fromDate;

    @Column (name="thru_date")
    private Date thruDate;

    /**
     * Getter for fromDate
     *
     * @return the fromDate
     */
    public Date getFromDate()
    {
        return fromDate;
    }

    
    public Integer getId()
    {
        return getTaskRoleId();
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskRole#getParty()
     */
    public Party getParty()
    {
        return party;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskRole#getRoleType()
     */
    public RoleType getRoleType()
    {
        return roleType;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskRole#getTask()
     */
    public Task getTask()
    {
        return task;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskRole#getTaskRoleId()
     */
    public Integer getTaskRoleId()
    {
        return taskRoleId;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskRole#getThruDate()
     */
    public Date getThruDate()
    {
        return thruDate;
    }

    
    public boolean isEquivalent(Object object)
    {
        TaskRole role = (TaskRole) object;
        return DataUtil.equals(getTaskRoleId(), role.getTaskRoleId())
                && DataUtil.isEquivalent(getTask(), role.getTask())
                && DataUtil.isEquivalent(getParty(), role.getParty())
                && DataUtil.isEquivalent(getRoleType(), role.getRoleType())
                && DataUtil.equals(getFromDate(), role.getFromDate())
                && DataUtil.equals(getThruDate(), role.getThruDate());
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskRole#setFromDate(java.sql.Date)
     */
    public void setFromDate(Date fromDate)
    {
        this.fromDate = fromDate;
    }

    
    public void setId(Integer id)
    {
        setTaskRoleId(id);
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskRole#setParty(core.data.model.party.Party)
     */
    public void setParty(Party party)
    {
        this.party = party;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskRole#setRoleType(core.data.model.party.RoleType)
     */
    public void setRoleType(RoleType roleType)
    {
        this.roleType = roleType;
    }
    
    /* (non-Javadoc)
     * @see core.data.model.task.TaskRole#setTask(core.data.model.task.Task)
     */
    public void setTask(Task task)
    {
        this.task = task;
    }
    
    /* (non-Javadoc)
     * @see core.data.model.task.TaskRole#setTaskRoleId(java.lang.Integer)
     */
    public void setTaskRoleId(Integer taskRoleId)
    {
        this.taskRoleId = taskRoleId;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskRole#setThruDate(java.sql.Date)
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
        return "TaskRole("
            + "taskRoleId="
            + getTaskRoleId()
            + ",task="
            + DataUtil.getId(getTask())
            + ",party="
            + DataUtil.getId(getParty())
            + ",roleType="
            + getRoleType()
            + ",fromDate="
            + getFromDate()
            + ",thruDate="
            + getThruDate()
            + ")";
    }

}
