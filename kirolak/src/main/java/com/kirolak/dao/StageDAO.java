package com.kirolak.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.kirolak.Competition;
import com.kirolak.CompetitionTeam;
import com.kirolak.Sport;
import com.kirolak.KirolakObject;
import com.kirolak.util.HibernateUtil;

public class StageDAO extends KirolakDAO
{
	public static List<KirolakObject> listByCompetition(Competition competition)
	{
		// TODO it should be done using Hibernate's Lazy Load (Custom Session
		// Management)
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<KirolakObject> items = session.createQuery("from Stage where competition_id = :id").setParameter("id", competition.getId()).list();
		return items;
	}
}
