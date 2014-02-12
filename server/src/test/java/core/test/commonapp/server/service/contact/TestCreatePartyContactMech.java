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

import core.commonapp.client.dao.contact.PartyContactMechDao;
import core.commonapp.client.dao.contact.PartyContactMechPurposeDao;
import core.commonapp.client.service.contact.CreatePartyContactMechService;
import core.commonapp.server.service.CommonAppServiceInstantiator;
import core.data.hibernate.contact.ContactMechHibernateImpl;
import core.data.model.contact.ContactMechPurpose;
import core.data.model.contact.PartyContactMech;
import core.data.model.contact.PartyContactMechPurpose;
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
public class TestCreatePartyContactMech extends CommonAppServerTest
{
    /** service to create party contact mech related objects */
    @Autowired
    private CreatePartyContactMechService createPartyContactMech;
    
    /** party contact mech purpose dao */
    @Autowired
    private PartyContactMechPurposeDao partyContactMechPurposeDao;
    
    @Autowired
    private PartyContactMechDao partyContactMechDao;

    /** create timestamp for from date fields */
    private Timestamp fromDate = new Timestamp(System.currentTimeMillis());
    
    /** party object mock */
    private PartyMock partyMock;
    
    /** contact mech object mock */
    private ContactMechMock contactMechMock;

    /**
     * Default constructor
     * 
     */
    public TestCreatePartyContactMech()
    {
        super();
    }

    @Before
    public void setup() throws Exception
    {
        new SystemPropertyFileReader("commonapp-test-service.properties");
        partyMock = new PartyMock(getInformationContext());
        contactMechMock = new ContactMechMock(getInformationContext());
    }

    /**
     * test create party contact mech object
     * 
     */
    @Test
    public void testCreatePartyContactMech() 
    {
        Party party = partyMock.generateParty();
        ContactMechHibernateImpl contactMech = contactMechMock.generateContactMech();
        
        ServiceResult<PartyContactMech> result = createPartyContactMech.createPartyContactMech(party, contactMech, fromDate);

        Assert.assertTrue(result.isSuccess());
        PartyContactMech partyContactMech = result.getPayload();
        PartyContactMech foundPartyContactMech = partyContactMechDao.findById(partyContactMech.getPartyContactMechId());
        Assert.assertEquals(partyContactMech.getContactMech().getContactMechId(), foundPartyContactMech.getContactMech().getId());
        Assert.assertEquals(partyContactMech.getParty().getPartyId(), foundPartyContactMech.getParty().getId());
        Assert.assertEquals(partyContactMech.getPartyContactMechId(), foundPartyContactMech.getPartyContactMechId());
        Assert.assertEquals(partyContactMech.getFromDate(), foundPartyContactMech.getFromDate());
        Assert.assertNull(partyContactMech.getThruDate());
    }
    
    /**
     * Test creating party contact mech purpose object
     */
    @Test
    public void testCreatePartyContactMechPurpose() 
    {
        PartyContactMech partyContactMech = contactMechMock.generatePartyContactMech();
        ContactMechPurpose contactMechPurposeType = contactMechMock.generateContactMechPurpose();
        
        ServiceResult<PartyContactMechPurpose> result = createPartyContactMech.createPartyContactMechPurpose(partyContactMech, contactMechPurposeType, fromDate);

        Assert.assertTrue(result.isSuccess());
        PartyContactMechPurpose partyContactMechPurpose = result.getPayload();
        PartyContactMechPurpose foundPurpose = partyContactMechPurposeDao.findById(partyContactMechPurpose.getPartyContactMechPurposeId());
        Assert.assertEquals(partyContactMechPurpose.getPartyContactMechPurposeId(), foundPurpose.getPartyContactMechPurposeId());
        Assert.assertEquals(partyContactMechPurpose.getContactMechPurpose().getContactMechPurposeId(), foundPurpose.getContactMechPurpose().getId());
        Assert.assertEquals(partyContactMechPurpose.getPartyContactMech().getPartyContactMechId(), foundPurpose.getPartyContactMech().getId());
        Assert.assertEquals(partyContactMechPurpose.getFromDate(), foundPurpose.getFromDate());
        Assert.assertNull(partyContactMechPurpose.getThruDate());
    }

}
