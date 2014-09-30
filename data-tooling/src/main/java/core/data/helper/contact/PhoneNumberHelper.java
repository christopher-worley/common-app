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
package core.data.helper.contact;

import core.data.model.contact.PhoneNumber;
import core.data.model.util.DataUtil;

public class PhoneNumberHelper
{
    
    /** phone number */
    private PhoneNumber phoneNumber;
    
    /**
     * constructor
     * 
     * @param phoneNumber
     */
    public PhoneNumberHelper(PhoneNumber phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    /**
     * return display string
     * 
     * @return
     */
    public String getDisplayString() {
        return phoneNumber.getAreaCode() 
                + " " 
                + phoneNumber.getContactNumber()
                + " " 
                + phoneNumber.getExtension();    
    }

    /**
     * determine if the phone number is considered empty
     * 
     * @return true if all fields are empty; otherwise false
     */
    public boolean isEmpty()
    {
        return phoneNumber == null
            || (DataUtil.isEmpty(phoneNumber.getCountryCode())
            && DataUtil.isEmpty(phoneNumber.getAreaCode())
            && DataUtil.isEmpty(phoneNumber.getContactNumber())
            && DataUtil.isEmpty(phoneNumber.getExtension()));
    }

}
