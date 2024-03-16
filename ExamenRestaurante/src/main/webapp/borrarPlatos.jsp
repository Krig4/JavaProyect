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
	<h1>Ver platos</h1>
    <% ArrayList<Plato> listaPlatos = AccesoDatos.obtenerTodosPlatos();%>
    
    <%for(int i = 0; i < listaPlatos.size(); i++) {%>
    	<%Plato p = listaPlatos.get(i);%>
    	<p>Nombre: </p>
    	<%=p.getNombre() %>
    	<br>
    	<p>Precio: </p>
    	<%=p.getPrecio() %>
    	<br>
    	<p>Tipo: </p>
    	<%=p.getTipo() %>
    	<form action="Servlet">
			<input type="hidden" name="idPlato" value="<%= p.getId() %>">
			<input type="hidden" name="accion" value="borrarPlato">
			<input type="submit" value="Borrar">
    	</form>
    	<hr>
    	
    <%} %>
</body>
</html>