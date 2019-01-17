package nanterre.miage.baptiste.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import nanterre.miage.baptiste.model.Contact;
import nanterre.miage.baptiste.model.Group;
import nanterre.miage.baptiste.service.GroupService;
import nanterre.miage.baptiste.validationform.GetContactGroupValidationForm;

import java.util.Set;

public class GetContactGroupAction extends Action{
	public ActionForward execute(final ActionMapping mapping, ActionForm pForm, final HttpServletRequest pRequest,final HttpServletResponse pResponse) throws Exception{
		try {
			GroupService gps = GroupService.getInstance();
			Group grp = gps.getGroupFromId(Integer.parseInt(((GetContactGroupValidationForm)pForm).getGroupId()));
			Set<Contact> ctc = grp.getContacts();
			pRequest.setAttribute("contact",ctc);
			return mapping.findForward("success");
		}catch(Exception e) {
			e.printStackTrace();
			return new ActionForward("/ERROR");
		}

	}
}