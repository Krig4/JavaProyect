<%@page import= "java.util.ArrayList" %>
<%@ page import= "paquetedatos.*" %>
<%@ page import= "paqueteobjetos.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%
if (session == null|| session.getAttribute("usuario") == null || !session.getAttribute("rol").equals("user")){
	response.sendRedirect("login.jsp");
}
String usuario=(String)session.getAttribute("usuario");
if (usuario==null)
{
	request.getRequestDispatcher("index.jsp");
}
%>
<meta charset="ISO-8859-1">
<title>Comprar</title>
</head>
<body>
<form action="Servlet">
        <input type="hidden" name="accion" value="crearPedido">
        <label name="entrada">Número de entradas: </label>
        <select name="entrada">
            <% for (int i = 1; i < 5; i++) { %>
                <option value=<%=i %>><%=i %></option>
            <% } %>
        </select>
<button name="accion" type="submit" value="crearPedido">
Comprar
</button>
</form>
</body>
</html>