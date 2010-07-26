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

import core.commonapp.client.dao.contact.PartyContactMechDAO;
import core.commonapp.client.dao.contact.PartyContactMechPurposeDAO;
import core.commonapp.client.service.contact.CreatePartyContactMechService;
import core.data.cache.KeyedCache;
import core.data.helper.party.PartyHelper;
import core.data.hibernate.contact.PartyContactMechHibernateImpl;
import core.data.hibernate.contact.PartyContactMechPurposeHibernateImpl;
import core.data.model.contact.ContactMech;
import core.data.model.contact.ContactMechPurpose;
import core.data.model.contact.PartyContactMech;
import core.data.model.contact.PartyContactMechPurpose;
import core.data.model.party.Party;
import core.service.result.ServiceResult;
import core.tooling.logging.LogFactory;
import core.tooling.logging.Logger;

public class CreatePartyContactMechServiceImpl implements CreatePartyContactMechService
{
    /** logger for this class */
    private static Logger log = LogFactory.getLogger(CreatePartyContactMechServiceImpl.class);

    /** PartyContactMech data access object */
    private PartyContactMechDAO partyContactMechDAO;
    
    /** PartyContactMechPurposeType data access object */
    private PartyContactMechPurposeDAO partyContactMechPurposeDAO;
    
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
     * @param partyContactMechDAO
     * @param partyContactMechPurposeDAO
     */
    @Autowired
    public CreatePartyContactMechServiceImpl(PartyContactMechDAO partyContactMechDAO,
            PartyContactMechPurposeDAO partyContactMechPurposeDAO)
    {
        super();
        this.partyContactMechDAO = partyContactMechDAO;
        this.partyContactMechPurposeDAO = partyContactMechPurposeDAO;
    }

    @Override
    public ServiceResult<PartyContactMech> createPartyContactMech(Party party, ContactMech contactMech, Timestamp fromDate)
    {
        log.debug("CreatePartyContactMechServiceImpl.createPartyContactMech({0}, {1}, {2})", party, contactMech, fromDate);
        PartyContactMechHibernateImpl partyContactMech = new PartyContactMechHibernateImpl();
        partyContactMech.setParty(party);
        partyContactMech.setContactMech(contactMech);
        partyContactMech.setFromDate(fromDate);
        
        // add reference to the party
        PartyHelper<Party> helper = new PartyHelper<Party>(KeyedCache, party);
        helper.addPartyContactMech(partyContactMech);

        partyContactMechDAO.save(partyContactMech);
        log.debug("PartyContactMech created with id {0}: ", partyContactMech.getId());
        
        return new ServiceResult(partyContactMech);
    }

    @Override
    public ServiceResult<PartyContactMechPurpose> createPartyContactMechPurpose(PartyContactMech partyContactMech,
            ContactMechPurpose contactMechPurpose, Timestamp fromDate)
    {
        log.debug("CreatePartyContactMechServiceImpl.createPartyContactMechPurposeType({0}, {1}, {2})", partyContactMech, contactMechPurpose, fromDate);
        PartyContactMechPurposeHibernateImpl partyContactMechPurpose = new PartyContactMechPurposeHibernateImpl();
        partyContactMechPurpose.setPartyContactMech(partyContactMech);
        partyContactMechPurpose.setContactMechPurpose(contactMechPurpose);
        partyContactMechPurpose.setFromDate(fromDate);

        partyContactMechPurposeDAO.save(partyContactMechPurpose);
        log.debug("PartyContactMechPurpose created with id {0}: ", partyContactMechPurpose.getId());
        
        return new ServiceResult(partyContactMechPurpose);
    }

}
