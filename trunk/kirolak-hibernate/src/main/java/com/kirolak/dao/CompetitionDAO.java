package com.kirolak.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.kirolak.Competition;
import com.kirolak.KirolakObject;
import com.kirolak.Sport;
import com.kirolak.Team;
import com.kirolak.util.HibernateUtil;

public class CompetitionDAO extends KirolakDAO
{
	public static KirolakObject get(int id)
	{
		return KirolakDAO.get(Competition.class, id);
	}
	
	public static List<KirolakObject> listBySport(Sport sport)
	{
		// TODO it should be done using Hibernate's Lazy Load
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<KirolakObject> items = session.createQuery("from Competition where sport_id = :id").setParameter("id", sport.getId()).list();
		return items;
	}
	
	public static List<KirolakObject> listByTeam(Team team)
	{
		List<KirolakObject> items = new ArrayList<KirolakObject>();
		
		// TODO it should be done using Hibernate's Lazy Load
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		items = session.createSQLQuery("Select competitions.* " +
				" from competitions, competition_teams " +
				" where competitions.id = competition_teams.competition_id " +
				" and team_id = :team_id").addEntity(Competition.class).setInteger("team_id", team.getId()).list();
		return items;
	}
}
