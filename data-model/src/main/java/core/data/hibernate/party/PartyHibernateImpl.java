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
package core.data.hibernate.party;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import net.sf.gilead.pojo.java5.LightEntity;
import core.data.hibernate.contact.PartyContactMechHibernateImpl;
import core.data.model.contact.PartyContactMech;
import core.data.model.party.Party;
import core.data.model.party.PartyRelationship;
import core.data.model.party.PartyRole;
import core.data.model.party.PartyType;
import core.data.model.util.DataUtil;

/**
 * Base class for all party types
 * 
 * @author cworley
 * 
 */
@Entity
@Table(name = "party")
@Inheritance(strategy=InheritanceType.JOINED)
public class PartyHibernateImpl extends LightEntity implements Party
{

    /**
     * 
     */
    private static final long serialVersionUID = -5039407398232008003L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "party_id", nullable = false)
    private Integer partyId;

    @ManyToOne (targetEntity=PartyTypeHibernateImpl.class)
    @JoinColumn(name = "party_type_id")
    private PartyType partyType;

    @OneToMany (mappedBy="party", cascade={CascadeType.ALL}, fetch=FetchType.EAGER, targetEntity=PartyRoleHibernateImpl.class)
    @JoinColumn(name="party_id")
    private List<PartyRole> partyRoles;

    @OneToMany (mappedBy="party", cascade={CascadeType.ALL}, fetch=FetchType.LAZY, targetEntity=PartyContactMechHibernateImpl.class)
    @JoinColumn(name="party_id")
    private List<PartyContactMech> partyContactMechs;

    @OneToMany (mappedBy="partyTo", cascade={CascadeType.ALL}, fetch=FetchType.LAZY, targetEntity=PartyRelationshipHibernateImpl.class)
    @JoinColumn(name="party_id_to")
    private List<PartyRelationship> partyToRelationships;

    @OneToMany (mappedBy="partyFrom", cascade={CascadeType.ALL}, fetch=FetchType.LAZY, targetEntity=PartyRelationshipHibernateImpl.class)
    @JoinColumn(name="party_id_from")
    private List<PartyRelationship> partyFromRelationships;
    
    @Version
    @Column(name="version")
    private Integer version;
    
    public Integer getId()
    {
        return getPartyId();
    }

    /* (non-Javadoc)
     * @see core.data.model.party.Party#getPartyContactMechs()
     */
    public List<PartyContactMech> getPartyContactMechs()
    {
        return partyContactMechs;
    }

    /**
     * Getter for partyFromRelationships
     *
     * @return the partyFromRelationships
     */
    public List<PartyRelationship> getPartyFromRelationships()
    {
        return partyFromRelationships;
    }

    /* (non-Javadoc)
     * @see core.data.model.party.Party#getPartyId()
     */
    public Integer getPartyId()
    {
        return partyId;
    }

    /* (non-Javadoc)
     * @see core.data.model.party.Party#getPartyRoles()
     */
    public List<PartyRole> getPartyRoles()
    {
        return partyRoles;
    }

    /**
     * Getter for partyToRelationships
     *
     * @return the partyToRelationships
     */
    public List<PartyRelationship> getPartyToRelationships()
    {
        return partyToRelationships;
    }

    
    /* (non-Javadoc)
     * @see core.data.model.party.Party#getPartyType()
     */
    public PartyType getPartyType()
    {
        return partyType;
    }

    public Integer getVersion()
    {
        return version;
    }

    public boolean isEquivalent(Object object)
    {
        Party party = (Party) object;
        return DataUtil.equals(getPartyId(), party.getPartyId())
            && DataUtil.isEquivalent(getPartyType(), party.getPartyType())
            && DataUtil.isEquivalent(getPartyRoles(), party.getPartyRoles())
            && DataUtil.isEquivalent(getPartyContactMechs(), party.getPartyContactMechs());
    }

    public void setId(Integer id)
    {
        setPartyId(id);
    }

    /* (non-Javadoc)
     * @see core.data.model.party.Party#setPartyContactMechs(java.util.List)
     */
    public void setPartyContactMechs(List<PartyContactMech> partyContactMechs)
    {
        this.partyContactMechs = partyContactMechs;
    }

    
    /**
     * Setter for partyFromRelationships
     *
     * @param partyFromRelationships the partyFromRelationships to set
     */
    public void setPartyFromRelationships(List<PartyRelationship> partyFromRelationships)
    {
        this.partyFromRelationships = partyFromRelationships;
    }

    
    /* (non-Javadoc)
     * @see core.data.model.party.Party#setPartyId(java.lang.Integer)
     */
    public void setPartyId(Integer partyId)
    {
        this.partyId = partyId;
    }

    /* (non-Javadoc)
     * @see core.data.model.party.Party#setPartyRoles(java.util.List)
     */
    public void setPartyRoles(List<PartyRole> partyRoles)
    {
        this.partyRoles = partyRoles;
    }

    /**
     * Setter for partyToRelationships
     *
     * @param partyToRelationships the partyToRelationships to set
     */
    public void setPartyToRelationships(List<PartyRelationship> partyToRelationships)
    {
        this.partyToRelationships = partyToRelationships;
    }

    /* (non-Javadoc)
     * @see core.data.model.party.Party#setPartyType(core.data.model.party.PartyType)
     */
    public void setPartyType(PartyType partyType)
    {
        this.partyType = partyType;
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
        return "Party("
            + "partyId="
            + getPartyId()
            + ",partyTypeId="
            + getPartyType()
// TODO: watch out for no session
//            + ",partyRoles="
//            + getPartyRoles()
//            + ",partyContactMechs="
//            + getPartyContactMechs()
            + ")";
    }

}
