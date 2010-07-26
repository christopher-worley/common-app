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
package core.commonapp.server.dao.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import core.commonapp.client.dao.GenericDAO;
import core.commonapp.client.dao.task.TaskRelationshipTypeDAO;
import core.data.hibernate.task.TaskRelationshipTypeHibernateImpl;
import core.data.model.task.TaskRelationshipType;

public class TaskRelationshipTypeDAOHibernateImpl extends HibernateDaoSupport implements TaskRelationshipTypeDAO
{
    /** Generic dao */
    private GenericDAO genericDAO;

    public TaskRelationshipTypeDAOHibernateImpl()
    {
        super();
        
    }
    
    
    /**
     * Default constructor
     * 
     * @param genericDAO
     */
    @Autowired
    public TaskRelationshipTypeDAOHibernateImpl(GenericDAO genericDAO)
    {
        super();
        this.genericDAO = genericDAO;
    }


    @Override
    public TaskRelationshipType findById(Integer id)
    {
        return (TaskRelationshipType) genericDAO.findById(TaskRelationshipTypeHibernateImpl.class, id);
    }

    @Override
    public TaskRelationshipType save(TaskRelationshipTypeHibernateImpl taskRelationshipType)
    {
        genericDAO.save(taskRelationshipType);
        
        return taskRelationshipType;
    }
}
