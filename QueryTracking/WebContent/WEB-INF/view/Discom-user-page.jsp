<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<div class="text-align-right">
<a  class="btn btn-primary" href="./logOut">Logout</a>
</div>

<div class="container mt-3">
<div class="row">
<div class="col-md-6 offset-md-3">
<h1 class="text-center mb-3">Discom Page</h1>
<form action="registerQuery" method="post" >
<div class="form-row">
<div class="clearfix"></div>
<div class="col-xs-12 col-sm-3 col-md-3 form-group" style="margin-left: 10px;">
Select Facility:
<select class="form-control customselet custum-select" name="facility">
        <option value="Outage Extend ">Outage Extend</option>
        <option value="Feeder Mapping">Feeder Mapping</option>
      <select>
      </div>
      <div class="form-group col-lg-2"style="margin-left: 20px; ">
Select Priority:
<select class="form-control customselet custum-select" name="priority" style="padding-top: 1px;">
        <option value="High ">High</option>
        <option value="Medium">Medium</option>
        <option value="Low">Low</option>
      <select>
      </div>
      
      
      
     
      <div class="form-group col-lg-8">
      Query Description:
      <input type="text" maxlength="200" class="form-control ng-pristine ng-valid"  name="queryDescription"/>
      </div>
      
     
      	<div class="form-group col-lg-4">
       <div  style="padding-top: 24px;"> 
		 <input type="submit" value="submit" class="btn btn-danger"  />
		 </div>
		 </div>
		 </div>
		 
<form>

</div>
</div>
<hr>
<div class="container">
<table class="table">

  <thead class="thead-dark">
    <tr>
     
      <th  scope="col">UserId</th>
      <th scope="col"> Name of  State</th>
      <th scope="col">Name of the Discom</th>
      <th scope="col">Name of Employee</th>
      <th scope="col">Query Id</th>
      <th scope="col">Facility Name</th>
      <th scope="col">Description</th>
      <th scope="col">Query Registration Date</th>
      <th scope="col">Status</th>
      <th scope="col">Query Compliance Date</th>
      <th scope="col">Remarks</th>
           
    </tr>
  </thead>
    <tbody>   
     <c:forEach var="discom" items="${qlist}">
      <tr style="text-align: left">
     <td>${discom[0]}</td>
     <td>${discom[1]}</td>
      <td>${discom[2]}</td>
       <td>${discom[3]}</td>
       <td>${discom[4]}</td>
       <td>${discom[5]}</td>
       <td>${discom[6]}</td>
       <td>${discom[7]}</td>
        <td>${discom[8]}</td>
        <td>${discom[9]}</td>
        <td style="text-align: left;">${discom[10]}<td/>
         
        </tr>
           </c:forEach>
     </tbody>
   </table>

</div>


</body>
</html>