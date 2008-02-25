package com.kirolak;


// Generated 30-nov-2007 8:26:55 by Hibernate Tools 3.2.0.CR1


public class LocalizedListItem extends KirolakObject
{

	private LocalizedId compositeId;

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
}
