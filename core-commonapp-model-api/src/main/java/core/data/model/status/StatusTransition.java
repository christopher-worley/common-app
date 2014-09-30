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
package core.data.model.status;

import java.util.List;

import core.data.model.DataObject;
import core.data.model.Keyable;

public interface StatusTransition extends DataObject, Keyable
{

    /**
     * Getter for description
     *
     * @return the description
     */
    public abstract String getDescription();

    /**
     * Getter for statusFrom
     *
     * @return the statusFrom
     */
    public abstract Status getStatusFrom();

    /**
     * Getter for statusTo
     *
     * @return the statusTo
     */
    public abstract Status getStatusTo();

    /**
     * Getter for statusFlowId
     *
     * @return the statusFlowId
     */
    public abstract Integer getStatusTransitionId();

    /**
     * Getter for statusTransitionRoles
     *
     * @return the statusTransitionRoles
     */
    public abstract List<StatusTransitionRole> getStatusTransitionRoles();

    /**
     * Setter for description
     *
     * @param description the description to set
     */
    public abstract void setDescription(String description);

    /**
     * Setter for statusFrom
     *
     * @param statusFrom the statusFrom to set
     */
    public abstract void setStatusFrom(Status statusFrom);

    /**
     * Setter for statusTo
     *
     * @param statusTo the statusTo to set
     */
    public abstract void setStatusTo(Status statusTo);

    /**
     * Setter for statusFlowId
     *
     * @param statusFlowId the statusFlowId to set
     */
    public abstract void setStatusTransitionId(Integer statusFlowId);

    /**
     * Setter for statusTransitionRoles
     *
     * @param statusTransitionRoles the statusTransitionRoles to set
     */
    public abstract void setStatusTransitionRoles(List<StatusTransitionRole> statusTransitionRoles);

}