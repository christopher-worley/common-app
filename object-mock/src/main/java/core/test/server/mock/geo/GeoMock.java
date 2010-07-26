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
package core.test.server.mock.geo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import core.commonapp.domain.InformationContext;
import core.data.cache.KeyedCacheStore;
import core.data.cache.geo.GeoTypeKey;
import core.data.model.geo.Geo;
import core.test.server.mock.AbstractObjectMock;

public class GeoMock extends AbstractObjectMock
{
    List<Geo> states;
    
    /**
     * @param context
     */
    public GeoMock(InformationContext context)
    {
        super(context);
    }

    /**
     * return random state
     * 
     * @return
     */
    public Geo generateState()
    {
        List<Geo> states = getStates();
        int index = new Random().nextInt(states.size());
        return states.get(index);
    }

    private List<Geo> getStates()
    {
        if (states == null)
        {
            KeyedCacheStore<Geo> geoCache = (KeyedCacheStore<Geo>) getKeyedCache().getCacheStore(Geo.class);
            states = new ArrayList<Geo>();
            List<Geo> geos = geoCache.getObjects();
            for (Iterator<Geo> iter = geos.iterator(); iter.hasNext();)
            {
                Geo geo = iter.next();
                if (GeoTypeKey.KEY_STATE.equals(geo.getGeoType().getKey()))
                {
                    states.add(geo);
                }
            }
                
        }
        return states;
    }
}
