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

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import core.commonapp.client.dao.security.SecurityGroupDao;
import core.commonapp.server.dao.BaseDaoJpaImpl;
import core.data.model.security.SecurityGroup;
import core.data.model.security.UserLogin;
import core.data.model.security.UserLoginSecurityGroup;
import core.tooling.logging.LogFactory;
import core.tooling.logging.Logger;

@Repository
public class SecurityGroupDaoHibernateImpl extends BaseDaoJpaImpl<SecurityGroup> implements SecurityGroupDao
{
    
    /** logger for this class */
    private Logger logger = LogFactory.getLogger(SecurityGroupDaoHibernateImpl.class);

    @Override
    @Transactional
    public List<SecurityGroup> findAll()
    {
    	CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
    	CriteriaQuery<SecurityGroup> query = builder.createQuery(SecurityGroup.class);
    	
    	List<SecurityGroup> securityGroups = getEntityManager().createQuery(query).getResultList();
    	
//        criteria.setFetchMode("userLoginSecurityGroups", FetchMode.SELECT);
//        criteria.setFetchMode("permissionSecurityGroups", FetchMode.SELECT);
        
        for (SecurityGroup securityGroup : securityGroups)
        {
            securityGroup.getPermissionSecurityGroups().size();
            securityGroup.getUserLoginSecurityGroups().size();
        }
        
        return securityGroups;
    }

    @Override
    @Transactional
    public Set<SecurityGroup> findAllByUserLogin(UserLogin userLogin)
    {
    	CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
    	CriteriaQuery<SecurityGroup> query = builder.createQuery(SecurityGroup.class);
    	
    	Root<SecurityGroup> root = query.from(SecurityGroup.class);
    	Join<SecurityGroup, UserLoginSecurityGroup> join = root.join("userLoginSecurityGroup");
    	
    	builder.equal(join.get("userLogin.userLoginId"), userLogin.getUserLoginId());
    	builder.isNull(join.get("thruDate"));
        
//        criteria.setFetchMode("userLoginSecurityGroups", FetchMode.SELECT);
//        criteria.setFetchMode("permissionSecurityGroups", FetchMode.SELECT);
        
        Set<SecurityGroup> securityGroups = new HashSet<SecurityGroup>(getEntityManager().createQuery(query).getResultList());
        
        for (SecurityGroup securityGroup : securityGroups)
        {
            securityGroup.getPermissionSecurityGroups().size();
            securityGroup.getUserLoginSecurityGroups().size();
        }
        
        return securityGroups;
    }

	@Override
	public Class<SecurityGroup> getPersistClass() {
		return SecurityGroup.class;
	}

}
