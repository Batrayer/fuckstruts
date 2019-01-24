package nanterre.miage.baptiste.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import nanterre.miage.baptiste.model.Group;

public class GroupDAO extends ParentDAO {
	public GroupDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	public void addGroup(Group group) {
		super.insertObject(group);
	}
	public void updateGroup(Group group) {
		super.updateObject(group);
	}
	public Group getGroup(int id) {
		try {
			return (Group) super.getSessionFactory().getCurrentSession().get(Group.class, id);
		} finally {
			super.freeSession();
		}
	}
	public List<Group> getAllGroup() {
		try {
			StringBuffer requete = new StringBuffer();
			requete.append("SELECT g FROM Group g");
			List<Group> lst = super.getSessionFactory().getCurrentSession().createQuery(requete.toString()).list();
			return lst;
		} finally {
			super.freeSession();
		}
	}
}
