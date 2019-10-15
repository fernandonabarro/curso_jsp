<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="resources/css/estilo.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="login-page">
		<div class="form">
			<form action="LoginServlet" method="post" class="login-form">
				Usuário <input type="text" name="login" id="login"> <br>
				Senha: <input type="password" name="senha" id="senha">
				<button type="submit" name="logar" id="logar" value="Logar">Logar</button>
			</form>
		</div>
	</div>
</body>
</html>