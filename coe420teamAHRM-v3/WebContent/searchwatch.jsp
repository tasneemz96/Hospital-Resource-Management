<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.Watch"%>
	
	<%@ page import="model.HospitalChain" %>
	<%@ page import="model.HospitalBranch" %>
<!DOCTYPE html>
<html lang="en">

<head>
<title>HRM by Team A</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, height=device-height initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>

<body>
<% HospitalChain branches = new HospitalChain();
HospitalBranch branch = branches.findBranch((int)request.getSession().getAttribute("branchID"));
request.getSession().setAttribute("branchID", branch.getBranchID());%>
	<div class="" style="height: 100vh; overflow: auto; max-height: 100%;">
		<div class="container-fluid bg-dark text-white pt-3 pb-2">
			<h1><a href="Login" class="text-white">HRM</a></h1>
			<h5><%=(branch.getBranchName()+", "+branch.getBranchLocation()) %></h5>
		</div>

		<div class="container-fluid bg-light text-success pt-2 pb-1 shadow-sm">
			<h5>
				<a href="Branch/back" class="text-dark">> Home </a> <a href="Watches"
					class="text-dark">> Watches > </a>Search watch
			</h5>
		</div>

		<div class="container-fluid pt-3">
			<div
				class="d-flex justify-content-center flex-column align-items-center mx-auto h-100 w-50">
				<table class="table table-sm table-hover border">
					<thead class="thead-light">
						<tr>
							<th style="width: 50%;">Watch ID</th>
							<td>
								<%
									Watch watch = (Watch) request.getAttribute("watch");
									out.println(watch.getWatchID());
								%>
							</td>
						</tr>
						<tr>
							<th>Brand</th>
							<td><%=watch.getBrand()%></td>
						</tr>
						<tr>
							<th>Model</th>
							<td><%=watch.getModel()%></td>
						</tr>
						<tr>
							<th>Availability</th>
							<td>
								<%
									if (watch.isAvailable()) {
										out.println("Available");
									} else {
										out.println("Unavailable");
									}
								%>
							</td>
						</tr>
						<tr>
							<th>PatientID</th>
							<td><%=watch.getPatientID()%></td>
						</tr>
					</thead>
				</table>

			</div>

		</div>
	</div>
</body>

</html>