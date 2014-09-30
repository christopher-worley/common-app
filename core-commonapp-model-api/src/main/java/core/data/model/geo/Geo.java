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
package core.data.model.geo;

import core.data.model.DataObject;
import core.data.model.Keyable;

public interface Geo extends DataObject, Keyable
{

    /**
     * Getter for abbreviation
     * 
     * @return the abbreviation
     */
    public abstract String getAbbreviation();

    /**
     * Getter for geoId
     * 
     * @return the geoId
     */
    public abstract Integer getGeoId();

    /**
     * Getter for geoType
     * 
     * @return the geoType
     */
    public abstract GeoType getGeoType();

    /**
     * Getter for name
     * 
     * @return the name
     */
    public abstract String getName();

    /**
     * Setter for abbreviation
     * 
     * @param abbreviation
     *                the abbreviation to set
     */
    public abstract void setAbbreviation(String abbreviation);

    /**
     * Setter for geoId
     * 
     * @param geoId
     *                the geoId to set
     */
    public abstract void setGeoId(Integer geoId);

    /**
     * Setter for geoType
     * 
     * @param geoType
     *                the geoType to set
     */
    public abstract void setGeoType(GeoType geoType);

    /**
     * Setter for name
     * 
     * @param name
     *                the name to set
     */
    public abstract void setName(String name);

}