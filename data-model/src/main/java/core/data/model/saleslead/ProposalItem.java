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


import core.data.model.DataObject;
import core.data.model.product.Product;

public interface ProposalItem extends DataObject
{

    /**
     * Getter for amount
     *
     * @return the amount
     */
    public abstract Double getAmount();

    /**
     * Getter for itemDescription
     *
     * @return the itemDescription
     */
    public abstract String getItemDescription();

    /**
     * Getter for product
     *
     * @return the product
     */
    public abstract Product getProduct();

    /**
     * Getter for proposal
     *
     * @return the proposal
     */
    public abstract Proposal getProposal();

    /**
     * Getter for proposalItemId
     *
     * @return the proposalItemId
     */
    public abstract Integer getProposalItemId();

    /**
     * Getter for quantity
     *
     * @return the quantity
     */
    public abstract Double getQuantity();

    /**
     * Setter for amount
     *
     * @param amont the amount to set
     */
    public abstract void setAmount(Double amont);

    /**
     * Setter for itemDescription
     *
     * @param itemDescription the itemDescription to set
     */
    public abstract void setItemDescription(String itemDescription);

    /**
     * Setter for product
     *
     * @param product the product to set
     */
    public abstract void setProduct(Product product);

    /**
     * Setter for proposal
     *
     * @param proposal the proposal to set
     */
    public abstract void setProposal(Proposal proposal);

    /**
     * Setter for proposalItemId
     *
     * @param proposalItemId the proposalItemId to set
     */
    public abstract void setProposalItemId(Integer proposalItemId);

    /**
     * Setter for quantity
     *
     * @param quantity the quantity to set
     */
    public abstract void setQuantity(Double quantity);

}