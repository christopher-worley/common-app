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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import core.data.hibernate.product.ProductHibernateImpl;
import core.data.model.product.Product;
import core.data.model.saleslead.Proposal;
import core.data.model.saleslead.ProposalItem;
import core.data.model.util.DataUtil;

@Entity
@Table (name="proposal_item")
public class ProposalItemHibernateImpl implements ProposalItem
{
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="proposal_item_id")
    private Integer proposalItemId;
    
    @ManyToOne (targetEntity=ProposalHibernateImpl.class)
    @JoinColumn (name="proposal_id")
    private Proposal proposal;
    
    @ManyToOne (targetEntity=ProductHibernateImpl.class) 
    @JoinColumn (name="product_id")
    private Product product;
    
    @Column (name="item_description")
    private String itemDescription;
    
    @Column (name="quantity")
    private Double quantity;

    @Column (name="amount")
    private Double amount;

    /* (non-Javadoc)
     * @see core.data.model.saleslead.ProposalItem#getAmount()
     */
    public Double getAmount()
    {
        return amount;
    }

    
    public Integer getId()
    {
        return getProposalItemId();
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.ProposalItem#getItemDescription()
     */
    public String getItemDescription()
    {
        return itemDescription;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.ProposalItem#getProduct()
     */
    public Product getProduct()
    {
        return product;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.ProposalItem#getProposal()
     */
    public Proposal getProposal()
    {
        return proposal;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.ProposalItem#getProposalItemId()
     */
    public Integer getProposalItemId()
    {
        return proposalItemId;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.ProposalItem#getQuantity()
     */
    public Double getQuantity()
    {
        return quantity;
    }

    
    public boolean isEquivalent(Object object)
    {
        ProposalItem item = (ProposalItem) object;
        return DataUtil.equals(getProposalItemId(), item.getProposalItemId())
            && DataUtil.isEquivalent(getProposal(), item.getProposal())
            && DataUtil.isEquivalent(getProduct(), item.getProduct())
            && DataUtil.equals(getItemDescription(), item.getItemDescription())
            && DataUtil.equals(getQuantity(), item.getQuantity())
            && DataUtil.equals(getAmount(), item.getAmount());
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.ProposalItem#setAmount(java.math.Double)
     */
    public void setAmount(Double amont)
    {
        this.amount = amont;
    }

    
    public void setId(Integer id)
    {
        setProposalItemId(id);
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.ProposalItem#setItemDescription(java.lang.String)
     */
    public void setItemDescription(String itemDescription)
    {
        this.itemDescription = itemDescription;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.ProposalItem#setProduct(core.data.model.product.Product)
     */
    public void setProduct(Product product)
    {
        this.product = product;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.ProposalItem#setProposal(core.data.model.saleslead.Proposal)
     */
    public void setProposal(Proposal proposal)
    {
        this.proposal = proposal;
    }
    
    /* (non-Javadoc)
     * @see core.data.model.saleslead.ProposalItem#setProposalItemId(java.lang.Integer)
     */
    public void setProposalItemId(Integer proposalItemId)
    {
        this.proposalItemId = proposalItemId;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.ProposalItem#setQuantity(java.math.Double)
     */
    public void setQuantity(Double quantity)
    {
        this.quantity = quantity;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    public String toString()
    {
        return "ProposalItem("
            + "proposalItemId="
            + getProposalItemId()
            + "proposalId="
            + DataUtil.getId(getProposal())
            + "product="
            + getProduct()
            + "itemDescription="
            + getItemDescription()
            + "quantity="
            + getQuantity()
            + "amount="
            + getAmount()
            + ")";
    }

}
