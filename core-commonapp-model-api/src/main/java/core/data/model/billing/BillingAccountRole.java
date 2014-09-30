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
package core.data.model.billing;

import core.data.model.DataObject;
import core.data.model.Expirable;
import core.data.model.party.Party;
import core.data.model.party.RoleType;

public interface BillingAccountRole  extends DataObject, Expirable
{

    /**
     * Getter for billingAccount
     *
     * @return the billingAccount
     */
    public abstract BillingAccount getBillingAccount();

    /**
     * Getter for billingAccountRoleId
     *
     * @return the billingAccountRoleId
     */
    public abstract Integer getBillingAccountRoleId();

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
     * Setter for billingAccount
     *
     * @param billingAccount the billingAccount to set
     */
    public abstract void setBillingAccount(BillingAccount billingAccount);

    /**
     * Setter for billingAccountRoleId
     *
     * @param billingAccountRoleId the billingAccountRoleId to set
     */
    public abstract void setBillingAccountRoleId(Integer billingAccountRoleId);

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

}