<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@page import="model.Doctor, model.HospitalChain, model.HospitalBranch"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>HRM by Team A</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, height=device-height initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>

<body>

<%
	HospitalChain branches = new HospitalChain();
HospitalBranch branch = branches.findBranch((String)request.getSession().getAttribute("branchID"));
request.getSession().setAttribute("branchID", branch.getBranchID());
	request.setAttribute("branchID", branch.getBranchID());
%>

    <div class="" style="height:100vh; overflow:auto; max-height:100%;">
        <div class="container-fluid bg-dark text-white pt-3 pb-2">
            <h1><a href="Login" class="text-white">HRM</a></h1>
            <h5><%=(branch.getBranchName()+", "+branch.getBranchLocation()) %></h5>
        </div>

        <div class="container-fluid bg-light text-success pt-2 pb-1 shadow-sm">
            <h5><a href="Branch/back" class="text-dark">> Home </a> <a href="Doctors"
					class="text-dark">> Doctors > </a>Search doctor</h5>
        </div>

        <div class="container-fluid pt-3">
            <div class="d-flex justify-content-center flex-column align-items-center mx-auto h-100 w-50">
                <table class="table table-sm table-hover border">
                    <thead class="thead-light">
                        <tr>
                            <th style="width: 50%;">ID</th>
                            <td><%
									Doctor doctor = (Doctor) request.getAttribute("doctor");
									out.println(doctor.getDoctorID());
								%></td>
                        </tr>
                        <tr>
                            <th>First name</th>
                            <td><%=doctor.getFirstName()%></td>
                        </tr>
                        <tr>
                            <th>Last name</th>
                            <td><%=doctor.getLastName()%></td>
                        </tr>
                        <tr>
                            <th>Specialization</th>
                            <td><%=doctor.getSpecialization()%></td>
                        </tr>
                        <tr>
                            <th>Phone extension</th>
                            <td><%=doctor.getPhone()%></td>
                        </tr>
                    </thead>
                </table>

                <div class="row w-100" style="height: 50px;">
                    <div class="col">
                        <button class="btn btn-outline-secondary btn-block rounded-0 h-100">View patients</button>
                    </div>
                    <div class="col">
                        <button class="btn btn-outline-secondary btn-block rounded-0 h-100">Assign patient</button>
                    </div>
                </div>
                <div class="row w-100 mt-3" style="height: 50px;">
                    <div class="col">
                        <button class="btn btn-outline-secondary btn-block rounded-0 h-100">View shifts</button>
                    </div>
                    <div class="col">
                        <button class="btn btn-outline-secondary btn-block rounded-0 h-100">Edit shift</button>
                    </div>
                </div>

            </div>
        </div>

    </div>
</body>

</html>