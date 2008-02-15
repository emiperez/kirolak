package com.kirolak.jsp.beans;

import java.util.List;

import com.kirolak.*;
import com.kirolak.dao.CompetitionDAO;
import com.kirolak.dao.SportDAO;

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
