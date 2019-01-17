package nanterre.miage.baptiste.validationform;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import java.util.List;

public class AddContactGroupValidationForm extends ActionForm{
	private static final long serialVersionUID = 1L;
	private String nom = null;

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.nom=null;
	}
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request){
	    ActionErrors errors = new ActionErrors();
	    
        System.out.println("validated");
        return errors;
    }
}