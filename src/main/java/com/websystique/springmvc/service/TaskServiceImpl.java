package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.TaskDao;
import com.websystique.springmvc.model.Task;


@Service("taskService")
@Transactional
public class TaskServiceImpl implements TaskService{

	@Autowired
	private TaskDao dao;

		
	public Task findById(int id) {
		return dao.findById(id);
	}

	public Task findBySSO(String sso) {
		Task task = dao.findBySSO(sso);
		return task;
	}

	
	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateTask(Task task) {
		Task entity = dao.findById(task.getId());
		if(entity!=null){
			entity.setTaskName(task.getTaskName());
			entity.setOwner(task.getOwner());
			entity.setTeam(task.getTeam());
			entity.setStartDate(task.getStartDate());
			entity.setEndDate(task.getEndDate());
			entity.setRevisedDate(task.getRevisedDate());
		}
	}


	@Override
	public void deleteTaskByTaskId(int id) {
		// TODO Auto-generated method stub
		dao.deleteBySSO(id);
	}

	@Override
	public List<Task> findAllTasks() {
		// TODO Auto-generated method stub
		return dao.findAllTasks();
	}

	@Override
	public boolean isTaskSSOUnique(Integer id, String sso) {
		Task task=findBySSO(sso);
		return( task == null || (( id !=null) && (task.getId() == id)));
	}

	@Override
	public void saveTask(Task task) {
		// TODO Auto-generated method stub
		task.setOwner(task.getOwner());
		dao.save(task);
		
	}

	
}

