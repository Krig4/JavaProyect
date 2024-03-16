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
<h1>Ver pedidos</h1>
    <% ArrayList<Pedidos> lista_pedidos = accesodatos.obtenerTodosPedidos();%>
	<table>
	<tr>
		<th>Fecha</th>
		<th>Primero</th>
		<th>Segundo</th>
		<th>Postre</th>
		<th>Observacion</th>
		<th>Entregado</th>
	</tr>
	<%for(int i = 0; i < lista_pedidos.size(); i++){%>
		<%Pedidos p = lista_pedidos.get(i);%>
		<%if(p.getIsComplete() == 0) {%>
		<div id=<%=p.getId() %>>
		<tr>
			<td><%=p.getDate() %></td>
			<td><%=p.getPrimero() %></td>
			<td><%=p.getSegundo() %></td>
			<td><%=p.getPostre() %></td>
			<td><%=p.getObs() %></td>
			<form action="Servlet">
				<input type="hidden" name="accion" value="entregarPedido">
				<input type="hidden" name="idPedido" value="<%= p.getId() %>">
				
				<%if(p.getIsComplete()==0){%>
					<td><button id="pedido_"+<%=p.getId() %>>No entregado</button></td>
				<%} else {%>
					<td><button id="pedido_"+<%=p.getId() %>>Entregado</button></td>
				<%} %>
			</form>
			
		</tr>
		</div>
		<%} %>
	<%} %>
	</table>
<a href="./insertarplatos.jsp">Crear plato</a>
<form action="Servlet">
		<input type="hidden" name="accion" value="exportarCSV">
		<button>CSV</button>
	</form><br>
</body>
</html>