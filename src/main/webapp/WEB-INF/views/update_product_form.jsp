<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="./base.jsp" %>
</head>
<body>
	<div class="container mt-5">
		<div class="row align-items-center">
			<h1 class="text-center">Fill the product detail</h1>
			<div class="col-md-6 offset-md-3 " >
				<form action="${pageContext.request.contextPath}/update-product" method="post">
					<input type="text" name="id" value="${product.id}" style=" display:none;"/>
					<div class="mb-3">
					  <label for="name" class="form-label">Product Name</label>
					  <input type="text" value="${product.name}" class="form-control" id="name" name="name" placeholder="Enter the product name here">
					</div>
					<div class="mb-3">
					  <label for="description" class="form-label">Product Description</label>
					  <textarea class="form-control" rows="5" id="description" name="description" placeholder="Enter the product description  here">${product.description}</textarea>
					</div>
					<div class="mb-3">
					  <label for="price" class="form-label">Product Price</label>
					  <input type="text" class="form-control"  value="${product.price}" id="price" name="price" placeholder="Enter Product Price">
					</div>
					<div class="continer text-center">
						<a class="btn btn-outline-danger" href="${pageContext.request.contextPath}/">Back</a> 
						<button type="submit" class="btn btn-outline-primary">Update</button>
					</div>
		
				</form>
			</div>
		</div>
		
		
	</div>
</body>
</html>