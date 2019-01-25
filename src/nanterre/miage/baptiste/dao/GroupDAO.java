package nanterre.miage.baptiste.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import nanterre.miage.baptiste.model.Group;
import nanterre.miage.baptiste.model.Telephone;
import nanterre.miage.baptiste.model.User;

public class GroupDAO extends ParentDAO {
	public GroupDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	public Group addGroup(Group group) {
		return (Group) super.insertObject(group);
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
	
	public Group getGroupByName(String name) {
		try {
			StringBuffer query = new StringBuffer();
			query.append("SELECT g FROM Group g WHERE g.groupName = :name");
			Query results = super.getSessionFactory().getCurrentSession().createQuery(query.toString());
			results.setParameter("name", name);
			return (Group) results.uniqueResult();
		} finally {
			super.freeSession();
		}
	}
}
