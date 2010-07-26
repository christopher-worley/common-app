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
import java.util.List;

import core.data.model.DataObject;

public interface Survey extends DataObject
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
     * Getter for surveyId
     *
     * @return the surveyId
     */
    public abstract Integer getSurveyId();

    /**
     * Getter for surveyItems
     *
     * @return the surveyItems
     */
    public abstract List<SurveyItem> getSurveyItems();

    /**
     * Getter for surveyType
     *
     * @return the surveyType
     */
    public abstract SurveyType getSurveyType();

    /**
     * Getter for title
     *
     * @return the title
     */
    public abstract String getTitle();

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
     * Setter for surveyId
     *
     * @param surveyId the surveyId to set
     */
    public abstract void setSurveyId(Integer surveyId);

    /**
     * Setter for surveyItems
     *
     * @param surveyItems the surveyItems to set
     */
    public abstract void setSurveyItems(List<SurveyItem> surveyItems);

    /**
     * Setter for surveyType
     *
     * @param surveyType the surveyType to set
     */
    public abstract void setSurveyType(SurveyType surveyType);

    /**
     * Setter for title
     *
     * @param title the title to set
     */
    public abstract void setTitle(String title);

}