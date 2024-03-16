<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="paqueteobjetos.Plato" %>
<%@ page import="paquetedatos.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Realizar pedido</title>
</head>
<body>
    <h1>Realiza tu pedido</h1>
    <% ArrayList<Plato> listaPlatos = AccesoDatos.obtenerTodosPlatos();%>
    <form action="Servlet">
        <input type="hidden" name="accion" value="crearPedido">
        <label name="numMesa">Número de mesa: </label>
        <select name="numMesa">
            <% for (int i = 1; i < 9; i++) { %>
                <option value=<%=i %>><%=i %></option>
            <% } %>
        </select>

        <div>
            <label name="primerPlato">Primer plato: </label>
            <select name="primerPlato">
                <% for (int i = 0; i < listaPlatos.size(); i++) {
                	Plato plato = listaPlatos.get(i);
                    if (plato.getTipo().equals("Primero")) { %>
                        <option value=<%=plato.getNombre() %>><%=plato.getNombre() %>(<%=plato.getPrecio() %>)</option>
                <% } } %>
            </select>
        </div>

        <div>
            <label name="segundoPlato">Segundo plato: </label>
            <select name="segundoPlato">
                <% for (int i = 0; i < listaPlatos.size(); i++) {
                	Plato plato = listaPlatos.get(i);
                    if (plato.getTipo().equals("Segundo")) { %>
                        <option value=<%=plato.getNombre() %>><%=plato.getNombre() %>(<%=plato.getPrecio() %>)</option>
                <% } } %>
            </select>
        </div>

        <div>
            <label name="postre">Postre: </label>
            <select name="postre">
                <% for (int i = 0; i < listaPlatos.size(); i++) {
                	Plato plato = listaPlatos.get(i);
                    if (plato.getTipo().equals("Postre")) { %>
                        <option value=<%=plato.getNombre() %>><%=plato.getNombre() %>(<%=plato.getPrecio() %>)</option>
                <% } } %>
            </select>
        </div>
		<label name="obs">Observaciones: </label>
		<textarea name="obs"></textarea>
		<br>
        <input type="submit" value="Hacer pedido">
    </form>
    <a href="./crearCocinero.jsp">Insertar nuevo cocinero</a>
</body>
</html>
