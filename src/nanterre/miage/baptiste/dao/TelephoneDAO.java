package nanterre.miage.baptiste.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import nanterre.miage.baptiste.model.Adresse;
import nanterre.miage.baptiste.model.Telephone;

public class TelephoneDAO extends ParentDAO {
	public TelephoneDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	public void updateTel(Telephone t) {
		super.updateObject(t);
	}
	public Telephone getTelByNum(String num) {
		Telephone tel = null;
		try {
			StringBuffer query = new StringBuffer();
			query.append("SELECT t FROM Telephone t WHERE t.telephone = :tel");
			Query results = super.getSessionFactory().getCurrentSession().createQuery(query.toString());
			results.setParameter("tel", num);
			tel = (Telephone) results.uniqueResult();
			return tel;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public Telephone getTel(int id) {
		try {
			StringBuilder query = new StringBuilder();
			query.append("SELECT t FROM Telephone t LEFT JOIN t.contact WHERE t.idTelephone = " + id);
			return (Telephone) super.getSessionFactory().getCurrentSession().createQuery(query.toString()).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			super.freeSession();
		}
	}
	public List<Telephone> getAllTel() {
		try {
			StringBuilder query = new StringBuilder();
			query.append("SELECT t FROM Telephone t LEFT JOIN t.contact");
			return (List<Telephone>) super.getSessionFactory().getCurrentSession().createQuery(query.toString()).list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			super.freeSession();
		}
	}
	
	public Telephone insertTelephone(Telephone tel) {
		return (Telephone) super.insertObject(tel);
	}
}
