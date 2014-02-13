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
package core.data.model.jpa.contact;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import core.data.model.DataObject;
import core.data.model.contact.ContactMechPurpose;
import core.data.model.util.DataUtil;

@Entity
@Table(name = "contact_mech_purpose")
public class ContactMechPurposeJpaImpl implements DataObject, ContactMechPurpose, Serializable
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_mech_purpose_id", nullable = false)
    private Integer contactMechPurposeId;

    @Column(name = "description")
    private String description;
    
    @Column (name="key")
    private String key;

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object obj)
    {
        ContactMechPurpose that = (ContactMechPurpose) obj;
        return DataUtil.equals(this.getContactMechPurposeId(), that.getContactMechPurposeId())
            && DataUtil.equals(this.getDescription(), that.getDescription())
            && DataUtil.equals(this.getKey(), that.getKey());
    }

    /* (non-Javadoc)
     * @see core.data.model.contact.ContactMechPurpose#getContactMechPurposeId()
     */
    public Integer getContactMechPurposeId()
    {
        return contactMechPurposeId;
    }

    /* (non-Javadoc)
     * @see core.data.model.contact.ContactMechPurpose#getDescription()
     */
    public String getDescription()
    {
        return description;
    }

    
    public Integer getId()
    {
        return getContactMechPurposeId();
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

    
    public boolean isEquivalent(Object object)
    {
        ContactMechPurposeJpaImpl purpose = (ContactMechPurposeJpaImpl) object;
        return DataUtil.equals(getContactMechPurposeId(), purpose.getContactMechPurposeId())
            && DataUtil.equals(getDescription(), purpose.getDescription())
            && DataUtil.equals(getKey(), purpose.getKey());
    }

    /* (non-Javadoc)
     * @see core.data.model.contact.ContactMechPurpose#setContactMechPurposeId(java.lang.Integer)
     */
    public void setContactMechPurposeId(Integer contactMechPurposeId)
    {
        this.contactMechPurposeId = contactMechPurposeId;
    }

    /* (non-Javadoc)
     * @see core.data.model.contact.ContactMechPurpose#setDescription(java.lang.String)
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    
    public void setId(Integer id)
    {
        setContactMechPurposeId(id);
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
        return "ContactMechPurpose("
            + "contactMechPurposeId="
            + getContactMechPurposeId()
            + ",description="
            + getDescription()
            + ",key="
            + getKey()
            + ")";
    }
    
    

}
