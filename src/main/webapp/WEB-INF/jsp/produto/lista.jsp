<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.css">
<title>Listagem Produtos</title>
</head>
<body>
<div class="container">
	<h1>Listagem produtos ${usuarioLogado.usuario.nome}</h1>
	<table class="table table-stripped table-hover table-bordered">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Valor</th>
				<th>Quantidade</th>
				<th align=center>Adicionar</th>
				<th align=center>Editar</th>
				<th align=center>Excluir</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${produtoList}" var="produto">
			<tr>
				<td>${produto.nome}</td>
				<td >${produto.valor}</td>
				<td >${produto.quantidade}</td>
				<td align=center>
					<a href="<c:url value='/produto/formulario' />" class="btn-sm btn-sucess btn-primary ">
						 <span class="glyphicon glyphicon-plus"></span>
					</a>
				</td>
				<td align=center>
					<a href="<c:url value='/produto/edita' />" class="btn-sm btn-primary a-btn-slide-text" >
						<span class="glyphicon glyphicon-edit"></span>
					</a>
				</td>
				<td align=center>
					<a href="<c:url value='/produto/remove?produto.id=${produto.id}' />" class="btn btn-sm btn-secondary btn-danger" > 
						<span class="glyphicon glyphicon-trash"></span>
					</a>
				</td>
				<td>
					<c:url value='/produto/enviaPedidoDeNovosItens?produto.nome=${produto.nome}' var="url"/>
					<a href="${url }">Solicitar mais itens</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<c:if test="${not empty mensagem}">
    	<div class="alert alert-success">${mensagem}</div>
	</c:if>
</div>
</body>
</html>