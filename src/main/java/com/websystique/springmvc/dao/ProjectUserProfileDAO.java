package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.ProjectUserProfile;

public interface ProjectUserProfileDAO {
	
    List<ProjectUserProfile> findAll();
	
    ProjectUserProfile findByType(String type);
	
    ProjectUserProfile findById(int id);

}
