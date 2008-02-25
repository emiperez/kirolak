package com.kirolak.jsp.beans;

import java.util.List;

import com.kirolak.KirolakObject;
import com.kirolak.Stage;
import com.kirolak.dao.GroupDAO;

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
