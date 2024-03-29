package com.kirolak;

// Generated 30-nov-2007 8:26:55 by Hibernate Tools 3.2.0.CR1

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Round generated by hbm2java
 */
public class Round extends KirolakObject
{
	private RoundId compositeId;
	private Date day;
	private List<Match> matches;

	public Round()
	{
		this.compositeId = new RoundId();
	}
	
	public Round(RoundId compositeId)
	{
		this.compositeId = compositeId;
	}

	public Round(RoundId compositeId, Date day)
	{
		this.compositeId = compositeId;
		this.day = day;
	}
	
	public short getNumber()
	{
		return this.compositeId.getId();
	}

	public void setNumber(short number)
	{
		this.compositeId.setId(number);
	}

	public RoundId getCompositeId()
	{
		return this.compositeId;
	}

	public void setCompositeId(RoundId compositeId)
	{
		this.compositeId = compositeId;
	}

	public Date getDay()
	{
		return this.day;
	}

	public void setDay(Date day)
	{
		this.day = day;
	}

	public Group getGroup()
	{
		return this.compositeId.getGroup();
	}

	public void setGroup(Group group)
	{
		this.compositeId.setGroup(group);
	}

	@Override
	public String getName()
	{
		String name = "" + this.getNumber();
		if (this.day != null)
		{
			name += " - " + DateFormat.getDateInstance().format(this.day);
		}
		return name;
	}

	public List<Match> getMatches()
	{
		return matches;
	}

	public void setMatches(List<Match> matches)
	{
		this.matches = matches;
	}
	
	public void addMatch(Match match)
	{
		if(this.matches == null)
		{
			this.matches = new ArrayList<Match>();
		}
		this.matches.add(match);
	}
			

}
