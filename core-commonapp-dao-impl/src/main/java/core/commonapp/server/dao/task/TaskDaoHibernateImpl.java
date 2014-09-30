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

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import core.commonapp.client.dao.task.TaskDao;
import core.commonapp.server.dao.BaseDaoJpaImpl;
import core.data.model.party.Person;
import core.data.model.task.Task;
import core.data.model.task.TaskType;

@Repository
public class TaskDaoHibernateImpl extends BaseDaoJpaImpl<Task> implements TaskDao
{

    public TaskDaoHibernateImpl()
    {
        super();
    }
    
    @Override
    public List<Task> findAll(int max, int offset, List<Person> pepole, String subject, List<TaskType> taskTypes)
    {
        Query query = getEntityManager().createQuery("from Task");

        List<Task> tasks = query.getResultList();
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
    	Task task = getEntityManager().find(Task.class, id);
    	
        // TODO: add boolean to choose when to populate
        task.getTaskStatus().size();
        
        return task;
    }

	@Override
	public Class<Task> getPersistClass() {
		return Task.class;
	}

}
