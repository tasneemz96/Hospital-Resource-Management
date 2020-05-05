<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.HospitalBranch"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>HRM by Team A</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>

<body>
	<div
		style="height: 100vh; max-height: 100%; overflow: auto; width: 100vw;">
		<div class="container-fluid bg-dark text-white pt-3 pb-2">
			<h1>
				<a href="../Login" class="text-white">HRM</a>
			</h1>
			<h5>
				<%
					HospitalBranch branch = (HospitalBranch) request.getAttribute("branch");
					out.println(branch.getBranchName() + ", " + branch.getBranchLocation());
				%>
			</h5>
			<p>
				<%
					out.println(branch.getBranchID());
				%>
			</p>
			<%
				request.getSession().setAttribute("branchID", branch.getBranchID());
			%>
		</div>

		<div class="container-fluid bg-light text-success pt-2 pb-1 shadow-sm">
			<h5>> Home</h5>
		</div>

		<div
			class="d-flex flex-column justify-content-center align-items-center h-50">
			<div class="d-flex flex-row m-3" style="width: 1050px; height: 90px;">
				<div class="col">
					<button
						class="btn btn-lg btn-outline-secondary btn-block h-100 rounded-0">
						<h4>Admins</h4>
					</button>
				</div>
				<div class="col">
					<a href="../Doctors" class="text-decoration-none">
						<button
							class="btn btn-lg btn-outline-secondary btn-block h-100 rounded-0">
							<h4>Doctors</h4>
						</button>
					</a>
				</div>
				<div class="col">
					<a href="../Nurses" class="text-decoration-none">
						<button
							class="btn btn-lg btn-outline-secondary btn-block h-100 rounded-0">
							<h4>Nurses</h4>
						</button>
					</a>
				</div>
				<div class="col">
					<a href="../Patients" class="text-decoration-none">
						<button
							class="btn btn-lg btn-outline-secondary btn-block h-100 rounded-0">
							<h4>Patients</h4>
						</button>
					</a>
				</div>
			</div>
			<div class="d-flex flex-row m-3" style="width: 800px; height: 90px;">
				<div class="col">
					<a href="../Watches" class="text-decoration-none">
						<button
							class="btn btn-lg btn-outline-secondary btn-block h-100 rounded-0">
							<h4>Watches</h4>
						</button>
					</a>
				</div>
				<div class="col">
					<button
						class="btn btn-lg btn-outline-secondary btn-block h-100 rounded-0">
						<h4>Equipment</h4>
					</button>
				</div>
				<div class="col">
					<a href="../Rooms" class="text-decoration-none">
						<button
							class="btn btn-lg btn-outline-secondary btn-block h-100 rounded-0">
							<h4>Rooms</h4>
						</button>
					</a>
				</div>
			</div>

		</div>
	</div>
</body>

</html>