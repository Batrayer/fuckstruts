 package nanterre.miage.baptiste.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import nanterre.miage.baptiste.validationform.AddContactValidationForm;
import nanterre.miage.baptiste.model.Adresse;
import nanterre.miage.baptiste.model.Contact;
import nanterre.miage.baptiste.service.AdresseService;
import nanterre.miage.baptiste.service.ContactService;

public class AddContactAction extends Action {

	public ActionForward execute(final ActionMapping mapping, ActionForm pForm, final HttpServletRequest pRequest,final HttpServletResponse pResponse){
		try {
			ContactService cts = ContactService.getInstance();
			AdresseService ass = AdresseService.getInstance();
			Adresse a = ass.getOrCreate(((AddContactValidationForm) pForm).getAdresse()); 
			Contact c = cts.differentiateFromForm(((AddContactValidationForm) pForm));
			c.setAdresse(a);
			cts.addContact(c);
			return mapping.findForward("success");
		}catch(Exception e) {
			e.printStackTrace();
			return new ActionForward("error");
		}
	}
}
