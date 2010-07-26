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

import core.commonapp.client.dao.GenericDAO;
import core.commonapp.client.dao.party.PartyTypeDAO;
import core.commonapp.client.dao.party.RoleTypeDAO;
import core.commonapp.client.service.party.PartyService;
import core.data.model.party.Party;
import core.service.result.ServiceResult;

public class PartyServiceImpl implements PartyService
{
    
    /** party type dao */
    @Autowired
    private PartyTypeDAO partyTypeDAO;

    /** role type dao */
    @Autowired
    private RoleTypeDAO roleTypeDAO;
    
    /** generic dao */
    @Autowired
    private GenericDAO genericDAO;

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
        return new ServiceResult(partyTypeDAO.findAll());
    }

    @Override
    public ServiceResult findAllRoleTypes()
    {
        return new ServiceResult(roleTypeDAO.findAll());
    }

    @Override
    public ServiceResult<Party> updateParty(Party party)
    {
        return ServiceResult.success("Successfully updated party.", genericDAO.save(party));
    }

}
