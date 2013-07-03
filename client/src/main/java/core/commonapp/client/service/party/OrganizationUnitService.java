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
package core.commonapp.client.service.party;

import core.data.model.party.OrganizationUnit;
import core.data.model.party.PartyGroup;
import core.data.model.security.UserLogin;
import core.service.annotation.InformationBean;
import core.service.annotation.Service;
import core.service.result.ServiceResult;

@InformationBean (beanName="organizationUnitService")
@Service
public interface OrganizationUnitService
{
    
    /**
     * Create PartyGroup for the given organization unit role
     * 
     * @param userLogin
     * @param name
     * @param unit
     * @return
     */
    public ServiceResult<PartyGroup> createOrganizationUnit(UserLogin userLogin, String name, OrganizationUnit unit);

    /**
     * Create PartyGroup for the given organization unit role
     * 
     * @param userLogin
     * @param name
     * @param unit
     * @param parent
     * @return
     */
    public ServiceResult<PartyGroup> createOrganizationUnit(UserLogin userLogin, String name, OrganizationUnit unit, PartyGroup parent);

    /**
     * Create an role type for organization units
     * 
     * @param userLogin
     * @param description
     * @return
     */
    public ServiceResult<OrganizationUnit> createOrganizationUnitRoleType(UserLogin userLogin, String description);

    /**
     * Create an role type for organization units
     * 
     * @param userLogin
     * @param description
     * @param parent
     * @return
     */
    public ServiceResult<OrganizationUnit> createOrganizationUnitRoleType(UserLogin userLogin, String description, OrganizationUnit parent);

    /**
     * Expire the organization unit.  Find all party relationships from and to 
     * the organization unit.  For each, expire the relationship and create a new
     * relationship to <code>moveToParty</code>
     * 
     * @param userLogin
     * @param partyGroup
     * @param moveToParty
     * @return
     */
    public ServiceResult<PartyGroup> expireOrganizationUnit(UserLogin userLogin, PartyGroup partyGroup, PartyGroup moveToParty);

    /**
     * expire the organization unit role type
     * 
     * verify that all organization units of this role have no active party relationships.
     * 
     * @param userLogin
     * @param unit
     * @return
     */
    public ServiceResult<OrganizationUnit> expireOrganizationUnitRoleType(UserLogin userLogin, OrganizationUnit unit);

}
