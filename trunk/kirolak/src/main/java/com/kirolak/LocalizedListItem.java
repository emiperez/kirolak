package com.kirolak;


// Generated 30-nov-2007 8:26:55 by Hibernate Tools 3.2.0.CR1

/**
 * Used for localizable lists like stageTypes or scoreModes
 */

public class LocalizedListItem
{

	private LocalizedId compositeId;
	private String name;

	public LocalizedListItem()
	{
	}

	public LocalizedListItem(LocalizedId compositeId)
	{
		this.compositeId = compositeId;
	}

	public LocalizedListItem(LocalizedId compositeId, String name)
	{
		this.compositeId = compositeId;
		this.name = name;
	}

	public LocalizedId getCompositeId() {
		return compositeId;
	}

	public void setCompositeId(LocalizedId compositeId) {
		this.compositeId = compositeId;
	}
	
	public Byte getId()
	{
		return this.compositeId.getId();
	}

	public String getName()
    {
    	return name;
    }

	public void setName(String name)
    {
    	this.name = name;
    }
}
