package com.kirolak.beans;

import java.util.List;

import javax.faces.event.ActionEvent;

import com.kirolak.Competition;
import com.kirolak.KirolakObject;
import com.kirolak.Sport;
import com.kirolak.Stage;
import com.kirolak.Team;
import com.kirolak.dao.CompetitionDAO;
import com.kirolak.dao.SportDAO;
import com.kirolak.dao.StageDAO;
import com.kirolak.dao.TeamDAO;
import com.kirolak.util.FacesUtil;
import com.kirolak.util.Messages;

public class StageBean extends KirolakSession
{
	public String getTitle()
	{
		if (this.item.getIntId() > -1)
		{
			return this.item.getName();
		} else
		{
			return Messages.getString("messages", "new_stage");
		}
	}

	public void load(ActionEvent event)
	{
		this.setParent(CompetitionDAO.get(Integer.parseInt("" + FacesUtil.getRequestParameter("parent"))));
		this.items = null;
	}

	public List<KirolakObject> getItems()
	{
		if (this.items == null)
		{
			this.items = StageDAO.listByCompetition((Competition) this.parent);
		}
		return this.items;
	}

	public String newItem()
	{
		this.item = new Stage();
		((Stage)this.item).setCompetition((Competition)this.parent);
		return "edit";
	}

	@Override
	public void setParent(KirolakObject parent)
	{
		this.parent = parent;
		if(this.item != null)
		{
			((Stage) this.item).setCompetition((Competition)this.parent);
		}
	}
}
