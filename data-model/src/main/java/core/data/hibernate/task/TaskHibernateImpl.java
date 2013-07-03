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
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import core.data.model.task.Task;
import core.data.model.task.TaskRole;
import core.data.model.task.TaskStatus;
import core.data.model.task.TaskType;
import core.data.model.util.DataUtil;

@Entity
@Table (name="task")
public class TaskHibernateImpl implements Task
{
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="task_id", nullable=false)
    private Integer taskId;
    
    @ManyToOne (targetEntity=TaskTypeHibernateImpl.class)
    @JoinColumn (name="task_type_id")
    private TaskType taskType;

    @Column (name="subject")
    private String subject;

    @Column (name="goal")
    private String goal;

    @Column (name="description")
    private String description;
    
    @Column (name="createdDate")
    private Date createdDate;
    
    @OneToMany (cascade={CascadeType.ALL}, fetch=FetchType.LAZY, targetEntity=TaskStatusHibernateImpl.class)
    private List<TaskStatus> taskStatus;
    
    @OneToMany (cascade={CascadeType.ALL}, fetch=FetchType.LAZY, targetEntity=TaskRoleHibernateImpl.class)
    public List<TaskRole> taskRoles;

    /* (non-Javadoc)
     * @see core.data.model.task.Task#getCreatedDate()
     */
    public Date getCreatedDate()
    {
        return createdDate;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.Task#getDescription()
     */
    public String getDescription()
    {
        return description;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.Task#getGoal()
     */
    public String getGoal()
    {
        return goal;
    }

    public Integer getId()
    {
        return getTaskId();
    }

    /* (non-Javadoc)
     * @see core.data.model.task.Task#getSubject()
     */
    public String getSubject()
    {
        return subject;
    }

    
    /* (non-Javadoc)
     * @see core.data.model.task.Task#getTaskId()
     */
    public Integer getTaskId()
    {
        return taskId;
    }

    public List<TaskRole> getTaskRoles()
    {
        return taskRoles;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.Task#getTaskStatus()
     */
    public List<TaskStatus> getTaskStatus()
    {
        return taskStatus;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.Task#getTaskType()
     */
    public TaskType getTaskType()
    {
        return taskType;
    }

    public boolean isEquivalent(Object object)
    {
        Task task = (Task) object;
        return DataUtil.equals(getTaskId(), task.getTaskId())
            && DataUtil.isEquivalent(getTaskType(), task.getTaskType())
            && DataUtil.equals(getSubject(), task.getSubject())
            && DataUtil.equals(getGoal(), task.getGoal())
            && DataUtil.equals(getDescription(), task.getDescription())
            && DataUtil.equals(getCreatedDate(), task.getCreatedDate())
            && DataUtil.isEquivalent(getTaskStatus(), task.getTaskStatus());
    }

    
    /* (non-Javadoc)
     * @see core.data.model.task.Task#setCreatedDate(java.sql.Date)
     */
    public void setCreatedDate(Date createdDate)
    {
        this.createdDate = createdDate;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.Task#setDescription(java.lang.String)
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.Task#setGoal(java.lang.String)
     */
    public void setGoal(String goal)
    {
        this.goal = goal;
    }

    public void setId(Integer id)
    {
        setTaskId(id);
    }

    
    /* (non-Javadoc)
     * @see core.data.model.task.Task#setSubject(java.lang.String)
     */
    public void setSubject(String subject)
    {
        this.subject = subject;
    }
    
    /* (non-Javadoc)
     * @see core.data.model.task.Task#setTaskId(java.lang.Integer)
     */
    public void setTaskId(Integer taskId)
    {
        this.taskId = taskId;
    }
    
    public void setTaskRoles(List<TaskRole> taskRoles)
    {
        this.taskRoles = taskRoles;
    }
    
    /* (non-Javadoc)
     * @see core.data.model.task.Task#setTaskStatus(java.util.List)
     */
    public void setTaskStatus(List<TaskStatus> taskStatus)
    {
        this.taskStatus = taskStatus;
    }
    
    

    /* (non-Javadoc)
     * @see core.data.model.task.Task#setTaskType(core.data.model.task.TaskType)
     */
    public void setTaskType(TaskType taskType)
    {
        this.taskType = taskType;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    public String toString()
    {
        return "Task("
            + "taskId="
            + getTaskId()
            + ",taskType="
            + getTaskType()
            + ",subject="
            + getSubject()
            + ",goal="
            + getGoal()
            + ",description="
            + getDescription()
            + ",createdDate="
            + getCreatedDate()
            + ",taskStatus="
            + getTaskStatus()
            + ")";
    }

}
