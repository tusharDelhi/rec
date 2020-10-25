<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">

<title>Discom User</title>
</head>
<body>
<div class="container">
${msg }
</div>
<div class="container">${userId} </div>

<div class="container mt-3">
<div class="row">
<div class="col-md-6 offset-md-3">
<h1 class="text-center mb-3">Discom Page</h1>
<form action="registerQuery" method="post" >


 
					

<div class="form-group">
Select Facility:
<select class="form-control" name="facility">
        <option value="Outage Extend ">Outage Extend</option>
        <option value="Feeder Mapping">Feeder Mapping</option>
      <select>
      </div>
      
      
      
       <div class="form-group">
      Query Id:
      <input type="text" maxlength="200" class="form-control" name="queryNo"/>
      </div>
      
      <div class="form-group">
      Query Description:
      <input type="text" maxlength="200" class="form-control"    name="queryDescription"/>
      </div>
      
     
      
       <div class="container text-center"> 
		 <input type="submit" value="submit" class="btn btn-primary" />
		 </div>
<form>
</div>
</div>
</div>
<hr>
<div class="container">
<table class="table" style="">

  <thead class="thead-dark">
    <tr>
      <th scope="col">S.no</th>
      <th scope="col">Query Id</th>
      <th scope="col"> Name of  State</th>
      <th scope="col">Name of the Discom</th>
      <th scope="col">Name of Employee</th>
      <th scope="col">UserId</th>
      <th scope="col">Facility Name</th>
      <th scope="col">Description</th>
      <th scope="col">Query Registration Date</th>
      <th scope="col">Status</th>
      <th scope="col">Query Compliance Date</th>
      
      <th scope="col">Remarks</th>
            
    </tr>
  </thead>
    <tbody>
    <tr>
     <th scope="row">sl.no</th>
      <th scope="row">Query Id</th>
      <td>Name of State</td>
       <td>Name of the discom</td>
       <td>Name of employee</td>
       <td>user Id</td>
       <td><select class="form-control">
        <option value="Outage Extend ">Outage Extend</option>
        <option value="Feeder Mapping">Feeder Mapping</option>
      </select>
      </td>
       <td>Description</td>
         <td>Query Registration Date</td>
           <td>Status</td>
           <td>Query Complaince Date</td>
           <td>Remarks</td>
      
    </tr>
    </tbody>
   </table>

</div>


</body>
</html>