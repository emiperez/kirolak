package com.kirolak.dao;

import java.util.List;
import java.util.Locale;

import org.hibernate.Session;

import com.kirolak.MatchStatus;
import com.kirolak.util.HibernateUtil;

public class MatchStatusDAO
{

	public static MatchStatus get(short id)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		MatchStatus returnValue = (MatchStatus) session.get(MatchStatus.class, id);
		return returnValue;
	}

	public static List<MatchStatus> list(Locale locale)
	{
		// TODO it should be done using Hibernate's Lazy Load
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<MatchStatus> items = session.createQuery("from MatchStatus ms where ms.compositeId.locale = :locale").setParameter("locale", locale.getLanguage()).list();
		return items;
	}

}
