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
package core.data.model.saleslead;

import core.data.model.DataObject;
import core.data.model.Expirable;
import core.data.model.contact.ContactMech;
import core.data.model.contact.ContactMechPurpose;

public interface SalesLeadContactMech extends DataObject, Expirable
{

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
     * Getter for salesLead
     *
     * @return the salesLead
     */
    public abstract SalesLead getSalesLead();

    /**
     * Getter for proposalContactMechId
     *
     * @return the proposalContactMechId
     */
    public abstract Integer getSalesLeadContactMechId();

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
     * Setter for salesLead
     *
     * @param salesLead the salesLead to set
     */
    public abstract void setSalesLead(SalesLead salesLead);

    /**
     * Setter for proposalContactMechId
     *
     * @param proposalContactMechId the proposalContactMechId to set
     */
    public abstract void setSalesLeadContactMechId(Integer proposalContactMechId);


}