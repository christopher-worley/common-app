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

import core.data.model.contact.PostalAddress;
import core.data.model.util.DataUtil;

public class PostalAddressHelper
{
    
    /** phone number */
    private PostalAddress postalAddress;
    
    /**
     * constructor
     * 
     * @param postalAddress
     */
    public PostalAddressHelper(PostalAddress postalAddress)
    {
        this.postalAddress = postalAddress;
    }

    /**
     * return display string for GUI
     * 
     * @param lineSeparator
     * @return
     */
    public String getDisplayString(String lineSeparator) {
        String display = "";
        
        if (!DataUtil.isEmpty(postalAddress.getAddressLine1())) {
            display += postalAddress.getAddressLine1() + lineSeparator;
        } 
        
        if (!DataUtil.isEmpty(postalAddress.getAddressLine2())) {
            display += postalAddress.getAddressLine2() + lineSeparator;
        }
        
        if (!DataUtil.isEmpty(postalAddress.getCity())) {
            display += postalAddress.getCity() + " ";
        }
        
        if (postalAddress.getStateGeo() != null) {
            display += postalAddress.getStateGeo().getAbbreviation() + "  ";
        }
        
        if (!DataUtil.isEmpty(postalAddress.getPostalCode())) {
            display += postalAddress.getPostalCode();
        }
        
        return display;
    }
    
    public String getHTMLDisplayString() {
        return getDisplayString("<br/>");
    }
    
    /**
     * return true if the postal address is null or all the fields 
     * are empty, otherwise return false
     * 
     * @return
     */
    public boolean isEmpty()
    {
        return postalAddress == null
        || (DataUtil.isEmpty(postalAddress.getAddressLine1())
                && DataUtil.isEmpty(postalAddress.getAddressLine2())
                && DataUtil.isEmpty(postalAddress.getCity())
                && DataUtil.isEmpty(postalAddress.getPostalCode())
                && postalAddress.getStateGeo() == null
                && postalAddress.getCountryGeo() == null
           );
    }
}
