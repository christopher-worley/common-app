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
package core.data.model.security;


import java.util.Date;

import core.data.model.DataObject;
import core.data.model.party.Party;
import core.service.InformationBean;

@InformationBean(beanName="userLoginModel")
public interface UserLogin extends DataObject
{

    /**
     * Getter for createdDate
     *
     * @return the createdDate
     */
    public Date getCreatedDate();

    /**
     * Getter for enabled
     *
     * @return the enabled
     */
    public Boolean getEnabled();

    /**
     * Getter for party
     *
     * @return the party
     */
    public Party getParty();

    /**
     * Getter for password
     *
     * @return the password
     */
    public String getPassword();

    /**
     * Getter for userLoginId
     *
     * @return the userLoginId
     */
    public Integer getUserLoginId();

    /**
     * Getter for username
     *
     * @return the username
     */
    public String getUsername();

    /**
     * Setter for createdDate
     *
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(Date createdDate);

    /**
     * Setter for enabled
     *
     * @param enabled the enabled to set
     */
    public void setEnabled(Boolean enabled);

    /**
     * Setter for party
     *
     * @param party the party to set
     */
    public void setParty(Party party);

    /**
     * Setter for password
     *
     * @param password the password to set
     */
    public void setPassword(String password);

    /**
     * Setter for userLoginId
     *
     * @param userLoginId the userLoginId to set
     */
    public void setUserLoginId(Integer userId);

    /**
     * Setter for user name
     *
     * @param username the user name to set
     */
    public void setUsername(String username);

}