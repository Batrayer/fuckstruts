package nanterre.miage.baptiste.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import nanterre.miage.baptiste.service.ConnexionService;
import nanterre.miage.baptiste.validationform.ConnexionValidationForm;

public class ConnexionAction extends Action{

	public ActionForward execute(final ActionMapping mapping, ActionForm pForm, final HttpServletRequest pRequest,final HttpServletResponse pResponse) throws Exception{
		try {
			System.out.println("ConnexionAction");
			String error = null;
			HttpSession session = pRequest.getSession();
			boolean bool = ConnexionService.getInstance().checkIdentifiant((ConnexionValidationForm) pForm);
			if(!bool)
			{
				error = "Erreur l'utilisateur n'existe pas";
			}
			if(error==null){
				session.setAttribute("login", ((ConnexionValidationForm) pForm).getUsername());
				return mapping.findForward("success");
			}else{
				return mapping.findForward("error");
			}
		}catch(Exception e) {
			return new ActionForward("/ERROR");
		}
	}
}