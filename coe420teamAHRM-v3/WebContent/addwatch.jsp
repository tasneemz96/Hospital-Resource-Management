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
HospitalBranch branch = branches.findBranch((int)request.getSession().getAttribute("branchID"));
request.getSession().setAttribute("branchID", branch.getBranchID());%>

    <div class="" style="height:100vh; overflow:auto; max-height:100%; width:100vw">
        <div class="container-fluid bg-dark text-white pt-3 pb-2">
            <h1>HRM</h1>
            <h5><%=(branch.getBranchName()+", "+branch.getBranchLocation()) %></h5>
        </div>

        <div class="container-fluid bg-light text-success pt-2 pb-1 shadow-sm">
            <h5><a href="Branch/back" class="text-dark">> Home </a>
            <a href="Watches" class="text-dark">> Watches > </a>Add watch</h5>
        </div>

        <div class="d-flex justify-content-center align-items-center w-100 h-75 pt-3">

            <form style="width:28vw;" method="post" action="AddWatch">

                <div class="form-group row pt-2">
                    <div class="col-sm-4">
                        <label for="brand">Brand: </label>
                    </div>
                    <div class="col">

                        <select class="form-control rounded-0" id="brand" name="brand">
                            <option>Samsung</option>
                            <option>Fitbit</option>
                            <option>Apple</option>
                            <option>Xiaomi</option>
                        </select>

                    </div>
                </div>

                <div class="form-group row pt-2">
                    <div class="col-sm-4">
                        <label for="model">Model: </label>
                    </div>
                    <div class="col">
                        <input type="text" class="form-control rounded-0" id="model" name="model" required
                            placeholder="Enter model">
                    </div>
                </div>

                <div class="row pt-2">
                    <div class="col">
                        <button type="submit" class="btn btn-success btn-block rounded-0" id="signup">Confirm</button>
                    </div>
                </div>
                <div class="row pt-1">
                    <div class="col"><a href="Watches" class="text-decoration-none">
                        <button type="button" class="btn btn-outline-secondary btn-block rounded-0"
                            id="cancel">Cancel</button></a>
                    </div>
                </div>

            </form>
        </div>

    </div>
</body>

</html>