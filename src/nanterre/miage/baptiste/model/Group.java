package nanterre.miage.baptiste.model;

import java.util.HashSet;
import java.util.Set;

public class Group {
	private int idGroup;
	private String groupName;
	private Set<Contact> contacts;
	private int version;
	
	
	public Group() {
		this.contacts = new HashSet<Contact>();
	}
	
	public String getGroupName() {
		return groupName;
	}
	public int getIdGroup() {
		return idGroup;
	}
	public Set<Contact> getContacts() {
		return contacts;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public void setIdGroup(int idGroup) {
		this.idGroup = idGroup;
	}
	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
}
