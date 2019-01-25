package nanterre.miage.baptiste.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import nanterre.miage.baptiste.model.Adresse;
import nanterre.miage.baptiste.model.Contact;
import nanterre.miage.baptiste.model.Entreprise;
import nanterre.miage.baptiste.model.Group;
import nanterre.miage.baptiste.model.Telephone;
import nanterre.miage.baptiste.service.AdresseService;
import nanterre.miage.baptiste.service.ContactService;
import nanterre.miage.baptiste.service.GroupService;
import nanterre.miage.baptiste.service.TelephoneService;

public class RempliBDDAction extends Action{
	public ActionForward execute(final ActionMapping mapping, ActionForm form, final HttpServletRequest pRequest,final HttpServletResponse pResponse) throws Exception{
		try {
	        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");  
	        GroupService groupService = (GroupService) context.getBean("GroupService");
	        ContactService contactService = (ContactService) context.getBean("ContactService");
	        AdresseService adresseService = (AdresseService) context.getBean("AdresseService");
	        TelephoneService telephoneService = (TelephoneService) context.getBean("TelephoneService");
	        
	        Group volleyball = (Group) context.getBean("volleyball");
	        Group collegue = (Group) context.getBean("collegue");
	        volleyball = (Group) groupService.addGroupIfNameNotExist(volleyball);
	        collegue = (Group) groupService.addGroupIfNameNotExist(collegue);
	        
	        Adresse adr1 = (Adresse) context.getBean("adresse1");
	        Adresse adr2 = (Adresse) context.getBean("adresse2");
	        adr1 = adresseService.create(adr1);
	        adr2 = adresseService.create(adr2);
	        
	        
	        Contact alexandre = (Contact) context.getBean("contact1");
	        Contact baptiste = (Contact) context.getBean("contact2");
	        Contact itnovem = (Contact) context.getBean("contact3");
	        contactService.addContact(alexandre);
	        contactService.addContact(baptiste);
	        contactService.addContact(itnovem);
	        
	        Telephone tel1 = (Telephone) context.getBean("tel1");
	        Telephone tel2 = (Telephone) context.getBean("tel2");
	        Telephone tel3 = (Telephone) context.getBean("tel3");
	        telephoneService.insertTelephone(tel1);
	        telephoneService.insertTelephone(tel2);
	        telephoneService.insertTelephone(tel3);
	        
			return mapping.findForward("success");
		}catch(Exception e) {
			e.printStackTrace();
			return new ActionForward("ERROR");
		}
	}
}