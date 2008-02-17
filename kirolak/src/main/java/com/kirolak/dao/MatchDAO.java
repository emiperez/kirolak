package com.kirolak.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.kirolak.Competition;
import com.kirolak.KirolakObject;
import com.kirolak.Match;
import com.kirolak.Round;
import com.kirolak.Sport;
import com.kirolak.Stage;
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
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<Match> items = session.createQuery("from Match m where m.matchStatus = 30 order by m.updated desc").setMaxResults(MAX_ROWS).list();
		return items;
	}
	
	public static List<Match> listLastUpdated(Sport sport)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<Match> items = session.createQuery("from Match m  where m.round.compositeId.group.stage.competition.sport = :sport and  m.matchStatus = 30 order by m.updated desc").setParameter("sport", sport).setMaxResults(MAX_ROWS).list();
		return items;
	}
	
	public static List<Match> listLastUpdated(Competition competition)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<Match> items = session.createQuery("from Match m  where m.round.compositeId.group.stage.competition = :competition and  m.matchStatus = 30 order by m.updated desc").setParameter("competition", competition).setMaxResults(MAX_ROWS).list();
		return items;
	}
	
	public static List<Match> listLastUpdated(Stage stage)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<Match> items = session.createQuery("from Match m  where m.round.compositeId.group.stage = :stage and  m.matchStatus = 30 order by m.updated desc").setParameter("stage", stage).setMaxResults(MAX_ROWS).list();
		return items;
	}
		
	public static List<Match> listLastUpdated(KirolakObject obj)
	{
		List<Match> items = new ArrayList<Match>();
		if(obj != null)
		{
			if(obj.getClass().equals(Sport.class))
			{
				return listLastUpdated((Sport)obj);
			}
			else if(obj.getClass().equals(Competition.class))
			{
				return listLastUpdated((Competition)obj);
			}
			else if(obj.getClass().equals(Stage.class))
			{
				return listLastUpdated((Stage)obj);
			}
		}
		return items;
	}
}
