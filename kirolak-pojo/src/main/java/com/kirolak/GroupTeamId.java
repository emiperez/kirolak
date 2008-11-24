package com.kirolak;

// Generated 30-nov-2007 8:26:55 by Hibernate Tools 3.2.0.CR1

/**
 * GroupTeamId generated by hbm2java
 */
public class GroupTeamId implements java.io.Serializable
{

	private int groupId;
	private int teamId;

	public GroupTeamId()
	{
	}

	public GroupTeamId(int groupId, int teamId)
	{
		this.groupId = groupId;
		this.teamId = teamId;
	}

	public int getGroupId()
	{
		return this.groupId;
	}

	public void setGroupId(int groupId)
	{
		this.groupId = groupId;
	}

	public int getTeamId()
	{
		return this.teamId;
	}

	public void setTeamId(int teamId)
	{
		this.teamId = teamId;
	}

	public boolean equals(Object other)
	{
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof GroupTeamId))
			return false;
		GroupTeamId castOther = (GroupTeamId) other;

		return (this.getGroupId() == castOther.getGroupId()) && (this.getTeamId() == castOther.getTeamId());
	}

	public int hashCode()
	{
		int result = 17;

		result = 37 * result + this.getGroupId();
		result = 37 * result + this.getTeamId();
		return result;
	}

}
