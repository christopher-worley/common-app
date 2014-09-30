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

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import core.commonapp.client.dao.security.UserLoginDao;
import core.commonapp.server.dao.BaseDaoJpaImpl;
import core.data.model.security.UserLogin;

@Repository
public class UserLoginDaoHibernateImpl extends BaseDaoJpaImpl<UserLogin> implements UserLoginDao
{
    
    public UserLoginDaoHibernateImpl()
    {
        super();       
    }


    @Override
    public boolean existByUsername(String username)
    {
    	CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
    	CriteriaQuery<UserLogin> query = builder.createQuery(UserLogin.class);
    	
    	Root<UserLogin> root = query.from(UserLogin.class);
    	
    	query.where( builder.equal(root.get("username"), username) );
    	
        return getEntityManager().createQuery(query).getResultList().size() > 0;
    }

    @Override
    public List<UserLogin> findAllLikeUsername(String username)
    {
    	CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
    	CriteriaQuery<UserLogin> query = builder.createQuery(UserLogin.class);
    	
    	Root<UserLogin> root = query.from(UserLogin.class);
    	
    	query.where( builder.like(root.<String>get("username"), "%" + username + "%") );
    	
        return getEntityManager().createQuery(query).getResultList();
    }


    @Override
    public UserLogin findByUsernameAndPassword(String username, String password)
    {
    	CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
    	CriteriaQuery<UserLogin> query = builder.createQuery(UserLogin.class);
    	
    	Root<UserLogin> root = query.from(UserLogin.class);
    	
    	query.where( 
    			builder.equal(root.get("username"), username),
    			builder.equal(root.get("password"), password)
    		);
    	
        return getEntityManager().createQuery(query).getSingleResult();
    }


	@Override
	public Class<UserLogin> getPersistClass() {
		return UserLogin.class;
	}

}
