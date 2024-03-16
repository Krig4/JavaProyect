<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%
int r = (int) (Math.random() * 1000);
int g = (int) (Math.random() * 1000);
int b = (int) (Math.random() * 1000);
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agenda</title>
<style>
	body{
	background-color: rgb(<%=r%>, <%=g%>, <%=b%>);
	}
</style>
</head>
<body>
<form method="post" action="Servlet?accion=escribir">
        <h1>Formulario</h1>
        <label for="id_nombre">Nombre:</label>
        <input id="id_nombre" type="text" name="name" placeholder="Introduce tu nombre" required>
        <label for="id_apellido">Edad:</label>
        <input id="id_apellido" type="text" name="age" placeholder="Introduce tu edad" required>
        <label for="id_telefono">Teléfono:</label>
        <input id="id_telefono" type="text" name="tel" placeholder="Introduce tu nº telefono" required>
        <input type="submit" value="Guardar">
    </form>
    <a href="Servlet?accion=listar">Ver Contactos</a>
 <form method="post" action="Servlet?accion=buscar">
 		<h1>Busqueda de contactos</h1>
 		<label for="id_nombre">Nombre:</label>
        <input id="id_nombre" type="text" name="search" placeholder="Nombre para buscar" required>
        <input type="submit" value="Buscar">
 </form>
</body>
</html>