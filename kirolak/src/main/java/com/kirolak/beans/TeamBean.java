package com.kirolak.beans;

import java.io.Serializable;

import javax.faces.component.UIData;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.hibernate.Session;

import com.kirolak.Sport;
import com.kirolak.Team;
import com.kirolak.util.FacesUtil;
import com.kirolak.util.HibernateUtil;
import com.sun.faces.util.MessageFactory;

public class TeamBean extends GenericBean
{
	
	private static final long serialVersionUID = 1L;
	private Team item = new Team();

	public String getTitle()
	{
		if (this.item.getId() > -1)
		{
			return this.item.getName();
		} else
		{
			return MessageFactory.getMessage("new_team").getDetail();
		}
	}

	public void newItem(ActionEvent event)
	{
		this.item = new Team();
		Short sportId = Short.parseShort(FacesUtil.getRequestParameter("sportId"));
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Sport teamSport = (Sport)session.get(Sport.class, sportId);
		session.getTransaction().commit();
		this.item.setSport(teamSport);
	}
	

	public String edit()
	{
		this.item = (Team) itemData.getRowData();
		return "edit";
	}

	public String save()
	{
		return super.save(this.item);
	}

	public String delete()
	{
		this.item = (Team) itemData.getRowData();
		return super.delete(this.item);
	}

	public Team getItem()
	{
		return item;
	}

	public void setItem(Team item)
	{
		this.item = item;
	}

}
