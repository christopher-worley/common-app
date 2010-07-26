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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import core.data.hibernate.geo.GeoHibernateImpl;
import core.data.model.contact.PostalAddress;
import core.data.model.geo.Geo;
import core.data.model.util.DataUtil;

@Entity
@Table(name = "postal_address")
@PrimaryKeyJoinColumn(name="contact_mech_id")
public class PostalAddressHibernateImpl extends ContactMechHibernateImpl implements PostalAddress
{

    @Column(name = "address_line_1")
    private String addressLine1;

    @Column(name = "address_line_2")
    private String addressLine2;

    @Column(name = "city")
    private String city;

    @Column(name = "postal_code")
    private String postalCode;

    @ManyToOne (targetEntity=GeoHibernateImpl.class)
    @JoinColumn(name = "state_geo_id")
    private Geo stateGeo;

    @ManyToOne (targetEntity=GeoHibernateImpl.class)
    @JoinColumn(name = "country_geo_id")
    private Geo countryGeo;

    /* (non-Javadoc)
     * @see core.data.model.contact.PostalAddress#getAddressLine1()
     */
    public String getAddressLine1()
    {
        return addressLine1;
    }

    /* (non-Javadoc)
     * @see core.data.model.contact.PostalAddress#getAddressLine2()
     */
    public String getAddressLine2()
    {
        return addressLine2;
    }

    /* (non-Javadoc)
     * @see core.data.model.contact.PostalAddress#getCity()
     */
    public String getCity()
    {
        return city;
    }

    /* (non-Javadoc)
     * @see core.data.model.contact.PostalAddress#getCountryGeo()
     */
    public Geo getCountryGeo()
    {
        return countryGeo;
    }

    /* (non-Javadoc)
     * @see core.data.model.contact.PostalAddress#getPostalCode()
     */
    public String getPostalCode()
    {
        return postalCode;
    }

    /* (non-Javadoc)
     * @see core.data.model.contact.PostalAddress#getStateGeo()
     */
    public Geo getStateGeo()
    {
        return stateGeo;
    }

    /**
     * determine if the postal address fields are empty
     * 
     * @return true if all fields are not set or empty; otherwise return false
     */
    public boolean isEmpty()
    {
        return DataUtil.isEmpty(getAddressLine1())
            && DataUtil.isEmpty(getAddressLine2())
            && DataUtil.isEmpty(getCity())
            && DataUtil.isEmpty(getPostalCode())
            && getStateGeo() == null
            && getCountryGeo() == null;
    }

    /* (non-Javadoc)
     * @see core.data.model.contact.ContactMech#isEquivalent(java.lang.Object)
     */
    
    public boolean isEquivalent(Object object)
    {
        PostalAddress address = (PostalAddress) object;
        return super.isEquivalent(object)
            && DataUtil.equals(getAddressLine1(), address.getAddressLine1())
            && DataUtil.equals(getAddressLine2(), address.getAddressLine2())
            && DataUtil.equals(getCity(), address.getCity())
            && DataUtil.equals(getPostalCode(), address.getPostalCode())
            && DataUtil.isEquivalent(getStateGeo(), address.getStateGeo())
            && DataUtil.isEquivalent(getCountryGeo(), address.getCountryGeo());
    }

    /* (non-Javadoc)
     * @see core.data.model.contact.PostalAddress#setAddressLine1(java.lang.String)
     */
    public void setAddressLine1(String addressLine1)
    {
        this.addressLine1 = addressLine1;
    }

    /* (non-Javadoc)
     * @see core.data.model.contact.PostalAddress#setAddressLine2(java.lang.String)
     */
    public void setAddressLine2(String addressLine2)
    {
        this.addressLine2 = addressLine2;
    }

    /* (non-Javadoc)
     * @see core.data.model.contact.PostalAddress#setCity(java.lang.String)
     */
    public void setCity(String city)
    {
        this.city = city;
    }

    /* (non-Javadoc)
     * @see core.data.model.contact.PostalAddress#setCountryGeo(core.data.model.geo.Geo)
     */
    public void setCountryGeo(Geo countryGeoId)
    {
        this.countryGeo = countryGeoId;
    }

    /* (non-Javadoc)
     * @see core.data.model.contact.PostalAddress#setPostalCode(java.lang.String)
     */
    public void setPostalCode(String postalCode)
    {
        this.postalCode = postalCode;
    }

    /* (non-Javadoc)
     * @see core.data.model.contact.PostalAddress#setStateGeo(core.data.model.geo.Geo)
     */
    public void setStateGeo(Geo stateGeo)
    {
        this.stateGeo = stateGeo;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    public String toString()
    {
        return "PostalAddress("
            + super.toString()
            + ",addressLine1="
            + getAddressLine1()
            + ",addressLine2="
            + getAddressLine2()
            + ",city="
            + getCity()
            + ",postalCode="
            + getPostalCode()
            + ",stateGeo="
            + getStateGeo()
            + ",countryGeo="
            + getCountryGeo()
            + ")";
    }
    
    
}
