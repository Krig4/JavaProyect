<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="POST" action="Servlet">
        <h1>Añadir Plato</h1>
        <label for="id_tipo">Tipo:</label>
        <input id="id_tipo" type="text" name="tipo" placeholder="Introduce tipo de plato" required>
        <label for="id_nombre">Nombre:</label>
        <input id="id_nombre" type="text" name="nombre" placeholder="Introduce nombre plato" required>
        <label for="id_precio">Precio:</label>
        <input id="id_precio" type="text" name="precio" placeholder="Introduce el precio" required>
        <input type="hidden" name="accion" value="crearPlatos">
        <input type="submit" value="Enviar">
    </form>
     <a href="Servlet?accion=borrar">Borrar Platos</a>
     <a href="./verpedidos.jsp">Ver pedidos</a>
</body>
</html>