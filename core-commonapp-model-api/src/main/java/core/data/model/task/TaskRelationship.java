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

public interface TaskRelationship extends DataObject, Expirable
{

    /**
     * Getter for description
     *
     * @return the description
     */
    public abstract String getDescription();

    /**
     * Getter for taskFrom
     *
     * @return the taskFrom
     */
    public abstract Task getTaskFrom();

    /**
     * Getter for taskRelationshipId
     *
     * @return the taskRelationshipId
     */
    public abstract Integer getTaskRelationshipId();

    /**
     * Getter for taskRelationshipType
     *
     * @return the taskRelationshipType
     */
    public abstract TaskRelationshipType getTaskRelationshipType();

    /**
     * Getter for taskTo
     *
     * @return the taskTo
     */
    public abstract Task getTaskTo();

    /**
     * Getter for UserLogin
     *
     * @return the UserLogin
     */
    public abstract UserLogin getUser();

    /**
     * Setter for description
     *
     * @param description the description to set
     */
    public abstract void setDescription(String description);

    /**
     * Setter for taskFrom
     *
     * @param taskFrom the taskFrom to set
     */
    public abstract void setTaskFrom(Task taskFrom);

    /**
     * Setter for taskRelationshipId
     *
     * @param taskRelationshipId the taskRelationshipId to set
     */
    public abstract void setTaskRelationshipId(Integer taskRelationshipId);

    /**
     * Setter for taskRelationshipType
     *
     * @param taskRelationshipType the taskRelationshipType to set
     */
    public abstract void setTaskRelationshipType(TaskRelationshipType taskRelationshipType);

    /**
     * Setter for taskTo
     *
     * @param taskTo the taskTo to set
     */
    public abstract void setTaskTo(Task taskTo);

    /**
     * Setter for UserLogin
     *
     * @param UserLogin the UserLogin to set
     */
    public abstract void setUser(UserLogin user);

}