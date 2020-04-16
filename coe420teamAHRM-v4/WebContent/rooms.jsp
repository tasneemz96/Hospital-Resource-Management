<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@ page import="model.HospitalChain" %>
	<%@ page import="model.HospitalBranch" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>HRM by Team A</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>

<body>
<% HospitalChain branches = new HospitalChain();
HospitalBranch branch = branches.findBranch((int)request.getSession().getAttribute("branchID"));
request.getSession().setAttribute("branchID", branch.getBranchID());%>
    <div class="container-fluid bg-dark text-white pt-3 pb-2">
        <h1>HRM</h1>
        <h5><%=(branch.getBranchName()+", "+branch.getBranchLocation()) %></h5>
        
    </div>

    <div class="container-fluid bg-light text-success pt-2 pb-1 shadow-sm">
       <h5> <a href="Branch/back" class="text-dark">> Home </a> > Rooms </h5>
    </div>


    

    <div class="d-flex flex-column justify-content-center align-items-center" style="height:500px;">
        
        <div class="d-flex flex-row m-3" style="width:800px;height:90px;">
            <div class="col"><a href="ViewAllRooms" class="text-decoration-none">
                <button class="btn btn-lg btn-outline-secondary btn-block h-100 rounded-0">
                    <h4>View all rooms</h4>
                </button></a>
            </div>
            <div class="col"><a href="ViewAvailableRooms" class="text-decoration-none">
                <button class="btn btn-lg btn-outline-secondary btn-block h-100 rounded-0">
                    <h4>View available rooms</h4>
                </button></a>
            </div>
            <div class="col">
                <button class="btn btn-lg btn-outline-secondary btn-block h-100 rounded-0">
                    <h4>Assign room</h4>
                </button>
            </div>
        </div>
    </div>

</body>

</html>