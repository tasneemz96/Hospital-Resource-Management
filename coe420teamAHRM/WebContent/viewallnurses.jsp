<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.util.ArrayList, java.util.List"%>
<%@ page import="model.Nurse, model.HospitalChain, model.HospitalBranch"%>
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
		HospitalBranch branch = branches.findBranch((String) request.getAttribute("branchID"));
		request.getSession().setAttribute("branchID", branch.getBranchID());
		request.setAttribute("branchID", branch.getBranchID());
	%>

	<div class="" style="height: 100vh; overflow: auto; max-height: 100%;">
		<div class="container-fluid bg-dark text-white pt-3 pb-2">
			<h1>
				<a href="Login" class="text-white">HRM</a>
			</h1>
			<h5><%=(branch.getBranchName() + " " + branch.getBranchLocation())%></h5>
		</div>

		<div class="container-fluid bg-light text-success pt-2 pb-1 shadow-sm">
			<h5>
				<a href="Branch/back" class="text-dark">> Home </a> <a href="Nurses"
					class="text-dark">> Nurses > </a>View all nurses
			</h5>
		</div>

		<div class="container-fluid pt-3">
			<div class="d-flex justify-content-center align-items-center h-100">
				<table class="table table-hover border w-100">
					<thead class="thead-light">
						<tr>
							<th>ID</th>
							<th>First name</th>
							<th>Last name</th>
							<th>Specialization</th>
							<th>Rank</th>
						</tr>
					</thead>
					<tbody>

						<%
							List<Nurse> nurses = (ArrayList<Nurse>) request.getAttribute("nurses");
							if (nurses.size() == 0) {
								out.println("<tr>");
								out.println("<td colspan=\"6\" class=\"text-center\">");
								out.println("This hospital currently has no nurses");
								out.println("</td>");
								out.println("</tr>");
							} else {
								for (Nurse nurse : nurses) {
									out.println("<tr>");
									out.println("<td>");
									out.println(nurse.getNurseID());
									out.println("</td>");
									out.println("<td>");
									out.println(nurse.getFirstName());
									out.println("</td>");
									out.println("<td>");
									out.println(nurse.getLastName());
									out.println("</td>");
									out.println("<td>");
									out.println(nurse.getSpecialization());
									out.println("</td>");
									out.println("<td>");
									out.println(nurse.getRanking());
									out.println("</td>");
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