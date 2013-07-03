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
package core.data.hibernate.payment;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import core.data.model.payment.Payment;
import core.data.model.payment.PaymentType;
import core.data.model.util.DataUtil;

@Entity
@Table (name="payment")
public class PaymentHibernateImpl implements Payment
{
 
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="payment_id")
    private Integer paymentId;
    
    @ManyToOne (targetEntity=PaymentTypeHibernateImpl.class)
    @JoinColumn (name="payment_type_id")
    private PaymentType paymentType;
    
    @Column (name="created_date")
    private Date createdDate;
    
    @Column (name="payment_date")
    private Date paymentDate;
    
    @Column (name="amount")
    private Double amount;

    /* (non-Javadoc)
     * @see core.data.model.payment.Payment#getAmount()
     */
    public Double getAmount()
    {
        return amount;
    }

    /* (non-Javadoc)
     * @see core.data.model.payment.Payment#getCreatedDate()
     */
    public Date getCreatedDate()
    {
        return createdDate;
    }

    
    public Integer getId()
    {
        return getPaymentId();
    }

    /* (non-Javadoc)
     * @see core.data.model.payment.Payment#getPaymentDate()
     */
    public Date getPaymentDate()
    {
        return paymentDate;
    }

    /* (non-Javadoc)
     * @see core.data.model.payment.Payment#getPaymentId()
     */
    public Integer getPaymentId()
    {
        return paymentId;
    }

    /* (non-Javadoc)
     * @see core.data.model.payment.Payment#getPaymentType()
     */
    public PaymentType getPaymentType()
    {
        return paymentType;
    }

    
    public boolean isEquivalent(Object object)
    {
        Payment payment = (Payment) object;
        return DataUtil.equals(getPaymentId(), payment.getPaymentId())
            && DataUtil.isEquivalent(getPaymentType(), payment.getPaymentType())
            && DataUtil.equals(getCreatedDate(), payment.getCreatedDate())
            && DataUtil.equals(getPaymentDate(), payment.getPaymentDate())
            && DataUtil.equals(getAmount(), payment.getAmount());
    }

    /* (non-Javadoc)
     * @see core.data.model.payment.Payment#setAmount(java.lang.Double)
     */
    public void setAmount(Double amount)
    {
        this.amount = amount;
    }

    /* (non-Javadoc)
     * @see core.data.model.payment.Payment#setCreatedDate(java.util.Date)
     */
    public void setCreatedDate(Date createdDate)
    {
        this.createdDate = createdDate;
    }

    
    public void setId(Integer id)
    {
        setPaymentId(id);
    }

    /* (non-Javadoc)
     * @see core.data.model.payment.Payment#setPaymentDate(java.util.Date)
     */
    public void setPaymentDate(Date paymentDate)
    {
        this.paymentDate = paymentDate;
    }

    /* (non-Javadoc)
     * @see core.data.model.payment.Payment#setPaymentId(java.lang.Integer)
     */
    public void setPaymentId(Integer paymentId)
    {
        this.paymentId = paymentId;
    }

    /* (non-Javadoc)
     * @see core.data.model.payment.Payment#setPaymentType(core.data.model.payment.PaymentType)
     */
    public void setPaymentType(PaymentType paymentType)
    {
        this.paymentType = paymentType;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    public String toString()
    {
        return "Payment("
            + "paymentId="
            + getPaymentId()
            + ",paymentType="
            + getPaymentType()
            + ",createdDate="
            + getCreatedDate()
            + ",paymentDate="
            + getPaymentDate()
            + ",amount="
            + getAmount()
            + ")";
    }

}
