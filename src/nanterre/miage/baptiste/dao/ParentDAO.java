package nanterre.miage.baptiste.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class ParentDAO {
	Transaction tx;
	Session session;
	public ParentDAO() {
	}
	
	protected void freeSession() {
		try  {
			this.session().close();
		}catch(Exception e ) {
			e.printStackTrace();
		}finally {
			this.tx = null;
			System.out.println("FreeSession");
		}
		
	}

	protected Session session() {
	     return HibernateUtil.getSessionFactory().openSession();
	}
	
	protected void beginTransaction() {
		try {
			this.session = session();
			this.tx = this.session.beginTransaction();
		}catch (Exception e) {
			e.printStackTrace();
		}
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
			beginTransaction();
			this.session.save(object);
			tx.commit();
			return object;
		} catch (Exception e) {
			e.printStackTrace();
			freeSession();
			return null;
		}
	}
	
	protected Object updateObject(Object object) {
		try {
			beginTransaction();
			this.session.update(object);
			tx.commit();
			return object;
		} catch (Exception e) {
			e.printStackTrace();
			freeSession();
			return object;
		}
	}
}
