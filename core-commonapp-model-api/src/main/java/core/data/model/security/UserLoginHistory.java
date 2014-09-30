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

public interface UserLoginHistory extends DataObject
{

    /**
     * Getter for createdDate
     *
     * @return the createdDate
     */
    public abstract Date getCreatedDate();

    /**
     * Getter for disabledDate
     *
     * @return the disabledDate
     */
    public abstract Date getDisabledDate();

    /**
     * Getter for enabledDate
     *
     * @return the enabledDate
     */
    public abstract Date getEnabledDate();

    /**
     * Getter for failedLogin
     *
     * @return the failedLogin
     */
    public abstract Date getFailedLogin();

    /**
     * Getter for successfulLogin
     *
     * @return the successfulLogin
     */
    public abstract Date getSuccessfulLogin();

    /**
     * Getter for user
     *
     * @return the user
     */
    public abstract UserLogin getUserLogin();

    /**
     * Getter for userHistoryId
     *
     * @return the userHistoryId
     */
    public abstract Integer getUserLoginHistoryId();

    /**
     * Setter for createdDate
     *
     * @param createdDate the createdDate to set
     */
    public abstract void setCreatedDate(Date createdDate);

    /**
     * Setter for disabledDate
     *
     * @param disabledDate the disabledDate to set
     */
    public abstract void setDisabledDate(Date disabledDate);

    /**
     * Setter for enabledDate
     *
     * @param enabledDate the enabledDate to set
     */
    public abstract void setEnabledDate(Date enabledDate);

    /**
     * Setter for failedLogin
     *
     * @param failedLogin the failedLogin to set
     */
    public abstract void setFailedLogin(Date failedLogin);

    /**
     * Setter for successfulLogin
     *
     * @param successfulLogin the successfulLogin to set
     */
    public abstract void setSuccessfulLogin(Date successfulLogin);

    /**
     * Setter for user
     *
     * @param user the user to set
     */
    public abstract void setUserLogin(UserLogin user);

    /**
     * Setter for userHistoryId
     *
     * @param userHistoryId the userHistoryId to set
     */
    public abstract void setUserLoginHistoryId(Integer userHistoryId);

}