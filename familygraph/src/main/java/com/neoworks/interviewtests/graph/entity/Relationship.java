package com.neoworks.interviewtests.graph.entity;

public class Relationship {
	private String primaryEmail;
	private Integer relationshipType;
	private String email;

	public Relationship() {
	}

	public Relationship(Integer relationshipType, String email) {
		this.relationshipType = relationshipType;
		this.email = email;
	}

	public String getPrimaryEmail() {
		return primaryEmail;
	}

	public void setPrimaryEmail(String primaryEmail) {
		this.primaryEmail = primaryEmail;
	}

	public Integer getRelationshipType() {
		return relationshipType;
	}

	public void setRelationshipType(Integer relationshipType) {
		this.relationshipType = relationshipType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
