<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Cocinero</title>
</head>
<body>
<h1>Login Cocinero</h1>
<form action="Servlet">
		<input type="hidden" name="accion" value="loginCocinero">
		<label for="nameLog">Nombre: </label>
    	<input type="text" name="nameLog" id="nameLog">
    	<label for="pwdLog">Password: </label>
    	<input type="password" name="pwdLog" id="pwdLog">
    	<input type="submit" value="Iniciar sesión">
	</form>
</body>
</html>