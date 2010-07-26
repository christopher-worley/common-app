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
package core.test.commonapp.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

import core.commonapp.client.service.security.UserService;
import core.commonapp.domain.InformationContext;
import core.data.model.security.UserLogin;

public class CommonAppServerTest extends AbstractTransactionalDataSourceSpringContextTests 
{
    
    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationContext context;
    
    
    /**
     * find the sys admin user login
     * 
     * @return
     */
    protected UserLogin findSysAdmin() 
    {
        return userService.findByUsernameAndPassword("sysadmin", "sysadmin").getPayload();
    }
    
    /**
     * @return
     */
    protected InformationContext getInformationContext()
    {
        return new InformationContext(context);
    }

    
}
