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

import core.data.model.DataObject;
import core.data.model.Expirable;
import core.data.model.security.UserLogin;
import core.data.model.status.Status;

public interface TaskStatus extends DataObject, Expirable
{


    /**
     * Getter for status
     *
     * @return the status
     */
    public abstract Status getStatus();

    /**
     * Getter for task
     *
     * @return the task
     */
    public abstract Task getTask();

    /**
     * Getter for taskStatusId
     *
     * @return the taskStatusId
     */
    public abstract Integer getTaskStatusId();

   
    /**
     * Getter for user
     *
     * @return the user
     */
    public abstract UserLogin getUser();

  
    /**
     * Setter for status
     *
     * @param status the status to set
     */
    public abstract void setStatus(Status status);

    /**
     * Setter for task
     *
     * @param task the task to set
     */
    public abstract void setTask(Task task);

    /**
     * Setter for taskStatusId
     *
     * @param taskStatusId the taskStatusId to set
     */
    public abstract void setTaskStatusId(Integer taskStatusId);


    /**
     * Setter for user
     *
     * @param user the user to set
     */
    public abstract void setUser(UserLogin user);

}