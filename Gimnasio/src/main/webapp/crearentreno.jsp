<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="paqueteobjetos.Ejercicio" %>
    <%@page import="paqueteobjetos.PintarHTML" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
if (session == null|| session.getAttribute("usuario") == null || !session.getAttribute("rol").equals("user")){
	response.sendRedirect("login.jsp");
}
String usuario=(String)session.getAttribute("usuario");
ArrayList<Ejercicio> lista_ejercicios=(ArrayList<Ejercicio>)request.getAttribute("lista_ejercicios");
if (usuario==null)
{
	request.getRequestDispatcher("index.jsp");
}
%>
<a href="Servlet?accion=verentrenos&usuario=<%=usuario%>"> </a>
<form action="Servlet" method="post">
<input type="hidden" name="usuario" value="<%=usuario%>">
<%

//Codigo para pintar los desplegables
out.print(PintarHTML.crearOpcion(1, lista_ejercicios));
out.print(PintarHTML.crearOpcion(2, lista_ejercicios));
out.print(PintarHTML.crearOpcion(3, lista_ejercicios));
out.print(PintarHTML.crearOpcion(4, lista_ejercicios));
%>
<button name="accion" type="submit" value="crearentreno">
Grabar
</button>
</form>


</body>
</html>