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

import core.commonapp.client.dao.security.PermissionSecurityGroupDao;
import core.commonapp.server.dao.BaseDaoJpaImpl;
import core.data.model.security.PermissionSecurityGroup;
import core.data.model.security.SecurityGroup;

@Repository
public class PermissionSecurityGroupDaoHibernateImpl extends BaseDaoJpaImpl<PermissionSecurityGroup> implements PermissionSecurityGroupDao
{

    @Override
    public List<PermissionSecurityGroup> findAllBySecurityGroup(SecurityGroup securityGroup, boolean includeOld)
    {
    	CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
    	CriteriaQuery<PermissionSecurityGroup> query = builder.createQuery(getPersistClass());
    	Root<PermissionSecurityGroup> root = query.from(getPersistClass());
    	query.where(builder.equal(root.get("securityGroup"), securityGroup));
    	
        if (!includeOld) 
        {
            query.where(builder.isNull(root.get("thruDate")));
        }

        return (List<PermissionSecurityGroup>) getEntityManager().createQuery(query).getResultList();
    }

	@Override
	public Class<PermissionSecurityGroup> getPersistClass() {
		return PermissionSecurityGroup.class;
	}

}
