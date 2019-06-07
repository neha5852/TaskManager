package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.ProjectUserProfile;

public interface ProjectUserProfileService {
	
	ProjectUserProfile findById(int id);

	ProjectUserProfile findByType(String sso);
	
	List<ProjectUserProfile> findAll();

}
