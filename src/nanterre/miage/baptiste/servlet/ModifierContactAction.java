package nanterre.miage.baptiste.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import nanterre.miage.baptiste.model.Contact;
import nanterre.miage.baptiste.model.Group;
import nanterre.miage.baptiste.model.Telephone;
import nanterre.miage.baptiste.service.ContactService;
import nanterre.miage.baptiste.service.GroupService;
import nanterre.miage.baptiste.service.TelephoneService;

public class ModifierContactAction extends Action{
	public ActionForward execute(final ActionMapping mapping, ActionForm pForm, final HttpServletRequest pRequest,final HttpServletResponse pResponse) throws Exception{
		try {
			int id = Integer.parseInt(pRequest.getParameter("id"));
			ContactService cts = ContactService.getInstance();
			GroupService gps = GroupService.getInstance();
			TelephoneService tes = TelephoneService.getInstance();
			List<Group> grp = gps.getAllGroup();
			Contact c = cts.getContactById(id);
			List<Telephone> tel = tes.getAllTel();
			List<Telephone> telContact = tes.getAllTelFromContact(tel, c);
			tel = tes.getAllTelWithoutContact(tel);
			System.out.println("nb tel = " + tel.size());
			pRequest.setAttribute("tel", tel);
			pRequest.setAttribute("tctc", telContact);
			pRequest.setAttribute("cgrp", grp);
			pRequest.setAttribute("contact",c);
			return mapping.findForward("success");
		}catch(Exception e) {
			e.printStackTrace();
			return new ActionForward("error");
		}
	}
}