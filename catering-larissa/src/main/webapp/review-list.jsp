<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<title>Larissa Catering</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" 
	crossorigin="anonymous">
	</head>
	<body>
	
		<header>
			<nav class="navbar navbar-expand-md navbar-dark"
				style="background-color: tomato">
				<div>
					<a href="https://www.cateringlarissa.com" class="navbar-brand"> Larissa Catering </a>
				</div>
	
				<ul class="navbar-nav">
					<li><a href="<%=request.getContextPath()%>/menulist"
						class="nav-link">Menus</a></li>
					<li><a href="<%=request.getContextPath()%>/reviewlist"
						class="nav-link">Reviews</a></li>
				</ul>
			</nav>
		</header>
		<br>
	
		<div class="row">
			<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->
	
			<div class="container">
				<h3 class="text-center">List of Reviews</h3>
				<hr>
				<div class="container text-left">
	
					<a href="<%=request.getContextPath()%>/newreview" class="btn btn-success">Add
						New Review</a>
				</div>
				<br>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Rating</th>
							<th>Description</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<!--   for (Todo todo: todos) {  -->
						<c:forEach var="review" items="${listReview}">
	
							<tr>
								<td><c:out value="${review.id}" /></td>
								<td><c:out value="${review.name}" /></td>
								<td><c:out value="${review.price}" /></td>
								<td><c:out value="${review.description}" /></td>
								<td><a href="edit?id=<c:out value='${review.id}' />">Edit</a>
									&nbsp;&nbsp;&nbsp;&nbsp; <a
									href="delete?id=<c:out value='${review.id}' />">Delete</a></td>
							</tr>
						</c:forEach>
						<!-- } -->
					</tbody>
	
				</table>
			</div>
		</div>
	</body>
</html>