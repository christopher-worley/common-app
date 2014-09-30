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
package core.data.helper.party;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import core.data.cache.KeyedCache;
import core.data.cache.KeyedCacheStore;
import core.data.cache.contact.ContactMechPurposeKey;
import core.data.cache.contact.ContactMechTypeKey;
import core.data.cache.party.PartyTypeKey;
import core.data.helper.contact.PartyContactMechHelper;
import core.data.model.contact.ContactMech;
import core.data.model.contact.ContactMechPurpose;
import core.data.model.contact.ContactMechType;
import core.data.model.contact.EmailAddress;
import core.data.model.contact.PartyContactMech;
import core.data.model.contact.PartyContactMechPurpose;
import core.data.model.contact.PhoneNumber;
import core.data.model.contact.PostalAddress;
import core.data.model.jpa.contact.PartyContactMechJpaImpl;
import core.data.model.jpa.contact.PartyContactMechPurposeJpaImpl;
import core.data.model.jpa.party.PartyRelationshipJpaImpl;
import core.data.model.jpa.party.PartyRoleJpaImpl;
import core.data.model.party.Party;
import core.data.model.party.PartyGroup;
import core.data.model.party.PartyRelationship;
import core.data.model.party.PartyRole;
import core.data.model.party.PartyType;
import core.data.model.party.Person;
import core.data.model.party.RoleType;

public class PartyHelper<T extends Party>
{
    /** party to get help with */
    private T party;

    /** party type Cache */
    private KeyedCacheStore<PartyType> partyTypeCache;

    /** contact mech type Cache */
    private KeyedCacheStore<ContactMechType> contactMechTypeCache;

    /** contact mech purpose Cache */
    private KeyedCacheStore<ContactMechPurpose> contactMechPurposeCache;
    
    /** role type Cache */
    private KeyedCacheStore<RoleType> roleTypeCache;
    
    /** data constatn factory */
    private KeyedCache keyedCache;

    /**
     * Defautl constructor
     * 
     * @param party
     */
    public PartyHelper(KeyedCache keyedCache, T party)
    {
        super();
        this.party = party;
        this.keyedCache = keyedCache;
        this.partyTypeCache = keyedCache.getCacheStore(PartyType.class);
        this.contactMechTypeCache = keyedCache.getCacheStore(ContactMechType.class);
        this.contactMechPurposeCache = keyedCache.getCacheStore(ContactMechPurpose.class);
        this.roleTypeCache = keyedCache.getCacheStore(RoleType.class);
    }

    /**
     * add the given contact mech to the party
     * 
     * if the purpose is not null a <code>PartyContactMechPurose</code> record
     * willbe created for the <code>PartyContactMech</code>
     * 
     * @param contactMech
     * @param purpose
     * @return new <code>PartyContactMech</code>
     */
    public PartyContactMech addContactMech(ContactMech contactMech, ContactMechPurpose purpose)
    {
        PartyContactMech partyContactMech = new PartyContactMechJpaImpl();
        partyContactMech.setFromDate(new Timestamp(System.currentTimeMillis()));
        partyContactMech.setParty(party);
        partyContactMech.setContactMech(contactMech);

        if (purpose != null)
        {
            PartyContactMechPurpose partyContactMechPurpose = new PartyContactMechPurposeJpaImpl();
            partyContactMechPurpose.setPartyContactMech(partyContactMech);
            partyContactMechPurpose.setContactMechPurpose(purpose);
            partyContactMechPurpose.setFromDate(new Timestamp(System.currentTimeMillis()));

            // TODO: Move to helper
            PartyContactMechHelper helper = new PartyContactMechHelper(partyContactMech);
            helper.addContactMechPurpose(partyContactMechPurpose);
        }

        addPartyContactMech(partyContactMech);

        return partyContactMech;
    }

    /**
     * add email address to the party
     * 
     * @param emailAddress
     * @return
     */
    public PartyContactMech addEmailAddress(EmailAddress emailAddress)
    {
        return addEmailAddress(emailAddress, null);
    }
    
    /**
     * add email address with the given purpose
     * 
     * @param emailAddress
     * @param purpose
     * @return
     */
    public PartyContactMech addEmailAddress(EmailAddress emailAddress, ContactMechPurpose purpose)
    {
        if (emailAddress.getContactMechType() == null)
        {
            emailAddress.setContactMechType(contactMechTypeCache.getObject(ContactMechTypeKey.KEY_EMAIL_ADDRESS));
        }
        return addContactMech(emailAddress, purpose);
    }
    
