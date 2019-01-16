package nanterre.miage.baptiste.validationform;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;


public class RechercheContactValidationForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	private String nom = null;
	private String prenom = null;
	private String email = null;
	private String siret = null;
    

	public String getEmail() {
		return email;
	}

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setEmail(String email) {
		this.email = email;
	}
    
    public String getSiret() {
		return siret;
	}
    
    public void setSiret(String siret) {
		this.siret = siret;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.email=null;
		this.prenom=null;
		this.nom=null;
	}
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request){
	    ActionErrors errors = new ActionErrors();
 
        System.out.println("validated");
        return errors;
    }
}
