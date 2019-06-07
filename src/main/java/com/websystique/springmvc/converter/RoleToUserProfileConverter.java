package com.websystique.springmvc.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.websystique.springmvc.model.ProjectProfile;
import com.websystique.springmvc.service.ProjectProfileService;

/**
 * A converter class used in views to map id's to actual userProfile objects.
 */
@Component
public class RoleToUserProfileConverter implements Converter<Object, ProjectProfile>{

	static final Logger logger = LoggerFactory.getLogger(RoleToProjectProfileConverter.class);
	
	@Autowired
	ProjectProfileService projectProfileService;

	/**
	 * Gets UserProfile by Id
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	public ProjectProfile convert(Object element) {
		Integer id = Integer.parseInt((String)element);
		ProjectProfile profile= projectProfileService.findById(id);
		logger.info("Profile : {}",profile);
		return profile;
	}
	
}