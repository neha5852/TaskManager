package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Task;


public interface TaskService {
	
   Task findById(int id);
	
   Task findBySSO(String sso);
   
   void saveTask(Task task);
   
	void updateTask(Task task);
	
	void deleteTaskByTaskId(int id);

	List<Task> findAllTasks();
	
	boolean isTaskSSOUnique(Integer id, String sso);
}
