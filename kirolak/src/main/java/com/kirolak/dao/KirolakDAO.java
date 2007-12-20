package com.kirolak.dao;

import org.hibernate.Session;

import com.kirolak.KirolakObject;
import com.kirolak.util.HibernateUtil;

public abstract class KirolakDAO
{
	public static KirolakDAO newIntance(String ClassName)
	{		
		return null;
	}
	
	public static void save(Object obj)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(obj);
		session.getTransaction().commit();
	}
	
	public static void delete(Object obj)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(obj);
		session.getTransaction().commit();
	}
	
	
	public static KirolakObject get(Class itemClass, Integer id)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		KirolakObject returnValue = (KirolakObject)session.get(itemClass, id);
		session.getTransaction().commit();
		return returnValue;
	}
	
	public static KirolakObject get(Class itemClass, Short id)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		KirolakObject returnValue = (KirolakObject)session.get(itemClass, id);
		session.getTransaction().commit();
		return returnValue;
	}
}
