package nanterre.miage.baptiste.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import nanterre.miage.baptiste.model.Adresse;

public class AdresseDAO extends ParentDAO {
	public AdresseDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
	public Adresse getByAdresse(String adresse) {
		try {
			StringBuffer query = new StringBuffer();
			query.append("SELECT a FROM Adresse a WHERE a.adresse = :adr");
			Query results = super.getSessionFactory().getCurrentSession().createQuery(query.toString());
			results.setParameter("adr", adresse);
			Adresse a = (Adresse) results.uniqueResult();
			return a;
		} finally {
			super.freeSession();
		}
	}
	
	public Adresse addAdresse(Adresse adresse) {
		try {
			return (Adresse) super.insertObject(adresse);
		} catch (Exception e) {
			return null;
		} finally {
			super.freeSession();
		}
	}
	
	public void deleteAdresse(Adresse adresse) {
		try {
			super.getSessionFactory().getCurrentSession().delete(adresse);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
