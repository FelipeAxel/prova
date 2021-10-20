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
		<h3>Adicionar Carro</h3>
		<h4>O id é automatico!</h4>
		<form action="EstacionamentoControllerServlet" method="GET">
				<input type ="hidden" name ="command" value= "ADD">
			<input type="hidden" name="command" value="ADD"/>
			<table>
				<tbody>
					<tr>
						<td><label>placa:</label></td>
						<td><input type="text" name="placa" /></td>
					</tr>

					<tr>
						<td><label>modelo:</label></td>
						<td><input type="text" name="modelo" /></td>
					</tr>

					<tr>
						<td><label>hora entrada:</label></td>
						<td><input type="text" name="horaentrada" /></td>
					</tr>
					
					<tr>
						<td><label>hora saida:</label></td>
						<td><input type="text" name="horasaida" /></td>
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