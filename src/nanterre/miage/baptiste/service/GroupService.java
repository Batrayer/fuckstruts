package nanterre.miage.baptiste.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nanterre.miage.baptiste.dao.GroupDAO;
import nanterre.miage.baptiste.model.Group;
import nanterre.miage.baptiste.validationform.AddContactGroupValidationForm;

public class GroupService {
	private GroupDAO gdao;
	private GroupService(GroupDAO gdao) {
		this.gdao = gdao;
	}
	
	public List<Group> getAllGroup() {
		return gdao.getAllGroup();
	}
	public Set<Group> getAllFromTab(int[] ids) {
		Set<Group> set = new HashSet<Group>();
		if(ids != null) {
			if(ids[0] != 0) {
				for(int i = 0; i<ids.length; i++) {
					System.out.println("Add group: " + ids[i]);
					set.add(gdao.getGroup(ids[i]));
				}
			}

		}
		return set;
	}
	public Group addGroup(Group group) {
		return gdao.addGroup(group);
	}
	
	public Group addGroupIfNameNotExist(Group group) {
		Group grp = gdao.getGroupByName(group.getGroupName()); 
		if (grp == null) {
			return this.addGroup(group);
		}
		return grp;
		
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
