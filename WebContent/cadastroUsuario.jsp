<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="beans.BeanUsuario"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de usuário</title>
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
		<h1>Cadastro de usuário</h1>
		<h3 style="color: orange;">${msg}</h3>
	</center>

	<center>
		<form action="salvarUsuario" method="post" id="formUser"
			onsubmit="return validarDados()? true : false"
			enctype="multipart/form-data">

			<table>
				<tr>
					<td>Código:</td>
					<td><input type="text" readonly="readonly" name="id" id="id"
						value="${user.id}" /></td>

					<td>Cep:</td>
					<td><input type="text" name="cep" id="cep"
						onblur="buscarDadosCEP()" value="${user.cep}" maxlength="9" /></td>

				</tr>
				<tr>
					<td>Login:</td>
					<td><input type="text" name="login" id="login" maxlength="10"
						value="${user.login}" /></td>

					<td>Rua:</td>
					<td><input type="text" name="rua" id="rua" value="${user.rua}"
						maxlength="50" /></td>
				</tr>
				<tr>
					<td>Senha:</td>
					<td><input type="password" name="senha" id="senha"
						maxlength="10" value="${user.senha}" /></td>

					<td>Bairro:</td>
					<td><input type="text" name="bairro" id="bairro"
						maxlength="50" value="${user.bairro}" /></td>
				</tr>
				<tr>
					<td>Nome:</td>
					<td><input type="text" name="nome" id="nome" maxlength="50"
						value="${user.nome}" placeholder="Informe o nome do usuário" /></td>

					<td>Cidade:</td>
					<td><input type="text" name="cidade" id="cidade"
						maxlength="50" value="${user.cidade}" /></td>
				</tr>
				<tr>
					<td>IBGE:</td>
					<td><input type="text" name="ibge" id="ibge" maxlength="20"
						value="${user.ibge}" /></td>
					<td>Estado:</td>
					<td><input type="text" name="estado" id="estado"
						value="${user.estado}" /></td>
				</tr>
				<tr>
					<td>Sexo:</td>
					<td><input type="radio" name="sexo"
						<%if (request.getAttribute("user") != null) {
				BeanUsuario usuario = (BeanUsuario) request.getAttribute("user");
				if (usuario.getSexo().equalsIgnoreCase("masculino")) {
					out.print(" ");
					out.print("checked=\"checked\"");
					out.print(" ");
				}
			}%>
						value="masculino">Masculino&nbsp;&nbsp;&nbsp; <input
						type="radio" name="sexo"
						<%if (request.getAttribute("user") != null) {
				BeanUsuario usuario = (BeanUsuario) request.getAttribute("user");
				if (usuario.getSexo().equalsIgnoreCase("feminino")) {
					out.print(" ");
					out.print("checked=\"checked\"");
					out.print(" ");
				}
			}%>
						value="feminino">Feminino</td>
					<td>Foto:</td>
					<td><input type="file" name="foto" id="foto"></td>
				</tr>
				<tr>
					<td>Ativo:</td>
					<td><input type="checkbox" id="ativo" name="ativo"
						<%if (request.getAttribute("user") != null) {
				BeanUsuario usuario = (BeanUsuario) request.getAttribute("user");
				if (usuario.isAtivo()) {
					out.print(" ");
					out.print("checked=\"checked\"");
					out.print(" ");
				}
			}%>>
					<td>Currículo:</td>
					<td><input type="file" name="curriculo" id="curriculo"></td>
				</tr>
				<tr>
					<td>Perfil:</td>
					<td><select id="perfil" name="perfil" style="width: 200px">

							<option value="não_informado">[--SELECIONE--]</option>
							<option value="gerente"
								<%if (request.getAttribute("user") != null) {
				BeanUsuario usuario = (BeanUsuario) request.getAttribute("user");
				if (usuario.getPerfil().equalsIgnoreCase("gerente")) {
					out.print(" ");
					out.print("selected=\"selected\"");
					out.print(" ");
				}
			}%>>Gerente</option>
							<option value="secretario"
								<%if (request.getAttribute("user") != null) {
				BeanUsuario usuario = (BeanUsuario) request.getAttribute("user");
				if (usuario.getPerfil().equalsIgnoreCase("secretario")) {
					out.print(" ");
					out.print("selected=\"selected\"");
					out.print(" ");
				}
			}%>>Secretário(a)</option>
							<option value="administrador"
								<%if (request.getAttribute("user") != null) {
				BeanUsuario usuario = (BeanUsuario) request.getAttribute("user");
				if (usuario.getPerfil().equalsIgnoreCase("administrador")) {
					out.print(" ");
					out.print("selected=\"selected\"");
					out.print(" ");
				}
			}%>>Administrador</option>
							<option value="funcionario"
								<%if (request.getAttribute("user") != null) {
				BeanUsuario usuario = (BeanUsuario) request.getAttribute("user");
				if (usuario.getPerfil().equalsIgnoreCase("funcionario")) {
					out.print(" ");
					out.print("selected=\"selected\"");
					out.print(" ");
				}
			}%>>Funcionário</option>
					</select></td>
				</tr>
				<tr></tr>
				<tr>
					<td></td>
					<td><input type="submit" value="salvar" style="width: 200px"
						onclick="document.getElementById('formUser').action='salvarUsuario?acao=salvar&usuario=${user.id}'" /></td>
					<td></td>
					<td><input type="submit" value="cancelar" style="width: 200px"
						onclick="document.getElementById('formUser').action='salvarUsuario?acao=reset'" /></td>
				</tr>
			</table>
		</form>
	</center>
	<br>
	<br>
	<center>
		<form action="servletPesquisa" method="post">
			<table>
				<tr>
					<td>Descrição</td>
					<td><input type="text" id="descricaoconsulta"
						name="descricaoconsulta"></td> 
					<td><input type="submit"
						value="pesquisar"></td>
				</tr>
			</table>
		</form>
	</center>
	<div class="container">
		<form>
			<table class="responsive-table">


				<caption>Lista de usuários</caption>
				<thead>

					<tr>
						<th scope="col">ID</th>
						<th scope="col">Login</th>
						<th scope="col">Foto</th>
						<th scope="col">Currículo</th>
						<th scope="col">Nome</th>
						<th scope="col">Telefones</th>
						<th scope="col">Delete</th>
						<th scope="col">Editar</th>
					</tr>
				</thead>
				<c:forEach items="${usuarios}" var="user">

					<tbody>
						<tr>
							<th scope="row"><c:out value="${user.id}" />
							<td><c:out value="${user.login}" /></td>
							<c:if test="${user.fotoBase64Miniatura.isEmpty()==false}">
								<td><a
									href="salvarUsuario?acao=download&tipo=imagem&user=${user.id}"><img
										src="<c:out value="${user.fotoBase64Miniatura}"/>"
										alt="Foto usuário" title="Foto usuário" width="32px"
										height="32px"></a></td>
							</c:if>
							<c:if test="${user.fotoBase64Miniatura.isEmpty() == null}">
								<td><img alt="Foto usuario"
									src="resources/img/usuario_padrao.png" width="32px"
									height="32px" onclick="alert('Não possui imagem!')"></td>
							</c:if>
							<c:if test="${user.curriculoBase64 != null}">
								<td><a
									href="salvarUsuario?acao=download&tipo=curriculoPdf&user=${user.id}"><img
										alt="currículo" src="images/icons/pdf.ico" width="32px"
										height="32px"></a></td>
							</c:if>
							<c:if test="${user.curriculoBase64 == null}">
								<td><img alt="currículo usuário"
									src="resources/img/pdfx.jpg" width="32px" height="32px"
									onclick="alert('Não possui currículo!')"></td>
							</c:if>
							<td><c:out value="${user.nome}" /></td>
							<td><a href="salvarTelefone?acao=addFone&user=${user.id}"><img
									src="resources/img/telefones.png" alt="Telefones"
									title="Telefones" width="20px" height="20px"></a></td>
							<td><a href="salvarUsuario?acao=delete&user=${user.id}"
								onclick=" return confirm('Confirmar a exclusão?');"><img
									src="resources/img/excluir_icon.png" alt="Exluir"
									title="Excluir" width="20px" height="20px"> </a></td>
							<td><a href="salvarUsuario?acao=editar&user=${user.id}"><img
									src="resources/img/editar_icon.png" alt="Editar" title="Editar"
									width="20px" height="20px"></a></td>
						</tr>
					</tbody>


				</c:forEach>

			</table>


		</form>
	</div>
	<script type="text/javascript"
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'>
		
	</script>
	<script type="text/javascript">
		function validarDados() {
			if (!document.getElementById("login").value) {
				alert("Tem que informar o login!!!!");
				return false;
			} else if (!document.getElementById("senha").value) {
				alert("Tem que informar o senha!!!!");
				return false;
			} else if (!document.getElementById("nome").value) {
				alert("Tem que informar o nome!!!!");
				return false;
			} else if (!document.getElementById("fone").value) {
				alert("Tem que informar o telefone!!!!");
				return false;
			}
			return true;
		}

		function buscarDadosCEP() {
			var cep = $("#cep").val()
			$.getJSON("https://viacep.com.br/ws/" + cep + "/json/?callback=?",
					function(dados) {

						if (!("erro" in dados)) {
							//Atualiza os campos com os valores da consulta.
							$("#rua").val(dados.logradouro);
							$("#bairro").val(dados.bairro);
							$("#cidade").val(dados.localidade);
							$("#estado").val(dados.uf);
							$("#ibge").val(dados.ibge);
						} //end if.
						else {
							//CEP pesquisado não foi encontrado.
							$("#cep").val("");
							$("#rua").val("");
							$("#bairro").val("");
							$("#cidade").val("");
							$("#estado").val("");
							$("#ibge").val("");
							alert("CEP não encontrado.");
						}
					});
		}

		function validarFotoUsuario() {
			if ($(''))
		}
	</script>
	</bo
							dy>
</html>