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

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import core.commonapp.client.dao.contact.PartyContactMechDao;
import core.commonapp.server.dao.BaseDaoJpaImpl;
import core.data.model.contact.PartyContactMech;
import core.tooling.logging.LogFactory;
import core.tooling.logging.Logger;

@Repository
public class PartyContactMechDaoHibernateImpl extends BaseDaoJpaImpl<PartyContactMech> implements PartyContactMechDao
{
    /** logger for this class */
    private Logger log = LogFactory.getLogger(PartyContactMechDaoHibernateImpl.class);

    public PartyContactMechDaoHibernateImpl()
    {
        super();
    }

    @Override
    public Set<PartyContactMech> findByContactMechId(Integer contactMechId)
    {
        log.debug("PartyContactMechDaoHibernateImpl.findByContactMechId({0})", contactMechId);

        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<PartyContactMech> query = builder.createQuery(PartyContactMech.class);
        Root<PartyContactMech> root = query.from(PartyContactMech.class);
        builder.equal(root.get("contactMechId"), contactMechId);
        builder.isNull(root.get("thruDate"));
        
        return (Set<PartyContactMech>) new HashSet(getEntityManager().createQuery(query).getResultList());
    }

	@Override
	public Class<PartyContactMech> getPersistClass() {
		return PartyContactMech.class;
	}

}
