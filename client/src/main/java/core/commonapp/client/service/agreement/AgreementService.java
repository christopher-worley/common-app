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
package core.commonapp.client.service.agreement;

import core.service.InformationBean;
import core.service.Service;
import core.service.result.ServiceResult;

@InformationBean(beanName="agreementService")
@Service
public interface AgreementService
{

    /**
     * Find all <code>AgreementType</code> objects
     * 
     * Service result payload
     *          0 - <code>List</code> of <code>AgreementType</code> objects
     * 
     * @return
     */
    public ServiceResult findAllAgreementTypes();
    
    
    /**
     * get all service intervals
     * 
     * Service result payload
     *          0 - <code>List</code> of <code>ServiceInterval</code> objects

     * @return
     */
    public ServiceResult findAllServiceIntervals();
    
}
