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
<%ArrayList<Platos> lista_platos = accesodatos.recuperarPlatos();%>
 <form action="Servlet">
        <input type="hidden" name="accion" value="crearPedido">
        <label name="mesa">Número de mesa: </label>
        <select name="mesa">
            <% for (int i = 1; i < 9; i++) { %>
                <option value=<%=i %>><%=i %></option>
            <% } %>
        </select>

        <div>
            <label name="primerPlato">Primer plato: </label>
            <select name="primerPlato">
                <% for (int i = 0; i < lista_platos.size(); i++) {
                	Platos plato = lista_platos.get(i);
                    if (plato.getTipo().equals("Primero")) { %>
                        <option value=<%=plato.getNombre() %>><%=plato.getNombre() %>(<%=plato.getPrecio() %>)</option>
                <% } } %>
            </select>
        </div>

        <div>
            <label name="segundoPlato">Segundo plato: </label>
            <select name="segundoPlato">
                <% for (int i = 0; i < lista_platos.size(); i++) {
                	Platos plato = lista_platos.get(i);
                    if (plato.getTipo().equals("Segundo")) { %>
                        <option value=<%=plato.getNombre() %>><%=plato.getNombre() %>(<%=plato.getPrecio() %>)</option>
                <% } } %>
            </select>
        </div>

        <div>
            <label name="postre">Postre: </label>
            <select name="postre">
                <% for (int i = 0; i < lista_platos.size(); i++) {
                	Platos plato = lista_platos.get(i);
                    if (plato.getTipo().equals("Postre")) { %>
                        <option value=<%=plato.getNombre() %>><%=plato.getNombre() %>(<%=plato.getPrecio() %>)</option>
                <% } } %>
            </select>
        </div>
		<label name="observacion">Observaciones: </label>
		<textarea name="observacion"></textarea>
		<br>
        <input type="submit" value="Hacer pedido">
    </form>
<a href="./login.jsp">Login</a>
</body>
</html>