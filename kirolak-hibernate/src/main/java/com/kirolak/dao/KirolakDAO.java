package com.kirolak.dao;

import java.util.Observable;

import org.hibernate.Session;

import com.kirolak.KirolakObject;
import com.kirolak.generators.KirolakObservable;
import com.kirolak.generators.TestObserver;
import com.kirolak.util.HibernateUtil;

public abstract class KirolakDAO
{
	public static final int MAX_ROWS = 10;
	

	public static void save(Object obj)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.saveOrUpdate(obj);
		new KirolakObservable((KirolakObject)obj);
	}

	public static void delete(Object obj)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.delete(obj);
	}

	public static KirolakObject get(Class itemClass, Integer id)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		KirolakObject returnValue = (KirolakObject) session.get(itemClass, id);
		return returnValue;
	}

	public static KirolakObject get(Class itemClass, Short id)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		KirolakObject returnValue = (KirolakObject) session.get(itemClass, id);
		return returnValue;
	}
}
