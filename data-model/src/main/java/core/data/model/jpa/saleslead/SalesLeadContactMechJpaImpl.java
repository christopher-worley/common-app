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
package core.data.model.jpa.saleslead;


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

import core.data.model.contact.ContactMech;
import core.data.model.contact.ContactMechPurpose;
import core.data.model.jpa.contact.ContactMechJpaImpl;
import core.data.model.jpa.contact.ContactMechPurposeJpaImpl;
import core.data.model.saleslead.SalesLead;
import core.data.model.saleslead.SalesLeadContactMech;
import core.data.model.util.DataUtil;

@Entity
@Table (name="sales_lead_contact_mech")
public class SalesLeadContactMechJpaImpl implements SalesLeadContactMech
{

    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="sales_lead_contact_mech_id")
    private Integer salesLeadContactMechId;
    
    @ManyToOne (targetEntity=SalesLeadJpaImpl.class)
    @JoinColumn (name="sales_lead_id")
    private SalesLead salesLead;
    
    @ManyToOne (cascade={CascadeType.ALL}, targetEntity=ContactMechJpaImpl.class)
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
     * @see core.data.model.saleslead.SalesLeadContactMech#getContactMech()
     */
    public ContactMech getContactMech()
    {
        return contactMech;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.SalesLeadContactMech#getContactMechPurpose()
     */
    public ContactMechPurpose getContactMechPurpose()
    {
        return contactMechPurpose;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.SalesLeadContactMech#getFromDate()
     */
    public Date getFromDate()
    {
        return fromDate;
    }

    
    public Integer getId()
    {
        return getSalesLeadContactMechId();
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.SalesLeadContactMech#getSalesLead()
     */
    public SalesLead getSalesLead()
    {
        return salesLead;
    }
    
    /* (non-Javadoc)
     * @see core.data.model.saleslead.SalesLeadContactMech#getSalesLeadContactMechId()
     */
    public Integer getSalesLeadContactMechId()
    {
        return salesLeadContactMechId;
    }
    
    /* (non-Javadoc)
     * @see core.data.model.saleslead.SalesLeadContactMech#getThruDate()
     */
    public Date getThruDate()
    {
        return thruDate;
    }

    
    public boolean isEquivalent(Object object)
    {
        SalesLeadContactMech contactMech = (SalesLeadContactMech) object;
        return DataUtil.equals(getSalesLeadContactMechId(), contactMech.getSalesLeadContactMechId())
                && DataUtil.isEquivalent(getSalesLead(), contactMech.getSalesLead())
                && DataUtil.isEquivalent(getContactMech(), contactMech.getContactMech())
                && DataUtil.isEquivalent(getContactMechPurpose(), contactMech.getContactMechPurpose())
                && DataUtil.equals(getFromDate(), contactMech.getFromDate())
                && DataUtil.equals(getThruDate(), contactMech.getThruDate());
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.SalesLeadContactMech#setContactMech(core.data.model.contact.ContactMech)
     */
    public void setContactMech(ContactMech contactMech)
    {
        this.contactMech = contactMech;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.SalesLeadContactMech#setContactMechPurpose(core.data.model.contact.ContactMechPurpose)
     */
    public void setContactMechPurpose(ContactMechPurpose contactMechPurpose)
    {
        this.contactMechPurpose = contactMechPurpose;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.SalesLeadContactMech#setFromDate(java.sql.Date)
     */
    public void setFromDate(Date fromDate)
    {
        this.fromDate = fromDate;
    }

    
    public void setId(Integer id)
    {
        setSalesLeadContactMechId(id);
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.SalesLeadContactMech#setSalesLead(core.data.model.saleslead.SalesLead)
     */
    public void setSalesLead(SalesLead salesLead)
    {
        this.salesLead = salesLead;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.SalesLeadContactMech#setSalesLeadContactMechId(java.lang.Integer)
     */
    public void setSalesLeadContactMechId(Integer proposalContactMechId)
    {
        this.salesLeadContactMechId = proposalContactMechId;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.SalesLeadContactMech#setThruDate(java.sql.Date)
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
        return "SalesLeadContactMech("
            + "salesLeadContactMechId="
            + getSalesLeadContactMechId()
            + ",salesLeadId="
            + DataUtil.getId(getSalesLead())
            + ",contactMech="
            + getContactMech()
            + ",contactMechPurpose="
            + getContactMechPurpose()
            + ",fromDate="
            + getFromDate()
            + ",thruDate="
            + getThruDate()
            + ")";
    }

}
