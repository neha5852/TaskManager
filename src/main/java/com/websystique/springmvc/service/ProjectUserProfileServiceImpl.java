package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.ProjectUserProfileDAO;
import com.websystique.springmvc.model.ProjectUserProfile;

@Service("projectUserProfileService")
@Transactional
public class ProjectUserProfileServiceImpl implements ProjectUserProfileService {

	ProjectUserProfileDAO dao;
	
	@Override
	public ProjectUserProfile findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public ProjectUserProfile findByType(String sso) {
		// TODO Auto-generated method stub
		return dao.findByType(sso);
	}

	@Override
	public List<ProjectUserProfile> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
