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
import core.data.model.billing.BillingAccountContactMech;
import core.data.model.contact.ContactMech;
import core.data.model.contact.ContactMechPurpose;
import core.data.model.jpa.contact.ContactMechJpaImpl;
import core.data.model.jpa.contact.ContactMechPurposeJpaImpl;
import core.data.model.util.DataUtil;

@Entity
@Table (name="billing_account_contact_mech")
public class BillingAccountContactMechJpaImpl implements BillingAccountContactMech
{
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="billing_account_contact_mech_id")
    private Integer billingAccountContactMechId;
    
    @ManyToOne (targetEntity=BillingAccountJpaImpl.class)
    @JoinColumn (name="billing_account_id")
    private BillingAccount billingAccount;    

    @ManyToOne (targetEntity=ContactMechJpaImpl.class)
    @JoinColumn (name="contact_mech_id")
    private ContactMech contactMech;

    @ManyToOne (targetEntity=ContactMechPurposeJpaImpl.class)
    @JoinColumn (name="contact_mech_purpose_id")
    private ContactMechPurpose contactMechPurpose;

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
     * @see core.data.model.billing.IBillingAccountContactMech#getBillingAccount()
     */
    public BillingAccount getBillingAccount()
    {
        return billingAccount;
    }

    /* (non-Javadoc)
     * @see core.data.model.billing.IBillingAccountContactMech#getBillingAccountContactMechId()
     */
    public Integer getBillingAccountContactMechId()
    {
        return billingAccountContactMechId;
    }

    /* (non-Javadoc)
     * @see core.data.model.billing.IBillingAccountContactMech#getContactMech()
     */
    public ContactMech getContactMech()
    {
        return contactMech;
    }

    /* (non-Javadoc)
     * @see core.data.model.billing.IBillingAccountContactMech#getContactMechPurpose()
     */
    public ContactMechPurpose getContactMechPurpose()
    {
        return contactMechPurpose;
    }

    /* (non-Javadoc)
     * @see core.data.model.billing.IBillingAccountContactMech#getFromDate()
     */
    public Date getFromDate()
    {
        return fromDate;
    }

    
    public Integer getId()
    {
        return getBillingAccountContactMechId();
    }

    /* (non-Javadoc)
     * @see core.data.model.billing.IBillingAccountContactMech#getThruDate()
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
        BillingAccountContactMech contactMech = (BillingAccountContactMech) object;
        return DataUtil.equals(getBillingAccountContactMechId(), contactMech.getBillingAccountContactMechId())
            && DataUtil.isEquivalent(getBillingAccount(), contactMech.getBillingAccount())
            && DataUtil.isEquivalent(getContactMech(), contactMech.getContactMech())
            && DataUtil.isEquivalent(getContactMechPurpose(), contactMech.getContactMechPurpose())
            && getFromDate().equals(contactMech.getFromDate())
            && getThruDate().equals(contactMech.getThruDate());
    }

    /* (non-Javadoc)
     * @see core.data.model.billing.IBillingAccountContactMech#setBillingAccount(core.data.model.billing.BillingAccount)
     */
    public void setBillingAccount(BillingAccount billingAccount)
    {
        this.billingAccount = billingAccount;
    }

    /* (non-Javadoc)
     * @see core.data.model.billing.IBillingAccountContactMech#setBillingAccountContactMechId(java.lang.Integer)
     */
    public void setBillingAccountContactMechId(Integer billingAccountContactMechId)
    {
        this.billingAccountContactMechId = billingAccountContactMechId;
    }

    /* (non-Javadoc)
     * @see core.data.model.billing.IBillingAccountContactMech#setContactMech(core.data.model.contact.ContactMech)
     */
    public void setContactMech(ContactMech contactMech)
    {
        this.contactMech = contactMech;
    }

    /* (non-Javadoc)
     * @see core.data.model.billing.IBillingAccountContactMech#setContactMechPurpose(core.data.model.contact.ContactMechPurpose)
     */
    public void setContactMechPurpose(ContactMechPurpose contactMechPurpose)
    {
        this.contactMechPurpose = contactMechPurpose;
    }

    /* (non-Javadoc)
     * @see core.data.model.billing.IBillingAccountContactMech#setFromDate(java.sql.Date)
     */
    public void setFromDate(Date fromDate)
    {
        this.fromDate = fromDate;
    }

    
    public void setId(Integer id)
    {
        setBillingAccountContactMechId(id);
    }

    /* (non-Javadoc)
     * @see core.data.model.billing.IBillingAccountContactMech#setThruDate(java.sql.Date)
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
        return "BillingAccountContactMech("
        + "billingAccountContactMechId="
        + getBillingAccountContactMechId()
        + ",billingAccountId="
        + DataUtil.getId(getBillingAccount())
        + ",contactMechId="
        + DataUtil.getId(getContactMech())
        + ",contactMechPurposeId="
        + DataUtil.getId(getContactMechPurpose())
        + ",fromDate="
        + getFromDate()
        + ",thruDate="
        + getThruDate()
        + ")";
    }

}
