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
package core.test.commonapp.server.service.party;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import core.commonapp.client.service.party.ContactPersonService;
import core.commonapp.client.service.security.UserService;
import core.commonapp.server.config.ServerConfiguration;
import core.commonapp.server.service.CommonAppServiceInstantiator;
import core.data.cache.KeyedCache;
import core.data.helper.party.PartyHelper;
import core.data.hibernate.contact.PhoneNumberHibernateImpl;
import core.data.model.contact.EmailAddress;
import core.data.model.contact.PhoneNumber;
import core.data.model.contact.PostalAddress;
import core.data.model.party.Person;
import core.data.model.security.UserLogin;
import core.service.result.ServiceResult;
import core.test.commonapp.server.CommonAppServerTest;
import core.test.server.mock.contact.ContactMechMock;
import core.test.server.mock.party.PartyMock;
import core.test.server.mock.security.UserLoginMock;
import core.tooling.logging.LogFactory;
import core.tooling.logging.Logger;
import core.tooling.property.SystemPropertyFileReader;

/**
 * Test services from <code>ContactPersonService</code>
 * 
 * 
 * 
 * @author worleyc
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ServerConfiguration.class)
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
@Transactional
public class TestContactPersonService extends CommonAppServerTest
{
    
    /** logger for this class */
    private Logger log = LogFactory.getLogger(TestContactPersonService.class);

    /** contact person service */
    @Autowired
    private ContactPersonService contactPersonService = null;
    
    /** user security service */
    @Autowired
    private UserService userService = null;
    
    // sales person login
    private UserLogin userLogin;
    
    @Autowired
    private KeyedCache keyedCache;
    
    private UserLoginMock userLoginMock;
    
    private PartyMock partyMock;

    private ContactMechMock contactMechMock;

    @Before
    public void before()
    {
        new SystemPropertyFileReader("commonapp-test-service.properties");

        userLoginMock = new UserLoginMock(getInformationContext());
        partyMock = new PartyMock(getInformationContext());
        contactMechMock = new ContactMechMock(getInformationContext());
        
        // grab a user login
        userLogin = userLoginMock.createUserLogin();
        userLogin.setParty(partyMock.generatePerson());
        ServiceResult result = userService.createUserLogin(userLogin);
        userLogin = (UserLogin) result.getPayload();
    }
   
    /**
     * Create a contact person for testing 
     * 
     * @return
     */
    private Person createContactPerson() {
        Person person = partyMock.generatePerson();
        PostalAddress postalAddress = contactMechMock.generatePostalAddress();
        EmailAddress emailAddress = contactMechMock.generateEmailAddress();
        PhoneNumber workNumber = contactMechMock.generatePhoneNumber();
        PhoneNumber cellNumber = contactMechMock.generatePhoneNumber();
        
        List<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();
        phoneNumbers.add(workNumber);
        phoneNumbers.add(cellNumber);

        ServiceResult<Person> result = contactPersonService.createContactPerson(person, postalAddress, emailAddress,
                phoneNumbers,
                userLogin);
        
        if (result.isError())
        {
            throw new RuntimeException("Create person failed: " + result.getMessage());
        }
        
        return result.getPayload();
	}
    
    /**
     * helper to invoke the find contact person service.  Then loop through the results
     * and find the created person.
     * 
     */
    private Set<Person> findBy(String partyName, PhoneNumber phoneNumber, PostalAddress postalAddress, String emailAddress)
    {
        ServiceResult<Set<Person>> result = contactPersonService.findContactPerson(partyName, phoneNumber, postalAddress, emailAddress, userLogin);
        if (!result.isSuccess())
        {
            throw new RuntimeException("Find Contact Person failed.", (Exception) result.getPayload());
        }

        return result.getPayload();
    }

    /**
     * Find by email address
     */
    private void findByEmailAddress(Person createdPerson)
    {
        /**
         * email address
         * Usage:
         *      [email address]
         */
        EmailAddress emailAddress = new PartyHelper(keyedCache, createdPerson).getPrimaryEmailAddress();
        log.debug("*** Find contact person by emailAddress: [emailAddress]");
        findBy(null, null, null, emailAddress.getEmailAddress());
    }

    /**
     * Find by first and last name
     */
    private void findByFirstAndLastName(Person createdPerson)
    {
        /**
         * first name
         * Usage:
         *  [lastName]
         */
        log.debug("*** Find contact person by partyName: [lastName]");
        Set<Person> people = findBy(createdPerson.getLastName(), null, null, null);
        for (Person person : people)
        {
            Assert.assertEquals(createdPerson.getLastName(), person.getLastName());
        }
        /**
         * first name
         * Usage:
         *  [lastName], [firstName]
         */
        log.debug("*** Find contact person by partyName: [lastName], [firstName]");
        findBy(createdPerson.getLastName() + ", " + createdPerson.getFirstName(), null, null, null);
        for (Person person : people)
        {
            Assert.assertEquals(createdPerson.getLastName(), person.getLastName());
            Assert.assertEquals(createdPerson.getFirstName(), person.getFirstName());
        }
    }
        

    /**
     * find user by a set of phone number queries
     */
    private void findByPhoneNumber(Person createdPerson)
    {
        PhoneNumber phoneNumber;
        PartyHelper helper = new PartyHelper(keyedCache, createdPerson);
        
        for (Iterator iter = helper.getPhoneNumbers().iterator(); iter.hasNext();)
        {
            PhoneNumber partyPhoneNumber = (PhoneNumber) iter.next();
            
            phoneNumber = new PhoneNumberHibernateImpl();
            phoneNumber.setContactNumber(partyPhoneNumber.getContactNumber());
            log.debug("*** Find contact person by phoneNumber: [contactNumber]");
            Set<Person> people = findBy(null, phoneNumber, null, null);
            // test that the people have this phone number
            boolean foundPhoneNumber = false;
            for (Person person : people)
            {
                PartyHelper personHelper = new PartyHelper(keyedCache, person);
                List<PhoneNumber> phoneNumbers = personHelper.getPhoneNumbers();
                for (PhoneNumber personPhoneNumber : phoneNumbers)
                {
                    if (personPhoneNumber.getContactNumber().equals(phoneNumber.getContactNumber()))
                    {
                        foundPhoneNumber = true;
                    }
                }
            }
            Assert.assertTrue(foundPhoneNumber);
            
            
            phoneNumber = new PhoneNumberHibernateImpl();
            phoneNumber.setExtension(partyPhoneNumber.getExtension());
            phoneNumber.setAreaCode(partyPhoneNumber.getAreaCode());
            log.debug("*** Find contact person by phoneNumber: [areaCode] [extension]");
            people = findBy(null, phoneNumber, null, null);
            // test that the people have this phone number
            foundPhoneNumber = false;
            for (Person person : people)
            {
                PartyHelper personHelper = new PartyHelper(keyedCache, person);
                List<PhoneNumber> phoneNumbers = personHelper.getPhoneNumbers();
                for (PhoneNumber personPhoneNumber : phoneNumbers)
                {
                    if (personPhoneNumber.getExtension().equals(phoneNumber.getExtension())
                            && personPhoneNumber.getAreaCode().equals(phoneNumber.getAreaCode()))
                    {
                        foundPhoneNumber = true;
                    }
                }
            }
            Assert.assertTrue(foundPhoneNumber);
            
        }
    }
    
    /**
     * find party by postal address params
     */
    private void findByPostalAddress(Person createdPerson)
    {
        PartyHelper helper = new PartyHelper(keyedCache, createdPerson);
        List postalAddresses = helper.getPostalAddresses();
        if (postalAddresses.size() < 1)
        {
            throw new RuntimeException("Failed to load postal addresses");
        }
        PostalAddress postalAddress = (PostalAddress) postalAddresses.get(0);
        
        // find by exact postal address
        log.debug("*** Find contact person by postalAddress: (all fields)");
        findBy(null, null, postalAddress, null);
        
        // find by zip and state
        postalAddress.setAddressLine1(null);
        postalAddress.setAddressLine2(null);
        postalAddress.setCity(null);
        log.debug("*** Find contact person by postalAddress: [postalCode] [state]");
        findBy(null, null, postalAddress, null);
        
        
    }
    
    /**
     * test creating a contact person.
     */
    @Test
    public void testCreateContactPerson()
    {
    	Person createdPerson = createContactPerson();

        // find the person
    	ServiceResult<Person> result = contactPersonService.findContactPerson(createdPerson.getId());
    	Person foundPerson = result.getPayload();
        Assert.assertEquals(createdPerson.getPartyId(), foundPerson.getPartyId());
    
        log.info("Created contact person successfully");
    }

	/**
     * test finding contact people with a number of possible inputs
     * 
     */
    @Test
    public void testFindContactPerson()
    {
    	Person person = createContactPerson();
        
        findByFirstAndLastName(person);
        
        findByEmailAddress(person);
        
        findByPhoneNumber(person);
        
        findByPostalAddress(person);
    }
}
