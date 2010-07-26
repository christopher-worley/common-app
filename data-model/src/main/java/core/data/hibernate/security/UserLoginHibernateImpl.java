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

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import net.sf.gilead.pojo.java5.LightEntity;
import core.data.hibernate.party.PartyHibernateImpl;
import core.data.model.DataObject;
import core.data.model.party.Party;
import core.data.model.security.UserLogin;
import core.data.model.util.DataUtil;

@Entity
@Table (name="user_login")
public class UserLoginHibernateImpl extends LightEntity implements DataObject, UserLogin, Serializable
{
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="user_login_id")
    private Integer userLoginId;
    
    @OneToOne (cascade={CascadeType.ALL}, targetEntity=PartyHibernateImpl.class)
    @JoinColumn (name="party_id")
    private Party party;
    
    @Column (name="username")
    private String username;

    @Column (name="password")
    private String password;

    @Column (name="created_date")
    private Date createdDate;

    @Column (name="enabled")
    private Boolean enabled;

    /* (non-Javadoc)
     * @see core.data.model.security.UserLogin#getCreatedDate()
     */
    public Date getCreatedDate()
    {
        return createdDate;
    }

    /* (non-Javadoc)
     * @see core.data.model.security.UserLogin#getEnabled()
     */
    public Boolean getEnabled()
    {
        return enabled;
    }

    
    public Integer getId()
    {
        return getUserLoginId();
    }

    /* (non-Javadoc)
     * @see core.data.model.security.UserLogin#getParty()
     */
    public Party getParty()
    {
        return party;
    }

    /* (non-Javadoc)
     * @see core.data.model.security.UserLogin#getPassword()
     */
    public String getPassword()
    {
        return password;
    }

    /* (non-Javadoc)
     * @see core.data.model.security.UserLogin#getUserLoginId()
     */
    public Integer getUserLoginId()
    {
        return userLoginId;
    }

    /* (non-Javadoc)
     * @see core.data.model.security.UserLogin#getUsername()
     */
    public String getUsername()
    {
        return username;
    }

    
    public boolean isEquivalent(Object object)
    {
        UserLogin user = (UserLogin) object;
        return DataUtil.equals(getUserLoginId(), user.getUserLoginId())
            && DataUtil.isEquivalent(getParty(), user.getParty())
            && DataUtil.equals(getUsername(), user.getUsername())
            && DataUtil.equals(getPassword(), user.getPassword())
            && DataUtil.equals(getCreatedDate(), user.getCreatedDate())
            && DataUtil.equals(getEnabled(), user.getEnabled());
    }

    /* (non-Javadoc)
     * @see core.data.model.security.UserLogin#setCreatedDate(java.util.Date)
     */
    public void setCreatedDate(Date createdDate)
    {
        this.createdDate = createdDate;
    }

    /* (non-Javadoc)
     * @see core.data.model.security.UserLogin#setEnabled(java.lang.Boolean)
     */
    public void setEnabled(Boolean enabled)
    {
        this.enabled = enabled;
    }

    
    public void setId(Integer id)
    {
        setUserLoginId(id);
    }
    
    /* (non-Javadoc)
     * @see core.data.model.security.UserLogin#setParty(core.data.model.party.Party)
     */
    public void setParty(Party party)
    {
        this.party = party;
    }
    
    /* (non-Javadoc)
     * @see core.data.model.security.UserLogin#setPassword(java.lang.String)
     */
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    /* (non-Javadoc)
     * @see core.data.model.security.UserLogin#setUserLoginId(java.lang.Integer)
     */
    public void setUserLoginId(Integer userId)
    {
        this.userLoginId = userId;
    }
    
    /* (non-Javadoc)
     * @see core.data.model.security.UserLogin#setUsername(java.lang.String)
     */
    public void setUsername(String username)
    {
        this.username = username;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    public String toString()
    {
        return "UserLogin("
            + "userLoginId="
            + getUserLoginId()
            + ",party="
            + getParty()
            + ",username="
            + getUsername()
            + ",password="
            + getPassword()
            + ",createdDate="
            + getCreatedDate()
            + ",enabled="
            + getEnabled()
            + ")";
    }

}
