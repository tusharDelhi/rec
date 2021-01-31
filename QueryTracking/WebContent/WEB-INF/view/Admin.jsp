
<%@page import="java.util.logging.Logger"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.rec.model.States"%>
<%@page import="org.hibernate.query.Query"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.Session"%>
<%@page import="java.io.Console"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<meta charset="ISO-8859-1">


<title>Admin</title>

<script type="text/javascript">
function showData()
{
	var s = document.getElementById("StateSelect").value;
var displayText = s;
alert(displayText);
	}

</script>
<script type="text/javascript">

</script>

<style type="text/css">
.color {
	background-color: #6595BA;
}

.alt {
	background: #AFD5F2;
}

table td {
	border-bottom: 2px solid #1c46a8;
	border-right: 1px solid #1c46a8;
	padding: 8px 6px;
	vertical-align: top;
	display: table-cell;
	text-transform: uppercase;
}

tr:nth-child(even) {
	background-color: #d9ecfe !important;
}

table th {
	border-bottom: 2px solid #1c46a8;
	border-right: 1px solid #1c46a8;
	padding: 12px 6px;
	vertical-align: top;
	font-weight: bold;
	text-transform: uppercase;
	background: #003466;
	color: #fff;
	text-align: center;
}

tr:hover, .tr:nth-child(even):hover {
	background: #bfddfa !important;
}

tr:nth-child(odd) {
	background-color: #ebf5ff;
}

.table {
	margin-right: 12%;
}
</style>
</head>
<body >
	
	<div align="right">
		<a class="btn btn-primary" href="./logOut">Logout</a>
	</div>

	<div class="MT20" align="left">


		
		<form method="get" action="searchBar"  >
			<div class="form-row">
			

				<div class="col-xs-12 col-sm-3 col-md-3 form-group" style="margin-left: 40px;">
				<input type="hidden" name="copy" id="getValue"/>
					State: <select class="form-control customselet custum-select" id="StateSelect" name="state" onChange="showData()">
						<option value="0" label="--- Select ---" />
						 <c:forEach var="st" items="${state_list}">
						 <option value="${st.stateId}">${st.state}</option>
						 </c:forEach>
	                           	</select>
                	
                	
					
				</div>
				<div class="form-group col-lg-2" style="margin-left: 20px;">
					Discom: <select class="form-control customselet custum-select"
						name="Discom" id="DiscomSelect" required="required" >
						<option value="0" label="--- Select ---" />
						<c:forEach var="dis" items="${discomList}">
						<option value="${dis.id}">${dis.name }</option>
						</c:forEach>
								
								
							
							//	out.println("id"+id);
							
						
						</select>
				</div>
				<div class="clearfix"></div>
				<div class="form-group col-lg-2 custominput"
					style="margin-left: 20px;">

					From Date: <input type="date" class="form-control StartDate"
						name="queryRegistered" placeholder="From Date" required="required">
				</div>
				<div class="form-group col-lg-2 custominput"
					style="margin-left: 20px;">

					To Date: <input type="date" name="queryCompliance"
						class="form-control EndDate" placeholder="To Date" required="required">
				</div>
				<div class="form-group col-lg-8" style="margin-left: 40px;">

					<input type="text" class="form-control ng-pristine ng-valid"
						name="keyword" placeholder="Search" required />
				</div>

				<div class="form-group col-lg-4">
					<div style="padding-top: 24px;">
						<input type="submit" value="Search" class="btn btn-danger"
							style="margin-left: 1000px;" />
					</div>
				</div>
			</div>
	
</form>


	
	<hr style="border-color: #1c46a8">
	<div class="clearfix"></div>
	</div>
     
	<div class="clearfix"></div>
	<div class="container" style="margin-left: 1px;">
	<a href="./excel" class="btn btn-danger">Export to Excel</a>
		<table class="table table-bordered">
			<thead
				style="background: #003466; color: white; font: Open Sans, sans-serif; padding: 12px 6px;">
				<tr>
					<th scope="col">User Id</th>
					<th scope="col">Name of State</th>
					<th scope="col">Name of the Discom</th>
					<th scope="col">Name of Employee</th>
					<th scope="col">Query No.</th>
					<th scope="col">Facility Name</th>
					<th scope="col">Description</th>
					<th scope="col">Query Registration Date</th>
					<th scope="col">Status</th>
					<th scope="col">QueryComplianceDate</th>
					<th scope="col">remarks</th>
					<th scope="col">Edit</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="discom" items="${searchList}">
					<tr style="text-align: center;" class="color">
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
						<td>${discom[10]}</td>
						<td style="text-align: center;"><a
							href="./updateQuerystatus/${discom[11]}">Update</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>


</body>

</html>


