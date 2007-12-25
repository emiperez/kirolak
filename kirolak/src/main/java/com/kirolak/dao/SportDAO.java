package com.kirolak.dao;

import java.util.List;

import org.hibernate.Session;
import com.kirolak.KirolakObject;
import com.kirolak.Sport;
import com.kirolak.util.HibernateUtil;

public class SportDAO extends KirolakDAO
{

	public static KirolakObject get(short id)
	{
		return KirolakDAO.get(Sport.class, id);
	}

	public static List<KirolakObject> list()
	{
		// TODO it should be done using Hibernate's Lazy Load
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<KirolakObject> items = session.createQuery("from Sport").list();
		return items;
	}

}
