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
import core.commonapp.client.dao.party.PartyRoleDAO;
import core.data.hibernate.party.PartyRoleHibernateImpl;
import core.data.model.party.PartyRole;

public class PartyRoleDAOHibernateImpl extends HibernateDaoSupport implements PartyRoleDAO
{
    /** generic dao */
    private GenericDAO genericDAO;

    public PartyRoleDAOHibernateImpl()
    {
        super();
        
    }

    @Autowired
    public PartyRoleDAOHibernateImpl(GenericDAO genericDAO)
    {
        super();
        this.genericDAO = genericDAO;
    }

    @Override
    public PartyRole findById(Integer id)
    {
        return (PartyRole) genericDAO.findById(PartyRoleHibernateImpl.class, id);
    }

    @Override
    public PartyRole save(PartyRole partyRole)
    {
        genericDAO.save(partyRole);
        
        return partyRole;
    }

}
