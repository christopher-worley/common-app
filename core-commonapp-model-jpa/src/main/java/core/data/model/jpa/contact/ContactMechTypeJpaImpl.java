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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import core.data.model.contact.ContactMechType;
import core.data.model.util.DataUtil;

/**
 * Contact mech type entity for distinguishing ContactMech objects
 * 
 * @author cworley
 * 
 */
@Entity
@Table(name = "contact_mech_type")
@Component("contactMechTypeModel")
public class ContactMechTypeJpaImpl implements ContactMechType
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_mech_type_id", nullable = false)
    public Integer contactMechTypeId;

    @Column(name = "key")
    public String key;
    
    @Column(name = "description")
    public String description;

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        ContactMechType right = (ContactMechType) obj;
        return DataUtil.equals(getContactMechTypeId(), right.getContactMechTypeId())
            && DataUtil.equals(getKey(), right.getKey())
            && DataUtil.equals(getDescription(), right.getDescription());
    }
    
    
    /* (non-Javadoc)
     * @see core.data.model.contact.ContactMechType#getContactMechTypeId()
     */
    public Integer getContactMechTypeId()
    {
        return contactMechTypeId;
    }

    /* (non-Javadoc)
     * @see core.data.model.contact.ContactMechType#getDescription()
     */
    public String getDescription()
    {
        return description;
    }

    
    public Integer getId()
    {
        return getContactMechTypeId();
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

    
    public boolean isEquivalent(Object object)
    {
        ContactMechTypeJpaImpl type = (ContactMechTypeJpaImpl) object;
        return DataUtil.equals(getContactMechTypeId(), type.getContactMechTypeId())
            && DataUtil.equals(getDescription(), type.getDescription())
            && DataUtil.equals(getKey(), type.getKey()); 
    }

    /* (non-Javadoc)
     * @see core.data.model.contact.ContactMechType#setContactMechTypeId(java.lang.Integer)
     */
    public void setContactMechTypeId(Integer contactMechTypeId)
    {
        this.contactMechTypeId = contactMechTypeId;
    }

    /* (non-Javadoc)
     * @see core.data.model.contact.ContactMechType#setDescription(java.lang.String)
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    
    public void setId(Integer id)
    {
        setContactMechTypeId(id);
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
        return "ContactMechType("
            + "contactMechTypeId="
            + getContactMechTypeId()
            + ",description="
            + getDescription()
            + ",key="
            + getKey()
            + ")";
    }

    
}
