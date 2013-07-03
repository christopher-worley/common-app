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
package core.data.hibernate.party;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import core.data.model.party.PartyGroup;
import core.data.model.util.DataUtil;

/**
 * Party entity to track organizations
 * 
 * @author cworley
 * 
 */
@Entity
@Table(name = "party_group")
@PrimaryKeyJoinColumn(name="party_id")
public class PartyGroupHibernateImpl extends PartyHibernateImpl implements PartyGroup
{

    @Column(name = "group_name")
    private String groupName;
    
    /* (non-Javadoc)
     * @see core.data.model.party.PartyGroup#getGroupName()
     */
    public String getGroupName()
    {
        return groupName;
    }

    public boolean isEquivalent(Object object)
    {
        PartyGroup group = (PartyGroup) object;
        return super.isEquivalent(object)
            && DataUtil.equals(getGroupName(), group.getGroupName());
    }

    /* (non-Javadoc)
     * @see core.data.model.party.Party#isEquivalent(java.lang.Object)
     */
    
    /* (non-Javadoc)
     * @see core.data.model.party.PartyGroup#setGroupName(java.lang.String)
     */
    public void setGroupName(String groupName)
    {
        this.groupName = groupName;
    }

    /* (non-Javadoc)
     * @see core.data.party.Party#toString()
     */
    
    public String toString()
    {
        return "PartyGroup("
            + super.toString()
            + ",groupName="
            + getGroupName()
            + ")";
    }

}
