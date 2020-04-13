<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<div class="container-fluid bg-dark text-white pt-3 pb-2">
		<h1>HRM</h1>
		<a href="Branch" class="text-white"><h5>Branch name, Branch
				location</h5></a>

	</div>

	<div class="container-fluid bg-light text-success pt-2 pb-1 shadow-sm">
		<h5>> Patients</h5>
	</div>




	<div
		class="d-flex flex-column justify-content-center align-items-center"
		style="height: 500px;">
		<div classs="d-flex flex-row m-3 align-items-end"
			style="width: 1050px;">
			<div class="col">
				<form method="post" action="SearchPatient">
					<div class="input-group mb-3">
						<input type="text" class="form-control rounded-0" name="patientID" required
							id="patientID" placeholder="Search patient by ID...">
						<div class="input-group-append">
							
								<button class="btn input-group-text rounded-0" type="submit">
									<i class="material-icons">search</i>
								</button>
							
						</div>
					</div>
				</form>
			</div>

		</div>
		<div class="d-flex flex-row m-3" style="width: 1050px; height: 90px;">
			<div class="col">
				<a href="ViewAllPatients" class="text-decoration-none">
					<button
						class="btn btn-lg btn-outline-secondary btn-block h-100 rounded-0">
						<h4>View all patients</h4>
					</button>
				</a>
			</div>
			<div class="col">
				<a href="AddPatient" class="text-decoration-none">
					<button
						class="btn btn-lg btn-outline-secondary btn-block h-100 rounded-0">
						<h4>Add patient</h4>
					</button>
				</a>
			</div>
			<div class="col">
				<button
					class="btn btn-lg btn-outline-secondary btn-block h-100 rounded-0">
					<h4>Update patient</h4>
				</button>
			</div>
			<div class="col">
				<button
					class="btn btn-lg btn-outline-secondary btn-block h-100 rounded-0">
					<h4>Remove patient</h4>
				</button>
			</div>
		</div>
	</div>

</body>

</html>