package com.kirolak.jsf.beans;

import java.util.List;

import javax.faces.event.ActionEvent;

import com.kirolak.Competition;
import com.kirolak.Group;
import com.kirolak.KirolakObject;
import com.kirolak.Round;
import com.kirolak.Stage;
import com.kirolak.dao.GroupDAO;
import com.kirolak.dao.RoundDAO;
import com.kirolak.dao.StageDAO;
import com.kirolak.util.FacesUtil;
import com.kirolak.util.Messages;

public class RoundBean extends KirolakSession
{
	
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
			this.items = RoundDAO.listByGroup((Group)this.parent);
		}
		return this.items;
	}

	public String newItem()
	{
		this.item = new Round();
		((Round)this.item).setGroup((Group)this.parent);
		return "edit";
	}

	@Override
	public void setParent(KirolakObject parent)
	{
		this.parent = parent;
		if(this.item != null)
		{
			((Round) this.item).setGroup((Group) parent);
		}
	}
	
	public void load(ActionEvent event)
	{
		this.setParent(GroupDAO.get(Integer.parseInt("" + FacesUtil.getRequestParameter("parent"))));
		this.items = null;
	}
	
}
