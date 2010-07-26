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

import net.sf.gilead.pojo.java5.LightEntity;
import core.data.model.saleslead.Proposal;
import core.data.model.saleslead.ProposalItem;
import core.data.model.saleslead.ProposalStatus;
import core.data.model.saleslead.ProposalType;
import core.data.model.saleslead.SalesLead;
import core.data.model.util.DataUtil;

@Entity
@Table (name="proposal")
public class ProposalHibernateImpl extends LightEntity implements Proposal
{
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="proposal_id")
    private Integer proposalId;
    
    @ManyToOne (targetEntity=ProposalTypeHibernateImpl.class)
    @JoinColumn (name="proposal_type_id")
    private ProposalType proposalType;
    
    @ManyToOne (cascade={CascadeType.ALL}, targetEntity=SalesLeadHibernateImpl.class)
    @JoinColumn (name="sales_lead_id")
    private SalesLead salesLead;

    @Column (name="created_date")
    private Date createdDate;

    @Column (name="title")
    private String title;
    
    @OneToMany (cascade={CascadeType.ALL}, targetEntity=ProposalItemHibernateImpl.class)
    @JoinColumn (name="proposal_id")
    private List<ProposalItem> proposalItems;
    
    @OneToMany (cascade={CascadeType.ALL}, targetEntity=ProposalStatusHibernateImpl.class)
    @JoinColumn (name="proposal_id")
    private List<ProposalStatus> proposalStatus;
    
    /* (non-Javadoc)
     * @see core.data.model.saleslead.Proposal#getCreatedDate()
     */
    public Date getCreatedDate()
    {
        return createdDate;
    }
    
    
    public Integer getId()
    {
        return getProposalId();
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.Proposal#getProposalId()
     */
    public Integer getProposalId()
    {
        return proposalId;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.Proposal#getProposalItems()
     */
    public List<ProposalItem> getProposalItems()
    {
        return proposalItems;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.Proposal#getProposalStatus()
     */
    public List<ProposalStatus> getProposalStatus()
    {
        return proposalStatus;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.Proposal#getProposalType()
     */
    public ProposalType getProposalType()
    {
        return proposalType;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.Proposal#getSalesLead()
     */
    public SalesLead getSalesLead()
    {
        return salesLead;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.Proposal#getTitle()
     */
    public String getTitle()
    {
        return title;
    }

    
    public boolean isEquivalent(Object object)
    {
        Proposal proposal = (Proposal) object;
        return DataUtil.equals(getProposalId(), proposal.getProposalId())
            && DataUtil.isEquivalent(getSalesLead(), proposal.getSalesLead())
            && DataUtil.equals(getCreatedDate(), proposal.getCreatedDate())
            && DataUtil.equals(getTitle(), proposal.getTitle())
            && DataUtil.isEquivalent(getProposalItems(), proposal.getProposalItems())
            && DataUtil.isEquivalent(getProposalStatus(), proposal.getProposalStatus());
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.Proposal#setCreatedDate(java.sql.Date)
     */
    public void setCreatedDate(Date createdDate)
    {
        this.createdDate = createdDate;
    }

    
    public void setId(Integer id)
    {
        setProposalId(id);
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.Proposal#setProposalId(java.lang.Integer)
     */
    public void setProposalId(Integer proposalId)
    {
        this.proposalId = proposalId;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.Proposal#setProposalItems(java.util.List)
     */
    public void setProposalItems(List<ProposalItem> proposalItems)
    {
        this.proposalItems = proposalItems;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.Proposal#setProposalStatus(java.util.List)
     */
    public void setProposalStatus(List<ProposalStatus> proposalStatus)
    {
        this.proposalStatus = proposalStatus;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.Proposal#setProposalType(core.data.model.saleslead.ProposalType)
     */
    public void setProposalType(ProposalType proposalType)
    {
        this.proposalType = proposalType;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.Proposal#setSalesLead(core.data.model.saleslead.SalesLead)
     */
    public void setSalesLead(SalesLead salesLead)
    {
        this.salesLead = salesLead;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.Proposal#setTitle(java.lang.String)
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    public String toString()
    {
        return "Proposal("
            + "proposalId="
            + getProposalId()
            + ",title="
            + getTitle()
            + ",createdDate="
            + getCreatedDate()
            + ",salesLead="
            + getSalesLead()
            + ")";
    }

}
