package com.kirolak;

// Generated 30-nov-2007 8:26:55 by Hibernate Tools 3.2.0.CR1

/**
 * StandingId generated by hbm2java
 */
public class StandingId implements java.io.Serializable
{

	private Team team;
	private Round round;

	public StandingId()
	{
	}

	public StandingId(Team team, Round round)
	{
		this.team = team;
		this.round = round;
	}

	public Team getTeam()
	{
		return this.team;
	}

	public void setTeam(Team team)
	{
		this.team = team;
	}

	public Round getRound()
	{
		return this.round;
	}

	public void setRound(Round round)
	{
		this.round = round;
	}

	public boolean equals(Object other)
	{
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof StandingId))
			return false;
		StandingId castOther = (StandingId) other;

		return (this.getTeam().equals(castOther.getTeam()) && this.getRound().equals(castOther.getRound()));
	}

	public int hashCode()
	{
		int result = 17;

		result = 37 * result + this.getTeam().getId();
		result = 37 * result + this.getRound().getNumber();
		result = 37 * result + this.getRound().getGroup().getId();
		return result;
	}

}
