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
package core.commonapp.server.dao.contact;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import core.commonapp.client.dao.GenericDAO;
import core.commonapp.client.dao.contact.PartyContactMechDAO;
import core.data.hibernate.contact.PartyContactMechHibernateImpl;
import core.data.model.contact.PartyContactMech;
import core.tooling.logging.LogFactory;
import core.tooling.logging.Logger;

public class PartyContactMechDAOHibernateImpl extends HibernateDaoSupport implements PartyContactMechDAO
{
    /** logger for this class */
    private Logger log = LogFactory.getLogger(PartyContactMechDAOHibernateImpl.class);

    /** generic dao */
    private GenericDAO genericDAO;

    public PartyContactMechDAOHibernateImpl()
    {
        super();
        
    }

    
    @Autowired
    public PartyContactMechDAOHibernateImpl(GenericDAO genericDAO)
    {
        super();
        this.genericDAO = genericDAO;
    }

    @Override
    public Set<PartyContactMech> findByContactMechId(Integer contactMechId)
    {
        log.debug("PartyContactMechDAOHibernateImpl.findByContactMechId({0})", contactMechId);

        DetachedCriteria criteria = DetachedCriteria.forClass(PartyContactMech.class);
        criteria.add(Restrictions.eq("contactMechId", contactMechId));
        criteria.add(Restrictions.isNull("thruDate"));
        return (Set<PartyContactMech>) new HashSet(getHibernateTemplate().findByCriteria(criteria));
    }

    @Override
    public PartyContactMech findById(Integer id)
    {
        return (PartyContactMech) genericDAO.findById(PartyContactMechHibernateImpl.class, id);
    }

    @Override
    public PartyContactMech save(PartyContactMech partyContactMech)
    {
        genericDAO.save(partyContactMech);
        
        return partyContactMech;
    }

}
