package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.Project;
import com.websystique.springmvc.model.ProjectChecking;

public interface ProjectDao {

	Project findById(int id);
	
	ProjectChecking findById1(int id);
	
	Project findBySSO(String sso);
	
	void save(Project project);
	
	void save(ProjectChecking project);
	
	void deleteBySSO(int sso);
	
	List<Project> findAllProjects();
	
	List<ProjectChecking> findAllProjects1();

}