    /**
     * add party contact mech object to list
     * 
     * @param partyContactMech
     */
    public void addPartyContactMech(PartyContactMech partyContactMech)
    {
        if (party.getPartyContactMechs() == null)
        {
            party.setPartyContactMechs(new ArrayList<PartyContactMech>());
        }
        party.getPartyContactMechs().add(partyContactMech);
    }

    /**
     * Add party from relationship
     * 
     * @param relationship
     */
    public void addPartyFromRelationship(PartyRelationship relationship)
    {
        if (party.getPartyFromRelationships() == null)
        {
            party.setPartyFromRelationships(new ArrayList<PartyRelationship>());
        }
        party.getPartyFromRelationships().add(relationship);
    }

    /**
     * Add party to relationship
     * 
     * @param relationship
     */
    public void addPartyToRelationship(PartyRelationship relationship)
    {
        if (party.getPartyToRelationships() == null)
        {
            party.setPartyToRelationships(new ArrayList<PartyRelationship>());
        }
        party.getPartyToRelationships().add(relationship);
    }

    /**
     * add phone number to the party
     * 
     * @param phoneNumber
     * @return
     */
    public PartyContactMech addPhoneNumber(PhoneNumber phoneNumber)
    {
        return addPhoneNumber(phoneNumber, null);
    }

    /**
     * add phone number with the given purpose
     * 
     * @param phoneNumber
     * @param purpose
     * @return
     */
    public PartyContactMech addPhoneNumber(PhoneNumber phoneNumber, ContactMechPurpose purpose)
    {
        if (phoneNumber.getContactMechType() == null)
        {
            phoneNumber.setContactMechType(contactMechTypeCache.getObject(ContactMechTypeKey.KEY_PHONE_NUMBER));
        }
        return addContactMech(phoneNumber, purpose);
    }

    /**
     * add postal address to the parth
     * 
     * @param postalAddress
     * @return
     */
    public PartyContactMech addPostalAddress(PostalAddress postalAddress)
    {
        return addContactMech(postalAddress, null);
    }

    /**
     * add postal address with the given purpose
     * 
     * @param postalAddress
     * @param purpose
     * @return
     */
    public PartyContactMech addPostalAddress(PostalAddress postalAddress, ContactMechPurpose purpose)
    {
        return addContactMech(postalAddress, purpose);
    }

    /**
     * create party relationship with the given party as the from party.
     * 
     * Deprecated use addRelationshipFrom(Party, RoleType, RoleType, Date)
     * 
     * @param party
     * @param sales_person
     * @param contact_person
     * @return new <code>PartyRelationship</code>
     */
    @Deprecated
    public PartyRelationship addRelationshipFrom(Party partyFrom, RoleType roleTypeFrom, RoleType roleTypeTo)
    {
        PartyRelationship relationship = new PartyRelationshipJpaImpl();
        relationship.setFromDate(new Timestamp(System.currentTimeMillis()));
        relationship.setPartyFrom(partyFrom);
        relationship.setRoleTypeFrom(roleTypeFrom);
        relationship.setPartyTo(party);
        relationship.setRoleTypeTo(roleTypeTo);

        addPartyToRelationship(relationship);

        PartyHelper<Party> helper = new PartyHelper<Party>(keyedCache, partyFrom);
        helper.addPartyFromRelationship(relationship);

        return relationship;
    }

    /**
     * create party relationship with the given party as the to party.
     * 
     * 
     * @param party
     * @param sales_person
     * @param contact_person
     * @timestamp
     * @return new <code>PartyRelationship</code>
     */
    public PartyRelationship addRelationshipFrom(Party partyTo, RoleType roleTypeTo, RoleType roleTypeFrom, Date timestamp)
    {
        PartyRelationship relationship = new PartyRelationshipJpaImpl();
        relationship.setFromDate(timestamp);
        relationship.setPartyFrom(party);
        relationship.setRoleTypeFrom(roleTypeFrom);
        relationship.setPartyTo(partyTo);
        relationship.setRoleTypeTo(roleTypeTo);

        addPartyFromRelationship(relationship);
        
        PartyHelper helper = new PartyHelper(keyedCache, partyTo);
        helper.addPartyToRelationship(relationship);

        return relationship;
    }

