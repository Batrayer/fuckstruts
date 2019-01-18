package nanterre.miage.baptiste.servlet;

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
import java.util.*;

public class AfficheContactAction extends Action {
	public List<Contact> ctc;
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)throws Exception{
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			ContactService cts = (ContactService)context.getBean("ContactService");
			ctc = cts.getAllContact();
			request.setAttribute("contact",ctc);
			return mapping.findForward("reussi");
		}catch(Exception e) {
			e.printStackTrace();
			return new ActionForward("ERROR");
		}
	}
}