package nanterre.miage.baptiste.validationform;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import nanterre.miage.baptiste.domain.*;
import nanterre.miage.baptiste.model.Contact;


public class ModifierBDDContactValidationForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	private String idContact = null;
	private String nom = null;
	private String prenom = null;
	private String email = null;
    private String adresse = null;
    private String ville = null;
    private String pays = null;
    private String codepostal = null;
    private String siret = null;
    private int[] idGroup = null;
    private String idPhoneNumber = null;
    private String phoneNumber = null;
    private String phoneKind = null;
    private int version;

    public String getIdPhoneNumber() {
    	return this.idPhoneNumber;
    }
    public String getPhoneKind() {
    	return this.phoneKind;
    }
    public String getPhoneNumber() {
    	return this.phoneNumber;
    }
    public void setIdPhoneNumber(String idPhoneNumber) {
    	this.idPhoneNumber = idPhoneNumber;
    }
    public void setPhoneKind(String phoneKind) {
    	this.phoneKind = phoneKind;
    }
    public void setPhoneNumber(String phoneNumber) {
    	this.phoneNumber = phoneNumber;
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
    public String getVille() {
        return ville;
    }
    public void setVille(String ville) {
        this.ville = ville;
    }
    public String getPays() {
        return pays;
    }
    public void setPays(String pays) {
        this.pays = pays;
    }
    public String getCodepostal() {
        return codepostal;
    }
    public void setCodepostal(String codepostal) {
        this.codepostal = codepostal;
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
        this.ville=null;
        this.pays=null;
        this.codepostal=null;
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
        
        if(!errors.isEmpty()) {/*
        	Contact c = new Contact(Integer.parseInt(getId()),getNom(), getPrenom(), getEmail(), getAdresse(), getVille(), getPays(),getCodepostal());
        	c.setSiret(this.siret);
        	
        	try {
        		c.setIdPhoneNumber(Integer.parseInt(getIdPhoneNumber()));
        	}catch (Exception e) {
        		c.setIdPhoneNumber(-1);
        	}
        	request.setAttribute("contact", c);
        */}
 
        System.out.println("validated");
        return errors;
    }
}
