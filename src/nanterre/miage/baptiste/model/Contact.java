package nanterre.miage.baptiste.model;

import java.util.HashSet;
import java.util.Set;

public class Contact {
	private int idContact;
	private String nom;
	private String prenom;
	private String email;
	private Adresse adresse;
	private int version;
	private Set<Group> groups;
	
	public Contact() {
		this.groups = new HashSet<Group>();
		this.nom = null;
		this.prenom = null;
		this.email = null;
	}
	
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdContact() {
		return idContact;
	}

	public void setIdContact(int idContact) {
		this.idContact = idContact;
	}
	
	public Adresse getAdresse() {
		return this.adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	public Set<Group> getGroups() {
		return groups;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}
	
	public void addGroups(Group group) {
		this.groups.add(group);
	}

}
