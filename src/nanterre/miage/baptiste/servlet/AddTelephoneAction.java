 package nanterre.miage.baptiste.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import nanterre.miage.baptiste.model.Telephone;
import nanterre.miage.baptiste.service.TelephoneService;
import nanterre.miage.baptiste.validationform.AddTelephoneValidationForm;

public class AddTelephoneAction extends Action {

	public ActionForward execute(final ActionMapping mapping, ActionForm pForm, final HttpServletRequest pRequest,final HttpServletResponse pResponse){
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			TelephoneService tls = (TelephoneService)context.getBean("TelephoneService");
			Telephone tel = tls.getTelFromForm((AddTelephoneValidationForm) pForm);
			
			tls.insertTelephoneIfNotExist(tel);
			return mapping.findForward("success");

		}catch(Exception e) {
			e.printStackTrace();
			return mapping.findForward("error");
		}

	}
}
