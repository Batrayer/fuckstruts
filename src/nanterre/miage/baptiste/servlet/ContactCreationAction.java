package nanterre.miage.baptiste.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ContactCreationAction extends Action{
	public ActionForward execute(final ActionMapping mapping, ActionForm pForm, final HttpServletRequest pRequest,final HttpServletResponse pResponse) throws Exception{
		try {
			return mapping.findForward("success");
		}catch(Exception e) {
			e.printStackTrace();
			return new ActionForward("error");
		}
	}
}