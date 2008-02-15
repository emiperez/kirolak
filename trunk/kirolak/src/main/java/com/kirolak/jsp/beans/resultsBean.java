package com.kirolak.jsp.beans;

import java.util.List;

import com.kirolak.Competition;
import com.kirolak.KirolakObject;
import com.kirolak.Match;
import com.kirolak.Sport;
import com.kirolak.Stage;
import com.kirolak.dao.CompetitionDAO;
import com.kirolak.dao.MatchDAO;
import com.kirolak.dao.SportDAO;
import com.kirolak.dao.StageDAO;

public class resultsBean extends kirolakBean {
 
	private String sport_seoName = null;
	private KirolakObject item = null;
	
	public resultsBean()
	{
		
	}
	
	public void setSportSeoName(String seoName)
	{
		this.sport_seoName = seoName;
	}

	public List<Match> getLastResults()
	{
		if(this.item != null)
		{
			return MatchDAO.listLastUpdated(this.item);
		}
		else
		{
			return MatchDAO.listLastUpdated();
		}
	}
	
	public void setSport(Sport sport)
	{
		this.item = sport;
	}
	
	public void setSport(String seoName)
	{
		this.item = SportDAO.getBySeoName(this.sport_seoName);
	}
	
	public KirolakObject getSport()
	{
		if (this.item == null || this.item.getClass() != Sport.class)
		{
			this.item = SportDAO.getBySeoName(this.sport_seoName);
		}
		return (Sport)this.item;
	}
	
	public KirolakObject getCompetition()
	{
		if (this.item == null || this.item.getClass() != Competition.class)
		{
			this.item = CompetitionDAO.get(this.id);
		}
		return (Competition)this.item;
	}
	
	public KirolakObject getStage()
	{
		if (this.item == null || this.item.getClass() != Stage.class)
		{
			this.item = StageDAO.get(this.id);
		}
		return (Stage)this.item;
	}
	
}
