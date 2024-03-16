<%@page import= "java.util.ArrayList" %>
<%@ page import= "paqueteaccesodatos.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ver contactos</title>
</head>
<body>
ESTAS EN VER CONTACTOS
<% 
ArrayList<Contacto> contactos =(ArrayList<Contacto>) request.getAttribute("listaContacto");
String tabla_html = PintarHTML.crearTabla(contactos);
%>
<%=tabla_html %>
<a href="index.jsp">
    <button type="button">Volver al menu principal</button>
</a>
</body>
</html>