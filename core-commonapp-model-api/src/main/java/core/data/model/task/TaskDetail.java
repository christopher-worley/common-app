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

import core.data.model.DataObject;
import core.data.model.Expirable;
import core.data.model.security.UserLogin;

public interface TaskDetail extends DataObject, Expirable
{

    /**
     * Getter for createdDate
     *
     * @return the createdDate
     */
    public abstract Date getCreatedDate();

    /**
     * Getter for dueDate
     *
     * @return the dueDate
     */
    public abstract Date getDueDate();

    /**
     * Getter for estimatedCompletionDate
     *
     * @return the estimatedCompletionDate
     */
    public abstract Date getEstimatedCompletionDate();

    /**
     * Getter for scheduledEndDate
     *
     * @return the scheduledEndDate
     */
    public abstract Date getScheduledEndDate();

    /**
     * Getter for scheduledStartDate
     *
     * @return the scheduledStartDate
     */
    public abstract Date getScheduledStartDate();

    /**
     * Getter for task
     *
     * @return the task
     */
    public abstract Task getTask();

    /**
     * Getter for taskDetailId
     *
     * @return the taskDetailId
     */
    public abstract Integer getTaskDetailId();

    /**
     * Getter for user
     *
     * @return the user
     */
    public abstract UserLogin getUser();

    /**
     * Setter for createdDate
     *
     * @param createdDate the createdDate to set
     */
    public abstract void setCreatedDate(Date createdDate);

    /**
     * Setter for dueDate
     *
     * @param dueDate the dueDate to set
     */
    public abstract void setDueDate(Date dueDate);

    /**
     * Setter for estimatedCompletionDate
     *
     * @param estimatedCompletionDate the estimatedCompletionDate to set
     */
    public abstract void setEstimatedCompletionDate(Date estimatedCompletionDate);

    /**
     * Setter for scheduledEndDate
     *
     * @param scheduledEndDate the scheduledEndDate to set
     */
    public abstract void setScheduledEndDate(Date scheduledEndDate);

    /**
     * Setter for scheduledStartDate
     *
     * @param scheduledStartDate the scheduledStartDate to set
     */
    public abstract void setScheduledStartDate(Date scheduledStartDate);

    /**
     * Setter for task
     *
     * @param task the task to set
     */
    public abstract void setTask(Task task);

    /**
     * Setter for taskDetailId
     *
     * @param taskDetailId the taskDetailId to set
     */
    public abstract void setTaskDetailId(Integer taskDetailId);

    /**
     * Setter for user
     *
     * @param user the user to set
     */
    public abstract void setUser(UserLogin user);

}