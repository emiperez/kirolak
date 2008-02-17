package com.kirolak.jsp.beans;

import java.util.List;

import com.kirolak.*;
import com.kirolak.dao.CompetitionDAO;
import com.kirolak.dao.GroupDAO;
import com.kirolak.dao.RoundDAO;
import com.kirolak.dao.SportDAO;
import com.kirolak.dao.StageDAO;

public class roundsBean {
	
		private Group group;

		public roundsBean()
		{
			
		}

		public List<KirolakObject> getRounds()
		{
			return RoundDAO.listByGroup(this.group);
		}

		public Group getGroup() {
			return this.group;
		}

		public void setGroup(Group group) {
			this.group = group;
		}

}
