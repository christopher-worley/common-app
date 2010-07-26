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

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import core.commonapp.client.dao.security.PermissionSecurityGroupDAO;
import core.data.hibernate.security.PermissionSecurityGroupHibernateImpl;
import core.data.model.security.PermissionSecurityGroup;
import core.data.model.security.SecurityGroup;

public class PermissionSecurityGroupDAOHibernateImpl extends HibernateDaoSupport implements PermissionSecurityGroupDAO
{

    @Override
    public List<PermissionSecurityGroup> findAllBySecurityGroup(SecurityGroup securityGroup, boolean includeOld)
    {
        DetachedCriteria criteria = DetachedCriteria.forClass(PermissionSecurityGroupHibernateImpl.class);
        criteria.add(Restrictions.eq("securityGroup", securityGroup));
        if (!includeOld) 
        {
            criteria.add(Restrictions.isNull("thruDate"));
        }

        return (List<PermissionSecurityGroup>) getHibernateTemplate().findByCriteria(criteria);
    }

}
