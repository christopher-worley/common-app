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
package core.data.cache;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class KeyedCacheStore<T>
{

    /** cached objects */
    private Map<String, T> objects;
    
    /**
     * @param objects
     */
    public KeyedCacheStore(Map<String, T> objects)
    {
        this.objects = objects;
    }

    /**
     * 
     * @param key
     * @return
     */
    public T getObject(String key)
    {
        return objects.get(key);
    }
    
    /**
     * @return
     */
    public List<T> getObjects()
    {
        List<T> list = new ArrayList<T>(objects.size());
        for (Iterator<String> iter = objects.keySet().iterator(); iter.hasNext();)
        {
            list.add(objects.get(iter.next()));
        }
        return list;
    }
}
