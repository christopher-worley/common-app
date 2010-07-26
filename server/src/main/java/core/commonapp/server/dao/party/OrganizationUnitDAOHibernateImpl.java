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
package core.commonapp.server.dao.party;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import core.commonapp.client.dao.GenericDAO;
import core.commonapp.client.dao.party.OrganizationUnitDAO;
import core.data.hibernate.party.OrganizationUnitHibernateImpl;
import core.data.model.party.OrganizationUnit;

public class OrganizationUnitDAOHibernateImpl extends HibernateDaoSupport implements OrganizationUnitDAO
{
    @Autowired
    private GenericDAO<OrganizationUnit> genericDAO;

    @Override
    @Transactional
    public OrganizationUnit save(OrganizationUnit unit)
    {
        return genericDAO.save(unit);
    }

    @Override
    public List<OrganizationUnit> findAll()
    {
        return genericDAO.findAll(OrganizationUnitHibernateImpl.class);
    }

    @Override
    public OrganizationUnit findById(Integer id)
    {
        return (OrganizationUnit) genericDAO.findById(OrganizationUnitHibernateImpl.class, id);
    }

}
