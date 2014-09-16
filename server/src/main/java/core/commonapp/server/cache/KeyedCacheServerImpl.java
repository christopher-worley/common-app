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
package core.commonapp.server.cache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import core.data.cache.KeyedCache;
import core.data.cache.KeyedCacheHandler;
import core.data.cache.KeyedCacheStore;
import core.data.model.Keyable;
import core.tooling.logging.LogFactory;
import core.tooling.logging.Logger;

@Component
public class KeyedCacheServerImpl implements KeyedCache
{
    /** logger for this class */
    private static Logger log = LogFactory.getLogger(KeyedCacheServerImpl.class);
    
    /** data handlers, keyed by data class name*/
    private Map<Class, KeyedCacheHandler> handlers;
    
    /** cached stores keyed by class */
    private Map<Class, KeyedCacheStore> stores;
    
//    /** information context */
//    private InformationContext context;
    
    /** application context used to instantiate this */
    @Autowired
    private ApplicationContext context;
    
    private static volatile Object syncObject = new Object();


    /**
     * Default constructor 
     */
    public KeyedCacheServerImpl() {
		super();
	}

	/**
     * Create keyed map for objects.
     * @param objects
     * @param handler
     * @return
     */
    private Map<String,Keyable> createKeyedObjectMap(List objects, KeyedCacheHandler handler) 
    {
        Map keyedMap = new HashMap();
        
        // loop through the objects, use the handler to generate the object key 
        for (Iterator iter = objects.iterator(); iter.hasNext();)
        {
            Keyable object = (Keyable) iter.next();
            keyedMap.put(handler.getKey(object), object);
        }
        
        return keyedMap;
    }
    
    /**
     * 
     * @param cachedClass
     * @return
     */
    public KeyedCacheStore getCacheStore(Class cachedClass)
    {
    	if (stores == null) {
    		initialize();
    	}
    	
        if (stores.get(cachedClass) == null) {
            reload(cachedClass);
        }
        return stores.get(cachedClass);
    }
    
    /**
     * initialize data archive
     */
    private void initialize() 
    {
        stores = new HashMap<Class, KeyedCacheStore>();
        handlers = new HashMap<Class, KeyedCacheHandler>();
        log.debug("Keyed cache is initializing.");
        Map<String, KeyedCacheHandler> handlerBeans = context.getBeansOfType(KeyedCacheHandler.class);
        for (String name : handlerBeans.keySet()) {
        	KeyedCacheHandler handler = handlerBeans.get(name);
        	handlers.put(handler.getDataClass(), handler);
        }
    }
    
    /**
     * Reload given archived class from handler
     * 
     * @param archivedClass
     */
    public void reload(Class archivedClass)
    {
        synchronized (syncObject)
        {
            // get handler for class
            KeyedCacheHandler handler = (KeyedCacheHandler) handlers.get(archivedClass);
            if (handler == null)
            {
                initialize();
                handler = (KeyedCacheHandler) handlers.get(archivedClass);
            }
            
            if (stores.get(archivedClass.getName()) != null) 
            {
                log.debug("Clearing existing cache store for class (className={0}).", archivedClass.getName());
                stores.remove(archivedClass.getName());
            }
            KeyedCacheStore store = new KeyedCacheStore(createKeyedObjectMap(handler.getObjects(), handler));
            stores.put(archivedClass, store);
            
            log.debug("Reloading archive data for class {0}.", archivedClass.getName());
        }
    }
    
    /**
     * Clear archive and reload all data from handlers
     * 
     */
    public void reloadAll() 
    {
        synchronized (syncObject)
        {
            stores.clear();
            log.debug("Cleared archive reloading data for {0} handlers.", handlers.size());
            
            for (Iterator iter = handlers.keySet().iterator(); iter.hasNext();)
            {
                Object key = iter.next();
                KeyedCacheHandler handler = (KeyedCacheHandler)handlers.get(key);
                List objects = handler.getObjects();
                // add keyed map to archive
                stores.put(handler.getDataClass(), new KeyedCacheStore(createKeyedObjectMap(objects, handler)));
                
                log.debug("Added {0} objects to the {1} archive.", objects.size(), handler.getClass());
            }
        }
    }


}
