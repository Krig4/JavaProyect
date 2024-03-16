<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Añadir ejercicios</title>
</head>
<body>
	<form method="post" action="Servlet?accion=ejercicio">
	<h1>Crear nuevo ejercicio</h1>
        <label for="ejercicio">Ejercicio:</label>
        <input id="ejercicio" type="text" name="ejercicio" placeholder="Nombre nuevo ejercicio" required>
        <input type="submit" value="Guardar">
    </form>
</body>
</html>