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
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${menu != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${menu == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${menu != null}">
            				Edit Menu
            			</c:if>
					</h2>
				</caption>

				<c:if test="${menu != null}">
					<input type="hidden" name="id" value="<c:out value='${menu.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Name</label> <input type="text"
						value="<c:out value='${menu.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Type</label> <input type="text"
						value="<c:out value='${menu.type}' />" class="form-control"
						name="type">
				</fieldset>

				<fieldset class="form-group">
					<label>Price</label> <input type="number"
						value="<c:out value='${menu.price}' />" class="form-control"
						name="price">
				</fieldset>
	
				<fieldset class="form-group">
					<label>Description</label> <input type="text"
						value="<c:out value='${menu.description}' />" class="form-control"
						name="description">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>