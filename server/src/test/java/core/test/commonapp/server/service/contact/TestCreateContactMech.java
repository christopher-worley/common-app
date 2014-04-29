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
package core.test.commonapp.server.service.contact;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import core.commonapp.client.dao.contact.ContactMechDao;
import core.commonapp.client.service.contact.CreateContactMechService;
import core.commonapp.server.cache.KeyedCacheServerImpl;
import core.data.cache.KeyedCache;
import core.data.cache.KeyedCacheStore;
import core.data.cache.geo.GeoKey;
import core.data.model.contact.ContactMech;
import core.data.model.contact.EmailAddress;
import core.data.model.contact.PhoneNumber;
import core.data.model.contact.PostalAddress;
import core.data.model.geo.Geo;
import core.service.result.ServiceResult;
import core.test.commonapp.server.CommonAppServerTest;
import core.tooling.property.SystemPropertyFileReader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/commonapp-server-test-context.xml")
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
@Transactional
public class TestCreateContactMech extends CommonAppServerTest
{
    /** create contact mech service */
    @Autowired
    private CreateContactMechService createContactMech;
    
    @Autowired
    private ContactMechDao contactMechDao;
    
    @Autowired
    private KeyedCache keyedCache;

    /**
     * Default constructor
     * 
     */
    public TestCreateContactMech()
    {
        super();
    }

    /**
     * Helper method for checking contact mech base class
     * @param contactMech
     */
    private void checkContactMech(ContactMech contactMech)
    {
        ContactMech foundContactMech = contactMechDao.findById(contactMech.getContactMechId());
        Assert.assertEquals(contactMech.getContactMechId(), foundContactMech.getContactMechId());
        Assert.assertEquals(contactMech.getContactMechType().getContactMechTypeId(), foundContactMech.getContactMechType().getId());
    }
    
    @Before
    public void setup() throws Exception
    {
        new SystemPropertyFileReader("commonapp-test-service.properties");
    }

    /**
     * Test create email address service
     */
    @Test
    public void testCreateEmailAdress()
    {
        ServiceResult<EmailAddress> result = createContactMech.createEmailAddress("x@y.com");
        
        Assert.assertTrue(result.isSuccess());
        EmailAddress emailAddress = result.getPayload();
        EmailAddress foundEmailAddress = (EmailAddress) contactMechDao.findById(emailAddress.getContactMechId());
        // email
        Assert.assertEquals(emailAddress.getEmailAddress(), foundEmailAddress.getEmailAddress());
        Assert.assertEquals(emailAddress.getContactMechId(), foundEmailAddress.getContactMechId());

        // contact mech
        checkContactMech(emailAddress);
    }

    /**
     * Test create phone number service
     */
    @Test
    public void testCreatePhoneNumber()
    {
        ServiceResult<PhoneNumber> result = createContactMech.createPhoneNumber("1", "919", "4445555", "333");
        
        Assert.assertTrue(result.isSuccess());
        PhoneNumber phoneNumber = result.getPayload();
        PhoneNumber foundNumber = (PhoneNumber) contactMechDao.findById(phoneNumber.getContactMechId());
        // phone number
        Assert.assertEquals(phoneNumber.getAreaCode(), foundNumber.getAreaCode());
        Assert.assertEquals(phoneNumber.getContactNumber(), foundNumber.getContactNumber());
        Assert.assertEquals(phoneNumber.getCountryCode(), foundNumber.getCountryCode());
        Assert.assertEquals(phoneNumber.getExtension(), foundNumber.getExtension());

        // contact mech
        checkContactMech(phoneNumber);
    }
    
    /**
     * Test create postal address service
     */
    @Test
    public void testCreatePostalAddress()
    {
        KeyedCacheStore<Geo> store = keyedCache.getCacheStore(Geo.class); 
        ServiceResult<PostalAddress> result = createContactMech.createPostalAddress("address1", "address2", "city", "11134", store.getObject(GeoKey.KEY_COLORADO), store.getObject(GeoKey.KEY_UNITED_STATES));
        
        Assert.assertTrue(result.isSuccess());
        PostalAddress postalAddress = result.getPayload();
        PostalAddress foundAddress = (PostalAddress) contactMechDao.findById(postalAddress.getContactMechId());
        // phone number
        Assert.assertEquals(postalAddress.getAddressLine1(), foundAddress.getAddressLine1());
        Assert.assertEquals(postalAddress.getAddressLine2(), foundAddress.getAddressLine2());
        Assert.assertEquals(postalAddress.getCity(), foundAddress.getCity());
        Assert.assertEquals(postalAddress.getPostalCode(), foundAddress.getPostalCode());
        Assert.assertEquals(postalAddress.getCountryGeo().getGeoId(), foundAddress.getCountryGeo().getId());
        Assert.assertEquals(postalAddress.getStateGeo().getGeoId(), foundAddress.getStateGeo().getId());

        // contact mech
        checkContactMech(postalAddress);
    }
}
