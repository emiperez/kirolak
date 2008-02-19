package com.kirolak.dao;

import java.util.List;

import org.hibernate.Session;
import com.kirolak.KirolakObject;
import com.kirolak.StageType;
import com.kirolak.util.HibernateUtil;

public class StageTypeDAO extends KirolakDAO
{

	public static KirolakObject get(short id)
	{
		return KirolakDAO.get(StageType.class, id);
	}

	public static List<KirolakObject> list()
	{
		// TODO it should be done using Hibernate's Lazy Load
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<KirolakObject> items = session.createQuery("from StageType").list();
		return items;
	}

}
