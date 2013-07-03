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
package core.data.hibernate.document;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import core.data.model.document.Document;

@Entity
@Table (name="documet")
public class DocumentHibernateImpl implements Document
{

	@Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column (name="document_id")
    private Integer documentId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="path_prefix")
	private String pathPrefix;
	
	@Column(name="path_suffix")
	private String pathSuffix;
	
	@Column(name="filename")
	private String filename;
    
    public String getDescription()
	{
		return description;
	}

    
    public Integer getDocumentId()
	{
		return documentId;
	}


	public String getFilename()
	{
		return filename;
	}


	public Integer getId()
    {
		return getDocumentId();
    }


	public String getName()
	{
		return name;
	}


	public String getPathPrefix()
	{
		return pathPrefix;
	}


	public String getPathSuffix()
	{
		return pathSuffix;
	}


	public boolean isEquivalent(Object object)
    {
        // TODO Auto-generated method stub
        return false;
    }


	public void setDescription(String description)
	{
		this.description = description;
	}


	public void setDocumentId(Integer documentId)
	{
		this.documentId = documentId;
	}


	public void setFilename(String filename)
	{
		this.filename = filename;
	}


	public void setId(Integer id)
    {
		setDocumentId(id);
    }


	public void setName(String name)
	{
		this.name = name;
	}


	public void setPathPrefix(String pathPrefix)
	{
		this.pathPrefix = pathPrefix;
	}

    
    public void setPathSuffix(String pathSuffix)
	{
		this.pathSuffix = pathSuffix;
	}

}
