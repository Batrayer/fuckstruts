package nanterre.miage.baptiste.dao;

import java.util.List;

import nanterre.miage.baptiste.model.Telephone;

public class TelephoneDAO extends ParentDAO {
	public TelephoneDAO() {
		super();
	}
	public void updateTel(Telephone t) {
		super.updateObject(t);
	}
	
	public Telephone getTel(int id) {
		try {
			super.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("SELECT t FROM Telephone t LEFT JOIN t.contact WHERE t.idTelephone = " + id);
			return (Telephone) super.session.createQuery(query.toString()).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			super.freeSession();
		}
	}
	public List<Telephone> getAllTel() {
		try {
			super.beginTransaction();
			StringBuilder query = new StringBuilder();
			query.append("SELECT t FROM Telephone t LEFT JOIN t.contact");
			return (List<Telephone>) super.session.createQuery(query.toString()).list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			super.freeSession();
		}
	}
}
