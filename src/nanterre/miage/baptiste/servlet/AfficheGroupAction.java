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

import java.util.List;

public class AfficheGroupAction extends Action {	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)throws Exception{
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			GroupService gps = (GroupService)context.getBean("GroupService");

			List<Group> grp = gps.getAllGroup();
			request.setAttribute("group", grp);
			return mapping.findForward("reussi");
		}catch (Exception e) {
			e.printStackTrace();
			return new ActionForward("/error");
	
		}
	}
}