package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.Task;

public interface TaskDao {

	Task findById(int id);
	
	Task findBySSO(String sso);
	
	void save(Task task);
	
	void deleteBySSO(int sso);
	
	List<Task> findAllTasks();

}
