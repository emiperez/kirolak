package com.kirolak;

// Generated 30-nov-2007 8:26:55 by Hibernate Tools 3.2.0.CR1

/**
 * RoundId generated by hbm2java
 */
public class RoundId implements java.io.Serializable
{

	private short id;
	private int groupId;

	public RoundId()
	{
	}

	public RoundId(short id, int groupId)
	{
		this.id = id;
		this.groupId = groupId;
	}

	public short getId()
	{
		return this.id;
	}

	public void setId(short id)
	{
		this.id = id;
	}

	public int getGroupId()
	{
		return this.groupId;
	}

	public void setGroupId(int groupId)
	{
		this.groupId = groupId;
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

		return (this.getId() == castOther.getId()) && (this.getGroupId() == castOther.getGroupId());
	}

	public int hashCode()
	{
		int result = 17;

		result = 37 * result + this.getId();
		result = 37 * result + this.getGroupId();
		return result;
	}

}
