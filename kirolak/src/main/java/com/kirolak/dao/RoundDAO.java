package com.kirolak.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import com.kirolak.Group;
import com.kirolak.KirolakObject;
import com.kirolak.Match;
import com.kirolak.Round;
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
	
	public static KirolakObject get(int id)
	{
		return KirolakDAO.get(Round.class, id);
	}
	
	public static List<KirolakObject> listByGroup(Group group)
	{
		// TODO it should be done using Hibernate's Lazy Load
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<KirolakObject> items = session.createQuery("from Round r where r.compositeId.group = :group").setParameter("group", group).list();
		return items;
	}
}
