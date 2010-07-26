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
import core.data.model.contact.ContactMech;
import core.data.model.contact.ContactMechPurpose;

public interface AgreementContactMech extends DataObject 
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
    public abstract Integer getAgreementContactMechId();

    /**
     * Getter for contactMech
     *
     * @return the contactMech
     */
    public abstract ContactMech getContactMech();

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
    public abstract void setAgreementContactMechId(Integer agreementContactMechId);

    /**
     * Setter for contactMech
     *
     * @param contactMech the contactMech to set
     */
    public abstract void setContactMech(ContactMech contactMech);

    /**
     * Setter for contactMechPurpose
     *
     * @param contactMechPurpose the contactMechPurpose to set
     */
    public abstract void setContactMechPurpose(ContactMechPurpose contactMechPurpose);

    /**
     * Setter for fromDate
     *
     * @param fromDate the fromDate to set
     */
    public abstract void setFromDate(Date fromDate);

    /**
     * Setter for thruDate
     *
     * @param thruDate the thruDate to set
     */
    public abstract void setThruDate(Date thruDate);

}