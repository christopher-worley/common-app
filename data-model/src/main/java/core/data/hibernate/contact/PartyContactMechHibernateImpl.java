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
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import core.data.hibernate.party.PartyHibernateImpl;
import core.data.model.contact.ContactMech;
import core.data.model.contact.PartyContactMech;
import core.data.model.contact.PartyContactMechPurpose;
import core.data.model.party.Party;
import core.data.model.util.DataUtil;

@Entity
@Table(name = "party_contact_mech")
public class PartyContactMechHibernateImpl implements PartyContactMech
{

    /**
	 * 
	 */
    private static final long serialVersionUID = -4686418032110918661L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "party_contact_mech_id")
    private Integer partyContactMechId;

    @ManyToOne(cascade =
    { CascadeType.ALL }, targetEntity = PartyHibernateImpl.class)
    @JoinColumn(name = "party_id")
    private Party party;

    @ManyToOne(cascade =
    { CascadeType.ALL }, targetEntity = ContactMechHibernateImpl.class)
    @JoinColumn(name = "contact_mech_id")
    private ContactMech contactMech;

    @Column(name = "from_date")
    private Date fromDate;

    @Column(name = "thru_date")
    private Date thruDate;

    @OneToMany(mappedBy = "partyContactMech", cascade =
    { CascadeType.ALL }, targetEntity = PartyContactMechPurposeHibernateImpl.class)
    private List<PartyContactMechPurpose> partyContactMechPurposes;

    @Version
    @Column(name="version")
    private Integer version;
    
    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object obj)
    {
        // TODO data object equals
        return super.equals(obj);
    }

    /*
     * (non-Javadoc)
     * 
     * @see core.data.model.contact.PartyContactMech#getContactMech()
     */
    public ContactMech getContactMech()
    {
        return contactMech;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see core.data.model.contact.PartyContactMech#getFromDate()
     */
    public Date getFromDate()
    {
        return fromDate;
    }

    public Integer getId()
    {
        return getPartyContactMechId();
    }

    /*
     * (non-Javadoc)
     * 
     * @see core.data.model.contact.PartyContactMech#getParty()
     */
    public Party getParty()
    {
        return party;
    }

    /*
     * (non-Javadoc)
     * 
     * @see core.data.model.contact.PartyContactMech#getPartyContactMechId()
     */
    public Integer getPartyContactMechId()
    {
        return partyContactMechId;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * core.data.model.contact.PartyContactMech#getPartyContactMechPurposes()
     */
    public List<PartyContactMechPurpose> getPartyContactMechPurposes()
    {
        return partyContactMechPurposes;
    }

    /*
     * (non-Javadoc)
     * 
     * @see core.data.model.contact.PartyContactMech#getThruDate()
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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */

    public boolean isEquivalent(Object object)
    {
        PartyContactMech partyContactMech = (PartyContactMech) object;
        return DataUtil.equals(getPartyContactMechId(), partyContactMech.getPartyContactMechId())
                && DataUtil.isEquivalent(getParty(), partyContactMech.getParty())
                && DataUtil.isEquivalent(getContactMech(), partyContactMech.getContactMech())
                && DataUtil.equals(getFromDate(), partyContactMech.getFromDate())
                && DataUtil.equals(getThruDate(), partyContactMech.getThruDate())
                && DataUtil.isEquivalent(getPartyContactMechPurposes(), partyContactMech.getPartyContactMechPurposes());
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * core.data.model.contact.PartyContactMech#setContactMech(core.data.model
     * .contact.ContactMech)
     */
    public void setContactMech(ContactMech contactMech)
    {
        this.contactMech = contactMech;
    }

    /*
     * (non-Javadoc)
     * 
     * @see core.data.model.contact.PartyContactMech#setFromDate(java.sql.Date)
     */
    public void setFromDate(Date fromDate)
    {
        this.fromDate = fromDate;
    }

    public void setId(Integer id)
    {
        setPartyContactMechId(id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see core.data.model.contact.PartyContactMech#setId(java.lang.Integer)
     */

    /**
     * Setter for party
     * 
     * @param party
     *            the party to set
     */
    public void setParty(Party party)
    {
        this.party = party;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * core.data.model.contact.PartyContactMech#setPartyContactMechId(java.lang
     * .Integer)
     */
    public void setPartyContactMechId(Integer partyContactMechId)
    {
        this.partyContactMechId = partyContactMechId;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * core.data.model.contact.PartyContactMech#setPartyContactMechPurposes(
     * java.util.List)
     */
    public void setPartyContactMechPurposes(List<PartyContactMechPurpose> partyContactMechPurposes)
    {
        this.partyContactMechPurposes = partyContactMechPurposes;
    }

    /*
     * (non-Javadoc)
     * 
     * @see core.data.model.contact.PartyContactMech#setThruDate(java.sql.Date)
     */
    public void setThruDate(Date thruDate)
    {
        this.thruDate = thruDate;
    }

    public void setVersion(Integer version)
    {
        this.version = version;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

    public String toString()
    {
        return "PartyContactMech(" + "partyContactMechId=" + getPartyContactMechId() + ",partyId="
                + DataUtil.getId(getParty()) + ",contactMech=" + DataUtil.getId(getContactMech()) + ",fromDate="
                + getFromDate() + ",thruDate=" + getThruDate() + ")";
    }

}
