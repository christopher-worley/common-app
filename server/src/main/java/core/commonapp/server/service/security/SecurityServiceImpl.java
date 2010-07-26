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
package core.commonapp.server.service.security;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import core.commonapp.client.dao.security.PermissionDAO;
import core.commonapp.client.service.security.SecurityService;
import core.commonapp.domain.InformationContext;
import core.data.model.security.Permission;
import core.service.result.ServiceResult;

public class SecurityServiceImpl implements SecurityService, ApplicationContextAware
{

    /** set when bean is created */
    private InformationContext context;
    
    @Override
    public ServiceResult<List<Permission>> findAllPermissions()
    {
        PermissionDAO permissionDAO = (PermissionDAO) context.getBean("permissionDAO");
        return ServiceResult.success("Successfully found permissions.", permissionDAO.findAll());
    }


    @Override
    public void setApplicationContext(ApplicationContext context)
    {
        this.context = new InformationContext(context);
    }

    
}
