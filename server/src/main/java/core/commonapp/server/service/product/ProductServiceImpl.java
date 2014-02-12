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
package core.commonapp.server.service.product;

import org.springframework.beans.factory.annotation.Autowired;

import core.commonapp.client.dao.product.ProductTypeDao;
import core.commonapp.client.service.product.ProductService;
import core.service.result.ServiceResult;

public class ProductServiceImpl implements ProductService
{
    /** product type dao */
    private ProductTypeDao productTypeDao;




    public ProductServiceImpl()
    {
        super();
        
    }

    
    /**
     * Default constructor
     * 
     * @param productTypeDao
     */
    @Autowired
    public ProductServiceImpl(ProductTypeDao productTypeDao)
    {
        super();
        this.productTypeDao = productTypeDao;
    }




    @Override
    public ServiceResult findAllProductTypes()
    {
        return new ServiceResult(productTypeDao.findAll());
    }

}
