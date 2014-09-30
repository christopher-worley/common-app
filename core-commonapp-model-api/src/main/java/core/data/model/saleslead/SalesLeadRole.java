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
import core.data.model.party.Party;
import core.data.model.party.RoleType;

public interface SalesLeadRole extends DataObject, Expirable
{

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
     * Getter for salesLead
     *
     * @return the salesLead
     */
    public abstract SalesLead getSalesLead();

    /**
     * Getter for salesLeadRoleId
     *
     * @return the salesLeadRoleId
     */
    public abstract Integer getSalesLeadRoleId();

    /**
     * Setter for party
     *
     * @param party the party to set
     */
    public abstract void setParty(Party party);

    /**
     * Setter for roletype
     *
     * @param roletype the roleType to set
     */
    public abstract void setRoleType(RoleType roleType);

    /**
     * Setter for salesLead
     *
     * @param salesLead the salesLead to set
     */
    public abstract void setSalesLead(SalesLead salesLead);

    /**
     * Setter for salesLeadRoleId
     *
     * @param salesLeadRoleId the salesLeadRoleId to set
     */
    public abstract void setSalesLeadRoleId(Integer proposalRoleId);

}