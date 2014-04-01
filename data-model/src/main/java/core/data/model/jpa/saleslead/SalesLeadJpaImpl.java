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
package core.data.model.jpa.saleslead;

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

import core.data.model.DataObject;
import core.data.model.saleslead.SalesLead;
import core.data.model.saleslead.SalesLeadContactMech;
import core.data.model.saleslead.SalesLeadRole;
import core.data.model.saleslead.SalesLeadStatus;
import core.data.model.saleslead.SalesLeadType;
import core.data.model.util.DataUtil;

@Entity
@Table(name = "sales_lead")
public class SalesLeadJpaImpl implements DataObject, SalesLead
{
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="sales_lead_id")
    private Integer salesLeadId;
    
    @ManyToOne (targetEntity=SalesLeadTypeJpaImpl.class)
    @JoinColumn (name="sales_lead_type_id")
    private SalesLeadType salesLeadType;
    
    @Column (name="created_date")
    private Date createdDate;

    @Column (name="description")
    private String description;

    @OneToMany (cascade={CascadeType.ALL}, targetEntity=SalesLeadRoleJpaImpl.class)
    @JoinColumn (name="sales_lead_id")
    private List<SalesLeadRole> salesLeadRoles;
    
    @OneToMany (cascade={CascadeType.ALL}, targetEntity=SalesLeadContactMechJpaImpl.class)
    @JoinColumn (name="sales_lead_id")
    private List<SalesLeadContactMech> salesLeadContactMechs;
    
    @OneToMany (cascade={CascadeType.ALL}, targetEntity=SalesLeadStatusJpaImpl.class)
    @JoinColumn (name="sales_lead_id")
    private List<SalesLeadStatus> salesLeadStatus;
    
    
    /* (non-Javadoc)
     * @see core.data.model.saleslead.SalesLead#getCreatedDate()
     */
    public Date getCreatedDate()
    {
        return createdDate;
    }
    
    /* (non-Javadoc)
     * @see core.data.model.saleslead.SalesLead#getDescription()
     */
    public String getDescription()
    {
        return description;
    }

    
    public Integer getId()
    {
        return getSalesLeadId();
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.SalesLead#getSalesLeadContactMechs()
     */
    public List<SalesLeadContactMech> getSalesLeadContactMechs()
    {
        return salesLeadContactMechs;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.SalesLead#getSalesLeadId()
     */
    public Integer getSalesLeadId()
    {
        return salesLeadId;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.SalesLead#getSalesLeadRoles()
     */
    public List<SalesLeadRole> getSalesLeadRoles()
    {
        return salesLeadRoles;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.SalesLead#getSalesLeadStatus()
     */
    public List<SalesLeadStatus> getSalesLeadStatus()
    {
        return salesLeadStatus;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.SalesLead#getSalesLeadType()
     */
    public SalesLeadType getSalesLeadType()
    {
        return salesLeadType;
    }

    
    public boolean isEquivalent(Object object)
    {
        SalesLead lead = (SalesLead) object;
        return DataUtil.equals(getSalesLeadId(), lead.getSalesLeadId())
            && DataUtil.equals(getCreatedDate(), lead.getCreatedDate())
            && DataUtil.equals(getDescription(), lead.getDescription())
            && DataUtil.isEquivalent(getSalesLeadRoles(), lead.getSalesLeadRoles())
            && DataUtil.isEquivalent(getSalesLeadContactMechs(), lead.getSalesLeadContactMechs())
            && DataUtil.isEquivalent(getSalesLeadStatus(), lead.getSalesLeadStatus());
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.SalesLead#setCreatedDate(java.sql.Date)
     */
    public void setCreatedDate(Date createdDate)
    {
        this.createdDate = createdDate;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.SalesLead#setDescription(java.lang.String)
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    
    public void setId(Integer id)
    {
        setSalesLeadId(id);
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.SalesLead#setSalesLeadContactMechs(java.util.List)
     */
    public void setSalesLeadContactMechs(List<SalesLeadContactMech> salesLeadContactMechs)
    {
        this.salesLeadContactMechs = salesLeadContactMechs;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.SalesLead#setSalesLeadId(java.lang.Integer)
     */
    public void setSalesLeadId(Integer salesLeadId)
    {
        this.salesLeadId = salesLeadId;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.SalesLead#setSalesLeadRoles(java.util.List)
     */
    public void setSalesLeadRoles(List<SalesLeadRole> salesLeadRoles)
    {
        this.salesLeadRoles = salesLeadRoles;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.SalesLead#setSalesLeadStatus(java.util.List)
     */
    public void setSalesLeadStatus(List<SalesLeadStatus> salesLeadStatus)
    {
        this.salesLeadStatus = salesLeadStatus;
    }

    /* (non-Javadoc)
     * @see core.data.model.saleslead.SalesLead#setSalesLeadType(core.data.model.saleslead.SalesLeadType)
     */
    public void setSalesLeadType(SalesLeadType salesLeadType)
    {
        this.salesLeadType = salesLeadType;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    public String toString()
    {
        return "SalesLead("
            + "salesLeadId="
            + getSalesLeadId()
            + ",description="
            + getDescription()
            + ",createdDate="
            + getCreatedDate()
            + ",salesLeadRoles="
            + getSalesLeadRoles()
            + ",salesLeadContactMechs="
            + getSalesLeadContactMechs()
            + ",salesLeadStatus="
            + getSalesLeadStatus()
            + ")";
    }

}
