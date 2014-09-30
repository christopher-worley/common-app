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
package core.data.model.party;


import java.util.Date;

import core.data.model.DataObject;
import core.data.model.Expirable;

public interface PartyRelationship extends DataObject, Expirable
{

    /**
     * Getter for fromDate
     * 
     * @return the fromDate
     */
    public abstract Date getFromDate();

    /**
     * Getter for partyFrom
     * 
     * @return the partyFrom
     */
    public abstract Party getPartyFrom();

    /**
     * Getter for partyRelationshipId
     * 
     * @return the partyRelationshipId
     */
    public abstract Integer getPartyRelationshipId();

    /**
     * Getter for partyTo
     * 
     * @return the partyTo
     */
    public abstract Party getPartyTo();

    /**
     * Getter for roleTypeFrom
     * 
     * @return the roleTypeFrom
     */
    public abstract RoleType getRoleTypeFrom();

    /**
     * Getter for roleTypeTo
     * 
     * @return the roleTypeTo
     */
    public abstract RoleType getRoleTypeTo();

    /**
     * Getter for thruDate
     * 
     * @return the thruDate
     */
    public abstract Date getThruDate();

    /**
     * Setter for fromDate
     * 
     * @param fromDate
     *                the fromDate to set
     */
    public abstract void setFromDate(Date fromDate);

    /**
     * Setter for partyFrom
     * 
     * @param partyFrom
     *                the partyFrom to set
     */
    public abstract void setPartyFrom(Party partyFrom);

    /**
     * Setter for partyRelationshipId
     * 
     * @param partyRelationshipId
     *                the partyRelationshipId to set
     */
    public abstract void setPartyRelationshipId(Integer partyRelationshipId);

    /**
     * Setter for partyTo
     * 
     * @param partyTo
     *                the partyTo to set
     */
    public abstract void setPartyTo(Party partyTo);

    /**
     * Setter for roleTypeFrom
     * 
     * @param roleTypeFrom
     *                the roleTypeFrom to set
     */
    public abstract void setRoleTypeFrom(RoleType roleTypeFrom);

    /**
     * Setter for roleTypeTo
     * 
     * @param roleTypeTo
     *                the roleTypeTo to set
     */
    public abstract void setRoleTypeTo(RoleType roleTypeTo);

    /**
     * Setter for thruDate
     * 
     * @param thruDate
     *                the thruDate to set
     */
    public abstract void setThruDate(Date thruDate);

}