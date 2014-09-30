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

import core.data.model.contact.ContactMech;
import core.data.model.contact.PartyContactMech;
import core.service.annotation.InformationBean;
import core.service.annotation.Service;
import core.service.result.ServiceResult;

@InformationBean(beanName="partyContactMechService")
@Service
public interface PartyContactMechService
{

    
    /**
     * Expire <code>PartyContactMech</code> relationship 
     * 
     * @param partyContactMech
     * @return
     */
    public ServiceResult<PartyContactMech> expirePartyContactMech(PartyContactMech partyContactMech);

    /**
     * Update a party's <code>ContactMech</code> by creating a
     * new <code>PartyContactMech</code> relationship to the new
     * <code>ContactMech</code> and expire the current relationship.
     * 
     * @param partyContactMech Relationship to be expired
     * @param contactMech The <code>ContactMech</code> to update to
     * @return the newly created <code>PartyContactMech</code>
     */
	public ServiceResult<PartyContactMech> updatePartyContactMech(
			PartyContactMech partyContactMech, ContactMech contactMech);

}
