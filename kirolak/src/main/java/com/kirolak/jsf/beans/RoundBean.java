package com.kirolak.jsf.beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import com.kirolak.Competition;
import com.kirolak.Group;
import com.kirolak.KirolakObject;
import com.kirolak.Match;
import com.kirolak.Round;
import com.kirolak.Stage;
import com.kirolak.Team;
import com.kirolak.dao.GroupDAO;
import com.kirolak.dao.KirolakDAO;
import com.kirolak.dao.MatchDAO;
import com.kirolak.dao.RoundDAO;
import com.kirolak.dao.StageDAO;
import com.kirolak.dao.TeamDAO;
import com.kirolak.util.FacesUtil;
import com.kirolak.util.Messages;

public class RoundBean extends KirolakSession
{

	@Override
	public String saveItem()
	{
		RoundDAO.save(this.item);
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

	public List<SelectItem> getSelectableTeams()
	{
		List<SelectItem> selectableTeams = new ArrayList<SelectItem>();
		List<KirolakObject> teams = TeamDAO.listByGroup((Group) this.parent);
		Iterator<KirolakObject> iterator = teams.iterator();
		while (iterator.hasNext())
		{
			Team team = (Team) iterator.next();
			selectableTeams.add(new SelectItem((team), team.getName()));
		}
		return selectableTeams;
	}

	public List<Match> getMatches()
	{
		List<Match> matches = MatchDAO.listByRound((Round) this.item);
		if (matches.isEmpty())
		{
			for (int n = 0; n < this.getSelectableTeams().size() / 2; n++)
			{
				matches.add(new Match());
			}
		}
		this.setMatches(matches);
		return matches;
	}

	public void setMatches(List<Match> matches)
	{
		((Round) this.item).setMatches(matches);
	}

}
