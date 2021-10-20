<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"  %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<sql:setDataSource 
	driver ="com.mysql.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/estacionamento?useSSL=false&serverTimezone=UTC"
	user="root"
	password="root"
	var="snapshot"/>

<sql:update dataSource="${snapshot }">
	INSERT INTO carros (id, placa, modelo, horaentrada, horasaida)VALUE(3,12345,"mustang","13:00", "12:00")
</sql:update>	
	
</body>
</html>