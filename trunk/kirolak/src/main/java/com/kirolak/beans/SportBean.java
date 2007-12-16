package com.kirolak.beans;


import java.util.List;

import javax.faces.component.UIData;

import org.hibernate.Session;

import com.kirolak.Sport;
import com.kirolak.Team;
import com.kirolak.util.HibernateUtil;
import com.sun.faces.util.MessageFactory;

public class SportBean extends GenericBean
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Sport item = new Sport();
	private UIData itemData;
	private List<Team> teams;

	public UIData getItemData()
	{
		return itemData;
	}

	public String getTitle()
	{
		if (this.item.getId() > -1)
		{
			return this.item.getName();
		} else
		{
			return MessageFactory.getMessage("new_sport").getDetail();
		}
	}

	public void setItemData(UIData sportData)
	{
		this.itemData = sportData;
	}

	
	public Sport getItem()
	{
		return item;
	}

	public void setSport(Sport item)
	{
		this.item = item;
	}

	public List<Team> getTeams()
	{
		if(this.teams==null)
		{
			//TODO it should be done using Hibernate's Lazy Load (Custom Session Management)
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			this.teams = session.createQuery("from Team t where sport_id = :id").setParameter("id", this.item.getId()).list();
			session.getTransaction().commit();
		}
		return this.teams;
	}


	public String newItem()
	{
		this.item = new Sport();
		return "edit";
	}

	public String edit()
	{
		this.item = (Sport) itemData.getRowData();
		return "edit";
	}

	public String save()
	{
		return super.save(this.item);
	}
	
	public String goteams()
	{
		this.item = (Sport) itemData.getRowData();
		return "teams";
	}

	public String delete()
	{
		this.item = (Sport) itemData.getRowData();
		return super.delete(this.item);
	}

}
