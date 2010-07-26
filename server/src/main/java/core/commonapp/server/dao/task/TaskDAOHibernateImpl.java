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


import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import core.commonapp.client.dao.GenericDAO;
import core.commonapp.client.dao.task.TaskDAO;
import core.data.hibernate.task.TaskHibernateImpl;
import core.data.model.party.Person;
import core.data.model.task.Task;
import core.data.model.task.TaskType;

public class TaskDAOHibernateImpl extends HibernateDaoSupport implements TaskDAO
{
    /** generic dao */
    private GenericDAO genericDAO;

    public TaskDAOHibernateImpl()
    {
        super();
        
    }
    
    /**
     * Default constructor
     * 
     * @param genericDAO
     */
    @Autowired
    public TaskDAOHibernateImpl(GenericDAO genericDAO)
    {
        super();
        this.genericDAO = genericDAO;
    }

    @Override
    public List<Task> findAll(int max, int offset, List<Person> pepole, String subject, List<TaskType> taskTypes)
    {
        DetachedCriteria criteria = DetachedCriteria.forClass(TaskHibernateImpl.class);
        
        final List<Task> tasks = getHibernateTemplate().findByCriteria(criteria, offset, max);

        for (Task task : tasks)
        {
            task.getTaskStatus().size();
        }
        
        return tasks;
    }

    @Override
    @Transactional
    public Task findById(Integer id)
    {
        DetachedCriteria criteria = DetachedCriteria.forClass(TaskHibernateImpl.class);
        criteria.add(Restrictions.eq("taskId", id));
        
        final List<Task> tasks = getHibernateTemplate().findByCriteria(criteria);
        if (tasks.size() < 1)
        {
            return null;
        }
        Task task = tasks.get(0);
        
        // TODO: add boolean
        task.getTaskStatus().size();
        
        return task;
    }

    @Override
    @Transactional
    public Task save(Task task)
    {
        return (Task) genericDAO.save(task);
    }

}
