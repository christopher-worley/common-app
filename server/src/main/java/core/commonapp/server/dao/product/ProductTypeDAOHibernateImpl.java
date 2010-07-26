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
package core.commonapp.server.dao.product;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import core.commonapp.client.dao.GenericDAO;
import core.commonapp.client.dao.product.ProductTypeDAO;
import core.data.hibernate.product.ProductTypeHibernateImpl;
import core.data.model.product.ProductType;

public class ProductTypeDAOHibernateImpl extends HibernateDaoSupport implements ProductTypeDAO
{
    /** generic dao */
    private GenericDAO genericDAO;

    public ProductTypeDAOHibernateImpl()
    {
        super();
        
    }
    
    /**
     * Default constructor
     * @param genericDAO
     */
    @Autowired
    public ProductTypeDAOHibernateImpl(GenericDAO genericDAO)
    {
        super();
        this.genericDAO = genericDAO;
    }

    @Override
    public List<ProductTypeHibernateImpl> findAll()
    {
        DetachedCriteria criteria = DetachedCriteria.forClass(ProductTypeHibernateImpl.class);
        return (List<ProductTypeHibernateImpl>) getHibernateTemplate().findByCriteria(criteria);
    }

    @Override
    public ProductType findById(Integer id)
    {
        return null;
    }

    @Override
    public ProductType save(ProductTypeHibernateImpl productType)
    {
        genericDAO.save(productType);
        
        return productType;
    }

}