    /**
     * create party relationship with the given party as the to party.
     * 
     * 
     * @param party
     * @param sales_person
     * @param contact_person
     * @return new <code>PartyRelationship</code>
     */
    @Deprecated
    public PartyRelationship addRelationshipTo(Party partyTo, RoleType roleTypeTo, RoleType roleTypeFrom)
    {
        return addRelationshipFrom(partyTo, roleTypeTo, roleTypeFrom, new Date(System.currentTimeMillis()));
    }

    /**
     * create party relationship with the given party as the to party.
     * 
     * 
     * @param party
     * @param sales_person
     * @param contact_person
     * @timestamp
     * @return new <code>PartyRelationship</code>
     */
    public PartyRelationship addRelationshipTo(Party partyFrom, RoleType roleTypeFrom, RoleType roleTypeTo, Date timestamp)
    {
        PartyRelationship relationship = new PartyRelationshipJpaImpl();
        relationship.setFromDate(timestamp);
        relationship.setPartyFrom(partyFrom);
        relationship.setRoleTypeFrom(roleTypeFrom);
        relationship.setPartyTo(party);
        relationship.setRoleTypeTo(roleTypeTo);

        addPartyToRelationship(relationship);

        PartyHelper<Party> helper = new PartyHelper<Party>(keyedCache, partyFrom);
        helper.addPartyFromRelationship(relationship);

        return relationship;
    }

    /**
     * Add relation to role type to party
     * 
     * @param roleType
     */
    public void addRoleType(RoleType roleType)
    {
        if (party.getPartyRoles() == null)
        {
            List<PartyRole> partyRoles = new ArrayList<PartyRole>();
            party.setPartyRoles(partyRoles);
        }
        PartyRole partyRole = new PartyRoleJpaImpl();
        partyRole.setParty(party);
        partyRole.setRoleType(roleType);
        partyRole.setFromDate(new Date(System.currentTimeMillis()));
        party.getPartyRoles().add(partyRole);
    }

    /**
     * Modify or create new PartyRelationship objects for the given party.  Based on the roles given
     * this method will modify the records so that the only active relationships will be the ones
     * for the given parties.
     * 
     * @param roleTypeFrom
     * @param roleTypeTo
     * @param toParties
     */
    public void createFromRelationshipsByRole(RoleType roleTypeFrom, RoleType roleTypeTo, List<Party> toParties,
            Date timestamp)
    {
        if (party.getPartyFromRelationships() != null)
        {
            // expire any not found
            for (PartyRelationship fromRelationship : party.getPartyFromRelationships())
            {
                boolean found = false;
                for (Party toParty : toParties)
                {
                    if (toParty.getId().equals(fromRelationship.getPartyTo().getId()))
                    {
                        found = true;
                    }
                }
                if (!found)
                {
                    fromRelationship.setThruDate(timestamp);
                }
            }
        }
        else 
        {
            // set to empty array list
            party.setPartyFromRelationships(new ArrayList<PartyRelationship>());
        }
        
        // add relationships that do not already exist
        for (Party toParty : toParties)
        {
            boolean found = false;
            for (PartyRelationship fromRelationship : party.getPartyFromRelationships())
            {
                if (fromRelationship.getThruDate() == null
                        && fromRelationship.getPartyTo().getId().equals(toParty.getId()))
                {
                    found = true;
                }
            }
            if (!found)
            {
                addRelationshipFrom(toParty, roleTypeTo, roleTypeFrom, timestamp);
            }
        }
    }

    /**
     * Modify or create new PartyRelationship objects for the given party.  Based on the roles given
     * this method will modify the records so that the only active relationships will be the ones
     * for the given parties.
     * 
     * @param roleTypeFrom
     * @param roleTypeTo
     * @param fromParties
     */
    public void createToRelationshipsByRole(RoleType roleTypeFrom, RoleType roleTypeTo, List<Party> fromParties,
            Date timestamp)
    {
        if (party.getPartyToRelationships() != null)
        {
            // expire any not found
            for (PartyRelationship toRelationship : party.getPartyToRelationships())
            {
                boolean found = false;
                for (Party fromParty : fromParties)
                {
                    if (fromParty.getId().equals(toRelationship.getPartyFrom().getId()))
                    {
                        found = true;
                    }
                }
                if (!found)
                {
                    toRelationship.setThruDate(timestamp);
                }
            }
        }
        else 
        {
            // set to empty array list
            party.setPartyToRelationships(new ArrayList<PartyRelationship>());
        }
        
        // add relationships that do not already exist
        for (Party fromParty : fromParties)
        {
            boolean found = false;
            for (PartyRelationship toRelationship : party.getPartyToRelationships())
            {
                if (toRelationship.getThruDate() == null
                        && toRelationship.getPartyFrom().getId().equals(fromParty.getId()))
                {
                    found = true;
                }
            }
            if (!found)
            {
                addRelationshipFrom(fromParty, roleTypeFrom, roleTypeTo, timestamp);
            }
        }
    }

