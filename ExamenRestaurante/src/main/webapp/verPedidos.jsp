<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
<%@ page import="paqueteobjetos.*" %>
<%@ page import="paquetedatos.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
    // Verificar si el cocinero ha iniciado sesi�n
    if (session == null || session.getAttribute("cocinero") == null) {
        // El cocinero no ha iniciado sesi�n, redirigir a la p�gina de inicio de sesi�n
        response.sendRedirect("loginCocinero.jsp"); // Reemplaza "login.jsp" con tu p�gina de inicio de sesi�n
        return; // Termina la ejecuci�n del c�digo JSP
    }
%>
<h1>Ver pedidos</h1>
    <h1>Bienvenido <%= session.getAttribute("nombreCocinero") %></h1>
    <% ArrayList<Pedido> listaPedidos = AccesoDatos.obtenerTodosPedidos();%>
	<table>
	<tr>
		<th>Fecha</th>
		<th>Primero</th>
		<th>Segundo</th>
		<th>Postre</th>
		<th>Observacion</th>
		<th>Entregado</th>
	</tr>
	<%for(int i = 0; i < listaPedidos.size(); i++){%>
		<%Pedido p = listaPedidos.get(i);%>
		<%if(p.getEntregado() == false) {%>
		<div id=<%=p.getId() %>>
		<tr>
			<td><%=p.getFecha() %></td>
			<td><%=p.getPrimero() %></td>
			<td><%=p.getSegundo() %></td>
			<td><%=p.getPostre() %></td>
			<td><%=p.getObs() %></td>
			<form action="Servlet">
				<input type="hidden" name="accion" value="entregarPedido">
				<input type="hidden" name="idPedido" value="<%= p.getId() %>">
				
				<%if(p.getEntregado()==false){%>
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
<a href="./crearPlato.jsp">Crear plato</a>
<a href="./borrarPlatos.jsp">Borrar plato</a>
</body>
</html>