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
package core.data.model.saleslead;


import java.util.Date;

import core.data.model.DataObject;
import core.data.model.status.Status;

public interface SalesLeadStatus extends DataObject
{

    /**
     * Getter for fromDate
     *
     * @return the fromDate
     */
    public abstract Date getFromDate();

    /**
     * Getter for salesLead
     *
     * @return the salesLead
     */
    public abstract SalesLead getSalesLead();

    /**
     * Getter for salesLeadStatusId
     *
     * @return the salesLeadStatusId
     */
    public abstract Integer getSalesLeadStatusId();

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
     * Setter for fromDate
     *
     * @param fromDate the fromDate to set
     */
    public abstract void setFromDate(Date fromDate);

    /**
     * Setter for salesLead
     *
     * @param salesLead the salesLead to set
     */
    public abstract void setSalesLead(SalesLead salesLead);

    /**
     * Setter for salesLeadStatusId
     *
     * @param salesLeadStatusId the salesLeadStatusId to set
     */
    public abstract void setSalesLeadStatusId(Integer salesLeadStatusId);

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