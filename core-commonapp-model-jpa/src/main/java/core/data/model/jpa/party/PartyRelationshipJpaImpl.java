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
package core.data.model.jpa.party;


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

import core.data.model.party.Party;
import core.data.model.party.PartyRelationship;
import core.data.model.party.RoleType;
import core.data.model.util.DataUtil;

/**
 * PartyRelationship relates parties to each other and the roles each party
 * plays in the relationship
 * 
 * @author cworley
 * 
 */
@Entity
@Table(name = "party_relationship")
public class PartyRelationshipJpaImpl  implements PartyRelationship
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "party_relationship_id", nullable = false)
    private Integer partyRelationshipId;

    @ManyToOne (cascade={CascadeType.ALL}, targetEntity=PartyJpaImpl.class)
    @JoinColumn(name = "party_id_from")
    private Party partyFrom;

    @ManyToOne (targetEntity=RoleTypeJpaImpl.class)
    @JoinColumn(name = "role_type_id_from")
    private RoleType roleTypeFrom;

    @ManyToOne (cascade={CascadeType.ALL}, targetEntity=PartyJpaImpl.class)
    @JoinColumn(name = "party_id_to")
    private Party partyTo;

    @ManyToOne (targetEntity=RoleTypeJpaImpl.class)
    @JoinColumn(name = "role_type_id_to")
    private RoleType roleTypeTo;

    @Column(name = "from_date")
    private Date fromDate;

    @Column(name = "thru_date")
    private Date thruDate;

    /* (non-Javadoc)
     * @see core.data.model.party.PartyRelationship#getFromDate()
     */
    public Date getFromDate()
    {
        return fromDate;
    }

    
    public Integer getId()
    {
        return getPartyRelationshipId();
    }

    /* (non-Javadoc)
     * @see core.data.model.party.PartyRelationship#getPartyFrom()
     */
    public Party getPartyFrom()
    {
        return partyFrom;
    }

    /* (non-Javadoc)
     * @see core.data.model.party.PartyRelationship#getPartyRelationshipId()
     */
    public Integer getPartyRelationshipId()
    {
        return partyRelationshipId;
    }

    /* (non-Javadoc)
     * @see core.data.model.party.PartyRelationship#getPartyTo()
     */
    public Party getPartyTo()
    {
        return partyTo;
    }

    /* (non-Javadoc)
     * @see core.data.model.party.PartyRelationship#getRoleTypeFrom()
     */
    public RoleType getRoleTypeFrom()
    {
        return roleTypeFrom;
    }

    /* (non-Javadoc)
     * @see core.data.model.party.PartyRelationship#getRoleTypeTo()
     */
    public RoleType getRoleTypeTo()
    {
        return roleTypeTo;
    }

    /* (non-Javadoc)
     * @see core.data.model.party.PartyRelationship#getThruDate()
     */
    public Date getThruDate()
    {
        return thruDate;
    }

    
    public boolean isEquivalent(Object object)
    {
        PartyRelationship relationship = (PartyRelationship) object;
        return DataUtil.equals(getPartyRelationshipId(), relationship.getPartyRelationshipId())
            && DataUtil.isEquivalent(getPartyFrom(), relationship.getPartyFrom())
            && DataUtil.isEquivalent(getRoleTypeFrom(), relationship.getRoleTypeFrom())
            && DataUtil.isEquivalent(getPartyTo(), relationship.getPartyTo())
            && DataUtil.isEquivalent(getRoleTypeTo(), relationship.getRoleTypeTo())
            && DataUtil.equals(getFromDate(), relationship.getFromDate())
            && DataUtil.equals(getThruDate(), relationship.getThruDate());
    }

    /* (non-Javadoc)
     * @see core.data.model.party.PartyRelationship#setFromDate(java.sql.Date)
     */
    public void setFromDate(Date fromDate)
    {
        this.fromDate = fromDate;
    }

    
    public void setId(Integer id)
    {
        setPartyRelationshipId(id);
    }

    /* (non-Javadoc)
     * @see core.data.model.party.PartyRelationship#setPartyFrom(core.data.model.party.Party)
     */
    public void setPartyFrom(Party partyFrom)
    {
        this.partyFrom = partyFrom;
    }

    /* (non-Javadoc)
     * @see core.data.model.party.PartyRelationship#setPartyRelationshipId(java.lang.Integer)
     */
    public void setPartyRelationshipId(Integer partyRelationshipId)
    {
        this.partyRelationshipId = partyRelationshipId;
    }

    /* (non-Javadoc)
     * @see core.data.model.party.PartyRelationship#setPartyTo(core.data.model.party.Party)
     */
    public void setPartyTo(Party partyTo)
    {
        this.partyTo = partyTo;
    }

    /* (non-Javadoc)
     * @see core.data.model.party.PartyRelationship#setRoleTypeFrom(core.data.model.party.RoleType)
     */
    public void setRoleTypeFrom(RoleType roleTypeFrom)
    {
        this.roleTypeFrom = roleTypeFrom;
    }

    /* (non-Javadoc)
     * @see core.data.model.party.PartyRelationship#setRoleTypeTo(core.data.model.party.RoleType)
     */
    public void setRoleTypeTo(RoleType roleTypeTo)
    {
        this.roleTypeTo = roleTypeTo;
    }

    /* (non-Javadoc)
     * @see core.data.model.party.PartyRelationship#setThruDate(java.sql.Date)
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
        return "PartyRelationship("
            + "partyRelationshipId="
            + getPartyRelationshipId()
            + ",partyFrom="
            + getPartyFrom()
            + ",roleTypeFrom="
            + getRoleTypeFrom()
            + ",partyTo"
            + getPartyTo()
            + ",roleTypeTo="
            + getRoleTypeTo()
            + ",fromDate="
            + getFromDate()
            + ",thruDate="
            + getThruDate()
            + ")";
    }

}
