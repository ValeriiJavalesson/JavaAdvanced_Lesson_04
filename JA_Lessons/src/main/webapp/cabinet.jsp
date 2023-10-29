<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User's cabinet</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<h2>Ви успішно ${userAction} в системі</h2>
	<h2>Вітаємо у вашому кабінеті, ${userEmail}!</h2>


	<jsp:include page="footer.jsp"></jsp:include>


</body>
</html>