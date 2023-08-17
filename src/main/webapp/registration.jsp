<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h1>Registration page</h1>
<p>
<p>
<p>
<form action="registration" method="post">
	
		<label for="firstName">First Name :</label> <input name="firstName">
			<br>
		<label for="lastName">Last Name :</label> <input name="lastName">
			<br>
		<label for="email">Email :</label> <input name="email">
			<br>	
		<label for="password">Password : </label> <input name="password">
			<br>
		<input name="accessLevel" type="radio" id="user" value="user" checked>
        <label for="user">Звичайний користувач</label>
        	<br>
        <input name="accessLevel" type="radio" id="admin" value="admin">
        <label for="admin">Адміністратор</label>
        	<br>
		<input type="submit" value="Зареєстуватися">
	</form>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>