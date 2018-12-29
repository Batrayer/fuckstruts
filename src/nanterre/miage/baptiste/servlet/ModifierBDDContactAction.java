package nanterre.miage.baptiste.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import nanterre.miage.baptiste.model.Contact;
import nanterre.miage.baptiste.service.ContactService;
import nanterre.miage.baptiste.validationform.ModifierBDDContactValidationForm;

public class ModifierBDDContactAction extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)throws Exception{
		try {
			ContactService cts = ContactService.getInstance();
			Contact contact = cts.differentiateFromForm((ModifierBDDContactValidationForm)form);
			cts.updateContact(contact);
			return mapping.findForward("success");
		}catch(Exception e) {
			e.printStackTrace();
			return new ActionForward("error");
		}
	}
}