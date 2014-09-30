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
import core.data.model.party.PartyRole;
import core.data.model.party.RoleType;
import core.data.model.util.DataUtil;

/**
 * Party role contains roles that a party has in the system
 * 
 * @author cworley
 * 
 */
@Entity
@Table(name = "party_role")
public class PartyRoleJpaImpl implements PartyRole
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "party_role_id")
    private Integer partyRoleId;

    @ManyToOne (cascade={CascadeType.ALL}, targetEntity=PartyJpaImpl.class)
    @JoinColumn(name = "party_id", nullable=false)
    private Party party;

    @ManyToOne (targetEntity=RoleTypeJpaImpl.class)
    @JoinColumn(name = "role_type_id", nullable=false)
    private RoleType roleType;

    @Column(name = "from_date")
    private Date fromDate;

    @Column(name = "thru_date")
    private Date thruDate;

    @Override
    public boolean equals(Object obj)
    {
        PartyRole right = (PartyRole) obj;
        return super.equals(obj)
            && DataUtil.equals(getPartyRoleId(), right.getPartyRoleId())
            && DataUtil.equals(getParty(), right.getParty())
            && DataUtil.equals(getRoleType(), right.getRoleType())
            && DataUtil.equals(getFromDate(), right.getFromDate())
            && DataUtil.equals(getThruDate(), right.getThruDate());
    }

    
    /* (non-Javadoc)
     * @see core.data.model.party.PartyRole#getFromDate()
     */
    public Date getFromDate()
    {
        return fromDate;
    }

    public Integer getId()
    {
        return getPartyRoleId();
    }

    /* (non-Javadoc)
     * @see core.data.model.party.PartyRole#getParty()
     */
    public Party getParty()
    {
        return party;
    }

    /* (non-Javadoc)
     * @see core.data.model.party.PartyRole#getPartyRoleId()
     */
    public Integer getPartyRoleId()
    {
        return partyRoleId;
    }

    /* (non-Javadoc)
     * @see core.data.model.party.PartyRole#getRoleType()
     */
    public RoleType getRoleType()
    {
        return roleType;
    }

    
    /* (non-Javadoc)
     * @see core.data.model.party.PartyRole#getThruDate()
     */
    public Date getThruDate()
    {
        return thruDate;
    }

    public boolean isEquivalent(Object object)
    {
        PartyRole role = (PartyRole) object;
        return DataUtil.equals(getPartyRoleId(), role.getPartyRoleId())
            && DataUtil.isEquivalent(getParty(), role.getParty())
            && DataUtil.isEquivalent(getRoleType(), role.getRoleType())
            && DataUtil.equals(getFromDate(), role.getFromDate())
            && DataUtil.equals(getThruDate(), role.getThruDate());
    }

    
    /* (non-Javadoc)
     * @see core.data.model.party.PartyRole#setFromDate(java.sql.Date)
     */
    public void setFromDate(Date fromDate)
    {
        this.fromDate = fromDate;
    }

    public void setId(Integer id)
    {
        setPartyRoleId(id);
    }

    /* (non-Javadoc)
     * @see core.data.model.party.PartyRole#setParty(core.data.model.party.Party)
     */
    public void setParty(Party party)
    {
        this.party = party;
    }


    /* (non-Javadoc)
     * @see core.data.model.party.PartyRole#setPartyRoleId(java.lang.Integer)
     */
    public void setPartyRoleId(Integer partyRoleId)
    {
        this.partyRoleId = partyRoleId;
    }

    /* (non-Javadoc)
     * @see core.data.model.party.PartyRole#setRoleType(core.data.model.party.RoleType)
     */
    public void setRoleType(RoleType roleType)
    {
        this.roleType = roleType;
    }

    /* (non-Javadoc)
     * @see core.data.model.party.PartyRole#setThruDate(java.sql.Date)
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
        return "PartyRole("
            + ",partyRoleId="
            + getPartyRoleId()
            + ",partyId="
            + DataUtil.getId(getParty())
            + ",roleType="
            + getRoleType()
            + ",fromDate="
            + getFromDate()
            + ",thruDate="
            + getThruDate()
            + ")";
    }

}
