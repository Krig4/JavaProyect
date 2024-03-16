<%@page import="org.hibernate.internal.build.AllowSysOut"%>
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
	if (session.getAttribute("username") == null)
		request.getRequestDispatcher("index.jsp").forward(request, response);
	ArrayList<Plato> platos = (ArrayList<Plato>) request.getAttribute("platos"); 
%>
</head>
<body>
	<h1>Borrar Platos</h1>
	<%
		if (platos.size() > 0)
		{
			out.write("<table style='border: solid 1px black'>");
			out.write("<tr style='border: solid 1px black'>");
			out.write("<td style='border: solid 1px black'>ID </td>");
			out.write("<td style='border: solid 1px black'>Nombre </td>");
			out.write("<td style='border: solid 1px black'>Precio </td>");
			out.write("<td style='border: solid 1px black'>Tipo </td>");
			out.write("<td style='border: solid 1px black'>Borrar </td>");
			out.write("</tr>");
			for(int i = 0; i < platos.size(); i += 1)
			{
				out.write("<tr style='border: solid 1px black'>");
				out.write("<td style='border: solid 1px black'>" + platos.get(i).getId() + "</td>");
				out.write("<td style='border: solid 1px black'>" + platos.get(i).getName() + "</td>");
				out.write("<td style='border: solid 1px black'>" + platos.get(i).getPrice() + "</td>");
				out.write("<td style='border: solid 1px black'>" + platos.get(i).getType() + "</td>");
				out.write("<td style='border: solid 1px black'>");
				out.write("<form method='ExamServlet'>");
				out.write("<input type='hidden' name='idPlato' value='" +platos.get(i).getId()+ "'>");
				out.write("<input type='hidden' name='action' value='borrarPlato'>");
				out.write("<button>Delete</button>");
				out.write("</form>");
				out.write("</td>");
				out.write("</tr>");
			}
			out.write("</table><br>");
		}
		else
			out.write("<h3>No existen platos</h3>");
	%>
	<a href="insertarPlatos.jsp">Insertar Platos</a><br>
		<br>
	<form action="ExamServlet">
		<input type="hidden" name="action" value="mostrarPedidos">
		<button>Mostrar Pedidos</button>
	</form>
</body>
</html>