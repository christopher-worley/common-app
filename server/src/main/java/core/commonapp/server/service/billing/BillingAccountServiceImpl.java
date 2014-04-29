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
package core.commonapp.server.service.billing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.commonapp.client.dao.billing.BillingAccountTypeDao;
import core.commonapp.client.service.billing.BillingAccountService;
import core.service.result.ServiceResult;

@Service
public class BillingAccountServiceImpl implements BillingAccountService
{
    
    /** billing account type dao */
    private BillingAccountTypeDao billingAccountTypeDao;



    public BillingAccountServiceImpl()
    {
        super();
        
    }
    
    
    /**
     * default constructor
     * 
     * @param billingAccountTypeDao
     */
    @Autowired
    public BillingAccountServiceImpl(BillingAccountTypeDao billingAccountTypeDao)
    {
        super();
        this.billingAccountTypeDao = billingAccountTypeDao;
    }



    @Override
    public ServiceResult findAllBillingAccountTypes()
    {
        return new ServiceResult(billingAccountTypeDao.findAll());
    }

}
