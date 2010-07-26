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
package core.commonapp.server.dao.security;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import core.commonapp.client.dao.GenericDAO;
import core.commonapp.client.dao.security.UserLoginDAO;
import core.data.hibernate.security.UserLoginHibernateImpl;
import core.data.model.security.UserLogin;

public class UserLoginDAOHibernateImpl extends HibernateDaoSupport implements UserLoginDAO
{
    /** generic dao */
    private GenericDAO genericDAO;

    public UserLoginDAOHibernateImpl()
    {
        super();
        
    }

    
    /**
     * Default constructor
     * @param genericDAO
     * 
     */
    @Autowired
    public UserLoginDAOHibernateImpl(GenericDAO genericDAO)
    {
        super();
        this.genericDAO = genericDAO;
    }

    @Override
    public boolean existByUsername(String username)
    {
        DetachedCriteria criteria = DetachedCriteria.forClass(UserLoginHibernateImpl.class);
        criteria.add(Restrictions.eq("username", username));
        
        return getHibernateTemplate().findByCriteria(criteria).size() > 0;
    }

    @Override
    public Set<UserLogin> findAllLikeUsername(String username)
    {
        DetachedCriteria criteria = DetachedCriteria.forClass(UserLoginHibernateImpl.class);
        criteria.add(Restrictions.like("username", "%" + username + "%"));
        return new HashSet<UserLogin>(getHibernateTemplate().findByCriteria(criteria));
    }

    @Override
    public UserLogin findById(Integer id)
    {
        return (UserLogin) genericDAO.findById(UserLoginHibernateImpl.class, id);
    }

    @Override
    public UserLogin findByUsernameAndPassword(String username, String password)
    {
        DetachedCriteria criteria = DetachedCriteria.forClass(UserLoginHibernateImpl.class);
        criteria.add(Restrictions.eq("username", username));
        criteria.add(Restrictions.eq("password", password));
        List list = getHibernateTemplate().findByCriteria(criteria);
        return list.size() > 0 ? (UserLogin) list.get(0) : null;
    }


    @Override
    public UserLogin save(UserLogin user)
    {
       genericDAO.save(user);
       return user;
    }

}
