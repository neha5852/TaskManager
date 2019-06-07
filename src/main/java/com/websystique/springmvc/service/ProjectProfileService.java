package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.ProjectProfile;


public interface ProjectProfileService {

	ProjectProfile findById(int id);

	ProjectProfile findByType(String type);
	
	List<ProjectProfile> findAll();
	
}
