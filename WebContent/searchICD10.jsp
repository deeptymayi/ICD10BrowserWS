<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title></title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="css/bootstrap.min.css">
<style>
body {
	padding-top: 50px;
	padding-bottom: 20px;
}
</style>
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/main.css">
<script src="js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
</head>

<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="home.jsp">ICD-10 Context Browser</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="home.jsp">Home</a></li>
					<li><a href="#about">About</a></li>
					<li><a href="#contact">Contact</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Services<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="prescriptionToRecord.jsp"> Prescription To Record</a></li>
							<li><a href="searchICD10.jsp"> ICD10 Code Generation</a></li>
							<li><a href="billingFraudDetection.jsp"> Billing Fraud Detection</a></li>
						</ul>
					</li>
				</ul>
			</div>
			<!--/.navbar-collapse -->
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="page-header">
					<h1>Search for ICD10 Code</h1>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12"></div>
		</div>
		<div class="row">
			<div class="col-lg-6">
				<input type="search" id="search" value="" class="form-control"
					placeholder="Enter patient symptom" style="margin-bottom: 20px;">
				<button class="btn btn-success">Search</button>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<table class="table icdTable" id="table">
					<thead>
						<tr>
							<th>ICD10 Code</th>
							<th>Description</th>
							<th>Notes</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>A00.0</td>
							<td>Cholera due to Vibrio cholerae 01, biovar cholerae</td>
							<td>Cholera due to Vibrio cholerae 01, biovar cholerae</td>
						</tr>
						<tr>
							<td>A01</td>
							<td>Typhoid and paratyphoid fevers</td>
							<td>Typhoid and paratyphoid fevers</td>
						</tr>
						<tr>
							<td>A01.02</td>
							<td>Typhoid fever with heart involvement</td>
							<td>Typhoid fever with heart involvement</td>
						</tr>
						<tr>
							<td>A01.03</td>
							<td>Typhoid pneumonia</td>
							<td>Typhoid pneumonia</td>
						</tr>
					</tbody>
				</table>
				<hr>
			</div>
		</div>
	</div>
	<script	src="//rawgithub.com/stidges/jquery-searchable/master/dist/jquery.searchable-1.0.0.min.js"></script>
	<!-- /container -->
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
	<script src="js/vendor/bootstrap.min.js"></script>
	<script src="js/main.js"></script>
</body>

</html>
