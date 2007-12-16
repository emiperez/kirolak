package com.kirolak;

import org.hibernate.Session;
import com.kirolak.util.HibernateUtil;

public class KirolakObject implements java.io.Serializable
{
	protected Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	public void delete()
	{
		session.beginTransaction();
		session.delete(this);
		session.getTransaction().commit();
	}
	
	public void save()
	{
		session.beginTransaction();
		session.saveOrUpdate(this);
		session.getTransaction().commit();
	}

}
