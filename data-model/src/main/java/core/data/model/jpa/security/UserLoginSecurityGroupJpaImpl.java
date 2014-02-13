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
package core.data.model.jpa.security;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import core.data.model.DataObject;
import core.data.model.Expirable;
import core.data.model.security.SecurityGroup;
import core.data.model.security.UserLogin;
import core.data.model.security.UserLoginSecurityGroup;

@Entity
@Table (name="user_login_security_group")
public class UserLoginSecurityGroupJpaImpl implements DataObject, Serializable, Expirable, UserLoginSecurityGroup
{

    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="user_login_security_group_id")
    private Integer userLoginSecurityGroupId;

    @Column (name="from_date")
    private Date fromDate;
    
    @Column (name="thru_date")
    private Date thruDate;

    @ManyToOne (targetEntity=UserLoginJpaImpl.class)
    @JoinColumn (name="user_login_id")
    private UserLogin userLogin;
    
    @ManyToOne (targetEntity=SecurityGroupJpaImpl.class)
    @JoinColumn (name="security_group_id")
    private SecurityGroup securityGroup;

    /**
     * Getter for fromDate
     *
     * @return the fromDate
     */
    public Date getFromDate()
    {
        return fromDate;
    }

    public Integer getId()
    {
        return getUserLoginSecurityGroupId();
    }

    /* (non-Javadoc)
     * @see core.data.hibernate.security.UserLoginGroup#getGroup()
     */
    public SecurityGroup getSecurityGroup()
    {
        return securityGroup;
    }

    /**
     * Getter for thruDate
     *
     * @return the thruDate
     */
    public Date getThruDate()
    {
        return thruDate;
    }

    /* (non-Javadoc)
     * @see core.data.hibernate.security.UserLoginGroup#getUserLogin()
     */
    public UserLogin getUserLogin()
    {
        return userLogin;
    }

    /* (non-Javadoc)
     * @see core.data.hibernate.security.UserLoginGroup#getUserLoginGroupId()
     */
    public Integer getUserLoginSecurityGroupId()
    {
        return userLoginSecurityGroupId;
    }

    public boolean isEquivalent(Object object)
    {
        if (object instanceof UserLoginSecurityGroup) 
        {
            UserLoginSecurityGroup right = (UserLoginSecurityGroup) object;
            return getFromDate().equals(right.getFromDate())
                && getSecurityGroup().isEquivalent(right.getSecurityGroup())
                && getThruDate().equals(right.getThruDate())
                && getUserLogin().isEquivalent(right.getUserLogin());                
        }
        return false;
    }

    /**
     * Setter for fromDate
     *
     * @param fromDate the fromDate to set
     */
    public void setFromDate(Date fromDate)
    {
        this.fromDate = fromDate;
    }

    public void setId(Integer id)
    {
        setUserLoginSecurityGroupId(id);
    }

    /* (non-Javadoc)
     * @see core.data.hibernate.security.UserLoginGroup#setGroup(core.data.model.security.Group)
     */
    public void setSecurityGroup(SecurityGroup group)
    {
        this.securityGroup = group;
    }

    /**
     * Setter for thruDate
     *
     * @param thruDate the thruDate to set
     */
    public void setThruDate(Date thruDate)
    {
        this.thruDate = thruDate;
    }

    /* (non-Javadoc)
     * @see core.data.hibernate.security.UserLoginGroup#setUserLogin(core.data.model.security.UserLogin)
     */
    public void setUserLogin(UserLogin userLogin)
    {
        this.userLogin = userLogin;
    }

    /* (non-Javadoc)
     * @see core.data.hibernate.security.UserLoginGroup#setUserLoginGroupId(java.lang.Integer)
     */
    public void setUserLoginSecurityGroupId(Integer userLoginGroupId)
    {
        this.userLoginSecurityGroupId = userLoginGroupId;
    }
    
    
}
