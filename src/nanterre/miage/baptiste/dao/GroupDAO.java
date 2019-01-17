package nanterre.miage.baptiste.dao;

import java.util.List;

import org.hibernate.Query;

import nanterre.miage.baptiste.model.Group;

public class GroupDAO extends ParentDAO {
	public GroupDAO() {
		super();
	}
	public void addGroup(Group group) {
		super.insertObject(group);
	}
	public void updateGroup(Group group) {
		super.updateObject(group);
	}
	public Group getGroup(int id) {
		try {
			super.beginTransaction();
			return (Group) super.session().get(Group.class, id);
		} finally {
			super.freeSession();
		}
	}
	public List<Group> getAllGroup() {
		try {
			super.beginTransaction();
			StringBuffer requete = new StringBuffer();
			requete.append("SELECT g FROM Group g");
			List<Group> lst = super.session().createQuery(requete.toString()).list();
			return lst;
		} finally {
			super.freeSession();
		}
	}
}
