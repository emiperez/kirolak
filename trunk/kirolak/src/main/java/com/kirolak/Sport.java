package com.kirolak;

// Generated 30-nov-2007 8:26:55 by Hibernate Tools 3.2.0.CR1

/**
 * Sport generated by hbm2java
 */
public class Sport extends KirolakObject implements java.io.Serializable
{
	private Byte maxParts;
	private String name;
	private String partName;
	private String playOffName;
	private Byte pointsDraw;
	private Byte pointsLoose;
	private Byte pointsWin;

	private Byte scoreMode;
	private String seoName;

	public Sport()
	{
		this.id = -1;
	}

	public Sport(short id, String name, String seoName, Byte scoreMode, String partName, Byte maxParts, String playOffName, Byte pointsWin,
			Byte pointsDraw, Byte pointsLoose)
	{
		this.id = id;
		this.name = name;
		this.seoName = seoName;
		this.scoreMode = scoreMode;
		this.partName = partName;
		this.maxParts = maxParts;
		this.playOffName = playOffName;
		this.pointsWin = pointsWin;
		this.pointsDraw = pointsDraw;
		this.pointsLoose = pointsLoose;
	}

	public void setId(short id)
	{
		this.id = id;
	}

	public short getId()
	{
		return Integer.valueOf(super.id).shortValue();
	}

	public Byte getMaxParts()
	{
		return this.maxParts;
	}

	public String getName()
	{
		return this.name;
	}

	public String getPartName()
	{
		return this.partName;
	}

	public String getPlayOffName()
	{
		return this.playOffName;
	}

	public Byte getPointsDraw()
	{
		return this.pointsDraw;
	}

	public Byte getPointsLoose()
	{
		return this.pointsLoose;
	}

	public Byte getPointsWin()
	{
		return this.pointsWin;
	}

	public Byte getScoreMode()
	{
		return this.scoreMode;
	}

	public String getSeoName()
	{
		return this.seoName;
	}

	public void setMaxParts(Byte maxParts)
	{
		this.maxParts = maxParts;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setPartName(String partName)
	{
		this.partName = partName;
	}

	public void setPlayOffName(String playOffName)
	{
		this.playOffName = playOffName;
	}

	public void setPointsDraw(Byte pointsDraw)
	{
		this.pointsDraw = pointsDraw;
	}

	public void setPointsLoose(Byte pointsLoose)
	{
		this.pointsLoose = pointsLoose;
	}

	public void setPointsWin(Byte pointsWin)
	{
		this.pointsWin = pointsWin;
	}

	public void setScoreMode(Byte scoreMode)
	{
		this.scoreMode = scoreMode;
	}

	public void setSeoName(String seoName)
	{
		this.seoName = seoName;
	}

	public boolean equals(Object obj)
	{
		return (this == obj || (obj != null && (obj instanceof Sport) && ((Sport) obj).id == this.id));
	}

}
