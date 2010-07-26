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

import net.sf.gilead.pojo.java5.LightEntity;
import core.data.hibernate.party.PartyHibernateImpl;
import core.data.hibernate.party.RoleTypeHibernateImpl;
import core.data.model.billing.BillingAccount;
import core.data.model.billing.BillingAccountRole;
import core.data.model.party.Party;
import core.data.model.party.RoleType;
import core.data.model.util.DataUtil;

@Entity
@Table (name="billing_account_role")
public class BillingAccountRoleHibernateImpl extends LightEntity implements BillingAccountRole
{
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="billing_account_role_id")
    private Integer billingAccountRoleId;
    
    @ManyToOne (targetEntity=BillingAccountHibernateImpl.class)
    @JoinColumn (name="billing_account_id")
    private BillingAccount billingAccount;    
    
    @ManyToOne (targetEntity=PartyHibernateImpl.class)
    @JoinColumn (name="party_id")
    private Party party;

    @ManyToOne (targetEntity=RoleTypeHibernateImpl.class)
    @JoinColumn (name="role_type_id")
    private RoleType roleType;

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
     * @see core.data.model.billing.IBillingAccountRole#getBillingAccount()
     */
    public BillingAccount getBillingAccount()
    {
        return billingAccount;
    }

    /* (non-Javadoc)
     * @see core.data.model.billing.IBillingAccountRole#getBillingAccountRoleId()
     */
    public Integer getBillingAccountRoleId()
    {
        return billingAccountRoleId;
    }

    /* (non-Javadoc)
     * @see core.data.model.billing.IBillingAccountRole#getFromDate()
     */
    public Date getFromDate()
    {
        return fromDate;
    }

    
    public Integer getId()
    {
        return getBillingAccountRoleId();
    }

    /* (non-Javadoc)
     * @see core.data.model.billing.IBillingAccountRole#getParty()
     */
    public Party getParty()
    {
        return party;
    }

    /* (non-Javadoc)
     * @see core.data.model.billing.IBillingAccountRole#getRoleType()
     */
    public RoleType getRoleType()
    {
        return roleType;
    }

    /* (non-Javadoc)
     * @see core.data.model.billing.IBillingAccountRole#getThruDate()
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
        BillingAccountRole role = (BillingAccountRole) object;
        return getBillingAccountRoleId().equals(role.getBillingAccountRoleId())
            && DataUtil.isEquivalent(getBillingAccount(), role.getBillingAccount())
            && DataUtil.isEquivalent(getRoleType(), role.getRoleType())
            && DataUtil.isEquivalent(getParty(), role.getParty())
            && getFromDate().equals(role.getFromDate())
            && getThruDate().equals(role.getThruDate());
    }

    /* (non-Javadoc)
     * @see core.data.model.billing.IBillingAccountRole#setBillingAccount(core.data.model.billing.BillingAccount)
     */
    public void setBillingAccount(BillingAccount billingAccount)
    {
        this.billingAccount = billingAccount;
    }

    /* (non-Javadoc)
     * @see core.data.model.billing.IBillingAccountRole#setBillingAccountRoleId(java.lang.Integer)
     */
    public void setBillingAccountRoleId(Integer billingAccountRoleId)
    {
        this.billingAccountRoleId = billingAccountRoleId;
    }

    /* (non-Javadoc)
     * @see core.data.model.billing.IBillingAccountRole#setFromDate(java.sql.Date)
     */
    public void setFromDate(Date fromDate)
    {
        this.fromDate = fromDate;
    }

    
    public void setId(Integer id)
    {
        setBillingAccountRoleId(id);
    }

    /* (non-Javadoc)
     * @see core.data.model.billing.IBillingAccountRole#setParty(core.data.model.party.Party)
     */
    public void setParty(Party party)
    {
        this.party = party;
    }
    
    /* (non-Javadoc)
     * @see core.data.model.billing.IBillingAccountRole#setRoleType(core.data.model.party.RoleType)
     */
    public void setRoleType(RoleType roleType)
    {
        this.roleType = roleType;
    }

    /* (non-Javadoc)
     * @see core.data.model.billing.IBillingAccountRole#setThruDate(java.sql.Date)
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
        return "BillingAccountRole("
            + "billingAccountRoleId="
            + getBillingAccountRoleId()
            + ",billingAccountId="
            + DataUtil.getId(getBillingAccount())
            + ",partyId="
            + DataUtil.getId(getParty())
            + ",roleType="
            + DataUtil.getId(getRoleType())
            + ",fromDate="
            + getFromDate()
            + ",thruDate="
            + getThruDate()
            + ")";
    }

}
