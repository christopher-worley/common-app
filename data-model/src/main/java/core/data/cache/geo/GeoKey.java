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
package core.data.cache.geo;

import core.service.annotation.InformationBean;
import core.service.annotation.Service;

@InformationBean (beanName="geoCache")
public interface GeoKey
{
    /** keys */
    // countries
    public static String KEY_UNITED_STATES = "_COUNTRY_US";
    
    // states
    public static String KEY_ALABAMA = "_STATE_AL";
    public static String KEY_ALASKA = "_STATE_AK";
    public static String KEY_AMERICAN_SAMOA = "_STATE_AS";
    public static String KEY_ARIZONA = "_STATE_AZ";
    public static String KEY_ARKANSAS = "_STATE_AR";
    public static String KEY_CALIFORNIA = "_STATE_CA";
    public static String KEY_COLORADO = "_STATE_CO";
    public static String KEY_CONNECTICUT = "_STATE_CT";
    public static String KEY_DELAWARE = "_STATE_DE";
    public static String KEY_DISTRICT_OF_COLUMBIA = "_STATE_DC";
    public static String KEY_FEDERATED_STATES_OF_MICRONESIA = "_STATE_FM";
    public static String KEY_FLORIDA = "_STATE_FL";
    public static String KEY_GEORGIA = "_STATE_GA";
    public static String KEY_GUAM = "_STATE_GU";
    public static String KEY_HAWAII = "_STATE_HI";
    public static String KEY_IDAHO = "_STATE_ID";
    public static String KEY_ILLINOIS = "_STATE_IL";
    public static String KEY_INDIANA = "_STATE_IN";
    public static String KEY_IOWA = "_STATE_IA";
    public static String KEY_KANSAS = "_STATE_KS";
    public static String KEY_KENTUCKY = "_STATE_KY";
    public static String KEY_LOUISIANA = "_STATE_LA";
    public static String KEY_MAINE = "_STATE_ME";
    public static String KEY_MARSHALL_ISLANDS = "_STATE_MH";
    public static String KEY_MARYLAND = "_STATE_MD";
    public static String KEY_MASSACHUSETTS = "_STATE_MA";
    public static String KEY_MICHIGAN = "_STATE_MI";
    public static String KEY_MINNESOTA = "_STATE_MN";
    public static String KEY_MISSISSIPPI = "_STATE_MS";
    public static String KEY_MISSOURI = "_STATE_MO";
    public static String KEY_MONTANA = "_STATE_MT";
    public static String KEY_NEBRASKA = "_STATE_NE";
    public static String KEY_NEVADA = "_STATE_NV";
    public static String KEY_NEW_HAMPSHIRE = "_STATE_NH";
    public static String KEY_NEW_JERSEY = "_STATE_NJ";
    public static String KEY_NEW_MEXICO = "_STATE_NM";
    public static String KEY_NEW_YORK = "_STATE_NY";
    public static String KEY_NORTH_CAROLINA = "_STATE_NC";
    public static String KEY_NORTH_DAKOTA = "_STATE_ND";
    public static String KEY_NORTHERN_MARIANA_ISLANDS = "_STATE_MP";
    public static String KEY_OHIO = "_STATE_OH";
    public static String KEY_OKLAHOMA = "_STATE_OK";
    public static String KEY_OREGON = "_STATE_OR";
    public static String KEY_PALAU = "_STATE_PW";
    public static String KEY_PENNSYLVANIA = "_STATE_PA";
    public static String KEY_PUERTO_RICO = "_STATE_PR";
    public static String KEY_RHODE_ISLAND = "_STATE_RI";
    public static String KEY_SOUTH_CAROLINA = "_STATE_SC";
    public static String KEY_SOUTH_DAKOTA = "_STATE_SD";
    public static String KEY_TENNESSEE = "_STATE_TN";
    public static String KEY_TEXAS = "_STATE_TX";
    public static String KEY_UTAH = "_STATE_UT";
    public static String KEY_VERMONT = "_STATE_VT";
    public static String KEY_VIRGIN_ISLANDS = "_STATE_VI";
    public static String KEY_VIRGINIA = "_STATE_VA";
    public static String KEY_WASHINGTON = "_STATE_WA";
    public static String KEY_WEST_VIRGINIA = "_STATE_WV";
    public static String KEY_WISCONSIN = "_STATE_WI";
    public static String KEY_WYOMING = "_STATE_WY"; 
}
