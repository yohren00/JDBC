<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Len</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>

<div class="container">
		<center><h1>Len 資料庫設計</h1></center>
		<form method="post" action="EmployeesServlet">
			<div class="form-group col-md-6">
			  <label for="example-text-input" class="col-2 col-form-label">Last Name</label>
			  <div class="col-10">
			    <input class="form-control" type="text" value="" name="lastname" placeholder="Last Name">
			  </div>
			  
			  <label for="example-text-input" class="col-2 col-form-label">First Name</label>
			  <div class="col-10">
			    <input class="form-control" type="text" value="" name="firstname" placeholder="First Name">
			  </div>
			  
			  <label for="example-date-input" class="col-2 col-form-label">Birth Date</label>
			  <div class="col-10">
			    <input class="form-control" type="date" value="2017-10-20"  name="birthdate">
			  </div>
			  
			  <div class="col-sm-">
		        <button type="submit" class="btn btn-primary">新增</button>
		      </div>
			</div>
		</form>
		
		<table class="table table-hover table-responsive-sm">
			<thead class="thead-dark">
			      <tr>
			        <th scope="col">ID</th>
			        <th scope="col">Last Name</th>
			        <th scope="col">First Name</th>
			        <th scope="col">Birth Date</th>
			      </tr>
			</thead>
			<tbody>
			      <c:forEach var="employee" items="${requestScope.list}">
			      	<tr>
			      		<td scope="row">${employee[0]}</td>
			      		<td>${employee[1]}</td>
			      		<td>${employee[2]}</td>
			      		<td>${employee[3]}</td>
			      	</tr>
			      </c:forEach>
			</tbody>
		</table>
	</div>
	
</body>
</html>