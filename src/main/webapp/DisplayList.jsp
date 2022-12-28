<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@page import="com.dao.EmployeeDao"%>
<%@page import="com.model.Employee"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.List"%>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class=" navbar navbar-expand-sm bg-dark navbar-dark">
		<ul class="nav nav-tabs ">
			<li class="navbar-nav"><a class="nav-link" href="insert.html">Back</a></li>
		</ul>
		<div class="container justify-content-center">
			<h4 class="navbar-brand">Employee List</h4>
		</div>
	</div>

	<%
	EmployeeDao EmployeeDao= new EmployeeDao();
	List<Employee> lst = EmployeeDao.DisplayAll();
	%>
	<div class="container-fluid">
		<table class="table table-bordered ">

			<thead>
				<tr class="bg-light">

					<th>Employee ID</th>
					<th>Employee Name</th>
					<th>Gender</th>
					<th>Birthdate</th>
					<th>Address</th>
					<th>Salary</th>

				</tr>
			</thead>
			<%
			for (Employee e : lst) {
			%>
			<tbody>
				<tr>
					<td><%=e.getEmployeeid()%></td>
					<td><%=e.getEname()%></td>
					<td><%=e.getGender()%></td>
					<td><%=e.getBirthdate()%></td>
					<td><%=e.getAddr()%></td>
					<td><%=e.getSalary()%></td>
				</tr>
			</tbody>
			<%
			}
			%>
		</table>
	</div>
	<div class="container">
		<form action="DeleterecordController">
			<h6 class="text-secondary">Please Enter Employee id to delete
				Employee Record.</h6><br>
				 Employee ID <input type="text" class="form-control col-2"
				pattern="[0-9]{1,5}" name="eid" required><br> <input
				type="submit" class="btn btn-dark" value="Delete Record">
		</form>
	</div>
</body>
</html>