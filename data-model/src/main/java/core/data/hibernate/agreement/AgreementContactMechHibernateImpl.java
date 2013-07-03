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
package core.data.hibernate.agreement;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import core.data.hibernate.contact.ContactMechHibernateImpl;
import core.data.hibernate.contact.ContactMechPurposeHibernateImpl;
import core.data.model.agreement.Agreement;
import core.data.model.agreement.AgreementContactMech;
import core.data.model.contact.ContactMech;
import core.data.model.contact.ContactMechPurpose;
import core.data.model.util.DataUtil;

@Entity
@Table (name="agreement_contact_mech")
public class AgreementContactMechHibernateImpl implements AgreementContactMech
{
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="agreement_contact_mech_id")
    private Integer agreementContactMechId;

    @ManyToOne (targetEntity=AgreementHibernateImpl.class)
    @JoinColumn (name="agreement_id")
    private Agreement agreement;    

    @ManyToOne (targetEntity=ContactMechHibernateImpl.class)
    @JoinColumn (name="contact_mech_id")
    private ContactMech contactMech;

    @ManyToOne (targetEntity=ContactMechPurposeHibernateImpl.class)
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
     * @see core.data.model.agreement.IAgreementContactMech#getAgreement()
     */
    public Agreement getAgreement()
    {
        return agreement;
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreementContactMech#getAgreementContactMechId()
     */
    public Integer getAgreementContactMechId()
    {
        return agreementContactMechId;
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreementContactMech#getContactMech()
     */
    public ContactMech getContactMech()
    {
        return contactMech;
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreementContactMech#getContactMechPurpose()
     */
    public ContactMechPurpose getContactMechPurpose()
    {
        return contactMechPurpose;
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreementContactMech#getFromDate()
     */
    public Date getFromDate()
    {
        return fromDate;
    }

    public Integer getId()
    {
        return getAgreementContactMechId();
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreementContactMech#getThruDate()
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
        // TODO data hash code
        return super.hashCode();
    }

    /* (non-Javadoc)
     * @see core.data.DataObject#isEquivalent(java.lang.Object)
     */
    public boolean isEquivalent(Object object)
    {
        AgreementContactMech agreementContactMech = (AgreementContactMech) object;
        return getAgreementContactMechId().equals(agreementContactMech.getAgreementContactMechId())
            && DataUtil.isEquivalent(getAgreement(), agreementContactMech.getAgreement())
            && DataUtil.isEquivalent(getContactMech(), agreementContactMech.getContactMech())
            && DataUtil.isEquivalent(getContactMechPurpose(), agreementContactMech.getContactMechPurpose())
            && getFromDate().equals(agreementContactMech.getFromDate())
            && getThruDate().equals(agreementContactMech.getThruDate());
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreementContactMech#setAgreement(core.data.model.agreement.Agreement)
     */
    public void setAgreement(Agreement agreement)
    {
        this.agreement = agreement;
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreementContactMech#setAgreementContactMechId(java.lang.Integer)
     */
    public void setAgreementContactMechId(Integer agreementContactMechId)
    {
        this.agreementContactMechId = agreementContactMechId;
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreementContactMech#setContactMech(core.data.model.contact.ContactMech)
     */
    public void setContactMech(ContactMech contactMech)
    {
        this.contactMech = contactMech;
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreementContactMech#setContactMechPurpose(core.data.model.contact.ContactMechPurpose)
     */
    public void setContactMechPurpose(ContactMechPurpose contactMechPurpose)
    {
        this.contactMechPurpose = contactMechPurpose;
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreementContactMech#setFromDate(java.sql.Date)
     */
    public void setFromDate(Date fromDate)
    {
        this.fromDate = fromDate;
    }
    
    public void setId(Integer id)
    {
        setAgreementContactMechId(id);
    }
    
    
    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreementContactMech#setThruDate(java.sql.Date)
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
        return "AgreementContactMech("
            + "agreementContactMechId="
            + getAgreementContactMechId()
            + ",agreementId="
            + DataUtil.getId(getAgreement())
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
