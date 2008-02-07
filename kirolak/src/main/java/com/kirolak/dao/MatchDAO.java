package com.kirolak.dao;

import java.util.List;

import org.hibernate.Session;

import com.kirolak.Group;
import com.kirolak.KirolakObject;
import com.kirolak.Match;
import com.kirolak.Round;
import com.kirolak.Sport;
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
	
	public static List<Match> listLastUpdated()
	{
		// TODO it should be done using Hibernate's Lazy Load
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<Match> items = session.createQuery("from Match m where m.matchStatus = 30 order by m.updated desc").setMaxResults(MAX_ROWS).list();
		return items;
	}
	
	public static List<Match> listLastUpdated(Sport sport)
	{
		// TODO it should be done using Hibernate's Lazy Load
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<Match> items = session.createQuery("from Match m  where m.round.group.stage.competition.sport = :sport order by m.updated desc").setParameter("sport", sport).setMaxResults(MAX_ROWS).list();
		return items;
	}
}
