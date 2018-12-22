package nanterre.miage.baptiste.dao;

import org.hibernate.Session;

import util.HibernateUtil;

public class ParentDAO {
	Session session = null;
	
	public ParentDAO() {
	}
	
	protected void freeSession() {
		if (this.session != null) {
			session = null;
		}
	}
	protected void newSession() {
		this.session = HibernateUtil.getSessionFactory().openSession();
	}
	protected void loadCurrentSession() {
		this.session = HibernateUtil.getSessionFactory().getCurrentSession();
	}
}
