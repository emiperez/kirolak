package com.kirolak.dao;

import java.util.List;

import org.hibernate.Session;
import com.kirolak.Sport;
import com.kirolak.KirolakObject;
import com.kirolak.util.HibernateUtil;

public class TeamDAO extends KirolakDAO
{
	public static List<KirolakObject> listBySport(Sport sport)
	{
		// TODO it should be done using Hibernate's Lazy Load (Custom Session
		// Management)
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<KirolakObject> items = session.createQuery("from Team t where sport_id = :id").setParameter("id", sport.getId()).list();
		session.getTransaction().commit();
		return items;
	}

}
