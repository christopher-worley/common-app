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
package core.data.cache.security;


public interface PermissionKey
{
    /** keys */
    // root
    public static final String KEY_ROOT = "_ROOT";
    
    // user login
    public static final String KEY_CREATE_USER_LOGIN = "_CREATE_USER_LOGIN";
    public static final String KEY_MODIFY_USER_LOGIN = "_MODIFY_USER_LOGIN";
    
    // security group
    public static final String KEY_CREATE_SECURITY_GROUP = "_CREATE_SECURITY_GROUP";
    public static final String KEY_MODIFY_SECURITY_GROUP = "_MODIFY_SECURITY_GROUP";
    
    // sales related permissions
    public static final String KEY_CREATE_SALES_LEAD = "_CREATE_SALES_LEAD";
    public static final String KEY_MODIFY_SALES_LEAD = "_MODIFY_SALES_LEAD";
    public static final String KEY_CREATE_SALES_PERSON = "_CREATE_SALES_PERSON";
    public static final String KEY_MODIFY_SALES_PERSON = "_MODIFY_SALES_PERSON";
    public static final String KEY_CREATE_SALES_TEAM = "_CREATE_SALES_TEAM";
    public static final String KEY_MODIFY_SALES_TEAM = "_MODIFY_SALES_TEAM";
}
