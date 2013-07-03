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
package core.commonapp.client.dao;

import java.util.List;

import core.data.model.DataObject;
import core.service.annotation.InformationBean;
import core.service.annotation.Service;

@InformationBean (beanName="genericDAO")
public interface GenericDAO<T extends DataObject>
{

    /**
     * Find all objects for the given class
     * @param clazz
     * @return
     */
    public List<T> findAll(Class<? extends T> clazz);

    /**
     * find object by a certain field, only one is
     * expected to be in the database and only the first
     * result is returned.
     * 
     * @param clazz
     * @param field
     * @param value
     * @return
     */
    public Object findByField(Class<? extends T> clazz, String field, Object value);

    /**
     * find object by id for the given class
     * 
     * @param class1
     * @param id
     * @return
     */
    public Object findById(Class<? extends T> clazz, Integer id);
    
    /**
     * Update the object
     * 
     * @param data
     */
    public void reattach(T data);

    /**
     * Save data object
     * 
     * @param data
     * @return
     */
    public T save(T data);

    /**
     * Save all data objects
     * 
     * @param data
     * @return
     */
    public List<? extends T> saveAll(List<? extends T> data);
}
