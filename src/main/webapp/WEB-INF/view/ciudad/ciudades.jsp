<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- No pueden convivir c & sgf? da error y no arranca -->
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
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
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">CITYS APP</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
				
					<li><a href="<s:url value="/delegaciones" />"   
					title="<s:message code="navbar.delegations"></s:message>">
					<s:message code="navbar.delegations"></s:message></a></li>
					
					<li class="active"><a href="<s:url value="/ciudades/" />"    
					title="<s:message code="navbar.citys"></s:message>">
					<s:message code="navbar.citys"></s:message></a></li>
					
					<li><a href="<s:url value="/ciudad/newcity/" />" 
					title="<s:message code="navbar.newcity"></s:message>">
					<s:message code="navbar.newcity"></s:message></a></li>
					
				</ul>
				
				
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="true"><s:message
								code="navbar.language"></s:message> <span class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="?idioma=en"><img src="images/flags.png"
									class="flag flag-gb"
									alt="<s:message code="english"></s:message>" /> <s:message
										code="english"></s:message></a></li>
							<li><a href="?idioma=es"><img src="images/flags.png"
									class="flag flag-es"
									alt="<s:message code="spanish"></s:message>" /> <s:message
										code="spanish"></s:message></a></li>
						</ul></li>
				</ul>
				
				
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
	<div class="container">
		<div class="jumbotron">
			<h1>Citys list</h1>
			<p>These are the citys currently in the system.</p>
		</div>

		<table class="table">
			<thead>
				<tr>
					<th>NOMBRE</th>
					<th>CODIGO POSTAL</th>
					<th>IDPROVINCIA</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${citys}" var="city">
					<tr>
						<td>${city.nombre}</td>
						<td>${city.cpostal}</td>
						<td>${city.idProvincia}</td>
						<td><a class="btn btn-sm btn-primary" href="<s:url value="/ciudad/${city.id}" />" title="Detailed info"> see detail</a>
							<a class="btn btn-sm btn-info" href="<s:url value="/createdelegation/${city.id}" />" title="CreateDelegation"> add delegation</a>
							<a class="btn btn-sm btn-success" href="<s:url value="/ciudad/update/${city.id}" />" title="Update"> update</a>
							<a class="btn btn-sm btn-danger" href="<s:url value="/ciudad/delete/${city.id}" />" title="Delete"> delete</a>
							
							</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<footer class="footer">
		<div class="container">
			<p class="text-muted">&copy; 2015 Eugenia Pérez</p>
		</div>
	</footer>
	<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</body>
</html>