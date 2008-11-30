package com.kirolak.jsf.beans;

import java.util.List;

import com.kirolak.Competition;
import com.kirolak.KirolakObject;
import com.kirolak.Stage;
import com.kirolak.dao.CompetitionDAO;
import com.kirolak.dao.StageDAO;
import com.kirolak.jsf.util.FacesUtil;
import com.kirolak.jsf.util.Messages;

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

	public String load()
	{
		this.setParent(CompetitionDAO.get(Integer.parseInt("" + FacesUtil.getRequestParameter("parent"))));
		this.items = null;
		return "stages";
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
		Stage stage = new Stage();
		//TODO: Resolve why hibernate throws a Lazy Load Exception when accessing directly to parent.getSport()
		Competition comp = (Competition)CompetitionDAO.get(this.parent.getIntId());
		stage.setCompetition(comp);
		stage.setStartDate(comp.getStartDate());
		stage.setFinishDate(comp.getFinishDate());
		stage.setMaxParts(comp.getSport().getMaxParts());
		stage.setPlayOffName(comp.getSport().getPlayOffName());
		stage.setPointsWin(comp.getSport().getPointsWin());
		stage.setPointsDraw(comp.getSport().getPointsDraw());
		stage.setPointsLoose(comp.getSport().getPointsLoose());
		this.item = stage;
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
