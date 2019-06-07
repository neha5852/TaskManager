package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Project;
import com.websystique.springmvc.model.ProjectChecking;


public interface ProjectService {
	
	Project findById(int id);
	
	Project findBySSO(String sso);
	
	void saveUser(Project project);
	
	void updateProject(Project project);
	
	void updateProject1(ProjectChecking project);
	
	void updateProject2(ProjectChecking project);
	
	void deleteProjectBySSO(int sso);

	List<Project> findAllProjects(); 
	
	List<ProjectChecking> findAllProjects1(); 
	
	boolean isProjectSSOUnique(Integer id, String sso);

}