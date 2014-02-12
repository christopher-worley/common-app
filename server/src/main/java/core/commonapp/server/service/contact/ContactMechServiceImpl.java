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
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import core.commonapp.client.dao.contact.ContactMechPurposeDao;
import core.commonapp.client.dao.contact.ContactMechTypeDao;
import core.commonapp.client.dao.contact.PartyContactMechDao;
import core.commonapp.client.service.contact.ContactMechService;
import core.data.helper.contact.PartyContactMechHelper;
import core.data.hibernate.contact.EmailAddressHibernateImpl;
import core.data.hibernate.contact.PartyContactMechHibernateImpl;
import core.data.hibernate.contact.PartyContactMechPurposeHibernateImpl;
import core.data.model.contact.ContactMechPurpose;
import core.data.model.contact.EmailAddress;
import core.data.model.contact.PartyContactMech;
import core.data.model.contact.PartyContactMechPurpose;
import core.service.result.ServiceResult;

public class ContactMechServiceImpl implements ContactMechService
{
    /** contact mech purpose dao */
    private ContactMechPurposeDao contactMechPurposeDao;

    /** contact mech type dao */
    private ContactMechTypeDao contactMechTypeDao;
    
    /** party contact mech dao */
    private PartyContactMechDao partyContactMechDao;
    
    public ContactMechServiceImpl()
    {
        super();
        
    }
    
    /**
     * Default constructor
     * 
     * @param contactMechPurposeDao
     * @param contactMechTypeDao
     */
    @Autowired
    public ContactMechServiceImpl(ContactMechPurposeDao contactMechPurposeDao, ContactMechTypeDao contactMechTypeDao, PartyContactMechDao partyContactMechDao)
    {
        super();
        this.contactMechPurposeDao = contactMechPurposeDao;
        this.contactMechTypeDao = contactMechTypeDao;
        this.partyContactMechDao = partyContactMechDao;
    }

    @Override
    public ServiceResult findAllContactMechPurposes()
    {
        return new ServiceResult(contactMechPurposeDao.findAll());
    }

    @Override
    public ServiceResult findAllContactMechTypes()
    {
        return new ServiceResult(contactMechTypeDao.findAll());
    }

    @Override
    @Deprecated
    public ServiceResult updateEmailAddress(EmailAddress emailAddress, Set<ContactMechPurpose> purposes)
    {
        // TODO: service timestamp
        Date currentDate = new Date();
        
        EmailAddress newEmailAddress = new EmailAddressHibernateImpl();
        newEmailAddress.setEmailAddress(emailAddress.getEmailAddress());

        // expire old and create new PartyContactMech objects
        Set<PartyContactMech> partyContactMechs = partyContactMechDao.findByContactMechId(emailAddress.getContactMechId());
        Set<PartyContactMech> newPartyContactMechs = new HashSet();
        for (PartyContactMech partyContactMech : partyContactMechs)
        {
            // expire old
            partyContactMech.setThruDate(currentDate);
            partyContactMechDao.save(partyContactMech);
            
            // new party contact mech
            PartyContactMech newPartyContactMech = new PartyContactMechHibernateImpl();
            newPartyContactMech.setContactMech(newEmailAddress);
            newPartyContactMech.setParty(partyContactMech.getParty());
            newPartyContactMech.setFromDate(currentDate);
            for (ContactMechPurpose purpose : purposes)
            {
                PartyContactMechPurpose newPurpose = new PartyContactMechPurposeHibernateImpl();
                newPurpose.setContactMechPurpose(purpose);
                newPurpose.setFromDate(currentDate);
                PartyContactMechHelper helper = new PartyContactMechHelper(newPartyContactMech);
                helper.addContactMechPurpose(purpose);
            }
            //save new
            partyContactMechDao.save(newPartyContactMech);
        }
        
        return ServiceResult.success("Email address updated successfully", newEmailAddress);
    }

}
