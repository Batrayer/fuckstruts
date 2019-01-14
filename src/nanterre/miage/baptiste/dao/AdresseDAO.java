package nanterre.miage.baptiste.dao;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;

import nanterre.miage.baptiste.model.Adresse;

public class AdresseDAO extends ParentDAO {
	public AdresseDAO() {
		super();
	}
	
	public Adresse getByAdresse(String adresse) {
		try {
			super.loadCurrentSession();
			super.session.beginTransaction();
			StringBuffer query = new StringBuffer();
			query.append("SELECT a FROM Adresse a WHERE a.adresse = :adr");
			Query results = super.session.createQuery(query.toString());
			results.setParameter("adr", adresse);
			Adresse a = (Adresse) results.uniqueResult();
			return a;
		} finally {
			super.freeSession();
		}
	}
	
	public Adresse addAdresse(Adresse adresse) {
		try {
			super.newSession();
			super.session.beginTransaction();
			super.session.save(adresse);
			super.session.getTransaction().commit();
			return adresse;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			super.freeSession();
		}
	}
}
