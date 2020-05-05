<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="model.HospitalChain, model.HospitalBranch"%>

<!DOCTYPE html>
<html lang="en">

<head>
<title>HRM by Team A</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
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


	<div class=""
		style="height: 100vh; overflow: auto; max-height: 100%; width: 100vw;">
		<div class="container-fluid bg-dark text-white pt-3 pb-2">
			<h1><a href="Login" class="text-white">HRM</a></h1>
			<h5><%=(branch.getBranchName() + ", " + branch.getBranchLocation())%></h5>
		</div>

		<div class="container-fluid bg-light text-success pt-2 pb-1 shadow-sm">
			<h5>
				<a href="Branch/back" class="text-dark"> Home ></a> Doctors
			</h5>
		</div>




		<div
			class="d-flex flex-column justify-content-center align-items-center h-75">
			<div classs="d-flex flex-row m-3 align-items-end"
				style="width: 1050px;">
				<div class="col">
					<form method="post" action="SearchDoctor">
						<div class="input-group mb-3">
							<input type="text" class="form-control rounded-0"
								placeholder="Search doctor by ID..." name ="doctorID">
							<div class="input-group-append">
								<button class="btn input-group-text rounded-0">
									<i class="material-icons">search</i>
								</button>
							</div>
						</div>
					</form>
				</div>

			</div>
			<div class="d-flex flex-row m-3" style="width: 1050px; height: 90px;">
				<div class="col">
					<a href="ViewAllDoctors" class="text-decoration-none">
						<button
							class="btn btn-lg btn-outline-secondary btn-block h-100 rounded-0">
							<h4>View all doctors</h4>
						</button>
					</a>
				</div>
				<div class="col">
				<a href="AddDoctor" class="text-decoration-none">
					<button
						class="btn btn-lg btn-outline-secondary btn-block h-100 rounded-0">
						<h4>Add doctor</h4>
					</button>
					</a>
				</div>
				<div class="col">
					<button
						class="btn btn-lg btn-outline-secondary btn-block h-100 rounded-0">
						<h4>Update doctor</h4>
					</button>
				</div>
				<div class="col">
					<button
						class="btn btn-lg btn-outline-secondary btn-block h-100 rounded-0">
						<h4>Remove doctor</h4>
					</button>
				</div>
			</div>
		</div>
	</div>
</body>

</html>