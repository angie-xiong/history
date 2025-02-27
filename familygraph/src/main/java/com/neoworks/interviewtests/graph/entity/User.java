package com.neoworks.interviewtests.graph.entity;

import java.util.List;

public class User {
	private String userName;
	private String email;
	private Integer age;
	private List<Relationship> relationships;
	private List<Relationship> familyMembers;
	private List<Relationship> friends;

	public User() {
	}

	public User(String userName, String email, Integer age) {
		this.userName = userName;
		this.email = email;
		this.age = age;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<Relationship> getRelationships() {
		return relationships;
	}

	public void setRelationships(List<Relationship> relationships) {
		this.relationships = relationships;
	}

	public List<Relationship> getFamilyMembers() {
		return familyMembers;
	}

	public void setFamilyMembers(List<Relationship> familyMembers) {
		this.familyMembers = familyMembers;
	}

	public List<Relationship> getFriends() {
		return friends;
	}

	public void setFriends(List<Relationship> friends) {
		this.friends = friends;
	}
}
