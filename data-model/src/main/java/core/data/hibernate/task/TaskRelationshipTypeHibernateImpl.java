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
package core.data.hibernate.task;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import net.sf.gilead.pojo.java5.LightEntity;
import core.data.model.task.TaskRelationshipType;
import core.data.model.util.DataUtil;

@Entity
@Table (name="task_relationship_type")
public class TaskRelationshipTypeHibernateImpl extends LightEntity implements TaskRelationshipType
{
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="task_relationship_type_id")
    private Integer taskRelationshipTypeId;
    
    @Column (name="key")
    private String key;

    @Column (name="description")
    private String description;

    /* (non-Javadoc)
     * @see core.data.model.task.TaskRelationshipType#getDescription()
     */
    public String getDescription()
    {
        return description;
    }

    
    public Integer getId()
    {
        return getTaskRelationshipTypeId();
    }

    /**
     * Getter for keyable
     *
     * @return the keyable
     */
    public String getKey()
    {
        return key;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskRelationshipType#getTaskRelationshipTypeId()
     */
    public Integer getTaskRelationshipTypeId()
    {
        return taskRelationshipTypeId;
    }

    
    public boolean isEquivalent(Object object)
    {
        TaskRelationshipType type = (TaskRelationshipType) object;
        return DataUtil.equals(getTaskRelationshipTypeId(), type.getTaskRelationshipTypeId())
            && DataUtil.equals(getDescription(), type.getDescription())
            && DataUtil.equals(getKey(), type.getKey());
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskRelationshipType#setDescription(java.lang.String)
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    
    public void setId(Integer id)
    {
        setTaskRelationshipTypeId(id);
    }
    
    /**
     * Setter for keyable
     *
     * @param keyable the keyable to set
     */
    public void setKey(Object key)
    {
        this.key = (String) key;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.TaskRelationshipType#setTaskRelationshipTypeId(java.lang.Integer)
     */
    public void setTaskRelationshipTypeId(Integer taskRelationshipTypeId)
    {
        this.taskRelationshipTypeId = taskRelationshipTypeId;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    public String toString()
    {
        return "TaskRelationshipType("
            + "taskRelationshipTypeId="
            + getTaskRelationshipTypeId()
            + ",key="
            + getKey()
            + ",description="
            + getDescription()
            + ")";
    }

}
