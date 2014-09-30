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
package core.data.model.jpa.billing;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import core.data.model.billing.BillingAccountType;
import core.data.model.util.DataUtil;

@Entity
@Table (name="billing_account_type")
public class BillingAccountTypeJpaImpl implements BillingAccountType
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column (name="billing_account_type_id")
    private Integer billingAccountTypeId;
    
    @Column (name="description")
    private String description;

    @Column (name="key")
    private String key;

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    
    public boolean equals(Object obj)
    {
        // TODO data object equals
        return super.equals(obj);
    }

    /**
     * Getter for billingAccountTypeId
     *
     * @return the billingAccountTypeId
     */
    public Integer getBillingAccountTypeId()
    {
        return billingAccountTypeId;
    }

    /* (non-Javadoc)
     * @see core.data.model.billing.IBillingAccountType#getDescription()
     */
    public String getDescription()
    {
        return description;
    }

    /* (non-Javadoc)
     * @see core.data.DataObject#getId()
     */
    
    public Integer getId()
    {
        return getBillingAccountTypeId();
    }

    /**
     * Getter for key
     *
     * @return the key
     */
    public String getKey()
    {
        return key;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    
    public int hashCode()
    {
        // TODO data object hash code
        return super.hashCode();
    }

    /* (non-Javadoc)
     * @see core.data.DataObject#isEquivalent(java.lang.Object)
     */
    
    public boolean isEquivalent(Object object)
    {
        BillingAccountTypeJpaImpl type = (BillingAccountTypeJpaImpl) object;
        return DataUtil.equals(getBillingAccountTypeId(), type.getBillingAccountTypeId())
            && DataUtil.equals(getDescription(), type.getDescription())
            && DataUtil.equals(getKey(), type.getKey());
    }

    /* (non-Javadoc)
     * @see core.data.model.billing.IBillingAccountType#setBillingAccountTypeId(java.lang.Integer)
     */
    public void setBillingAccountTypeId(Integer billingAccountTypeId)
    {
        this.billingAccountTypeId = billingAccountTypeId;
    }

    /* (non-Javadoc)
     * @see core.data.model.billing.IBillingAccountType#setDescription(java.lang.String)
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /* (non-Javadoc)
     * @see core.data.DataObject#setId(java.lang.Integer)
     */
    
    public void setId(Integer id)
    {
        setBillingAccountTypeId(id);        
    }

    /**
     * Setter for key
     *
     * @param key the key to set
     */
    public void setKey(String key)
    {
        this.key = key;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    public String toString()
    {
        return "BillingAccountType("
            + "billingAccountTypeId="
            + getBillingAccountTypeId()
            + ",description="
            + getDescription()
            + ",key="
            + getKey()
            + ")";
    }

}
