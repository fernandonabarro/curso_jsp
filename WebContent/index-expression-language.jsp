<jsp:useBean id="calcula" class="beans.BeanCursoJsp" type="beans.BeanCursoJsp" scope="page"></jsp:useBean>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<% session.setAttribute("user", "javaavançado"); %>
	
	<a href= "teste-expression-language.jsp">Teste expression language jsp</a>	
	
<!-- 
	<form action="teste-expression-language.jsp">
		<input type="text" name="nome" id="nome">
		<br>
		<input type="text" name="idade" id="idade">
		<br>		
	    <input type="submit" name="enviar" id="enviar" value="Enviar">	
	</form>
 -->	
</body>
</html>