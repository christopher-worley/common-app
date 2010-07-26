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
package core.commonapp.client.service.party;

import java.sql.Timestamp;

import core.data.model.party.Party;
import core.data.model.party.PartyGroup;
import core.data.model.party.PartyRelationship;
import core.data.model.party.PartyRole;
import core.data.model.party.Person;
import core.data.model.party.RoleType;
import core.service.InformationBean;
import core.service.Service;
import core.service.result.ServiceResult;

@InformationBean(beanName="createPartyService")
@Service
public interface CreatePartyService
{

    /**
     * create, persist and return <code>PartyGroup</code> object
     * 
     * service result payload
     *          0 - new <code>PartyGroup</code> object
     * 
     * @param groupName
     * @return
     */
    public ServiceResult<PartyGroup> createPartyGroup(String groupName);
    
    /**
     * create, persist and return <code>PartyRelationship</code> object
     * 
     * service result payload
     *          0 - new <code>PartyRelationship</code> object
     * 
     * @param partyFrom
     * @param roleTypeFrom
     * @param partyTo
     * @param roleTypeTo
     * @return
     */
    public ServiceResult<PartyRelationship> createPartyRelationship(Party partyFrom, RoleType roleTypeFrom, Party partyTo, RoleType roleTypeTo, Timestamp fromDate);
    
    /**
     * create, persist and return <code>PartyRole</code> object
     * 
     * service result payload
     *          0 - new <code>PartyRole</code> object
     * 
     * @param party
     * @param roleType
     * @param fromDate
     * @return
     */
    public ServiceResult<PartyRole> createPartyRole(Party party, RoleType roleType, Timestamp fromDate);
    
    /**
     * persist and return <code>Person</code> object
     * 
     * service result payload
     *          0 - new <code>Person</code> object
     *  
     * @param person
     * @param roleTypes
     * @return
     */
    public ServiceResult<Person> createPerson(Person person, RoleType[] roleTypes);
    
    /**
     * create, persist and return <code>Person</code> object
     * 
     * service result payload
     *          0 - new <code>Person</code> object
     * 
     * @param firstName
     * @param lastName
     * @param roleTypes
     * @return
     */
    public ServiceResult<Person> createPerson(String firstName, String lastName, RoleType[] roleTypes);
    
}
