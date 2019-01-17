package nanterre.miage.baptiste.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import nanterre.miage.baptiste.model.Contact;

public class ContactDAO extends ParentDAO{

	public ContactDAO(){
		super();
	}
	public Contact getContact(int id) {
		try {
			super.beginTransaction();
			Contact c = (Contact) super.session().get(Contact.class, id);
			return c;
		} finally {
			super.freeSession();
		}
	}
	public List<Contact> getAllContactLike(Contact contact) {
		try {
			super.beginTransaction();
			List<Contact> lst;
			StringBuffer requete = new StringBuffer();
			requete.append("select c from Contact c ");
			if (contact.getNom() != null && !"".equals(contact.getNom())) {
				requete.append(super.whereOrAndAppend(requete.toString()));
				requete.append(" c.nom LIKE '%" + contact.getNom() +"%' ");
			}
			if (contact.getPrenom() != null && !"".equals(contact.getPrenom())) {
				requete.append(super.whereOrAndAppend(requete.toString()));
				requete.append(" c.prenom LIKE '%" + contact.getPrenom() +"%' ");
			}
			if (contact.getEmail() != null && !"".equals(contact.getEmail())) {
				requete.append(super.whereOrAndAppend(requete.toString()));
				requete.append(" c.email LIKE '%" + contact.getEmail() +"%' ");
			}
			Query results = super.session().createQuery(requete.toString());
			/*
			Example example = Example.create(contact)
					.ignoreCase()
					.enableLike()
					.excludeNone()
					.excludeZeroes();
			List<Contact> lst =  super.session.createCriteria(Contact.class).add(example).list();
			System.out.println(lst.size());*/
			lst = results.list();
			return lst;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			super.freeSession();
		}
	}
	
	public List<Contact> getAllContact() {
		try {
			super.beginTransaction();
			StringBuffer requete = new StringBuffer();
			requete.append("select c from Contact c");
			
			Query results = super.session().createQuery(requete.toString());
			List<Contact> lst =  results.list();
			return lst;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			super.freeSession();
		}

	}

	public void deleteAllInList(List<Contact> contacts) {
		try {
			super.beginTransaction();
			for (Contact c: contacts) {
				System.out.println(c.getIdContact());
				c = (Contact) super.session().createCriteria(Contact.class)
					.add(Restrictions.idEq(c.getIdContact())).uniqueResult();
				super.session().delete(c);
			}
			super.session().getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.freeSession();
		}
	}
	
	public void updateContact(Contact contact) {
		super.updateObject(contact);
	}
	
	public void addContact(Contact contact) {
		super.insertObject(contact);
	}
}
