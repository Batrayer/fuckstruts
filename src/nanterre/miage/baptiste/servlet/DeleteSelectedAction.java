package nanterre.miage.baptiste.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import nanterre.miage.baptiste.service.ContactService;
import nanterre.miage.baptiste.validationform.DeleteSelectedValidationForm;

public class DeleteSelectedAction extends Action{
	public ActionForward execute(final ActionMapping mapping, ActionForm pForm, final HttpServletRequest pRequest,final HttpServletResponse pResponse) throws Exception{
		try {
			ContactService cts = ContactService.getInstance();
			List<Integer> ids = cts.convertTabStringToListInt(((DeleteSelectedValidationForm) pForm).getId());
			String error = cts.deleteAllFromListId(ids);
			
			if(error==null){
				return mapping.findForward("success");
			}else{
				return mapping.findForward("error");
			}
		}catch(Exception e) {
			return new ActionForward("ERROR");
		}
	}
}