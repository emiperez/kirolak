package com.kirolak.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.faces.component.UIData;

import org.hibernate.Session;

import util.HibernateUtil;

import com.kirolak.Sport;

public class SportBean extends Observable implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Sport sport = new Sport();
	private ArrayList<Observer> observers;
	private UIData sportData;

	public UIData getSportData()
	{
		return sportData;
	}

	public void setSportData(UIData sportData)
	{
		this.sportData = sportData;
	}

	public short getId()
	{
		return sport.getId();
	}

	public void setId(short id)
	{
		this.sport.setId(id);
	}

	public String getName()
	{
		return this.sport.getName();
	}

	public void setName(String name)
	{
		this.sport.setName(name);
	}

	public String getSeoName()
	{
		return this.sport.getSeoName();
	}

	public void setSeoName(String seoName)
	{
		this.sport.setSeoName(seoName);
	}

	public Byte getScoreMode()
	{
		return this.sport.getScoreMode();
	}

	public void setScoreMode(Byte scoreMode)
	{
		this.sport.setScoreMode(scoreMode);
	}

	public String getPartName()
	{
		return this.sport.getPartName();
	}

	public void setPartName(String partName)
	{
		this.sport.setPartName(partName);
	}

	public Byte getMaxParts()
	{
		return this.sport.getMaxParts();
	}

	public void setMaxParts(Byte maxParts)
	{
		this.setMaxParts(maxParts);
	}

	public String getPlayOffName()
	{
		return this.sport.getPlayOffName();
	}

	public void setPlayOffName(String playOffName)
	{
		this.sport.setPlayOffName(playOffName);
	}

	public Byte getPointsWin()
	{
		return this.sport.getPointsWin();
	}

	public void setPointsWin(Byte pointsWin)
	{
		this.sport.setPointsWin(pointsWin);
	}

	public Byte getPointsDraw()
	{
		return this.sport.getPointsDraw();
	}

	public void setPointsDraw(Byte pointsDraw)
	{
		this.sport.setPointsDraw(pointsDraw);
	}

	public Byte getPointsLoose()
	{
		return this.sport.getPointsLoose();
	}

	public void setPointsLoose(Byte pointsLoose)
	{
		this.sport.setPointsLoose(pointsLoose);
	}

	public String newSport()
	{
		this.sport = new Sport();
		return "edit";
	}

	public String edit()
	{
		this.sport = (Sport) sportData.getRowData();
		return "edit";
	}

	public String save()
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(this.sport);
		session.getTransaction().commit();

		// Notify to the observers
		setChanged();
		notifyObservers();

		return "saved";
	}

	public String delete()
	{
		this.sport = (Sport) sportData.getRowData();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(this.sport);
		session.getTransaction().commit();

		// Notify to the observers
		setChanged();
		notifyObservers();

		return "deleted";
	}

	/**
	 * Set the observers listed in faces-config.xml for this managed-bean
	 * 
	 * @param observers
	 */
	public void setObservers(ArrayList<Observer> observers)
	{
		for (Observer o : observers)
		{
			addObserver(o);
		}
	}
}
