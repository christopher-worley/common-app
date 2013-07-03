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
package core.data.hibernate.geo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import core.data.model.geo.GeoType;
import core.data.model.util.DataUtil;

/**
 * Geo type contains geo types
 * 
 * @author cworley
 *
 */
@Entity
@Table (name="geo_type")
public class GeoTypeHibernateImpl implements GeoType
{
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="geo_type_id", nullable = false)
    private Integer geoTypeId;
    
    @Column (name="description")
    private String description;

    @Column (name="key")
    private String key;
    /* (non-Javadoc)
     * @see core.data.model.geo.GeoType#getDescription()
     */
    public String getDescription()
    {
        return description;
    }

    /* (non-Javadoc)
     * @see core.data.model.geo.GeoType#getGeoTypeId()
     */
    public Integer getGeoTypeId()
    {
        return geoTypeId;
    }

    
    public Integer getId()
    {
        return getGeoTypeId();
    }

    
    public Object getKey()
    {
        return key;
    }

    
    public boolean isEquivalent(Object object)
    {
        GeoTypeHibernateImpl type = (GeoTypeHibernateImpl) object;
        return DataUtil.equals(getGeoTypeId(), type.getGeoTypeId())
            && DataUtil.equals(getDescription(), type.getDescription())
            && DataUtil.equals(getKey(), type.getKey());
    }

    /* (non-Javadoc)
     * @see core.data.model.geo.GeoType#setDescription(java.lang.String)
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /* (non-Javadoc)
     * @see core.data.model.geo.GeoType#setGeoTypeId(java.lang.Integer)
     */
    public void setGeoTypeId(Integer geoTypeId)
    {
        this.geoTypeId = geoTypeId;
    }

    
    public void setId(Integer id)
    {
        setGeoTypeId(id);
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
     * @see java.lang.Object#toString()
     */
    
    public String toString()
    {
        return "GeoType("
            + "geoTypeId="
            + getGeoTypeId()
            + ",description="
            + getDescription()
            + ",key="
            + getKey()
            + ")";
    }
    
    
    
}
