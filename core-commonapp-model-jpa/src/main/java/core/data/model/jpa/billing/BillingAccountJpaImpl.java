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
package core.data.model.jpa.billing;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import core.data.model.billing.BillingAccount;
import core.data.model.billing.BillingAccountType;
import core.data.model.util.DataUtil;

@Entity
@Table (name="billing_account")
public class BillingAccountJpaImpl implements BillingAccount
{
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="billing_account_id")
    private Integer billingAccountId;
    
    @ManyToOne (targetEntity=BillingAccountTypeJpaImpl.class)
    @JoinColumn (name="billing_account_type_id")
    private BillingAccountType billingAccountType;
    
    @Column (name="description")
    private String description;
    
    @Column (name="created_date")
    private Date createdDate;

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    
    public boolean equals(Object obj)
    {
        // TODO data object equals
        return super.equals(obj);
    }

    /* (non-Javadoc)
     * @see core.data.model.billing.IBillingAccount#getBillingAccountId()
     */
    public Integer getBillingAccountId()
    {
        return billingAccountId;
    }

    /* (non-Javadoc)
     * @see core.data.model.billing.IBillingAccount#getBillingAccountType()
     */
    public BillingAccountType getBillingAccountType()
    {
        return billingAccountType;
    }

    /* (non-Javadoc)
     * @see core.data.model.billing.IBillingAccount#getCreatedDate()
     */
    public Date getCreatedDate()
    {
        return createdDate;
    }

    /* (non-Javadoc)
     * @see core.data.model.billing.IBillingAccount#getDescription()
     */
    public String getDescription()
    {
        return description;
    }

    
    public Integer getId()
    {
        return getBillingAccountId();
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
        BillingAccount account = (BillingAccount) object;
        return DataUtil.equals(getBillingAccountId(), account.getBillingAccountId())
            && DataUtil.isEquivalent(getBillingAccountType(), account.getBillingAccountType())
            && DataUtil.equals(getDescription(), account.getDescription())
            && DataUtil.equals(getCreatedDate(), account.getCreatedDate());
    }

    /* (non-Javadoc)
     * @see core.data.model.billing.IBillingAccount#setBillingAccountId(java.lang.Integer)
     */
    public void setBillingAccountId(Integer billingAccountId)
    {
        this.billingAccountId = billingAccountId;
    }

    /* (non-Javadoc)
     * @see core.data.model.billing.IBillingAccount#setBillingAccountType(core.data.model.billing.BillingAccountType)
     */
    public void setBillingAccountType(BillingAccountType billingAccountType)
    {
        this.billingAccountType = billingAccountType;
    }

    /* (non-Javadoc)
     * @see core.data.model.billing.IBillingAccount#setCreatedDate(java.sql.Date)
     */
    public void setCreatedDate(Date createdDate)
    {
        this.createdDate = createdDate;
    }

    /* (non-Javadoc)
     * @see core.data.model.billing.IBillingAccount#setDescription(java.lang.String)
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    
    public void setId(Integer id)
    {
        setBillingAccountId(id);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    public String toString()
    {
        return "BillingAccount("
            + "billingAccountId="
            + getBillingAccountId()
            + ",billingAccountType="
            + getBillingAccountType()
            + ",description="
            + getDescription()
            + ",createdDate="
            + getCreatedDate()
            + ")";
    }

}
