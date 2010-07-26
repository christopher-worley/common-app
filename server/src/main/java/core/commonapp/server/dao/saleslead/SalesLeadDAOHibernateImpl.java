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
package core.commonapp.server.dao.saleslead;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import core.commonapp.client.dao.GenericDAO;
import core.commonapp.client.dao.saleslead.SalesLeadDAO;
import core.data.hibernate.saleslead.SalesLeadHibernateImpl;
import core.data.model.saleslead.SalesLead;

public class SalesLeadDAOHibernateImpl extends HibernateDaoSupport implements SalesLeadDAO
{
    /** generic dao */
    private GenericDAO genericDAO;

    public SalesLeadDAOHibernateImpl()
    {
        super();
        
    }

    /**
     * Default constructor
     * 
     * @param genericDAO
     */
    @Autowired
    public SalesLeadDAOHibernateImpl(GenericDAO genericDAO)
    {
        super();
        this.genericDAO = genericDAO;
    }

    @Override
    public SalesLead findById(Integer id)
    {
        return (SalesLead) genericDAO.findById(SalesLeadHibernateImpl.class, id);
    }

    @Override
    public SalesLead save(SalesLead salesLead)
    {
        return (SalesLead) genericDAO.save(salesLead);
    }

}
