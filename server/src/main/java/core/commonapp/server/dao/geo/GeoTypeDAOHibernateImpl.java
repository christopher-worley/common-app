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

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import core.commonapp.client.dao.geo.GeoTypeDAO;
import core.data.hibernate.geo.GeoTypeHibernateImpl;

public class GeoTypeDAOHibernateImpl extends HibernateDaoSupport implements GeoTypeDAO
{

    public GeoTypeDAOHibernateImpl()
    {
        super();
        
    }

    @Override
    public List<GeoTypeDAO> findAll()
    {
        DetachedCriteria criteria = DetachedCriteria.forClass(GeoTypeHibernateImpl.class);
        return getHibernateTemplate().findByCriteria(criteria);
    }

}
