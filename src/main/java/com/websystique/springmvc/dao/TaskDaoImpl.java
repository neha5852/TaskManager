package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Task;



@Repository("/taskDao")
public class TaskDaoImpl extends AbstractDao<Integer, Task , Task> implements TaskDao {

	static final Logger logger = LoggerFactory.getLogger(TaskDaoImpl.class);
	
	public Task findById(int id) {
		Task task = getByKey(id);
		if(task!=null){
			Hibernate.initialize(task.gettaskProfiles());
		}
		return task;
	}

	public Task findBySSO(String sso) {
		logger.info("SSO : {}", sso);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("owner", sso));
		Task task = (Task)crit.uniqueResult();
		if(task!=null){
			Hibernate.initialize(task.gettaskProfiles());
		}
		return task;
	}

	@SuppressWarnings("unchecked")
	public List<Task> findAllTasks() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("taskName"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Task> tasks = (List<Task>) criteria.list();
		
		// No need to fetch userProfiles since we are not showing them on list page. Let them lazy load. 
		// Uncomment below lines for eagerly fetching of userProfiles if you want.
		/*
		for(Task task : tasks){
			Hibernate.initialize(task.gettaskProfiles());
		}*/
		return tasks;
	}

	public void save(Task tasks) {
		persist(tasks);
	}

	public void deleteBySSO(int sso) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", sso));
		Task tasks = (Task)crit.uniqueResult();
		delete(tasks);
	}

}

