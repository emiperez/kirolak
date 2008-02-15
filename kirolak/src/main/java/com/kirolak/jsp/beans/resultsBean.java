package com.kirolak.jsp.beans;

import java.util.List;

import com.kirolak.KirolakObject;
import com.kirolak.Match;
import com.kirolak.Sport;
import com.kirolak.dao.MatchDAO;
import com.kirolak.dao.SportDAO;

public class resultsBean {
 
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
		if(this.sport_seoName != null)
		{
			if (this.item == null || this.item.getClass() != Sport.class)
			{
				this.item = SportDAO.getBySeoName(this.sport_seoName);
			}
			return MatchDAO.listLastUpdated((Sport)this.item);
		}
		return MatchDAO.listLastUpdated();
	}
	
	public void setSport(Sport sport)
	{
		this.item = sport;
	}
	
	public KirolakObject getSport()
	{
		if (this.item == null || this.item.getClass() != Sport.class)
		{
			this.item = SportDAO.getBySeoName(this.sport_seoName);
		}
		return (Sport)this.item;
	}	
	
}
