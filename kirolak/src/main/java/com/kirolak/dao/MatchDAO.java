package com.kirolak.dao;

import java.util.List;

import org.hibernate.Session;

import com.kirolak.Group;
import com.kirolak.KirolakObject;
import com.kirolak.Match;
import com.kirolak.Round;
import com.kirolak.util.HibernateUtil;

public class MatchDAO extends KirolakDAO
{
	public static KirolakObject get(int id)
	{
		return KirolakDAO.get(Match.class, id);
	}
	
	public static List<Match> listByRound(Round round)
	{
		// TODO it should be done using Hibernate's Lazy Load
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<Match> items = session.createQuery("from Match m where m.round = :round").setParameter("round", round).list();
		return items;
	}
}
