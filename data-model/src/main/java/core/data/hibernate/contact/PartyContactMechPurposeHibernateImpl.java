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
package core.data.hibernate.contact;


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
import javax.persistence.Version;

import core.data.model.contact.ContactMechPurpose;
import core.data.model.contact.PartyContactMech;
import core.data.model.contact.PartyContactMechPurpose;
import core.data.model.util.DataUtil;

@Entity
@Table(name = "party_contact_mech_purpose")
public class PartyContactMechPurposeHibernateImpl implements PartyContactMechPurpose
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "party_contact_mech_purpose_id", nullable = false)
    private Integer partyContactMechPurposeId;

    @ManyToOne (targetEntity=ContactMechPurposeHibernateImpl.class)
    @JoinColumn(name = "contact_mech_purpose_id", nullable = false)
    private ContactMechPurpose contactMechPurpose;

    @ManyToOne (cascade={CascadeType.ALL}, targetEntity=PartyContactMechHibernateImpl.class)
    @JoinColumn(name = "party_contact_mech_id", nullable = false)
    private PartyContactMech partyContactMech;

    @Column(name = "from_date", nullable = false)
    private Date fromDate;

    @Column(name = "thru_date")
    private Date thruDate;

    @Version
    @Column(name="version")
    private Integer version;
    
    public boolean equals(Object obj)
    {
        // TODO data object equals
        return super.equals(obj);
    }

    /* (non-Javadoc)
     * @see core.data.model.contact.PartyContactMechPurpose#getContactMechPurpose()
     */
    public ContactMechPurpose getContactMechPurpose()
    {
        return contactMechPurpose;
    }
    
    /* (non-Javadoc)
     * @see core.data.model.contact.PartyContactMechPurpose#getFromDate()
     */
    public Date getFromDate()
    {
        return fromDate;
    }

    public Integer getId()
    {
        return getPartyContactMechPurposeId();
    }

    /**
     * Getter for partyContactMech
     *
     * @return the partyContactMech
     */
    public PartyContactMech getPartyContactMech()
    {
        return partyContactMech;
    }

    /* (non-Javadoc)
     * @see core.data.model.contact.PartyContactMechPurpose#getPartyContactMechPurposeId()
     */
    public Integer getPartyContactMechPurposeId()
    {
        return partyContactMechPurposeId;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    
    /* (non-Javadoc)
     * @see core.data.model.contact.PartyContactMechPurpose#getThruDate()
     */
    public Date getThruDate()
    {
        return thruDate;
    }

    public Integer getVersion()
    {
        return version;
    }

    
    public int hashCode()
    {
        // TODO data object hash code
        return super.hashCode();
    }

    public boolean isEquivalent(Object object)
    {
        PartyContactMechPurpose purpose = (PartyContactMechPurpose)  object;
        return DataUtil.equals(getPartyContactMechPurposeId(), purpose.getPartyContactMechPurposeId())
            && DataUtil.isEquivalent(getContactMechPurpose(), purpose.getContactMechPurpose())
            && DataUtil.equals(getPartyContactMech(), purpose.getPartyContactMech())
            && DataUtil.equals(getFromDate(), purpose.getFromDate())
            && DataUtil.equals(getThruDate(), purpose.getThruDate());
    }

    /* (non-Javadoc)
     * @see core.data.model.contact.PartyContactMechPurpose#setContactMechPurpose(core.data.model.contact.ContactMechPurpose)
     */
    public void setContactMechPurpose(ContactMechPurpose contactMechPurpose)
    {
        this.contactMechPurpose = contactMechPurpose;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    
    /* (non-Javadoc)
     * @see core.data.model.contact.PartyContactMechPurpose#setFromDate(java.sql.Date)
     */
    public void setFromDate(Date fromDate)
    {
        this.fromDate = fromDate;
    }

    
    public void setId(Integer id)
    {
        setPartyContactMechPurposeId(id);

    }

    /**
     * Setter for partyContactMech
     *
     * @param partyContactMech the partyContactMech to set
     */
    public void setPartyContactMech(PartyContactMech partyContactMech)
    {
        this.partyContactMech = partyContactMech;
    }

    /* (non-Javadoc)
     * @see core.data.model.contact.PartyContactMechPurpose#setPartyContactMechPurposeId(java.lang.Integer)
     */
    public void setPartyContactMechPurposeId(Integer partyContactMechPurposeId)
    {
        this.partyContactMechPurposeId = partyContactMechPurposeId;
    }

    

    /* (non-Javadoc)
     * @see core.data.model.contact.PartyContactMechPurpose#setThruDate(java.sql.Date)
     */
    public void setThruDate(Date thruDate)
    {
        this.thruDate = thruDate;
    }

    public void setVersion(Integer version)
    {
        this.version = version;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    public String toString()
    {
        return "PartyContactMechPurpose("
            + "partyContactMechPurposeId="
            + getPartyContactMechPurposeId()
            + ",partyContactMechId="
            + DataUtil.getId(getPartyContactMech())
            + ",contactMechPurpose="
            + getContactMechPurpose()
            + ",fromDate="
            + getFromDate()
            + ",thruDate="
            + getThruDate()
            + ")";
    }


}
