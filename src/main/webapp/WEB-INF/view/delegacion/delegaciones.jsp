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
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">CITYS APP -> DELEGATIONS</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="<s:url value="/delegaciones" />"   title="View Users">VIEW DELEGATIONS</a></li>
					<li class="active"><a href="<s:url value="/ciudades/" />"    title="View users">VIEW CITY</a></li>
					<li><a href="<s:url value="/ciudad/newdelegacion/" />" title="New user">NEW CITY</a></li>
				</ul>
				
				
				
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
	<div class="container">
		<div class="jumbotron">
			<h1>DELEGATIONS LIST</h1>
			<p>These are the delegacions currently in the system.</p>
		</div>

		<table class="table">
			<thead>
				<tr>
					<th>NOMBRE</th>
					<th>DESCRIPCION</th>
					<th>DIRECCION</th>
					<th>CIUDAD</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${delegations}" var="delegacion">
					<tr>
						<td>${delegacion.nombre}</td>
						<td>${delegacion.descripcion}</td>
						<td>${delegacion.direccion}</td>
						<td>${delegacion.id}</td>
						<td>
							<a class="btn btn-sm btn-primary" href="<s:url value="/delegacion/${delegacion.id}" />" title="Detailed info"> see detail</a>
							<a class="btn btn-sm btn-success" href="<s:url value="/delegacion/update/${delegacion.id}" />" title="Update"> update</a>
							<a class="btn btn-sm btn-danger" href="<s:url value="/delegacion/delete/${delegacion.id}" />" title="Delete"> delete</a>
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
</body>
</html>