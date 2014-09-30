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
import java.util.List;

import core.data.model.DataObject;
import core.data.model.Expirable;
import core.data.model.party.Party;

public interface PartyContactMech extends DataObject, Expirable
{

    /**
     * Getter for contactMech
     * 
     * @return the contactMech
     */
    public abstract ContactMech getContactMech();

    /**
     * Getter for fromDate
     * 
     * @return the fromDate
     */
    public abstract Date getFromDate();

    /**
     * Getter for party
     * 
     * @return the party
     */
    public abstract Party getParty();

    /**
     * Getter for partyContactMechId
     * 
     * @return the partyContactMechId
     */
    public abstract Integer getPartyContactMechId();

    /**
     * Getter for partyContactMechPurposes
     *
     * @return the partyContactMechPurposes
     */
    public abstract List<PartyContactMechPurpose> getPartyContactMechPurposes();

    /**
     * Getter for thruDate
     * 
     * @return the thruDate
     */
    public abstract Date getThruDate();

    /**
     * Setter for contactMech
     * 
     * @param contactMech
     *            the contactMech to set
     */
    public abstract void setContactMech(ContactMech contactMech);

    /**
     * Setter for fromDate
     * 
     * @param fromDate
     *            the fromDate to set
     */
    public abstract void setFromDate(Date fromDate);

    /**
     * Setter for party
     * 
     * @param party
     *            the party to set
     */
    public abstract void setParty(Party party);

    /**
     * Setter for partyContactMechId
     * 
     * @param partyContactMechId
     *            the partyContactMechId to set
     */
    public abstract void setPartyContactMechId(Integer partyContactMechId);

    /**
     * Setter for partyContactMechPurposes
     *
     * @param partyContactMechPurposes the partyContactMechPurposes to set
     */
    public abstract void setPartyContactMechPurposes(List<PartyContactMechPurpose> partyContactMechPurposes);

    /**
     * Setter for thruDate
     * 
     * @param thruDate
     *            the thruDate to set
     */
    public abstract void setThruDate(Date thruDate);

}