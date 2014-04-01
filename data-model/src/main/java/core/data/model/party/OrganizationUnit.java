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
package core.data.model.party;

import java.util.Date;

import core.data.model.DataObject;
import core.data.model.Expirable;

public interface OrganizationUnit extends DataObject, Expirable
{

    public Date getFromDate();

    public Integer getId();

    public Integer getOrganizationUnitId();

    public RoleType getRoleType();

    public Date getThruDate();

    public void setFromDate(Date fromDate);

    public void setId(Integer id);

    public void setOrganizationUnitId(Integer organizationUnitId);

    public void setRoleType(RoleType roleType);

    public void setThruDate(Date thruDate);

    public OrganizationUnit getParentOrganizationUnit();

    public void setParentOrganizationUnit(OrganizationUnit parentOrganizationUnit);

    
}
