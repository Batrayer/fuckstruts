package nanterre.miage.baptiste.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import java.util.List;

public class ContactCreationAction extends Action{
	public ActionForward execute(final ActionMapping mapping, ActionForm pForm, final HttpServletRequest pRequest,final HttpServletResponse pResponse) throws Exception{
		try {
			// List<Entreprise> lent;
			// List<ContactGroup> cgrp;
			// EntrepriseDAO daoE = new EntrepriseDAO();
			// ContactGroupDAO daoCG = new ContactGroupDAO();
			
			// lent = daoE.getAllEntreprise();
			// cgrp = daoCG.getAllContactGroup();
			//pRequest.setAttribute("cgrp", );
			//pRequest.setAttribute("ent", lent);
			return mapping.findForward("success");
		}catch(Exception e) {
			return new ActionForward("ERROR");
		}
	}
}