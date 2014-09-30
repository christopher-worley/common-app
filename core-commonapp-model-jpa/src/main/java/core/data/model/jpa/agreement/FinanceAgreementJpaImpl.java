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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import core.data.model.agreement.FinanceAgreement;
import core.data.model.util.DataUtil;

@Entity
@Table (name="finance_agreement")
public class FinanceAgreementJpaImpl extends AgreementJpaImpl implements FinanceAgreement
{
    
    @Column (name="financed_amount")
    private Double financedAmount;
    
    @Column (name="interest")
    private Double interest;
    
    @Column (name="months")
    private Integer months;

    /* (non-Javadoc)
     * @see core.data.model.agreement.Agreement#equals(java.lang.Object)
     */
    
    public boolean equals(Object obj)
    {
        // TODO data object equals
        return super.equals(obj);
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IFinanceAgreement#getFinancedAmount()
     */
    public Double getFinancedAmount()
    {
        return financedAmount;
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IFinanceAgreement#getInterest()
     */
    public Double getInterest()
    {
        return interest;
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IFinanceAgreement#getMonths()
     */
    public Integer getMonths()
    {
        return months;
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
        FinanceAgreement agreement = (FinanceAgreement) object;
        return DataUtil.equals(getFinancedAmount(), agreement.getFinancedAmount())
            && DataUtil.equals(getInterest(), agreement.getInterest())
            && DataUtil.equals(getMonths(), agreement.getMonths());
            
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IFinanceAgreement#setFinancedAmount(java.lang.Double)
     */
    public void setFinancedAmount(Double financedAmount)
    {
        this.financedAmount = financedAmount;
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IFinanceAgreement#setInterest(java.lang.Double)
     */
    public void setInterest(Double interest)
    {
        this.interest = interest;
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IFinanceAgreement#setMonths(java.lang.Integer)
     */
    public void setMonths(Integer months)
    {
        this.months = months;
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.Agreement#toString()
     */
    
    public String toString()
    {
        return "FinanceAgreement(" 
            + super.toString()
            + ",financeAmount="
            + getFinancedAmount()
            + ",interest="
            + getInterest()
            + ",months="
            + getMonths()
            + ")";
    }
    

}
