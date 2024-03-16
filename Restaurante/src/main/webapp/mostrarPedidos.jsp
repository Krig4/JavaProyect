<%@page import="object.Pedido"%>
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
		ArrayList<Pedido> pedidos = (ArrayList<Pedido>)request.getAttribute("pedidos");
	%>
</head>
<body>
	<%
		out.write("<h3>Hola " + session.getAttribute("username") + "</h3>");
		if(pedidos.size() > 0)
		{
			out.write("<table style='border: solid 1px black'>");
			out.write("<tr style='border: solid 1px black'>");
			out.write("<td style='border: solid 1px black'>ID </td>");
			out.write("<td style='border: solid 1px black'>Primero </td>");
			out.write("<td style='border: solid 1px black'>Segundo </td>");
			out.write("<td style='border: solid 1px black'>Postre </td>");
			out.write("<td style='border: solid 1px black'>Mesa </td>");
			out.write("<td style='border: solid 1px black'>Observaciones </td>");
			out.write("<td style='border: solid 1px black'>Fecha </td>");
			out.write("<td style='border: solid 1px black'>¿Completado? </td>");
			out.write("</tr>");
			for(int i = 0; i < pedidos.size(); i += 1)
			{
				if (pedidos.get(i).getIsComplete() == 0)
				{
					out.write("<tr style='border: solid 1px black'>");
					out.write("<td style='border: solid 1px black'>" + pedidos.get(i).getId() + "</td>");
					out.write("<td style='border: solid 1px black'>" + pedidos.get(i).getPrimero() + "</td>");
					out.write("<td style='border: solid 1px black'>" + pedidos.get(i).getSegundo() + "</td>");
					out.write("<td style='border: solid 1px black'>" + pedidos.get(i).getPostre() + "</td>");
					out.write("<td style='border: solid 1px black'>" + pedidos.get(i).getMesa() + "</td>");
					out.write("<td style='border: solid 1px black'>" + pedidos.get(i).getObs() + "</td>");
					out.write("<td style='border: solid 1px black'>" + pedidos.get(i).getDate().toString() + "</td>");
					out.write("<td style='border: solid 1px black'>");
					out.write("<form method='ExamServlet'>");
					out.write("<input type='hidden' name='idPedido' value='" +pedidos.get(i).getId()+ "'>");
					out.write("<input type='hidden' name='action' value='borrarPedido'>");
					out.write("<button>Completado</button>");
					out.write("</form>");
					out.write("</td>");
					out.write("</tr>");
				}
			}
			out.write("</table><br>");
		}
		else
			out.write("<br>No existen pedidos<br>");
	%>
	<a href="insertarPlatos.jsp">Insertar Platos</a><br>
	<form action="ExamServlet">
		<input type="hidden" name="action" value="borrar">
		<button>Borrar Platos</button>
	</form><br>
	
	<form action="ExamServlet">
		<input type="hidden" name="action" value="csv">
		<button>CSV</button>
	</form><br>
	<footer>
		<form action="logout.jsp">
			<input type="hidden" name="action" value="logout">
			<button>Cerrar Sesión</button>
		</form>
	</footer>
</body>
</html>