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
package core.data.model.agreement;

import java.util.Date;

import core.data.model.DataObject;
import core.data.model.party.Party;
import core.data.model.party.RoleType;

public interface AgreementRole extends DataObject 
{

    /**
     * Getter for agreement
     *
     * @return the agreement
     */
    public abstract Agreement getAgreement();

    /**
     * Getter for agreementContactMechId
     *
     * @return the agreementContactMechId
     */
    public abstract Integer getAgreementRoleId();

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
     * Getter for roleType
     *
     * @return the roleType
     */
    public abstract RoleType getRoleType();

    /**
     * Getter for thruDate
     *
     * @return the thruDate
     */
    public abstract Date getThruDate();

    /**
     * Setter for agreement
     *
     * @param agreement the agreement to set
     */
    public abstract void setAgreement(Agreement agreement);

    /**
     * Setter for agreementContactMechId
     *
     * @param agreementContactMechId the agreementContactMechId to set
     */
    public abstract void setAgreementRoleId(Integer agreementContactMechId);

    /**
     * Setter for fromDate
     *
     * @param fromDate the fromDate to set
     */
    public abstract void setFromDate(Date fromDate);

    /**
     * Setter for party
     *
     * @param party the party to set
     */
    public abstract void setParty(Party party);

    /**
     * Setter for roleType
     *
     * @param roleType the roleType to set
     */
    public abstract void setRoleType(RoleType roleType);

    /**
     * Setter for thruDate
     *
     * @param thruDate the thruDate to set
     */
    public abstract void setThruDate(Date thruDate);

}