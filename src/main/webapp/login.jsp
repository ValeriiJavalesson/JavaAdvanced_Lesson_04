<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Вхід</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	
	<h1>Сторінка авторизації</h1>
	<p>
	<p>
	<p>
	<form action="login" method="post">
		<label for="login">Логін :</label> <input name="login"> <br>
		<label for="password">Пароль : </label> <input name="password">
		<br> <input type="submit" value="Ввійти">
	</form>
	
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>