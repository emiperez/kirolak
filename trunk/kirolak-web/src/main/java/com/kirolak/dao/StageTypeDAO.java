package com.kirolak.dao;

import java.util.List;
import java.util.Locale;

import org.hibernate.Session;

import com.kirolak.StageType;
import com.kirolak.util.HibernateUtil;

public class StageTypeDAO
{

	public static StageType get(short id)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		StageType returnValue = (StageType) session.get(StageType.class, id);
		return returnValue;
	}

	public static List<StageType> list(Locale locale)
	{
		// TODO it should be done using Hibernate's Lazy Load
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<StageType> items = session.createQuery("from StageType st where st.compositeId.locale = :locale").setParameter("locale", locale.getLanguage()).list();
		return items;
	}

}
