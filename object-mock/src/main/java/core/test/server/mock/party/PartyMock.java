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
package core.test.server.mock.party;

import java.util.List;
import java.util.Random;

import core.commonapp.domain.InformationContext;
import core.data.cache.KeyedCacheStore;
import core.data.model.jpa.party.PartyGroupJpaImpl;
import core.data.model.jpa.party.PersonJpaImpl;
import core.data.model.party.Party;
import core.data.model.party.PartyGroup;
import core.data.model.party.PartyType;
import core.data.model.party.Person;
import core.data.model.party.RoleType;
import core.test.server.mock.AbstractObjectMock;
import core.test.server.mock.util.PersonNameUtil;

public class PartyMock extends AbstractObjectMock
{
    private String[] groupNames = {
        "ABC inc.",
        "XYZ llc",
        "AeroTek corp."
    };
    
    private KeyedCacheStore<RoleType> roleTypeCache;

    private  KeyedCacheStore<PartyType> partyTypeCache;
    
    
    /**
     * @param context
     */
    public PartyMock(InformationContext context)
    {
        super(context);
        roleTypeCache = (KeyedCacheStore<RoleType>) getKeyedCache().getCacheStore(RoleType.class);
        partyTypeCache = (KeyedCacheStore<PartyType>) getKeyedCache().getCacheStore(PartyType.class);
    }

    /**
     * Generate a mocked up Party object
     * 
     * @return
     */
    public Party generateParty()
    {
        int random = new Random().nextInt(2);
        if (random == 1) 
        {
            return generatePerson();
        } 
        else 
        {
          return generatePartyGroup();  
        }
    }
    
    /**
     * generate party group
     * 
     * @return
     */
    public PartyGroup generatePartyGroup()
    {
        PartyGroup partyGroup = new PartyGroupJpaImpl();
        //partyGroup.setPartyType(partyTypeCache.getPartyGroupType());
        
        int random = new Random().nextInt(groupNames.length);
        partyGroup.setGroupName(groupNames[random]);
        
        return partyGroup;
    }
    
    /**
     * generate person 
     * 
     * @return
     */
    public Person generatePerson()
    {
        Person person = new PersonJpaImpl();
        //person.setPartyType(partyTypeCache.getPersonType());
        PersonNameUtil nameUtil = PersonNameUtil.getInstance();
        
        int lastRandom = new Random().nextInt(nameUtil.getLastNames().size());
        person.setLastName((String)nameUtil.getLastNames().get(lastRandom));

        if (new Random().nextInt(1) > 0) 
        {
            int femaleRandom = new Random().nextInt(nameUtil.getFemaleNames().size());
            person.setFirstName((String)nameUtil.getFemaleNames().get(femaleRandom));
        }
        else 
        {
            int maleRandom = new Random().nextInt(nameUtil.getMaleNames().size());
            person.setFirstName((String)nameUtil.getMaleNames().get(maleRandom));
        }
        
        return person;
    }

    /**
     * generate role type
     * @return
     */
    public RoleType generateRoleType()
    {
        List<RoleType> roleTypes = roleTypeCache.getObjects();
        int random = new Random().nextInt(roleTypes.size());
        return roleTypes.get(random);
    }
}
