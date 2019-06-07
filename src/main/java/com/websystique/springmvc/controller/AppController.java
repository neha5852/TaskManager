package com.websystique.springmvc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.websystique.springmvc.model.ProjectChecking;
import com.websystique.springmvc.model.ProjectReport;
import com.websystique.springmvc.model.Task;
import com.websystique.springmvc.model.User;
import com.websystique.springmvc.model.UserProfile;
import com.websystique.springmvc.model.Project;
import com.websystique.springmvc.model.ProjectProfile;
import com.websystique.springmvc.service.TaskService;
import com.websystique.springmvc.service.UserProfileService;
import com.websystique.springmvc.service.UserService;
import com.websystique.springmvc.service.ProjectProfileService;
import com.websystique.springmvc.service.ProjectService;



@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class AppController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserProfileService userProfileService;
	
	@Autowired
	ProjectService projectService;
	
	@Autowired
	TaskService taskService;
	
	@Autowired
	ProjectProfileService projectProfileService;
	
	@Autowired
	MessageSource messageSource;

	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;
	
	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;
	
	String sso="sam";
	
	
	
	/**
	 * This method will list all existing users.
	 */
	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public String listOptions(ModelMap model) {
		List<Project> projects = projectService.findAllProjects();
		model.addAttribute("projects", projects);
		model.addAttribute("loggedinuser", getPrincipal());
		List<User> users = userService.findAllUsers();
		model.addAttribute("users", users);
		List<Task> tasks = taskService.findAllTasks();
		model.addAttribute("tasks", tasks);
		
		Task t = null;
		int i=0;
		int k =0;
		List<Task> task = new ArrayList<>();
		while (i<tasks.size())
		{
		t=tasks.get(i);
		model.addAttribute("loggedinuser", getPrincipal());
		if(getPrincipal().equalsIgnoreCase(t.getOwner()))
		{
	    task.add(t);
		model.addAttribute("tasks", task);
	    k = Integer.parseInt(t.getPid());
		}
		i = i+1;
		}
		
		List<Project> project1 = projectService.findAllProjects();
		//System.out.println("available projects " + project1);
		Project pro = null;
		List<Project> proj = new ArrayList<>();

		for (int o = 0; o< project1.size(); o++)
		{
			pro = project1.get(o);
			int l = pro.getId();
			System.out.println("values are : " +k);
			if (k == l)
			{
			proj.add(pro);
			model.addAttribute("projects", projects);
		}
	    }
		System.out.println(" checking project " + proj);
		
		
		
		return "home";
	}
	
	
	@RequestMapping(value = {"/list" }, method = RequestMethod.GET)
	public String listUsers(ModelMap model) {

		List<User> users = userService.findAllUsers();
		model.addAttribute("users", users);
		model.addAttribute("loggedinuser", getPrincipal());
		return "userslist";
	}
	
	/**
	 * This method will list all existing projects.
	 */
	@RequestMapping(value = { "/projectlist" }, method = RequestMethod.GET)
	public String listProjects(ModelMap model) {

		List<Project> projects = projectService.findAllProjects();
		System.out.println("this is list of projects " + projects);
		model.addAttribute("projects", projects);
		System.out.println("checking : "+model.addAttribute("projects", projects));
		model.addAttribute("loggedinuser", getPrincipal());
		return "projectlist";
	}
	
	/**
	 * This method will list all existing projects.
	 */
	@RequestMapping(value = { "/qaprojectlist" }, method = RequestMethod.GET)
	public String listProjects1(ModelMap model) {

		List<Project> projects = projectService.findAllProjects();
		System.out.println("this is list of projects " + projects);
		model.addAttribute("projects", projects);
		System.out.println("checking : "+model.addAttribute("projects", projects));
		model.addAttribute("loggedinuser", getPrincipal());
		return "qaProjectView";
	}
	
	@RequestMapping(value = { "/projectreport" }, method = RequestMethod.GET)
	public String reportProjects(ModelMap model) {

		List<Project> projects = projectService.findAllProjects();
		System.out.println("this is list of projects " + projects);
		model.addAttribute("projects", projects);
		System.out.println("checking : "+model.addAttribute("projects", projects));
		model.addAttribute("loggedinuser", getPrincipal());
		return "projectReport";
	}
	
	
	@RequestMapping(value = { "/tasklist1" }, method = RequestMethod.GET)
	public String listtasks1(ModelMap model) {
		List<Project> project1 = projectService.findAllProjects();
		System.out.println("available projects " + project1);
		Project pro = null;
		List<Project> proj = new ArrayList<>();

		
		List<Task> projects = taskService.findAllTasks();
		Task t = null;
		int i=0;
		int k =0;
		List<Task> task = new ArrayList<>();
		
		
		for (int o = 0; o< project1.size(); o++)
		{
			pro = project1.get(o);
			int l = pro.getId();
			t = projects.get(o);
			k = Integer.parseInt(t.getPid());
	  	System.out.println("values are : " +k +l);
			if (k == l)
			{
			//proj.add(pro);
				//while (i<projects.size())
			//	{
				t=projects.get(o);
				System.out.println("task are "+t);
			    task.add(t);
			  //  k = Integer.parseInt(t.getPid());
		}
	    }
		model.addAttribute("tasks", task);
		System.out.println(" checking project " + proj);
		model.addAttribute("loggedinuser", getPrincipal());
		
		
		return "adminTaskList";
	}

	
	/**
	 * This method will list all existing tasks.
	 */
	@RequestMapping(value = { "/tasklist" }, method = RequestMethod.GET)
	public String listtasks(ModelMap model) {

		List<Task> projects = taskService.findAllTasks();
		Task t = null;
		int i=0;
		int k =0;
		List<Task> task = new ArrayList<>();
		while (i<projects.size())
		{
		t=projects.get(i);
		model.addAttribute("loggedinuser", getPrincipal());
		if(getPrincipal().equalsIgnoreCase(t.getOwner()))
		{
	    task.add(t);
		model.addAttribute("tasks", task);
	    k = Integer.parseInt(t.getPid());
		}
		i = i+1;
		}
		
		List<Project> project1 = projectService.findAllProjects();
		//System.out.println("available projects " + project1);
		Project pro = null;
		List<Project> proj = new ArrayList<>();

		for (int o = 0; o< project1.size(); o++)
		{
			pro = project1.get(o);
			int l = pro.getId();
			System.out.println("values are : " +k);
			if (k == l)
			{
			proj.add(pro);
			model.addAttribute("projects", projects);
		}
	    }
		System.out.println(" checking project " + proj);
		
		return "tasklist";
	}

	
	/**
	 * This method will provide the medium to add a new user.
	 */
	@RequestMapping(value = { "/newuser" }, method = RequestMethod.GET)
	public String newUser(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		return "registration";
	}
	
	/**
	 * This method will provide the medium to add a new project.
	 */
	
	@RequestMapping(value = { "/newproject" }, method = RequestMethod.GET)
	public String newProject(ModelMap model) {
		Project project = new Project();
		model.addAttribute("project", project);
		System.out.println("this is project:"+project);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		return "projectregistration";
	}
	
	@RequestMapping(value = { "/newtask" }, method = RequestMethod.GET)
	public String newtask(ModelMap model) {
		Task task = new Task();
		model.addAttribute("task", task);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		return "newtask";
	}
	
	
	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/newuser" }, method = RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "registration";
		}
		
		
		/*
		 * Preferred way to achieve uniqueness of field [sso] should be implementing custom @Unique annotation 
		 * and applying it on field [sso] of Model class [User].
		 * 
		 * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
		 * framework as well while still using internationalized messages.
		 * 
		 */
		if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
			FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registration";
		}
		
		userService.saveUser(user);

		model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " registered successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		//return "success";
		return "registrationsuccess";
	}


	/**
	 * This method will be called on form submission, handling POST request for
	 * saving project in database. It also validates the project input
	 */
	
	@RequestMapping(value = { "/newproject" }, method = RequestMethod.POST)
	public String saveProject(@Valid Project project, BindingResult result,
			ModelMap model) {
        System.out.println("this is result:"+project);
		if (result.hasErrors()) {
			System.out.println("not working");
			return "projectregistration";
		}
		/*
		 * Preferred way to achieve uniqueness of field [sso] should be implementing custom @Unique annotation 
		 * and applying it on field [sso] of Model class [User].
		 * 
		 * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
		 * framework as well while still using internationalized messages.
		 * 
		 */
		if(!projectService.isProjectSSOUnique(project.getId(), project.getOwner())){
			FieldError ssoError =new FieldError("project","owner",messageSource.getMessage("non.unique.ssoId", new String[]{project.getOwner()}, Locale.getDefault()));
		    result.addError(ssoError);
		    System.out.println("working");
			return "projectregistration";
		}
		
		//projectService.updateProject(project);
		projectService.saveUser(project);

		model.addAttribute("success", "Project " + project.getProjectName() +" registered successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		//return "success";
		System.out.println("Done");
		return "projectregistrationsuccess";
	}
	
	@RequestMapping(value = { "/newtask" }, method = RequestMethod.POST)
	public String saveProject(@Valid Task task, BindingResult result,
			ModelMap model) {
		System.out.println("result is:"+result);

		if (result.hasErrors()) {
			return "newtask";
		}
		/*
		 * Preferred way to achieve uniqueness of field [sso] should be implementing custom @Unique annotation 
		 * and applying it on field [sso] of Model class [User].
		 * 
		 * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
		 * framework as well while still using internationalized messages.
		 * 
		 */
		if(!taskService.isTaskSSOUnique(task.getId(), task.getOwner())){
			FieldError ssoError =new FieldError("project","owner",messageSource.getMessage("non.unique.ssoId", new String[]{task.getOwner()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "newtask";
		}
		
		taskService.saveTask(task);

		model.addAttribute("success", "Project " + task.getTaskName() +" registered successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		//return "success";
		return "registrationsuccess";
	}

	/**
	 * This method will provide the medium to update an existing user.
	 */
	@RequestMapping(value = { "/edit-user-{ssoId}" }, method = RequestMethod.GET)
	public String editUser(@PathVariable String ssoId, ModelMap model) {
		User user = userService.findBySSO(ssoId);
		model.addAttribute("user", user);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "registration";
	}
	
	/**
	 * This method will be called on form submission, handling POST request for
	 * updating user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-user-{ssoId}" }, method = RequestMethod.POST)
	public String updateUser(@Valid User user, BindingResult result,
			ModelMap model, @PathVariable String ssoId) {

		if (result.hasErrors()) {
			return "registration";
		}

		/*//Uncomment below 'if block' if you WANT TO ALLOW UPDATING SSO_ID in UI which is a unique key to a User.
		if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
			FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registration";
		}*/


		userService.updateUser(user);

		model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " updated successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "registrationsuccess";
	}
	
	
	
	/**
	 * This method will provide the medium to update an existing project.
	 */
	@RequestMapping(value = { "/edit-project-{projectId}" }, method = RequestMethod.GET)
	public String editProject(@PathVariable int projectId, ModelMap model) {
		Project project = projectService.findById(projectId);
		System.out.println("testing: " + project);
		model.addAttribute("project", project);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "projectregistration";
	}
	
	/**
	 * This method will be called on form submission, handling POST request for
	 * updating project in database. It also validates the projecct input
	 */
	@RequestMapping(value = { "/edit-project-{projectId}" }, method = RequestMethod.POST)
	public String updateProject(@Valid Project project, BindingResult result,
			ModelMap model, @PathVariable int projectId) {
        System.out.println("result is:" +result);
		if (result.hasErrors()) {
			return "projectregistration";
		}

		/*//Uncomment below 'if block' if you WANT TO ALLOW UPDATING SSO_ID in UI which is a unique key to a User.
		if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
			FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registration";
		}*/


		projectService.updateProject(project);

		model.addAttribute("success", "Project " + project.getProjectName() + " updated successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "projectregistrationsuccess";
	}

	
	
	
	@RequestMapping(value = { "/update-project-{projectId}" }, method = RequestMethod.GET)
	public String editProject1(@PathVariable int projectId, ModelMap model) {
		Project project = projectService.findById(projectId);
		model.addAttribute("project", project);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "qaProjectUpdate";
	}
	
	/**
	 * This method will provide the medium to update an existing project.
	 */
	@RequestMapping(value = { "/edit-task-{projectId}" }, method = RequestMethod.GET)
	public String editTask(@PathVariable int projectId, ModelMap model) {
		Task task = taskService.findById(projectId);
		model.addAttribute("task", task);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "newtask";
	}
	
	@RequestMapping(value = { "/update-task-{id}" }, method = RequestMethod.GET)
	public String editTask1(@PathVariable int id, ModelMap model) {
		System.out.println("checking:" + id);
		Task task = taskService.findById(id);
		model.addAttribute("task", task);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "userUpdate1";
	}
	
	

	
	
	@RequestMapping(value = { "/update-task-{id}" }, method = RequestMethod.POST)
	public String updatetask1(@Valid Task task, BindingResult result,
			ModelMap model, @PathVariable int id) {
     //   System.out.println("result is:" +result);
		if (result.hasErrors()) {
			return "userUpdate1";
		}

		/*//Uncomment below 'if block' if you WANT TO ALLOW UPDATING SSO_ID in UI which is a unique key to a User.
		if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
			FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registration";
		}*/


		taskService.updateTask(task);

		model.addAttribute("success", "Task " + task.getTaskName() + " updated successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "tasklist";
	}
	
	@RequestMapping(value = { "/update-project-{projectId}" }, method = RequestMethod.POST)
	public String updateProject1(@Valid ProjectChecking project, BindingResult result,
			ModelMap model, @PathVariable String projectId) {
        System.out.println("result is:" +result);
		if (result.hasErrors()) {
			return "userUpdate";
		}

		/*//Uncomment below 'if block' if you WANT TO ALLOW UPDATING SSO_ID in UI which is a unique key to a User.
		if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
			FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registration";
		}*/


		projectService.updateProject1(project);

		model.addAttribute("success", "Project " + project.getProjectName() + " updated successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "projectregistrationsuccess";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * updating task in database. It also validates the task input
	 */
	@RequestMapping(value = { "/edit-task-{projectId}" }, method = RequestMethod.POST)
	public String updatetask(@Valid Task task, BindingResult result,
			ModelMap model, @PathVariable int projectId) {
        System.out.println("result is:" +result);
		if (result.hasErrors()) {
			return "newtask";
		}

		/*//Uncomment below 'if block' if you WANT TO ALLOW UPDATING SSO_ID in UI which is a unique key to a User.
		if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
			FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registration";
		}*/


		taskService.updateTask(task);

		model.addAttribute("success", "Task " + task.getTaskName() + " updated successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "registrationsuccess";
	}
	
	
	/**
	 * This method will delete an user by it's SSOID value.
	 */
	@RequestMapping(value = { "/delete-user-{ssoId}" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable String ssoId) {
		userService.deleteUserBySSO(ssoId);
		return "redirect:/list";
	}
	
	
	/**
	 * This method will delete project by it's project Id value.
	 */
	@RequestMapping(value = { "/delete-project-{projectId}" }, method = RequestMethod.GET)
	public String deleteProject(@PathVariable int projectId) {
		projectService.deleteProjectBySSO(projectId);
		return "redirect:/projectlist";
	}
	
	/**
	 * This method will delete project by it's Task Id value.
	 */
	@RequestMapping(value = { "/delete-task-{projectId}" }, method = RequestMethod.GET)
	public String deleteTask(@PathVariable int projectId) {
		taskService.deleteTaskByTaskId(projectId);
		return "redirect:/tasklist";
	}
	

	/**
	 * This method will provide UserProfile list to views
	 */
	@ModelAttribute("roles")
	public List<UserProfile> initializeProfiles() {
		return userProfileService.findAll();
	}
	
	/**
	 * This method will provide UserProfile list to views
	 */
	@ModelAttribute("projectowner")
	public List<UserProfile> initializeProjectOwner() {
		return userProfileService.findAllUsers();
	}
	
	
	@ModelAttribute("projectroles")
		public List<ProjectProfile> initializeProjectProfiles() {
	  	return projectProfileService.findAll();
	}
	
	/**
	 * This method handles Access-Denied redirect.
	 */
	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("loggedinuser", getPrincipal());
		return "accessDenied";
	}

	/**
	 * This method handles login GET requests.
	 * If users is already logged-in and tries to goto login page again, will be redirected to list page.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		if (isCurrentAuthenticationAnonymous()) {
			return "login";
	    } else {
	    	//return "redirect:/projectlist";
	    	return "redirect:/list";  
	    }
	}

	/**
	 * This method handles logout requests.
	 * Toggle the handlers if you are RememberMe functionality is useless in your app.
	 */
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			//new SecurityContextLogoutHandler().logout(request, response, auth);
			persistentTokenBasedRememberMeServices.logout(request, response, auth);
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		return "redirect:/login?logout";
	}

	/**
	 * This method returns the principal[user-name] of logged-in user.
	 */
	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
	
	/**
	 * This method returns true if users is already authenticated [logged-in], else false.
	 */
	private boolean isCurrentAuthenticationAnonymous() {
	    final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    return authenticationTrustResolver.isAnonymous(authentication);
	}
	
	@SuppressWarnings("null")
	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public String report(ModelMap model)
	{ 
		
			
		List<ProjectReport> reportList = new ArrayList<>();
		
		List<Project> projects = projectService.findAllProjects();
		System.out.println("projectlist"+projects);
		System.out.println("next");
		Project report = null;
		int i = 0,j = 0;
		String projectName = null;
		float scheduleVariance = 0;
		float effortVariance = 0;
		float delivered = 0 ;
		float production = 0;
		ProjectReport repo = null;
		
		for(Project allReport: projects)
			{
			ProjectReport pr= new  ProjectReport();
			  pr.setProjectName(allReport.getProjectName());
				pr.setScheduleVariance(ProjectReport.scheduleVariance(allReport.getActualEndDate(), allReport.getStartDate(), allReport.getRaisedEndDate())) ;
				pr.setEffortVariance(effortVariance = ProjectReport.effortsVariance(allReport.getActualEfforts(), allReport.getPlannedEfforts())) ;
				pr.setDelivered(ProjectReport.delivered(allReport.getActualEfforts(), allReport.getPlannedEfforts(), allReport.getUat()));
				pr.setProduction(production = ProjectReport.production(allReport.getActualEfforts(), allReport.getPlannedEfforts(), allReport.getPost()));
				
				reportList.add(pr);
				
			}
		model.addAttribute("projectReport", reportList);
		model.addAttribute("loggedinuser", getPrincipal());
		
		System.out.println("Report list "+reportList);
		
		
		
		return "report"; 
		  

	}



}