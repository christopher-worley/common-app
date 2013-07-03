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

import java.util.Set;

import core.data.model.contact.ContactMechPurpose;
import core.data.model.contact.EmailAddress;
import core.service.annotation.InformationBean;
import core.service.annotation.Service;
import core.service.result.ServiceResult;

@InformationBean(beanName="contactMechService")
@Service
public interface ContactMechService
{
    /** 
     * find all contact mech purposes
     * 
     * Service result payload
     *          0 - <code>List</code> of <code>ContactMechPurpose</code>s
     * 
     * @return
     */
    public ServiceResult findAllContactMechPurposes();

    /**
     * find all contact mech types
     * 
     * Service result payload
     *          0 - <code>List</code> of <code>ContactMechType</code>s
     * 
     * @return
     */
    public ServiceResult findAllContactMechTypes();
    
    /**
     * update email address by expiring all exiting <code>PartyContactMech</code>
     * records and creating new ones for the new email address.
     * 
     * Service result payload
     *          0 - new <code>EmailAddress</code> 
     */
    @Deprecated
    public ServiceResult updateEmailAddress(EmailAddress emailAddress, Set<ContactMechPurpose> purposes);
}
