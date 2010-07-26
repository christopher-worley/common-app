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

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.sf.gilead.pojo.java5.LightEntity;
import core.data.hibernate.party.RoleTypeHibernateImpl;
import core.data.model.party.RoleType;
import core.data.model.payment.Payment;
import core.data.model.payment.PaymentRole;
import core.data.model.util.DataUtil;

@Entity
@Table(name = "payment_role")
public class PaymentRoleHibernateImpl extends LightEntity implements PaymentRole
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_role_id")
    private Integer paymentRoleId;

    @ManyToOne (cascade={CascadeType.ALL}, targetEntity=PaymentHibernateImpl.class)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @ManyToOne (targetEntity=RoleTypeHibernateImpl.class)
    @JoinColumn(name = "role_type_id")
    private RoleType roleType;

    @Column(name = "from_date")
    private Date fromDate;

    @Column(name = "thru_date")
    private Date thruDate;

    /* (non-Javadoc)
     * @see core.data.model.payment.PaymentRole#getFromDate()
     */
    public Date getFromDate()
    {
        return fromDate;
    }

    
    public Integer getId()
    {
        return getPaymentRoleId();
    }

    /* (non-Javadoc)
     * @see core.data.model.payment.PaymentRole#getPayment()
     */
    public Payment getPayment()
    {
        return payment;
    }

    /* (non-Javadoc)
     * @see core.data.model.payment.PaymentRole#getPaymentRoleId()
     */
    public Integer getPaymentRoleId()
    {
        return paymentRoleId;
    }

    /* (non-Javadoc)
     * @see core.data.model.payment.PaymentRole#getRoleType()
     */
    public RoleType getRoleType()
    {
        return roleType;
    }

    /* (non-Javadoc)
     * @see core.data.model.payment.PaymentRole#getThruDate()
     */
    public Date getThruDate()
    {
        return thruDate;
    }

    
    public boolean isEquivalent(Object object)
    {
        PaymentRole role = (PaymentRole) object;
        return DataUtil.equals(getPaymentRoleId(), role.getPaymentRoleId())
            && DataUtil.isEquivalent(getPayment(), role.getPayment())
            && DataUtil.isEquivalent(getRoleType(), role.getRoleType())
            && DataUtil.equals(getFromDate(), role.getFromDate())
            && DataUtil.equals(getThruDate(), role.getThruDate());
    }

    /* (non-Javadoc)
     * @see core.data.model.payment.PaymentRole#setFromDate(java.sql.Date)
     */
    public void setFromDate(Date fromDate)
    {
        this.fromDate = fromDate;
    }

    
    public void setId(Integer id)
    {
        setPaymentRoleId(id);
    }

    /* (non-Javadoc)
     * @see core.data.model.payment.PaymentRole#setPayment(core.data.model.payment.Payment)
     */
    public void setPayment(Payment payment)
    {
        this.payment = payment;
    }

    /* (non-Javadoc)
     * @see core.data.model.payment.PaymentRole#setPaymentRoleId(java.lang.Integer)
     */
    public void setPaymentRoleId(Integer paymentRoleId)
    {
        this.paymentRoleId = paymentRoleId;
    }

    /* (non-Javadoc)
     * @see core.data.model.payment.PaymentRole#setRoleType(core.data.model.party.RoleType)
     */
    public void setRoleType(RoleType roleType)
    {
        this.roleType = roleType;
    }

    /* (non-Javadoc)
     * @see core.data.model.payment.PaymentRole#setThruDate(java.sql.Date)
     */
    public void setThruDate(Date thruDate)
    {
        this.thruDate = thruDate;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    public String toString()
    {
        return "PaymentRole("
            + ",paymentRoleId="
            + getPaymentRoleId()
            + ",payment="
            + getPayment()
            + ",roleType="
            + getRoleType()
            + ",fromDate="
            + getFromDate()
            + ",thruDate="
            + getThruDate()
            + ")";
    }

}
