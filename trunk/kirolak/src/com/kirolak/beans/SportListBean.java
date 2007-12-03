package com.kirolak.beans;

import java.io.Serializable;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.faces.component.UIData;

import org.hibernate.Session;

import util.HibernateUtil;

import com.kirolak.Sport;

public class SportListBean implements Observer, Serializable
{

	private static final long serialVersionUID = 1L;
	private List<Sport> sports;


	public List<Sport> getSports()
	{
		if (this.sports == null)
		{
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			this.sports = session.createQuery("from Sport").list();
			session.getTransaction().commit();
		}
		return this.sports;
	}

	public void update(Observable o, Object arg)
	{
		this.sports = null;
	}

}
