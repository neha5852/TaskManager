package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.UserProfile;


public interface UserProfileDao {

	List<UserProfile> findAll();
	
	List<UserProfile> findAllUsers();
	
	UserProfile findByType(String type);
	
	UserProfile findById(int id);
}
