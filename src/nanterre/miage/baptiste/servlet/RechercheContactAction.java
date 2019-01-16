package nanterre.miage.baptiste.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import nanterre.miage.baptiste.model.Contact;
import nanterre.miage.baptiste.service.ContactService;
import nanterre.miage.baptiste.validationform.RechercheContactValidationForm;

public class RechercheContactAction extends Action{
	public ActionForward execute(final ActionMapping mapping, ActionForm form, final HttpServletRequest pRequest,final HttpServletResponse pResponse) throws Exception{
		try {
			ContactService cts = ContactService.getInstance();
			Contact contact = cts.differentiateFromForm((RechercheContactValidationForm) form);
			List<Contact> c = cts.getAllContactLike(contact);

			pRequest.setAttribute("contact", c);
			return mapping.findForward("success");

		}catch(Exception e) {
			return new ActionForward("ERROR");
		}
	}
}