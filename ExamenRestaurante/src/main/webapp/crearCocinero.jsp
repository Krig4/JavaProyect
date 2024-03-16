<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insertar cocinero</title>
</head>
<body>
	<h1>Crear cocinero</h1>
	<form action="Servlet" method="post">
	    <input type="hidden" name="accion" value="crearCocinero">
		<label for="name">Nombre: </label>
    	<input type="text" name="name" id="name">
    	<label for="pwd">Password: </label>
    	<input type="password" name="pwd" id="pwd">
        <input type="submit" value="Registrar">
    </form>
    <a href="./loginCocinero.jsp">Login cocinero</a>
</body>
</html>