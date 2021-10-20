<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
ServletContext context = getServletContext();
String projeto = context.getInitParameter("nomeprojeto");
%>
<h2><%=projeto%></h2>
	<form action ="EstacionamentoServlet" method="GET">
	id:<input type="text" name="id"/>
	placa:<input type="text" name="placa"/>
	modelo:<input type="text" name="modelo"/>
	hora entrada:<input type="text" name="horaentrada"/>
	hora saida:<input type="text" name="horasaida"/>
	<input type ="submit" value="Send"/>
	</form>
</body>
</html>