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
package core.commonapp.server.data;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.SubnodeConfiguration;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.configuration.tree.ConfigurationNode;

import core.commonapp.client.dao.GenericDAO;
import core.commonapp.domain.InformationContext;
import core.data.model.Keyable;
import core.tooling.logging.LogFactory;
import core.tooling.logging.Logger;

public class RequiredDataReader
{
    /** logger for ths class */
    private static Logger log = LogFactory.getLogger(RequiredDataReader.class);

    /** default file name */
    private static String DEFAULT_FILENAME = "/core-required-data.xml";

    /** data objects added to db */
    List<Object> dataObjects = new ArrayList<Object>();

    private Map<String, Object> referenceMap = new HashMap<String, Object>();

    private InformationContext context;
    
    /**
     * Default Constructor
     */
    public RequiredDataReader(InformationContext context)
    {
        this.context = context;
    }

    /**
     * getter for dataObjects
     * 
     * @return
     */
    public List getDataObjects()
    {
        return dataObjects;
    }

    /**
     * 
     * @param object
     * @param methodName
     * @return
     */
    private Method getMethod(Object object, String methodName)
    {
        Method[] methods = object.getClass().getMethods();
        Method method = null;
        for (int index = 0; index < methods.length; index++)
        {
            if (methods[index].getName().equals(methodName))
            {
                method = methods[index];
            }
        }
        return method;
    }

    /**
     * return data objects read
     * 
     */
    public List getObjects()
    {
        return dataObjects;
    }

    /**
     * Initialize data reader
     * 
     * if there are relationships that need to be defined. In the xml define the
     * forgein relation first. Then reference the relation as the value of the
     * columns with ${RelationType.KeyValue}. The relation type is the class
     * name with no package. i.e. 'forgeinKey=${GeoType._STATE}'
     */
    public void read(String filename)
    {
        GenericDAO genericDao = (GenericDAO) context.getBean("genericDAO");

        try
        {
            log.debug("Reading data file {0}.", filename);
            XMLConfiguration reader = new XMLConfiguration(getClass().getResource(filename));
            List<SubnodeConfiguration> records = reader.configurationsAt("record");
            for (SubnodeConfiguration record : records)
            {
                String beanName = record.getString("[@bean]");
                Object object = context.getBean(beanName);
                ConfigurationNode node = record.getRootNode();
                List<ConfigurationNode> attributes = node.getAttributes();

                // attempt to load from db, if found then use it to update
                // instead of a new object to insert
                Object dbObject = null;
                String key = record.getString("[@key]");
                if (object instanceof Keyable &&  key != null)
                {
                    Keyable keyable = (Keyable) object;
                    dbObject = genericDao.findByField(object.getClass(), "key", key);
                    if (dbObject != null)
                    {
                        log.debug("Found keyed object in database (dbObject={0}).", dbObject);
                        // set the object to the one in the db so we can update the
                        // fields with data from xml
                        object = dbObject;
                    }
                }

                for (ConfigurationNode attribute : attributes)
                {
                    String name = attribute.getName();
                    String value = (String) attribute.getValue();
                    if (value.startsWith("$"))
                    {
                        // remove the wrapping ${...}
                        // TODO: reg expr error check format
                        value = value.substring(2);
                        value = value.substring(0, value.length() - 1);
                        log.debug("Static data reference found (refId={0})", value);
                        // set method
                        String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
                        Method method = getMethod(object, methodName);
                        method.invoke(object, referenceMap.get(value));
                    } else if ("%CURRENT_TIMESTAMP".equals(value))
                    {
                        String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
                        Method method = getMethod(object, methodName);
                        method.invoke(object, new Date());
                    }
                    else if ("refId".equals(name))                     
                    {
                        referenceMap.put(value, object);
                        log.debug("Adding declared reference object by id (refId={0},object={1}).", value, object);
                    } else if (!"bean".equals(name))
                    {
                        String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
                        Method method = getMethod(object, methodName);
                        method.invoke(object, value);
                    }
                }

                // if the object is keyable then infer the reference
                if (object instanceof Keyable)
                {
                    Keyable keyable = (Keyable) object;
                    String refId = keyable.getClass().getSimpleName().replace("HibernateImpl", "") + "."
                            + keyable.getKey();
                    referenceMap.put(refId, object);
                    log.debug("Inferred reference for object (refId={0},object={1}).", refId, object);
                }

                // add object to list for saving
                dataObjects.add(object);
            }
        } catch (ConfigurationException e)
        {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e)
        {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * Read default file
     */
    public void readDefault()
    {
        read(DEFAULT_FILENAME);
    }

}
