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
package core.commonapp.server.cache.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import core.commonapp.client.service.security.SecurityService;
import core.data.cache.KeyedCacheException;
import core.data.cache.KeyedCacheHandler;
import core.data.model.Keyable;
import core.data.model.security.Permission;
import core.service.result.ServiceResult;

@Component
public class PermissionCacheHandler implements KeyedCacheHandler
{

	@Autowired
    private SecurityService securityService;

	@Override
    public Class getDataClass()
    {
        return Permission.class;
    }

    @Override
    public Object getKey(Keyable keyableObject)
    {
        return keyableObject.getKey();
    }

    @Override
    public List getObjects()
    {
        ServiceResult<List<Permission>> result = securityService.findAllPermissions();
        if (!result.isSuccess()) {
            throw new KeyedCacheException("Failed to load permission objects.");
        }
        return result.getPayload();
    }

}
