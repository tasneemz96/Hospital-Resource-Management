<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page
	import="model.Patient, model.HospitalChain, model.HospitalBranch"%>
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
				<a href="Branch/back" class="text-dark">> Home </a> <a
					href="Patients" class="text-dark">> Patients > </a>View all
				patients
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
							<th>Diagnosis</th>
							<th>Room no.</th>
							<th>Bed no.</th>
						</tr>
					</thead>
					<tbody>

						<%
							List<Patient> patients = (ArrayList<Patient>) request.getAttribute("patients");
							if (patients.size() == 0) {
								out.println("<tr>");
								out.println("<td colspan=\"6\" class=\"text-center\">");
								out.println("This hospital currently has no patients");
								out.println("</td>");
								out.println("</tr>");
							} else {
								for (Patient patient : patients) {
									
									out.println("<tr>");
									
									out.println("<td>");
									out.println(patient.getPatientID());
									out.println("</td>");
									out.println("<td>");
									out.println(patient.getFirstName());
									out.println("</td>");
									out.println("<td>");
									out.println(patient.getLastName());
									out.println("</td>");
									out.println("<td>");
									out.println(patient.getDiagnosis());
									out.println("</td>");
									out.println("<td>");
									out.println(patient.getRoomNum());
									out.println("</td>");
									out.println("<td>");
									if(patient.getBedNum()==0){
										out.println("Unassigned");
									}
									else{
										out.println(patient.getBedNum());
									}
									
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