package com.kirolak.jsf.beans;

import java.util.List;

import com.kirolak.KirolakObject;
import com.kirolak.Sport;
import com.kirolak.dao.SportDAO;
import com.kirolak.util.Messages;

public class SportBean extends KirolakSession
{
	public String getTitle()
	{
		if (this.item.getIntId() > -1)
		{
			return this.item.getName();
		} else
		{
			return Messages.getString("messages", "new_sport");
		}
	}

	public List<KirolakObject> getItems()
	{
		if (this.items == null)
		{
			this.items = SportDAO.list();
		}
		return this.items;
	}

	public String newItem()
	{
		this.item = new Sport();
		return "edit";
	}
	
	public String load()
	{
		this.items = SportDAO.list();
		return "sports";
	}

}
