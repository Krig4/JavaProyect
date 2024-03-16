<%@page import= "java.util.ArrayList" %>
<%@ page import= "paquetedatos.*" %>
<%@ page import= "paqueteobjetos.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%
if (session == null || session.getAttribute("usuario") == null || !session.getAttribute("rol").equals("admin")){
	response.sendRedirect("index.jsp");
}
%>
<meta charset="ISO-8859-1">
<title>Reservas realizadas</title>
</head>
<body>
<h1>Ver pedidos</h1>
    <% ArrayList<Reservas> lista_reservas = accesodatos.obtenerTodosPedidos();%>
	<table>
	<tr>
		<th>Cliente</th>
		<th>Fecha</th>
		<th>Numero Entradas</th>
	</tr><%for(int i = 0; i < lista_reservas.size(); i++){%>
		<%Reservas p = lista_reservas.get(i);%>
		<div id=<%=p.getId() %>>
		<tr>
			<td><%=p.getUsuario() %></td>
			<td><%=p.getFecha() %></td>
			<td><%=p.getEntradas() %></td>
		</tr>
		</div>
		<%} %>
	</table>
</body>
</html>