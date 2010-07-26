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

import core.data.model.DataObject;

public interface AgreementType extends DataObject 
{

    /**
     * Getter for agreementTypeId
     *
     * @return the agreementTypeId
     */
    public abstract Integer getAgreementTypeId();

    /**
     * Getter for description
     *
     * @return the description
     */
    public abstract String getDescription();

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    public abstract int hashCode();

    /**
     * Setter for agreementTypeId
     *
     * @param agreementTypeId the agreementTypeId to set
     */
    public abstract void setAgreementTypeId(Integer agreementTypeId);

    /**
     * Setter for description
     *
     * @param description the description to set
     */
    public abstract void setDescription(String description);

}