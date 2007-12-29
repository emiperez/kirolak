package com.kirolak.jsf.beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

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
	private List<KirolakObject> selectableTeams;
	private List<KirolakObject> selectedTeams;
	
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
		this.selectableTeams = null;
		this.selectedTeams = null;
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
	
	public List<KirolakObject> getSelectableTeams()
	{
		if (this.selectableTeams == null)
		{
			this.selectableTeams = TeamDAO.listByCompetition(((Group)this.item).getStage().getCompetition());
		}
		return this.selectableTeams;
	}
	
	public String teams()
	{
		this.item = (KirolakObject) itemData.getRowData();
		return "group-teams";
	}

	public List<SelectItem> getSelectItemsTeams()
	{
		List<SelectItem> list = new ArrayList<SelectItem>();
		if(this.selectableTeams == null)
		{
			getSelectableTeams();
		}
		Iterator<KirolakObject> iterator = this.selectableTeams.iterator();
		while (iterator.hasNext())
		{
			KirolakObject team = iterator.next();
			list.add(new SelectItem(team,team.getName()));
		}
		return list;
	}
	
	public List<KirolakObject> getSelectedTeams()
	{
		if(this.selectedTeams == null)
		{
			this.selectedTeams = TeamDAO.listByGroup((Group)this.item);
		}
		return this.selectedTeams;
	}

	public void setSelectedTeams(List<KirolakObject> selectedTeams)
	{
		this.selectedTeams = selectedTeams;
	}
	
	public String saveTeams()
	{
		Group group = (Group) GroupDAO.get(this.item.getIntId());
		group.getTeams().clear();
		Iterator iterator = this.selectedTeams.iterator();		
		while(iterator.hasNext())
		{
			group.getTeams().add(((Team)iterator.next()));
		}
		return "groups";
	}
}
