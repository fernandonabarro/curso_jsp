<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:#fffdd0 ">
	<a href="pagina-acesso-liberado.jsp"><img alt="Início"
		title="Início" src="resources/img/home.jpg"
		style="width: 70px; height: 70px;"></a>
	<a href="index_primeiro_servlet.jsp"><img alt="Sair" title="Sair"
		src="resources/img/sair.jpg"
		style="width: 70px; height: 70px; padding-top: 7px"></a>
	<center style="padding-top: 10%;">
		<h1>Bem vindo ao sistema java jsp!</h1>
		<table>
			<tr>
				<td><center>
						<a href="salvarUsuario?acao=listartodos"><img
							style="padding-right:  100px" alt="Cadastro de usuário"
							src="images/icons/usuarioCadastro.ico"></a>
					</center></td>
				<td><center>
						<a href="salvarProduto?acao=listartodos"><img
							alt="Cadastro de produto" src="images/icons/produtoCadastro.ico"></a>
					</center></td>
			</tr>
			<tr>
				<td><center style="padding-right:  100px">Cad. Usuário</center></td>
				<td><center>Cad. Produto</center></td>
			</tr>
		</table>
	</center>
</body>
</html>