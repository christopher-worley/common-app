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
package core.data.helper.contact;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import core.data.model.contact.ContactMechPurpose;
import core.data.model.contact.PartyContactMech;
import core.data.model.contact.PartyContactMechPurpose;
import core.data.model.jpa.contact.PartyContactMechPurposeJpaImpl;

public class PartyContactMechHelper
{
    /** party contact mech to help */
    private PartyContactMech partyContactMech;

    /**
     * @param partyContactMech
     */
    public PartyContactMechHelper(PartyContactMech partyContactMech)
    {
        super();
        this.partyContactMech = partyContactMech;
    }
    
    /**
     * Add purpose to partyContactMech
     * @param purpose
     */
    public void addContactMechPurpose(ContactMechPurpose purpose)
    {
        PartyContactMechPurpose partyContactMechPurpose = new PartyContactMechPurposeJpaImpl();
        partyContactMechPurpose.setPartyContactMech(partyContactMech);
        partyContactMechPurpose.setContactMechPurpose(purpose);
        // TOOD: service date
        partyContactMechPurpose.setFromDate(new Date());

        addContactMechPurpose(partyContactMechPurpose);
    }

    /**
     * Add the given <code>PartyContactMechPurpose</code> to
     * the partyContactMech 
     * 
     * @param partyContactMechPurpose
     */
    public void addContactMechPurpose(PartyContactMechPurpose partyContactMechPurpose)
    {
        if (partyContactMech.getPartyContactMechPurposes() == null) 
        {
            partyContactMech.setPartyContactMechPurposes(new ArrayList<PartyContactMechPurpose>());
        }
        partyContactMech.getPartyContactMechPurposes().add(partyContactMechPurpose);
    }

    /**
     * Get list of all ContactMechPurpose objects related to 
     * the party contact mech
     * 
     * @return
     */
    public List<ContactMechPurpose> getContactMechPurposes()
    {
        List<ContactMechPurpose> purposes = new ArrayList<ContactMechPurpose>();
        for (PartyContactMechPurpose purpose : partyContactMech.getPartyContactMechPurposes())
        {
            purposes.add(purpose.getContactMechPurpose());
        }
        return purposes;
    }
    
}
