package com.kirolak.beans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.component.UIData;

import com.kirolak.Sport;
import com.kirolak.Team;
import com.sun.faces.util.MessageFactory;

public class TeamBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Team team = new Team();
	private UIData teamData;

	public UIData getTeamData()
	{
		return teamData;
	}

	public String getTitle()
	{
		if (this.team.getId() > -1)
		{
			return this.team.getName();
		} else
		{
			return MessageFactory.getMessage("new_team").getDetail();
		}
	}

	public void setTeamData(UIData teamData)
	{
		this.teamData = teamData;
	}

	public int getId()
	{
		return this.team.getId();
	}

	public void setId(int id)
	{
		this.team.setId(id);
	}

	public String getName()
	{
		return this.team.getName();
	}

	public void setName(String name)
	{
		this.team.setName(name);
	}

	public String getSeoName()
	{
		return this.team.getSeoName();
	}

	public void setSeoName(String seoName)
	{
		this.team.setSeoName(seoName);
	}

	public Sport getSport()
	{
		return this.team.getSport();
	}

	public void setSport(Sport sport)
	{
		this.team.setSport(sport);
	}

	public String newTeam()
	{
		this.team = new Team();
		return "team";
	}

	public String edit()
	{
		this.team = (Team) teamData.getRowData();
		return "edit";
	}

	public String save()
	{
		this.team.save();
		return "saved";
	}
	
	public String delete()
	{
		this.team.save();
		return "saved";
	}
	
}
