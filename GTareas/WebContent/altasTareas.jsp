<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import = "modelo.Tarea" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta name='viewport' content='width=device-width, initial-scale=1.0'>
	<meta charset="utf-8">
	<title>Gestor de tareas</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body>	
	<% 
		boolean ISSETGet = false;
		Tarea t = new Tarea();
		
		if(request.getParameter("id") != null) {
			int id = Integer.parseInt(request.getParameter("id"));
			t.buscarID(id);
			ISSETGet = true;
		}
		System.out.println(t.getId());
	%>
	
		<form method="post" action="AltaTarea">
			<input type="hidden" name="id" value="<%=t.getId()%>">
			<h3>Nueva tarea</h3>
			<div class="form-group">
		    	<label for="titulo">Título</label>
		    	<input name="titulo" type="text" id="titulo" required>
		  	</div>
		  	<div>
			    <label for="description">Descripción</label>
			    <input name="descripcion" type="text" required>
			</div>
		  	<div>
		    	<label for="category">Categoría</label>
		    	<select name="categoria" required>
				      <option value="0">Personal</option>
				      <option value="1">Proyectos IMF</option>
				      <option value="2">Prácticas</option>
		    	</select>
		  	</div>
		  	<div>
		    	<label for="important">Importancia</label>
		    	<select name="importancia" id="importantTask" required>
				      <option value="0">Baja</option>
				      <option value="1">Media</option>
				      <option value="2">Alta</option>
		    	</select>
		  	</div>
			<div>
				<label for="fechaInicio">Fecha de inicio</label>
				<input type="date" name="fecha_inicio" required>
			</div>
			<div>
				<label for="fechaFin">Fecha fin</label>
				<input type="date" name="fecha_fin" required>
			</div>
			<div>
		    	<select type="hidden" name="dependencia">
				      <option selected value="0">...</option>
		    	</select>
		  	</div>
			
		  	<hr><button type="submit">Enviar</button>
		</form>
</body>
</html>