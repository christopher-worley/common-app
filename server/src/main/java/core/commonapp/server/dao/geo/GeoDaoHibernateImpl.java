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
package core.commonapp.server.dao.geo;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import core.commonapp.client.dao.geo.GeoDao;
import core.commonapp.server.dao.BaseDaoJpaImpl;
import core.data.model.geo.Geo;
import core.data.model.geo.GeoType;

@Repository
public class GeoDaoHibernateImpl extends BaseDaoJpaImpl<Geo> implements GeoDao
{

    public GeoDaoHibernateImpl()
    {
        super();
    }

    @Override
    public List<Geo> findByGeoType(GeoType type)
    {
    	CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
    	CriteriaQuery query = builder.createQuery(Geo.class);
    	
    	Root<Geo> root = query.from(Geo.class);
    	builder.equal(root.get("geoType"), type);
    	return getEntityManager().createQuery(query).getResultList();
    }

	@Override
	public Class<Geo> getPersistClass() {
		return Geo.class;
	}

}
