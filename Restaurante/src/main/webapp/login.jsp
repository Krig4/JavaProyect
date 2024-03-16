<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Iniciar Sesión</h1>
	<form action="ExamServlet" method="post">
		<input type="text" name="username" id="username" required>
		<input type="password" name="password" id="password" required>
		<input type="hidden" name="action" value="login">
		<button type="submit">Iniciar Sesión</button>
	</form>
</body>
</html>