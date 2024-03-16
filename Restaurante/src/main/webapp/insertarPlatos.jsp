<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Insertar Plato</h1>
	<form action="ExamServlet">
		<input type="text" name="name" id="name" required>
		<select name="type" id="type">
			<option value="primero/segundo">Primero/segundo</option>
			<option value="postre">Postre</option>
		</select>
		<input type="number" name="price" id="price" required>
		<input type="hidden" name="action" value="ingresarPlato">
		<button>Insertar</button>
	</form><br>
	<form action="ExamServlet">
		<input type="hidden" name="action" value="borrar">
		<button>Borrar Platos</button>
	</form>
	<br>
	<form action="ExamServlet">
		<input type="hidden" name="action" value="mostrarPedidos">
		<button>Mostrar Pedidos</button>
	</form>
</body>
</html>