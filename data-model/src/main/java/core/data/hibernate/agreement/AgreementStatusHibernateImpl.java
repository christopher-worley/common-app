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
package core.data.hibernate.agreement;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.sf.gilead.pojo.java5.LightEntity;
import core.data.hibernate.status.StatusHibernateImpl;
import core.data.model.agreement.Agreement;
import core.data.model.agreement.AgreementStatus;
import core.data.model.status.Status;
import core.data.model.util.DataUtil;

@Entity
@Table (name="agreement_status")
public class AgreementStatusHibernateImpl extends LightEntity implements AgreementStatus
{
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="agreement_status_id")
    private Integer agreementStatusId;
    
    @ManyToOne (targetEntity=AgreementHibernateImpl.class)
    @JoinColumn (name="agreement_id")
    private Agreement agreement;

    @ManyToOne (targetEntity=StatusHibernateImpl.class)
    @JoinColumn (name="status_id")
    private Status status;

    @Column (name="from_date")
    private Date fromDate;

    @Column (name="thru_date")
    private Date thruDate;

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    
    public boolean equals(Object obj)
    {
        // TODO data object hash code
        return super.equals(obj);
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreementStatus#getAgreement()
     */
    public Agreement getAgreement()
    {
        return agreement;
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreementStatus#getAgreementStatusId()
     */
    public Integer getAgreementStatusId()
    {
        return agreementStatusId;
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreementStatus#getFromDate()
     */
    public Date getFromDate()
    {
        return fromDate;
    }

    
    public Integer getId()
    {
        return getAgreementStatusId();
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreementStatus#getStatus()
     */
    public Status getStatus()
    {
        return status;
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreementStatus#getThruDate()
     */
    public Date getThruDate()
    {
        return thruDate;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    
    public int hashCode()
    {
        // TODO data object hash code
        return super.hashCode();
    }

    /* (non-Javadoc)
     * @see core.data.DataObject#isEquivalent(java.lang.Object)
     */
    
    public boolean isEquivalent(Object object)
    {
        AgreementStatus status = (AgreementStatus) object;
        return DataUtil.equals(getAgreementStatusId(), status.getAgreementStatusId())
            && DataUtil.isEquivalent(getAgreement(), status.getAgreement())
            && DataUtil.isEquivalent(getStatus(), status.getStatus())
            && DataUtil.equals(getFromDate(), status.getFromDate())
            && DataUtil.equals(getThruDate(), status.getThruDate());    
     }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreementStatus#setAgreement(core.data.model.agreement.Agreement)
     */
    public void setAgreement(Agreement agreement)
    {
        this.agreement = agreement;
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreementStatus#setAgreementStatusId(java.lang.Integer)
     */
    public void setAgreementStatusId(Integer agreementStatusId)
    {
        this.agreementStatusId = agreementStatusId;
    }    

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreementStatus#setFromDate(java.sql.Date)
     */
    public void setFromDate(Date fromDate)
    {
        this.fromDate = fromDate;
    }

    
    public void setId(Integer id)
    {
        setAgreementStatusId(id);
    }
    
    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreementStatus#setStatus(core.data.model.status.Status)
     */
    public void setStatus(Status status)
    {
        this.status = status;
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreementStatus#setThruDate(java.sql.Date)
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
        return "AgreementStatus("
            + "agreementStatusId="
            + getAgreementStatusId()
            + ",agreementId="
            + DataUtil.getId(getAgreement())
            + ",status="
            + getStatus()
            + ",fromDate="
            + getFromDate()
            + ",thruDate="
            + getThruDate()
            + ")";
    }

}
