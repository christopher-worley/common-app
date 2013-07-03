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
package core.commonapp.domain;

import org.springframework.context.ApplicationContext;

import core.service.annotation.InformationBean;
import core.service.annotation.Service;
import core.service.factory.ServiceFactory;

public class InformationContext
{
    public static final String KEY = "informationContext";

    /** application context */
    private ApplicationContext applicationContext;

    /** service factory */
    private ServiceFactory serviceFactory;;
    
    /**
     * @param applicationContext
     */
    public InformationContext(ApplicationContext applicationContext)
    {
        super();
        this.applicationContext = applicationContext;
        this.serviceFactory = (ServiceFactory) applicationContext.getBean("serviceFactory");
    }
    
    /**
     * Get bean for given interface.
     * 
     * The interface is required to have the <code>Service</code> annotation.
     * 
     * @param serviceInterface
     * @return
     */
    public Object createService(Class serviceInterface)
    {
        Object service = serviceFactory.createService(serviceInterface);
        return service;
    }

    public ApplicationContext getApplicationContext()
    {
        return applicationContext;
    }

    /**
     * Get bean for given interface.
     * 
     * The interface is required to have the <code>Service</code> annotation.
     * 
     * @param beanInterface
     * @return
     */
    public Object getBean(Class beanInterface)
    {
        InformationBean bean = (InformationBean) beanInterface.getAnnotation(InformationBean.class);
        if (bean == null)
        {
            throw new IllegalArgumentException("No bean found  for interface " + beanInterface.getName());
        }
        return getBean(bean.beanName());
    }

    /**
     * Get bean based on name
     * 
     * @param beanName
     * @return
     */
    public Object getBean(String beanName)
    {
        Object bean = applicationContext.getBean(beanName);
        return bean;
    }
    
}
