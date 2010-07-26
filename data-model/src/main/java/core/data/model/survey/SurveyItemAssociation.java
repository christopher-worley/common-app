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
package core.data.model.survey;


import java.util.Date;

import core.data.model.DataObject;

public interface SurveyItemAssociation extends DataObject
{

    /**
     * Getter for fromDate
     *
     * @return the fromDate
     */
    public abstract Date getFromDate();

    /**
     * Getter for surveyAssociationType
     *
     * @return the surveyAssociationType
     */
    public abstract SurveyAssociationType getSurveyAssociationType();

    /**
     * Getter for surveyItemAssocitationId
     *
     * @return the surveyItemAssocitationId
     */
    public abstract Integer getSurveyItemAssocitationId();

    /**
     * Getter for surveyItemFrom
     *
     * @return the surveyItemFrom
     */
    public abstract SurveyItem getSurveyItemFrom();

    /**
     * Getter for surveyItemTo
     *
     * @return the surveyItemTo
     */
    public abstract SurveyItem getSurveyItemTo();

    /**
     * Getter for thruDate
     *
     * @return the thruDate
     */
    public abstract Date getThruDate();

    /**
     * Setter for fromDate
     *
     * @param fromDate the fromDate to set
     */
    public abstract void setFromDate(Date fromDate);

    /**
     * Setter for surveyAssociationType
     *
     * @param surveyAssociationType the surveyAssociationType to set
     */
    public abstract void setSurveyAssociationType(SurveyAssociationType surveyAssociationType);

    /**
     * Setter for surveyItemAssocitationId
     *
     * @param surveyItemAssocitationId the surveyItemAssocitationId to set
     */
    public abstract void setSurveyItemAssocitationId(Integer surveyItemAssocitationId);

    /**
     * Setter for surveyItemFrom
     *
     * @param surveyItemFrom the surveyItemFrom to set
     */
    public abstract void setSurveyItemFrom(SurveyItem surveyItemFrom);

    /**
     * Setter for surveyItemTo
     *
     * @param surveyItemTo the surveyItemTo to set
     */
    public abstract void setSurveyItemTo(SurveyItem surveyItemTo);

    /**
     * Setter for thruDate
     *
     * @param thruDate the thruDate to set
     */
    public abstract void setThruDate(Date thruDate);

}