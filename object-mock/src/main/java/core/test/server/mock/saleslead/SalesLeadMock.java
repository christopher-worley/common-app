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
package core.test.server.mock.saleslead;

import java.util.Random;

import core.commonapp.domain.InformationContext;
import core.data.cache.KeyedCacheStore;
import core.data.cache.contact.ContactMechPurposeKey;
import core.data.cache.party.RoleTypeKey;
import core.data.helper.party.PartyHelper;
import core.data.helper.sales.SalesLeadHelper;
import core.data.hibernate.saleslead.SalesLeadHibernateImpl;
import core.data.model.contact.ContactMechPurpose;
import core.data.model.party.PartyGroup;
import core.data.model.party.Person;
import core.data.model.party.RoleType;
import core.test.server.mock.AbstractObjectMock;
import core.test.server.mock.contact.ContactMechMock;
import core.test.server.mock.party.PartyMock;

public class SalesLeadMock extends AbstractObjectMock
{
    /** sales lead descriptions */
    private String[] salesLeadDescriptions =
    {
        "New Sales Lead Mock 1",
        "Mock 2 Lead",
        "Mock 3 Sales Lead",
        "Sales Lead For Mock 4",
    };

    private PartyMock partyMock = new PartyMock(getInformationContext());
    private ContactMechMock contactMechMock = new ContactMechMock(getInformationContext());
    
    public SalesLeadMock(InformationContext context)
    {
        super(context);
    }
    
    /**
     * Generate a random sales lead
     * 
     * @return
     */
    public SalesLeadHibernateImpl generateSalesLead()
    {
        // create sales lead
        SalesLeadHibernateImpl salesLead = new SalesLeadHibernateImpl();
        salesLead.setDescription(generateSalesLeadDescription());
        
        SalesLeadHelper helper = new SalesLeadHelper(salesLead);
        
        KeyedCacheStore<RoleType> roleTypeCache = getKeyedCache().getCacheStore(RoleType.class);
        
        // add party roles
        // get a sales person
        helper.addSalesLeadRole(generateSalesPerson(), roleTypeCache.getObject(RoleTypeKey.KEY_SALES_PERSON));
        if (new Random().nextInt(2) == 0)
        {
            helper.addSalesLeadRole(partyMock.generatePartyGroup(), roleTypeCache.getObject(RoleTypeKey.KEY_BUYER));
        }
        else 
        {
            helper.addSalesLeadRole(partyMock.generatePerson(), roleTypeCache.getObject(RoleTypeKey.KEY_BUYER));
        }
        
        // add party contacts
        if (new Random().nextInt(2) == 0)
        {
            helper.addSalesLeadRole(partyMock.generatePerson(), roleTypeCache.getObject(RoleTypeKey.KEY_CONTACT_PERSON));
        }
        
        KeyedCacheStore<ContactMechPurpose> contactMechPurposeCache = getKeyedCache().getCacheStore(ContactMechPurpose.class);
        // add contact mechs
        if (new Random().nextInt(2) == 0) 
        {
            helper.addSalesLeadContactMech(contactMechMock.generateEmailAddress(), contactMechPurposeCache.getObject(ContactMechPurposeKey.KEY_PRIMARY));
            helper.addSalesLeadContactMech(contactMechMock.generatePhoneNumber(), contactMechPurposeCache.getObject(ContactMechPurposeKey.KEY_PRIMARY));
        }
        else
        {
            helper.addSalesLeadContactMech(contactMechMock.generatePhoneNumber(), contactMechPurposeCache.getObject(ContactMechPurposeKey.KEY_PRIMARY));
        }

        return salesLead;        
    }
    
    /**
     * return random description for a sales lead
     * 
     * @return
     */
    private String generateSalesLeadDescription()
    {
        int index = new Random().nextInt(salesLeadDescriptions.length);
        return salesLeadDescriptions[index];
    }
    
    /**
     * Generate a random sales person
     * 
     * @return
     */
    public Person generateSalesPerson()
    {
        Person person = partyMock.generatePerson();
        PartyHelper<Person> partyHelper = new PartyHelper<Person>(getKeyedCache(), person);
        KeyedCacheStore<RoleType> roleTypeCache = getKeyedCache().getCacheStore(RoleType.class);
        partyHelper.addRoleType(roleTypeCache.getObject(RoleTypeKey.KEY_SALES_PERSON));
        return person;
    }

    /**
     * 
     * @return
     */
    public PartyGroup generateSalesTeam()
    {
        PartyGroup team = partyMock.generatePartyGroup();
        PartyHelper<PartyGroup> partyHelper = new PartyHelper<PartyGroup>(getKeyedCache(), team);
        KeyedCacheStore<RoleType> roleTypeCache = getKeyedCache().getCacheStore(RoleType.class);
        partyHelper.addRoleType(roleTypeCache.getObject(RoleTypeKey.KEY_SALES_TEAM));
        return team;
    }

}
