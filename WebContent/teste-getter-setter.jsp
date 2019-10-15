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
 	<h1>Página teste getter e setter de bean</h1>
	<jsp:setProperty property="*" name="calcula"/>
	
	<jsp:getProperty property="nome" name="calcula"/>
	<br>	
	<jsp:getProperty property="idade" name="calcula"/>
	<br>	
	<jsp:getProperty property="sexo" name="calcula"/>
	
</body>
</html>