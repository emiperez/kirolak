package com.kirolak.jsf.beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import com.kirolak.Group;
import com.kirolak.KirolakObject;
import com.kirolak.Match;
import com.kirolak.Round;
import com.kirolak.Team;
import com.kirolak.dao.GroupDAO;
import com.kirolak.dao.MatchDAO;
import com.kirolak.dao.RoundDAO;
import com.kirolak.dao.TeamDAO;
import com.kirolak.util.FacesUtil;
import com.kirolak.util.Messages;

public class RoundBean extends KirolakSession
{
	private List<Match> listMatch;

	public String saveRound()
	{
		Round round = (Round)this.item;
		round.setMatches(this.listMatch);
		RoundDAO.saveRound(round);
		this.items = null;
		return "list";
	}

	public String getTitle()
	{
		if (this.item.getIntId() > -1)
		{
			return this.item.getName();
		} else
		{
			return Messages.getString("messages", "new_round");
		}
	}

	public List<KirolakObject> getItems()
	{
		if (this.items == null)
		{
			this.items = RoundDAO.listByGroup((Group) this.parent);
		}
		return this.items;
	}

	public String newItem()
	{
		this.item = new Round();
		((Round) this.item).setGroup((Group) this.parent);
		return "edit";
	}

	@Override
	public void setParent(KirolakObject parent)
	{
		this.parent = parent;
		if (this.item != null)
		{
			((Round) this.item).setGroup((Group) parent);
		}
	}

	public void load(ActionEvent event)
	{
		this.setParent(GroupDAO.get(Integer.parseInt("" + FacesUtil.getRequestParameter("parent"))));
		this.items = null;
	}
	
	public String auto()
	{
		List<Round> rounds = ((Group)this.parent).calculateSchedule();
		Iterator<Round> iterator = rounds.iterator();
		while(iterator.hasNext())
		{
			RoundDAO.saveRound(iterator.next());
		}
		this.items = null;
		return "list";
	}

	public List<SelectItem> getSelectableTeams()
	{
		List<SelectItem> selectableTeams = new ArrayList<SelectItem>();
		List<KirolakObject> teams = TeamDAO.listByGroup((Group) this.parent);
		Iterator<KirolakObject> iterator = teams.iterator();
		selectableTeams.add(new SelectItem(null, ""));
		while (iterator.hasNext())
		{
			Team team = (Team) iterator.next();
			selectableTeams.add(new SelectItem((team), team.getName()));
		}
		return selectableTeams;
	}

	public List<Match> getListMatch()
	{
		Round round = (Round) this.item;
		this.listMatch = MatchDAO.listByRound(round);
		if (this.listMatch.isEmpty())
		{
			for (int n = 0; n < this.getSelectableTeams().size() / 2; n++)
			{
				Match match = new Match();
				match.setRound(round);
				this.listMatch.add(match);
			}
		}
		return this.listMatch;
	}

	public void setListMatch(List<Match> listMatch)
	{
		this.listMatch = listMatch;
	}

	

}
