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
package core.test.commonapp.server.service.security;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import core.commonapp.client.dao.security.PermissionSecurityGroupDao;
import core.commonapp.client.dao.security.SecurityGroupDao;
import core.commonapp.client.dao.security.UserLoginDao;
import core.commonapp.client.service.security.SecurityGroupService;
import core.commonapp.client.service.security.UserService;
import core.commonapp.server.cache.KeyedCacheServerImpl;
import core.data.cache.KeyedCache;
import core.data.cache.KeyedCacheStore;
import core.data.cache.security.PermissionKey;
import core.data.model.party.Person;
import core.data.model.security.Permission;
import core.data.model.security.PermissionSecurityGroup;
import core.data.model.security.SecurityGroup;
import core.data.model.security.UserLogin;
import core.service.result.ServiceResult;
import core.test.commonapp.server.CommonAppServerTest;
import core.test.server.mock.party.PartyMock;
import core.tooling.logging.LogFactory;
import core.tooling.logging.Logger;
import core.tooling.property.SystemPropertyFileReader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/commonapp-server-test-context.xml")
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
@Transactional
public class TestSecurity extends CommonAppServerTest
{
    /** logger */
    Logger log = LogFactory.getLogger(TestSecurity.class);

    /** user service */
    @Autowired
    private UserService userService;
    
    /** security group service */
    @Autowired
    private SecurityGroupService securityGroupService;
    
    @Autowired
    private UserLoginDao userLoginDao;
    
    @Autowired
    private SecurityGroupDao securityGroupDao;
    
    /** permission security group dao */
    @Autowired
    private PermissionSecurityGroupDao permissionSecurityGroupDao;
    
    @Autowired
    private KeyedCache keyedCache;
    
    private PartyMock partyMock;

    /**
     * Default constructor
     * 
     * @param userService
     */
    public TestSecurity()
    {
        super();
    }
    
    /**
     * find the sys admin user login
     * 
     * @return
     */
    public UserLogin findSysAdmin() 
    {
        return userService.findByUsernameAndPassword("sysadmin", "sysadmin").getPayload();
    }

    @Before
    public void setup() throws Exception
    {
        new SystemPropertyFileReader("commonapp-test-service.properties");
        partyMock = new PartyMock(getInformationContext());
    }

    @Test
    public void testAddUsersToSecurityGroup()
    {

    }
    
    @Test
    public void testCreateSecurityGroup()
    {
        UserLogin userLogin = findSysAdmin();
        
        String description = "Test Group";
        String code = "TG";
        
        ServiceResult<SecurityGroup> serviceResult = securityGroupService.createSecurityGroup(userLogin, description, code);
        SecurityGroup securityGroup = serviceResult.getPayload();

        SecurityGroup foundSecurityGroup = securityGroupDao.findById(securityGroup.getSecurityGroupId());
        Assert.assertEquals(securityGroup.getCode(), foundSecurityGroup.getCode());
        Assert.assertEquals(securityGroup.getDescription(), foundSecurityGroup.getDescription());
        Assert.assertEquals(securityGroup.getKey(), foundSecurityGroup.getKey());
        Assert.assertEquals(securityGroup.getSecurityGroupId(), (Integer)foundSecurityGroup.getSecurityGroupId());
    }

    /**
     * test create user login service
     */
    @Test
    public void testCreateUserLogin()
    {
        Person person = partyMock.generatePerson();
        ServiceResult result = userService.createUserLogin(person, person.getFirstName().substring(0, 1)
                + person.getLastName(), "foobar");
        UserLogin userLogin = (UserLogin) result.getPayload();

        log.debug("Created new user login: {0}", userLogin);
        UserLogin foundUserLogin = userLoginDao.findById(userLogin.getUserLoginId());
        Assert.assertEquals(userLogin.getUserLoginId(), foundUserLogin.getUserLoginId());
        Assert.assertEquals(userLogin.getUsername(), foundUserLogin.getUsername());
        Assert.assertEquals(userLogin.getPassword(), foundUserLogin.getPassword());
        Assert.assertEquals(userLogin.getCreatedDate(), foundUserLogin.getCreatedDate());
        Assert.assertEquals(userLogin.getEnabled(), foundUserLogin.getEnabled());
        // TODO: compare Party
    }

    @Test
    public void testRemoveUserFromSecurityGroup()
    {

    }

    @Test
    public void testSaveSecurityGroup()
    {
        UserLogin userLogin = findSysAdmin();
        ServiceResult<SecurityGroup> serviceResult = securityGroupService.createSecurityGroup(userLogin, "Test saveSecurityGroup", "TSSG");
        SecurityGroup securityGroup = serviceResult.getPayload();
        
        KeyedCache keyedCache = (KeyedCache) getInformationContext().getBean(KeyedCache.class);
        KeyedCacheStore<Permission> permissionStore = keyedCache.getCacheStore(Permission.class);
        
        Permission createSecurityGroupPermission = permissionStore.getObject(PermissionKey.KEY_CREATE_SECURITY_GROUP);
        Permission createUserLoginPermission = permissionStore.getObject(PermissionKey.KEY_CREATE_USER_LOGIN);
        Permission modifySecurityGroupPermission = permissionStore.getObject(PermissionKey.KEY_MODIFY_SECURITY_GROUP);
        Permission modifyUserLoginPermission = permissionStore.getObject(PermissionKey.KEY_MODIFY_USER_LOGIN);
        
        List<Permission> permissions = new ArrayList<Permission>();
        permissions.add(createSecurityGroupPermission);
        permissions.add(createUserLoginPermission);
        permissions.add(modifySecurityGroupPermission);
        securityGroupService.saveSecurityGroup(userLogin, securityGroup, permissions);
        
        List<PermissionSecurityGroup> testList = permissionSecurityGroupDao.findAllBySecurityGroup(securityGroup, true);
        Assert.assertEquals(testList.size(), 3);
        Assert.assertTrue(testList.contains(createSecurityGroupPermission));
        Assert.assertTrue(testList.contains(createUserLoginPermission));
        Assert.assertTrue(testList.contains(modifySecurityGroupPermission));
        
        permissions.remove(createSecurityGroupPermission);
        permissions.remove(createUserLoginPermission);
        permissions.add(modifyUserLoginPermission);
        securityGroupService.saveSecurityGroup(userLogin, securityGroup, permissions);
        
        testList = permissionSecurityGroupDao.findAllBySecurityGroup(securityGroup, true);
        Assert.assertEquals(testList.size(), 4);
        Assert.assertFalse(testList.contains(createSecurityGroupPermission));
        Assert.assertFalse(testList.contains(createUserLoginPermission));
        Assert.assertTrue(testList.contains(modifySecurityGroupPermission));
        Assert.assertTrue(testList.contains(modifyUserLoginPermission));
        
    }
}
