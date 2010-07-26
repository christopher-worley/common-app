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
package core.commonapp.server.service.party;

import java.util.Date;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.transaction.annotation.Transactional;

import core.commonapp.client.dao.party.OrganizationUnitDAO;
import core.commonapp.client.dao.party.PartyGroupDAO;
import core.commonapp.client.service.party.OrganizationUnitService;
import core.commonapp.domain.InformationContext;
import core.data.cache.KeyedCache;
import core.data.helper.party.PartyHelper;
import core.data.model.party.OrganizationUnit;
import core.data.model.party.PartyGroup;
import core.data.model.party.RoleType;
import core.data.model.security.UserLogin;
import core.service.result.ServiceResult;

public class OrganizationUnitServiceImpl implements OrganizationUnitService, ApplicationContextAware
{
    private InformationContext context;
    
    @Autowired
    private OrganizationUnitDAO organizationUnitDAO;
    
    @Autowired
    private PartyGroupDAO partyGroupDAO;
    
    @Autowired
    private KeyedCache keyedCache;

    @Override
    public ServiceResult<PartyGroup> createOrganizationUnit(UserLogin userLogin, String name, OrganizationUnit unit)
    {
        return createOrganizationUnit(userLogin, name, unit, null);
    }
    
    @Override
    public ServiceResult<PartyGroup> createOrganizationUnit(UserLogin userLogin, String name, OrganizationUnit unit, PartyGroup parent)
    {
        // create party group
        PartyGroup partyGroup = (PartyGroup) context.getBean(PartyGroup.class);
        partyGroup.setGroupName(name);
        
        // add organization unit role to party group
        PartyHelper<PartyGroup> helper = new PartyHelper<PartyGroup>(keyedCache, partyGroup);
        helper.addRoleType(unit.getRoleType());
        
        // add relationship to parent
        if (parent != null)
        {
            // TODO: validate role type some how. there could be more than one... or could there ???
            RoleType roleType = parent.getPartyRoles().get(0).getRoleType();
            helper.addRelationshipTo(parent, roleType, unit.getRoleType(), new Date());
        }
        
        // persist
        partyGroup = partyGroupDAO.save(partyGroup);
        
        return ServiceResult.success("Created organization unit successfully.", partyGroup);
    }

    @Override
    @Transactional
    public ServiceResult<OrganizationUnit> createOrganizationUnitRoleType(UserLogin userLogin, String description)
    {
        return createOrganizationUnitRoleType(userLogin, description, null);
    }

    @Override
    @Transactional
    public ServiceResult<OrganizationUnit> createOrganizationUnitRoleType(UserLogin userLogin, String description,
            OrganizationUnit parent)
    {
        RoleType roleType = (RoleType) context.getBean(RoleType.class);
        roleType.setDescription(description);
        // TODO: should role type have a key ????

        OrganizationUnit unit = (OrganizationUnit) context.getBean(OrganizationUnit.class);
        unit.setRoleType(roleType);
        unit.setParentOrganizationUnit(parent);
        // TODO: server service date
        unit.setFromDate(new Date());
        
        unit = organizationUnitDAO.save(unit);
        
        return ServiceResult.success("Organization unit role created successfully.", unit);
    }

    @Override
    public ServiceResult<PartyGroup> expireOrganizationUnit(UserLogin userLogin, PartyGroup partyGroup,
            PartyGroup moveToParty)
    {
        return null;
    }

    @Override
    public ServiceResult<OrganizationUnit> expireOrganizationUnitRoleType(UserLogin userLogin, OrganizationUnit unit)
    {
        return null;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
    {
        context = new InformationContext(applicationContext);
    }

}
