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

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import core.commonapp.client.dao.contact.PartyContactMechDao;
import core.commonapp.client.service.contact.PartyContactMechService;
import core.data.helper.contact.PartyContactMechHelper;
import core.data.hibernate.contact.PartyContactMechHibernateImpl;
import core.data.hibernate.contact.PartyContactMechPurposeHibernateImpl;
import core.data.model.contact.ContactMech;
import core.data.model.contact.PartyContactMech;
import core.data.model.contact.PartyContactMechPurpose;
import core.service.result.ServiceResult;
import core.tooling.logging.LogFactory;
import core.tooling.logging.Logger;

/**
 * Services handling the <code>PartyContactMech</code> data model
 * 
 * @author worleyc
 *
 */
public class PartyContactMechServiceImpl implements PartyContactMechService
{
    /** logger for this class */
    private static Logger log = LogFactory.getLogger(PartyContactMechServiceImpl.class);

    /** generic dao */
    private PartyContactMechDao partyContactMechDao;

    public PartyContactMechServiceImpl()
    {
        super();
        
    }
    
    @Autowired
    public PartyContactMechServiceImpl(PartyContactMechDao partyContactMechDao)
    {
        super();
        this.partyContactMechDao = partyContactMechDao;
    }
    
    @Override
    public ServiceResult<PartyContactMech> expirePartyContactMech(PartyContactMech partyContactMech)
    {
        log.debug("PartyContactMechServiceImpl.expirePartyContactMech({0})", partyContactMech);
        // TODO: Use service date
        partyContactMech.setThruDate(new Date());
        partyContactMech = partyContactMechDao.save(partyContactMech);
        log.debug("PartyContactMech expired at {0}.", partyContactMech.getThruDate());
        return ServiceResult.success("Successfully expired contact information.", partyContactMech);
    }

	@Override
	public ServiceResult<PartyContactMech> updatePartyContactMech(
			PartyContactMech partyContactMech, ContactMech contactMech) {
        // TODO: service timestamp
        Date currentDate = new Date();

        // expire old
		partyContactMech.setThruDate(currentDate);
		
		partyContactMechDao.save(partyContactMech);
		
		// create new
		// TODO: should implement clone?
		PartyContactMech newPartyContactMech = new PartyContactMechHibernateImpl();
		newPartyContactMech.setFromDate(currentDate);
		newPartyContactMech.setParty(partyContactMech.getParty());
		newPartyContactMech.setContactMech(contactMech);
		if (newPartyContactMech.getPartyContactMechPurposes() != null)
		{
			PartyContactMechHelper helper = new PartyContactMechHelper(newPartyContactMech);
			for (PartyContactMechPurpose purpose : newPartyContactMech.getPartyContactMechPurposes())
			{
				PartyContactMechPurpose newPurpose = new PartyContactMechPurposeHibernateImpl();
				newPurpose.setPartyContactMech(newPartyContactMech);
				newPurpose.setContactMechPurpose(purpose.getContactMechPurpose());
				newPurpose.setFromDate(purpose.getFromDate());
				helper.addContactMechPurpose(newPurpose);
			}
		}
		
		partyContactMechDao.save(newPartyContactMech);
		
		return ServiceResult.success("Updated party contact mech.", newPartyContactMech);
	}
    
}
