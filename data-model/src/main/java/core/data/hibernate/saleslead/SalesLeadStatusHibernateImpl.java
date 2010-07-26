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
package core.data.hibernate.saleslead;

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
import core.data.model.saleslead.SalesLead;
import core.data.model.saleslead.SalesLeadStatus;
import core.data.model.status.Status;
import core.data.model.util.DataUtil;

@Entity
@Table (name="sales_lead_status")
public class SalesLeadStatusHibernateImpl extends LightEntity  implements SalesLeadStatus
{
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="sales_lead_status_id")
    private Integer salesLeadStatusId;

    @ManyToOne (targetEntity=SalesLeadHibernateImpl.class)
    @JoinColumn (name="sales_lead_id")
    private SalesLead salesLead;

    @ManyToOne (targetEntity=StatusHibernateImpl.class)
    @JoinColumn (name="status_id")
    private Status status;

    @Column (name="from_date")
    private Date fromDate;
    
    @Column (name="thru_date")
    private Date thruDate;
    
    /* (non-Javadoc)
     * @see core.data.model.saleslead.SalesLeadStatus#getFromDate()
     */
    public Date getFromDate()
    {
        return fromDate;
    }
    
    
    public Integer getId()
    {
        return getSalesLeadStatusId();
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.SalesLeadStatus#getSalesLead()
     */
    public SalesLead getSalesLead()
    {
        return salesLead;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.SalesLeadStatus#getSalesLeadStatusId()
     */
    public Integer getSalesLeadStatusId()
    {
        return salesLeadStatusId;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.SalesLeadStatus#getStatus()
     */
    public Status getStatus()
    {
        return status;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.SalesLeadStatus#getThruDate()
     */
    public Date getThruDate()
    {
        return thruDate;
    }

    
    public boolean isEquivalent(Object object)
    {
        SalesLeadStatus status = (SalesLeadStatus) object;
        return DataUtil.equals(getSalesLeadStatusId(), status.getSalesLeadStatusId())
            && DataUtil.isEquivalent(getSalesLead(), status.getSalesLead())
            && DataUtil.isEquivalent(getStatus(), status.getStatus())
            && DataUtil.equals(getFromDate(), status.getFromDate())
            && DataUtil.equals(getThruDate(), status.getThruDate());
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.SalesLeadStatus#setFromDate(java.sql.Date)
     */
    public void setFromDate(Date fromDate)
    {
        this.fromDate = fromDate;
    }

    
    public void setId(Integer id)
    {
        setSalesLeadStatusId(id);
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.SalesLeadStatus#setSalesLead(core.data.model.saleslead.SalesLead)
     */
    public void setSalesLead(SalesLead salesLead)
    {
        this.salesLead = salesLead;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.SalesLeadStatus#setSalesLeadStatusId(java.lang.Integer)
     */
    public void setSalesLeadStatusId(Integer salesLeadStatusId)
    {
        this.salesLeadStatusId = salesLeadStatusId;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.SalesLeadStatus#setStatus(core.data.model.status.Status)
     */
    public void setStatus(Status status)
    {
        this.status = status;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.SalesLeadStatus#setThruDate(java.sql.Date)
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
        return "SalesLeadStatus("
            + "salesLeadStatusId="
            + getSalesLeadStatusId()
            + ",salesLeadId="
            + DataUtil.getId(getSalesLead())
            + ",status="
            + getStatus()
            + ",fromDate="
            + getFromDate()
            + ",thruDate="
            + getThruDate()
            + ")";
    }
    
}
