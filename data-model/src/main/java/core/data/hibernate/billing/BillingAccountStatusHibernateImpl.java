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
package core.data.hibernate.billing;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import core.data.hibernate.status.StatusHibernateImpl;
import core.data.model.billing.BillingAccount;
import core.data.model.billing.BillingAccountStatus;
import core.data.model.status.Status;
import core.data.model.util.DataUtil;

@Entity
@Table (name="billing_account_status")
public class BillingAccountStatusHibernateImpl implements BillingAccountStatus
{
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="billing_account_status_id")
    private Integer billingAccountStatusId;
    
    @ManyToOne (targetEntity=BillingAccountHibernateImpl.class)
    @JoinColumn (name="billing_account_id")
    private BillingAccount billingAccount;

    @ManyToOne (targetEntity=StatusHibernateImpl.class)
    @JoinColumn (name="status_id")
    private Status status;

    @Column (name="from_date")
    private Date fromDate;

    @Column (name="thru_date")
    private Date thruDate;

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    
    public boolean equals(Object obj)
    {
        // TODO data object equals
        return super.equals(obj);
    }

    /* (non-Javadoc)
     * @see core.data.model.billing.IBillingAccountStatus#getBillingAccount()
     */
    public BillingAccount getBillingAccount()
    {
        return billingAccount;
    }

    /* (non-Javadoc)
     * @see core.data.model.billing.IBillingAccountStatus#getBillingAccountStatusId()
     */
    public Integer getBillingAccountStatusId()
    {
        return billingAccountStatusId;
    }

    /* (non-Javadoc)
     * @see core.data.model.billing.IBillingAccountStatus#getFromDate()
     */
    public Date getFromDate()
    {
        return fromDate;
    }

    
    public Integer getId()
    {
        return getBillingAccountStatusId();
    }

    /* (non-Javadoc)
     * @see core.data.model.billing.IBillingAccountStatus#getStatus()
     */
    public Status getStatus()
    {
        return status;
    }

    /* (non-Javadoc)
     * @see core.data.model.billing.IBillingAccountStatus#getThruDate()
     */
    public Date getThruDate()
    {
        return thruDate;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    
    public int hashCode()
    {
        // TODO data object hash code
        return super.hashCode();
    }

    /* (non-Javadoc)
     * @see core.data.DataObject#isEquivalent(java.lang.Object)
     */
    
    public boolean isEquivalent(Object object)
    {
        BillingAccountStatus status = (BillingAccountStatus) object;
        return DataUtil.equals(getBillingAccountStatusId(), status.getBillingAccountStatusId())
            && DataUtil.isEquivalent(getBillingAccount(), status.getBillingAccount())
            && DataUtil.isEquivalent(getStatus(), status.getStatus())
            && DataUtil.equals(getFromDate(), status.getFromDate())
            && DataUtil.equals(getThruDate(), status.getThruDate());    
    }

    /* (non-Javadoc)
     * @see core.data.model.billing.IBillingAccountStatus#setBillingAccount(core.data.model.billing.BillingAccount)
     */
    public void setBillingAccount(BillingAccount billingAccount)
    {
        this.billingAccount = billingAccount;
    }

    /* (non-Javadoc)
     * @see core.data.model.billing.IBillingAccountStatus#setBillingAccountStatusId(java.lang.Integer)
     */
    public void setBillingAccountStatusId(Integer billingAccountStatusId)
    {
        this.billingAccountStatusId = billingAccountStatusId;
    }

    /* (non-Javadoc)
     * @see core.data.model.billing.IBillingAccountStatus#setFromDate(java.sql.Date)
     */
    public void setFromDate(Date fromDate)
    {
        this.fromDate = fromDate;
    }

    
    public void setId(Integer id)
    {
        setBillingAccountStatusId(id);
    }

    /* (non-Javadoc)
     * @see core.data.model.billing.IBillingAccountStatus#setStatus(core.data.model.status.Status)
     */
    public void setStatus(Status status)
    {
        this.status = status;
    }

    /* (non-Javadoc)
     * @see core.data.model.billing.IBillingAccountStatus#setThruDate(java.sql.Date)
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
        return "BillingAccountStatus("
            + "billingAccountStatusId="
            + getBillingAccountStatusId()
            + ",billingAccountId="
            + DataUtil.getId(getBillingAccount())
            + ",status="
            + getStatus()
            + ",fromDate="
            + getFromDate()
            + ",thruDate="
            + getThruDate()
            + ")";
    }

}
