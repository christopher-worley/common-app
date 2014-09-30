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

public interface SurveyItem extends DataObject
{

    /**
     * Getter for code
     *
     * @return the code
     */
    public abstract String getCode();

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
     * Getter for itemText
     *
     * @return the itemText
     */
    public abstract String getItemText();

    /**
     * Getter for sequence
     *
     * @return the sequence
     */
    public abstract Integer getSequence();

    /**
     * Getter for survey
     *
     * @return the survey
     */
    public abstract Survey getSurvey();

    /**
     * Getter for surveyItemId
     *
     * @return the surveyItemId
     */
    public abstract Integer getSurveyItemId();

    /**
     * Getter for surveyItemType
     *
     * @return the surveyItemType
     */
    public abstract SurveyItemType getSurveyItemType();

    /**
     * Setter for code
     *
     * @param code the code to set
     */
    public abstract void setCode(String code);

    /**
     * Setter for createdDate
     *
     * @param createdDate the createdDate to set
     */
    public abstract void setCreatedDate(Date createdDate);

    /**
     * Setter for description
     *
     * @param description the description to set
     */
    public abstract void setDescription(String description);

    /**
     * Setter for itemText
     *
     * @param itemText the itemText to set
     */
    public abstract void setItemText(String itemText);

    /**
     * Setter for sequence
     *
     * @param sequence the sequence to set
     */
    public abstract void setSequence(Integer sequence);

    /**
     * Setter for survey
     *
     * @param survey the survey to set
     */
    public abstract void setSurvey(Survey survey);

    /**
     * Setter for surveyItemId
     *
     * @param surveyItemId the surveyItemId to set
     */
    public abstract void setSurveyItemId(Integer surveyItemId);

    /**
     * Setter for surveyItemType
     *
     * @param surveyItemType the surveyItemType to set
     */
    public abstract void setSurveyItemType(SurveyItemType surveyItemType);

}