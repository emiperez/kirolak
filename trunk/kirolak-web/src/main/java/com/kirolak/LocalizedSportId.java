package com.kirolak;

import java.util.Locale;

public class LocalizedSportId
{
	private Locale locale;
	protected String seoName;
	
	public LocalizedSportId()
	{
		
	}
	
	public LocalizedSportId(Locale locale, String seoName)
	{
		this.locale = locale;
		this.seoName = seoName;
	}
	
	public Locale getLocale()
    {
    	return locale;
    }
	public void setLocale(Locale locale)
    {
    	this.locale = locale;
    }
	public String getSeoName()
    {
    	return seoName;
    }
	public void setSeoName(String seoName)
    {
    	this.seoName = seoName;
    }
}
