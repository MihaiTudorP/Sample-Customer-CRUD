<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
<title>CRM - List customers</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h1>CRM - Customer Relationship Manager</h1>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<!-- add the "Add customer" button -->
			<input type="button" value="Add customer"
				onClick="window.location.href='showFormForAdd'; return false;"
				class="add-button" />	
			<!--  add a search box -->
            <form:form action="search" method="POST">
                Search customer: <input type="text" name="theSearchName" />
                
                <input type="submit" value="Search" class="add-button" />
            </form:form>
			<!-- add the customer table here -->
			<table>
				<thead>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action</th>
					</tr>
				</thead>
				<!-- loop over and print the customers -->
				<tbody>
					<c:forEach var="customer" items="${customers}">
						<!-- construct an update link for each customer -->
						<c:url var="updateLink" value="showFormForUpdate">
							<c:param name="customerId" value="${customer.id}" />
						</c:url>

						<!-- construct a delete link for each customer -->
						<c:url var="deleteLink" value="delete">
							<c:param name="customerId" value="${customer.id}" />
						</c:url>

						<tr>
							<td>${customer.firstName}</td>
							<td>${customer.lastName}</td>
							<td>${customer.email}</td>
							<td>
								<!-- display the update link --> <a href="${updateLink}">Update</a>
								| <a href="${deleteLink}"
								onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>