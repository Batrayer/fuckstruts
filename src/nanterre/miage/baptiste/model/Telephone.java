package nanterre.miage.baptiste.model;

public class Telephone {
	private int idTelephone;
	private String telephone;
	private Contact contact;
	
	private int version;
	
	public Telephone() {
	}
	
	public int getIdTelephone() {
		return idTelephone;
	}
	public String getTelephone() {
		return telephone;
	}
	public int getVersion() {
		return version;
	}
	public void setIdTelephone(int idTelephone) {
		this.idTelephone = idTelephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public Contact getContact() {
		return this.contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}

}
