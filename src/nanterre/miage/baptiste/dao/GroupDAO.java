package nanterre.miage.baptiste.dao;

import java.util.List;

import org.hibernate.Query;

import nanterre.miage.baptiste.model.Contact;
import nanterre.miage.baptiste.model.Group;

public class GroupDAO extends ParentDAO {
	public GroupDAO() {
		super();
	}
	
	public List<Group> getAllGroup() {
		try {
			super.loadCurrentSession();
			super.session.beginTransaction();
			StringBuffer requete = new StringBuffer();
			requete.append("SELECT g FROM Group g");
			Query results = super.session.createQuery(requete.toString());
			List<Group> lst = results.list();
			return lst;
		} finally {
			super.freeSession();
		}
	}
}
