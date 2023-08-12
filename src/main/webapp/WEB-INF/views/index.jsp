<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored = "false" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="./base.jsp" %>
</head>
<body>
	<div class="container mt-5 text-center">
		<div class="row">
			<div class="col-12">
				<h1>Welcome to Product App</h1>
				<table class="table">
					<thead>
						<tr class="table-dark">
							<th scope="col">ID</th>
							<th scope="col">Product Name</th>
							<th scope="col">Description</th>
							<th scope="col">Price</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${products}" var="product">
							<tr>
								<td scope="row">${product.id}</td>
								<td>${product.name}</td>
								<td>${product.description}</td>
								<th>&#8360.${product.price}</th>
								<td>
									<a href="delete/${product.id}"><i class="fa-solid fa-trash" style="margin-right:10px; font-size: 20px;"></i></a>
									<a href="update/${product.id}"><i class="fa-regular fa-pen-to-square" style=" font-size: 20px;"></i></a>
								
								</td>
							</tr>
						
						</c:forEach>
					</tbody>
					
				
				</table>
				<div class="container text-center">
					<a class="btn btn-success" href="add-product">Add Product</a>
				</div>
			
			</div>
		
		
		</div>
	</div>
</body>
</html>