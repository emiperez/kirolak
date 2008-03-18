package com.kirolak;

import java.util.Locale;

public class LocalizedKirolakObject
{
	private LocalizedDataId compositeId;
	protected String name;
	protected String seoName;
	
	public LocalizedKirolakObject()
    {
    }

	public LocalizedKirolakObject(LocalizedDataId compositeId, String name, String seoName)
    {
	    this.compositeId = compositeId;
	    this.name = name;
	    this.seoName = seoName;
    }

	public int getId()
	{
		return this.getCompositeId().getId();
	}


	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSeoName()
	{
		return seoName;
	}

	public void setSeoName(String seoName)
	{
		this.seoName = seoName;
	}

	public Locale getLocale()
    {
    	return this.getCompositeId().getLocale();
    }



	public LocalizedDataId getCompositeId()
    {
    	return compositeId;
    }

	public void setCompositeId(LocalizedDataId compositeId)
    {
    	this.compositeId = compositeId;
    }

}
