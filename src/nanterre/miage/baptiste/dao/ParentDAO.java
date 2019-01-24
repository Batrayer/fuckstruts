package nanterre.miage.baptiste.dao;

import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;

import util.HibernateUtil;

public class ParentDAO {
	Statistics stat;
	protected SessionFactory sessionFactory;
	
	protected ParentDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		this.stat = HibernateUtil.getSessionFactory().getStatistics();
		this.stat.setStatisticsEnabled(true);
	}
	
	protected void freeSession() {

	}

	protected SessionFactory getSessionFactory() {
		
		return this.sessionFactory;
	}
	
 	protected String whereOrAndAppend(String request) {
		if (request.contains("WHERE")) {
			return "AND";
		} else {
			return "WHERE";
		}
	}
	
	protected Object insertObject(Object object) {
		try {
			
        	System.out.println("Second Level Hit Count=" + this.stat.getSecondLevelCacheHitCount());
			System.out.println("Second Level Miss Count=" + this.stat.getSecondLevelCacheMissCount());
			getSessionFactory().getCurrentSession().save(object);
            System.out.println("Second Level Hit Count=" + this.stat.getSecondLevelCacheHitCount());
			System.out.println("Second Level Miss Count=" + this.stat.getSecondLevelCacheMissCount());
			return object;
		} catch (Exception e) {
			e.printStackTrace();
			freeSession();
			return null;
		}
	}
	
	protected Object updateObject(Object object) {
		try {
			this.getSessionFactory().getCurrentSession().update(object);
			return object;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			freeSession();
		}
	}
}
