<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.HospitalChain" %>
	<%@ page import="model.HospitalBranch" %>
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
<% HospitalChain branches = new HospitalChain();
HospitalBranch branch = branches.findBranch((String)request.getSession().getAttribute("branchID"));
request.getSession().setAttribute("branchID", branch.getBranchID());%>
    <div class="" style="height:100vh; overflow:auto; max-height:100%;">
        <div class="container-fluid bg-dark text-white pt-3 pb-2">
            <h1><a href="Login" class="text-white">HRM</a></h1>
            <h5><%=(branch.getBranchName()+", "+branch.getBranchLocation()) %></h5>
        </div>

        <div class="container-fluid bg-light text-success pt-2 pb-1 shadow-sm">
            <h5><a href="Branch/back" class="text-dark">> Home </a>
            <a href="Patients" class="text-dark"> > Patients</a><a href="SearchPatient" class="text-dark"> > Search patient > </a>View all assigned doctors and nurses</h5>
        </div>

        <div class="container-fluid pt-3">
            <div class="d-flex flex-column justify-content-center align-items-center h-100 w-100">
                <div class="w-100">
                    <h4>Doctors</h4>
                    <table class="table table-sm table-hover border w-100">
                        <thead class="thead-light">
                            <tr>
                                <th>ID</th>
                                <th>First name</th>
                                <th>Last name</th>
                                <th>Specialization</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>D0001</td>
                                <td>John</td>
                                <td>Doe</td>
                                <td>Pediatrics</td>
                            </tr>
                            <tr>
                                <td>D0002</td>
                                <td>Mary</td>
                                <td>Moe</td>
                                <td>Gynaecology</td>
                            </tr>
                            <tr>
                                <td>D0003</td>
                                <td>July</td>
                                <td>Dooley</td>
                                <td>Internal medicine</td>
                            </tr>
                        </tbody>
                    </table>
                </div>

                <div class="w-100 pt-3">
                    <h4>Nurses</h4>
                    <table class="table table-sm table-hover border w-100">
                        <thead class="thead-light">
                            <tr>
                                <th>ID</th>
                                <th>First name</th>
                                <th>Last name</th>
                                <th>Specialization</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>N0001</td>
                                <td>John</td>
                                <td>Doe</td>
                                <td>Pediatrics</td>
                            </tr>
                            <tr>
                                <td>N0002</td>
                                <td>Mary</td>
                                <td>Moe</td>
                                <td>Gynaecology</td>
                            </tr>
                            <tr>
                                <td>N0003</td>
                                <td>July</td>
                                <td>Dooley</td>
                                <td>Internal medicine</td>
                            </tr>
                        </tbody>
                    </table>

                </div>

            </div>
        </div>

    </div>
</body>

</html>