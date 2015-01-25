<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Spring forms :: Users</title>

<!-- Bootstrap -->
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Users app</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="<s:url value="/assignments" />"
						title="View Users">View assigments</a></li>
					<li><a href="<s:url value="/users/" />" title="View users">View
							users</a></li>
					<li class="active"><a href="<s:url value="/users/new" />"
						title="New user">New user</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
	<div class="container">
		<div class="jumbotron">
			<h1>New user</h1>
			<p>See this user info</p>
		</div>
		<sf:form method="post" modelAttribute="user" action="/users/new">
			<div class="form-group">
				<label for="login">Login</label>
				<sf:input path="login" class="form-control" placeholder="Login" />
			</div>
			<div class="form-group">
				<label for="password">Password</label>
				<sf:input path="password" class="form-control" type="password"
					placeholder="Password" />
			</div>
			<div class="form-group">
				<label for="description">Description</label>
				<sf:textarea path="description" class="form-control"
					placeholder="Description" />
			</div>
			<sf:button class="btn btn-primary pull-right">Create</sf:button>
		</sf:form>
	</div>
	<footer class="footer">
		<div class="container">
			<p class="text-muted">&copy; 2015 Eugenia Pérez</p>
		</div>
	</footer>
</body>
</html>