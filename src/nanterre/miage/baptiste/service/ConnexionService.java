package nanterre.miage.baptiste.service;

import nanterre.miage.baptiste.dao.UserDAO;
import nanterre.miage.baptiste.model.User;
import nanterre.miage.baptiste.validationform.ConnexionValidationForm;

public class ConnexionService {
	private UserDAO udao;
	
	private ConnexionService(UserDAO udao) {
		this.udao = udao;
	}
	
	public boolean checkIdentifiant(ConnexionValidationForm form) {
		User u = new User();
		u.setUsername(form.getUsername());
		u.setPassword(form.getPassword());
		return this.udao.getConnection(u);
	}
	
	public void setUdao(UserDAO udao) {
		this.udao = udao;
	}
	
}
