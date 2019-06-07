<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Project List</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
</head>

<body>
	<div class="generic-container" id="kryesore"> 
	<%@include file="authheader.jsp" %>
	<div id="header"><h2><b><center>Welcome to Project Tracker</b></center></h2></div>
	 <button class="btn" onclick="history.back()"><i class="fa fa-home"></i></button>
		<div id="list">
			<div class="panel panel-default">
				<div class="panel-heading"><span class="lead"><center>List of Projects</center> </span></div> 
					<center>
					<table class="table table-hover" id="tableprojectlist">
					
						<thead>
							<tr>
								<th>Project Id</th>
								<th>Project name</th>
								<th>Project Description</th>
								<th>Owner</th>
								<th>Team</th>
								<th>Start Date</th>
								<th>End Date</th>
								<th>Raised End Date</th>
								<th>Actual End Date</th>
								<th>Planned Efforts</th>
								<th>Actual Efforts</th>
								<th>Defect in QA </th>
								<th>Defect in UAT </th>
								<th>Defect in Post Production</th> 
								<th></th>
								<th></th>
								<th></th>
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
							    <td>${project.raisedEndDate}</td>
								<td>${project.actualEndDate}</td>
								<td>${project.plannedEfforts}</td>
								<td>${project.actualEfforts}</td>
								<td>${project.qa}</td>
								<td>${project.uat}</td>
								<td>${project.post}</td>
							    <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
							    <td><a href="<c:url value='/edit-project-${project.id}' />" class="btn btn-success custom-width">edit</a></td>
				                </sec:authorize>
				                <sec:authorize access="hasRole('ADMIN')">
							    <td><a href="<c:url value='/delete-project-${project.id}' />" class="btn btn-danger custom-width">delete</a></td>
        				        </sec:authorize>
		        				<sec:authorize access="hasRole('ADMIN')">
								<td><a href="<c:url value='/tasklist1' />" class="btn btn-primary custom-width">Task List</a></td>
		        				</sec:authorize>
		        				<sec:authorize access="hasRole('QA')">
									<td><a href="<c:url value='/update-project-${project.id}' />" class="btn btn-success custom-width">Update</a></td>
						        </sec:authorize>
							</tr>
						</c:forEach>
	    			</tbody>
	    			</center>
	    		</table>
	    		
			</div>
			<sec:authorize access="hasRole('ADMIN')">
		 	<div class="well">
		 	<center>
		 		<a href="<c:url value='/newproject' />">Add New Project</a>
		 	</center>
		 	</div>
	 	</sec:authorize>
   	</div>
   	</div>
   	
</body>
</html>