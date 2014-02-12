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

import java.sql.Timestamp;

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
import core.commonapp.client.dao.contact.PartyContactMechDao;
import core.commonapp.client.dao.contact.PartyContactMechPurposeDao;
import core.commonapp.client.service.contact.CreatePartyContactMechService;
import core.commonapp.client.service.contact.PartyContactMechService;
import core.commonapp.server.service.CommonAppServiceInstantiator;
import core.data.cache.KeyedCache;
import core.data.cache.KeyedCacheStore;
import core.data.cache.contact.ContactMechPurposeKey;
import core.data.helper.contact.PartyContactMechHelper;
import core.data.helper.party.PartyHelper;
import core.data.hibernate.contact.ContactMechHibernateImpl;
import core.data.model.contact.ContactMechPurpose;
import core.data.model.contact.PartyContactMech;
import core.data.model.contact.PartyContactMechPurpose;
import core.data.model.contact.PhoneNumber;
import core.data.model.party.Party;
import core.service.result.ServiceResult;
import core.test.commonapp.server.CommonAppServerTest;
import core.test.server.mock.contact.ContactMechMock;
import core.test.server.mock.party.PartyMock;
import core.tooling.property.SystemPropertyFileReader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/commonapp-server-test-context.xml")
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
@Transactional
public class TestPartyContactMech extends CommonAppServerTest
{
    /** service to create party contact mech related objects */
    @Autowired
    private  CreatePartyContactMechService createPartyContactMech;

    /** service to party contact mech related objects */
    @Autowired
    private  PartyContactMechService partyContactMechService;

    @Autowired
    private  PartyContactMechDao partyContactMechDao;

    @Autowired
    private ContactMechDao contactMechDao;
    
    @Autowired
    private  PartyContactMechPurposeDao partyContactMechPurposeDao;
    
    /** party mock */
    private PartyMock partyMock;
    
    /** contact mech object mock */
    private ContactMechMock contactMechMock;

    @Autowired
    private KeyedCache keyedCache;

    /** create timestamp for from date fields */
    private Timestamp fromDate = new Timestamp(System.currentTimeMillis());

    @Before
    public void setup() throws Exception
    {
        new SystemPropertyFileReader("commonapp-test-service.properties");
        partyMock = new PartyMock(getInformationContext());
        contactMechMock = new ContactMechMock(getInformationContext());
    }
    
    @Test
    public void testExpirePartyContactMechPurpose()
    {
        // generate party
        Party party = partyMock.generateParty();
        // generate ContactMech
        ContactMechHibernateImpl contactMech = contactMechMock.generateContactMech();

        // create the PartyContactMech
        ServiceResult<PartyContactMech> result = createPartyContactMech.createPartyContactMech(party, contactMech,
                fromDate);
        Assert.assertTrue(result.isSuccess());
        PartyContactMech partyContactMech = result.getPayload();
        PartyContactMechHelper helper = new PartyContactMechHelper(partyContactMech);
        // add generated ContactMechPurpose
        ContactMechPurpose contactMechPurpose = contactMechMock.generateContactMechPurpose();
        helper.addContactMechPurpose(contactMechPurpose);
        ContactMechPurpose contactMechPurpose2 = contactMechMock.generateContactMechPurpose();
        helper.addContactMechPurpose(contactMechPurpose2);
        // save PartyContactMech
        partyContactMechDao.save(partyContactMech);
        PartyContactMechPurpose savedPurpose = partyContactMech.getPartyContactMechPurposes().get(0);

        PartyContactMechPurpose foundPurpose = partyContactMechPurposeDao.findById(savedPurpose.getId());
        Assert.assertEquals(savedPurpose.getFromDate(), foundPurpose.getFromDate());
        Assert.assertEquals(savedPurpose.getThruDate(), foundPurpose.getThruDate());
        Assert.assertEquals(savedPurpose.getPartyContactMechPurposeId(), foundPurpose.getPartyContactMechPurposeId());
        Assert.assertEquals(savedPurpose.getPartyContactMech().getPartyContactMechId(), foundPurpose.getPartyContactMech().getId());
        Assert.assertEquals(savedPurpose.getContactMechPurpose().getContactMechPurposeId(), foundPurpose.getContactMechPurpose().getId());

        // test expire
        ServiceResult<PartyContactMech> expireResult = partyContactMechService.expirePartyContactMech(partyContactMech);
        // TODO: ??? may need to compare all purposes
        savedPurpose = partyContactMech.getPartyContactMechPurposes().get(0);
        Assert.assertTrue(expireResult.isSuccess());
        foundPurpose = partyContactMechPurposeDao.findById(savedPurpose.getId());
        Assert.assertEquals(savedPurpose.getFromDate(), foundPurpose.getFromDate());
        Assert.assertEquals(savedPurpose.getThruDate(), foundPurpose.getThruDate());
        Assert.assertEquals(savedPurpose.getPartyContactMechPurposeId(), foundPurpose.getPartyContactMechPurposeId());
        Assert.assertEquals(savedPurpose.getPartyContactMech().getPartyContactMechId(), foundPurpose.getPartyContactMech().getId());
        Assert.assertEquals(savedPurpose.getContactMechPurpose().getContactMechPurposeId(), foundPurpose.getContactMechPurpose().getId());
    }

    /**
     * 
     */
    @Test
    public void testUpdatePartyContactMech()
    {
        // generate necessary objects
        Party party = partyMock.generatePerson();
        PhoneNumber phoneNumber = contactMechMock.generatePhoneNumber();

        // Create party contact mech to work with
        PartyHelper partyHelper = new PartyHelper(keyedCache, party);
        KeyedCacheStore<ContactMechPurpose> store = keyedCache.getCacheStore(ContactMechPurpose.class);
        PartyContactMech partyContactMech = partyHelper.addPhoneNumber(phoneNumber, store.getObject(ContactMechPurposeKey.KEY_FAX));

        partyContactMechDao.save(partyContactMech);

        // test update with phone number
        PhoneNumber newPhoneNumber = contactMechMock.generatePhoneNumber();

        ServiceResult<PartyContactMech> result = partyContactMechService.updatePartyContactMech(partyContactMech,
                newPhoneNumber);
        PartyContactMech newPartyContactMech = result.getPayload();

        // test results
        Assert.assertTrue(result.isSuccess());
        // test that old party contact mech is expired
        PartyContactMech foundPartyContactMech = partyContactMechDao.findById(partyContactMech.getPartyContactMechId());
        // TODO: finish testing

        // test the new party contact mech
        foundPartyContactMech = partyContactMechDao.findById(newPartyContactMech.getPartyContactMechId());
        // TODO: finish testing

        // test the old phone number
        PhoneNumber foundPhoneNumber = (PhoneNumber) contactMechDao.findById(phoneNumber.getContactMechId());
        // TODO: finish testing

        // test the new phone number
        foundPhoneNumber = (PhoneNumber) contactMechDao.findById(newPhoneNumber.getContactMechId());
        // TODO: finish testing
    }

}
