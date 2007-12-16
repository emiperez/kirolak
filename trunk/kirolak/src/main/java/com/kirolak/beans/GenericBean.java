package com.kirolak.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.faces.component.UIData;

import org.hibernate.Session;

import com.kirolak.Sport;
import com.kirolak.util.HibernateUtil;

public class GenericBean extends Observable implements Serializable
{
	protected UIData itemData;
	
	public String save(Object obj)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(obj);
		session.getTransaction().commit();
		// Notify to the observers
		setChanged();
		notifyObservers();
		return "saved";
	}
	
	public String delete(Object obj)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(obj);
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

	public UIData getItemData()
	{
		return itemData;
	}

	public void setItemData(UIData itemData)
	{
		this.itemData = itemData;
	}

}
