package nanterre.miage.baptiste.service;

import java.util.List;

import nanterre.miage.baptiste.dao.GroupDAO;
import nanterre.miage.baptiste.model.Group;

public class GroupService {
	private static final GroupService INSTANCE = new GroupService();
	private final GroupDAO gdao;
	private GroupService() {
		gdao = new GroupDAO();
	}
	
	public static GroupService getInstance() {
		return INSTANCE;
	}
	
	public List<Group> getAllGroup() {
		return gdao.getAllGroup();
	}
}
