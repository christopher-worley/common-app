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
package core.data.model.jpa.agreement;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import core.data.model.agreement.ServiceAgreement;
import core.data.model.agreement.ServiceInterval;
import core.data.model.jpa.product.ProductJpaImpl;
import core.data.model.product.Product;
import core.data.model.util.DataUtil;

@Entity
@Table (name="service_agreement")
@PrimaryKeyJoinColumn(name="agreement_id")
public class ServiceAgreementJpaImpl extends AgreementJpaImpl implements ServiceAgreement
{
    @ManyToOne (targetEntity=ProductJpaImpl.class)
    @JoinColumn (name="product_id")
    private Product product;
    
    @ManyToOne (targetEntity=ServiceIntervalJpaImpl.class)
    @JoinColumn (name="service_interval_id")
    private ServiceInterval serviceInterval;
    
    @Column (name="start_date")
    private Date startDate;
    

    /* (non-Javadoc)
     * @see core.data.model.agreement.Agreement#equals(java.lang.Object)
     */
    /* (non-Javadoc)
     * @see core.data.model.agreement.IServiceAgreement#equals(java.lang.Object)
     */
    
    public boolean equals(Object obj)
    {
        // TODO data object equals
        return super.equals(obj);
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IServiceAgreement#getProduct()
     */
    public Product getProduct()
    {
        return product;
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IServiceAgreement#getServiceInterval()
     */
    public ServiceInterval getServiceInterval()
    {
        return serviceInterval;
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IServiceAgreement#getStartDate()
     */
    public Date getStartDate()
    {
        return startDate;
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.Agreement#hashCode()
     */
    
    public int hashCode()
    {
        // TODO data object hash code
        return super.hashCode();
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.Agreement#isEquivalent(java.lang.Object)
     */
    
    public boolean isEquivalent(Object object)
    {
        ServiceAgreement agreement = (ServiceAgreement) object;
        return super.isEquivalent(object)
            && DataUtil.isEquivalent(getProduct(), agreement.getProduct())
            && DataUtil.isEquivalent(getServiceInterval(), agreement.getServiceInterval())
            && getStartDate().equals(agreement.getStartDate());
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IServiceAgreement#setProduct(core.data.model.product.Product)
     */
    public void setProduct(Product service)
    {
        this.product = service;
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IServiceAgreement#setServiceInterval(core.data.model.agreement.ServiceInterval)
     */
    public void setServiceInterval(ServiceInterval serviceInterval)
    {
        this.serviceInterval = serviceInterval;
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IServiceAgreement#setStartDate(java.sql.Date)
     */
    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.Agreement#toString()
     */
    
    public String toString()
    {
        return "ServiceAgreement("
            + super.toString()
            + ",product="
            + getProduct()
            + ",serviceInterval="
            + getServiceInterval()
            + ",startDate="
            + getStartDate()
            + ")";
    }

}
