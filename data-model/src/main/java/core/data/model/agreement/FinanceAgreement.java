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
package core.data.model.agreement;


public interface FinanceAgreement
{

    /**
     * Getter for financedAmount
     *
     * @return the financedAmount
     */
    public abstract Double getFinancedAmount();

    /**
     * Getter for interest
     *
     * @return the interest
     */
    public abstract Double getInterest();

    /**
     * Getter for months
     *
     * @return the months
     */
    public abstract Integer getMonths();

    /**
     * Setter for financedAmount
     *
     * @param financedAmount the financedAmount to set
     */
    public abstract void setFinancedAmount(Double financedAmount);

    /**
     * Setter for interest
     *
     * @param interest the interest to set
     */
    public abstract void setInterest(Double interest);

    /**
     * Setter for months
     *
     * @param months the months to set
     */
    public abstract void setMonths(Integer months);

}