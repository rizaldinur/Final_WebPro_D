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
				<h3 class="text-center">List of Menus</h3>
				<hr>
				<div class="container text-left">
	
					<a href="<%=request.getContextPath()%>/newmenu" class="btn btn-success">Add
						New Menu</a>
				</div>
				<br>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Type</th>
							<th>Price</th>
							<th>Description</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<!--   for (Todo todo: todos) {  -->
						<c:forEach var="menu" items="${listMenu}">
	
							<tr>
								<td><c:out value="${menu.id}" /></td>
								<td><c:out value="${menu.name}" /></td>
								<td><c:out value="${menu.type}" /></td>
								<td><c:out value="${menu.price}" /></td>
								<td><c:out value="${menu.description}" /></td>
								<td><a href="edit?id=<c:out value='${menu.id}' />">Edit</a>
									&nbsp;&nbsp;&nbsp;&nbsp; <a
									href="delete?id=<c:out value='${menu.id}' />">Delete</a></td>
							</tr>
						</c:forEach>
						<!-- } -->
					</tbody>
	
				</table>
			</div>
		</div>
	</body>
</html>