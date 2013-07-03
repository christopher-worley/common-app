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
package core.data.hibernate.security;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import core.data.model.security.UserLogin;
import core.data.model.security.UserLoginHistory;
import core.data.model.util.DataUtil;

@Entity
@Table (name="user_login_history")
public class UserLoginHistoryHibernateImpl implements UserLoginHistory
{
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="user_login_history_id")
    private Integer userLoginHistoryId;
    
    @ManyToOne (targetEntity=UserLoginHibernateImpl.class)
    @JoinColumn (name="user_id")
    private UserLogin user;
    
    @Column (name="created_date")
    private Date createdDate;
    
    @Column (name="disabled_date")
    private Date disabledDate;
    
    @Column (name="enabled_date")
    private Date enabledDate;
    
    @Column (name="successful_login")
    private Date successfulLogin;
    
    @Column (name="failed_login")
    private Date failedLogin;

    /* (non-Javadoc)
     * @see core.data.model.security.UserHistory#getCreatedDate()
     */
    public Date getCreatedDate()
    {
        return createdDate;
    }

    /* (non-Javadoc)
     * @see core.data.model.security.UserHistory#getDisabledDate()
     */
    public Date getDisabledDate()
    {
        return disabledDate;
    }

    /* (non-Javadoc)
     * @see core.data.model.security.UserHistory#getEnabledDate()
     */
    public Date getEnabledDate()
    {
        return enabledDate;
    }

    /* (non-Javadoc)
     * @see core.data.model.security.UserHistory#getFailedLogin()
     */
    public Date getFailedLogin()
    {
        return failedLogin;
    }

    
    public Integer getId()
    {
        return getUserLoginHistoryId();
    }

    /* (non-Javadoc)
     * @see core.data.model.security.UserHistory#getSuccessfulLogin()
     */
    public Date getSuccessfulLogin()
    {
        return successfulLogin;
    }

    /* (non-Javadoc)
     * @see core.data.model.security.UserHistory#getUser()
     */
    public UserLogin getUserLogin()
    {
        return user;
    }

    /* (non-Javadoc)
     * @see core.data.model.security.UserHistory#getUserHistoryId()
     */
    public Integer getUserLoginHistoryId()
    {
        return userLoginHistoryId;
    }

    
    public boolean isEquivalent(Object object)
    {
        UserLoginHistory history = (UserLoginHistory) object;
        return DataUtil.equals(getUserLoginHistoryId(), history.getUserLoginHistoryId())
            && DataUtil.isEquivalent(getUserLogin(), history.getUserLogin())
            && DataUtil.equals(getCreatedDate(), history.getCreatedDate())
            && DataUtil.equals(getDisabledDate(), history.getDisabledDate())
            && DataUtil.equals(getEnabledDate(), history.getEnabledDate())
            && DataUtil.equals(getSuccessfulLogin(), history.getSuccessfulLogin())
            && DataUtil.equals(getFailedLogin(), history.getFailedLogin());
    }

    /* (non-Javadoc)
     * @see core.data.model.security.UserHistory#setCreatedDate(java.sql.Date)
     */
    public void setCreatedDate(Date createdDate)
    {
        this.createdDate = createdDate;
    }

    /* (non-Javadoc)
     * @see core.data.model.security.UserHistory#setDisabledDate(java.sql.Date)
     */
    public void setDisabledDate(Date disabledDate)
    {
        this.disabledDate = disabledDate;
    }

    /* (non-Javadoc)
     * @see core.data.model.security.UserHistory#setEnabledDate(java.sql.Date)
     */
    public void setEnabledDate(Date enabledDate)
    {
        this.enabledDate = enabledDate;
    }

    /* (non-Javadoc)
     * @see core.data.model.security.UserHistory#setFailedLogin(java.sql.Date)
     */
    public void setFailedLogin(Date failedLogin)
    {
        this.failedLogin = failedLogin;
    }

    
    public void setId(Integer id)
    {
        setUserLoginHistoryId(id);
    }

    /* (non-Javadoc)
     * @see core.data.model.security.UserHistory#setSuccessfulLogin(java.sql.Date)
     */
    public void setSuccessfulLogin(Date successfulLogin)
    {
        this.successfulLogin = successfulLogin;
    }

    /* (non-Javadoc)
     * @see core.data.model.security.UserHistory#setUser(core.data.model.security.UserLogin)
     */
    public void setUserLogin(UserLogin user)
    {
        this.user = user;
    }
    

    /* (non-Javadoc)
     * @see core.data.model.security.UserHistory#setUserHistoryId(java.lang.Integer)
     */
    public void setUserLoginHistoryId(Integer userHistoryId)
    {
        this.userLoginHistoryId = userHistoryId;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    public String toString()
    {
        return "UserHistory("
            + "userHistoryId="
            + getUserLoginHistoryId()
            + ",user="
            + getUserLogin()
            + ",createdDate="
            + getCreatedDate()
            + ",disabledDate="
            + getDisabledDate()
            + ",enabledDate="
            + getEnabledDate()
            + ",successfulLogin="
            + getSuccessfulLogin()
            + ",failedLogin="
            + getFailedLogin()
            + ")";
    }

}
