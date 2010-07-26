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
package core.data.model.contact;

import core.data.model.geo.Geo;

public interface PostalAddress extends ContactMech
{

    /**
     * Getter for addressLine1
     * 
     * @return the addressLine1
     */
    public abstract String getAddressLine1();

    /**
     * Getter for addressLine2
     * 
     * @return the addressLine2
     */
    public abstract String getAddressLine2();

    /**
     * Getter for city
     * 
     * @return the city
     */
    public abstract String getCity();

    /**
     * Getter for countryGeoId
     * 
     * @return the countryGeoId
     */
    public abstract Geo getCountryGeo();

    /**
     * Getter for postalCode
     * 
     * @return the postalCode
     */
    public abstract String getPostalCode();

    /**
     * Getter for stateGeo
     * 
     * @return the stateGeo
     */
    public abstract Geo getStateGeo();

    /**
     * Setter for addressLine1
     * 
     * @param addressLine1
     *                the addressLine1 to set
     */
    public abstract void setAddressLine1(String addressLine1);

    /**
     * Setter for addressLine2
     * 
     * @param addressLine2
     *                the addressLine2 to set
     */
    public abstract void setAddressLine2(String addressLine2);

    /**
     * Setter for city
     * 
     * @param city
     *                the city to set
     */
    public abstract void setCity(String city);

    /**
     * Setter for countryGeoId
     * 
     * @param countryGeoId
     *                the countryGeoId to set
     */
    public abstract void setCountryGeo(Geo countryGeoId);

    /**
     * Setter for postalCode
     * 
     * @param postalCode
     *                the postalCode to set
     */
    public abstract void setPostalCode(String postalCode);

    /**
     * Setter for stateGeo
     * 
     * @param stateGeo
     *                the stateGeo to set
     */
    public abstract void setStateGeo(Geo stateGeo);

}