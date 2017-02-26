<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page session="false"%>
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
			<h1>UPDATE DELEGATION</h1>
		</div>
		<s:url var="action" value="/delegacion/saveupdate" />
		<sf:form method="post" action="${action}" modelAttribute="delegacion">
			<sf:hidden path="id"/>
			<div class="form-group">
				<label for="login">NOMBRE</label>
				<sf:input path="nombre" class="form-control"  />
				<sf:errors path="nombre" cssClass="error" />
			</div>
			<div class="form-group">
				<label for="password">DESCRIPCION</label>
				<sf:input path="descripcion" class="form-control"  />
				<sf:errors path="descripcion" cssClass="error" />
			</div>
			<div class="form-group">
				<label for="description">DIRECCION</label>
				<sf:textarea path="direccion" class="form-control" />
				<sf:errors path="direccion" cssClass="error" />
			</div>
			<sf:hidden path="ciudad.id"/>
			<sf:button class="btn btn-primary pull-right">Update</sf:button>
			
		</sf:form>
</div>
		<footer class="footer">
			<div class="container">
				<p class="text-muted">&copy; 2015 Eugenia Pérez</p>
			</div>
		</footer>
		<script src="<c:url value="/resources/js/validateUserForm.js" />"></script>
		
</body>
</html>
