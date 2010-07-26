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
package core.data.hibernate.status;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import net.sf.gilead.pojo.java5.LightEntity;
import core.data.model.DataObject;
import core.data.model.Keyable;
import core.data.model.status.StatusType;
import core.data.model.util.DataUtil;

@Entity
@Table (name="status_type")
public class StatusTypeHibernateImpl extends LightEntity implements DataObject, Keyable, StatusType
{
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="status_type_id")
    private Integer statusTypeId;
    
    @Column (name="keyable")
    private String key;
    
    @Column (name="description")
    private String description;

    /* (non-Javadoc)
     * @see core.data.model.status.StatusType#getDescription()
     */
    public String getDescription()
    {
        return description;
    }

    
    public Integer getId()
    {
        return getStatusTypeId();
    }

    /**
     * Getter for key
     *
     * @return the key
     */
    public String getKey()
    {
        return key;
    }

    /* (non-Javadoc)
     * @see core.data.model.status.StatusType#getStatusTypeId()
     */
    public Integer getStatusTypeId()
    {
        return statusTypeId;
    }

    
    public boolean isEquivalent(Object object)
    {
        StatusTypeHibernateImpl type = (StatusTypeHibernateImpl) object;
        return DataUtil.equals(getStatusTypeId(), type.getStatusTypeId())
            && DataUtil.equals(getDescription(), type.getDescription())
            && DataUtil.equals(getKey(), type.getKey());
    }

    /* (non-Javadoc)
     * @see core.data.model.status.StatusType#setDescription(java.lang.String)
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    
    public void setId(Integer id)
    {
        setStatusTypeId(id);
    }

    /**
     * Setter for key
     *
     * @param key the key to set
     */
    public void setKey(Object key)
    {
        this.key = (String) key;
    }

    /* (non-Javadoc)
     * @see core.data.model.status.StatusType#setStatusTypeId(java.lang.Integer)
     */
    public void setStatusTypeId(Integer statusTypeId)
    {
        this.statusTypeId = statusTypeId;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    public String toString()
    {
        return "StatusType("
            + "statusTypeId="
            + getStatusTypeId()
            + ",key="
            + getKey()
            + ",description="
            + getDescription()
            + ")";
    }

}
