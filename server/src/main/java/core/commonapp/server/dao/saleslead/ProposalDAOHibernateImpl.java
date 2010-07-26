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
import core.commonapp.client.dao.saleslead.ProposalDAO;
import core.data.model.saleslead.Proposal;

public class ProposalDAOHibernateImpl extends HibernateDaoSupport implements ProposalDAO
{
    
    /** generic dao  */
    private GenericDAO<Proposal> genericDAO;

    public ProposalDAOHibernateImpl()
    {
        super();
        
    }

    /**
     * Default constructor
     * 
     * @param genericDAO
     */
    @Autowired
    public ProposalDAOHibernateImpl(GenericDAO<Proposal> genericDAO)
    {
        super();
        this.genericDAO = genericDAO;
    }

    @Override
    public Proposal findById(Integer id)
    {
        return (Proposal) genericDAO.findById(Proposal.class, id);
    }

    @Override
    public Proposal save(Proposal proposal)
    {
        return genericDAO.save(proposal);
    }

}
