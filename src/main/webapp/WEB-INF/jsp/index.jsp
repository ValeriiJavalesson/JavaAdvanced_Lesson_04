<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>JavaAdvanced_Lessons - lesson_19 - Spring Multipart</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css"
	rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-default sticky-top shadow bg-light mb-3">
		<div class="container-fluid">
			<div class="navbar-header text-center h2 cursor-pointer">
				<a class="text-decoration-none text-black" href="/">SPRING <br>	Multipart</a>
			</div>
		</div>
	</nav>
	<div class="container">
		<form class="input-group d-flex flex-column" method="post" action="/register" enctype="multipart/form-data">
			<div class="input-group m-3">
				<span class="input-group-text" id="addon-wrapping-fn">Ім’я</span> 
				<input type="text" id="firstName" name="firstName" class="form-control"	aria-label="First Name:" aria-describedby="addon-wrapping-fn">
			</div>
			<div class="input-group m-3">
				<span class="input-group-text" id="addon-wrapping-ln">Прізвище</span> 
				<input type="text"  id="lastName" name="lastName" class="form-control" aria-label="Last Name:" aria-describedby="addon-wrapping-ln">
			</div>
			<div class="input-group m-3">
				<span class="input-group-text" id="addon-wrapping-age">Вік</span> 
				<input type="text" id="age" name="age" class="form-control" aria-label="Age:" aria-describedby="addon-wrapping-age">
			</div>
			<div class="input-group m-3">
				<input type="file" id="photo" name="photo" class="form-control" aria-describedby="inputGroupFile" aria-label="Upload">
				<button class="btn btn-outline-secondary" type="submit"	id="inputGroupFile">Зберегти</button>
			</div>
		</form>
	</div>
</body>
</html>
