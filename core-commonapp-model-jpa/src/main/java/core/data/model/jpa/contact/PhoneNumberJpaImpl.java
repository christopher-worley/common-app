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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import core.data.model.contact.PhoneNumber;
import core.data.model.util.DataUtil;

/**
 * Phone number contact info
 * 
 * @author cworley
 * 
 */
@Entity
@Table(name = "phone_number")
@PrimaryKeyJoinColumn(name="contact_mech_id")
public class PhoneNumberJpaImpl extends ContactMechJpaImpl implements PhoneNumber
{

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "area_code")
    private String areaCode;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "extension")
    private String extension;

    /* (non-Javadoc)
     * @see core.data.contact.ContactMech#equals(java.lang.Object)
     */
    
    public boolean equals(Object obj)
    {
        // TODO data object equals
        return super.equals(obj);
    }

    /* (non-Javadoc)
     * @see core.data.model.contact.PhoneNumber#getAreaCode()
     */
    public String getAreaCode()
    {
        return areaCode;
    }

    /* (non-Javadoc)
     * @see core.data.model.contact.PhoneNumber#getContactNumber()
     */
    public String getContactNumber()
    {
        return contactNumber;
    }

    /* (non-Javadoc)
     * @see core.data.model.contact.PhoneNumber#getCountryCode()
     */
    public String getCountryCode()
    {
        return countryCode;
    }

    /* (non-Javadoc)
     * @see core.data.model.contact.PhoneNumber#getExtension()
     */
    public String getExtension()
    {
        return extension;
    }
    
    /* (non-Javadoc)
     * @see core.data.contact.ContactMech#hashCode()
     */
    
    public int hashCode()
    {
        // TODO data object hash code
        return super.hashCode();
    }

    /* (non-Javadoc)
     * @see core.data.model.contact.ContactMech#isEquivalent(java.lang.Object)
     */
    
    public boolean isEquivalent(Object object)
    {
        PhoneNumber phoneNumber = (PhoneNumber) object;
        return super.isEquivalent(object)
            && DataUtil.equals(getCountryCode(), phoneNumber.getCountryCode())
            && DataUtil.equals(getAreaCode(), phoneNumber.getAreaCode())
            && DataUtil.equals(getContactNumber(), phoneNumber.getContactNumber())
            && DataUtil.equals(getExtension(), phoneNumber.getExtension());
    }

    /* (non-Javadoc)
     * @see core.data.model.contact.PhoneNumber#setAreaCode(java.lang.String)
     */
    public void setAreaCode(String areaCode)
    {
        this.areaCode = areaCode;
    }

    /* (non-Javadoc)
     * @see core.data.model.contact.PhoneNumber#setContactNumber(java.lang.String)
     */
    public void setContactNumber(String contactNumber)
    {
        this.contactNumber = contactNumber;
    }

    /* (non-Javadoc)
     * @see core.data.model.contact.PhoneNumber#setCountryCode(java.lang.String)
     */
    public void setCountryCode(String countryCode)
    {
        this.countryCode = countryCode;
    }

    /* (non-Javadoc)
     * @see core.data.model.contact.PhoneNumber#setExtension(java.lang.String)
     */
    public void setExtension(String extension)
    {
        this.extension = extension;
    }

    /* (non-Javadoc)
     * @see core.data.contact.ContactMech#toString()
     */
    
    public String toString()
    {
        return "PhoneNumber("
            + super.toString()
            + ",countryCode="
            + getCountryCode()
            + ",areaCode="
            + getAreaCode()
            + ",contactNumer="
            + getContactNumber()
            + ",extension="
            + getExtension()
            + ")";
    }
    
}
