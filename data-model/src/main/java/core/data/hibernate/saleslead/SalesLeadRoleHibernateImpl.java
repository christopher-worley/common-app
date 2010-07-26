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
package core.data.hibernate.saleslead;


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

import net.sf.gilead.pojo.java5.LightEntity;
import core.data.hibernate.party.PartyHibernateImpl;
import core.data.hibernate.party.RoleTypeHibernateImpl;
import core.data.model.party.Party;
import core.data.model.party.RoleType;
import core.data.model.saleslead.SalesLead;
import core.data.model.saleslead.SalesLeadRole;
import core.data.model.util.DataUtil;

@Entity
@Table (name="sales_lead_role")
public class SalesLeadRoleHibernateImpl extends LightEntity implements SalesLeadRole
{
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="sales_lead_role_id")
    private Integer salesLeadRoleId;
    
    @ManyToOne (targetEntity=SalesLeadHibernateImpl.class)
    @JoinColumn (name="sales_lead_id")
    private SalesLead salesLead;
    
    @ManyToOne (cascade={CascadeType.ALL}, targetEntity=PartyHibernateImpl.class)
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
     * @see core.data.model.saleslead.SalesLeadRole#getFromDate()
     */
    public Date getFromDate()
    {
        return fromDate;
    }

    
    public Integer getId()
    {
        return getSalesLeadRoleId();
    }
    
    /* (non-Javadoc)
     * @see core.data.model.saleslead.SalesLeadRole#getParty()
     */
    public Party getParty()
    {
        return party;
    }
    
    /* (non-Javadoc)
     * @see core.data.model.saleslead.SalesLeadRole#getRoleType()
     */
    public RoleType getRoleType()
    {
        return roleType;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.SalesLeadRole#getSalesLead()
     */
    public SalesLead getSalesLead()
    {
        return salesLead;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.SalesLeadRole#getSalesLeadRoleId()
     */
    public Integer getSalesLeadRoleId()
    {
        return salesLeadRoleId;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.SalesLeadRole#getThruDate()
     */
    public Date getThruDate()
    {
        return thruDate;
    }

    
    public boolean isEquivalent(Object object)
    {
        SalesLeadRole role = (SalesLeadRole) object;
        return DataUtil.equals(getSalesLeadRoleId(), role.getSalesLeadRoleId())
                && DataUtil.isEquivalent(getSalesLead(), role.getSalesLead())
                && DataUtil.isEquivalent(getParty(), role.getParty())
                && DataUtil.isEquivalent(getRoleType(), role.getRoleType())
                && DataUtil.equals(getFromDate(), role.getFromDate())
                && DataUtil.equals(getThruDate(), role.getThruDate());
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.SalesLeadRole#setFromDate(java.sql.Date)
     */
    public void setFromDate(Date fromDate)
    {
        this.fromDate = fromDate;
    }

    
    public void setId(Integer id)
    {
        setSalesLeadRoleId(id);
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.SalesLeadRole#setParty(core.data.model.party.Party)
     */
    public void setParty(Party party)
    {
        this.party = party;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.SalesLeadRole#setRoleType(core.data.model.party.RoleType)
     */
    public void setRoleType(RoleType roleType)
    {
        this.roleType = roleType;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.SalesLeadRole#setSalesLead(core.data.model.saleslead.SalesLead)
     */
    public void setSalesLead(SalesLead salesLead)
    {
        this.salesLead = salesLead;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.SalesLeadRole#setSalesLeadRoleId(java.lang.Integer)
     */
    public void setSalesLeadRoleId(Integer proposalRoleId)
    {
        this.salesLeadRoleId = proposalRoleId;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.SalesLeadRole#setThruDate(java.sql.Date)
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
        return "SalesLeadRole("
            + "salesLeadRoleId="
            + getSalesLeadRoleId()
            + ",salesLeadId="
            + DataUtil.getId(getSalesLead())
            + ",party="
            + getParty()
            + ",roleType="
            + getRoleType()
            + ",fromDate="
            + getFromDate()
            + ",thruDate="
            + getThruDate()
            + ")";
    }

}
