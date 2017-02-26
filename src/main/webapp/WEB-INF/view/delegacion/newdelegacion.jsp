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
					<a class="navbar-brand" href="#">citys app -> DELEGACIONES</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="<s:url value="/delegaciones" />"   title="View Users">VIEW DELEGATIONS</a></li>
					<li class="active"><a href="<s:url value="/ciudades/" />"    title="View users">VIEW CITY</a></li>
					<li><a href="<s:url value="/ciudad/newcity/" />" title="New user">NEW CITY</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
	<div class="container">
		<div class="jumbotron">
			<h1>NEW DELEGATION</h1>
			<p>See this delegation info</p>
		</div>
		<!-- En action se debe indicar la acción a la cuál queremos dirigir la petición. 
		El controlador será el mismo que el que ha servido esta página. Si se quiere especificar
		otro, se debe componer una nueva ruta mediante c:url -->
		<s:url var="action" value="/delegacion/newdelegacion/new" />
		<sf:form method="post" modelAttribute="delegacion" action="${action}">
			<div class="form-group">
				<label for="login">NOMBRE</label>
				<sf:input path="nombre" class="form-control" />
				<sf:errors path="nombre" cssClass="error" />
			</div>
			<div class="form-group">
				<label for="password">DESCRIPCION</label>
				<sf:input path="descripcion" class="form-control"  />
				<sf:errors path="descripcion" cssClass="error" />
			</div>
			<div class="form-group">
				<label for="direccion">DIRECCION</label>
				<sf:textarea path="direccion" class="form-control"  />
				<sf:errors path="direccion" cssClass="error" />
			</div>
			<sf:hidden path="ciudad.id"  />
			<div>
			
		</div>
			
			
			<sf:button class="btn btn-primary pull-right">CREATE</sf:button>
		</sf:form>
	</div>
	<footer class="footer">
		<div class="container">
			<p class="text-muted">&copy; 2015 Eugenia Pérez</p>
		</div>
	</footer>
</body>
</html>