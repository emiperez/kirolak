package com.kirolak;


public abstract class KirolakObject implements java.io.Serializable
{
	private Sport sport;
	private Competition competition;
	private Stage stage;
	private Group group;
	private Round round;
	
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
	
	public Sport getSport()
	{	
		if(this.sport != null)			
		{
			return this.sport;
		}
		else
		{
			if(this.getClass().equals(Sport.class))
			{
				this.sport = (Sport)this;
				return this.sport;
			}
			else
			{
				this.competition = getCompetition();
				if(this.competition != null)
				{
					this.sport = this.competition.getSport();
				}
				return this.sport;
			}
		}			
	}
	
	public Competition getCompetition()
	{
		if(this.competition != null)			
		{
			return this.competition;
		}
		else
		{
			if(this.getClass().equals(Competition.class))
			{
				this.competition = (Competition)this;
				return this.competition;
			}
			else
			{
				this.stage = getStage();
				if(this.stage != null)
				{
					this.competition = this.stage.getCompetition();
				}
				return this.competition;
			}
		}
	}
	
	public Stage getStage()
	{
		if(this.stage != null)			
		{
			return this.stage;
		}
		else
		{
			if(this.getClass().equals(Stage.class))
			{
				this.stage = (Stage)this;
				return this.stage;
			}
			else
			{
				this.group = getGroup();
				if(this.group != null)
				{
					this.stage = this.group.getStage();
				}
				return this.stage;
			}
		}
	}
	
	public Group getGroup()
	{
		if(this.group != null)			
		{
			return this.group;
		}
		else
		{
			if(this.getClass().equals(Group.class))
			{
				this.group = (Group)this;
				return this.group;
			}
			else
			{
				this.round = getRound();
				if (this.round != null)
				{
					this.group = this.round.getGroup();
				}
				return this.group;
			}
		}
	}
	
	public Round getRound()
	{
		if(this.round != null)			
		{
			return this.round;
		}
		else
		{
			if(this.getClass().equals(Round.class))
			{
				this.round = (Round)this;
				return this.round;
			}
			else
			{
				if(this.getClass().equals(Match.class))
				{
					this.round = ((Match)this).getRound();
					return this.round;
				}
				else
				{
					return null;
				}
			}
		}
	}

}
