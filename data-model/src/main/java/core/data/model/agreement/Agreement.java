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

import java.util.Date;
import java.util.List;

import core.data.model.DataObject;

public interface Agreement extends DataObject 
{

    /**
     * Getter for agreementContactMechs
     *
     * @return the agreementContactMechs
     */
    public abstract List<AgreementContactMech> getAgreementContactMechs();

    /**
     * Getter for agreementId
     *
     * @return the agreementId
     */
    public abstract Integer getAgreementId();

    /**
     * Getter for agreementRoles
     *
     * @return the agreementRoles
     */
    public abstract List<AgreementRole> getAgreementRoles();

    /**
     * Getter for agreementStatus
     *
     * @return the agreementStatus
     */
    public abstract List<AgreementStatus> getAgreementStatus();

    /**
     * Getter for agreementType
     *
     * @return the agreementType
     */
    public abstract AgreementType getAgreementType();

    /**
     * Getter for createdDate
     *
     * @return the createdDate
     */
    public abstract Date getCreatedDate();

    /**
     * Getter for effectiveDate
     *
     * @return the effectiveDate
     */
    public abstract Date getEffectiveDate();

    /**
     * Getter for title
     *
     * @return the title
     */
    public abstract String getTitle();

    /**
     * Setter for agreementContactMechs
     *
     * @param agreementContactMechs the agreementContactMechs to set
     */
    public abstract void setAgreementContactMechs(List<AgreementContactMech> agreementContactMechs);

    /**
     * Setter for agreementId
     *
     * @param agreementId the agreementId to set
     */
    public abstract void setAgreementId(Integer agreementId);

    /**
     * Setter for agreementRoles
     *
     * @param agreementRoles the agreementRoles to set
     */
    public abstract void setAgreementRoles(List<AgreementRole> agreementRoles);

    /**
     * Setter for agreementStatus
     *
     * @param agreementStatus the agreementStatus to set
     */
    public abstract void setAgreementStatus(List<AgreementStatus> agreementStatus);

    /**
     * Setter for agreementType
     *
     * @param agreementType the agreementType to set
     */
    public abstract void setAgreementType(AgreementType agreementType);

    /**
     * Setter for createdDate
     *
     * @param createdDate the createdDate to set
     */
    public abstract void setCreatedDate(Date createdDate);

    /**
     * Setter for effectiveDate
     *
     * @param effectiveDate the effectiveDate to set
     */
    public abstract void setEffectiveDate(Date effectiveDate);

    /**
     * Setter for title
     *
     * @param title the title to set
     */
    public abstract void setTitle(String title);

}