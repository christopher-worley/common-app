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
package core.commonapp.server.dao;

import java.util.List;

import org.hibernate.ReplicationMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import core.commonapp.client.dao.GenericDAO;
import core.data.model.DataObject;
import core.tooling.logging.LogFactory;
import core.tooling.logging.Logger;

public class GenericDAOHibernateImpl<T extends DataObject> extends HibernateDaoSupport implements GenericDAO<T>
{

    /** logger for this class */
    Logger logger = LogFactory.getLogger(GenericDAOHibernateImpl.class);
    
    public GenericDAOHibernateImpl()
    {
        super();
    }

    @Override
    public List<T> findAll(Class<? extends T> clazz)
    {
        DetachedCriteria criteria = DetachedCriteria.forClass(clazz);
        return getHibernateTemplate().findByCriteria(criteria);
    }

    @Override
    public Object findByField(Class<? extends T> clazz, String field, Object value)
    {
        DetachedCriteria criteria = DetachedCriteria.forClass(clazz);
        criteria.add(Restrictions.eq(field, value));
        List results = getHibernateTemplate().findByCriteria(criteria);
        if (results.size() < 1) 
        {
            return null;
        } 
        if (results.size() > 1) 
        {
            logger.warn("Multiple records returned when only one is expected (class={0},field={1},value={2}).", clazz.getSimpleName(), field, value);
        }
        return results.get(0); 
    }
    
    @Override
    public Object findById(Class<? extends T> clazz, Integer id)
    {
        return getHibernateTemplate().load(clazz, id);
    }

    @Override
    public void reattach(T data)
    {
        logger.debug("Updating data {0}", data);
        // TODO: reattach, needs to occur on the GWT side
        //data = (T) HibernateUtil.currentSession().merge(data);
        getHibernateTemplate().replicate(data, ReplicationMode.OVERWRITE);
    }

    @SuppressWarnings("unchecked")
    @Override
    public T save(DataObject data)
    {
        logger.debug("Saving data {0}", data);
        getHibernateTemplate().saveOrUpdate(data);
        getHibernateTemplate().flush();
        return (T) data;
    }

    @Override
    public List<? extends T> saveAll(List<? extends T> data)
    {
        logger.debug("Saving data {0}", data);
        getHibernateTemplate().saveOrUpdateAll(data);
        getHibernateTemplate().flush();
        return data;
    }


}
