 package nanterre.miage.baptiste.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import nanterre.miage.baptiste.model.Group;
import nanterre.miage.baptiste.service.AdresseService;
import nanterre.miage.baptiste.service.ContactService;
import nanterre.miage.baptiste.service.GroupService;
import nanterre.miage.baptiste.validationform.AddContactGroupValidationForm;

public class AddContactGroupAction extends Action {

	public ActionForward execute(final ActionMapping mapping, ActionForm pForm, final HttpServletRequest pRequest,final HttpServletResponse pResponse){
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			GroupService gps = (GroupService)context.getBean("GroupService");
			Group group = gps.getGroupFromForm((AddContactGroupValidationForm) pForm);
			gps.addGroupIfNameNotExist(group);
			return mapping.findForward("success");

		}catch(Exception e) {
			e.printStackTrace();
			return mapping.findForward("error");
		}

	}
}
