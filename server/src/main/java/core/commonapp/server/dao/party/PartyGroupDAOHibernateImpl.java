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
package core.commonapp.server.dao.party;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import core.commonapp.client.dao.GenericDAO;
import core.commonapp.client.dao.party.PartyGroupDAO;
import core.data.hibernate.party.PartyGroupHibernateImpl;
import core.data.model.party.PartyGroup;

public class PartyGroupDAOHibernateImpl extends HibernateDaoSupport implements PartyGroupDAO
{
    @Autowired
    private GenericDAO genericDAO;

    @Override
    public PartyGroup findById(Integer partyGroupId)
    {
        return (PartyGroup) genericDAO.findById(PartyGroupHibernateImpl.class, partyGroupId);
    }

    @Override
    public PartyGroup findById(Integer partyGroupId, boolean includeFromRelationships, boolean includeToRelationships,boolean includeContactMechs )
    {
        PartyGroup partyGroup = (PartyGroup) genericDAO.findByField(PartyGroupHibernateImpl.class, "partyId", partyGroupId);
        
        if (includeFromRelationships)
        {
            partyGroup.getPartyFromRelationships().size();
        }
        
        if (includeToRelationships)
        {
            partyGroup.getPartyToRelationships().size();
        }
        
        if (includeContactMechs)
        {
            partyGroup.getPartyContactMechs().size();
        }
        
        return partyGroup;
    }

    @Override
    public PartyGroup save(PartyGroup partyGroup)
    {
        return (PartyGroup) genericDAO.save(partyGroup);
    }

}
