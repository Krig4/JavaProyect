<%@page import="object.Plato"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
String primero = (String) request.getAttribute("primero");
String segundo = (String) request.getAttribute("segundo");
String postre = (String) request.getAttribute("postre");
String mesa = (String) request.getAttribute("mesa");
String obs =  (String) request.getAttribute("obs");
ArrayList<Plato> platos = (ArrayList<Plato>) request.getAttribute("platos");
%>
</head>
<body>
	<%
		int price = 0;
	
		for (int i = 0; i < platos.size(); i += 1)
		{
			if (platos.get(i).getName().equals(primero))
				price += platos.get(i).getPrice();
			if (platos.get(i).getName().equals(segundo))
				price += platos.get(i).getPrice();
			if (platos.get(i).getName().equals(postre))
				price += platos.get(i).getPrice();			
		}
	%>
	
	<h1>Pedido Final</h1>
	<p>Primero: <%=primero %></p>
	<p>Segundo: <%=segundo %></p>
	<p>Postre: <%=postre %></p>
	<p>Mesa: <%=mesa %></p>
	<p>Observaciones: <%=obs %></p>
	<p>Precio Total: <%=price %></p>
	
	<form action="ExamServlet">
		<input type="hidden" name="primero" value='<%=primero %>'>
		<input type="hidden" name="segundo" value='<%=segundo %>'>
		<input type="hidden" name="postre" value='<%=postre %>'>
		<input type="hidden" name="mesa" value='<%=mesa %>'>
		<input type="hidden" name="obs" value='<%=obs %>'>
		<input type="hidden" name="action" value='savePedido'>
		<button>Completar Pago</button>
	</form>
</body>
</html>