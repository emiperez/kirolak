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
		// TODO it should be done using Hibernate's Lazy Load 
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<KirolakObject> items = session.createQuery("from Team t where sport_id = :id").setParameter("id", sport.getId()).list();
		return items;
	}

}
