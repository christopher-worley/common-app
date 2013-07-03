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
package core.commonapp.client.service.contact;

import java.sql.Timestamp;

import core.data.model.contact.ContactMech;
import core.data.model.contact.ContactMechPurpose;
import core.data.model.contact.PartyContactMech;
import core.data.model.contact.PartyContactMechPurpose;
import core.data.model.party.Party;
import core.service.annotation.InformationBean;
import core.service.annotation.Service;
import core.service.result.ServiceResult;

@InformationBean(beanName="createPartyContactMechService")
@Service
public interface CreatePartyContactMechService
{

    /**
     * Create, persist and return a PartyContactMech object
     * 
     * @param party
     * @param contactMech
     * @return
     */
    public ServiceResult<PartyContactMech> createPartyContactMech(Party party, ContactMech contactMech, Timestamp fromDate);
    

    /**
     * Create, persist and return a PartyContactMechPurpose object
     * 
     * @param partyContactMech
     * @param contactMechPurposeType
     * @return
     */
    public ServiceResult<PartyContactMechPurpose> createPartyContactMechPurpose(PartyContactMech partyContactMech, ContactMechPurpose contactMechPurposeType, Timestamp fromDate);
}
