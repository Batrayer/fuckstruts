package nanterre.miage.baptiste.model;

public class Adresse {
	private int idAdresse;
	private String adresse;
	private int version;
	
	public String getAdresse() {
		return adresse;
	}
	public int getIdAdresse() {
		return idAdresse;
	}
	public int getVersion() {
		return version;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public void setIdAdresse(int idAdresse) {
		this.idAdresse = idAdresse;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
}
