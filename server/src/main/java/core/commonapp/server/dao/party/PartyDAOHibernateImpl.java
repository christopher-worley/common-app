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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import core.commonapp.client.dao.GenericDAO;
import core.commonapp.client.dao.party.PartyDAO;
import core.data.hibernate.party.PartyHibernateImpl;
import core.data.model.contact.PartyContactMech;
import core.data.model.party.Party;


public class PartyDAOHibernateImpl extends HibernateDaoSupport implements PartyDAO
{
    /** generic dao */
    private GenericDAO genericDAO;

    /**
     * 
     */
    public PartyDAOHibernateImpl()
    {
        super();
    }
    
    /**
     * 
     * @param genericDAO
     */
    @Autowired
    public PartyDAOHibernateImpl(GenericDAO genericDAO)
    {
        super();
        this.genericDAO = genericDAO;
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
        Party party = (Party) genericDAO.findById(PartyHibernateImpl.class, id);
        PartyDAOHibernateImpl.lazyLoad(party, loadPartyType, loadPartyContactMechs, loadPartyFromRelationships, loadPartyToRelationships);
        return party;
    }

    @Override
    @Transactional
    public Party save(Party party)
    {
        genericDAO.save(party);
        
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

}
