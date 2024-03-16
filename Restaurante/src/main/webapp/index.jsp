<%@page import="object.Plato"%>
<%@page import="com.mysql.cj.x.protobuf.MysqlxDatatypes.Array"%>
<%@page import="object.Pedido"%>
<%@page import="java.util.ArrayList"%>
<%@page import="object.User"%>
<%@page import="data.PhpMyAdmin"%>
<%@page import="data.MysqlData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	ArrayList<Plato> platos = MysqlData.getPlatos(); 
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header style="dislplay: flex; flex-direction: row;">
		<h1>Restaturante Carlos</h1>
		<a href="login.jsp">Soy Cocinero, Iniciar Sesión</a>
	</header>
	<form action="ExamServlet" method="get">
		<p>Primero</p>
		<select name="primero">
		<%
			for(int i = 0; i < platos.size(); i += 1)
			{
				if (!platos.get(i).getType().equals("postre"))
					out.write("<option value= '" + platos.get(i).getName()+"'>" + platos.get(i).getName() + " - "+platos.get(i).getPrice()+" euros </option>");
			}
		%>
		</select><br>
		<p>Segundo</p>
		<select name="segundo">
		<%
			for(int i = 0; i < platos.size(); i += 1)
			{
				if (!platos.get(i).getType().equals("postre"))
					out.write("<option value= '" + platos.get(i).getName()+"'>" + platos.get(i).getName() + " - "+platos.get(i).getPrice()+" euros </option>");
			}
		%>
		</select><br>
		<p>Postre</p>
		<select name="postre">
		<%
			for(int i = 0; i < platos.size(); i += 1)
			{
				if (platos.get(i).getType().equals("postre"))
					out.write("<option value= '" + platos.get(i).getName()+"'>" + platos.get(i).getName() + " - "+platos.get(i).getPrice()+" euros </option>");
			}
		%>
		</select><br>
		<p>Mesa</p>
		<select name="mesa">
			<option value='1'>1</option>
			<option value='2'>2</option>
			<option value='3'>3</option>
			<option value='4'>4</option>
			<option value='5'>5</option>
			<option value='6'>6</option>
			<option value='7'>7</option>
			<option value='8'>8</option>
		</select><br>
		<p>Observaciones</p>
		<textarea rows="" cols="" name="obs" required></textarea>
		<input type='hidden' name='action' value='solicitar'>
		<button>Solicitar</button>
	</form>
</body>
</html>