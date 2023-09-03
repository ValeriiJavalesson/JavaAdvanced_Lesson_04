<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Реєстрація</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h1>Сторінка реєстрації</h1>
<p>
<p>
<p>
<form action="registration" method="post">
	
		<label for="firstName">Ім’я :</label> <input name="firstName">
			<br>
		<label for="lastName">Прізвище :</label> <input name="lastName">
			<br>
		<label for="email">Email :</label> <input name="email">
			<br>	
		<label for="password">Пароль : </label> <input name="password">
			<br>
		<input name="accessLevel" type="radio" id="user" value="user" checked>
        <label for="user">Звичайний користувач</label>
        	<br>
        <input name="accessLevel" type="radio" id="admin" value="administrator">
        <label for="admin">Адміністратор</label>
        	<br>
		<input type="submit" value="Зареєстуватися">
	</form>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>