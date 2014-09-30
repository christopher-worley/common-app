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
package core.data.model.status;

import core.data.model.DataObject;
import core.data.model.Keyable;

public interface Status extends DataObject, Keyable
{

    /**
     * Getter for code
     *
     * @return the code
     */
    public abstract String getCode();

    /**
     * Getter for description
     *
     * @return the description
     */
    public abstract String getDescription();

    /**
     * Getter for statusId
     *
     * @return the statusId
     */
    public abstract Integer getStatusId();

    /**
     * Getter for statusType
     *
     * @return the statusType
     */
    public abstract StatusType getStatusType();

    /**
     * Setter for code
     *
     * @param code the code to set
     */
    public abstract void setCode(String code);

    /**
     * Setter for description
     *
     * @param description the description to set
     */
    public abstract void setDescription(String description);

    /**
     * Setter for statusId
     *
     * @param statusId the statusId to set
     */
    public abstract void setStatusId(Integer statusId);

    /**
     * Setter for statusType
     *
     * @param statusType the statusType to set
     */
    public abstract void setStatusType(StatusType statusType);

}