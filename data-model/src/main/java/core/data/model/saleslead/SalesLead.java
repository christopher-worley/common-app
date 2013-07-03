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

import java.util.Date;
import java.util.List;

import core.data.model.DataObject;
import core.service.annotation.InformationBean;
import core.service.annotation.Service;

@InformationBean(beanName="salesLeadModel")
public interface SalesLead extends DataObject
{

    /**
     * Getter for createdDate
     *
     * @return the createdDate
     */
    public abstract Date getCreatedDate();

    /**
     * Getter for description
     *
     * @return the description
     */
    public abstract String getDescription();

    /**
     * Getter for salesLeadContactMechs
     *
     * @return the salesLeadContactMechs
     */
    public abstract List<SalesLeadContactMech> getSalesLeadContactMechs();

    /**
     * Getter for salesLeadId
     *
     * @return the salesLeadId
     */
    public abstract Integer getSalesLeadId();

    /**
     * Getter for salesLeadRoles
     *
     * @return the salesLeadRoles
     */
    public abstract List<SalesLeadRole> getSalesLeadRoles();

    /**
     * Getter for salesLeadStatus
     *
     * @return the salesLeadStatus
     */
    public abstract List<SalesLeadStatus> getSalesLeadStatus();

    /**
     * Getter for salesLeadType
     *
     * @return the salesLeadType
     */
    public abstract SalesLeadType getSalesLeadType();

    /**
     * setter for createdDate
     *
     * @param createdDate the createdDate to List
     */
    public abstract void setCreatedDate(Date createdDate);

    /**
     * setter for description
     *
     * @param description the description to List
     */
    public abstract void setDescription(String description);

    /**
     * setter for salesLeadContactMechs
     *
     * @param salesLeadContactMechs the salesLeadContactMechs to List
     */
    public abstract void setSalesLeadContactMechs(List<SalesLeadContactMech> salesLeadContactMechs);

    /**
     * setter for salesLeadId
     *
     * @param salesLeadId the salesLeadId to List
     */
    public abstract void setSalesLeadId(Integer salesLeadId);

    /**
     * setter for salesLeadRoles
     *
     * @param salesLeadRoles the salesLeadRoles to List
     */
    public abstract void setSalesLeadRoles(List<SalesLeadRole> salesLeadRoles);

    /**
     * setter for salesLeadStatus
     *
     * @param salesLeadStatus the salesLeadStatus to List
     */
    public abstract void setSalesLeadStatus(List<SalesLeadStatus> salesLeadStatus);

    /**
     * Setter for salesLeadType
     *
     * @param salesLeadType the salesLeadType to set
     */
    public abstract void setSalesLeadType(SalesLeadType salesLeadType);

}