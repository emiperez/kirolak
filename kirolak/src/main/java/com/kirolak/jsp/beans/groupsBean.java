package com.kirolak.jsp.beans;

import java.util.List;

import com.kirolak.*;
import com.kirolak.dao.CompetitionDAO;
import com.kirolak.dao.GroupDAO;
import com.kirolak.dao.SportDAO;

public class groupsBean {
	
		private Stage stage;

		public groupsBean()
		{
			
		}

		public List<KirolakObject> getGroups()
		{
			return GroupDAO.listByStage(this.stage);
		}

		public Stage getStage() {
			return stage;
		}

		public void setStage(Stage stage) {
			this.stage = stage;
		}

}
