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
package core.data.hibernate.survey;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import core.data.model.survey.Survey;
import core.data.model.survey.SurveyItem;
import core.data.model.survey.SurveyItemType;
import core.data.model.util.DataUtil;

@Entity
@Table (name="survey_item")
public class SurveyItemHibernateImpl implements SurveyItem
{
 
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="survey_item_id")
    private Integer surveyItemId;
    
    @ManyToOne (targetEntity=SurveyItemTypeHibernateImpl.class)
    @JoinColumn (name="survey_item_type")
    private SurveyItemType surveyItemType;

    @ManyToOne (targetEntity=SurveyHibernateImpl.class)
    @JoinColumn (name="survey_id")
    private Survey survey;
    
    @Column (name="created_date")
    private Date createdDate;
    
    @Column (name="sequence")
    private Integer sequence;
    
    @Column (name="code")
    private String code;
    
    @Column (name="description")
    private String description;
    
    @Column (name="itemText")
    private String itemText;

    /* (non-Javadoc)
     * @see core.data.model.survey.SurveyItem#getCode()
     */
    public String getCode()
    {
        return code;
    }

    /* (non-Javadoc)
     * @see core.data.model.survey.SurveyItem#getCreatedDate()
     */
    public Date getCreatedDate()
    {
        return createdDate;
    }

    /* (non-Javadoc)
     * @see core.data.model.survey.SurveyItem#getDescription()
     */
    public String getDescription()
    {
        return description;
    }

    
    public Integer getId()
    {
        return getSurveyItemId();
    }

    /* (non-Javadoc)
     * @see core.data.model.survey.SurveyItem#getItemText()
     */
    public String getItemText()
    {
        return itemText;
    }

    /* (non-Javadoc)
     * @see core.data.model.survey.SurveyItem#getSequence()
     */
    public Integer getSequence()
    {
        return sequence;
    }

    /* (non-Javadoc)
     * @see core.data.model.survey.SurveyItem#getSurvey()
     */
    public Survey getSurvey()
    {
        return survey;
    }

    /* (non-Javadoc)
     * @see core.data.model.survey.SurveyItem#getSurveyItemId()
     */
    public Integer getSurveyItemId()
    {
        return surveyItemId;
    }

    /* (non-Javadoc)
     * @see core.data.model.survey.SurveyItem#getSurveyItemType()
     */
    public SurveyItemType getSurveyItemType()
    {
        return surveyItemType;
    }

    
    public boolean isEquivalent(Object object)
    {
        SurveyItem item = (SurveyItem) object;
        return DataUtil.equals(getSurveyItemId(), item.getSurveyItemId())
            && DataUtil.isEquivalent(getSurveyItemType(), item.getSurveyItemType())
            && DataUtil.isEquivalent(getSurvey(), item.getSurvey())
            && DataUtil.equals(getCreatedDate(), item.getCreatedDate())
            && DataUtil.equals(getSequence(), item.getSequence())
            && DataUtil.equals(getCode(), item.getCode())
            && DataUtil.equals(getDescription(), item.getDescription())
            && DataUtil.equals(getItemText(), item.getItemText());
    }

    /* (non-Javadoc)
     * @see core.data.model.survey.SurveyItem#setCode(java.lang.String)
     */
    public void setCode(String code)
    {
        this.code = code;
    }

    /* (non-Javadoc)
     * @see core.data.model.survey.SurveyItem#setCreatedDate(java.sql.Date)
     */
    public void setCreatedDate(Date createdDate)
    {
        this.createdDate = createdDate;
    }

    /* (non-Javadoc)
     * @see core.data.model.survey.SurveyItem#setDescription(java.lang.String)
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    
    public void setId(Integer id)
    {
        setSurveyItemId(id);
    }

    /* (non-Javadoc)
     * @see core.data.model.survey.SurveyItem#setItemText(java.lang.String)
     */
    public void setItemText(String itemText)
    {
        this.itemText = itemText;
    }

    /* (non-Javadoc)
     * @see core.data.model.survey.SurveyItem#setSequence(java.lang.Integer)
     */
    public void setSequence(Integer sequence)
    {
        this.sequence = sequence;
    }

    /* (non-Javadoc)
     * @see core.data.model.survey.SurveyItem#setSurvey(core.data.model.survey.Survey)
     */
    public void setSurvey(Survey survey)
    {
        this.survey = survey;
    }

    /* (non-Javadoc)
     * @see core.data.model.survey.SurveyItem#setSurveyItemId(java.lang.Integer)
     */
    public void setSurveyItemId(Integer surveyItemId)
    {
        this.surveyItemId = surveyItemId;
    }

    /* (non-Javadoc)
     * @see core.data.model.survey.SurveyItem#setSurveyItemType(core.data.model.survey.SurveyItemType)
     */
    public void setSurveyItemType(SurveyItemType surveyItemType)
    {
        this.surveyItemType = surveyItemType;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    public String toString()
    {
        return "SurveyItem("
            + "surveyItemId="
            + getSurveyItemId()
            + ",surveyItemType="
            + getSurveyItemType()
            + ",survey="
            + getSurvey()
            + ",createdDate="
            + getCreatedDate()
            + ",sequence="
            + getSequence()
            + ",code="
            + getCode()
            + ",description="
            + getDescription()
            + ",itemText="
            + getItemText()
            + ")";
    }

}
