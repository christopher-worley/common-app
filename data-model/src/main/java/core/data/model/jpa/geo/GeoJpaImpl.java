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
package core.data.model.jpa.geo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import core.data.model.geo.Geo;
import core.data.model.geo.GeoType;
import core.data.model.util.DataUtil;

/**
 * Geo contains geological locations such as: states countries
 * 
 * @author cworley
 * 
 */
@Entity
@Table(name = "geo")
public class GeoJpaImpl  implements Geo, Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = -8725815662047293568L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "geo_id", nullable = false)
    private Integer geoId;

    @ManyToOne (targetEntity=GeoTypeJpaImpl.class)
    @JoinColumn(name = "geo_type_id")
    private GeoType geoType;

    @Column(name = "name")
    private String name;

    @Column(name = "abbreviation")
    private String abbreviation;
    
    @Column(name="key")
    private String key;

    /**
     * 
     */
    public GeoJpaImpl()
    {
        super();
    }

    /* (non-Javadoc)
     * @see core.data.model.geo.Geo#getAbbreviation()
     */
    public String getAbbreviation()
    {
        return abbreviation;
    }

    /* (non-Javadoc)
     * @see core.data.model.geo.Geo#getGeoId()
     */
    public Integer getGeoId()
    {
        return geoId;
    }

    /* (non-Javadoc)
     * @see core.data.model.geo.Geo#getGeoType()
     */
    public GeoType getGeoType()
    {
        return geoType;
    }

    
    public Integer getId()
    {
        return getGeoId();
    }

    
    public Object getKey()
    {
        return key;
    }

    /* (non-Javadoc)
     * @see core.data.model.geo.Geo#getName()
     */
    public String getName()
    {
        return name;
    }

    
    public boolean isEquivalent(Object object)
    {
        Geo geo = (Geo) object;
        return DataUtil.equals(getGeoId(), geo.getGeoId())
            && DataUtil.isEquivalent(getGeoType(), geo.getGeoType())
            && DataUtil.equals(getKey(), geo.getKey())
            && DataUtil.equals(getName(), geo.getName())
            && DataUtil.equals(getAbbreviation(), geo.getAbbreviation());
    }

    /* (non-Javadoc)
     * @see core.data.model.geo.Geo#setAbbreviation(java.lang.String)
     */
    public void setAbbreviation(String abbreviation)
    {
        this.abbreviation = abbreviation;
    }

    /* (non-Javadoc)
     * @see core.data.model.geo.Geo#setGeoId(java.lang.Integer)
     */
    public void setGeoId(Integer geoId)
    {
        this.geoId = geoId;
    }

    /* (non-Javadoc)
     * @see core.data.model.geo.Geo#setGeoType(core.data.model.geo.GeoType)
     */
    public void setGeoType(GeoType geoType)
    {
        this.geoType = geoType;
    }

    
    public void setId(Integer id)
    {
        setGeoId(id);
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
     * @see core.data.model.geo.Geo#setName(java.lang.String)
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    public String toString()
    {
        return "Geo("
            + "geoId="
            + getGeoId()
            + ",getType="
            + getGeoType()
            + ",key="
            + getKey()
            + ",abbreviation="
            + getAbbreviation()
            + ",name="
            + getName()
            + ")";
    }

}
