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
package core.commonapp.client.dao.task;

import java.util.List;

import core.data.hibernate.task.TaskTypeHibernateImpl;
import core.data.model.task.TaskType;

public interface TaskTypeDAO
{
    
    /**
     * Find all <code>TaskType</code> objects from 
     * data source
     * 
     * @return
     */
    public List<TaskType> findAll();

    /**
     * find task type by id
     * 
     * @param id
     * @return
     */
    public TaskType findById(Integer id);
    
    /**
     * save task type 
     * 
     * @param taskType
     * @return
     */
    public TaskType save(TaskTypeHibernateImpl taskType);
    
}
