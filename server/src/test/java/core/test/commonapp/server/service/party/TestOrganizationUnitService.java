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

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import core.commonapp.client.dao.party.OrganizationUnitDao;
import core.commonapp.client.dao.party.PartyGroupDao;
import core.commonapp.client.service.party.OrganizationUnitService;
import core.data.model.party.OrganizationUnit;
import core.data.model.party.PartyGroup;
import core.data.model.security.UserLogin;
import core.service.result.ServiceResult;
import core.test.commonapp.server.CommonAppServerTest;
import core.tooling.property.SystemPropertyFileReader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/commonapp-server-test-context.xml")
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
@Transactional
public class TestOrganizationUnitService extends CommonAppServerTest
{
    
    @Autowired
    private OrganizationUnitDao organizationUnitDao;
    
    @Autowired 
    private OrganizationUnitService organizationService;
    
    @Autowired
    private PartyGroupDao partyGroupDao;
    
    /**
     * 
     */
    public TestOrganizationUnitService()
    {
        super();
    }
    
    /**
     * @param description
     * @return
     */
    private OrganizationUnit createOrganizationUnitRoleType(String description)
    {
        ServiceResult<OrganizationUnit> result = organizationService.createOrganizationUnitRoleType(findSysAdmin(), description);
        
        Assert.assertTrue(result.isSuccess());
        
        return result.getPayload();
    }
    
    @Before
    public void setup()
    {
        new SystemPropertyFileReader("commonapp-test-service.properties");
    }

    /**
     * 
     */
    @Test
    public void testCreateOrganizationUnit()
    {
        UserLogin sysAdmin = findSysAdmin();
        
        OrganizationUnit unit = createOrganizationUnitRoleType("foobar");
        
        String test1Name = "Test Unit";
        ServiceResult<PartyGroup> result = organizationService.createOrganizationUnit(sysAdmin, test1Name, unit);
        Assert.assertTrue(result.isSuccess());
        PartyGroup test1 = result.getPayload();

        // validate the returned result then second find the party group and validate again
        Assert.assertEquals(test1Name, test1.getGroupName());
        Assert.assertEquals(unit.getRoleType(), test1.getPartyRoles().get(0).getRoleType());
        PartyGroup foundTest1 = partyGroupDao.findById(test1.getPartyId());
        Assert.assertEquals(test1Name, foundTest1.getGroupName());
        Assert.assertEquals(unit.getRoleType(), foundTest1.getPartyRoles().get(0).getRoleType());
                
        // create a child under the previous unit
        String test2Name = "Test Unit 2";
        result = organizationService.createOrganizationUnit(sysAdmin, test2Name, unit, test1);
        Assert.assertTrue(result.isSuccess());
        PartyGroup test2 = result.getPayload();
        
        // validate the returned result then second find the party group and validate again
        Assert.assertEquals(test2Name, test2.getGroupName());
        Assert.assertEquals(unit.getRoleType(), test2.getPartyRoles().get(0).getRoleType());
        Assert.assertEquals(test1.getPartyId(), test2.getPartyToRelationships().get(0).getPartyFrom().getPartyId());
        PartyGroup foundTest2 = partyGroupDao.findById(test2.getPartyId());
        Assert.assertEquals(test2Name, foundTest2.getGroupName());
        Assert.assertEquals(unit.getRoleType(), foundTest2.getPartyRoles().get(0).getRoleType());
        Assert.assertEquals(test1.getPartyId(), foundTest2.getPartyToRelationships().get(0).getPartyFrom().getPartyId());
    }

    public void testCreateOrganizationUnitRoleType()
    {
        String roleName1 = "test role";
        ServiceResult<OrganizationUnit> result = organizationService.createOrganizationUnitRoleType(findSysAdmin(), roleName1);
        
        // validate
        
        // create w/ parent
        
        // validate
    }

    public void testExpireOrganizationUnit()
    {
    }

    public void testExpireOrganizationUnitRoleType()
    {
    }
    
}
