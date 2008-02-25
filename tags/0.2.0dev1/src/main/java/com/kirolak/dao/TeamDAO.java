package com.kirolak.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.kirolak.Competition;
import com.kirolak.Group;
import com.kirolak.KirolakObject;
import com.kirolak.Sport;
import com.kirolak.Team;
import com.kirolak.util.HibernateUtil;

public class TeamDAO extends KirolakDAO
{
	
	public static KirolakObject get(int id)
	{
		return KirolakDAO.get(Team.class, id);
	}

	public static List<KirolakObject> listBySport(Sport sport)
	{
		// TODO it should be done using Hibernate's Lazy Load
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<KirolakObject> items = session.createQuery("from Team where sport_id = :id order by name").setParameter("id", sport.getId()).list();
		return items;
	}

	public static List<KirolakObject> listByCompetition(Competition competition)
	{
		List<KirolakObject> items = new ArrayList<KirolakObject>();
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		items = session.createSQLQuery("Select teams.* " +
					" from teams, competition_teams " +
					" where teams.id = competition_teams.team_id " +
					" and competition_id = :competition_id order by name").addEntity(Team.class).setInteger("competition_id", competition.getId()).list();
		return items;
	}
	
	public static List<KirolakObject> listByGroup(Group group)
	{
		List<KirolakObject> items = new ArrayList<KirolakObject>();		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		items = session.createSQLQuery("Select teams.* " +
					" from teams, group_teams " +
					" where teams.id = group_teams.team_id " +
					" and group_id = :group_id order by name").addEntity(Team.class).setInteger("group_id", group.getId()).list();
		return items;
	}
}
