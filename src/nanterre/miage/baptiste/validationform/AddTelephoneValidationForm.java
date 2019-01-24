package nanterre.miage.baptiste.validationform;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class AddTelephoneValidationForm extends ActionForm{
	private static final long serialVersionUID = 1L;
	private String telephoneNumber = null;

	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.telephoneNumber=null;
	}
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request){
	    ActionErrors errors = new ActionErrors();
	    
	    String regexnumber = "[0-9]+";
	    if(getTelephoneNumber().length()==0 || getTelephoneNumber()==null) {
        	if(Pattern.matches(regexnumber,getTelephoneNumber())||(getTelephoneNumber().length()<9)||getTelephoneNumber().length()>10) {
        		errors.add("telephone", new ActionMessage("addContact.form.add.error.phoneNumber"));
        	}
		}
        return errors;
    }
}