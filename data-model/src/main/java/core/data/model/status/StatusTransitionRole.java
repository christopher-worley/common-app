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


import core.data.model.DataObject;
import core.data.model.Expirable;
import core.data.model.party.RoleType;

public interface StatusTransitionRole extends DataObject, Expirable
{


    /**
     * Getter for roleType
     *
     * @return the roleType
     */
    public abstract RoleType getRoleType();

    /**
     * Getter for statusTransition
     *
     * @return the statusTransition
     */
    public abstract StatusTransition getStatusTransition();

    /**
     * Getter for statusTransitionRoleId
     *
     * @return the statusTransitionRoleId
     */
    public abstract Integer getStatusTransitionRoleId();

    /**
     * Setter for roleType
     *
     * @param roleType the roleType to set
     */
    public abstract void setRoleType(RoleType roleType);

    /**
     * Setter for statusTransition
     *
     * @param statusTransition the statusTransition to set
     */
    public abstract void setStatusTransition(StatusTransition statusFlow);

    /**
     * Setter for statusTransitionRoleId
     *
     * @param statusTransitionRoleId the statusTransitionRoleId to set
     */
    public abstract void setStatusTransitionRoleId(Integer statusTransitionRoleId);

}