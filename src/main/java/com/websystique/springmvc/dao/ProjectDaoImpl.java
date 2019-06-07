package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Project;
import com.websystique.springmvc.model.ProjectChecking;



@Repository("projectDao")
public class ProjectDaoImpl extends AbstractDao<Integer, Project, ProjectChecking> implements ProjectDao {

	static final Logger logger = LoggerFactory.getLogger(ProjectDaoImpl.class);
	
	public Project findById(int id) {
		Project project = getByKey(id);
		if(project!=null){
			Hibernate.initialize(project.getProjectProfiles());
		}
		return project;
	}

	public Project findBySSO(String sso) {
		logger.info("SSO : {}", sso);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("owner", sso));
		Project project = (Project)crit.uniqueResult();
		if(project!=null){
			Hibernate.initialize(project.getProjectProfiles());
		}
		return project;
	}

	@SuppressWarnings("unchecked")
	public List<Project> findAllProjects() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("projectName"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Project> projects = (List<Project>) criteria.list();
		
		// No need to fetch userProfiles since we are not showing them on list page. Let them lazy load. 
		// Uncomment below lines for eagerly fetching of userProfiles if you want.
		
		for(Project project : projects){
			Hibernate.initialize(project.getProjectProfiles());
		}
		return projects;
	}

	public void save(Project project) {
		persist(project);
	}

	public void deleteBySSO(int sso) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", sso));
		Project project = (Project)crit.uniqueResult();
		delete(project);
	}

	public void save(ProjectChecking project) {
		// TODO Auto-generated method stub
		   persist1(project);
		
	}

	@Override
	public ProjectChecking findById1(int id) {
		ProjectChecking project = getByKey1(id);
		if(project!=null){
			Hibernate.initialize(project.getProjectProfiles());
		}
		return project;
	}

	@Override
	public List<ProjectChecking> findAllProjects1() {
		// TODO Auto-generated method stub
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("projectName"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<ProjectChecking> projects = (List<ProjectChecking>) criteria.list();
		
		// No need to fetch userProfiles since we are not showing them on list page. Let them lazy load. 
		// Uncomment below lines for eagerly fetching of userProfiles if you want.
		
		for(ProjectChecking project : projects){
			Hibernate.initialize(project.getProjectProfiles());
		}
		return projects;
	}



}
