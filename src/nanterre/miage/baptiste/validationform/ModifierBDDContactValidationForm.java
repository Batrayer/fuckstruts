package nanterre.miage.baptiste.validationform;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class ModifierBDDContactValidationForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	private String idContact = null;
	private String nom = null;
	private String prenom = null;
	private String email = null;
    private String adresse = null;
    private String siret = null;
    private int[] idGroup = null;
    private int[] idTel = null;
    private int version;

    public int[] getIdTel() {
    	return this.idTel;
    }
    public void setIdTel(int[] idTel) {
    	this.idTel= idTel;
    }

    
    public int[] getIdGroup() {
    	return this.idGroup;
    }
    public void setIdGroup(int[] idGroup) {
    	this.idGroup = idGroup;
    }
    
    public String getSiret() {
    	return siret;
    }
    
    public void setSiret(String siret) {
    	this.siret = siret;
    }
    public String getIdContact() {
        return idContact;
    }
    public void setIdContact(String idContact) {
        this.idContact = idContact;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

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
    
    public int getVersion() {
    	return version;
    }
    
    public void setVersion(int version) {
    	this.version = version;
    }

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.email=null;
		this.prenom=null;
		this.nom=null;
        this.adresse=null;
        this.siret=null;
        this.idGroup=null;
        
	}
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request){
	    ActionErrors errors = new ActionErrors();
	    if(getEmail()==null || getEmail().length()<1){
	    	errors.add("email", new ActionMessage("addContact.form.add.error.email"));
        }
        if(getNom()==null || getNom().length()<1){
        	errors.add("nom", new ActionMessage("addContact.form.add.error.nom"));
        }
        if(getPrenom()==null || getPrenom().length()<1){
        	errors.add("prenom", new ActionMessage("addContact.form.add.error.prenom"));
        }
        System.out.println("validated");
        return errors;
    }
}
