package com.kirolak.jsf.beans;

import java.util.List;

import javax.faces.event.ActionEvent;

import com.kirolak.Competition;
import com.kirolak.Group;
import com.kirolak.KirolakObject;
import com.kirolak.Sport;
import com.kirolak.Stage;
import com.kirolak.Team;
import com.kirolak.dao.CompetitionDAO;
import com.kirolak.dao.GroupDAO;
import com.kirolak.dao.SportDAO;
import com.kirolak.dao.StageDAO;
import com.kirolak.dao.TeamDAO;
import com.kirolak.util.FacesUtil;
import com.kirolak.util.Messages;

public class GroupBean extends KirolakSession
{
	public String getTitle()
	{
		if (this.item.getIntId() > -1)
		{
			return this.item.getName();
		} else
		{
			return Messages.getString("messages", "new_group");
		}
	}

	public void load(ActionEvent event)
	{
		this.setParent(StageDAO.get(Integer.parseInt("" + FacesUtil.getRequestParameter("parent"))));
		this.items = null;
	}

	public List<KirolakObject> getItems()
	{
		if (this.items == null)
		{
			this.items = GroupDAO.listByStage((Stage) this.parent);
		}
		return this.items;
	}

	public String newItem()
	{
		this.item = new Group();
		((Group)this.item).setStage((Stage)this.parent);
		return "edit";
	}

	@Override
	public void setParent(KirolakObject parent)
	{
		this.parent = parent;
		if(this.item != null)
		{
			((Group) this.item).setStage((Stage)this.parent);
		}
	}
}
