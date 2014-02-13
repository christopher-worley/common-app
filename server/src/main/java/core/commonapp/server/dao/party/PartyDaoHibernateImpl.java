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

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import core.commonapp.client.dao.party.PartyDao;
import core.commonapp.server.dao.BaseDaoJpaImpl;
import core.data.model.contact.PartyContactMech;
import core.data.model.party.Party;


@Repository
public class PartyDaoHibernateImpl extends BaseDaoJpaImpl<Party> implements PartyDao
{

    /**
     * 
     */
    public PartyDaoHibernateImpl()
    {
        super();
    }

    @Override
    @Transactional
    public Party findById(Integer id)
    {
        return findById(id, false, false, false, false);
    }

    @Override
    @Transactional
    public Party findById(Integer id, boolean loadPartyType, boolean loadPartyContactMechs, boolean loadPartyFromRelationships, boolean loadPartyToRelationships)
    {
        Party party = findById(id);
        PartyDaoHibernateImpl.lazyLoad(party, loadPartyType, loadPartyContactMechs, loadPartyFromRelationships, loadPartyToRelationships);
        return party;
    }


    /**
     * Lazy load relationships on party objects
     *
     * @param party
     * @param loadPartyType
     * @param loadPartyContactMechs
     * @param loadPartyFromRelationships
     * @param loadPartyToRelationships
     */
    @Transactional
    public static void lazyLoad(Party party, boolean loadPartyType, boolean loadPartyContactMechs, boolean loadPartyFromRelationships, boolean loadPartyToRelationships)
    {
        // party type
        if (loadPartyType)
        {
            party.getPartyType().getId();
        }
        // party contact mechs
        if (loadPartyContactMechs)
        {
            for (PartyContactMech partyContactMech : party.getPartyContactMechs())
            {
                partyContactMech.getContactMech().getContactMechType().getId();
                partyContactMech.getPartyContactMechPurposes().size();
            }
        }
    }
    
    /**
     * Lazy load relationships on party objects
     * 
     * @param parties
     * @param loadPartyType
     * @param loadPartyContactMechs
     * @param loadPartyFromRelationships
     * @param loadPartyToRelationships
     */
    @Transactional
    public static void lazyLoad(List<Party> parties, boolean loadPartyType, boolean loadPartyContactMechs, boolean loadPartyFromRelationships, boolean loadPartyToRelationships)
    {
        // lazy load relationships
        for (Party party : parties)
        {
            lazyLoad(party, loadPartyType, loadPartyContactMechs, loadPartyFromRelationships, loadPartyToRelationships);
        }
    }

	@Override
	public Class<Party> getPersistClass() {
		return Party.class;
	}

}
