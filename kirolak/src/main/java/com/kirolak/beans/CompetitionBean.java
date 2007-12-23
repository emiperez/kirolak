package com.kirolak.beans;

import java.util.List;

import javax.faces.event.ActionEvent;

import com.kirolak.Competition;
import com.kirolak.KirolakObject;
import com.kirolak.Sport;
import com.kirolak.Team;
import com.kirolak.dao.CompetitionDAO;
import com.kirolak.dao.SportDAO;
import com.kirolak.util.FacesUtil;
import com.kirolak.util.Messages;

public class CompetitionBean extends KirolakSession
{
	public String getTitle()
	{
		if (this.item.getIntId() > -1)
		{
			return this.item.getName();
		} else
		{
			return Messages.getString("messages", "new_competition");
		}
	}
	
	public void load(ActionEvent event)
	{
		this.parent = SportDAO.get(Short.parseShort(""+FacesUtil.getRequestParameter("parent")));
		this.items = null;
	}
	
	public List<KirolakObject> getItems()
	{
		if(this.items==null)
		{
			this.items = CompetitionDAO.listBySport((Sport)this.parent);
		}
		return this.items;
	}

	public String newItem()
	{
		this.item = new Competition();
		return "edit";
	}
	
	@Override
	public void setParent(KirolakObject parent)
	{
		this.parent = parent;
		((Competition)this.item).setSport((Sport)parent);
	}
}
