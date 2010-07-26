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
package core.data.model;

import java.util.Date;


/**
 * Expirable represents a data or a relationship of data
 * where the relevance of the data existence or relationship
 * occurs during a period of time between the <code>fromDate</code>
 * and the <code>thruDate</code>
 * 
 * @author worleyc
 *
 */
public interface Expirable {
	
	/**
	 * Get from date for the start of the data relevance
	 * 
	 * @return
	 */
	public Date getFromDate();
	
	/**
	 * Get from date for the end of the data relevance
	 * 
	 * @return
	 */
	public Date getThruDate();
	
	/**
	 * Set from date for the start of the data relevance
	 * 
	 * @return
	 */
	public void setFromDate(Date fromDate);
	
	/**
	 * Set from date for the end of the data relevance
	 * 
	 * @return
	 */
	public void setThruDate(Date thruDate);

}
