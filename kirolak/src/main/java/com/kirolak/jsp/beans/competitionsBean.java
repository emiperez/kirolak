package com.kirolak.jsp.beans;

import java.util.List;

import com.kirolak.KirolakObject;
import com.kirolak.Sport;
import com.kirolak.dao.CompetitionDAO;

public class competitionsBean {
	
		private Sport sport;

		public competitionsBean()
		{
			
		}

		public List<KirolakObject> getCompetitions()
		{
			return CompetitionDAO.listBySport(this.sport);
		}

		public Sport getSport() {
			return sport;
		}

		public void setSport(Sport sport) {
			this.sport = sport;
		}
}
