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
package core.data.model.jpa.status;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import core.data.model.status.Status;
import core.data.model.status.StatusType;
import core.data.model.util.DataUtil;

@Entity
@Table (name="status")
public class StatusJpaImpl implements Status
{

    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="status_id", nullable=false)
    private Integer statusId;
    
    @ManyToOne (targetEntity=StatusTypeJpaImpl.class)
    @JoinColumn (name="status_type_id")
    private StatusType statusType;
    
    @Column (name="code")
    private String code;
    
    @Column (name="key")
    private String key;
    
    @Column (name="description")
    private String description;

    /* (non-Javadoc)
     * @see core.data.model.status.Status#getCode()
     */
    public String getCode()
    {
        return code;
    }

    /* (non-Javadoc)
     * @see core.data.model.status.Status#getDescription()
     */
    public String getDescription()
    {
        return description;
    }

    
    public Integer getId()
    {
        return getStatusId();
    }

    
    public Object getKey()
    {
        return key;
    }

    /* (non-Javadoc)
     * @see core.data.model.status.Status#getStatusId()
     */
    public Integer getStatusId()
    {
        return statusId;
    }

    /* (non-Javadoc)
     * @see core.data.model.status.Status#getStatusType()
     */
    public StatusType getStatusType()
    {
        return statusType;
    }

    
    public boolean isEquivalent(Object object)
    {
        Status status = (Status) object;
        return DataUtil.equals(getStatusId(), status.getStatusId())
            && DataUtil.isEquivalent(getStatusType(), status.getStatusType())
            && DataUtil.equals(getCode(), status.getCode())
            && DataUtil.equals(getKey(), status.getKey())
            && DataUtil.equals(getDescription(), status.getDescription());
    }

    /* (non-Javadoc)
     * @see core.data.model.status.Status#setCode(java.lang.String)
     */
    public void setCode(String code)
    {
        this.code = code;
    }

    /* (non-Javadoc)
     * @see core.data.model.status.Status#setDescription(java.lang.String)
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    
    public void setId(Integer id)
    {
        setStatusId(id);
    }

    /**
     * Setter for key
     *
     * @param key the key to set
     */
    public void setKey(Object key)
    {
        this.key = (String) key;
    }

    /* (non-Javadoc)
     * @see core.data.model.status.Status#setStatusId(java.lang.Integer)
     */
    public void setStatusId(Integer statusId)
    {
        this.statusId = statusId;
    }

    /* (non-Javadoc)
     * @see core.data.model.status.Status#setStatusType(core.data.model.status.StatusType)
     */
    public void setStatusType(StatusType statusType)
    {
        this.statusType = statusType;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    public String toString()
    {
        return "Status("
            + "statusId="
            + getStatusId()
            + ",statusType="
            + getStatusType()
            + ",code="
            + getCode()
            + ",key="
            + getKey()
            + ",description="
            + getDescription()
            + ")";
    }

}
