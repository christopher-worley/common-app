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
package core.test.server.mock.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 * Utils class which reads data files for mail and femail
 * names to be used for mock data.
 * 
 * @author worleyc
 *
 */
public class PersonNameUtil {
    /**
     * get singleton instance
     */
    public static PersonNameUtil getInstance()
    {
        return instance;
    }
    
    /** female names list */
    List<String> femaleNames = new ArrayList<String>();
    
    /** last names list */
    List<String> lastNames = new ArrayList<String>();
    
    /** male names list */
    List<String> maleNames = new ArrayList<String>();
    
    /** file path prefix */
    private String filePrefix = "/home/worleyc/archive/core/object-mock/";

    /** singleton instance */
    private static PersonNameUtil instance = new PersonNameUtil();
    
    /**
     * Default constructor
     */
    protected PersonNameUtil()
    {
        initialize();
    }

	public List getFemaleNames() {
		return femaleNames;
	}

	public List getLastNames() {
		return lastNames;
	}

	public List getMaleNames() {
		return maleNames;
	}
    
    /**
     * initialize data
     */
    private void initialize()
    {
        try {
			initializeFemaleNames();
			initializeLastNames();
	        initializeMaleNames();
		} catch (IOException e) {
			throw new RuntimeException("Failed to load names from files.", e);
		}
    }
    
    /**
     * initialize femail names from file
     * @throws IOException 
     * 
     */
    private void initializeFemaleNames() throws IOException
    {
    	File file = new File(filePrefix + "/data/people-names/female-names.txt");
    	femaleNames = FileUtils.readLines(file, "UTF-8");
    }
    
    /**
     * read last names from file and populate array
     * @throws IOException 
     */
    private void initializeLastNames() throws IOException
    {
        File file = new File(filePrefix + "/data/people-names/last-names.txt");
        lastNames = FileUtils.readLines(file, "UTF-8");
    }
    
    /**
     * initialize mail names from file
     * @throws IOException 
     * 
     */
    private void initializeMaleNames() throws IOException
    {
        File file = new File(filePrefix + "/data/people-names/male-names.txt");
        maleNames = FileUtils.readLines(file, "UTF-8");
    }

}
