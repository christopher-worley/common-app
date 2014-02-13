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

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import core.commonapp.client.dao.security.UserLoginSecurityGroupDao;
import core.commonapp.server.dao.BaseDaoJpaImpl;
import core.data.hibernate.security.UserLoginSecurityGroupHibernateImpl;
import core.data.model.security.PermissionSecurityGroup;
import core.data.model.security.SecurityGroup;
import core.data.model.security.UserLogin;
import core.data.model.security.UserLoginSecurityGroup;

@Repository
public class UserLoginSecurityGroupDaoHibernateImpl extends BaseDaoJpaImpl<UserLoginSecurityGroup> implements UserLoginSecurityGroupDao
{

    @Override
    public List<UserLoginSecurityGroup> findBySecurityGroup(SecurityGroup securityGroup, boolean includeOld)
    {
    	CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
    	CriteriaQuery<UserLoginSecurityGroup> query = builder.createQuery(getPersistClass());
    	Root<UserLoginSecurityGroup> root = query.from(getPersistClass());
    	query.where(builder.equal(root.get("securityGroup"), securityGroup));
    	
        if (!includeOld) 
        {
            query.where(builder.isNull(root.get("thruDate")));
        }

        return (List<UserLoginSecurityGroup>) getEntityManager().createQuery(query).getResultList();
    }

    @Override
    public List<UserLoginSecurityGroup> findByUserLoginAndSecurityGroup(UserLogin userLogin, SecurityGroup securityGroup, boolean includeOld)
    {
    	CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
    	CriteriaQuery<UserLoginSecurityGroup> query = builder.createQuery(getPersistClass());
    	Root<UserLoginSecurityGroup> root = query.from(getPersistClass());
    	query.where(
    			builder.equal(root.get("securityGroup"), securityGroup),
    			builder.equal(root.get("userLogin"), userLogin),
    			(includeOld 
    					? builder.isNotNull(root.get("thruDate")) 
    							: builder.isNull(root.get("thruDate"))
    			)
    		);
    	
        return (List<UserLoginSecurityGroup>) getEntityManager().createQuery(query).getResultList();
    }

	@Override
	public Class<UserLoginSecurityGroup> getPersistClass() {
		return UserLoginSecurityGroup.class;
	}

}
