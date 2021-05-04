<html>
<head>
<%@include file="./base.jsp" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

</head>
<body>
<div class="container mt-3">
	
	<div class="row">
	
		<div class="col-md-12">
		
		<h1 class="text-center mb-3">Welcome to Product App</h1>
		
					<table class="table">
			   <thead class="table-dark">
			    <tr>
			      <th scope="col">ID</th>
			      <th scope="col">Product Name</th>
			      <th scope="col">Description</th>
			      <th scope="col">Price</th>
			      <th scope="col">Action</th>
			    </tr>
			  </thead>
			  
			   <tbody>
			   
			   <c:forEach var="p" items="${productsList }">
				<tr>
					<td>TechOnly${p.id }</td>
					<td>${p.name }</td>
					<td>${p.description }</td>
					<td class="font-weight-bold">&#8377;${p.price }</td>
					<td>
					<a href="delete/${p.id }"><i class="fas fa-trash-alt text-danger"></i></a>
					<a href="update/${p.id }"><i class="fas fa-pen-nib text-primary"></i></a>
					</td>
					
				</tr>
			 </c:forEach> 
			 </tbody>
			</table>
			 
			<!-- button add -->
			<div class="container text-center">
			<a href="add-product" class="btn btn-outline-dark">Add Product</a>
			</div>
			
		</div>
	</div>
</div>
</body>
</html>
