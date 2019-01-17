 package nanterre.miage.baptiste.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import nanterre.miage.baptiste.model.Group;
import nanterre.miage.baptiste.service.GroupService;
import nanterre.miage.baptiste.validationform.AddContactGroupValidationForm;

public class AddContactGroupAction extends Action {

	public ActionForward execute(final ActionMapping mapping, ActionForm pForm, final HttpServletRequest pRequest,final HttpServletResponse pResponse){
		try {
			GroupService gps = GroupService.getInstance();
			Group group = gps.getGroupFromForm((AddContactGroupValidationForm) pForm);
			gps.AddGroup(group);
			return mapping.findForward("success");

		}catch(Exception e) {
			e.printStackTrace();
			return mapping.findForward("error");
		}

	}
}
