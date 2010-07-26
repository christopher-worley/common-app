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

import java.util.List;
import java.util.Set;

import core.data.model.contact.EmailAddress;
import core.data.model.contact.PhoneNumber;
import core.data.model.contact.PostalAddress;
import core.data.model.party.Person;
import core.data.model.security.UserLogin;
import core.service.InformationBean;
import core.service.Service;
import core.service.result.ServiceResult;

@InformationBean (beanName="contactPersonService")
@Service
public interface ContactPersonService
{
    
    /**
     * Create contact person
     * 
     * service result payload
     *          new <code>Person</code> object
     *          
     * @param person
     * @param postalAddress
     * @param emailAddress
     * @param phoneNumbers
     * @return
     */
    public ServiceResult<Person> createContactPerson(Person person, PostalAddress postalAddress,
            EmailAddress emailAddress, List<PhoneNumber> phoneNumbers, UserLogin userLogin);

    
    /**
     * Find all contact people who are associated as contacts for
     * the party of the given partyId.
     * 
     * @param partyId
     * @return
     */
    public ServiceResult<List<Person>> findAllContactPeople(Integer partyId);
    
    /**
     * Find contact person by id
     *
     * service result payload
     *          <code>Person</code> instance of person found
     *          
     * @param partyId
     * @return
     */
    public ServiceResult<Person> findContactPerson(Integer partyId);
    
    /**
     * 
     * Find contact person 
     * 
     * service result payload
     *          <code>Set</code> containing <code>Party</code> instances matching
     *          the search criteria
     * 
     * @param partyName
     * @param phoneNumber
     * @param postalAddress
     * @param emailAddress
     * @return
     */
    public ServiceResult<Set<Person>> findContactPerson(String partyName, PhoneNumber phoneNumber, PostalAddress postalAddress,
            String emailAddress, UserLogin userLogin);
    
}
