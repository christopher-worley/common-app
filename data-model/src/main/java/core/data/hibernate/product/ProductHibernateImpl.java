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
package core.data.hibernate.product;

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
import core.data.model.product.Product;
import core.data.model.product.ProductType;
import core.data.model.util.DataUtil;

@Entity
@Table (name="product")
public class ProductHibernateImpl extends LightEntity implements Product
{
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="product_id")
    private Integer productId;
    
    @ManyToOne (targetEntity=ProductTypeHibernateImpl.class)
    @JoinColumn (name="product_type_id")
    private ProductType productType;

    @Column (name="created_date")
    private Date createdDate;

    @Column (name="product_name")
    private String productName;

    @Column (name="description")
    private String description;
    
    /* (non-Javadoc)
     * @see core.data.model.product.Product#getCreatedDate()
     */
    public Date getCreatedDate()
    {
        return createdDate;
    }

    /* (non-Javadoc)
     * @see core.data.model.product.Product#getDescription()
     */
    public String getDescription()
    {
        return description;
    }

    
    public Integer getId()
    {
        return getProductId();
    }

    /* (non-Javadoc)
     * @see core.data.model.product.Product#getProductId()
     */
    public Integer getProductId()
    {
        return productId;
    }

    /* (non-Javadoc)
     * @see core.data.model.product.Product#getProductName()
     */
    public String getProductName()
    {
        return productName;
    }

    /* (non-Javadoc)
     * @see core.data.model.product.Product#getProductType()
     */
    public ProductType getProductType()
    {
        return productType;
    }

    
    public boolean isEquivalent(Object object)
    {
        Product product = (Product) object;
        return DataUtil.equals(getProductId(), product.getProductId())
            && DataUtil.isEquivalent(getProductType(), product.getProductType())
            && DataUtil.equals(getCreatedDate(), product.getCreatedDate())
            && DataUtil.equals(getProductName(), product.getProductName())
            && DataUtil.equals(getDescription(), product.getDescription());
    }

    /* (non-Javadoc)
     * @see core.data.model.product.Product#setCreatedDate(java.sql.Date)
     */
    public void setCreatedDate(Date createdDate)
    {
        this.createdDate = createdDate;
    }

    /* (non-Javadoc)
     * @see core.data.model.product.Product#setDescription(java.lang.String)
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    
    public void setId(Integer id)
    {
        setProductId(id);
    }

    /* (non-Javadoc)
     * @see core.data.model.product.Product#setProductId(java.lang.Integer)
     */
    public void setProductId(Integer productId)
    {
        this.productId = productId;
    }

    /* (non-Javadoc)
     * @see core.data.model.product.Product#setProductName(java.lang.String)
     */
    public void setProductName(String productName)
    {
        this.productName = productName;
    }
    
    /* (non-Javadoc)
     * @see core.data.model.product.Product#setProductType(core.data.model.product.ProductType)
     */
    public void setProductType(ProductType productType)
    {
        this.productType = productType;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    public String toString()
    {
        return "Product("
            + "productId="
            + getProductId()
            + ",productType="
            + getProductType()
            + ",createdDate="
            + getCreatedDate()
            + ",productName="
            + getProductName()
            + ",description="
            + getDescription()
            + ")";
    }

}
