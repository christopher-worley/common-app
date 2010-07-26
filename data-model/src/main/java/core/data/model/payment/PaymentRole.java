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
package core.data.model.payment;

import java.util.Date;

import core.data.model.DataObject;
import core.data.model.party.RoleType;

public interface PaymentRole extends DataObject
{

    /**
     * Getter for fromDate
     *
     * @return the fromDate
     */
    public abstract Date getFromDate();

    /**
     * Getter for payment
     *
     * @return the payment
     */
    public abstract Payment getPayment();

    /**
     * Getter for paymentRoleId
     *
     * @return the paymentRoleId
     */
    public abstract Integer getPaymentRoleId();

    /**
     * Getter for roleType
     *
     * @return the roleType
     */
    public abstract RoleType getRoleType();

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
     * Setter for payment
     *
     * @param payment the payment to set
     */
    public abstract void setPayment(Payment payment);

    /**
     * Setter for paymentRoleId
     *
     * @param paymentRoleId the paymentRoleId to set
     */
    public abstract void setPaymentRoleId(Integer paymentRoleId);

    /**
     * Setter for roleType
     *
     * @param roleType the roleType to set
     */
    public abstract void setRoleType(RoleType roleType);

    /**
     * Setter for thruDate
     *
     * @param thruDate the thruDate to set
     */
    public abstract void setThruDate(Date thruDate);

}