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
package core.test.server.mock.security;

import core.commonapp.domain.InformationContext;
import core.data.hibernate.security.UserLoginHibernateImpl;
import core.data.model.party.Person;
import core.data.model.security.UserLogin;
import core.test.server.mock.AbstractObjectMock;
import core.test.server.mock.party.PartyMock;

public class UserLoginMock extends AbstractObjectMock
{
    private PartyMock partyMock = new PartyMock(getInformationContext());

    public UserLoginMock(InformationContext context)
    {
        super(context);
    }
    
    /**
     * Create user login mock object
     * 
     * @return
     */
    public UserLogin createUserLogin()
    {
        Person person = partyMock.generatePerson();
        UserLogin userLogin = new UserLoginHibernateImpl();
        
        userLogin.setParty(person);
        String username = person.getFirstName().substring(0, 1).toLowerCase() + person.getLastName().toLowerCase();
        userLogin.setUsername(username);
        userLogin.setEnabled(true);
        
        return userLogin;        
    }
    
}
