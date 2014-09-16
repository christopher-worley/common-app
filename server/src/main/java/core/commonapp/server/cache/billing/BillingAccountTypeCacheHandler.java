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
package core.commonapp.server.cache.billing;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import core.commonapp.client.service.billing.BillingAccountService;
import core.data.cache.KeyedCacheException;
import core.data.cache.KeyedCacheHandler;
import core.data.model.Keyable;
import core.data.model.jpa.billing.BillingAccountTypeJpaImpl;
import core.service.result.ServiceResult;

@Component
public class BillingAccountTypeCacheHandler implements KeyedCacheHandler
{

	@Autowired
    private BillingAccountService billingAccountService;

	@Override
    public Class getDataClass()
    {
        return BillingAccountTypeJpaImpl.class;
    }

    @Override
    public Object getKey(Keyable keyableObject)
    {
        return keyableObject.getKey();
    }

    @Override
    public List getObjects()
    {
        ServiceResult result = billingAccountService.findAllBillingAccountTypes();
        if (result.isSuccess()) 
        {
            return (List) result.getPayload();
        }
        throw new KeyedCacheException("Failed to successfully get objects for archive: " + result.getMessage());
    }

}
