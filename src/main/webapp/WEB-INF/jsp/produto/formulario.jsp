<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="../base.css">
<title>Cadastro de Produto</title>
</head>
<body>
	<div class="container">
		<h1>Novo Produto</h1>
		<form action='<c:url value="/produto/adiciona" />' method="post">
			<div class="form-group">
				Nome:
				<input class="form-control" type="text" name="produto.nome" value="${produto.nome}"/>
				Valor: 
				<input class="form-control" type="text" name="produto.valor" value="${produto.valor}"/>
				Quantidade: 
				<input class="form-control" type="text" name="produto.quantidade" value="${produto.quantidade}"/>
				<br>
				<button type="submit" class="btn btn-primary" value="Adicionar">Adicionar</button>
			</div>
		</form>
	</div>
</body>
</html>