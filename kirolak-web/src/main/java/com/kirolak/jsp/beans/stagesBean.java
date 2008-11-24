package com.kirolak.jsp.beans;

import java.util.List;

import com.kirolak.Competition;
import com.kirolak.KirolakObject;
import com.kirolak.dao.StageDAO;

public class stagesBean {
	
		private Competition competition;

		public stagesBean()
		{
			
		}

		public List<KirolakObject> getStages()
		{
			return StageDAO.listByCompetition(this.competition);
		}

		public Competition getCompetition() {
			return competition;
		}

		public void setCompetition(Competition competition) {
			this.competition = competition;
		}

}
