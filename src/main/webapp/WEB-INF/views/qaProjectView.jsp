<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Users List</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
<div class="generic-container" id="kryesore"> 
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
			</div>



</body>
</html>