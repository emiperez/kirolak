package com.kirolak.jsf.beans;

import java.util.List;

import com.kirolak.KirolakObject;
import com.kirolak.Sport;
import com.kirolak.Team;
import com.kirolak.dao.SportDAO;
import com.kirolak.dao.TeamDAO;
import com.kirolak.jsf.util.FacesUtil;
import com.kirolak.jsf.util.Messages;

public class TeamBean extends KirolakSession
{
	public String getTitle()
	{
		if (this.item.getIntId() > -1)
		{
			return this.item.getName();
		} else
		{
			return Messages.getString("messages", "new_team");
		}
	}

	public String load()
	{
		this.parent = SportDAO.get(Short.parseShort("" + FacesUtil.getRequestParameter("parent")));
		this.items = null;
		return "teams";
	}

	public List<KirolakObject> getItems()
	{
		if (this.items == null)
		{
			this.items = TeamDAO.listBySport((Sport) this.parent);
		}
		return this.items;
	}

	public String newItem()
	{
		this.item = new Team();
		return "edit";
	}

	@Override
	public void setParent(KirolakObject parent)
	{
		this.parent = parent;
		((Team) this.item).setSport((Sport) parent);
	}
}
