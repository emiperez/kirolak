package com.kirolak.jsp.beans;

import java.util.List;

import com.kirolak.*;
import com.kirolak.dao.SportDAO;

public class sportsBean {

		public sportsBean()
		{
			
		}

		public List<KirolakObject> getSports()
		{
			return SportDAO.list();
		}
}
