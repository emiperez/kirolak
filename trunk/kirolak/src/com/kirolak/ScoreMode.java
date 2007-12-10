package com.kirolak;

import java.util.List;

import org.hibernate.Session;

import com.kirolak.util.HibernateUtil;

// Generated 30-nov-2007 8:26:55 by Hibernate Tools 3.2.0.CR1

/**
 * Sport generated by hbm2java
 */
public class ScoreMode implements java.io.Serializable
{

	private Byte id;
	private String name;

	public ScoreMode()
	{
		this.id = -1;
	}

	public ScoreMode(Byte id)
	{
		this.id = -1;
	}

	public ScoreMode(Byte id, String name)
	{
		this.id = id;
		this.name = name;
	}

	public Byte getId()
	{
		return this.id;
	}
	
	public void setId(Byte id)
	{
		this.id = id;
	}

	public String getName()
	{
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}

	
	public static List<ScoreMode> getAll()
	{
		List<ScoreMode> sports;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		sports = session.createQuery("from ScoreMode").list();
		session.getTransaction().commit();
		return sports;	
	}
	


}
