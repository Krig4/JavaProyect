<%@page import= "java.util.ArrayList" %>
<%@ page import= "paquetedatos.*" %>
<%@ page import= "paqueteobjetos.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%
ArrayList<Platos> lista_platos = (ArrayList<Platos>) request.getAttribute("lista_platos");
%>
</head>
<body>
<h1>Borrar Platos</h1>
	<%
	out.print(PintarHTML.crearTabla(lista_platos));
	%>
	<a href="insertarplatos.jsp">Insertar Platos</a><br>
		<br>
</body>
</html>