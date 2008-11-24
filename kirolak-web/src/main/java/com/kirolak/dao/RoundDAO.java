package com.kirolak.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import com.kirolak.Group;
import com.kirolak.KirolakObject;
import com.kirolak.Match;
import com.kirolak.Round;
import com.kirolak.RoundId;
import com.kirolak.util.HibernateUtil;

public class RoundDAO extends KirolakDAO
{
	
	public static void saveRound(Round round)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.saveOrUpdate(round);
		if(round.getMatches()!=null)
		{
			Iterator<Match> iterator = round.getMatches().iterator();
			while(iterator.hasNext())
			{
				Match match = (Match)iterator.next();				
				match.setRound(round);
				session.saveOrUpdate(match);
			}
		}
	}
	
	public static Round get(RoundId id)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Round returnValue = (Round)session.get(Round.class, id);
		return returnValue;
	}
	
	public static List<KirolakObject> listByGroup(Group group)
	{
		// TODO it should be done using Hibernate's Lazy Load
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<KirolakObject> items = session.createQuery("from Round r where r.compositeId.group = :group").setParameter("group", group).list();
		return items;
	}
	
	public static Round currentRound(Group group)
	{
		// Select the last Round where there is at least one match finished
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Round round = (Round)session.createSQLQuery("{call get_current_round(:group_id)}").addEntity(Round.class).setParameter("group_id", group.getId()).uniqueResult();		
		return round;
	}
}
