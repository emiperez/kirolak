package com.kirolak;

import java.lang.reflect.Constructor;

public abstract class KirolakObject implements java.io.Serializable
{
	protected KirolakObject parent;
	protected int id;
	protected String name;
	protected String seoName;

	public static final String SPORT = "Sport";
	public static final String TEAM = "Team";
	
	public static KirolakObject newInstance(String className)
	{
		KirolakObject retobj = null;
		try
		{
			Class cls = Class.forName("com.kirolak."+className);
			Class partypes[] = new Class[0];
			Constructor ct = cls.getConstructor(partypes);
			Object arglist[] = new Object[0];
			retobj = (KirolakObject)ct.newInstance(arglist);
		} catch (Throwable e)
		{
			// TODO: Manage Exception
		}
		return retobj;
	}

	public int getIntId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return this.name;
	}

	public String getSeoName()
	{
		return this.seoName;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setSeoName(String seoName)
	{
		this.seoName = seoName;
	}	


}
