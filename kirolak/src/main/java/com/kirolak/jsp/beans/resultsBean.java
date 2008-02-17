package com.kirolak.jsp.beans;

import java.util.List;

import com.kirolak.Competition;
import com.kirolak.Group;
import com.kirolak.KirolakObject;
import com.kirolak.Match;
import com.kirolak.Round;
import com.kirolak.RoundId;
import com.kirolak.Sport;
import com.kirolak.Stage;
import com.kirolak.Standing;
import com.kirolak.dao.CompetitionDAO;
import com.kirolak.dao.GroupDAO;
import com.kirolak.dao.MatchDAO;
import com.kirolak.dao.RoundDAO;
import com.kirolak.dao.SportDAO;
import com.kirolak.dao.StageDAO;
import com.kirolak.dao.StandingDAO;

public class resultsBean extends KirolakBean {
 
	private String sport_seoName = null;
	private KirolakObject item = null;
	private String roundId = null;
	
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

	public Round getRound() {
		if (this.item == null || this.item.getClass() != Round.class)
		{
			this.item = RoundDAO.get(createRoundId(this.roundId));
		}
		return (Round)this.item;
	}
	
	public void setRound(Round round)
	{
		this.item = round;
	}

	public RoundId createRoundId(String roundId) {
		String[] ids = roundId.split("-");
		Group group = (Group)GroupDAO.get(Integer.parseInt(ids[0]));
		return new RoundId(Short.parseShort(ids[1]),group);
	}
	
	public String getRoundId() {
		return this.roundId;
	}

	public void setRoundId(String roundId) {
		this.roundId = roundId;
	}
	
	public List<Match> getRoundResults()
	{
		return MatchDAO.listByRound(getRound());		
	}
	
	public List<Standing> getStandings()
	{
		return StandingDAO.listByRound(getRound());		
	}
}
