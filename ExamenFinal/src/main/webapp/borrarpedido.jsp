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
</head>
<body>
ESTAS EN BORRAR PLATOS
<% 
ArrayList<Platos> platos =(ArrayList<Platos>) request.getAttribute("listarPlatos");
String tabla_html = PintarHTML.crearTabla(platos);
%>
<%=tabla_html %>
<a href="index.jsp">
    <button type="button">Volver al menu principal</button>
</a>
</body>
</html>