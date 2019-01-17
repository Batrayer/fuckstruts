package nanterre.miage.baptiste.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nanterre.miage.baptiste.dao.GroupDAO;
import nanterre.miage.baptiste.model.Group;
import nanterre.miage.baptiste.validationform.AddContactGroupValidationForm;

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
	public Set<Group> getAllFromTab(int[] ids) {
		Set<Group> set = new HashSet<Group>();
		for(int i = 0; i<ids.length; i++) {
			set.add(gdao.getGroup(ids[i]));
		}
		return set;
	}
	public void AddGroup(Group group) {
		gdao.addGroup(group);
	}
	public Group getGroupFromId(int id) {
		return gdao.getGroup(id);
	}
	public Group getGroupFromForm(AddContactGroupValidationForm form) {
		Group group = new Group();
		group.setGroupName(form.getNom());
		return group;
	}
}
