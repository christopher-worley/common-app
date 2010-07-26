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
package core.data.hibernate.contact;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import core.data.model.contact.EmailAddress;

@Entity
@Table(name = "email_address")
@PrimaryKeyJoinColumn(name="contact_mech_id")
public class EmailAddressHibernateImpl extends ContactMechHibernateImpl implements EmailAddress
{

    @Column(name = "email_address")
    private String emailAddress;

    /* (non-Javadoc)
     * @see core.data.contact.ContactMech#equals(java.lang.Object)
     */
    
    public boolean equals(Object obj)
    {
        // TODO data object equals
        return super.equals(obj);
    }

    /* (non-Javadoc)
     * @see core.data.model.contact.EmailAddress#getEmailAddress()
     */
    public String getEmailAddress()
    {
        return emailAddress;
    }

    /* (non-Javadoc)
     * @see core.data.contact.ContactMech#hashCode()
     */
    
    public int hashCode()
    {
        // TODO data object hash code
        return super.hashCode();
    }

    /**
     * return true if the email address is empty, otherwise false
     * 
     * @return
     */
    public boolean isEmpty()
    {
        return getEmailAddress().isEmpty();
    }
    
    /* (non-Javadoc)
     * @see core.data.model.contact.EmailAddress#setEmailAddress(java.lang.String)
     */
    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

    /* (non-Javadoc)
     * @see core.data.contact.ContactMech#toString()
     */
    
    public String toString()
    {
        return "EmailAddress("
            + super.toString()
            + ",emailAddress="
            + getEmailAddress()
            + ")";
    }
    
    
}
