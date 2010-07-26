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
import core.data.model.status.Status;

public interface BillingAccountStatus extends DataObject
{

    /**
     * Getter for billingAccount
     *
     * @return the billingAccount
     */
    public abstract BillingAccount getBillingAccount();

    /**
     * Getter for billingAccountStatusId
     *
     * @return the billingAccountStatusId
     */
    public abstract Integer getBillingAccountStatusId();

    /**
     * Getter for fromDate
     *
     * @return the fromDate
     */
    public abstract Date getFromDate();

    /**
     * Getter for status
     *
     * @return the status
     */
    public abstract Status getStatus();

    /**
     * Getter for thruDate
     *
     * @return the thruDate
     */
    public abstract Date getThruDate();

    /**
     * Setter for billingAccount
     *
     * @param billingAccount the billingAccount to set
     */
    public abstract void setBillingAccount(BillingAccount billingAccount);

    /**
     * Setter for billingAccountStatusId
     *
     * @param billingAccountStatusId the billingAccountStatusId to set
     */
    public abstract void setBillingAccountStatusId(Integer billingAccountStatusId);

    /**
     * Setter for fromDate
     *
     * @param fromDate the fromDate to set
     */
    public abstract void setFromDate(Date fromDate);

    /**
     * Setter for status
     *
     * @param status the status to set
     */
    public abstract void setStatus(Status status);

    /**
     * Setter for thruDate
     *
     * @param thruDate the thruDate to set
     */
    public abstract void setThruDate(Date thruDate);

}