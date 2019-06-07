package com.websystique.springmvc.model;

import java.io.Serializable;

public enum ProjectProfileType implements Serializable{
	USER("USER"),
	DBA("DBA"),
	ADMIN("ADMIN");
	
	String projectProfileType;
	
	private ProjectProfileType(String projectProfileType){
		this.projectProfileType = projectProfileType;
	}
	
	public String getProjectProfileType(){
		return projectProfileType;
	}
	
}
