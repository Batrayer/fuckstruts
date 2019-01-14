package nanterre.miage.baptiste.service;

import nanterre.miage.baptiste.dao.AdresseDAO;
import nanterre.miage.baptiste.model.Adresse;

public class AdresseService {
	private static final AdresseService INSTANCE = new AdresseService();
	private final AdresseDAO adao;
	private AdresseService() {
		this.adao = new AdresseDAO();
	}
	public Adresse getOrCreate(String adresse) {
		Adresse adr = adao.getByAdresse(adresse);
		if (adr == null) {
			adr = new Adresse();
			adr.setAdresse(adresse);
			adr = adao.addAdresse(adr);
		}
		return adr;
	}
	public static AdresseService getInstance() {
		return INSTANCE;
	}
}
