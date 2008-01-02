package com.kirolak.jsf.beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.hibernate.Session;

import com.kirolak.Competition;
import com.kirolak.KirolakObject;
import com.kirolak.SelectedTeam;
import com.kirolak.Sport;
import com.kirolak.Team;
import com.kirolak.dao.CompetitionDAO;
import com.kirolak.dao.SportDAO;
import com.kirolak.dao.TeamDAO;
import com.kirolak.util.FacesUtil;
import com.kirolak.util.HibernateUtil;
import com.kirolak.util.Messages;

public class CompetitionBean extends KirolakSession
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
			return Messages.getString("messages", "new_competition");
		}
	}

	public String load()
	{
		this.parent = SportDAO.get(Short.parseShort("" + FacesUtil.getRequestParameter("parent")));
		this.items = null;
		this.selectableTeams = null;
		this.selectedTeams = null;
		return "competitions";
	}

	public List<KirolakObject> getItems()
	{
		if (this.items == null)
		{
			this.items = CompetitionDAO.listBySport((Sport) this.parent);
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
		((Competition) this.item).setSport((Sport) parent);
	}
	
	public List<KirolakObject> getSelectableTeams()
	{
		if (this.selectableTeams == null)
		{
			this.selectableTeams = TeamDAO.listBySport(((Competition)this.item).getSport());
		}
		return this.selectableTeams;
	}
	
	public String teams()
	{
		this.item = (KirolakObject) itemData.getRowData();
		return "competition-teams";
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
			this.selectedTeams = TeamDAO.listByCompetition((Competition)this.item);
		}
		return this.selectedTeams;
	}

	public void setSelectedTeams(List<KirolakObject> selectedTeams)
	{
		this.selectedTeams = selectedTeams;
	}
	
	public String saveTeams()
	{
		Competition comp = (Competition) CompetitionDAO.get(this.item.getIntId());
		comp.getTeams().clear();
		Iterator iterator = selectedTeams.iterator();		
		while(iterator.hasNext())
		{
			comp.getTeams().add(((Team)iterator.next()));
		}
		return "competitions";
	}

}
