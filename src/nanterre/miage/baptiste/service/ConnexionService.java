package nanterre.miage.baptiste.service;

import nanterre.miage.baptiste.dao.UserDAO;
import nanterre.miage.baptiste.model.User;
import nanterre.miage.baptiste.validationform.ConnexionValidationForm;

public class ConnexionService {
	private static final ConnexionService INSTANCE = new ConnexionService();
	private final UserDAO cdao = new UserDAO();
	
	private ConnexionService() {
	}
	
	public boolean checkIdentifiant(ConnexionValidationForm form) {
		User u = new User();
		u.setUsername(form.getUsername());
		u.setPassword(form.getPassword());
		return this.cdao.getConnection(u);
	}
	
    public static ConnexionService getInstance() {
        return INSTANCE;
    }
	
}
