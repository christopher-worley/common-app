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
package core.data.model.jpa.agreement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import core.data.model.Keyable;
import core.data.model.agreement.AgreementType;
import core.data.model.util.DataUtil;

@Entity
@Table (name="agreement_type")
public class AgreementTypeJpaImpl implements Keyable, AgreementType
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column (name="agreement_type_id")
    private Integer agreementTypeId;
    
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

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreementType#getAgreementTypeId()
     */
    public Integer getAgreementTypeId()
    {
        return agreementTypeId;
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreementType#getDescription()
     */
    public String getDescription()
    {
        return description;
    }

    
    public Integer getId()
    {
        return getAgreementTypeId();
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
    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreementType#hashCode()
     */
    
    public int hashCode()
    {
        // TODO data object hash code
        return super.hashCode();
    }

    
    public boolean isEquivalent(Object object)
    {
        AgreementTypeJpaImpl agreementType = (AgreementTypeJpaImpl) object;
        return DataUtil.equals(getAgreementTypeId(), agreementType.getAgreementTypeId())
            && DataUtil.equals(getDescription(), agreementType.getDescription())
            && DataUtil.equals(getKey(), agreementType.getKey());
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreementType#setAgreementTypeId(java.lang.Integer)
     */
    public void setAgreementTypeId(Integer agreementTypeId)
    {
        this.agreementTypeId = agreementTypeId;
    }
    
    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreementType#setDescription(java.lang.String)
     */
    public void setDescription(String description)
    {
        this.description = description;
    }
    

    
    public void setId(Integer id)
    {
        setAgreementTypeId(id);
    }

    /**
     * Setter for key
     *
     * @param key the key to set
     */
    public void setKey(Object key)
    {
        this.key = (String) key;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    public String toString()
    {
        return "AgreementType("
            + "agreementTypeId="
            + getAgreementTypeId()
            + ",description="
            + getDescription()
            + ",key="
            + getKey()
            + ")";
    }

}