    /**
     * find all contact mechs with the given type
     * 
     * @param type
     * @return
     */
    public List<? extends ContactMech> getAllContactMechsByType(ContactMechType type)
    {
        return getAllContactMechsByType(type, true);
    }

    /**
     * find all contact mechs with the given type
     * 
     * @param type
     * @param includeOld if true then return all relationships; otherwise, only return active relationships
     * @return
     */
    public List<? extends ContactMech> getAllContactMechsByType(ContactMechType type, boolean includeOld)
    {
        List<ContactMech> contactMechs = new ArrayList<ContactMech>();
        if (party.getPartyContactMechs() != null)
        {
            for (PartyContactMech partyContactMech : party.getPartyContactMechs())
            {
                if (type.equals(partyContactMech.getContactMech().getContactMechType())
                        && (includeOld || (!includeOld && partyContactMech.getThruDate() == null)))
                {
                    contactMechs.add(partyContactMech.getContactMech());
                }
            }
        }
        return contactMechs;
    }

    /**
     * Return all <code>PartyContactMech</code> objects with a contactMech with
     * the given type
     * 
     * @param type
     * @return
     */
    public List<PartyContactMech> getAllPartyContactMechsByType(ContactMechType type)
    {
        return getAllPartyContactMechsByType(type, false);
    }

    /**
     * Return all <code>PartyContactMech</code> objects with a contactMech with
     * the given type
     * 
     * @param type
     * @param includeOld if true then return all relationships; otherwise, only return active relationships
     * @return
     */
    public List<PartyContactMech> getAllPartyContactMechsByType(ContactMechType type, boolean includeOld)
    {
        List<PartyContactMech> partyContactMechs = new ArrayList<PartyContactMech>();
        if (party.getPartyContactMechs() != null)
        {
            for (PartyContactMech partyContactMech : party.getPartyContactMechs())
            {
                if (type.equals(partyContactMech.getContactMech().getContactMechType())
                        && (includeOld || (!includeOld && partyContactMech.getThruDate() == null)))
                {
                    partyContactMechs.add(partyContactMech);
                }
            }
        }
        return partyContactMechs;
    }

    /**
     * return all <code>PartyContactMech</code> objects that have the given
     * purpose
     * 
     * @param purpose
     * @return
     */
    public List<PartyContactMech> getAllPartyContactMechsWithPurpose(ContactMechPurpose purpose)
    {
        List<PartyContactMech> partyContactMechs = new ArrayList<PartyContactMech>();
        for (PartyContactMech partyContactMech : party.getPartyContactMechs())
        {
            for (PartyContactMechPurpose partyContactMechPurpose : partyContactMech.getPartyContactMechPurposes())
            {
                if (partyContactMechPurpose.getContactMechPurpose().equals(purpose))
                {
                    partyContactMechs.add(partyContactMech);
                }
            }
        }
        return partyContactMechs;
    }

    /**
     * Return display name of party
     * 
     * @return
     */
    public String getDisplayName()
    {
        if (partyTypeCache.getObject(PartyTypeKey.KEY_PERSON).equals(party.getPartyType()))
        {
            Person person = (Person) party;
            return person.getLastName() + ", " + person.getFirstName();
        } 
        else if (partyTypeCache.getObject(PartyTypeKey.KEY_PARTY_GROUP).equals(party.getPartyType()))
        {
            return ((PartyGroup) party).getGroupName();
        }

        throw new IllegalArgumentException("Unknown party type (" + party.getPartyType() + ").");
    }

    /**
     * return all email addresses associated with the party
     * 
     * @return
     */
    public List<EmailAddress> getEmailAddresses()
    {
        return getEmailAddresses(true);
    }

