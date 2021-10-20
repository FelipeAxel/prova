<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- 	<sql:setDataSource 
	driver ="com.mysql.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/estacionamento?useSSL=false&serverTimezone=UTC"
	user="root"
	password="root"
	var="snapshot"/>
	 
	<sql:query var="result" dataSource="${snapshot}">
		select * from carros
	</sql:query>
	-->
	<script>
	function addcarro(){
		window.location.href='add-carro.jsp';
		return false;
	}
	
	</script>
	<input type = "button" value = "Adicionar Carro" onclick="addcarro()"/>
	<table border="1">
	<tr>
		<td>id</td>
		<td>placa</td>
		<td>modelo</td>
		<td>hora entrada</td>
		<td>hora saida</td>
		<td>Action</td>
	</tr>
	<c:forEach var ="tempCarros" items="${carro_lista}">
	<c:url var="tempLinkUpdate" value="EstacionamentoControllerServlet">
		<c:param name ="command" value="LOAD"></c:param>
		<c:param name="carrosId" value="${tempCarros.id}"> </c:param>
	</c:url>
		<c:url var="tempLinkDelete" value="EstacionamentoControllerServlet">
		<c:param name ="command" value="DELETE"></c:param>
		<c:param name="carrosId" value="${tempCarros.id}"> </c:param>
	</c:url>
	<tr>
		<td><c:out value="${tempCarros.id}"/></td>
		<td><c:out value="${tempCarros.placa}"/></td>
		<td><c:out value="${tempCarros.modelo}"/></td>
		<td><c:out value="${tempCarros.horaentrada}"/></td>
		<td><c:out value="${tempCarros.horasaida}"/></td>
		<td>
		<a href="${	tempLinkUpdate }">Update</a> |
		<a href="${	tempLinkDelete }" onclick = "if(!(confirm('Deseja excluir?'))) return false">Delete</a>
		</td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>