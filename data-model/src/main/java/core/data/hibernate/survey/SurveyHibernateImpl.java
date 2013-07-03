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
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import core.data.model.survey.Survey;
import core.data.model.survey.SurveyItem;
import core.data.model.survey.SurveyType;
import core.data.model.util.DataUtil;

@Entity
@Table (name="survey")
public class SurveyHibernateImpl implements Survey
{
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="survey_id")
    private Integer surveyId;
    
    @ManyToOne (targetEntity=SurveyTypeHibernateImpl.class)
    @JoinColumn (name="survey_type_id")
    private SurveyType surveyType;
    
    @Column (name="title")
    private String title;

    @Column (name="description")
    private String description;
    
    @Column (name="created_date")
    private Date createdDate;
    
    @OneToMany (cascade={CascadeType.ALL}, targetEntity=SurveyItemHibernateImpl.class)
    @JoinColumn (name="survey_id")
    private List<SurveyItem> surveyItems;

    /* (non-Javadoc)
     * @see core.data.model.survey.Survey#getCreatedDate()
     */
    public Date getCreatedDate()
    {
        return createdDate;
    }

    /* (non-Javadoc)
     * @see core.data.model.survey.Survey#getDescription()
     */
    public String getDescription()
    {
        return description;
    }

    
    public Integer getId()
    {
        return getSurveyId();
    }

    /* (non-Javadoc)
     * @see core.data.model.survey.Survey#getSurveyId()
     */
    public Integer getSurveyId()
    {
        return surveyId;
    }

    /* (non-Javadoc)
     * @see core.data.model.survey.Survey#getSurveyItems()
     */
    public List<SurveyItem> getSurveyItems()
    {
        return surveyItems;
    }

    /* (non-Javadoc)
     * @see core.data.model.survey.Survey#getSurveyType()
     */
    public SurveyType getSurveyType()
    {
        return surveyType;
    }

    /* (non-Javadoc)
     * @see core.data.model.survey.Survey#getTitle()
     */
    public String getTitle()
    {
        return title;
    }

    
    public boolean isEquivalent(Object object)
    {
        Survey survey = (Survey) object;
        return DataUtil.equals(getSurveyId(), survey.getSurveyId())
            && DataUtil.isEquivalent(getSurveyType(), survey.getSurveyType())
            && DataUtil.equals(getTitle(), survey.getTitle())
            && DataUtil.equals(getDescription(), survey.getDescription())
            && DataUtil.equals(getCreatedDate(), survey.getCreatedDate())
            && DataUtil.isEquivalent(getSurveyItems(), survey.getSurveyItems());
    }

    /* (non-Javadoc)
     * @see core.data.model.survey.Survey#setCreatedDate(java.sql.Date)
     */
    public void setCreatedDate(Date createdDate)
    {
        this.createdDate = createdDate;
    }

    /* (non-Javadoc)
     * @see core.data.model.survey.Survey#setDescription(java.lang.String)
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    
    public void setId(Integer id)
    {
        setSurveyId(id);
    }

    /* (non-Javadoc)
     * @see core.data.model.survey.Survey#setSurveyId(java.lang.Integer)
     */
    public void setSurveyId(Integer surveyId)
    {
        this.surveyId = surveyId;
    }

    /* (non-Javadoc)
     * @see core.data.model.survey.Survey#setSurveyItems(java.util.List)
     */
    public void setSurveyItems(List<SurveyItem> surveyItems)
    {
        this.surveyItems = surveyItems;
    }

    /* (non-Javadoc)
     * @see core.data.model.survey.Survey#setSurveyType(core.data.model.survey.SurveyType)
     */
    public void setSurveyType(SurveyType surveyType)
    {
        this.surveyType = surveyType;
    }

    /* (non-Javadoc)
     * @see core.data.model.survey.Survey#setTitle(java.lang.String)
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    public String toString()
    {
        return "Survey("
            + "surveyId="
            + getSurveyId()
            + ",surveyType="
            + getSurveyType()
            + ",title="
            + getTitle()
            + ",description="
            + getDescription()
            + ",createdDate="
            + getCreatedDate()
            + ",surveyItems="
            + getSurveyItems()
            + ")";
    }

}