    /**
     * return all email addresses associated with the party
     *
     * @param includeOld if true then return all relationships; otherwise, only return active relationships
     * @return
     */
    public List<EmailAddress> getEmailAddresses(boolean includeOld)
    {
        // TODO: why cast?
        return (List<EmailAddress>) getAllContactMechsByType(contactMechTypeCache.getObject(ContactMechTypeKey.KEY_EMAIL_ADDRESS), includeOld);
    }

    /**
     * Return all party contactmechs for email addresses
     * 
     * @return
     */
    public List<PartyContactMech> getEmailAddressPartyContactMechs()
    {
        return getEmailAddressPartyContactMechs(true);
    }

    /**
     * Return all party contactmechs for email addresses
     * 
     * @param includeOld if true then return all relationships; otherwise, only return active relationships
     * @return
     */
    public List<PartyContactMech> getEmailAddressPartyContactMechs(boolean includeOld)
    {
        return getAllPartyContactMechsByType(contactMechTypeCache.getObject(ContactMechTypeKey.KEY_EMAIL_ADDRESS), includeOld);
    }

    /**
     * @return the party
     */
    public T getParty()
    {
        return party;
    }

    /**
     * Return all party contactmechs for phone number
     * 
     * @return
     */
    public List<PartyContactMech> getPhoneNumberPartyContactMechs()
    {
        return getPhoneNumberPartyContactMechs(true);
    }

    /**
     * Return all party contact mechs for phone numebrs
     * 
     * @param includeOld
     * @return
     */
    public List<PartyContactMech> getPhoneNumberPartyContactMechs(boolean includeOld)
    {
        return getAllPartyContactMechsByType(contactMechTypeCache.getObject(ContactMechTypeKey.KEY_PHONE_NUMBER), includeOld);
    }

    /**
     * return all phone numbers for the party
     * 
     * @return
     */
    public List<PhoneNumber> getPhoneNumbers()
    {
        return getPhoneNumbers(true);
    }

    /**
     * 
     * @param includeOld
     * @return
     */
    public List<PhoneNumber> getPhoneNumbers(boolean includeOld)
    {
        // TODO: Why do we have to cast this?
        return (List<PhoneNumber>) getAllContactMechsByType(contactMechTypeCache.getObject(ContactMechTypeKey.KEY_PHONE_NUMBER), includeOld);
    }

    /**
     * return all postal addresses for the party
     * 
     * @return
     */
    public List<? extends ContactMech> getPostalAddresses()
    {
        return getAllContactMechsByType(contactMechTypeCache.getObject(ContactMechTypeKey.KEY_POSTAL_ADDRESS));
    }

    /**
     * Return all party contactmechs for phone number
     * 
     * @return
     */
    public List<PartyContactMech> getPostalAddressPartyContactMechs()
    {
        return getAllPartyContactMechsByType(contactMechTypeCache.getObject(ContactMechTypeKey.KEY_POSTAL_ADDRESS));
    }

    /**
     * return the first primary email address found
     * 
     * @return
     */
    public EmailAddress getPrimaryEmailAddress()
    {
        for (Iterator iter = party.getPartyContactMechs().iterator(); iter.hasNext();)
        {
            PartyContactMech partyContactMech = (PartyContactMech) iter.next();
            if (contactMechTypeCache.getObject(ContactMechTypeKey.KEY_EMAIL_ADDRESS).equals(
                    partyContactMech.getContactMech().getContactMechType()))
            {
                for (Iterator purposeIter = partyContactMech.getPartyContactMechPurposes().iterator(); purposeIter
                        .hasNext();)
                {
                    PartyContactMechPurpose purpose = (PartyContactMechPurpose) purposeIter.next();
                    if (contactMechPurposeCache.getObject(ContactMechPurposeKey.KEY_PRIMARY).equals(purpose.getContactMechPurpose()))
                    {
                        return (EmailAddress) partyContactMech.getContactMech();
                    }
                }
            }
        }
        return null;
    }

    /**
     * determine if the party has the given role
     * 
     * @param roleType
     * @return
     */
    public boolean isRoleType(RoleType roleType)
    {
        List<PartyRole> partyRoles = party.getPartyRoles();
        for (PartyRole partyRole : partyRoles)
        {
            if (roleType.equals(partyRole.getRoleType()))
            {
                return true;
            }
        }
        return false;
    }

}
