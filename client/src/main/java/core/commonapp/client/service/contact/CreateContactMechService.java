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
package core.commonapp.client.service.contact;

import core.data.model.contact.EmailAddress;
import core.data.model.contact.PhoneNumber;
import core.data.model.contact.PostalAddress;
import core.data.model.geo.Geo;
import core.data.model.jpa.contact.EmailAddressJpaImpl;
import core.data.model.jpa.contact.PhoneNumberJpaImpl;
import core.data.model.jpa.contact.PostalAddressJpaImpl;
import core.service.annotation.InformationBean;
import core.service.annotation.Service;
import core.service.result.ServiceResult;

@InformationBean(beanName="createContactMechService")
@Service
public interface CreateContactMechService
{
    
    /**
     * Persist email address from new object
     * 
     * @param emailAddress
     * @return
     */
    public ServiceResult createEmailAddress(EmailAddressJpaImpl emailAddress);
    
    /**
     * Persist email address from fields
     * 
     * @param contactAddress
     * @return
     */
    public ServiceResult<EmailAddress> createEmailAddress(String contactAddress);
    
    
    
    /**
     * Persist  phone number from new object
     * 
     * @param phoneNumber
     * @return
     */
    public ServiceResult createPhoneNumber(PhoneNumberJpaImpl phoneNumber);
    
    
    /**
     * Persist  phone number from fields
     * 
     * @param countryCode
     * @param areaCode
     * @param contactNumber
     * @param extension
     * @return
     */
    public ServiceResult<PhoneNumber> createPhoneNumber(String countryCode, String areaCode, String contactNumber, String extension);
    
    /**
     * Create postal address from new object
     * 
     * @param postalAddress
     * @return
     */
    public ServiceResult createPostalAddress(PostalAddressJpaImpl postalAddress);

    /**
     * Persist PostalAddress
     * 
     * @param address1
     * @param address2
     * @param city
     * @param postalCode
     * @param stateGeo
     * @param country
     * @return
     */
    public ServiceResult<PostalAddress> createPostalAddress(String address1, String address2, String city, String postalCode,
            Geo stateGeo, Geo country);

}
