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
		System.out.println("Load currentSession");
		this.session = HibernateUtil.getSessionFactory().getCurrentSession();
		if (this.session == null) {
			this.newSession();
			System.out.println("New session");
		} else {
			System.out.println("Old session");
		}
	}
}
