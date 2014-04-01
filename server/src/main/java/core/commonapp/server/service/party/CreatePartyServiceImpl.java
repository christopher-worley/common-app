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

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.commonapp.client.dao.party.PartyDao;
import core.commonapp.client.dao.party.PartyRelationshipDao;
import core.commonapp.client.dao.party.PartyRoleDao;
import core.commonapp.client.service.party.CreatePartyService;
import core.data.cache.KeyedCache;
import core.data.cache.KeyedCacheStore;
import core.data.cache.party.PartyTypeKey;
import core.data.helper.party.PartyHelper;
import core.data.model.jpa.party.PartyGroupJpaImpl;
import core.data.model.jpa.party.PartyRelationshipJpaImpl;
import core.data.model.jpa.party.PartyRoleJpaImpl;
import core.data.model.jpa.party.PersonJpaImpl;
import core.data.model.party.Party;
import core.data.model.party.PartyGroup;
import core.data.model.party.PartyRelationship;
import core.data.model.party.PartyRole;
import core.data.model.party.PartyType;
import core.data.model.party.Person;
import core.data.model.party.RoleType;
import core.service.result.ServiceResult;
import core.tooling.logging.LogFactory;
import core.tooling.logging.Logger;

@Service
public class CreatePartyServiceImpl implements CreatePartyService
{
    /** logger for this class */
    private static Logger log = LogFactory.getLogger(CreatePartyServiceImpl.class);

    /** party Dao */
    @Autowired
    private PartyDao partyDao;

    /** party relationship Dao */
    @Autowired
    private PartyRelationshipDao partyRelationshipDao;
    
    /** party role Dao */
    @Autowired
    private PartyRoleDao partyRoleDao;
    
    @Autowired
    private KeyedCache keyedCache;

    public CreatePartyServiceImpl()
    {
        super();
        
    }
    
    @Override
    public ServiceResult<PartyGroup> createPartyGroup(String groupName) 
    {
        log.debug("CreatePartImpl.createPartyGroup({0})", groupName);
        PartyGroup partyGroup = new PartyGroupJpaImpl();
        partyGroup.setPartyType(getPartyTypeCache().getObject(PartyTypeKey.KEY_PARTY_GROUP));
        partyGroup.setGroupName(groupName);
        
        partyDao.save(partyGroup);
        log.debug("PartyGroup created with id {0}: ", partyGroup.getId());
        
        return new ServiceResult(partyGroup);
    }
    
    @Override
    public ServiceResult<PartyRelationship> createPartyRelationship(Party partyFrom, RoleType roleTypeFrom, Party partyTo,
            RoleType roleTypeTo, Timestamp fromDate)
    {
        log.debug("CreatePartyServiceImpl.createRelationship({0}, {1}, {2}, {3})", partyFrom, roleTypeFrom, partyTo, roleTypeTo);
        PartyRelationship partyRelationship = new PartyRelationshipJpaImpl();
        partyRelationship.setPartyFrom(partyFrom);
        partyRelationship.setRoleTypeFrom(roleTypeFrom);
        partyRelationship.setPartyTo(partyTo);
        partyRelationship.setRoleTypeTo(roleTypeTo);
        partyRelationship.setFromDate(fromDate);
        
        partyRelationshipDao.save(partyRelationship);
        log.debug("PartyRelationship created with id {0}: ", partyRelationship.getId());
        
        return new ServiceResult(partyRelationship);
    }
    
    @Override
    public ServiceResult<PartyRole> createPartyRole(Party party, RoleType roleType, Timestamp fromDate)
    {
        log.debug("CreatePartyServiceImpl.createPartyRole({0}, {1})", party, roleType);
        PartyRole partyRole = new PartyRoleJpaImpl();
        partyRole.setParty(party);
        partyRole.setRoleType(roleType);
        partyRole.setFromDate(fromDate);
        
        partyRoleDao.save(partyRole);
        log.debug("PartyRole created with id {0}: ", partyRole.getId());
        
        return new ServiceResult(partyRole);
    }

    @Override
    public ServiceResult<Person> createPerson(Person person, RoleType[] roleTypes)
    {
        log.debug("CreatePartyImpl.createPerson({0})", person);
        person.setPartyType(getPartyTypeCache().getObject(PartyTypeKey.KEY_PERSON));
        
        PartyHelper<Person> partyHelper = new PartyHelper<Person>(keyedCache, person);
        
        if (roleTypes != null)
        {
            for (int index = 0; index < roleTypes.length; index++)
            {
                partyHelper.addRoleType(roleTypes[index]);
            }
        }
        
        person = (Person) partyDao.save(person);
        log.debug("Person created with id {0}: ", person.getId());
        
        return new ServiceResult(person);
    }

    @Override
    public ServiceResult<Person> createPerson(String firstName, String lastName, RoleType[] roleTypes)
    {
        log.debug("CreatePartyImpl.createPerson({0}, {1})", firstName, lastName);
        Person person = new PersonJpaImpl();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        
        return createPerson(person, roleTypes);
    }

    /**
     * return PartyType cache store from cache
     * 
     * @return keyed cache store for PartyType objects
     */
    private KeyedCacheStore<PartyType> getPartyTypeCache()
    {
        return keyedCache.getCacheStore(PartyType.class);
    }
    
}
