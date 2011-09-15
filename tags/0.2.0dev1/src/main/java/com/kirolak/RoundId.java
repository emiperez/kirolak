package com.kirolak;

// Generated 30-nov-2007 8:26:55 by Hibernate Tools 3.2.0.CR1

/**
 * RoundId generated by hbm2java
 */
public class RoundId implements java.io.Serializable
{

	private short id;
	private Group group;

	public RoundId()
	{
	}

	public RoundId(short id, Group group)
	{
		this.id = id;
		this.group = group;
	}

	public short getId()
	{
		return this.id;
	}

	public void setId(short id)
	{
		this.id = id;
	}

	public boolean equals(Object other)
	{
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RoundId))
			return false;
		RoundId castOther = (RoundId) other;

		return (this.getId() == castOther.getId()) && (this.group.id == castOther.getGroup().getId());
	}

	public int hashCode()
	{
		int result = 17;

		result = 37 * result + this.getId();
		result = 37 * result + this.getGroup().getId();
		return result;
	}

	public Group getGroup()
	{
		return group;
	}

	public void setGroup(Group group)
	{
		this.group = group;
	}

}