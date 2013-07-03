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
package core.data.cache.contact;

import core.service.annotation.InformationBean;
import core.service.annotation.Service;

@InformationBean (beanName="contactMechPurposeCache")
public interface ContactMechPurposeKey
{
    /** keys */
    public static String KEY_PRIMARY = "_PRIMARY";
    public static String KEY_SECONDARY = "_SECONDARY";
    public static String KEY_FAX = "_FAX";
    public static String KEY_HOME = "_HOME";
    public static String KEY_WORK = "_WORK";
    public static String KEY_SHIPPING = "_SHIPPING";
    public static String KEY_BILLING = "_BILLING";
}
