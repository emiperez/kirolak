package com.kirolak.beans;


import com.kirolak.Team;
import com.sun.faces.util.MessageFactory;

public class TeamBean extends GenericBean
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Team item = new Team();


	public String getTitle()
	{
		if (this.item.getId() > -1)
		{
			return this.item.getName();
		} else
		{
			return MessageFactory.getMessage("new_team").getDetail();
		}
	}
	
	public Team getItem()
	{
		return item;
	}

	public void setTeam(Team item)
	{
		this.item = item;
	}


	public String newItem()
	{
		this.item = new Team();
		return "edit";
	}

	public String editItem()
	{
		this.item = (Team) itemData.getRowData();
		return "edit";
	}

	public String saveItem()
	{
		return super.save(this.item);
	}	

	public String deleteItem()
	{
		this.item = (Team) itemData.getRowData();
		return super.delete(this.item);
	}

}

