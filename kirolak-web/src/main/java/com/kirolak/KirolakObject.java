package com.kirolak;

import java.util.Iterator;
import java.util.Locale;
import java.util.Set;


public abstract class KirolakObject implements java.io.Serializable
{
	protected KirolakObject parent;
	protected int id;
	protected Set<LocalizedKirolakObject> localizedData; 

	public int getIntId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getName()
	{
		return "NO NAME";
	}

	public String getName(Locale locale)
	{
		LocalizedKirolakObject item = getLocalizedItem(locale);
		if(item == null)
		{
			//TODO Throw an Exception
			return "NO NAME FOR GIVEN LOCALE";
		}
		else
		{
			return item.getName();
		}
	}
	
	public String getSeoName(Locale locale)
	{
		LocalizedKirolakObject item = getLocalizedItem(locale);
		if(item == null)
		{
			//TODO Throw an Exception
			return "NO NAME FOR GIVEN LOCALE";
		}
		else
		{
			return item.getSeoName();
		}
	}
	
	public LocalizedKirolakObject getLocalizedItem(Locale locale)
	{
		LocalizedKirolakObject returnValue = null;
		Iterator<LocalizedKirolakObject> iterator = localizedData.iterator();
		LocalizedKirolakObject item;
		
		while(iterator.hasNext())
		{
			item = iterator.next();
			if(item.getLocale().equals(locale))
			{
				return item;
			}
			else
			{
				if (item.getLocale().getLanguage().equals(locale.getLanguage()))
				{
					returnValue = item;					
				}
			}
		}
		return returnValue;
	}

	public Set<LocalizedKirolakObject> getLocalizedData()
    {
    	return localizedData;
    }

	public void setLocalizedData(Set<LocalizedKirolakObject> localizedData)
    {
    	this.localizedData = localizedData;
    }

}
