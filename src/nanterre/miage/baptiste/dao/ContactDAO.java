package nanterre.miage.baptiste.dao;

import java.sql.Connection;
import java.util.List;
import java.sql.SQLException;
import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
		}finally {
			super.freeSession();
		}
	}

	public List<Contact> getAllContact() {
		try {
			super.newSession();
			Transaction tx = super.session.beginTransaction();
			StringBuffer requete = new StringBuffer();
			requete.append("select c from Contact c");

			Query results = super.session.createQuery(requete.toString());
			List<Contact> lst = results.list();
			return lst;
		} catch (Exception e) {
			System.err.println("Session : ");
			System.err.println(super.session.toString());
			e.printStackTrace();
			return null;
		} finally {
			super.freeSession();
		}

	}
	public void addContact(Contact c) {
		super.newSession();
		Transaction tx = super.session.beginTransaction();
		super.session.save(c);
		tx.commit();
	}
}
