package com.kirolak.jsp.beans;

import java.util.List;

import com.kirolak.Match;
import com.kirolak.dao.MatchDAO;
import com.kirolak.dao.SportDAO;

public class resultsBean {
 
	private String sport_seoName = null;
	
	public resultsBean()
	{
		
	}
	
	public void setSport(String seoName)
	{
		this.sport_seoName = seoName;
	}

	public List<Match> getLastResults()
	{
		if(this.sport_seoName != null)
		{
			return MatchDAO.listLastUpdated(SportDAO.getBySeoName(this.sport_seoName));
		}
		return MatchDAO.listLastUpdated();
	}
}
