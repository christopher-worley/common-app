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
import core.data.model.Expirable;
import core.data.model.status.Status;

public interface AgreementStatus extends DataObject, Expirable 
{

    /**
     * Getter for agreement
     *
     * @return the agreement
     */
    public abstract Agreement getAgreement();

    /**
     * Getter for agreementStatusId
     *
     * @return the agreementStatusId
     */
    public abstract Integer getAgreementStatusId();

    /**
     * Getter for status
     *
     * @return the status
     */
    public abstract Status getStatus();


    /**
     * Setter for agreement
     *
     * @param agreement the agreement to set
     */
    public abstract void setAgreement(Agreement agreement);

    /**
     * Setter for agreementStatusId
     *
     * @param agreementStatusId the agreementStatusId to set
     */
    public abstract void setAgreementStatusId(Integer agreementStatusId);


    /**
     * Setter for status
     *
     * @param status the status to set
     */
    public abstract void setStatus(Status status);

}