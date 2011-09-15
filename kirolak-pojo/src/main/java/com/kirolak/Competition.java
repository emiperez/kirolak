package com.kirolak;

import java.util.Date;
import java.util.Set;

// Generated 30-nov-2007 8:26:55 by Hibernate Tools 3.2.0.CR1

/**
 * Competition generated by hbm2java
 */
public class Competition extends KirolakObject
{

	private String name;
	private String seoName;
	private Date startDate;
	private Date finishDate;
	private Set<Team> teams;

	public Competition()
	{
		this.id = -1;
	}

	public Competition(int id, String name, String seoName)
	{
		this.id = id;
		this.name = name;
		this.seoName = seoName;
	}

	public Competition(int id, Sport sport, String name, String seoName)
	{
		this.id = id;
		this.parent = sport;
		this.name = name;
		this.seoName = seoName;
	}

	public int getId()
	{
		return this.id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSeoName()
	{
		return this.seoName;
	}

	public void setSeoName(String seoName)
	{
		this.seoName = seoName;
	}

	public Sport getSport()
	{
		return (Sport)this.parent;
	}

	public void setSport(Sport sport)
	{
		this.parent = sport;
	}

	public Date getStartDate()
	{
		return startDate;
	}

	public void setStartDate(Date startDate)
	{
		this.startDate = startDate;
	}

	public Date getFinishDate()
	{
		return finishDate;
	}

	public void setFinishDate(Date finishDate)
	{
		this.finishDate = finishDate;
	}

	public Set getTeams()
	{
		return teams;
	}

	public void setTeams(Set teams)
	{
		this.teams = teams;
	}

}