<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>
		<title>CRM - Add new customer</title>
	</head>
	<body>
		<div id="wrapper">
			<div id="header">
				<h1>CRM - Save Customer</h1>
			</div>
		</div>
		
		<div id="container">
			<div id="content">
				<h2>Save customer</h2>
				<!-- add the customer add form here -->
				<form:form action="saveCustomer" modelAttribute="customer" method="POST">
					<!-- assiociate the data with the customer id -->
					<form:hidden path="id" />
					<table>
						<tbody>
							<tr>
								<td><label>First name*:</label></td>
								<td><form:input path="firstName"/></td>
								<td><form:errors path="firstName" cssClass="error"/></td>
							</tr>
							<tr>
								<td><label>Last name*:</label></td>
								<td><form:input path="lastName"/></td>
								<td><form:errors path="lastName" cssClass="error"/></td>
							</tr>
							<tr>
								<td><label>Email*:</label></td>
								<td><form:input path="email"/></td>
								<td><form:errors path="email" cssClass="error"/></td>
							</tr>
							<tr>
								<td><label></label></td>
								<td><input type="submit" value="Save customer" class="save"/></td>
							</tr>
						</tbody>
					</table>
				</form:form>
				<div style="clear; both;"></div>
				<p><a href="${pageContext.request.contextPath}/customer/list">Back to the customer list</a></p>
			</div>
		</div>
	</body>
</html>