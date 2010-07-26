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
package core.data.model.agreement;

import java.util.Date;

import core.data.model.product.Product;

public interface ServiceAgreement
{

    /* (non-Javadoc)
     * @see core.data.model.agreement.Agreement#equals(java.lang.Object)
     */
    public abstract boolean equals(Object obj);

    /**
     * Getter for service
     *
     * @return the service
     */
    public abstract Product getProduct();

    /**
     * Getter for serviceInterval
     *
     * @return the serviceInterval
     */
    public abstract ServiceInterval getServiceInterval();

    /**
     * Getter for startDate
     *
     * @return the startDate
     */
    public abstract Date getStartDate();

    /**
     * Setter for service
     *
     * @param service the service to set
     */
    public abstract void setProduct(Product service);

    /**
     * Setter for serviceInterval
     *
     * @param serviceInterval the serviceInterval to set
     */
    public abstract void setServiceInterval(ServiceInterval serviceInterval);

    /**
     * Setter for startDate
     *
     * @param startDate the startDate to set
     */
    public abstract void setStartDate(Date startDate);

}