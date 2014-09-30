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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import core.data.model.contact.ContactMech;
import core.data.model.contact.ContactMechType;
import core.data.model.util.DataUtil;

/**
 * Base class for all contact information types
 * 
 * @author cworley
 * 
 */
@Entity
@Table(name = "contact_mech")
@Inheritance(strategy=InheritanceType.JOINED)
public class ContactMechJpaImpl implements ContactMech
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_mech_id", nullable = false)
    private Integer contactMechId;

    @ManyToOne (targetEntity=ContactMechTypeJpaImpl.class)
    @JoinColumn(name = "contact_mech_type_id")
    private ContactMechType contactMechType;

    @Version
    @Column(name="version")
    private Integer version;
    
    public boolean equals(Object obj)
    {
        // TODO data object equals
        return super.equals(obj);
    }

    /* (non-Javadoc)
     * @see core.data.model.contact.IContactMech#getContactMechId()
     */
    public Integer getContactMechId()
    {
        return contactMechId;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    
    /* (non-Javadoc)
     * @see core.data.model.contact.IContactMech#getContactMechType()
     */
    public ContactMechType getContactMechType()
    {
        return contactMechType;
    }

    public Integer getId()
    {
        return getContactMechId();
    }

    public Integer getVersion()
    {
        return version;
    }

    
    public int hashCode()
    {
        // TODO data object hash code
        return super.hashCode();
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    
    public boolean isEquivalent(Object object)
    {
        ContactMech contactMech = (ContactMech) object;
        return DataUtil.equals(getContactMechId(), contactMech.getContactMechId())
            && DataUtil.isEquivalent(getContactMechType(), contactMech.getContactMechType());
    }

    
    /* (non-Javadoc)
     * @see core.data.model.contact.IContactMech#setContactMechId(java.lang.Integer)
     */
    public void setContactMechId(Integer contactMechId)
    {
        this.contactMechId = contactMechId;
    }

    /* (non-Javadoc)
     * @see core.data.model.contact.IContactMech#setContactMechType(core.data.model.contact.ContactMechType)
     */
    public void setContactMechType(ContactMechType contactMechType)
    {
        this.contactMechType = contactMechType;
    }

    public void setId(Integer id)
    {
        setContactMechId(id);
    }

    
    public void setVersion(Integer version)
    {
        this.version = version;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    public String toString()
    {
        return "ContactMech("
            + "contactMechId="
            + getContactMechId()
            + ",contactMechType="
            + getContactMechType()
            + ")";
    }

    
}
