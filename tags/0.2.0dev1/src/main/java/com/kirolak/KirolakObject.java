package com.kirolak;


public abstract class KirolakObject implements java.io.Serializable
{
	protected KirolakObject parent;
	protected int id;
	protected String name;
	protected String seoName;

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
