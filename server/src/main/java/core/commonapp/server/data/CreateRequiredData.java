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

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import core.commonapp.domain.InformationContext;
import core.data.model.DataObject;
import core.tooling.logging.LogFactory;
import core.tooling.logging.Logger;

/**
 * For the core framework to work properly there is
 * certain required data that must exist in the database.
 * This class will ensure that the data does exist the 
 * database.
 * 
 * Required data for the core framework is <code>Keyable</code>
 * and the keys will be prefixed with an underscore "_"
 * 
 * @author worleyc
 *
 */
public class CreateRequiredData
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        new CreateRequiredData().storeData(Arrays.asList(args));
    }
    
    /** logger for this class */
    Logger log = LogFactory.getLogger(CreateRequiredData.class);
    
    private InformationContext context;

    /**
     * Default constructor
     * 
     * Create data based on application context from commonapp server context xml
     */
    public CreateRequiredData()
    {
        context = new InformationContext(new ClassPathXmlApplicationContext("commonapp-server-context.xml"));
    }

    /**
     * Create data based on a specific application context
     */
    public CreateRequiredData(ApplicationContext applicationContext)
    {
        context = new InformationContext(applicationContext);
    }
    
    /**
     * store all the objects read in
     */
    public void store(List dataObjects)
    {
        log.info("Creating required data, storing {0} objects.", dataObjects.size());
        for (Iterator iter = dataObjects.iterator(); iter.hasNext();)
        {
            DataObject object = (DataObject) iter.next();
            // save the data object
            try 
            {
            	EntityManager entityManager = (EntityManager) context.getBean(EntityManager.class);
                entityManager.persist(object);
                log.info("Data object saved: {0}", object);
            }
            catch (Exception e)
            {
                log.error("Failed to save required data object: {0}", object);
            }
            
        }
    }

    
    /**
     * Read default file and all files in the list and store the data
     * 
     * @param files
     */
    public void storeData(List files)
    {
        RequiredDataReader reader = new RequiredDataReader(context);
        // read default file
        reader.readDefault();
        
        // TODO: accept other files from command line 
        reader.read("/core-security-data.xml");
        
        for (Iterator iter = files.iterator(); iter.hasNext();)
        {
            reader.read((String)iter.next());
        }
        
        // store data
        store(reader.getDataObjects());
    }
    
    /**
     * read the default file only and store the data
     */
    public void storeDefaultData()
    {
        storeData(null);
    }
}
