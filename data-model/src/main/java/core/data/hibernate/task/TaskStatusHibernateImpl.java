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

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.sf.gilead.pojo.java5.LightEntity;
import core.data.hibernate.security.UserLoginHibernateImpl;
import core.data.hibernate.status.StatusHibernateImpl;
import core.data.model.security.UserLogin;
import core.data.model.status.Status;
import core.data.model.task.Task;
import core.data.model.task.TaskStatus;
import core.data.model.util.DataUtil;

@Entity
@Table (name="task_status")
public class TaskStatusHibernateImpl extends LightEntity implements TaskStatus
{
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="task_status_id")
    private Integer taskStatusId;
    
    @ManyToOne(cascade = CascadeType.MERGE, targetEntity=TaskHibernateImpl.class)
    @JoinColumn (name="task_id", nullable=false)
    private Task task;

    @ManyToOne (targetEntity=StatusHibernateImpl.class)
    @JoinColumn (name="status_id")
    private Status status;
    
    @Column (name="from_date")
    private Date fromDate;
    
    @Column (name="thru_date")
    private Date thruDate;
    
    @ManyToOne (targetEntity=UserLoginHibernateImpl.class)
    @JoinColumn (name="user_id")
    private UserLogin user;
    
    /* (non-Javadoc)
     * @see core.data.model.task.TaskStatus#getFromDate()
     */
    public Date getFromDate()
    {
        return fromDate;
    }

    
    public Integer getId()
    {
        return getTaskStatusId();
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskStatus#getStatus()
     */
    public Status getStatus()
    {
        return status;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskStatus#getTask()
     */
    public Task getTask()
    {
        return task;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskStatus#getTaskStatusId()
     */
    public Integer getTaskStatusId()
    {
        return taskStatusId;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskStatus#getThruDate()
     */
    public Date getThruDate()
    {
        return thruDate;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskStatus#getUser()
     */
    public UserLogin getUser()
    {
        return user;
    }

    
    public boolean isEquivalent(Object object)
    {
        TaskStatus status = (TaskStatus) object;
        return DataUtil.equals(getTaskStatusId(), status.getTaskStatusId())
            && DataUtil.isEquivalent(getTask(), status.getTask())
            && DataUtil.isEquivalent(getStatus(), status.getStatus())
            && DataUtil.equals(getFromDate(), status.getFromDate())
            && DataUtil.equals(getThruDate(), status.getThruDate());
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskStatus#setFromDate(java.sql.Date)
     */
    public void setFromDate(Date fromDate)
    {
        this.fromDate = fromDate;
    }

    
    public void setId(Integer id)
    {
        setTaskStatusId(id);
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskStatus#setStatus(core.data.model.status.Status)
     */
    public void setStatus(Status status)
    {
        this.status = status;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskStatus#setTask(core.data.model.task.Task)
     */
    public void setTask(Task task)
    {
        this.task = task;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskStatus#setTaskStatusId(java.lang.Integer)
     */
    public void setTaskStatusId(Integer taskStatusId)
    {
        this.taskStatusId = taskStatusId;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskStatus#setThruDate(java.sql.Date)
     */
    public void setThruDate(Date thruDate)
    {
        this.thruDate = thruDate;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskStatus#setUser(core.data.model.security.UserLogin)
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
        return "TaskStatus("
            + "taskStatusId="
            + getTaskStatusId()
            + ",taskId="
            + DataUtil.getId(getTask())
            + ",user="
            + getUser()
            + ",status="
            + getStatus()
            + ",fromDate="
            + getFromDate()
            + ",thruDate="
            + getThruDate()
            + ")";
    }

}
