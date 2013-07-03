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

import core.data.hibernate.party.PartyHibernateImpl;
import core.data.hibernate.party.RoleTypeHibernateImpl;
import core.data.model.agreement.Agreement;
import core.data.model.agreement.AgreementRole;
import core.data.model.party.Party;
import core.data.model.party.RoleType;
import core.data.model.util.DataUtil;

@Entity
@Table (name="agreement_role")
public class AgreementRoleHibernateImpl implements AgreementRole
{
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="agreement_role_id")
    private Integer agreementRoleId;
    
    @ManyToOne (targetEntity=AgreementHibernateImpl.class)
    @JoinColumn (name="agreement_id")
    private Agreement agreement;    
    
    @ManyToOne (targetEntity=PartyHibernateImpl.class)
    @JoinColumn (name="party_id")
    private Party party;

    @ManyToOne (targetEntity=RoleTypeHibernateImpl.class)
    @JoinColumn (name="role_type_id")
    private RoleType roleType;

    @Column (name="from_date")
    private Date fromDate;
    
    @Column (name="thru_date")
    private Date thruDate;

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    
    public boolean equals(Object obj)
    {
        // TODO data object agreement role
        return super.equals(obj);
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreementRole#getAgreement()
     */
    public Agreement getAgreement()
    {
        return agreement;
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreementRole#getAgreementRoleId()
     */
    public Integer getAgreementRoleId()
    {
        return agreementRoleId;
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreementRole#getFromDate()
     */
    public Date getFromDate()
    {
        return fromDate;
    }

    public Integer getId()
    {
        return getAgreementRoleId();
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreementRole#getParty()
     */
    public Party getParty()
    {
        return party;
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreementRole#getRoleType()
     */
    public RoleType getRoleType()
    {
        return roleType;
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreementRole#getThruDate()
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
        AgreementRole role = (AgreementRole) object;
        return getAgreementRoleId().equals(role.getAgreementRoleId())
            && DataUtil.isEquivalent(getAgreement(), role.getAgreement())
            && DataUtil.isEquivalent(getRoleType(), role.getRoleType())
            && DataUtil.isEquivalent(getParty(), role.getParty())
            && getFromDate().equals(role.getFromDate())
            && getThruDate().equals(role.getThruDate());
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreementRole#setAgreement(core.data.model.agreement.Agreement)
     */
    public void setAgreement(Agreement agreement)
    {
        this.agreement = agreement;
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreementRole#setAgreementRoleId(java.lang.Integer)
     */
    public void setAgreementRoleId(Integer agreementContactMechId)
    {
        this.agreementRoleId = agreementContactMechId;
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreementRole#setFromDate(java.sql.Date)
     */
    public void setFromDate(Date fromDate)
    {
        this.fromDate = fromDate;
    }


    public void setId(Integer id)
    {
        setAgreementRoleId(id);
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreementRole#setParty(core.data.model.party.Party)
     */
    public void setParty(Party party)
    {
        this.party = party;
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreementRole#setRoleType(core.data.model.party.RoleType)
     */
    public void setRoleType(RoleType roleType)
    {
        this.roleType = roleType;
    }

    /* (non-Javadoc)
     * @see core.data.model.agreement.IAgreementRole#setThruDate(java.sql.Date)
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
        return "AgreementRole("
            + "agreementRoleId="
            + getAgreementRoleId()
            + ",agreementId="
            + DataUtil.getId(getAgreement())
            + ",partyId="
            + DataUtil.getId(getParty())
            + ",roleType="
            + DataUtil.getId(getRoleType())
            + ",fromDate="
            + getFromDate()
            + ",thruDate="
            + getThruDate()
            + ")";
    }

}
