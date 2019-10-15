<%@ page language="java" contentType="text/html; 
charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:set var="numero" value="${100/3}"></c:set>
	
	<c:if test="${numero==50}">
		<c:redirect url="/pagina-acesso-liberado.jsp"/>
	</c:if>
	<c:if test="${numero<50}">
		<c:redirect url="http://www.javaavancado.com"/>
	</c:if>

<!--
	<c:url value="pagina-acesso-libera.jsp" var="acesso">
		<c:param name="param1" value="111"></c:param>
		<c:param name="param2" value="222"></c:param>
	</c:url>
	
	${acesso}

	<c:forTokens items="Alex-Fernando-Gian" delims="-" var="nome">
		Nome:<c:out value="${nome}"/>
		<br>
	</c:forTokens>

	<c:set var="numero" value="${100/3}"></c:set>
	
	
	<c:forEach var="n" begin="1" end="${numero}">
		Item:${n}
		<br>
	</c:forEach>
	
	<c:choose>
	
		<c:when test="${numero>50}">
			<c:out value="Numero maior que 50"/>
		</c:when>
		<c:when test="${numero<50}">
			<c:out value="Numero menor que 50"/>
		</c:when>
		<c:otherwise>
			<c:out value="Não encontrou o valor correto"/>
		</c:otherwise>
	</c:choose>

	<c:catch var="erro">
		<%= 100/0 %>
	</c:catch>
	
	<c:if test="${erro!=null}">
		${erro.message}
	</c:if>
	
	<c:out value="${'Curso Jstl'}"/>
	
  	<c:import var="data" url="https://www.google.com.br"/>
	
	<c:out value="${data}"/>

	
	<c:set var="data2" scope="page" value="${300*10}"></c:set>

	<c:out value="${data2}"/>
	
	<c:remove var="data2"/>

	<c:out value="${data2}"/>
	
	-->
	<p/>
	<p/>
	<p/>
</body>
</html>