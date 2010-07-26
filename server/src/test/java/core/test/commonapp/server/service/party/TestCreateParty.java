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

import core.commonapp.client.dao.party.PartyDAO;
import core.commonapp.client.dao.party.PartyRelationshipDAO;
import core.commonapp.client.dao.party.PartyRoleDAO;
import core.commonapp.client.service.party.CreatePartyService;
import core.commonapp.server.service.CommonAppServiceInstantiator;
import core.data.model.party.Party;
import core.data.model.party.PartyGroup;
import core.data.model.party.PartyRelationship;
import core.data.model.party.PartyRole;
import core.data.model.party.Person;
import core.data.model.party.RoleType;
import core.service.result.ServiceResult;
import core.test.commonapp.server.CommonAppServerTest;
import core.test.server.mock.party.PartyMock;
import core.tooling.property.SystemPropertyFileReader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/commonapp-server-test-context.xml")
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
@Transactional
public class TestCreateParty extends CommonAppServerTest
{
    /** from date */
    private Timestamp fromDate = new Timestamp(System.currentTimeMillis());
    
    /** service to test creating parties */
    @Autowired
    private CreatePartyService createParty;
    
    @Autowired
    private PartyDAO partyDAO;
    
    @Autowired
    private PartyRoleDAO partyRoleDAO;
    
    @Autowired
    private PartyRelationshipDAO partyRelationshipDAO;
    
    private PartyMock partyMock;
    
    public TestCreateParty()
    {
        super();
    }

    /**
     * check party values
     * 
     * @param party
     */
    private void checkParty(Party party)
    {
        Party foundParty = partyDAO.findById(party.getPartyId());
        Assert.assertEquals(party.getPartyId(), foundParty.getId());
        Assert.assertEquals(party.getPartyType().getPartyTypeId(), foundParty.getPartyType().getPartyTypeId());
        // TODO: finish checking values
    }

    
    @Before
    public void setup() throws Exception
    {
        new SystemPropertyFileReader("commonapp-test-service.properties");
        partyMock = new PartyMock(getInformationContext());
    }

    /**
     * test create party group service
     */
    @Test
    public void testCreatePartyGroup() 
    {
        ServiceResult<PartyGroup> result = createParty.createPartyGroup("Jerry's Place");
        
        Assert.assertTrue(result.isSuccess());
        // party group
        PartyGroup partyGroup = result.getPayload();
        PartyGroup foundParty = (PartyGroup) partyDAO.findById(partyGroup.getId());
        Assert.assertEquals(partyGroup.getGroupName(), foundParty.getGroupName());
        
        //  party
        checkParty(partyGroup);
    }

    /**
     * test create party relationship service
     */
    @Test
    public void testCreatePartyRelationship()
    {
        Party partyFrom = partyMock.generateParty();
        RoleType roleTypeFrom = partyMock.generateRoleType();
        Party partyTo = partyMock.generateParty();
        RoleType roleTypeTo = partyMock.generateRoleType();
        ServiceResult<PartyRelationship> result = createParty.createPartyRelationship(partyFrom, roleTypeFrom, partyTo, roleTypeTo, fromDate);
        
        Assert.assertTrue(result.isSuccess());
        // party relationship
        PartyRelationship partyRelationship = result.getPayload();
        PartyRelationship foundRelationship = partyRelationshipDAO.findById(partyRelationship.getPartyRelationshipId());
        Assert.assertEquals(partyRelationship.getPartyRelationshipId(), partyRelationship.getPartyRelationshipId());
        Assert.assertEquals(partyRelationship.getPartyFrom().getPartyId(), partyRelationship.getPartyFrom().getId());
        Assert.assertEquals(partyRelationship.getPartyTo().getPartyId(), partyRelationship.getPartyTo().getId());
        Assert.assertEquals(partyRelationship.getRoleTypeFrom().getRoleTypeId(), partyRelationship.getRoleTypeFrom().getId());
        Assert.assertEquals(partyRelationship.getRoleTypeTo().getRoleTypeId(), partyRelationship.getRoleTypeTo().getId());
        Assert.assertEquals(partyRelationship.getFromDate(), partyRelationship.getFromDate());
        Assert.assertEquals(partyRelationship.getThruDate(), partyRelationship.getThruDate());
    }
    
    /**
     * test create party role service
     */
    @Test
    public void testCreatePartyRole() 
    {
        Party party = partyMock.generateParty();
        RoleType roleType = partyMock.generateRoleType();
        ServiceResult<PartyRole> result = createParty.createPartyRole(party, roleType, fromDate);
    
        Assert.assertTrue(result.isSuccess());
        // party role
        PartyRole partyRole = result.getPayload();
        PartyRole foundRole = partyRoleDAO.findById(partyRole.getPartyRoleId());
        Assert.assertEquals(partyRole.getPartyRoleId(), foundRole.getPartyRoleId());
        Assert.assertEquals(partyRole.getParty().getPartyId(), foundRole.getParty().getId());
        Assert.assertEquals(partyRole.getRoleType().getRoleTypeId(), foundRole.getRoleType().getId());
        Assert.assertEquals(partyRole.getFromDate(), foundRole.getFromDate());
        Assert.assertNull(partyRole.getThruDate());
    }
    
    /**
     * Test create person services
     */
    @Test
    public void testCreatePerson()
    {
        ServiceResult<Person> result = createParty.createPerson("Chris", "Smith", null);

        Assert.assertTrue(result.isSuccess());
        Person person = result.getPayload();
        Person foundPerson = (Person) partyDAO.findById(person.getPartyId());
        Assert.assertEquals(person.getFirstName(), foundPerson.getFirstName());
        Assert.assertEquals(person.getMiddleName(), foundPerson.getMiddleName());
        Assert.assertEquals(person.getLastName(), foundPerson.getLastName());
        
        checkParty(person);
    }
    
}
