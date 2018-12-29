package nanterre.miage.baptiste.model;

public class Entreprise extends Contact{
	private String siret;

	public String getSiret(){
		return siret;
	}

	public void setSiret(String siret){
		this.siret = siret;
	}
	public Entreprise() {
		super();
	}
}