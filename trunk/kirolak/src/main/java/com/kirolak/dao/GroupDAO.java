package com.kirolak.dao;

import java.util.List;

import org.hibernate.Session;

import com.kirolak.Competition;
import com.kirolak.Group;
import com.kirolak.KirolakObject;
import com.kirolak.Stage;
import com.kirolak.util.HibernateUtil;

public class GroupDAO extends KirolakDAO
{
	
	public static KirolakObject get(int id)
	{
		return KirolakDAO.get(Group.class, id);
	}
	
	public static List<KirolakObject> listByStage(Stage stage)
	{
		// TODO it should be done using Hibernate's Lazy Load (Custom Session
		// Management)
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<KirolakObject> items = session.createQuery("from Group where stage_id = :id").setParameter("id", stage.getId()).list();
		return items;
	}
}
