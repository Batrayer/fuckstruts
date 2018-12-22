package nanterre.miage.baptiste.dao;

import org.hibernate.criterion.Example;
import nanterre.miage.baptiste.model.User;

public class UserDAO extends ParentDAO {
	public UserDAO() {
		super();
	}
	
	public boolean getConnection(User user) {
		try {
			super.loadCurrentSession();
			super.session.beginTransaction();
			return !super.session.createCriteria(User.class)
						.add(Example.create(user)).list().isEmpty();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			// super.freeSession();
		}
	}
}