<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Project Registration Form</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<!-- <script src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>-->
<script>
    $('#startDate').datepicker({
        format: 'dd-mm-yyyy'
    });
</script>
<script>
    $('#endDate').datepicker({
        format: 'dd-mm-yyyy'
    });
</script>

<body>
<sql:setDataSource var="ds" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:4200/websystique" user="root" password="Antman@123"/>
 	<div class="generic-container">
 	
 			<sql:query dataSource="${ds}" var="result"> 
   				 SELECT * from app_user;
		</sql:query>



 	<div class="generic-container">
		<%@include file="authheader.jsp" %>
        <button class="btn" onclick="history.back()"><i class="fa fa-home"></i></button>
		<div class="well lead">Project Registration Form</div>
	 	<form:form method="POST" modelAttribute="project" class="form-horizontal">
			<form:input type="hidden" path="id" id="id"/>
			
		<!--		<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="id">Project id</label>
					<div class="col-md-7">
						<form:input type="text" path="id" id="id" class="form-control input-sm"/>
						<div class="has-error">
							<form:errors path="id" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
		-->	
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="projectName">Project Name</label>
					<div class="col-md-7">
						<form:input type="text" path="projectName" id="projectName" class="form-control input-sm"/>
						<div class="has-error">
							<form:errors path="projectName" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="projectDescription">Project Description</label>
					<div class="col-md-7">
						<form:input type="text" path="projectDescription" id="projectDescription" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="projectDescription" class="help-inline"/>
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
								<!-- <form:input type="text" path="owner" id="owner" class="form-control input-sm" /> -->
								<select name  = "owner" >
								 <c:forEach var="owner" items="${result.rows}">   <!-- ref set var 'result' -->
                                 <option value='<c:out value="${owner.sso_id}"/>'><c:out value="${owner.sso_id}"/></option>
                                 </c:forEach>
                                 </select>
								
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
						<!--<form:input type="text" path="team" id="team" class="form-control input-sm" /> -->
						<select name="team" class="form-control input-sm">
                                <option value="JSS">JSS</option>
                                <option value="MS">MS</option>
                                <option value="QA">QA</option>
                         </select>
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
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="qa">DEF_QA</label>
					<div class="col-md-7">
						<c:choose>
							<c:when test="${edit}">
								<form:input type="text" path="qa" id="qa" class="form-control input-sm" disabled="true"/>
							</c:when>
							<c:otherwise>
								 <form:input type="text" path="qa" id="qa" class="form-control input-sm" /> 
								
								<div class="has-error">
									<form:errors path="qa" class="help-inline"/>
								</div>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
		
			<div class="row">
				<div class="form-actions floatRight">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/projectlist' />">Cancel</a>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/projectlist' />">Cancel</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>