package nanterre.miage.baptiste.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import nanterre.miage.baptiste.model.Contact;
import nanterre.miage.baptiste.service.AdresseService;
import nanterre.miage.baptiste.service.ContactService;
import nanterre.miage.baptiste.service.GroupService;
import nanterre.miage.baptiste.service.TelephoneService;
import nanterre.miage.baptiste.validationform.RechercheContactValidationForm;

public class RechercheContactAction extends Action{
	public ActionForward execute(final ActionMapping mapping, ActionForm form, final HttpServletRequest pRequest,final HttpServletResponse pResponse) throws Exception{
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			ContactService cts = (ContactService)context.getBean("ContactService");
			Contact contact = cts.differentiateFromForm((RechercheContactValidationForm) form);
			List<Contact> c = cts.getAllContactLike(contact);

			pRequest.setAttribute("contact", c);
			return mapping.findForward("success");

		}catch(Exception e) {
			return new ActionForward("ERROR");
		}
	}
}