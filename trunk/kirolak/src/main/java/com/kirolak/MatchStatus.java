package com.kirolak;

import java.util.List;

import org.hibernate.Session;

import com.kirolak.util.HibernateUtil;

// Generated 30-nov-2007 8:26:55 by Hibernate Tools 3.2.0.CR1

/**
 * Sport generated by hbm2java
 */
public class MatchStatus extends KirolakObject
{

	private Byte id;
	private String name;

	public MatchStatus()
	{
		this.id = -1;
	}

	public MatchStatus(Byte id)
	{
		this.id = -1;
	}

	public MatchStatus(Byte id, String name)
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
}
