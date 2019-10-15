<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="resources/javascript/jquery.min.js" type="text/javascript"></script>
<script src="resources/javascript/jquery.maskMoney.min.js"
	type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de produtos</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel="stylesheet" href="js/style.css">


<style>
/* NOTE: The styles were added inline because Prefixfree needs access to your styles and they must be inlined if they are on local disk! */
* {
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}

*:before, *:after {
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}

body {
	font-family: "Helvetica Neue", "Helvetica", "Roboto", "Arial",
		sans-serif;
	color: #5e5d52;
}

a {
	color: #337aa8;
}

a:hover, a:focus {
	color: #4b8ab2;
}

.container {
	margin: 5% 3%;
}

@media ( min-width : 48em) {
	.container {
		margin: 2%;
	}
}

@media ( min-width : 75em) {
	.container {
		margin: 2em auto;
		max-width: 75em;
	}
}

.responsive-table {
	width: 100%;
	margin-bottom: 1.5em;
	border-spacing: 0;
}

@media ( min-width : 48em) {
	.responsive-table {
		font-size: .9em;
	}
}

@media ( min-width : 62em) {
	.responsive-table {
		font-size: 1em;
	}
}

.responsive-table thead {
	position: absolute;
	clip: rect(1px, 1px, 1px, 1px);
	/* IE6, IE7 */
	padding: 0;
	border: 0;
	height: 1px;
	width: 1px;
	overflow: hidden;
}

@media ( min-width : 48em) {
	.responsive-table thead {
		position: relative;
		clip: auto;
		height: auto;
		width: auto;
		overflow: auto;
	}
}

.responsive-table thead th {
	background-color: #1d96b2;
	border: 1px solid #1d96b2;
	font-weight: normal;
	text-align: center;
	color: white;
}

.responsive-table thead th:first-of-type {
	text-align: left;
}

.responsive-table tbody, .responsive-table tr, .responsive-table th,
	.responsive-table td {
	display: block;
	padding: 0;
	text-align: left;
	white-space: normal;
}

@media ( min-width : 48em) {
	.responsive-table tr {
		display: table-row;
	}
}

.responsive-table th, .responsive-table td {
	padding: .5em;
	vertical-align: middle;
}

@media ( min-width : 30em) {
	.responsive-table th, .responsive-table td {
		padding: .75em .5em;
	}
}

@media ( min-width : 48em) {
	.responsive-table th, .responsive-table td {
		display: table-cell;
		padding: .5em;
	}
}

@media ( min-width : 62em) {
	.responsive-table th, .responsive-table td {
		padding: .75em .5em;
	}
}

@media ( min-width : 75em) {
	.responsive-table th, .responsive-table td {
		padding: .75em;
	}
}

.responsive-table caption {
	margin-bottom: 1em;
	font-size: 1em;
	font-weight: bold;
	text-align: center;
}

@media ( min-width : 48em) {
	.responsive-table caption {
		font-size: 1.5em;
	}
}

.responsive-table tfoot {
	font-size: .8em;
	font-style: italic;
}

@media ( min-width : 62em) {
	.responsive-table tfoot {
		font-size: .9em;
	}
}

@media ( min-width : 48em) {
	.responsive-table tbody {
		display: table-row-group;
	}
}

.responsive-table tbody tr {
	margin-bottom: 1em;
}

@media ( min-width : 48em) {
	.responsive-table tbody tr {
		display: table-row;
		border-width: 1px;
	}
}

.responsive-table tbody tr:last-of-type {
	margin-bottom: 0;
}

@media ( min-width : 48em) {
	.responsive-table tbody tr:nth-of-type(even) {
		background-color: rgba(94, 93, 82, 0.1);
	}
}

.responsive-table tbody th[scope="row"] {
	background-color: #1d96b2;
	color: white;
}

@media ( min-width : 30em) {
	.responsive-table tbody th[scope="row"] {
		border-left: 1px solid #1d96b2;
		border-bottom: 1px solid #1d96b2;
	}
}

@media ( min-width : 48em) {
	.responsive-table tbody th[scope="row"] {
		background-color: transparent;
		color: #5e5d52;
		text-align: left;
	}
}

.responsive-table tbody td {
	text-align: right;
}

@media ( min-width : 48em) {
	.responsive-table tbody td {
		border-left: 1px solid #1d96b2;
		border-bottom: 1px solid #1d96b2;
		text-align: center;
	}
}

@media ( min-width : 48em) {
	.responsive-table tbody td:last-of-type {
		border-right: 1px solid #1d96b2;
	}
}

.responsive-table tbody td[data-type=currency] {
	text-align: right;
}

