<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration page</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<h2>Hello on registration page!</h2>
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
		<input name="role" type="radio" id="user" value="USER" checked>
        <label for="USER">Звичайний користувач</label>
        	<br>
        <input name="role" type="radio" id="administrator" value="ADMINISTRATOR">
        <label for="ADMINISTRATOR">Адміністратор</label>
        	<br>
		<input type="submit" value="Зареєстуватися">
	</form>



<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>