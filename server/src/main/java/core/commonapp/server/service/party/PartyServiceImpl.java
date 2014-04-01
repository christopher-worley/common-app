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

import org.springframework.beans.factory.annotation.Autowired;

import core.commonapp.client.dao.party.PartyDao;
import core.commonapp.client.dao.party.PartyTypeDao;
import core.commonapp.client.dao.party.RoleTypeDao;
import core.commonapp.client.service.party.PartyService;
import core.data.model.party.Party;
import core.service.result.ServiceResult;

public class PartyServiceImpl implements PartyService
{
	/** party dao */
	@Autowired
	private PartyDao partyDao;
    
    /** party type dao */
    @Autowired
    private PartyTypeDao partyTypeDao;

    /** role type dao */
    @Autowired
    private RoleTypeDao roleTypeDao;


    /**
     * Default constructor
     * 
     */
    public PartyServiceImpl()
    {
        super();
    }

    @Override
    public ServiceResult findAllPartyTypes()
    {
        return new ServiceResult(partyTypeDao.findAll());
    }

    @Override
    public ServiceResult findAllRoleTypes()
    {
        return new ServiceResult(roleTypeDao.findAll());
    }

    @Override
    public ServiceResult<Party> updateParty(Party party)
    {
        return ServiceResult.success("Successfully updated party.", partyDao.save(party));
    }

}
