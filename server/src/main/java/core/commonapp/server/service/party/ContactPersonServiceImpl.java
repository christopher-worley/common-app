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
package core.commonapp.server.service.party;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import core.commonapp.client.dao.party.PartyDao;
import core.commonapp.client.dao.party.PersonDao;
import core.commonapp.client.service.contact.CreateContactMechService;
import core.commonapp.client.service.contact.CreatePartyContactMechService;
import core.commonapp.client.service.party.ContactPersonService;
import core.commonapp.client.service.party.CreatePartyService;
import core.commonapp.server.annotation.ServiceImpl;
import core.data.cache.KeyedCache;
import core.data.cache.KeyedCacheStore;
import core.data.cache.contact.ContactMechPurposeKey;
import core.data.cache.contact.ContactMechTypeKey;
import core.data.cache.party.RoleTypeKey;
import core.data.helper.party.PartyHelper;
import core.data.model.contact.ContactMechPurpose;
import core.data.model.contact.ContactMechType;
import core.data.model.contact.EmailAddress;
import core.data.model.contact.PhoneNumber;
import core.data.model.contact.PostalAddress;
import core.data.model.jpa.contact.EmailAddressJpaImpl;
import core.data.model.jpa.contact.PostalAddressJpaImpl;
import core.data.model.party.Person;
import core.data.model.party.RoleType;
import core.data.model.security.UserLogin;
import core.service.result.ServiceResult;
import core.tooling.logging.LogFactory;
import core.tooling.logging.Logger;

@ServiceImpl(clientInterface = ContactPersonService.class)
@Service
public class ContactPersonServiceImpl implements ContactPersonService
{
    /** logger for this class */
    private Logger log = LogFactory.getLogger(ContactPersonServiceImpl.class);

    /** create party service */
    @Autowired
    private CreatePartyService createPartyService;
    /** create contact mech service */
    @Autowired
    private CreateContactMechService createContactMechService;
    /** create party contact mech service */
    @Autowired
    private CreatePartyContactMechService createPartyContactMechService;
    /** data Cache factory */
    @Autowired
    private KeyedCache keyedCache;
    /** party dao */
    @Autowired
    private PartyDao partyDao;
    /** person dao */
    @Autowired
    private PersonDao personDao;

    public ContactPersonServiceImpl()
    {
        super();
    }

    /**
     * build where clause for first and last name
     * 
     * @param partyName
     * @return
     */
    private String buildWhereFirstAndLastName(List values, String partyName)
    {
        String hql = "";

        // partyName = partyName.toLowerCase();
        // determine first and last name
        String firstName = null;
        String lastName;
        int comma = partyName.indexOf(",");
        if (comma > 0)
        {
            lastName = partyName.substring(0, comma).trim();
            firstName = partyName.substring(comma + 1).trim();
        }
        else
        {
            lastName = partyName.trim();
        }

        // create hql for first and last names
        hql += "(";
        // last name
        hql += " person.lastName = " + ":value" + values.size();
        values.add(lastName);
        if (firstName != null)
        {
            hql += " and person.firstName = " + ":value" + values.size();
            values.add(firstName);
        }
        hql += ")";
        return hql;
    }

