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
package core.data.model.saleslead;

import core.data.model.DataObject;
import core.data.model.Keyable;

public interface SalesLeadType extends DataObject, Keyable
{

    /**
     * Getter for description
     * 
     * @return the description
     */
    public abstract String getDescription();

    /**
     * Getter for sales_leadTypeId
     * 
     * @return the sales_leadTypeId
     */
    public abstract Integer getSalesLeadTypeId();

    /**
     * Setter for description
     * 
     * @param description
     *                the description to set
     */
    public abstract void setDescription(String description);

    /**
     * Setter for sales_leadTypeId
     * 
     * @param sales_leadTypeId
     *                the sales_leadTypeId to set
     */
    public abstract void setSalesLeadTypeId(Integer sales_leadTypeId);

}