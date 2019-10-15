<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de telefones</title>
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
<body style="background-color:#fffdd0 ">
	<a href="pagina-acesso-liberado.jsp"><img alt="Início"
		title="Início" src="resources/img/home.jpg"
		style="width: 70px; height: 70px;"></a>
	<a href="index_primeiro_servlet.jsp"><img alt="Sair" title="Sair"
		src="resources/img/sair.jpg"
		style="width: 70px; height: 70px; padding-top: 7px"></a>
	<center>
		<h1>Lista de telefones</h1>
		<h3 style="color: orange;">${msg}</h3>
	</center>
	<center>
		<form action="salvarTelefone?user=${userEscolhido.id}" method="post"
			id="formTelefone" onsubmit="return validarDados()? true : false">

			<table>
				<tr>
					<td>User:</td>
					<td><input type="text" readonly="readonly" name="user"
						id="user" value="${userEscolhido.id}" /></td>
					<td><input type="text" readonly="readonly" name="nome"
						id="nome" value="${userEscolhido.nome}" /></td>
				</tr>
				<tr>
					<td>Numero:</td>
					<td><input type="text" name="numero" id="numero" /></td>
					<td><select id="tipo" name="tipo" style="width: 200px;">
							<option>Casa</option>
							<option>Trabalho</option>
							<option>Celular</option>
					</select>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="salvar" style="width: 200px" /></td>
					<td><input type="submit" value="voltar" style="width: 200px"
						onclick="document.getElementById('formTelefone').action='salvarTelefone?acao=voltar'" /></td>
				</tr>
			</table>
		</form>
	</center>


	<div class="container">
		<form>
			<table class="responsive-table">
				<caption>Telefones Cadastrados</caption>
				<thead>

					<tr>
						<th scope="col">ID</th>
						<th scope="col">Número</th>
						<th scope="col">Tipo</th>
						<th scope="col">Excluir</th>
					</tr>
				</thead>
				<c:forEach items="${telefones}" var="fone">

					<tbody>
						<tr>
							<th scope="row"><c:out value="${fone.id}" />
							<td><c:out value="${fone.numero}" /></td>
							<td><c:out value="${fone.tipo}" /></td>
							<td><a
								href="salvarTelefone?user=${fone.usuario}&acao=delete&foneId=${fone.id}"
								onclick=" return confirm('Confirmar a exclusão?');"><img
									src="resources/img/excluir_icon.png" alt="Exluir"
									title="Excluir" width="20px" height="20px"> </a></td>
						</tr>
					</tbody>


				</c:forEach>

			</table>


		</form>
	</div>
	<script type="text/javascript"
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'>
		function validarDados() {
			if (!document.getElementById("numero").value) {
				alert("Tem que informar o numero!!!!");
				return false;
			} else if (!document.getElementById("tipo").value) {
				alert("Tem que informar o tipo!!!!");
				return false;
			}
			return true;
		}
	</script>
</body>
</html>