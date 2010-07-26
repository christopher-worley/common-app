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
package core.data.hibernate.agreement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import net.sf.gilead.pojo.java5.LightEntity;
import core.data.model.agreement.ServiceInterval;

@Entity
@Table (name="service_interval")
public class ServiceIntervalHibernateImpl extends LightEntity implements ServiceInterval
{
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="service_interval_id")
    private Integer serviceIntervalId;
    
    @Column (name="description")
    private String description;
    
    @Column (name="key")
    private String key;

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    
    public boolean equals(Object obj)
    {
        // TODO data object equals
        return super.equals(obj);
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IServiceInterval#getDescription()
     */
    public String getDescription()
    {
        return description;
    }

    
    public Integer getId()
    {
        return getServiceIntervalId();
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
     * @see core.data.model.agreement.IServiceInterval#getServiceIntervalId()
     */
    public Integer getServiceIntervalId()
    {
        return serviceIntervalId;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    
    public int hashCode()
    {
        // TODO data object hash code
        return super.hashCode();
    }

    
    public boolean isEquivalent(Object object)
    {
        ServiceIntervalHibernateImpl interval = (ServiceIntervalHibernateImpl) object;
        return getServiceIntervalId().equals(interval.getServiceIntervalId())
            && getDescription().equals(interval.getDescription())
            && getKey().equals(interval.getKey());
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IServiceInterval#setDescription(java.lang.String)
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    
    public void setId(Integer id)
    {
        setServiceIntervalId(id);
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
     * @see core.data.model.agreement.IServiceInterval#setServiceIntervalId(java.lang.Integer)
     */
    public void setServiceIntervalId(Integer serviceIntervalId)
    {
        this.serviceIntervalId = serviceIntervalId;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    public String toString()
    {
        return "ServiceInterval("
            + "serviceIntervalId="
            + getServiceIntervalId()
            + ",description="
            + getDescription()
            + ",key="
            + getKey()
            + ")";
    }

}
