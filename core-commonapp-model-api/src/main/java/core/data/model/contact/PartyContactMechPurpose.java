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
package core.data.model.contact;


import java.util.Date;

import core.data.model.DataObject;
import core.data.model.Expirable;

public interface PartyContactMechPurpose extends DataObject, Expirable
{

    /**
     * Getter for contactMechPurpose
     * 
     * @return the contactMechPurpose
     */
    public abstract ContactMechPurpose getContactMechPurpose();

    /**
     * Getter for fromDate
     * 
     * @return the fromDate
     */
    public abstract Date getFromDate();

    /**
     * Getter for partyContactMech
     * 
     * @return the partyContactMech
     */
    public abstract PartyContactMech getPartyContactMech();

    /**
     * Getter for partyContactMechPurposeId
     * 
     * @return the partyContactMechPurposeId
     */
    public abstract Integer getPartyContactMechPurposeId();

    /**
     * Getter for thruDate
     * 
     * @return the thruDate
     */
    public abstract Date getThruDate();

    /**
     * Setter for contactMechPurpose
     * 
     * @param contactMechPurpose
     *            the contactMechPurpose to set
     */
    public abstract void setContactMechPurpose(ContactMechPurpose contactMechPurpose);

    /**
     * Setter for fromDate
     * 
     * @param fromDate
     *            the fromDate to set
     */
    public abstract void setFromDate(Date fromDate);

    /**
     * Setter for partyContactMech
     * 
     * @param partyContactMech
     *            the partyContactMech to set
     */
    public abstract void setPartyContactMech(PartyContactMech partyContactMech);

    /**
     * Setter for partyContactMechPurposeId
     * 
     * @param partyContactMechPurposeId
     *            the partyContactMechPurposeId to set
     */
    public abstract void setPartyContactMechPurposeId(Integer partyContactMechPurposeId);

    /**
     * Setter for thruDate
     * 
     * @param thruDate
     *            the thruDate to set
     */
    public abstract void setThruDate(Date thruDate);

}