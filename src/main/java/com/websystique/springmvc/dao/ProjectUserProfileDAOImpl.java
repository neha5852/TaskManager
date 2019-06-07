package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.websystique.springmvc.model.ProjectUserProfile;

@Repository("ProjectUserProfileDAO")
public class ProjectUserProfileDAOImpl extends AbstractDao<Integer, ProjectUserProfile , ProjectUserProfile >implements ProjectUserProfileDAO {

	@Override
	public List<ProjectUserProfile> findAll() {
		// TODO Auto-generated method stub
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.asc("ssoId"));
		return (List<ProjectUserProfile>)crit.list();
	}

	@Override
	public ProjectUserProfile findByType(String ssoId) {
		// TODO Auto-generated method stub
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("ssoId", ssoId));
		return (ProjectUserProfile) crit.uniqueResult();
	}

	@Override
	public ProjectUserProfile findById(int id) {
		// TODO Auto-generated method stub
		return getByKey(id);
	}

}
