package nanterre.miage.baptiste.validationform;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import java.util.List;
import java.util.regex.Pattern;

public class AddContactValidationForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	private String nom = null;
	private String prenom = null;
	private String email = null;
    public String adresse = null;
    public String siret = null;
    public String idGroup = null;
    public String phoneNumber = null;
    public String phoneKind = null;
    
    public String getPhoneKind() {
    	return this.phoneKind;
    }
    public void setPhoneKind(String phoneKind) {
    	this.phoneKind = phoneKind;
    }
    
    public String getPhoneNumber() {
    	return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
    	this.phoneNumber = phoneNumber;
    }
    
    public String getIdGroup() {
    	return this.idGroup;
    }
    public void setIdGroup(String idGroup) {
    	this.idGroup = idGroup;
    }
    
    public String getSiret() {
    	return siret;
    }
    
    public void setSiret(String siret) {
    	this.siret = siret;
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

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.email=null;
		this.prenom=null;
		this.nom=null;
        this.adresse=null;
        this.idGroup=null;
        this.siret=null;
        this.phoneKind=null;
        this.phoneNumber=null;
	}
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request){
	    ActionErrors errors = new ActionErrors();
	    String regexmail = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
	    // String regexnumber = "[0-9]+";
	    if(getEmail()==null || getEmail().length()<1 || !Pattern.matches(regexmail, getEmail())){
	        errors.add("email", new ActionMessage("addContact.form.add.error.email"));
        }
        if(getNom()==null || getNom().length()<1){
            errors.add("nom", new ActionMessage("addContact.form.add.error.nom"));
        }
        if(getPrenom()==null || getPrenom().length()<1){
            errors.add("prenom", new ActionMessage("addContact.form.add.error.prenom"));
        }/*
        if(getPhoneNumber().length()==0 || getPhoneNumber()==null) {
        	if(Pattern.matches(regexnumber,getPhoneNumber())||(getPhoneNumber().length()<9)||getPhoneNumber().length()>10) {
        		errors.add("prenom", new ActionMessage("addContact.form.add.error.phoneNumber"));
        	}
		}
        if(!errors.isEmpty()) {
        	ContactGroupDAO daocg = new ContactGroupDAO();
        	List<ContactGroup> cgrp = daocg.getAllContactGroup();
        	request.setAttribute("cgrp", cgrp);
        	EntrepriseDAO entDAO = new EntrepriseDAO();
        	List<Entreprise> ent = entDAO.getAllEntreprise();
        	request.setAttribute("ent", ent);
        }*/
        System.out.println("validated");
        return errors;
    }
}
