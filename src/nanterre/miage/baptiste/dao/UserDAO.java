package nanterre.miage.baptiste.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import nanterre.miage.baptiste.model.User;

public class UserDAO extends ParentDAO {
	public UserDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	public boolean getConnection(User user) {
		try {
			return !super.getSessionFactory().getCurrentSession().createCriteria(User.class)
						.add(Example.create(user)).list().isEmpty();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			super.freeSession();
		}
	}
}