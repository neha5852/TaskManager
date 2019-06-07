<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Home Page</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="../Stylesheet.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <!------ Include the above in your HEAD tag ---------->
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.0/animate.css" />
     <!------ Include the above in your HEAD tag ---------->
</head>

<body>
<header id="home">
<sec:authorize access="hasRole('ADMIN')">
	<div class="overlay"></div>
	<nav class="navbar fixed-top navbar-expand-lg navbar-dark">
            <div class="container-fluid">
               <!--  <a class="navbar-brand" href="javascript:void(0)">
                    <h3 class="my-heading ">Project Tracker</h3>
                </a> -->
                    <ul class="navbar-nav ml-auto">
					 <li class="nav-item">
					  <a href="<c:url value='/list' />">
					  <button type="button" class="btn btn-warning">	
						<span class="glyphicon glyphicon-user"></span> User List
					  </button></a>
                        </li>
                        <li class="nav-item">
			 		  <a href="<c:url value='/projectlist' />">
					  <button type="button" class="btn btn-success">	
						<span class="glyphicon glyphicon-king"></span> Project List
					  </button></a>
                        </li>
                        <li class="nav-item">
			         <!-- <a href="<c:url value='/report' />"> -->
			          <div class="dropdown">
					   <button class="dropbtn">
					   <span class="glyphicon glyphicon-tasks"></span> Reports </button>	
						<div class="dropdown-content">
    						<a href="projectreport">Project Report</a>
    						<a href="report">Varience Report</a>
 						</div>
					  </div>
                        </li>
                    </ul>
                </div>
                 <h1 class="title-main wow fadeInLeft" data-wow-duration="2.5s">Project Tracker</h1>
	             <h3 class="subtitle-main wow fadeInUp" data-wow-duration="2.1s">Talent wins games, 
	             but teamwork & intelligence wins championships ~Michael Jordan</h3>
             </div>
          </nav>
   
		<div class="backgroundwelcome">
			<div class="tophead" >
	            <div class="container-fluid">
	                <div class="row">
	                    <div class="col-sm-8 ">
	                         <h1 class="title-main wow fadeInLeft" data-wow-duration="3.5s"></h1>
	                          <h3 class="subtitle-main wow fadeInUp" data-wow-duration="3.1s"></h3> 
						<!-- 	<div class="top-btn-block wow fadeInUp data-wow-duration="2.5s">
								<a href="javascript:void(0)" class="btn-explore ">Explore</a>
								<a href="javascript:void(0)" class="btn-account ">Create Account</a>
							</div> -->
	              		 </div>
	           		</div>
	      	 	</div>
	  	  	</div>
		</div>
		</sec:authorize>
</header>
<sec:authorize access="hasRole('USER')">	
<%@include file="authheader.jsp" %> 
	  <div id="list"> 
	<center><h3>WELCOME <strong>${loggedinuser}</strong></h3></center>
		  	<div class="panel-heading">
		  	<center>
		  	<span class="lead">List of My Tasks 
		  	</span>
		  	</center>
		  	</div>
			<center>
			<table class="table table-hover" id="tablelist">
	    		<thead>
		      		<tr>
				        <th>Task id</th>
				        <th>Project id</th>
				        <th>Task Name</th>
				        <th>Owner</th>
				        <th>Team</th>
				        <th>Start Date</th>
				        <th>End Date</th>
				        <th>Revised Date</th>
				        <sec:authorize access="hasRole('USER')">
				        	<th width="100"></th>
				        </sec:authorize>
				        <sec:authorize access="hasRole('USER')">
				        	<th width="100"></th>
				        </sec:authorize>    
					</tr>
		    	</thead>
	    		<tbody>
				<c:forEach items="${tasks}" var="task">
					<tr>
						<td>${task.id}</td>
						<td>${task.pid}</td>
						<td>${task.taskName}</td>
						<td>${task.owner}</td>
						<td>${task.team}</td>
						<td>${task.startDate}</td>
						<td>${task.endDate}</td>
						<td>${task.revisedDate}</td>
					
					<sec:authorize access="hasRole('USER')">
					<td><a href="<c:url value='/update-task-${task.id}' />" class="btn btn-success custom-width">Update</a></td>
				   </sec:authorize>
				   </tr>
				</c:forEach>
	    		</tbody>
	    	</table>
	    	</center>
		</div>
</sec:authorize>

	
	<sec:authorize access="hasRole('QA')">
	<c:redirect url ="/projectlist"></c:redirect>
<!-- 	<div class="generic-container" id="kryesore"> 
	<%@include file="authheader.jsp" %>
	        <div id="list"> 
			<center><h5>WELCOME <strong>${loggedinuser}</strong></h5></center> 
			<div class="panel panel-default">
				<div class="panel-heading">
				<center>
				<span class="lead">List of Projects </span>
				</center>
				</div> 
					<center>
					<table class="table table-hover" id="tablelist">
						<thead>
							<tr>
								<th>Project Id</th>
								<th>Project name</th>
								<th>Project Description</th>
								<th>Owner</th>
								<th>Team</th>
								<th>Start Date</th>
								<th>End Date</th>
								<th>Defective QA</th>
								<th>Defective UAT</th>
								<th>Defective POST PROD</th>
								<th>
							</tr>
						</thead>
		    			<tbody>
						<c:forEach items="${projects}" var="project">
							<tr>
							    <td>${project.id}</td>
								<td>${project.projectName}</td>
								<td>${project.projectDescription}</td>
								<td>${project.owner}</td>
								<td>${project.team}</td>
								<td>${project.startDate}</td>
								<td>${project.endDate}</td>
								<td>${project.qa}</td>
								<td>${project.uat}</td>
								<td>${project.post}</td>
							    <sec:authorize access="hasRole('QA')">
									<td><a href="<c:url value='/update-project-${project.id}' />" class="btn btn-success custom-width">Update</a></td>
						        </sec:authorize>
							</tr>
						</c:forEach>
	    			</tbody>
	    		</table>
	    		</center>
			</div>
			</div>
			</div> -->
 	</sec:authorize>
			<!-- <c:if test="hasRole('USER')">
					<button type="button" class="btn btn-default">
					<span class="glyphicon glyphicon-user"></span> 
					<a href="<c:url value='/list' />">User List</a>
					</button>
				</c:if>
				<button type="button" class="btn btn-default">
						<span class="glyphicon glyphicon-user"></span> 
						<a href="<c:url value='/tasklist' />">Task List</a>
				</button>-->
				<%@include file="authhome.jsp" %>
 </body>
</html>