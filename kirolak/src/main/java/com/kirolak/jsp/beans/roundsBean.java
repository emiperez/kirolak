package com.kirolak.jsp.beans;

import java.util.List;

import com.kirolak.*;
import com.kirolak.dao.CompetitionDAO;
import com.kirolak.dao.GroupDAO;
import com.kirolak.dao.RoundDAO;
import com.kirolak.dao.SportDAO;
import com.kirolak.dao.StageDAO;

public class roundsBean extends KirolakBean {
	
		private Group group;
		private Round currentRound;

		public roundsBean()
		{
			
		}

		public List<KirolakObject> getRounds()
		{
			return RoundDAO.listByGroup(this.group);
		}

		public Group getGroup() {
			if(this.group == null)
			{
				this.group = (Group)GroupDAO.get(id);
			}
			return this.group;
		}

		public void setGroup(Group group) {
			this.group = group;
		}
		
		public Round getCurrentRound()
		{
			if(this.currentRound == null)
			{
				this.currentRound = RoundDAO.currentRound(group);
			}
			return this.currentRound;			
		}
}
