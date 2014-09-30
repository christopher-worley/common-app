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

import core.data.model.party.Person;
import core.data.model.task.Task;
import core.data.model.task.TaskType;

public interface TaskDao
{
    
    /**
     * find task by id
     * 
     * @param id 
     */
    public Task findById(Integer id);
    
    /**
     * save task
     * 
     * @param task task to save
     * @return peristed task
     */
    public Task save(Task task);
    
    /**
     * 
     * @param max
     * @param offset
     * @param pepole
     * @param subject
     * @param taskTypes
     * @return
     */
    public List<Task> findAll(int max, int offset, List<Person> pepole, String subject, List<TaskType> taskTypes);

}
