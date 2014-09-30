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
package core.data.model.jpa.party;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import core.data.model.party.PartyType;
import core.data.model.util.DataUtil;

@Entity
@Table(name = "party_type")
public class PartyTypeJpaImpl implements PartyType 
{
    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "party_type_id", nullable = false)
    private Integer partyTypeId;


    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Column(name = "description")
    private String description;

    @Column (name="key")
    private String key;

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        PartyType right  = (PartyType) obj;
        return DataUtil.equals(getPartyTypeId(), right.getPartyTypeId())
            && DataUtil.equals(getDescription(), right.getDescription())
            && DataUtil.equals(getKey(), right.getKey());
    }
    
    public String getDescription()
    {
        return description;
    }

    /* (non-Javadoc)
     * @see core.data.model.party.PartyType#getDescription()
     */
    public Integer getId()
    {
        return getPartyTypeId();
    }

    
    /**
     * Getter for key
     *
     * @return the key
     */
    public String getKey()
    {
        return key;
    }

    public Integer getPartyTypeId()
    {
        return partyTypeId;
    }

    /* (non-Javadoc)
     * @see core.data.model.party.PartyType#getPartyTypeId()
     */
    @Override
    public int hashCode()
    {
        // TODO Auto-generated method stub
        return super.hashCode();
    }


    
    public boolean isEquivalent(Object object)
    {
        PartyTypeJpaImpl type = (PartyTypeJpaImpl) object;
        return DataUtil.equals(getPartyTypeId(), type.getPartyTypeId())
            && DataUtil.equals(getDescription(), type.getDescription())
            && DataUtil.equals(getKey(), type.getKey());
    }

    /* (non-Javadoc)
     * @see core.data.model.party.PartyType#setDescription(java.lang.String)
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    
    public void setId(Integer id)
    {
        setPartyTypeId(id);

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
     * @see core.data.model.party.PartyType#setPartyTypeId(java.lang.Integer)
     */
    public void setPartyTypeId(Integer partyTypeId)
    {
        this.partyTypeId = partyTypeId;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    public String toString()
    {
        return "PartyType("
            + "partyTypeId="
            + getPartyTypeId()
            + ",description="
            + getDescription()
            + ",key="
            + getKey()
            + ")";
    }

}
