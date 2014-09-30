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
package core.data.model.jpa.task;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import core.data.model.task.TaskType;
import core.data.model.util.DataUtil;

@Entity
@Table (name="task_type")
public class TaskTypeJpaImpl implements TaskType
{
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column(name="task_type_id", nullable=false)
    private Integer taskTypeId;
    
    @Column (name="key")
    private String key;
    
    @Column (name="description")
    private String description;

    /* (non-Javadoc)
     * @see core.data.model.task.tASKtYPE#getDescription()
     */
    public String getDescription()
    {
        return description;
    }

    
    public Integer getId()
    {
        return getTaskTypeId();
    }

    /**
     * Getter for ke
     *
     * @return the ke
     */
    public String getKey()
    {
        return key;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.tASKtYPE#getTaskTypeId()
     */
    public Integer getTaskTypeId()
    {
        return taskTypeId;
    }

    
    public boolean isEquivalent(Object object)
    {
        TaskTypeJpaImpl type = (TaskTypeJpaImpl) object;
        return DataUtil.equals(getTaskTypeId(), type.getTaskTypeId())
            && DataUtil.equals(getDescription(), type.getDescription())
            && DataUtil.equals(getKey(), type.getKey());
    }

    /* (non-Javadoc)
     * @see core.data.model.task.tASKtYPE#setDescription(java.lang.String)
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    
    public void setId(Integer id)
    {
        setTaskTypeId(id);
    }

    /**
     * Setter for ke
     *
     * @param ke the ke to set
     */
    public void setKey(Object key)
    {
        this.key = (String) key;
    }

    /* (non-Javadoc)
     * @see core.data.model.task.tASKtYPE#setTaskTypeId(java.lang.Integer)
     */
    public void setTaskTypeId(Integer taskTypeId)
    {
        this.taskTypeId = taskTypeId;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    public String toString()
    {
        return "TaskType("
            + "taskTypeId="
            + getTaskTypeId()
            + ",key="
            + getKey()
            + ",description="
            + getDescription()
            + ")";
    }

}
