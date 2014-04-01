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
package core.data.helper.sales;

import java.util.ArrayList;

import core.data.model.contact.ContactMech;
import core.data.model.contact.ContactMechPurpose;
import core.data.model.jpa.saleslead.SalesLeadContactMechJpaImpl;
import core.data.model.jpa.saleslead.SalesLeadRoleJpaImpl;
import core.data.model.party.Party;
import core.data.model.party.RoleType;
import core.data.model.saleslead.SalesLead;
import core.data.model.saleslead.SalesLeadContactMech;
import core.data.model.saleslead.SalesLeadRole;
import core.data.model.saleslead.SalesLeadStatus;

/**
 * Helper methods for sales lead data
 * 
 * @author worleyc
 *
 */
public class SalesLeadHelper
{
    private SalesLead salesLead;
    
    /**
     * @param salesLead
     */
    public SalesLeadHelper(SalesLead salesLead)
    {
        super();
        this.salesLead = salesLead;
    }

    /**
     * Create SalesLeadContactMech and add to list of contact mechs
     * 
     * @param contactMech
     * @param purpose
     */
    public void addSalesLeadContactMech(ContactMech contactMech, ContactMechPurpose purpose)
    {
        SalesLeadContactMech salesLeadContactMech = new SalesLeadContactMechJpaImpl();
        salesLeadContactMech.setContactMech(contactMech);
        salesLeadContactMech.setContactMechPurpose(purpose);
        addSalesLeadContactMech(salesLeadContactMech);
    }
    
    /**
     * Add contactMech to list of contact mechs
     * 
     * @param contactMech
     */
    public void addSalesLeadContactMech(SalesLeadContactMech contactMech)
    {
       if (salesLead.getSalesLeadContactMechs() == null)
       {
           salesLead.setSalesLeadContactMechs(new ArrayList<SalesLeadContactMech>());
       }
       contactMech.setSalesLead(salesLead);
       salesLead.getSalesLeadContactMechs() .add(contactMech);
    }

    /**
     * @param party
     * @param roleType
     */
    public void addSalesLeadRole(Party party, RoleType roleType)
    {
        SalesLeadRole role = new SalesLeadRoleJpaImpl();
        role.setParty(party);
        role.setRoleType(roleType);
        addSalesLeadRole(role);
    }
    
    /**
     * @param role
     */
    public void addSalesLeadRole(SalesLeadRole role)
    {
        if (salesLead.getSalesLeadRoles()== null) 
        {
            salesLead.setSalesLeadRoles(new ArrayList<SalesLeadRole>());
        }
        role.setSalesLead(salesLead);
        salesLead.getSalesLeadRoles().add(role);
    }
    
    /**
     * @param status
     */
    public void addSalesLeadStatus(SalesLeadStatus status)
    {
        if (salesLead.getSalesLeadStatus() == null) 
        {
            salesLead.setSalesLeadStatus(new ArrayList<SalesLeadStatus>());
        }
        status.setSalesLead(salesLead);
        salesLead.getSalesLeadStatus().add(status);
    }

}
