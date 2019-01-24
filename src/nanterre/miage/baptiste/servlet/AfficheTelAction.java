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

import java.util.List;

public class AfficheTelAction extends Action {	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)throws Exception{
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			TelephoneService tls  = (TelephoneService)context.getBean("TelephoneService");

			List<Telephone> tel = tls.getAllTel();
			request.setAttribute("tels", tel);
			return mapping.findForward("reussi");
		}catch (Exception e) {
			e.printStackTrace();
			return new ActionForward("/error");
	
		}
	}
}