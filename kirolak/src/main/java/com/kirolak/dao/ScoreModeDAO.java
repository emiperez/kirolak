package com.kirolak.dao;

import java.util.List;
import java.util.Locale;

import org.hibernate.Session;

import com.kirolak.ScoreMode;
import com.kirolak.util.HibernateUtil;

public class ScoreModeDAO
{

	public static ScoreMode get(short id)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		ScoreMode returnValue = (ScoreMode) session.get(ScoreMode.class, id);
		return returnValue;
	}

	public static List<ScoreMode> list(Locale locale)
	{
		// TODO it should be done using Hibernate's Lazy Load
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<ScoreMode> items = session.createQuery("from ScoreMode sm where sm.compositeId.locale = :locale").setParameter("locale", locale.getLanguage()).list();
		return items;
	}

}
