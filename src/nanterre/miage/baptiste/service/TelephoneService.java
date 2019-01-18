package nanterre.miage.baptiste.service;

import java.util.ArrayList;
import java.util.List;

import nanterre.miage.baptiste.dao.TelephoneDAO;
import nanterre.miage.baptiste.model.Contact;
import nanterre.miage.baptiste.model.Telephone;

public class TelephoneService {
	private final TelephoneDAO tdao;

	private TelephoneService(TelephoneDAO tdao) {
		this.tdao = tdao;
	}
	
	public List<Telephone> getAllTel() {
		return tdao.getAllTel();
	}
	
	public void setContactToListTelId(int[] ids, Contact c) {
		for(int i = 0; i<ids.length; i++) {
			Telephone t = tdao.getTel(ids[i]);
			t.setContact(c);
			tdao.updateTel(t);
		}
	}
	
	public List<Telephone> getAllTelWithoutContact (List<Telephone> tels) { // TODO get les de l'utilisateur
		List<Telephone> telContact = new ArrayList<Telephone>();
		for(Telephone t: tels) {
			if(t.getContact() != null) {
				telContact.remove(t);
			}
		}
		return tels;
	}
	public List<Telephone> getAllTelFromContact(List<Telephone> tels, Contact c) {
		List<Telephone> telContact = new ArrayList<Telephone>();
		if(c != null) {
			for (Telephone t: tels) {
				if(t.getContact() != null) {
					if(t.getContact().getIdContact() == c.getIdContact()) {
						telContact.add(t);
					}					
				}
			}		
		}

		return telContact;
	}	
}
