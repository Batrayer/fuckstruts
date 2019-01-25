package nanterre.miage.baptiste.servlet;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.StaleObjectStateException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import nanterre.miage.baptiste.model.Adresse;
import nanterre.miage.baptiste.model.Contact;
import nanterre.miage.baptiste.model.Group;
import nanterre.miage.baptiste.service.AdresseService;
import nanterre.miage.baptiste.service.ContactService;
import nanterre.miage.baptiste.service.GroupService;
import nanterre.miage.baptiste.service.TelephoneService;
import nanterre.miage.baptiste.validationform.ModifierBDDContactValidationForm;

public class ModifierBDDContactAction extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)throws Exception{
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			GroupService gps = (GroupService)context.getBean("GroupService");
			ContactService cts = (ContactService)context.getBean("ContactService");
			AdresseService ass =  (AdresseService)context.getBean("AdresseService");
			TelephoneService tls =  (TelephoneService)context.getBean("TelephoneService");
			Adresse adresse = new Adresse();
			adresse.setAdresse(((ModifierBDDContactValidationForm) form).getAdresse());
			adresse = ass.getOrCreate(adresse);
			Contact contact = cts.differentiateFromForm((ModifierBDDContactValidationForm)form);
			tls.setContactToListTelId(((ModifierBDDContactValidationForm) form).getIdTel(), contact);
			Set<Group> groups = gps.getAllFromTab(((ModifierBDDContactValidationForm)form).getIdGroup());
			contact.setGroups(groups);
			contact.setAdresse(adresse);
			System.out.println(contact.getIdContact() + "---" + contact.getAdresse().getAdresse());
			cts.updateContact(contact);
			return mapping.findForward("success");
		} catch (StaleObjectStateException e) {
			System.out.println("error stale");
			request.setAttribute("error", "Votre objet est à été modifié, annulation des changements");
			return mapping.findForward("error");
		} catch(Exception e) {
			e.printStackTrace();
			return new ActionForward("error");
		}
	}
}