package com.kirolak;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.kirolak.dao.GroupDAO;
import com.kirolak.dao.RoundDAO;
import com.kirolak.dao.TeamDAO;

// Generated 30-nov-2007 8:26:55 by Hibernate Tools 3.2.0.CR1

/**
 * Stage generated by hbm2java
 */
public class Stage extends KirolakObject
{

	private Competition competition;
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
	
	public void calculateGroups(int groupNumber)
	{
		List<KirolakObject> selectableTeams = TeamDAO.listByCompetition(this.competition);
		int totalTeams = selectableTeams.size();
		int teamsPerGroup = totalTeams/groupNumber;
		int extraTeams = totalTeams%groupNumber;
		for (char n = 0; n < groupNumber; n++)
		{
			Group group = new Group();
			group.setStage(this);
			group.setName(new Character((char)(n+65)).toString());
			GroupDAO.save(group);
		}
		List<KirolakObject> groups = GroupDAO.listByStage(this);
		for (int n =0; n < groups.size(); n++)
		{
			Group group = (Group)groups.get(n);
			int teamsInCurrentGroup = teamsPerGroup;
			if(n < extraTeams)
			{
				teamsInCurrentGroup++;
			}
			for(int i=0; i<teamsInCurrentGroup; i++)
			{
				int teamNumber = (new Random()).nextInt(totalTeams);
				Team currentTeam = (Team)selectableTeams.get(teamNumber);
				selectableTeams.remove(teamNumber);
				--totalTeams;
				group.getTeams().add(currentTeam);
			}
		}
	}

}
