package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.ProjectDao;
import com.websystique.springmvc.model.Project;
import com.websystique.springmvc.model.ProjectChecking;


@Service("projectService")
@Transactional
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	private ProjectDao dao;

		
	public Project findById(int id) {
		return dao.findById(id);
	}

	public Project findBySSO(String sso) {
		Project project = dao.findBySSO(sso);
		return project;
	}

	@Override
	public void saveUser(Project project) {
		// TODO Auto-generated method stub
		project.setOwner(project.getOwner());
		dao.save(project);
		
	}
	
	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateProject(Project project) {
		System.out.println("this is id: "+ project.getId());
		Project entity = dao.findById(project.getId());
		if(entity!=null){
			
			entity.setProjectName(project.getProjectName());
			entity.setProjectDescription(project.getProjectDescription());
			entity.setOwner(project.getOwner());
			entity.setTeam(project.getTeam());
			entity.setStartDate(project.getStartDate());
			entity.setEndDate(project.getEndDate());
			entity.setProjectProfiles(project.getProjectProfiles());
			entity.setActualEfforts(project.getActualEfforts());
			entity.setQa(project.getQa());
			entity.setPost(project.getPost());
	        entity.setUat(project.getUat());
		}
	}

	
	public void deleteProjectBySSO(int sso) {
		dao.deleteBySSO(sso);
	}

	public List<Project> findAllProjects() {
		return dao.findAllProjects();
	}

	public boolean isProjectSSOUnique(Integer id, String sso) {
		System.out.println("checking...");
		Project project = findBySSO(sso);
		return ( project == null || ((id != null) && (project.getId() == id)));
	}

	@Override
	public void updateProject1(ProjectChecking project) {
		// TODO Auto-generated method stub
		ProjectChecking entity = dao.findById1(project.getId());
		System.out.println("this is id:" + entity);
		if(entity!=null){
			entity.setProjectName(project.getProjectName());
			entity.setProjectDescription(project.getProjectDescription());
			entity.setOwner(project.getOwner());
			entity.setTeam(project.getTeam());
			entity.setStartDate(project.getStartDate());
			entity.setEndDate(project.getEndDate());
			entity.setProjectProfiles(project.getProjectProfiles());
			entity.setQa(project.getQa());
			entity.setUat(project.getUat());
			entity.setPost(project.getPost());
	}

	}

	@Override
	public void updateProject2(ProjectChecking project) {
		// TODO Auto-generated method stub
		ProjectChecking entity = dao.findById1(project.getId());
		System.out.println("this is id:" + entity);
		if(entity!=null){
			entity.setProjectName(project.getProjectName());
			entity.setProjectDescription(project.getProjectDescription());
			entity.setOwner(project.getOwner());
			entity.setTeam(project.getTeam());
			entity.setStartDate(project.getStartDate());
			entity.setEndDate(project.getEndDate());
			entity.setProjectProfiles(project.getProjectProfiles());
            entity.setActualEfforts(project.getActualEfforts());
	}
	}

	@Override
	public List<ProjectChecking> findAllProjects1() {
		// TODO Auto-generated method stub
		return dao.findAllProjects1();
	}
}
