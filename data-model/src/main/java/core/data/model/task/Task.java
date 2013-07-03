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
package core.data.model.task;

import java.util.Date;
import java.util.List;

import core.data.model.DataObject;
import core.service.annotation.InformationBean;
import core.service.annotation.Service;

@InformationBean(beanName="taskModel")
public interface Task extends DataObject 
{

    /**
     * Getter for createdDate
     *
     * @return the createdDate
     */
    public abstract Date getCreatedDate();

    /**
     * Getter for description
     *
     * @return the description
     */
    public abstract String getDescription();

    /**
     * Getter for goal
     *
     * @return the goal
     */
    public abstract String getGoal();

    /**
     * Getter for subject
     *
     * @return the subject
     */
    public abstract String getSubject();

    /**
     * Getter for taskId
     *
     * @return the taskId
     */
    public abstract Integer getTaskId();

    public List<TaskRole> getTaskRoles();

    /**
     * Getter for taskStatus
     *
     * @return the taskStatus
     */
    public abstract List<TaskStatus> getTaskStatus();

    /**
     * Getter for taskType
     *
     * @return the taskType
     */
    public abstract TaskType getTaskType();

    /**
     * Setter for createdDate
     *
     * @param createdDate the createdDate to set
     */
    public abstract void setCreatedDate(Date createdDate);

    /**
     * Setter for description
     *
     * @param description the description to set
     */
    public abstract void setDescription(String description);

    /**
     * Setter for goal
     *
     * @param goal the goal to set
     */
    public abstract void setGoal(String goal);

    /**
     * Setter for subject
     *
     * @param subject the subject to set
     */
    public abstract void setSubject(String subject);

    /**
     * Setter for taskId
     *
     * @param taskId the taskId to set
     */
    public abstract void setTaskId(Integer taskId);

    public void setTaskRoles(List<TaskRole> taskRoles);

    /**
     * Setter for taskStatus
     *
     * @param taskStatus the taskStatus to set
     */
    public abstract void setTaskStatus(List<TaskStatus> taskStatus);

    /**
     * Setter for taskType
     *
     * @param taskType the taskType to set
     */
    public abstract void setTaskType(TaskType taskType);

}