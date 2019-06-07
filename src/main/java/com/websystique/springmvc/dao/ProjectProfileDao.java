package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.ProjectProfile;


public interface ProjectProfileDao {

	List<ProjectProfile> findAll();
	
	ProjectProfile findByType(String type);
	
	ProjectProfile findById(int id);
}
