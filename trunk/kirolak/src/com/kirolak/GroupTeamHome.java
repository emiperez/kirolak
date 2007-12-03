package com.kirolak;

// Generated 30-nov-2007 8:26:55 by Hibernate Tools 3.2.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class GroupTeam.
 * @see com.kirolak.GroupTeam
 * @author Hibernate Tools
 */
public class GroupTeamHome {

	private static final Log log = LogFactory.getLog(GroupTeamHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(GroupTeam transientInstance) {
		log.debug("persisting GroupTeam instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(GroupTeam instance) {
		log.debug("attaching dirty GroupTeam instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(GroupTeam instance) {
		log.debug("attaching clean GroupTeam instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(GroupTeam persistentInstance) {
		log.debug("deleting GroupTeam instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public GroupTeam merge(GroupTeam detachedInstance) {
		log.debug("merging GroupTeam instance");
		try {
			GroupTeam result = (GroupTeam) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public GroupTeam findById(com.kirolak.GroupTeamId id) {
		log.debug("getting GroupTeam instance with id: " + id);
		try {
			GroupTeam instance = (GroupTeam) sessionFactory
					.getCurrentSession().get("com.kirolak.GroupTeam", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<GroupTeam> findByExample(GroupTeam instance) {
		log.debug("finding GroupTeam instance by example");
		try {
			List<GroupTeam> results = (List<GroupTeam>) sessionFactory
					.getCurrentSession().createCriteria(
							"com.kirolak.GroupTeam").add(create(instance))
					.list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
