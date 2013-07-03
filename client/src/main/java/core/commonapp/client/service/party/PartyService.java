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
package core.commonapp.client.service.party;

import core.data.model.party.Party;
import core.service.annotation.InformationBean;
import core.service.annotation.Service;
import core.service.result.ServiceResult;

@InformationBean(beanName="partyService")
@Service
public interface PartyService
{

    /**
     * find all party types
     * 
     * Service result payload
     *          0 - <code>List</code> of <code>PartyType</code>s
     * 
     * @return
     */
    public ServiceResult findAllPartyTypes();
    
    /**
     * find all role types
     * 
     * Service result payload
     *          0 - <code>List</code> of <code>RoleType</code>s
     * 
     * @return
     */
    public ServiceResult findAllRoleTypes();
    
    /**
     * 
     * @param party
     * @return
     */
    public ServiceResult<Party> updateParty(Party party);
}
