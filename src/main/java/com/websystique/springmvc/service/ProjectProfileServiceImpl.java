package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.ProjectProfileDao;
import com.websystique.springmvc.model.ProjectProfile;


@Service("projectProfileService")
@Transactional
public class ProjectProfileServiceImpl implements ProjectProfileService{
	
	@Autowired
	ProjectProfileDao dao;
	
	public ProjectProfile findById(int id) {
		return dao.findById(id);
	}

	public ProjectProfile findByType(String type){
		return dao.findByType(type);
	}

	public List<ProjectProfile> findAll() {
		return dao.findAll();
	}
}
