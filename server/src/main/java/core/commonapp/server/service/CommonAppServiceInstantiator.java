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
package core.commonapp.server.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import core.commonapp.domain.InformationContext;
import core.service.annotation.InformationBean;
import core.service.executor.local.ServiceInstantiator;

public class CommonAppServiceInstantiator implements ServiceInstantiator
{
    /** set when bean is created */
    private static InformationContext context;

    @Override
    public Object instantiateService(Class serviceInterface)
    {
        InformationBean service = (InformationBean) serviceInterface.getAnnotation(InformationBean.class);
        if (service == null)
        {
            throw new IllegalArgumentException("No bean found  for interface " + serviceInterface.getName());
        }
        return getInformationContext().getBean(service.beanName());
    }
    
    /**
     * @return
     */
    public InformationContext getInformationContext()
    {
        if (context == null)
        {
            String contextFile = System.getProperty("core.commonapp.context.file");
            context = new InformationContext(new ClassPathXmlApplicationContext(contextFile));
        }
        return context;
    }
}
