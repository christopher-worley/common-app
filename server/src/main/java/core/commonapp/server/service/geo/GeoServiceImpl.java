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
 package core.commonapp.server.service.geo;

import org.springframework.beans.factory.annotation.Autowired;

import core.commonapp.client.dao.geo.GeoDAO;
import core.commonapp.client.dao.geo.GeoTypeDAO;
import core.commonapp.client.service.geo.GeoService;
import core.data.model.geo.GeoType;
import core.service.result.ServiceResult;

public class GeoServiceImpl implements GeoService
{
    /** geo dao */
    private GeoDAO geoDAO;

    /** geo type dao */
    private GeoTypeDAO geoTypeDAO;
    
    public GeoServiceImpl()
    {
        super();
        
    }

    
    /**
     * default constructor
     * 
     * @param geoDAO
     * @param geoTypeDAO
     */
    @Autowired
    public GeoServiceImpl(GeoDAO geoDAO, GeoTypeDAO geoTypeDAO)
    {
        super();
        this.geoDAO = geoDAO;
        this.geoTypeDAO = geoTypeDAO;
    }

    @Override
    public ServiceResult findAllGeos()
    {
        return new ServiceResult(geoDAO.findAll());
    }

    @Override
    public ServiceResult findAllGeoTypes()
    {
        return new ServiceResult(geoTypeDAO.findAll());
    }

    @Override
    public ServiceResult findByGeoType(GeoType type)
    {
        return new ServiceResult(geoDAO.findByGeoType(type));
    }

}
