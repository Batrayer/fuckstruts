package nanterre.miage.baptiste.validationform;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class ConnexionValidationForm extends ActionForm{
	private static final long serialVersionUID = 1L;
	private String username = null;
	private String password = null;
	
	public ConnexionValidationForm() {
		super();
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.password=null;
		this.username=null;
	}
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request){
	    ActionErrors errors = new ActionErrors();
        System.out.println("validated");
        return errors;
    }
}