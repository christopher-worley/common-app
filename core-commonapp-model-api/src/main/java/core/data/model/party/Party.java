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

import java.util.List;

import core.data.model.DataObject;
import core.data.model.contact.PartyContactMech;

public interface Party extends DataObject 
{

    /**
     * Getter for partyContactMechs
     *
     * @return the partyContactMechs
     */
    public abstract List<PartyContactMech> getPartyContactMechs();

    /**
     * Getter for partyFromRelationships
     *
     * @return the partyFromRelationships
     */
    public List<PartyRelationship> getPartyFromRelationships();

    /**
     * Getter for partyId
     * 
     * @return the partyId
     */
    public abstract Integer getPartyId();

    /**
     * Getter for partyRoles
     *
     * @return the partyRoles
     */
    public abstract List<PartyRole> getPartyRoles();

    /**
     * Getter for partyToRelationships
     * 
     * @return
     */
    public List<PartyRelationship> getPartyToRelationships();

    /**
     * Getter for partyType
     * 
     * @return the partyType
     */
    public abstract PartyType getPartyType();

    /**
     * Setter for partyContactMechs
     *
     * @param partyContactMechs the partyContactMechs to set
     */
    public abstract void setPartyContactMechs(List<PartyContactMech> partyContactMechs);

    /**
     * Setter for partyFromRelationships
     *
     * @param partyFromRelationships the partyFromRelationships to set
     */
    public void setPartyFromRelationships(List<PartyRelationship> partyFromRelationships);

    
    /**
     * Setter for partyId
     * 
     * @param partyId
     *                the partyId to set
     */
    public abstract void setPartyId(Integer partyId);

    /**
     * Setter for partyRoles
     *
     * @param partyRoles the partyRoles to set
     */
    public abstract void setPartyRoles(List<PartyRole> partyRoles);

    /**
     * Setter for partyToRelationships
     *
     * @param partyToRelationships the partyToRelationships to set
     */
    public void setPartyToRelationships(List<PartyRelationship> partyToRelationships);

    /**
     * Setter for partyType
     * 
     * @param partyType
     *                the partyType to set
     */
    public abstract void setPartyType(PartyType partyType);
    
}