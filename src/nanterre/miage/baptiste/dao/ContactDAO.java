package nanterre.miage.baptiste.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.StaleObjectStateException;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import nanterre.miage.baptiste.model.Contact;

public class ContactDAO extends ParentDAO{

	public ContactDAO(){
		super();
	}
	public Contact getContact(int id) {
		try {
			super.loadCurrentSession();
			super.session.beginTransaction();
			Contact c = (Contact) super.session.get(Contact.class, id);
			return c;
		} finally {
			super.freeSession();
		}
	}

	public List<Contact> getAllContact() {
		try {
			super.loadCurrentSession();
			super.session.beginTransaction();
			StringBuffer requete = new StringBuffer();
			requete.append("select c from Contact c");
			
			Query results = super.session.createQuery(requete.toString());
			List<Contact> lst = results.list();
			return lst;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			super.freeSession();
		}

	}
	public void addContact(Contact contact) {
		try {
			super.newSession();
			super.session.beginTransaction();
			super.session.save(contact);
			super.session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.freeSession();
		}
	}
	public void updateContact(Contact contact) throws StaleObjectStateException {
		try {
			super.newSession();
			super.session.beginTransaction();
			super.session.update(contact);
			super.session.getTransaction().commit();
		} catch (StaleObjectStateException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.freeSession();
		}
	}
	public void deleteAllInList(List<Contact> contacts) {
		try {
			super.loadCurrentSession();
			super.session.beginTransaction();
			for (Contact c: contacts) {
				System.out.println(c.getIdContact());
				c = (Contact) super.session.createCriteria(Contact.class)
					.add(Restrictions.idEq(c.getIdContact())).uniqueResult();
				super.session.delete(c);
			}
			super.session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.freeSession();
		}
	}
}
