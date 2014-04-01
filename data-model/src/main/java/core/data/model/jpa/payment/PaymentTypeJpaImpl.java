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
package core.data.model.jpa.payment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import core.data.model.payment.PaymentType;
import core.data.model.util.DataUtil;

@Entity
@Table(name = "payment_type")
public class PaymentTypeJpaImpl implements PaymentType
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_type_id", nullable = false)
    private Integer paymentTypeId;

    @Column(name = "description")
    private String description;

    @Column (name="key")
    private String key;

    /* (non-Javadoc)
     * @see core.data.model.payment.PaymentType#getDescription()
     */
    public String getDescription()
    {
        return description;
    }

    
    public Integer getId()
    {
        return getPaymentTypeId();
    }

    
    public Object getKey()
    {
        return getKey();
    }

    /* (non-Javadoc)
     * @see core.data.model.payment.PaymentType#getPaymentTypeId()
     */
    public Integer getPaymentTypeId()
    {
        return paymentTypeId;
    }

    
    public boolean isEquivalent(Object object)
    {
        PaymentTypeJpaImpl type = (PaymentTypeJpaImpl) object;
        return DataUtil.equals(getPaymentTypeId(), type.getPaymentTypeId())
            && DataUtil.equals(getDescription(), type.getDescription())
            && DataUtil.equals(getKey(), type.getKey());
    }
    
    /* (non-Javadoc)
     * @see core.data.model.payment.PaymentType#setDescription(java.lang.String)
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    
    public void setId(Integer id)
    {
        setPaymentTypeId(id);
    }

    /**
     * Setter for key
     *
     * @param key the key to set
     */
    public void setKey(Object key)
    {
        this.key = (String) key;
    }

    /* (non-Javadoc)
     * @see core.data.model.payment.PaymentType#setPaymentTypeId(java.lang.Integer)
     */
    public void setPaymentTypeId(Integer paymentTypeId)
    {
        this.paymentTypeId = paymentTypeId;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    public String toString()
    {
        return "PaymentType("
            + "paymentTypeId="
            + getPaymentTypeId()
            + ",description="
            + getDescription()
            + ",key="
            + getKey()
            + ")";
    }

}
