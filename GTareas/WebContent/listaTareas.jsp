<%@page import = "modelo.ListaTareas" %>
<%@page import = "modelo.Tarea" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset='UTF-8' >
	<meta name='viewport' content='width=device-width, initial-scale=1.0'>
	<meta charset="utf-8">
	<title>Gestor de tareas</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link href="css/style.css" type="text/css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<h3 id="tit">Mis tareas</h3>
		<div>
			<a href="altasTareas.jsp">
				Añadir nueva tarea
			</a>
		</div>
		
		
		<table>
		
			<%
				ListaTareas lista = new ListaTareas();
				lista.obtenerTareas();
				String guardarTarea = lista.imprimirListas();
			%>
			
		<%=guardarTarea%>
		</table>
	</div>
</body>
</html>