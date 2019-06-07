<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Task Registration Form</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
	<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
<script src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>
<script>
    $('#startDate').datepicker({
        format: 'dd/mm/yyyy'
    });
</script>
<script>
    $('#endDate').datepicker({
        format: 'dd/mm/yyyy'
    });
</script>

<body>
 	<div class="generic-container">
		<%@include file="authheader.jsp" %>

		<div class="well lead">Task Registration Form</div>
	 	<form:form method="POST" modelAttribute="task" class="form-horizontal">
			<form:input type="hidden" path="id" id="id"/>
			   
			   <div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="taskId">Task Id</label>
					<div class="col-md-7">
						<form:select path="taskId" multiple="true" itemValue="id" itemLabel="type" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="taskProfiles" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>		

			   <div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="taskId">Project Id</label>
					<div class="col-md-7">
						<form:select path="projectId" multiple="true" itemValue="id" itemLabel="type" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="projectProfiles" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>	
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="taskName">Task Name</label>
					<div class="col-md-7">
						<form:input type="text" path="taskName" id="taskName" class="form-control input-sm"/>
						<div class="has-error">
							<form:errors path="taskProfiles" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="ssoId">Owner</label>
					<div class="col-md-7">
						<c:choose>
							<c:when test="${edit}">
								<form:input type="text" path="owner" id="owner" class="form-control input-sm" disabled="true"/>
							</c:when>
							<c:otherwise>
								<form:input type="text" path="owner" id="owner" class="form-control input-sm" />
								<div class="has-error">
									<form:errors path="owner" class="help-inline"/>
								</div>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="team">Team</label>
					<div class="col-md-7">
						<form:input type="text" path="team" id="team" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="team" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="startDate">Start Date</label>
					<div class="col-md-7">
						<form:input type="text" path="startDate" id="startDate" class="form-control input-sm"  required="required" />
						<div class="has-error">
							<form:errors path="team" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
			
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="endDate">End Date</label>
					<div class="col-md-7">
						<form:input type="text" path="endDate" id="endDate" class="form-control input-sm"  required="required" />
						<div class="has-error">
							<form:errors path="team" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
		
			<div class="row">
				<div class="form-actions floatRight">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/tasklist' />">Update</a>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/tasksuccess' />">Register</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>