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

import net.sf.gilead.pojo.java5.LightEntity;
import core.data.model.agreement.Agreement;
import core.data.model.agreement.AgreementContactMech;
import core.data.model.agreement.AgreementRole;
import core.data.model.agreement.AgreementStatus;
import core.data.model.agreement.AgreementType;
import core.data.model.util.DataUtil;

@Entity
@Table (name="agreement")
public class AgreementHibernateImpl extends LightEntity implements Agreement
{
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="agreement_id")
    private Integer agreementId;
    
    @ManyToOne (targetEntity=AgreementTypeHibernateImpl.class)
    @JoinColumn (name="agreement_type_id")
    private AgreementType agreementType;
    
    @Column (name="created_date")
    private Date createdDate;
    
    @Column (name="effective_date")
    private Date effectiveDate;
    
    @Column (name="title")
    private String title;
    
    @OneToMany (cascade={CascadeType.ALL}, targetEntity=AgreementContactMechHibernateImpl.class)
    @JoinColumn (name="agreement_id")
    private List<AgreementContactMech> agreementContactMechs;
    
    @OneToMany (cascade={CascadeType.ALL}, targetEntity=AgreementRoleHibernateImpl.class)
    @JoinColumn (name="agreement_id")
    private List<AgreementRole> agreementRoles;
    
    @OneToMany (cascade={CascadeType.ALL}, targetEntity=AgreementStatusHibernateImpl.class)
    @JoinColumn (name="agreement_id")
    private List<AgreementStatus> agreementStatus;

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    
    public boolean equals(Object obj)
    {
        // TODO data object equals
        return super.equals(obj);
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreement#getAgreementContactMechs()
     */
    public List<AgreementContactMech> getAgreementContactMechs()
    {
        return agreementContactMechs;
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreement#getAgreementId()
     */
    public Integer getAgreementId()
    {
        return agreementId;
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreement#getAgreementRoles()
     */
    public List<AgreementRole> getAgreementRoles()
    {
        return agreementRoles;
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreement#getAgreementStatus()
     */
    public List<AgreementStatus> getAgreementStatus()
    {
        return agreementStatus;
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreement#getAgreementType()
     */
    public AgreementType getAgreementType()
    {
        return agreementType;
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreement#getCreatedDate()
     */
    public Date getCreatedDate()
    {
        return createdDate;
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreement#getEffectiveDate()
     */
    public Date getEffectiveDate()
    {
        return effectiveDate;
    }
    

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreement#getId()
     */
    public Integer getId()
    {
        return getAgreementId();
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreement#getTitle()
     */
    public String getTitle()
    {
        return title;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    
    public int hashCode()
    {
        // TODO data object hash code
        return super.hashCode();
    }

    public boolean isEquivalent(Object object)
    {
        Agreement agreement = (Agreement) object;
        return getAgreementId().equals(agreement.getAgreementId())
            && DataUtil.isEquivalent(getAgreementType(), agreement.getAgreementType())
            && getCreatedDate().equals(agreement.getCreatedDate())
            && getEffectiveDate().equals(agreement.getEffectiveDate())
            && getTitle().equals(agreement.getTitle())
            && DataUtil.isEquivalent(getAgreementContactMechs(), agreement.getAgreementContactMechs())
            && DataUtil.isEquivalent(getAgreementRoles(), agreement.getAgreementRoles())
            && DataUtil.isEquivalent(getAgreementStatus(), agreement.getAgreementStatus());
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreement#setAgreementContactMechs(java.util.List)
     */
    public void setAgreementContactMechs(List<AgreementContactMech> agreementContactMechs)
    {
        this.agreementContactMechs = agreementContactMechs;
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreement#setAgreementId(java.lang.Integer)
     */
    public void setAgreementId(Integer agreementId)
    {
        this.agreementId = agreementId;
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreement#setAgreementRoles(java.util.List)
     */
    public void setAgreementRoles(List<AgreementRole> agreementRoles)
    {
        this.agreementRoles = agreementRoles;
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreement#setAgreementStatus(java.util.List)
     */
    public void setAgreementStatus(List<AgreementStatus> agreementStatus)
    {
        this.agreementStatus = agreementStatus;
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreement#setAgreementType(core.data.model.agreement.AgreementType)
     */
    public void setAgreementType(AgreementType agreementType)
    {
        this.agreementType = agreementType;
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreement#setCreatedDate(java.sql.Date)
     */
    public void setCreatedDate(Date createdDate)
    {
        this.createdDate = createdDate;
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreement#setEffectiveDate(java.sql.Date)
     */
    public void setEffectiveDate(Date effectiveDate)
    {
        this.effectiveDate = effectiveDate;
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreement#setId(java.lang.Integer)
     */
    public void setId(Integer id)
    {
        setAgreementId(id);
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreement#setTitle(java.lang.String)
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
        return "Agreement("
            + "agreementId="
            + getAgreementId()
            + ",agreementType="
            + getAgreementType()
            + ",createdDate="
            + getCreatedDate()
            + ",effectiveDate="
            + getEffectiveDate()
            + ",title="
            + getTitle()
            + ",agreementContactMech="
            + getAgreementContactMechs()
            + ",agreementRoles="
            + getAgreementRoles()
            + ",agreementStatus="
            + getAgreementStatus()
            + ")";
    }

}
