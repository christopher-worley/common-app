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
package core.commonapp.server.service.contact;

import org.springframework.beans.factory.annotation.Autowired;

import core.commonapp.client.dao.contact.ContactMechDao;
import core.commonapp.client.service.contact.CreateContactMechService;
import core.data.cache.KeyedCache;
import core.data.cache.KeyedCacheStore;
import core.data.cache.contact.ContactMechTypeKey;
import core.data.hibernate.contact.EmailAddressHibernateImpl;
import core.data.hibernate.contact.PhoneNumberHibernateImpl;
import core.data.hibernate.contact.PostalAddressHibernateImpl;
import core.data.model.contact.ContactMechType;
import core.data.model.contact.EmailAddress;
import core.data.model.contact.PhoneNumber;
import core.data.model.contact.PostalAddress;
import core.data.model.geo.Geo;
import core.service.result.ServiceResult;
import core.tooling.logging.LogFactory;
import core.tooling.logging.Logger;

public class CreateContactMechServiceImpl implements CreateContactMechService
{
    /** logger for this class */
    private static Logger log = LogFactory.getLogger(CreateContactMechServiceImpl.class);

    /** contact mech dao */
    @Autowired
    private ContactMechDao contactMechDao;

    /** keyed cache */
    @Autowired
    private KeyedCache cache;

    public CreateContactMechServiceImpl()
    {
        super();

    }

    /**
     * create email object and persist data
     * 
     * @param emailAddress
     * @return
     */
    public ServiceResult createEmailAddress(EmailAddressHibernateImpl emailAddress)
    {
        log.debug("CreateContactMechImpl.createEmailAddress({0})", emailAddress);

        emailAddress.setContactMechType(getContactMechTypeCache().getObject(ContactMechTypeKey.KEY_EMAIL_ADDRESS));
        contactMechDao.save(emailAddress);
        log.debug("Email address saved with id {0}: ", emailAddress.getContactMechId());

        return new ServiceResult(emailAddress);
    }

    /**
     * create email object and persist data
     * 
     * @param emailAddress
     * @return
     */
    public ServiceResult<EmailAddress> createEmailAddress(String contactAddress)
    {
        log.debug("CreateContactMechImpl.createEmailAddress({0})", contactAddress);

        EmailAddressHibernateImpl emailAddress = new EmailAddressHibernateImpl();
        emailAddress.setEmailAddress(contactAddress);

        return createEmailAddress(emailAddress);
    }

    @Override
    public ServiceResult createPhoneNumber(PhoneNumberHibernateImpl phoneNumber)
    {
        log.debug("CreateContactMechImpl.createPhoneNumber({0})", phoneNumber);

        phoneNumber.setContactMechType(getContactMechTypeCache().getObject(ContactMechTypeKey.KEY_PHONE_NUMBER));
        contactMechDao.save(phoneNumber);
        log.debug("Phone number created with id {0}: ", phoneNumber.getContactMechId());

        return new ServiceResult(phoneNumber);
    }

    /**
     * 
     * @param countryCode
     * @param areaCode
     * @param contactNumber
     * @param extension
     * @return
     */
    public ServiceResult<PhoneNumber> createPhoneNumber(String countryCode, String areaCode, String contactNumber,
            String extension)
    {
        log.debug("CreateContactMechImpl.createPhoneNumber({0}, {1}, {2}, {3})", countryCode, areaCode, contactNumber,
                extension);

        PhoneNumberHibernateImpl phoneNumber = new PhoneNumberHibernateImpl();
        phoneNumber.setCountryCode(countryCode);
        phoneNumber.setAreaCode(areaCode);
        phoneNumber.setContactNumber(contactNumber);
        phoneNumber.setExtension(extension);

        return createPhoneNumber(phoneNumber);
    }

    @Override
    public ServiceResult createPostalAddress(PostalAddressHibernateImpl postalAddress)
    {
        log.debug("CreateContactMechImpl.createPostalAddress({0})", postalAddress);

        postalAddress.setContactMechType(getContactMechTypeCache().getObject(ContactMechTypeKey.KEY_POSTAL_ADDRESS));
        contactMechDao.save(postalAddress);
        log.debug("Postal address created with id {0}", postalAddress.getId());

        return new ServiceResult(postalAddress);
    }

    /**
     * Create postal address
     * 
     * @param address1
     * @param address2
     * @param city
     * @param postalCode
     * @param stateGeo
     * @param country
     * @return
     */
    public ServiceResult<PostalAddress> createPostalAddress(String address1, String address2, String city,
            String postalCode, Geo stateGeo, Geo country)
    {
        log.debug("CreateContactMechImpl.createPostalAddress({0}, {1}, {2}, {3}, {4}, {5})", address1, address2, city,
                postalCode, stateGeo, country);
        PostalAddressHibernateImpl postalAddress = new PostalAddressHibernateImpl();
        postalAddress.setContactMechType(getContactMechTypeCache().getObject(ContactMechTypeKey.KEY_POSTAL_ADDRESS));
        postalAddress.setAddressLine1(address1);
        postalAddress.setAddressLine2(address2);
        postalAddress.setCity(city);
        postalAddress.setPostalCode(postalCode);
        postalAddress.setStateGeo(stateGeo);
        postalAddress.setCountryGeo(country);

        return createPostalAddress(postalAddress);
    }

    /**
     * return ContactMechType cache store from cache
     * 
     * @return keyed cache store for ContactMechType objects
     */
    private KeyedCacheStore<ContactMechType> getContactMechTypeCache()
    {
        return cache.getCacheStore(ContactMechType.class);
    }

}
