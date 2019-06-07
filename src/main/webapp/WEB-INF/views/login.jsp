<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login page</title>
		<link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet"></link>
		<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
		<link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
	    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">
	
	</head>

	<body>
		<div class="container h-100">
		<div class="d-flex justify-content-center h-100">
			<div class="user_card">
				<div class="d-flex justify-content-center">
					<div class="brand_logo_container">
						<img src="https://cdn.freebiesupply.com/logos/large/2x/pinterest-circle-logo-png-transparent.png" class="brand_logo" alt="Logo">
					</div>
				</div>
					<div class="d-flex justify-content-center form_container">
						<c:url var="loginUrl" value="/login" />
						<form action="${loginUrl}" method="post" class="form-horizontal">
							<c:if test="${param.error != null}">
									<div class="mt-4">
					<div class="d-flex justify-content-center links">
									<p>Invalid username and password.</p>
								</div>
							</c:if>
							<c:if test="${param.logout != null}">
									<div class="d-flex justify-content-center links">
									<p>You have been logged out successfully.</p>
								</div>
								</div>
							</c:if>
								<div class="input-group mb-3">
									<div class="input-group-append">
								<label class="input-group-addon" for="username"><i class="fa fa-user"></i></label>
								</div>
								<input type="text" class="form-control" id="username" name="ssoId" placeholder="Enter Username" required>
							</div>
							<div class="input-group mb-2">
							<div class="input-group-append">
								<label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label> 
								</div>
								<input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required>
							</div>
							<div class="input-group input-sm">
                              <div class="checkbox">
                                <label><input type="checkbox" id="rememberme" name="remember-me"> Remember Me</label>  
                              </div>
                            </div>
							<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
								
							<div class="d-flex justify-content-center mt-3 login_container">
								<input type="submit"
									class="btn btn-block btn-primary btn-default" value="Log in">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div> 

	</body>
</html>