    /**
     * Create contact person and create relationship back to the user party. Add
     * email address and postal address as primary contacts for the person. Add
     * all phone numbers with there given purpose.
     * 
     */
    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public ServiceResult<Person> createContactPerson(final Person person, final PostalAddress postalAddress,
            final EmailAddress emailAddress, final List<PhoneNumber> phoneNumbers, final UserLogin userLogin)
    {
        // ???: will this work?  i removed the hibernate template after spring upgrade.
        UserLogin securityUserLogin = (UserLogin) userLogin;

        PartyHelper<Person> helper = new PartyHelper<Person>(keyedCache, person);
        helper.addRelationshipFrom(securityUserLogin.getParty(), getRoleTypeCache().getObject(RoleTypeKey.KEY_CONTACT_PERSON),
                getRoleTypeCache().getObject(RoleTypeKey.KEY_SALES_PERSON));

        // postal address
        // TODO: Hibernate specific code move it to a helper
        if (postalAddress != null && !((PostalAddressJpaImpl) postalAddress).isEmpty())
        {
            postalAddress.setContactMechType(getContactMechTypeCache().getObject(ContactMechTypeKey.KEY_POSTAL_ADDRESS));
            helper.addPostalAddress(postalAddress, getContactMechPurposeCache().getObject(ContactMechPurposeKey.KEY_PRIMARY));
        }

        // create email address
        if (emailAddress != null && !((EmailAddressJpaImpl) emailAddress).isEmpty())
        {
            helper.addEmailAddress(emailAddress, getContactMechPurposeCache().getObject(ContactMechPurposeKey.KEY_PRIMARY));
            emailAddress.setContactMechType(getContactMechTypeCache().getObject(ContactMechTypeKey.KEY_EMAIL_ADDRESS));
        }

        // create phone numbers
        if (phoneNumbers != null)
        {
            for (PhoneNumber phoneNumber : phoneNumbers)
            {
                phoneNumber.setContactMechType(getContactMechTypeCache().getObject(ContactMechTypeKey.KEY_PHONE_NUMBER));
                helper.addPhoneNumber(phoneNumber, getContactMechPurposeCache().getObject(ContactMechPurposeKey.KEY_PRIMARY));
            }
        }

        // create new Person
        ServiceResult result = createPartyService.createPerson(helper.getParty(), new RoleType[]
        { getRoleTypeCache().getObject(RoleTypeKey.KEY_CONTACT_PERSON) });
        if (result.isError())
        {
            return ServiceResult.error("Failed to create person with contact role: " + result.getMessage());
        }
        Person newPerson = (Person) result.getPayload();

        // find party and return success
        return ServiceResult.success("", newPerson);
    }

    @Override
    public ServiceResult<List<Person>> findAllContactPeople(Integer partyId)
    {
        log.debug("CotnactPersonServiceImpl.findAllContactPeople({0})", partyId);
        
        List<Person> people = personDao.findAllContactPeople(partyId);
        
        return ServiceResult.success("Successfully found all contact people for party.", people);
    }

    @Override
    public ServiceResult<Person> findContactPerson(Integer partyId)
    {
        log.debug("CotnactPersonServiceImpl.findContactPerson({0})", partyId);

        Person person = personDao.findById(partyId, true, true, false, false);
        return ServiceResult.success("Successfully found person.", person);
    }

    /**
     * find contact person with given parameters to search from
     * 
     */
    @Override
    public ServiceResult<Set<Person>> findContactPerson(String partyName, PhoneNumber phoneNumber,
            PostalAddress postalAddress, String emailAddress, UserLogin userLogin)
    {
        log.debug("CotnactPersonServiceImpl.findContactPerson({0}, {1}, {2}, {3}, {4})", partyName, phoneNumber,
                postalAddress, emailAddress, userLogin);
        ServiceResult result = ServiceResult.success("", personDao.findContactPerson(partyName, phoneNumber,
                postalAddress, emailAddress, userLogin));
        return result;
    }

    /**
     * return ContactMechPurpose cache store from cache
     * 
     * @return keyed cache store for ContactMechPurpose objects
     */
    private KeyedCacheStore<ContactMechPurpose> getContactMechPurposeCache()
    {
        return keyedCache.getCacheStore(ContactMechPurpose.class);
    }

    /**
     * return ContactMechType cache store from cache
     * 
     * @return keyed cache store for ContactMechType objects
     */
    private KeyedCacheStore<ContactMechType> getContactMechTypeCache()
    {
        return keyedCache.getCacheStore(ContactMechType.class);
    }

    /**
     * return RoleType cache store from cache
     * 
     * @return keyed cache store for RoleType objects
     */
    private KeyedCacheStore<RoleType> getRoleTypeCache()
    {
        return keyedCache.getCacheStore(RoleType.class);
    }
    
}
