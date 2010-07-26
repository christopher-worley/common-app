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

import core.commonapp.client.dao.contact.ContactMechPurposeDAO;
import core.commonapp.client.dao.contact.ContactMechTypeDAO;
import core.commonapp.client.dao.contact.PartyContactMechDAO;
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
    private ContactMechPurposeDAO contactMechPurposeDAO;

    /** contact mech type dao */
    private ContactMechTypeDAO contactMechTypeDAO;
    
    /** party contact mech dao */
    private PartyContactMechDAO partyContactMechDAO;
    
    public ContactMechServiceImpl()
    {
        super();
        
    }
    
    /**
     * Default constructor
     * 
     * @param contactMechPurposeDAO
     * @param contactMechTypeDAO
     */
    @Autowired
    public ContactMechServiceImpl(ContactMechPurposeDAO contactMechPurposeDAO, ContactMechTypeDAO contactMechTypeDAO, PartyContactMechDAO partyContactMechDAO)
    {
        super();
        this.contactMechPurposeDAO = contactMechPurposeDAO;
        this.contactMechTypeDAO = contactMechTypeDAO;
        this.partyContactMechDAO = partyContactMechDAO;
    }

    @Override
    public ServiceResult findAllContactMechPurposes()
    {
        return new ServiceResult(contactMechPurposeDAO.findAll());
    }

    @Override
    public ServiceResult findAllContactMechTypes()
    {
        return new ServiceResult(contactMechTypeDAO.findAll());
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
        Set<PartyContactMech> partyContactMechs = partyContactMechDAO.findByContactMechId(emailAddress.getContactMechId());
        Set<PartyContactMech> newPartyContactMechs = new HashSet();
        for (PartyContactMech partyContactMech : partyContactMechs)
        {
            // expire old
            partyContactMech.setThruDate(currentDate);
            partyContactMechDAO.save(partyContactMech);
            
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
            partyContactMechDAO.save(newPartyContactMech);
        }
        
        return ServiceResult.success("Email address updated successfully", newEmailAddress);
    }

}
