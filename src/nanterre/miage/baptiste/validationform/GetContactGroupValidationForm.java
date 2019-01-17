package nanterre.miage.baptiste.validationform;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class GetContactGroupValidationForm extends ActionForm{
	private static final long serialVersionUID = 1L;
	private String groupId;

	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.groupId=null;
	}
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request){
	    ActionErrors errors = new ActionErrors();
        System.out.println("validated");
        return errors;
    }
}