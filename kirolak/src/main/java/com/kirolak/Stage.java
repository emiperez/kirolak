package com.kirolak;

import java.util.Date;

// Generated 30-nov-2007 8:26:55 by Hibernate Tools 3.2.0.CR1

/**
 * Stage generated by hbm2java
 */
public class Stage extends KirolakObject
{

	protected Competition competition;
	private String name;
	private String seoName;
	private Date startDate;
	private Date finishDate;
	private Byte type;
	private Byte matches;
	private Byte maxParts;
	private String playOffName;
	private Byte pointsWin;
	private Byte pointsDraw;
	private Byte pointsLoose;

	public Stage()
	{
		this.id = -1;
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

	public Byte getType()
	{
		return this.type;
	}

	public void setType(Byte type)
	{
		this.type = type;
	}

	/**
	 * 
	 * @return how many matches play the same contenders for current stage
	 */
	public Byte getMatches()
	{
		return this.matches;
	}

	public void setMatches(Byte matches)
	{
		this.matches = matches;
	}

	public Byte getMaxParts()
	{
		return this.maxParts;
	}

	public void setMaxParts(Byte maxParts)
	{
		this.maxParts = maxParts;
	}

	public String getPlayOffName()
	{
		return this.playOffName;
	}

	public void setPlayOffName(String playOffName)
	{
		this.playOffName = playOffName;
	}

	public Byte getPointsWin()
	{
		return this.pointsWin;
	}

	public void setPointsWin(Byte pointsWin)
	{
		this.pointsWin = pointsWin;
	}

	public Byte getPointsDraw()
	{
		return this.pointsDraw;
	}

	public void setPointsDraw(Byte pointsDraw)
	{
		this.pointsDraw = pointsDraw;
	}

	public Byte getPointsLoose()
	{
		return this.pointsLoose;
	}

	public void setPointsLoose(Byte pointsLoose)
	{
		this.pointsLoose = pointsLoose;
	}

	public Competition getCompetition()
	{
		return competition;
	}

	public void setCompetition(Competition competition)
	{
		this.competition = competition;
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

}
