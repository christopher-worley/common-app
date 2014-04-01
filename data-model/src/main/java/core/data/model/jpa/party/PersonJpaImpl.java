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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import core.data.model.party.Person;
import core.data.model.util.DataUtil;

/**
 * Party entity to track people
 * 
 * @author cworley
 * 
 */
@Entity
@Table(name = "person")
@PrimaryKeyJoinColumn(name="party_id")
public class PersonJpaImpl extends PartyJpaImpl implements Person
{

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;
    
    /* (non-Javadoc)
     * @see core.data.model.party.Person#getFirstName()
     */
    public String getFirstName()
    {
        return firstName;
    }

    /* (non-Javadoc)
     * @see core.data.model.party.Person#getLastName()
     */
    public String getLastName()
    {
        return lastName;
    }
    
    /* (non-Javadoc)
     * @see core.data.model.party.Person#getMiddleName()
     */
    public String getMiddleName()
    {
        return middleName;
    }

    public boolean isEquivalent(Object object)
    {
        Person person = (Person) object;
        return super.isEquivalent(object)
            && DataUtil.equals(getFirstName(), person.getFirstName())
            && DataUtil.equals(getMiddleName(), person.getMiddleName())
            && DataUtil.equals(getLastName(), person.getLastName());
    }

    /* (non-Javadoc)
     * @see core.data.model.party.Party#isEquivalent(java.lang.Object)
     */
    
    /* (non-Javadoc)
     * @see core.data.model.party.Person#setFirstName(java.lang.String)
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /* (non-Javadoc)
     * @see core.data.model.party.Person#setLastName(java.lang.String)
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /* (non-Javadoc)
     * @see core.data.model.party.Person#setMiddleName(java.lang.String)
     */
    public void setMiddleName(String middleName)
    {
        this.middleName = middleName;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    public String toString()
    {
        return "Person("
            + super.toString()
            + ",firstName="
            + getFirstName()
            + ",middleName="
            + getMiddleName()
            + ",lastName="
            + getLastName()
            + ")";
    }

    
}
