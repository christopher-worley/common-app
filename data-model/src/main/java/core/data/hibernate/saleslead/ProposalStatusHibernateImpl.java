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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.sf.gilead.pojo.java5.LightEntity;
import core.data.hibernate.status.StatusHibernateImpl;
import core.data.model.saleslead.Proposal;
import core.data.model.saleslead.ProposalStatus;
import core.data.model.status.Status;
import core.data.model.util.DataUtil;

@Entity
@Table (name="proposal_status")
public class ProposalStatusHibernateImpl extends LightEntity implements ProposalStatus
{
 
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column
    private Integer proposalStatusId;
    
    @ManyToOne (targetEntity=ProposalHibernateImpl.class)
    @JoinColumn (name="proposal_id")
    private Proposal proposal;
    
    @ManyToOne (targetEntity=StatusHibernateImpl.class)
    @JoinColumn (name="status_id")
    private Status status;

    @Column (name="from_date")
    private Date fromDate;

    @Column (name="thru_date")
    private Date thruDate;
    

    /* (non-Javadoc)
     * @see core.data.model.saleslead.ProposalStatus#getFromDate()
     */
    public Date getFromDate()
    {
        return fromDate;
    }

    
    public Integer getId()
    {
        return getProposalStatusId();
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.ProposalStatus#getProposal()
     */
    public Proposal getProposal()
    {
        return proposal;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.ProposalStatus#getProposalStatusId()
     */
    public Integer getProposalStatusId()
    {
        return proposalStatusId;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.ProposalStatus#getStatus()
     */
    public Status getStatus()
    {
        return status;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.ProposalStatus#getThruDate()
     */
    public Date getThruDate()
    {
        return thruDate;
    }

    
    public boolean isEquivalent(Object object)
    {
        ProposalStatus status = (ProposalStatus) object;
        return DataUtil.equals(getProposalStatusId(), status.getProposalStatusId())
            && DataUtil.isEquivalent(getProposal(), status.getProposal())
            && DataUtil.isEquivalent(getStatus(), status.getStatus())
            && DataUtil.equals(getFromDate(), status.getFromDate())
            && DataUtil.equals(getThruDate(), status.getThruDate());
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.ProposalStatus#setFromDate(java.sql.Date)
     */
    public void setFromDate(Date fromDate)
    {
        this.fromDate = fromDate;
    }

    
    public void setId(Integer id)
    {
        setProposalStatusId(id);
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.ProposalStatus#setProposal(core.data.model.saleslead.Proposal)
     */
    public void setProposal(Proposal proposal)
    {
        this.proposal = proposal;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.ProposalStatus#setProposalStatusId(java.lang.Integer)
     */
    public void setProposalStatusId(Integer proposalStatusId)
    {
        this.proposalStatusId = proposalStatusId;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.ProposalStatus#setStatus(core.data.model.status.Status)
     */
    public void setStatus(Status status)
    {
        this.status = status;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.ProposalStatus#setThruDate(java.sql.Date)
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
        return "ProposalStatus("
            + "proposalStatusId="
            + getProposalStatusId()
            + ",proposal="
            + getProposal()
            + ",status="
            + getStatus()
            + ",fromDate="
            + getFromDate()
            + ",thruDate="
            + getThruDate()
            + ")";
    }

}
