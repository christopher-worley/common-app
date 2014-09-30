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

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import core.data.model.survey.SurveyAssociationType;
import core.data.model.survey.SurveyItem;
import core.data.model.survey.SurveyItemAssociation;

@Entity
@Table (name="survey_item_association")
public class SurveyItemAssociationJpaImpl implements SurveyItemAssociation
{
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="survey_item_association_id")
    private Integer surveyItemAssocitationId;
    
    @ManyToOne (targetEntity=SurveyAssociationTypeJpaImpl.class)
    @JoinColumn (name="survey_association_type_id")
    private SurveyAssociationType surveyAssociationType;

    @ManyToOne (targetEntity=SurveyItemJpaImpl.class)
    @JoinColumn (name="survey_item_from_id")
    private SurveyItem surveyItemFrom;
    
    @ManyToOne (targetEntity=SurveyItemJpaImpl.class)
    @JoinColumn (name="survey_item_to_id")
    private SurveyItem surveyItemTo;
    
    @Column (name="from_date")
    private Date fromDate;
    
    @Column (name="thru_date")
    private Date thruDate;

    /* (non-Javadoc)
     * @see core.data.model.survey.SurveyItemAssociation#getFromDate()
     */
    public Date getFromDate()
    {
        return fromDate;
    }

    
    public Integer getId()
    {
        return getSurveyItemAssocitationId();
    }

    /* (non-Javadoc)
     * @see core.data.model.survey.SurveyItemAssociation#getSurveyAssociationType()
     */
    public SurveyAssociationType getSurveyAssociationType()
    {
        return surveyAssociationType;
    }

    /* (non-Javadoc)
     * @see core.data.model.survey.SurveyItemAssociation#getSurveyItemAssocitationId()
     */
    public Integer getSurveyItemAssocitationId()
    {
        return surveyItemAssocitationId;
    }

    /* (non-Javadoc)
     * @see core.data.model.survey.SurveyItemAssociation#getSurveyItemFrom()
     */
    public SurveyItem getSurveyItemFrom()
    {
        return surveyItemFrom;
    }

    /* (non-Javadoc)
     * @see core.data.model.survey.SurveyItemAssociation#getSurveyItemTo()
     */
    public SurveyItem getSurveyItemTo()
    {
        return surveyItemTo;
    }

    /* (non-Javadoc)
     * @see core.data.model.survey.SurveyItemAssociation#getThruDate()
     */
    public Date getThruDate()
    {
        return thruDate;
    }

    
    public boolean isEquivalent(Object object)
    {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see core.data.model.survey.SurveyItemAssociation#setFromDate(java.sql.Date)
     */
    public void setFromDate(Date fromDate)
    {
        this.fromDate = fromDate;
    }

    
    public void setId(Integer id)
    {
        setSurveyItemAssocitationId(id);
    }

    /* (non-Javadoc)
     * @see core.data.model.survey.SurveyItemAssociation#setSurveyAssociationType(core.data.model.survey.SurveyAssociationTypeJpaImpl)
     */
    public void setSurveyAssociationType(SurveyAssociationType surveyAssociationType)
    {
        this.surveyAssociationType = surveyAssociationType;
    }

    /* (non-Javadoc)
     * @see core.data.model.survey.SurveyItemAssociation#setSurveyItemAssocitationId(java.lang.Integer)
     */
    public void setSurveyItemAssocitationId(Integer surveyItemAssocitationId)
    {
        this.surveyItemAssocitationId = surveyItemAssocitationId;
    }

    /* (non-Javadoc)
     * @see core.data.model.survey.SurveyItemAssociation#setSurveyItemFrom(core.data.model.survey.SurveyItem)
     */
    public void setSurveyItemFrom(SurveyItem surveyItemFrom)
    {
        this.surveyItemFrom = surveyItemFrom;
    }

    /* (non-Javadoc)
     * @see core.data.model.survey.SurveyItemAssociation#setSurveyItemTo(core.data.model.survey.SurveyItem)
     */
    public void setSurveyItemTo(SurveyItem surveyItemTo)
    {
        this.surveyItemTo = surveyItemTo;
    }

    /* (non-Javadoc)
     * @see core.data.model.survey.SurveyItemAssociation#setThruDate(java.sql.Date)
     */
    public void setThruDate(Date thruDate)
    {
        this.thruDate = thruDate;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    public String toString()
    {
        return "SurveyItemAssociation("
            + "surveyItemAssociationId="
            + getSurveyItemAssocitationId()
            + ",surveyAssociationType="
            + getSurveyAssociationType()
            + ",surveyItemFrom="
            + getSurveyItemFrom()
            + ",surveyItemTo="
            + getSurveyItemTo()
            + ",fromDate="
            + getFromDate()
            + ",thruDate="
            + getThruDate()
            + ")";
            
    }

}
