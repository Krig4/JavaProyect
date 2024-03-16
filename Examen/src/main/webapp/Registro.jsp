<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrarse</title>
</head>
<body>
<form method="post" action="Servlet?accion=registro">
	<h1>Registrar Usuario</h1>
        <label for="id_usuario">Usuario:</label>
        <input id="id_usuario" type="text" name="user" placeholder="Introduce tu usuario" required>
        <label for="id_contrasena">Contraseña:</label>
        <input id="id_contrasena" type="text" name="password" placeholder="Introduce tu contraseña" required>
        <input type="submit" value="Guardar">
    </form>
</body>
</html>