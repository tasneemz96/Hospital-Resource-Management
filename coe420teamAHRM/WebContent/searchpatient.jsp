<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.Patient"%>
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
	<div class="" style="height: 100vh; overflow: auto; max-height: 100%;">
		<div class="container-fluid bg-dark text-white pt-3 pb-2">
			<h1>HRM</h1>
			<h5>Branch name, Branch location</h5>
		</div>

		<div class="container-fluid bg-light text-success pt-2 pb-1 shadow-sm">
			<h5>
				<a href="Branch" class="text-dark">> Home </a> <a href="Patients"
					class="text-dark">> Patients > </a>Search patient
			</h5>
		</div>

		<div class="container-fluid pt-3">
			<div
				class="d-flex justify-content-center flex-column align-items-center mx-auto h-100 w-50">
				<table class="table table-sm table-hover border">
					<thead class="thead-light">
						<tr>
							<th style="width: 50%;">ID</th>
							<td>
								<%
									Patient patient = (Patient) request.getAttribute("patient");
									out.println(patient.getPatientID());
								%>
							</td>
						</tr>
						<tr>
							<th>First name</th>
							<td><%=patient.getFirstName()%></td>
						</tr>
						<tr>
							<th>Last name</th>
							<td><%=patient.getLastName()%></td>
						</tr>
						<tr>
							<th>Phone number</th>
							<td><%=patient.getPhone()%></td>
						</tr>
						<tr>
							<th>Address</th>
							<td><%=patient.getAddress()%></td>
						</tr>
						<tr>
							<th>Diagnosis</th>
							<td><%=patient.getDiagnosis()%></td>
						</tr>
						<tr>
							<th>Insurance</th>
							<td>
								<%
									if (patient.isInsurance()) {
										out.println("Yes");
									} else {
										out.println("No");
									}
								%>
							</td>

						</tr>
						<tr>
							<th>Room no.</th>
							<td><%=patient.getRoomNum()%></td>
						</tr>
						<tr>
							<th>Bed no.</th>
							<td>
								<%
									if (patient.getBedNum() == -1) {
										out.println("Unassigned");
									} else {
										out.println(patient.getBedNum());
									}
								%>
							</td>
						</tr>
						<tr>
							<th>Watch</th>
							<td>
								<%
									if (patient.getWatchID() == -1) {
										out.println("Unassigned");
									} else {
										out.println(patient.getWatchID());
									}
								%>
							</td>
						</tr>
					</thead>
				</table>

				<div class="row w-100" style="height: 50px;">
					<div class="col">
						<button
							class="btn btn-outline-secondary btn-block rounded-0 h-100">Symptoms</button>
					</div>
					<div class="col">
						<button
							class="btn btn-outline-secondary btn-block rounded-0 h-100">Biometrics</button>
					</div>
				</div>
				<div class="row w-100 mt-3 mb-3" style="height: 50px;">
					<div class="col">
						<a href="ViewAssignedEmployees" class="text-decoration-none">
							<button
								class="btn btn-outline-secondary btn-block rounded-0 h-100">View
								assigned doctors and nurses</button>
						</a>
					</div>
				</div>

			</div>
		</div>

	</div>
</body>

</html>