package nanterre.miage.baptiste.validationform;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class DeleteSelectedValidationForm extends ActionForm{
	private static final long serialVersionUID = 1L;
	private String[] id;

	public String[] getId() {
		return id;
	}
	public void setId(String[] id) {
		this.id = id;
	}
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.id=null;
	}
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request){
		ActionErrors errors = new ActionErrors();
		try {
		    if(id.length<1) {
		    	errors.add("getId", new ActionMessage("deleteSelected.form.error"));
		    }
		}catch (NullPointerException e) {
			errors.add("getId", new ActionMessage("deleteSelected.form.error"));
		}
        return errors;
    }
}