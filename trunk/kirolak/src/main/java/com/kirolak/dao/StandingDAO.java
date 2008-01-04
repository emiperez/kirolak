package com.kirolak.dao;

import java.util.List;

import org.hibernate.Session;

import com.kirolak.Group;
import com.kirolak.KirolakObject;
import com.kirolak.Match;
import com.kirolak.Round;
import com.kirolak.Standing;
import com.kirolak.util.HibernateUtil;

public class StandingDAO extends KirolakDAO
{
	public static KirolakObject get(int id)
	{
		return KirolakDAO.get(Standing.class, id);
	}
	
	public static List<Standing> listByRound(Round round)
	{
		// TODO it should be done using Hibernate's Lazy Load
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<Standing> items = session.createQuery("from Standing s where s.id.round = :round").setParameter("round", round).list();
		return items;
	}
}
