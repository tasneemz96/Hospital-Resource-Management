<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Watch, model.HospitalBranch, model.HospitalChain"%>
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
	<%
		HospitalChain branches = new HospitalChain();
		HospitalBranch branch = branches.findBranch((String) request.getSession().getAttribute("branchID"));
		request.getSession().setAttribute("branchID", branch.getBranchID());
	%>
	<div class="" style="height: 100vh; overflow: auto; max-height: 100%;">
		<div class="container-fluid bg-dark text-white pt-3 pb-2">
			<h1>
				<a href="Login" class="text-white">HRM</a>
			</h1>
			<h5><%=(branch.getBranchName() + ", " + branch.getBranchLocation())%></h5>
		</div>

		<div class="container-fluid bg-light text-success pt-2 pb-1 shadow-sm">
			<h5>
				<a href="Branch/back" class="text-dark">> Home </a> <a
					href="Watches" class="text-dark">> Watches > </a>View all watches
			</h5>
		</div>

		<div class="container-fluid pt-3">
			<div class="d-flex justify-content-center align-items-center h-100">
				<table class="table table-hover border w-100">
					<thead class="thead-light">
						<tr>
							<th>ID</th>
							<th>Brand</th>
							<th>Model</th>
							<th>Availability</th>
							<th>Assigned to</th>
						</tr>
					</thead>
					<tbody>
						<%
							List<Watch> watches = (ArrayList<Watch>) request.getAttribute("watches");
							if (watches.size() == 0) {
								out.println("<tr>");
								out.println("<td colspan=\"6\" class=\"text-center\">");
								out.println("This hospital currently has no watches");
								out.println("</td>");
								out.println("</tr>");
							} else {
								for (Watch watch : watches) {
									out.println("<tr>");
									out.println("<td>");
									out.println(watch.getWatchID());
									out.println("</td>");
									out.println("<td>");
									out.println(watch.getBrand());
									out.println("</td>");
									out.println("<td>");
									out.println(watch.getModel());
									out.println("</td>");
									out.println("<td>");
									if (watch.isAvailable()) {
										out.println("Available");
									} else {
										out.println("Unavailable");
									}
									out.println("</td>");
									out.println("<td>");
									out.println(watch.getPatientID());
									out.println("</tr>");
								}
							}
						%>

					</tbody>
				</table>

			</div>
		</div>

	</div>
</body>

</html>