.responsive-table tbody td[data-title]:before {
	content: attr(data-title);
	float: left;
	font-size: .8em;
	color: rgba(94, 93, 82, 0.75);
}

@media ( min-width : 30em) {
	.responsive-table tbody td[data-title]:before {
		font-size: .9em;
	}
}

@media ( min-width : 48em) {
	.responsive-table tbody td[data-title]:before {
		content: none;
	}
}
</style>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>

</head>
<body style="background-color: #fffdd0">
	<a href="pagina-acesso-liberado.jsp"><img alt="Início"
		title="Início" src="resources/img/home.jpg"
		style="width: 70px; height: 70px;"></a>
	<a href="index_primeiro_servlet.jsp"><img alt="Sair" title="Sair"
		src="resources/img/sair.jpg"
		style="width: 70px; height: 70px; padding-top: 7px"></a>
	<center>
		<h1>Cadastro de produtos</h1>
		<h3 style="color: orange;">${msg}</h3>
	</center>

	<center>
		<form action="salvarProduto" method="post" id="formUser"
			onsubmit="return validarDados()? true : false">

			<table>
				<tr>
					<td>Código:</td>
					<td><input type="text" readonly="readonly" name="id" id="id"
						value="${produto.id}" /></td>
				</tr>
				<tr>
					<td>Nome:</td>
					<td><input type="text" name="nome" id="nome" maxlength="100"
						style="width: 400px" value="${produto.nome}" /></td>
				</tr>
				<tr>
					<td>Quantidade Un.:</td>
					<td><input type="text" id="quantidade" name="quantidade"
						id="quantidade" value="${produto.quantidade}" maxlength="7" /></td>
				</tr>
				<tr>
					<td>Valor R$</td>
					<td><input type="text" name="valor" id="valor" maxlength="8"
						value="${produto.valorEmTexto}" data-thousands="."
						data-decimal="," data-precision="2" /></td>
				</tr>
				<tr>
					<td>Categoria:</td>
					<td>
						<select id="categorias" name="categoria_id">
							<c:forEach items="${categorias}" var="cat">
								<option value="${cat.id}" id="${cat.id}"
									<c:if test="${cat.id == produto.categoria_id}">
										<c:out value="selected=selected" />
									</c:if>>						
								${cat.nome}
								</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="salvar" style="width: 98px"
						onclick="document.getElementById('formUser').action='salvarProduto?acao=salvar&produto=${produto.id}'" />
						<input type="submit" value="cancelar" style="width: 98px"
						onclick="document.getElementById('formUser').action='salvarProduto?acao=reset'" /></td>
				</tr>
			</table>
		</form>
	</center>


	<div class="container">
		<form>
			<table class="responsive-table">
				<caption>Lista de produtos</caption>
				<thead>

					<tr>
						<th scope="col">Código</th>
						<th scope="col">Nome</th>
						<th scope="col">Quantidade</th>
						<th scope="col">Valor</th>
						<th scope="col">Delete</th>
						<th scope="col">Editar</th>
					</tr>
				</thead>
				<c:forEach items="${produtos}" var="produto">

					<tbody>
						<tr>
							<th scope="row"><c:out value="${produto.id}" />
							<td data-title="Login"><c:out value="${produto.nome}" /></td>
							<td data-title="Nome"><c:out value="${produto.quantidade}" /></td>
							<td data-title="Telefone"><fmt:formatNumber type="number"
									maxFractionDigits="2" value="${produto.valor}" /></td>
							<td><a
								href="salvarProduto?acao=delete&produto=${produto.id}"
								onclick=" return confirm('Confirmar a exclusão?');"><img
									src="resources/img/excluir_icon.png" alt="Exluir"
									title="Excluir" width="20px" height="20px"> </a></td>
							<td><a
								href="salvarProduto?acao=editar&produto=${produto.id}"><img
									src="resources/img/editar_icon.png" alt="Editar" title="Editar"
									width="20px" height="20px"></a></td>
						</tr>
					</tbody>


				</c:forEach>

			</table>


		</form>
	</div>
	<script type="text/javascript">
		function validarDados() {
			if (!document.getElementById("nome").value) {
				alert("Tem que informar o nome!!!!");
				return false;
			} else if (!document.getElementById("quantidade").value) {
				alert("Tem que informar o quantidade!!!!");
				return false;
			} else if (!document.getElementById("valor").value) {
				alert("Tem que informar o valor!!!!");
				return false;
			}
			return true;
		}

		$(function() {
			$('#valor').maskMoney();
		})

		$(document).ready(function() {
			$("#quantidade").keyup(function() {
				$("#quantidade").val(this.value.match(/[0-9]*/));
			});
		});
	</script>

</body>
</html>