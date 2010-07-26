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

import core.data.model.DataObject;
import core.service.InformationBean;

@InformationBean (beanName="phoneNumberModel")
public interface PhoneNumber extends ContactMech, DataObject
{

    /**
     * Getter for areaCode
     *
     * @return the areaCode
     */
    public abstract String getAreaCode();

    /**
     * Getter for contactNumber
     * 
     * @return the contactNumber
     */
    public abstract String getContactNumber();

    /**
     * Getter for countryCode
     * 
     * @return the countryCode
     */
    public abstract String getCountryCode();

    /**
     * Getter for extension
     * 
     * @return the extension
     */
    public abstract String getExtension();

    /**
     * Setter for areaCode
     *
     * @param areaCode the areaCode to set
     */
    public abstract void setAreaCode(String areaCode);

    /**
     * Setter for contactNumber
     * 
     * @param contactNumber
     *                the contactNumber to set
     */
    public abstract void setContactNumber(String contactNumber);

    /**
     * Setter for countryCode
     * 
     * @param countryCode
     *                the countryCode to set
     */
    public abstract void setCountryCode(String countryCode);

    /**
     * Setter for extension
     * 
     * @param extension
     *                the extension to set
     */
    public abstract void setExtension(String extension);

}