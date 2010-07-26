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
package core.data.model.saleslead;

import java.util.Date;
import java.util.List;

import core.data.model.DataObject;

public interface Proposal extends DataObject
{

    /**
     * Getter for createdDate
     *
     * @return the createdDate
     */
    public abstract Date getCreatedDate();

    /**
     * Getter for proposalId
     *
     * @return the proposalId
     */
    public abstract Integer getProposalId();

    /**
     * Getter for proposalItems
     *
     * @return the proposalItems
     */
    public abstract List<ProposalItem> getProposalItems();

    /**
     * Getter for proposalStatus
     *
     * @return the proposalStatus
     */
    public abstract List<ProposalStatus> getProposalStatus();

    /**
     * Getter for proposalType
     *
     * @return the proposalType
     */
    public abstract ProposalType getProposalType();

    /**
     * Getter for salesLead
     *
     * @return the salesLead
     */
    public abstract SalesLead getSalesLead();

    /**
     * Getter for title
     *
     * @return the title
     */
    public abstract String getTitle();

    /**
     * Setter for createdDate
     *
     * @param createdDate the createdDate to set
     */
    public abstract void setCreatedDate(Date createdDate);

    /**
     * Setter for proposalId
     *
     * @param proposalId the proposalId to set
     */
    public abstract void setProposalId(Integer proposalId);

    /**
     * Setter for proposalItems
     *
     * @param proposalItems the proposalItems to set
     */
    public abstract void setProposalItems(List<ProposalItem> proposalItems);

    /**
     * Setter for proposalStatus
     *
     * @param proposalStatus the proposalStatus to set
     */
    public abstract void setProposalStatus(List<ProposalStatus> proposalStatus);

    /**
     * Setter for proposalType
     *
     * @param proposalType the proposalType to set
     */
    public abstract void setProposalType(ProposalType proposalType);

    /**
     * Setter for salesLead
     *
     * @param salesLead the salesLead to set
     */
    public abstract void setSalesLead(SalesLead salesLead);

    /**
     * Setter for title
     *
     * @param title the title to set
     */
    public abstract void setTitle(String title);

}