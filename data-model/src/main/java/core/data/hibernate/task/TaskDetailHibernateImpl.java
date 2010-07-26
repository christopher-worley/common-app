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

import net.sf.gilead.pojo.java5.LightEntity;
import core.data.hibernate.security.UserLoginHibernateImpl;
import core.data.model.security.UserLogin;
import core.data.model.task.Task;
import core.data.model.task.TaskDetail;
import core.data.model.util.DataUtil;

@Entity
@Table (name="task_detail")
public class TaskDetailHibernateImpl extends LightEntity implements TaskDetail
{

    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="task_detail_id")
    private Integer taskDetailId;
    
    @ManyToOne (targetEntity=TaskHibernateImpl.class)
    @JoinColumn (name="task_id")
    private Task task;
    
    @Column (name="created_date")
    private Date createdDate;
    
    @Column (name="due_date")
    private Date dueDate;
    
    @Column (name="estimated_completion_date")
    private Date estimatedCompletionDate;
    
    @Column (name="scheduled_start_date")
    private Date scheduledStartDate;
    
    @Column (name="scheduled_end_date")
    private Date scheduledEndDate;
    
    @Column (name="from_date")
    private Date fromDate;
    
    @Column (name="thru_date")
    private Date thruDate;
    
    @ManyToOne (targetEntity=UserLoginHibernateImpl.class)
    @JoinColumn (name="user_id")
    private UserLogin user;

    /* (non-Javadoc)
     * @see core.data.model.task.TaskDetail#getCreatedDate()
     */
    public Date getCreatedDate()
    {
        return createdDate;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskDetail#getDueDate()
     */
    public Date getDueDate()
    {
        return dueDate;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskDetail#getEstimatedCompletionDate()
     */
    public Date getEstimatedCompletionDate()
    {
        return estimatedCompletionDate;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskDetail#getFromDate()
     */
    public Date getFromDate()
    {
        return fromDate;
    }

    
    public Integer getId()
    {
        return getTaskDetailId();
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskDetail#getScheduledEndDate()
     */
    public Date getScheduledEndDate()
    {
        return scheduledEndDate;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskDetail#getScheduledStartDate()
     */
    public Date getScheduledStartDate()
    {
        return scheduledStartDate;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskDetail#getTask()
     */
    public Task getTask()
    {
        return task;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskDetail#getTaskDetailId()
     */
    public Integer getTaskDetailId()
    {
        return taskDetailId;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskDetail#getThruDate()
     */
    public Date getThruDate()
    {
        return thruDate;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskDetail#getUser()
     */
    public UserLogin getUser()
    {
        return user;
    }

    
    public boolean isEquivalent(Object object)
    {
        TaskDetail detail = (TaskDetail) object;
        return DataUtil.equals(getTaskDetailId(), detail.getTaskDetailId())
            && DataUtil.isEquivalent(getTask(), detail.getTask())
            && DataUtil.equals(getCreatedDate(), detail.getCreatedDate())
            && DataUtil.equals(getDueDate(), detail.getDueDate())
            && DataUtil.equals(getEstimatedCompletionDate(), detail.getEstimatedCompletionDate())
            && DataUtil.equals(getScheduledStartDate(), detail.getScheduledStartDate())
            && DataUtil.equals(getScheduledEndDate(), detail.getScheduledEndDate())
            && DataUtil.equals(getFromDate(), detail.getFromDate())
            && DataUtil.equals(getThruDate(), detail.getThruDate())
            && DataUtil.isEquivalent(getUser(), detail.getUser());
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskDetail#setCreatedDate(java.sql.Date)
     */
    public void setCreatedDate(Date createdDate)
    {
        this.createdDate = createdDate;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskDetail#setDueDate(java.sql.Date)
     */
    public void setDueDate(Date dueDate)
    {
        this.dueDate = dueDate;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskDetail#setEstimatedCompletionDate(java.sql.Date)
     */
    public void setEstimatedCompletionDate(Date estimatedCompletionDate)
    {
        this.estimatedCompletionDate = estimatedCompletionDate;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskDetail#setFromDate(java.sql.Date)
     */
    public void setFromDate(Date fromDate)
    {
        this.fromDate = fromDate;
    }

    
    public void setId(Integer id)
    {
        setTaskDetailId(id);
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskDetail#setScheduledEndDate(java.sql.Date)
     */
    public void setScheduledEndDate(Date scheduledEndDate)
    {
        this.scheduledEndDate = scheduledEndDate;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskDetail#setScheduledStartDate(java.sql.Date)
     */
    public void setScheduledStartDate(Date scheduledStartDate)
    {
        this.scheduledStartDate = scheduledStartDate;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskDetail#setTask(core.data.model.task.Task)
     */
    public void setTask(Task task)
    {
        this.task = task;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskDetail#setTaskDetailId(java.lang.Integer)
     */
    public void setTaskDetailId(Integer taskDetailId)
    {
        this.taskDetailId = taskDetailId;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskDetail#setThruDate(java.sql.Date)
     */
    public void setThruDate(Date thruDate)
    {
        this.thruDate = thruDate;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskDetail#setUser(core.data.model.security.UserLogin)
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
        return "TaskDetail("
            + "taskDetailId="
            + getTaskDetailId()
            + ",taskId="
            + DataUtil.getId(getTask())
            + ",createdDate="
            + getCreatedDate()
            + ",estimatedCompletionDate="
            + getEstimatedCompletionDate()
            + ",scheduledStartDate="
            + getScheduledStartDate()
            + ",scheduledEndDate="
            + getScheduledEndDate()
            + ",thruDate="
            + getThruDate()
            + ",fromDate="
            + getFromDate()
            + ")";            
    }
    
}
