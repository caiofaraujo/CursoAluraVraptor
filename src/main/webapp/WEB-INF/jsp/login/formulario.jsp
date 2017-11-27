<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.css">
<title>Login</title>
</head>
<body>
	<div class="container">
	<h1>Efetuar Login</h1>
		<form action='<c:url value="/login/autentica" />' method=post>
			Usuario:
			<input class="form-control" type="text" name="usuario.nome" />
			Senha:
			<input class="form-control" type="text" name="usuario.senha" />
			<br>
			<input type="submit" class="btn btn-primary" value="Login"/>
		</form>
		<br>
		<c:forEach items="${errors}" var="erro"> 
			<div class="alert alert-danger">
				${erro.category} - ${erro.message}
			</div>
		</c:forEach>
	</div>
</body>
</html>