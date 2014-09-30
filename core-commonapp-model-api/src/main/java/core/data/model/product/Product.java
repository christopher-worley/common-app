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
package core.data.model.product;


import java.util.Date;

import core.data.model.DataObject;

public interface Product extends DataObject
{

    /**
     * Getter for createdDate
     *
     * @return the createdDate
     */
    public abstract Date getCreatedDate();

    /**
     * Getter for description
     *
     * @return the description
     */
    public abstract String getDescription();

    /**
     * Getter for productId
     *
     * @return the productId
     */
    public abstract Integer getProductId();

    /**
     * Getter for productName
     *
     * @return the productName
     */
    public abstract String getProductName();

    /**
     * Getter for productType
     *
     * @return the productType
     */
    public abstract ProductType getProductType();

    /**
     * Setter for createdDate
     *
     * @param createdDate the createdDate to set
     */
    public abstract void setCreatedDate(Date createdDate);

    /**
     * Setter for description
     *
     * @param description the description to set
     */
    public abstract void setDescription(String description);

    /**
     * Setter for productId
     *
     * @param productId the productId to set
     */
    public abstract void setProductId(Integer productId);

    /**
     * Setter for productName
     *
     * @param productName the productName to set
     */
    public abstract void setProductName(String productName);

    /**
     * Setter for productType
     *
     * @param productType the productType to set
     */
    public abstract void setProductType(ProductType productType);

}