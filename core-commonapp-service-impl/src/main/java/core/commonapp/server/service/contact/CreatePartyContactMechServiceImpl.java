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
package core.commonapp.server.service.contact;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.commonapp.client.dao.contact.PartyContactMechDao;
import core.commonapp.client.dao.contact.PartyContactMechPurposeDao;
import core.commonapp.client.service.contact.CreatePartyContactMechService;
import core.data.cache.KeyedCache;
import core.data.helper.party.PartyHelper;
import core.data.model.contact.ContactMech;
import core.data.model.contact.ContactMechPurpose;
import core.data.model.contact.PartyContactMech;
import core.data.model.contact.PartyContactMechPurpose;
import core.data.model.jpa.contact.PartyContactMechJpaImpl;
import core.data.model.jpa.contact.PartyContactMechPurposeJpaImpl;
import core.data.model.party.Party;
import core.service.result.ServiceResult;
import core.tooling.logging.LogFactory;
import core.tooling.logging.Logger;

@Service
public class CreatePartyContactMechServiceImpl implements CreatePartyContactMechService
{
    /** logger for this class */
    private static Logger log = LogFactory.getLogger(CreatePartyContactMechServiceImpl.class);

    /** PartyContactMech data access object */
    private PartyContactMechDao partyContactMechDao;
    
    /** PartyContactMechPurposeType data access object */
    private PartyContactMechPurposeDao partyContactMechPurposeDao;
    
    /** data contstat factory */
    @Autowired
    private KeyedCache KeyedCache;
    
    public CreatePartyContactMechServiceImpl()
    {
        super();
    }
    
    
    /**
     * Default constructor
     * 
     * @param partyContactMechDao
     * @param partyContactMechPurposeDao
     */
    @Autowired
    public CreatePartyContactMechServiceImpl(PartyContactMechDao partyContactMechDao,
            PartyContactMechPurposeDao partyContactMechPurposeDao)
    {
        super();
        this.partyContactMechDao = partyContactMechDao;
        this.partyContactMechPurposeDao = partyContactMechPurposeDao;
    }

    @Override
    public ServiceResult<PartyContactMech> createPartyContactMech(Party party, ContactMech contactMech, Timestamp fromDate)
    {
        log.debug("CreatePartyContactMechServiceImpl.createPartyContactMech({0}, {1}, {2})", party, contactMech, fromDate);
        PartyContactMechJpaImpl partyContactMech = new PartyContactMechJpaImpl();
        partyContactMech.setParty(party);
        partyContactMech.setContactMech(contactMech);
        partyContactMech.setFromDate(fromDate);
        
        // add reference to the party
        PartyHelper<Party> helper = new PartyHelper<Party>(KeyedCache, party);
        helper.addPartyContactMech(partyContactMech);

        partyContactMechDao.save(partyContactMech);
        log.debug("PartyContactMech created with id {0}: ", partyContactMech.getId());
        
        return new ServiceResult(partyContactMech);
    }

    @Override
    public ServiceResult<PartyContactMechPurpose> createPartyContactMechPurpose(PartyContactMech partyContactMech,
            ContactMechPurpose contactMechPurpose, Timestamp fromDate)
    {
        log.debug("CreatePartyContactMechServiceImpl.createPartyContactMechPurposeType({0}, {1}, {2})", partyContactMech, contactMechPurpose, fromDate);
        PartyContactMechPurposeJpaImpl partyContactMechPurpose = new PartyContactMechPurposeJpaImpl();
        partyContactMechPurpose.setPartyContactMech(partyContactMech);
        partyContactMechPurpose.setContactMechPurpose(contactMechPurpose);
        partyContactMechPurpose.setFromDate(fromDate);

        partyContactMechPurposeDao.save(partyContactMechPurpose);
        log.debug("PartyContactMechPurpose created with id {0}: ", partyContactMechPurpose.getId());
        
        return new ServiceResult(partyContactMechPurpose);
    }

}
