<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<html>

	<head>
		<meta charset="ISO-8859-1">
		<title>Catalog</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
		<link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
		<link rel="stylesheet" href="jsp/style/css/catalog.css">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
		<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
	</head>

	<body>
		<main>
			<nav class="navbar navbar-default sticky-top shadow bg-light mb-3">
				<div class="container-fluid">
					<div class="navbar-header text-center h2">SPRING <br> MVC</div>
					<div class="">
						<ul class="nav navbar-nav">
							<c:choose>
								<c:when test="${mode == 'VIEW'}">
									<a class="btn btn-primary btn-lg" href="new" role="button">New Participant</a>
								</c:when>
								<c:when test="${mode == 'CREATE' || mode == 'EDIT'}">
									<a class="btn btn-primary btn-lg" href="catalog" role="button">Catalog</a>
								</c:when>
							</c:choose>
						</ul>
					</div>
				</div>
			</nav>
			<div class="container">
				<c:choose>
					<c:when test="${mode == 'VIEW'}">

						<div class="table table-striped">
							<div class="container">
								<ol class="list-group list-group-numbered">
									<c:forEach var="participant" items="${participants}">
										<li
											class="list-group-item d-flex justify-content-between align-items-start text-bg-light m-2">
											<div
												class="ms-2 me-auto d-flex flex-row justify-content-between align-items-end w-100">
												<div>
													<div>Name: ${participant.name}</div>
													<div>Email: ${participant.email}</div>
													<div>Level: ${participant.level}</div>
													<div>Primary Skill: ${participant.primarySkill}</div>
												</div>
												<div class="d-flex flex-row justify-content-end">
													<div class="m-1">
														<a href="update?id=${participant.id}" class="btn btn-primary"
															role="button">edit</a>
													</div>
													<div class="m-1">
														<a href="delete?id=${participant.id}" class="btn btn-danger"
															role="button">delete</a>
													</div>
												</div>
											</div> <span
												class="badge bg-primary rounded-pill">ID:${participant.id}</span>
										</li>
									</c:forEach>
								</ol>
							</div>
						</div>
					</c:when>

					<c:when test="${mode == 'EDIT' || mode == 'CREATE'}">
						<form action="save" method="POST" class="fw-bold">
							<input type="hidden" value="${participant.id}" class="form-control m-3 mt-0" id="id"
								name="id">
							<div class="form-group m-3 mt-0">
								<label for="name">Name:</label> <input type="text" class="form-control" id="name"
									name="name" value="${participant.name}">
							</div>
							<div class="form-group m-3 mt-0">
								<label for="email">E-mail:</label> <input type="text" class="form-control" id="email"
									name="email" value="${participant.email}">
							</div>
							<div class="form-group m-3 mt-0">
								<label for="level">Level</label>
								<select class="form-select form-control select_value" id="level" name="level">
									<option value="L1">L1</option>
									<option value="L2">L2</option>
									<option value="L3">L3</option>
									<option value="L4">L4</option>
									<option value="L5">L5</option>
									
								</select>
								<script>
										$(".select_value option[value='${participant.level}']").prop('selected', true);
								</script>
							</div>
							<div class="form-group m-3 mt-0">
								<label for="primarySkill">Primary skill:</label> <input type="text" class="form-control"
									id="primarySkill" name="primarySkill" value="${participant.primarySkill}">
							</div>
							<div class="d-flex justify-content-between m-3">
								<button type="submit" class="btn btn-success">Submit</button>
								<c:choose>
									<c:when test="${mode == 'EDIT'}">
										<a class="btn btn-danger" href="catalog" role="button">Cancel
											edit</a>
									</c:when>
									<c:when test="${mode == 'CREATE'}">
										<a class="btn btn-danger" href="catalog" role="button">Cancel
											create</a>
									</c:when>
								</c:choose>
								
							</div>
						</form>
					</c:when>
				</c:choose>
			</div>




		</main>


		
	</body>

	</html>