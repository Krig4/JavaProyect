<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Crear plato</h1>
	<form action="Servlet">
		<input type="hidden" name="accion" value="crearPlato">
		<label for="name">Nombre: </label>
    	<input type="text" name="name" id="name">
    	<label for="price">Precio: </label>
    	<input type="number" name="price" id="price">
    	<label for="type">Tipo: </label>
    	<input type="text" name="type" id="type">
    	
    	<input type="submit" value="Crear plato">
	</form>
</body>
</html>