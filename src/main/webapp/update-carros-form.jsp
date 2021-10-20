<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Lista Carros</h2>
		</div>
	</div>

	<div id="container">
		<h3>Modificar Carro</h3>
		<form action="EstacionamentoControllerServlet" method="GET">
			<input type="hidden" name="command" value="UPDATE"/>
			<input type="hidden" name="carrosId" value="${T_carro.id }"/>
			<table>
				<tbody>
					<tr>
						<td><label>placa:</label></td>
						<td><input type="text" name="placa" value="${T_carro.placa }"/></td>
					</tr>

					<tr>
						<td><label>modelo:</label></td>
						<td><input type="text" name="modelo" value="${T_carro.modelo }"/></td>
					</tr>

					<tr>
						<td><label>horaentrada:</label></td>
						<td><input type="text" name="horaentrada" value="${T_carro.horaentrada }"/></td>
					</tr>
					
					<tr>
						<td><label>horasaida:</label></td>
						<td><input type="text" name="horasaida" value="${T_carro.horasaida }"/></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" /></td>
					</tr>

				</tbody>
			</table>
		</form>
		<div style="clear: both;"></div>
		<p>
			<a href="EstacionamentoControllerServlet">Back to List</a>
		</p>
	</div>
</body>
</html>