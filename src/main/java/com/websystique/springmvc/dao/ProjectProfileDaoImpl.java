package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.ProjectProfile;



@Repository("projectProfileDao")
public class ProjectProfileDaoImpl extends AbstractDao<Integer, ProjectProfile , ProjectProfile >implements ProjectProfileDao{

	public ProjectProfile findById(int id) {
		return getByKey(id);
	}

	public ProjectProfile findByType(String type) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("type", type));
		return (ProjectProfile) crit.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<ProjectProfile> findAll(){
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.asc("type"));
		return (List<ProjectProfile>)crit.list();
	}
	
}
