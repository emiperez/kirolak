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
 * Home object for domain model class CompetitionTeam.
 * @see com.kirolak.CompetitionTeam
 * @author Hibernate Tools
 */
public class CompetitionTeamHome {

	private static final Log log = LogFactory
			.getLog(CompetitionTeamHome.class);

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

	public void persist(CompetitionTeam transientInstance) {
		log.debug("persisting CompetitionTeam instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(CompetitionTeam instance) {
		log.debug("attaching dirty CompetitionTeam instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CompetitionTeam instance) {
		log.debug("attaching clean CompetitionTeam instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(CompetitionTeam persistentInstance) {
		log.debug("deleting CompetitionTeam instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CompetitionTeam merge(CompetitionTeam detachedInstance) {
		log.debug("merging CompetitionTeam instance");
		try {
			CompetitionTeam result = (CompetitionTeam) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CompetitionTeam findById(com.kirolak.CompetitionTeamId id) {
		log.debug("getting CompetitionTeam instance with id: " + id);
		try {
			CompetitionTeam instance = (CompetitionTeam) sessionFactory
					.getCurrentSession()
					.get("com.kirolak.CompetitionTeam", id);
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

	public List<CompetitionTeam> findByExample(CompetitionTeam instance) {
		log.debug("finding CompetitionTeam instance by example");
		try {
			List<CompetitionTeam> results = (List<CompetitionTeam>) sessionFactory
					.getCurrentSession().createCriteria(
							"com.kirolak.CompetitionTeam").add(
							create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
