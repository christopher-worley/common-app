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
package core.commonapp.server.service.agreement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.commonapp.client.dao.agreement.AgreementTypeDao;
import core.commonapp.client.dao.agreement.ServiceIntervalDao;
import core.commonapp.client.service.agreement.AgreementService;
import core.service.result.ServiceResult;

@Service
public class AgreementServiceImpl implements AgreementService
{

    /** agreement type dao */
    private AgreementTypeDao agreementTypeDao;

    /** service interval dao */
    private ServiceIntervalDao serviceIntervalDao;
    
    public AgreementServiceImpl()
    {
        super();
        
    }
    
    
    /**
     * Default constructor
     * 
     * @param agreementTypeDao
     */
    @Autowired(required=true)
    public AgreementServiceImpl(AgreementTypeDao agreementTypeDao, ServiceIntervalDao serviceIntervalDao)
    {
        super();
        this.agreementTypeDao = agreementTypeDao;
        this.serviceIntervalDao = serviceIntervalDao;
    }



    @Override
    public ServiceResult findAllAgreementTypes()
    {
        return new ServiceResult(agreementTypeDao.findAll());
    }



    @Override
    public ServiceResult findAllServiceIntervals()
    {
        return new ServiceResult(serviceIntervalDao.findAll());
    }

}
