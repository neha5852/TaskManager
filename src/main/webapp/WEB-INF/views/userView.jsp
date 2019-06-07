<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User task List</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Home Page</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="../Stylesheet.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="generic-container" id="kryesore"> 
	<%@include file="authheader.jsp" %>
	  <div id="list"> 
	<center><h3>WELCOME <strong>${loggedinuser}</strong></h3></center>
		<div class="panel panel-default">
		  	<div class="panel-heading"><span class="lead"><center>List of My Tasks </center></span></div>
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
					<td><a href="<c:url value='/update-task-${task.pid}' />" class="btn btn-success custom-width">Update</a></td>
				   </sec:authorize>
				   </tr>
				</c:forEach>
	    		</tbody>
	    	</table>
	    	</center>
		</div>
	</div> 
	
	<!-- <table class="table table-hover" id="tablelist">
						<thead>
							<tr>
								<th>Project Id</th>
								<th>Project name</th>
								<th>Project Description</th>
								<th>Owner</th>
								<th>Team</th>
								<th>Start Date</th>
								<th>End Date</th>
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
							      
							</tr>
						</c:forEach>
	    			</tbody>
	    		</table> -->
	
		</div>
</body>
</html>