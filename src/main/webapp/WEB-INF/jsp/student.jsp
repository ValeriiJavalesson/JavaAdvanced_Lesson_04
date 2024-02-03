<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-default sticky-top shadow bg-light mb-3">
		<div class="container-fluid">
			<div class="navbar-header text-center h2 cursor-pointer">
				<a class="text-decoration-none text-black" href="/">SPRING <br>
					Multipart
				</a>
			</div>
			<div>
				<span class="h5">Список всих студентів:</span> <select
					id="student_list" onchange="getUser()">
					<c:forEach var="student" items="${students_list}">
						<option value="${student.id}">${student.firstName}
							${student.lastName}</option>
					</c:forEach>
				</select>
				<script>
					$("#student_list option[value='${current_student.id}']")
							.prop('selected', true);
				</script>
			</div>
		</div>
	</nav>
	<div class="container mt-2 ">
		<div class="d-flex flex-column align-items-center">
			<div class="card shadow border border-top-0 bg-light"
				style="width: 30rem;">
				<div class="d-flex align-items-center" style="height: 25rem;">
					<img id="user_photo" src="data:image/jpeg;base64,${photo}"
						class="card-img-top" alt="Student`s Photo"
						style="margin: auto; width: 100%;">
				</div>
				<div class="card-body mt-2">
					<ul class="list-group list-group-flush">
						<li class="list-group-item bg-light"><h5 class="text-primary">ID:</h5>
							${current_student.id}</li>
						<li class="list-group-item bg-light"><h5 class="text-primary">Ім’я:</h5>
							${current_student.firstName}</li>
						<li class="list-group-item bg-light"><h5 class="text-primary">Прізвище:</h5>
							${current_student.lastName}</li>
						<li class="list-group-item bg-light"><h5 class="text-primary">Вік:</h5>
							${current_student.age}</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="/js/student.js"></script>
</body>
</html>
