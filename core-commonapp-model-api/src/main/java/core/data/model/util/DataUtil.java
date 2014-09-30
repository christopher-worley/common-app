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
package core.data.model.util;

import java.util.Iterator;
import java.util.List;

import core.data.model.DataObject;

/**
 * Utilities for data objects
 * 
 * @author worleyc
 *
 */
public class DataUtil
{
    
    /**
     * return true if the two objects are equals otherwise return false
     * 
     * @param left
     * @param right
     * @return
     */
    public static boolean equals(Object left, Object right)
    {
        if ((left == null && right != null)
                || (left != null && right == null))
        {
            return false;
        }
        return left.equals(right);
    }

    /**
     * Return the id of the given data object
     * 
     * @param object
     * @return
     */
    public static Integer getId(DataObject object)
    {
        return object == null ? null : object.getId();
    }

    /**
     * list comma spearated list of ids
     * 
     * @param statusTransitionRoles
     * @return
     */
    public static String getIds(List objects)
    {
        if (objects == null)
        {
            return "empty";
        }
        
        String ids = "";
        for (Iterator iter = objects.iterator(); iter.hasNext();)
        {
            DataObject object = (DataObject) iter.next();
            ids += object.getId() + (iter.hasNext() ? "," : "");
        }
        return ids;
    }
    
    /**
     * 
     * @param string
     * @return
     */
    public static boolean isEmpty(String string)
    {
       return (string == null ? true : string.isEmpty()); 
    }
    
    /**
     * Check if the data model objects are equivalent to each other.
     * 
     * @param left
     * @param right
     * @return
     */
    public static boolean isEquivalent(DataObject left, DataObject right)
    {
        // if they are both null then return true
       if (left == null && right == null)
       {
           return true;
       }
       // at this point if either of them is null return false
       if (left == null || right == null)
       {
           return false;
       }
       // compare the ids
       return DataUtil.equals(left.getId(), right.getId());
    }

    /**
     * return true if all <code>DataObject</code> elements in the list are equivalent,
     * otherwise return false
     * 
     * @param left
     * @param right
     * @return
     */
    public static boolean isEquivalent(List left, List right)
    {
        // if they are both null return true
        if (left == null && right == null)
        {
            return true;
        }
        // at this point if either of them is null return false
        if (left == null || right == null)
        {
            return false;
        }
        // check size
        if (left.size() != right.size())
        {
            return false;
        }
        // 
        for (int index = 0; index < left.size(); index++)
        {
            if (!isEquivalent((DataObject)left.get(index), (DataObject)right.get(index)))
            {
                return false;
            }
        }
        return true;
    }
}
