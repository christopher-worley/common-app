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

import java.util.List;

import core.data.model.Keyable;

/**
 * The CleintDataArchive uses DatArchiveHandler interface
 * to manage data in the archive.
 * 
 * @author worleyc
 *
 */
public interface KeyedCacheHandler
{
    
    /**
     * Return class the handler is for
     * 
     * @return
     */
    public Class getDataClass();
    
    /**
     * Return the key that identifies the object
     * 
     * The key needs to only be unique for objects of the
     * same class, not all objects in the archive.
     * 
     * @param keyableObject data object to generate key from
     * @return
     */
    public Object getKey(Keyable keyableObject);
    
    /**
     * return all objects that should be given
     * to the archive
     * 
     * @return
     */
    public List getObjects();

}
