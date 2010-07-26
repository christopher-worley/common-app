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
package core.test.server.mock.contact;

import java.sql.Timestamp;
import java.util.Random;

import core.commonapp.domain.InformationContext;
import core.data.cache.KeyedCacheStore;
import core.data.cache.geo.GeoKey;
import core.data.hibernate.contact.ContactMechHibernateImpl;
import core.data.hibernate.contact.EmailAddressHibernateImpl;
import core.data.hibernate.contact.PartyContactMechHibernateImpl;
import core.data.hibernate.contact.PhoneNumberHibernateImpl;
import core.data.hibernate.contact.PostalAddressHibernateImpl;
import core.data.hibernate.geo.GeoHibernateImpl;
import core.data.model.contact.ContactMechPurpose;
import core.data.model.contact.ContactMechType;
import core.data.model.geo.Geo;
import core.test.server.mock.AbstractObjectMock;
import core.test.server.mock.geo.GeoMock;
import core.test.server.mock.party.PartyMock;

public class ContactMechMock extends AbstractObjectMock
{
    // data Caches 
    private KeyedCacheStore<ContactMechPurpose> contactMechPurposeCache = (KeyedCacheStore<ContactMechPurpose>) getKeyedCache().getCacheStore(ContactMechPurpose.class);

    private KeyedCacheStore<ContactMechType> contactMechTypeCache = (KeyedCacheStore<ContactMechType>) getKeyedCache().getCacheStore(ContactMechType.class);
    
    private KeyedCacheStore<Geo> geoCache = (KeyedCacheStore<Geo>) getKeyedCache().getCacheStore(Geo.class);
    
    private GeoMock geoMock = new GeoMock(getInformationContext());
    
    /** postal address data source */
    private Object[][] postalAddresses =
    {
        {"555 Main St", "", "High Point", "29484", geoMock.generateState(), geoCache.getObject(GeoKey.KEY_UNITED_STATES)},
        {"123 Main St", "", "High Point", "27234", geoMock.generateState(), geoCache.getObject(GeoKey.KEY_UNITED_STATES)},
        {"2222 Owen Dr", "Apt  2E", "Greensboro", "28391", geoMock.generateState(), geoCache.getObject(GeoKey.KEY_UNITED_STATES)},
        {"3848 Skank Ln", "", "Fayetteville", "28392", geoMock.generateState(), geoCache.getObject(GeoKey.KEY_UNITED_STATES)},
    };

    /** phone number data source */
    private String[][] phoneNumbers =
    {
        {"1", "910", "5553333", "234"},
        {"1", "919", "4458787", ""},
        {"1", "336", "5534533", ""},
        {"1", "910", "2325566", "100"},
        {"1", "336", "5432223", ""},
        {"1", "910", "5224456", ""},
    };

    /** email address data source */
    private String[] emailAddresses =
    {
        "tootie@hotmail.com",
        "fruitie@gmail.com",
        "thd222@hotmail.com",
        "hotstuff@hotmail.com",
    };

    public ContactMechMock(InformationContext context)
    {
        super(context);
        // TODO Auto-generated constructor stub
    }

    
    /**
     * Create a mocked up ContactMech object
     * 
     * @return
     */
    public ContactMechHibernateImpl generateContactMech()
    {
        int random = new Random().nextInt(3);
        
        switch (random) 
        {
        case 0:
            return generatePostalAddress();
        case 1:
            return generatePhoneNumber();
        case 2:
            return generateEmailAddress();
        }
        throw new IllegalArgumentException("No more contact mechs to generate for random value.");
    }

    /**
     * create ContactMechPurposeType object
     * 
     * @return
     */
    public ContactMechPurpose generateContactMechPurpose()
    {
        int index = new Random().nextInt(contactMechPurposeCache.getObjects().size());
        
        return contactMechPurposeCache.getObjects().get(index);
    }

    /**
     * generate email address
     * 
     * @return
     */
    public EmailAddressHibernateImpl generateEmailAddress()
    {

        EmailAddressHibernateImpl emailAddress = new EmailAddressHibernateImpl();
        
        int index = new Random().nextInt(emailAddresses.length);
       // emailAddress.setContactMechType(contactMechTypeCache.getEmailAddressType());
        emailAddress.setEmailAddress(emailAddresses[index]);
        
        return emailAddress;
    }

    /**
     * Create a mocked up PartyContactMech object
     * 
     * @return
     */
    public PartyContactMechHibernateImpl generatePartyContactMech()
    {
        PartyMock partyMock = new PartyMock(getInformationContext());
        
        PartyContactMechHibernateImpl partyContactMech = new PartyContactMechHibernateImpl();
        partyContactMech.setParty(partyMock.generateParty());
        partyContactMech.setContactMech(generateContactMech());
        partyContactMech.setFromDate(new Timestamp(System.currentTimeMillis()));

        return partyContactMech;
    }

    /**
     * generate phone number
     * 
     * @return
     */
    public PhoneNumberHibernateImpl generatePhoneNumber()
    {
        PhoneNumberHibernateImpl phoneNumber = new PhoneNumberHibernateImpl();
        
        int index = new Random().nextInt(phoneNumbers.length);
        phoneNumber.setCountryCode(phoneNumbers[index][0]);
        phoneNumber.setAreaCode(phoneNumbers[index][1]);
        phoneNumber.setContactNumber(phoneNumbers[index][2]);
        phoneNumber.setExtension(phoneNumbers[index][3]);
        
        return phoneNumber;
    }

    /**
     * generate postal address
     * 
     * @return
     */
    public PostalAddressHibernateImpl generatePostalAddress()
    {
        PostalAddressHibernateImpl postalAddress = new PostalAddressHibernateImpl();
        
        int index = new Random().nextInt(postalAddresses.length);
        postalAddress.setAddressLine1((String)postalAddresses[index][0]);
        postalAddress.setAddressLine2((String)postalAddresses[index][1]);
        postalAddress.setCity((String)postalAddresses[index][2]);
        postalAddress.setPostalCode((String)postalAddresses[index][3]);
        postalAddress.setStateGeo((GeoHibernateImpl)postalAddresses[index][4]);
        postalAddress.setCountryGeo((GeoHibernateImpl)postalAddresses[index][5]);

        return postalAddress;
    }

}
