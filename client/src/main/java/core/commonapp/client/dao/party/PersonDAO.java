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
package core.commonapp.client.dao.party;

import java.util.List;
import java.util.Set;

import core.data.model.contact.PhoneNumber;
import core.data.model.contact.PostalAddress;
import core.data.model.party.Party;
import core.data.model.party.Person;
import core.data.model.security.UserLogin;

/**
 * @author worleyc
 *
 */
public interface PersonDAO
{
    
    /**
     * 
     * @param partyId
     * @return
     */
    public List<Person> findAllContactPeople(Integer partyId);

    /**
     * @param partyId
     * @return
     */
    public Person findById(Integer partyId);

    /**
     * @param partyId
     * @param loadPartyType
     * @param loadPartyContactMechs
     * @param loadPartyFromRelationships
     * @param loadPartyToRelationships
     * @return
     */
    public Person findById(Integer partyId, boolean loadPartyType, boolean loadPartyContactMechs, boolean loadPartyFromRelationships, boolean loadPartyToRelationships);

    /**
     * Find all contact people who match the given criteria
     * 
     * @param partyName
     * @param phoneNumber
     * @param postalAddress
     * @param emailAddress
     * @param userLogin
     * @return
     */
    public Set<Party> findContactPerson(String partyName, PhoneNumber phoneNumber, PostalAddress postalAddress,
            String emailAddress, UserLogin userLogin);

    /**
     * Save person object to db
     * 
     * @param person
     * @return
     */
    public Person save(Person person);

}
