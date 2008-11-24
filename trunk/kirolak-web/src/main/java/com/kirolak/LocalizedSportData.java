package com.kirolak;

import java.util.Locale;

public class LocalizedSportData
{
	private Sport sport;
	private LocalizedSportId compositeId;
	private String name;
	private String partName;
	private String playOffName;

	public LocalizedSportData()
	{

	}

	public Sport getSport()
	{
		return sport;
	}

	public void setSport(Sport sport)
	{
		this.sport = sport;
	}

	public LocalizedSportId getCompositeId()
	{
		return compositeId;
	}

	public void setCompositeId(LocalizedSportId compositeId)
	{
		this.compositeId = compositeId;
	}
	
	public Locale getLocale()
	{
		return this.compositeId.getLocale();
	}
	
	public String getSeoName()
	{
		return this.compositeId.getSeoName();
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPartName()
	{
		return partName;
	}

	public void setPartName(String partName)
	{
		this.partName = partName;
	}

	public String getPlayOffName()
	{
		return playOffName;
	}

	public void setPlayOffName(String playOffName)
	{
		this.playOffName = playOffName;
	}

}
