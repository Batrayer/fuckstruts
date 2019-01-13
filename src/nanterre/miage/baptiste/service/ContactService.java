package nanterre.miage.baptiste.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.StaleObjectStateException;

import nanterre.miage.baptiste.dao.ContactDAO;
import nanterre.miage.baptiste.model.Contact;
import nanterre.miage.baptiste.model.Entreprise;
import nanterre.miage.baptiste.validationform.AddContactValidationForm;
import nanterre.miage.baptiste.validationform.ModifierBDDContactValidationForm;

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
    public Contact differentiateFromForm(AddContactValidationForm form) {
    	Contact c;
    	if(form.getSiret() != null) {
    		c = new Entreprise();
    		((Entreprise) c).setSiret(form.getSiret());
    	} else {
    		c = new Contact();
    	}
    	c.setEmail(form.getEmail());
		c.setNom(form.getNom());
		c.setPrenom(form.getPrenom());
		return c;
    }
    public Contact differentiateFromForm(ModifierBDDContactValidationForm form) {
    	Contact c = getContactById(Integer.parseInt(form.getIdContact()));
    	if(form.getSiret() != null) {
    		((Entreprise) c).setSiret(form.getSiret());
    	}
    	c.setEmail(form.getEmail());
		c.setNom(form.getNom());
		c.setPrenom(form.getPrenom());
		return c;
    }
    public Contact getContactById(int id) {
    	return cdao.getContact(id);
    }
    public void updateContact(Contact contact) throws StaleObjectStateException {
    	try {
        	cdao.updateContact(contact);
    	} catch (StaleObjectStateException e) {
    		throw e;
    	}
    }
    public void addContact(Contact c) {
    	cdao.addContact(c);
    }
    
    public String deleteAllFromListId(List<Integer> id) {
    	List<Contact> contacts = new ArrayList<Contact>();
    	for (Integer i: id) {
    		Contact c = new Contact();
    		c.setIdContact(i);
    		contacts.add(c);
    	}
    	cdao.deleteAllInList(contacts);
    	return null;
    }
    
    public List<Integer> convertTabStringToListInt(String[] id) {
    	List<Integer> numbers = new ArrayList<Integer>();
    	for(int i = 0; i < id.length; i++) {
    		try {
    			numbers.add(Integer.parseInt(id[i]));
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    	return numbers;
    }
}
