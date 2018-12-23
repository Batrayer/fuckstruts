package nanterre.miage.baptiste.service;

import java.util.List;

import nanterre.miage.baptiste.dao.ContactDAO;
import nanterre.miage.baptiste.model.Contact;

public class ContactService {
	private static final ContactService INSTANCE = new ContactService();
	private final ContactDAO cdao;
    public static ContactService getInstance() {
        return INSTANCE;
    }
    private ContactService() {
    	cdao = new ContactDAO();
    }
    
    public List<Contact> getAllContact() {
    	return cdao.getAllContact();
    }
    
    public void addContact(Contact c) {
    	cdao.addContact(c);
    }
}
