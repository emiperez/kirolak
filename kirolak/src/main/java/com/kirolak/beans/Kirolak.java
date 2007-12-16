package com.kirolak.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.hibernate.Session;

import com.kirolak.ScoreMode;
import com.kirolak.Sport;
import com.kirolak.util.HibernateUtil;

public class Kirolak implements Observer, Serializable
{

	private static final long serialVersionUID = 1L;
	private List<Sport> sports;
	private List<ScoreMode> scoreModes;
	private List<SelectItem> scoreModesSelectItems;
	private List<SelectItem> sportsSelectItems;

	public List<ScoreMode> getScoreModes()
	{		
		if (this.scoreModes == null)
		{
			this.scoreModes = ScoreMode.getAll();
		}		
		return this.scoreModes;
	}
	
	public List<SelectItem> getScoreModesSelectItems()
	{
		
		if (this.scoreModes == null)
		{
			getScoreModes();
		}
		if (this.scoreModesSelectItems == null)
		{
			this.scoreModesSelectItems = new ArrayList<SelectItem>();
			Iterator<ScoreMode> scoreModesIterator = scoreModes.iterator();
			while(scoreModesIterator.hasNext())
			{
				ScoreMode scoreMode = scoreModesIterator.next();
				this.scoreModesSelectItems.add(new SelectItem(scoreMode.getId(),scoreMode.getName()));			
			}
		}
		return this.scoreModesSelectItems;
	}

	public List<Sport> getSports()
	{
		if (this.sports == null)
		{
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			this.sports = session.createQuery("from Sport s").list();
			session.getTransaction().commit();
		}
		return this.sports;
	}
	
	public List<SelectItem> getSportsSelectItems()
	{
		
		if (this.sports == null)
		{
			getSports();
		}
		if (this.sportsSelectItems == null)
		{
			this.sportsSelectItems = new ArrayList<SelectItem>();
			Iterator<Sport> sportsIterator = sports.iterator();
			while(sportsIterator.hasNext())
			{
				Sport sport = sportsIterator.next();
				this.sportsSelectItems.add(new SelectItem(sport,sport.getName()));			
			}
		}
		return this.sportsSelectItems;
	}
	
	public Iterator<Locale> getSupportedLocales()
	{
		return FacesContext.getCurrentInstance().getApplication().getSupportedLocales();
	}

	public void update(Observable o, Object arg)
	{
		this.sports = null;
	}

}
