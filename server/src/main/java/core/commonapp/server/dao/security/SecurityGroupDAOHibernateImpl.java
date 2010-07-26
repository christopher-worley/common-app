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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import core.commonapp.client.dao.GenericDAO;
import core.commonapp.client.dao.security.SecurityGroupDAO;
import core.data.hibernate.security.SecurityGroupHibernateImpl;
import core.data.model.security.SecurityGroup;
import core.data.model.security.UserLogin;
import core.tooling.logging.LogFactory;
import core.tooling.logging.Logger;

public class SecurityGroupDAOHibernateImpl extends HibernateDaoSupport implements SecurityGroupDAO
{
    
    /** logger for this class */
    private Logger logger = LogFactory.getLogger(SecurityGroupDAOHibernateImpl.class);
    
    @Autowired
    private GenericDAO genericDAO;

    @Override
    @Transactional
    public List<SecurityGroup> findAll()
    {
        DetachedCriteria criteria = DetachedCriteria.forClass(SecurityGroupHibernateImpl.class);
        
        criteria.setFetchMode("userLoginSecurityGroups", FetchMode.SELECT);
        criteria.setFetchMode("permissionSecurityGroups", FetchMode.SELECT);
        
        final List<SecurityGroup> securityGroups = getHibernateTemplate().findByCriteria(criteria);
        
        for (SecurityGroup securityGroup : securityGroups)
        {
            securityGroup.getPermissionSecurityGroups().size();
            securityGroup.getUserLoginSecurityGroups().size();
        }
        
        return securityGroups == null ? new ArrayList<SecurityGroup>(0) : securityGroups;
    }

    @Override
    @Transactional
    public Set<SecurityGroup> findAllByUserLogin(UserLogin userLogin)
    {
        DetachedCriteria criteria = DetachedCriteria.forClass(SecurityGroupHibernateImpl.class);
        DetachedCriteria userLoginCriteria = criteria.createCriteria("userLoginSecurityGroups");
        userLoginCriteria.add(Restrictions.eq("userLogin.userLoginId", userLogin.getUserLoginId()));
        userLoginCriteria.add(Restrictions.isNull("thruDate"));
        
        criteria.setFetchMode("userLoginSecurityGroups", FetchMode.SELECT);
        criteria.setFetchMode("permissionSecurityGroups", FetchMode.SELECT);
        
        final Set<SecurityGroup> securityGroups = new HashSet(getHibernateTemplate().findByCriteria(criteria));
        
        for (SecurityGroup securityGroup : securityGroups)
        {
            securityGroup.getPermissionSecurityGroups().size();
            securityGroup.getUserLoginSecurityGroups().size();
        }
        
        return securityGroups == null ? new HashSet<SecurityGroup>(0) : securityGroups;
    }

    @Override
    public SecurityGroup findById(Integer securityGroupId)
    {
        return (SecurityGroup) genericDAO.findById(SecurityGroupHibernateImpl.class, securityGroupId);
    }

}
