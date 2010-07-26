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

public interface Payment extends DataObject
{

    /**
     * Getter for amount
     *
     * @return the amount
     */
    public abstract Double getAmount();

    /**
     * Getter for createdDate
     *
     * @return the createdDate
     */
    public abstract Date getCreatedDate();

    /**
     * Getter for paymentDate
     *
     * @return the paymentDate
     */
    public abstract Date getPaymentDate();

    /**
     * Getter for paymentId
     *
     * @return the paymentId
     */
    public abstract Integer getPaymentId();

    /**
     * Getter for paymentType
     *
     * @return the paymentType
     */
    public abstract PaymentType getPaymentType();

    /**
     * Setter for amount
     *
     * @param amount the amount to set
     */
    public abstract void setAmount(Double amount);

    /**
     * Setter for createdDate
     *
     * @param createdDate the createdDate to set
     */
    public abstract void setCreatedDate(Date createdDate);

    /**
     * Setter for paymentDate
     *
     * @param paymentDate the paymentDate to set
     */
    public abstract void setPaymentDate(Date paymentDate);

    /**
     * Setter for paymentId
     *
     * @param paymentId the paymentId to set
     */
    public abstract void setPaymentId(Integer paymentId);

    /**
     * Setter for paymentType
     *
     * @param paymentType the paymentType to set
     */
    public abstract void setPaymentType(PaymentType paymentType);

}