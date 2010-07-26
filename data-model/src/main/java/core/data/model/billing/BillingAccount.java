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
package core.data.model.billing;


import java.util.Date;

import core.data.model.DataObject;

public interface BillingAccount extends DataObject
{

    /**
     * Getter for billingAccountId
     *
     * @return the billingAccountId
     */
    public abstract Integer getBillingAccountId();

    /**
     * Getter for billingAccountType
     *
     * @return the billingAccountType
     */
    public abstract BillingAccountType getBillingAccountType();

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
     * Setter for billingAccountId
     *
     * @param billingAccountId the billingAccountId to set
     */
    public abstract void setBillingAccountId(Integer billingAccountId);

    /**
     * Setter for billingAccountType
     *
     * @param billingAccountType the billingAccountType to set
     */
    public abstract void setBillingAccountType(BillingAccountType billingAccountType);

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

}