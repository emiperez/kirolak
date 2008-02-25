package com.kirolak.dao;

import java.util.List;
import java.util.Locale;

import org.hibernate.Session;

import com.kirolak.KirolakObject;
import com.kirolak.LocalizedListItem;
import com.kirolak.util.HibernateUtil;

public class MatchStatusDAO extends KirolakDAO
{

	public static KirolakObject get(short id)
	{
		return KirolakDAO.get(LocalizedListItem.class, id);
	}

	public static List<KirolakObject> list(Locale locale)
	{
		// TODO it should be done using Hibernate's Lazy Load
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<KirolakObject> items = session.createQuery("from MatchStatus ms where ms.compositeId.locale = :locale ").setParameter("locale", locale.getLanguage()).list();
		return items;
	}

}
