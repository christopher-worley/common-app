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
package core.data.model.jpa.survey;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import core.data.model.survey.SurveyItemType;
import core.data.model.util.DataUtil;

@Entity
@Table (name="survey_item_type")
public class SurveyItemTypeJpaImpl implements SurveyItemType
{
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="survey_item_type_id")
    private Integer surveyItemTypeId;
    
    @Column (name="description")
    private String description;
    
    @Column (name="key")
    private String key;

    /* (non-Javadoc)
     * @see core.data.model.survey.SurveyItemType#getDescription()
     */
    public String getDescription()
    {
        return description;
    }

    
    public Integer getId()
    {
        return getSurveyItemTypeId();
    }

    /**
     * Getter for key
     *
     * @return the key
     */
    public String getKey()
    {
        return key;
    }

    /* (non-Javadoc)
     * @see core.data.model.survey.SurveyItemType#getSurveyItemTypeId()
     */
    public Integer getSurveyItemTypeId()
    {
        return surveyItemTypeId;
    }

    
    public boolean isEquivalent(Object object)
    {
        SurveyItemTypeJpaImpl type = (SurveyItemTypeJpaImpl) object;
        return DataUtil.equals(getSurveyItemTypeId(), type.getSurveyItemTypeId())
            && DataUtil.equals(getDescription(), type.getDescription())
            && DataUtil.equals(getKey(), type.getKey());
    }

    /* (non-Javadoc)
     * @see core.data.model.survey.SurveyItemType#setDescription(java.lang.String)
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    
    public void setId(Integer id)
    {
        setSurveyItemTypeId(id);
    }

    /**
     * Setter for key
     *
     * @param key the key to set
     */
    public void setKey(String key)
    {
        this.key = key;
    }

    /* (non-Javadoc)
     * @see core.data.model.survey.SurveyItemType#setSurveyItemTypeId(java.lang.Integer)
     */
    public void setSurveyItemTypeId(Integer surveyItemTypeId)
    {
        this.surveyItemTypeId = surveyItemTypeId;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    public String toString()
    {
        return "SurveyItemType("
            + "surveyItemTypeId="
            + getSurveyItemTypeId()
            + ",description="
            + getDescription()
            + ",key="
            + getKey()
            + ")";
    }

}
