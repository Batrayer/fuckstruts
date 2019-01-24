package nanterre.miage.baptiste.service;

import nanterre.miage.baptiste.dao.AdresseDAO;
import nanterre.miage.baptiste.model.Adresse;

public class AdresseService {
	private AdresseDAO adao;

	public Adresse getOrCreate(String adresse) {
		if(adresse != null && !"".equals(adresse)) {
			Adresse adr = adao.getByAdresse(adresse);
			if (adr == null) {
				adr = new Adresse();
				adr.setAdresse(adresse);
				adr = adao.addAdresse(adr);
			}
			return adr;	
		}
		return null;
	}
	
	public Adresse create(Adresse adresse) {
		if(adresse.getAdresse() != null && !"".equals(adresse.getAdresse())) {
			Adresse adr = adao.getByAdresse(adresse.getAdresse());
			if (adr == null) {
				adr = adao.addAdresse(adresse);
				adr = adao.addAdresse(adr);
			} else {
				adao.deleteAdresse(adr);
				adr = adao.addAdresse(adresse);
			}
			return adr;	
		}
		return null;
	}
	public void setAdao(AdresseDAO adao) {
		this.adao = adao;
	}
}
