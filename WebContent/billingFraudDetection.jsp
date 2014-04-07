<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<link rel="stylesheet" type="text/css"
	href="css/jquery.calendars.picker.css">
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
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
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
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Services<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="prescriptionToRecord.jsp"> Prescription To
									Record</a></li>
							<li><a href="searchICD10.jsp"> ICD10 Code Generation</a></li>
							<li><a href="billingFraudDetection.jsp"> Billing Fraud
									Detection</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="page-header">
					<h1>Billing Fraud Detection</h1>
				</div>
				<ul id="tabs" class="nav nav-tabs" data-tabs="tabs">
					<li class="active"><a href="#detectBillingFraud"
						class="btn btn-large" data-toggle="tab">Detect
							Billing Fraud</a></li>
					<li><a href="#summary" class="btn btn-large"
						data-toggle="tab">Billing Summary</a></li>
				</ul>

				<div class="tab-content" style="padding-left: 20px;">
					<div class="tab-pane active" id="detectBillingFraud">
						<br>
						<div class="row">
							<form>
								<div class="form-group col-md-2">
									<label for="name"> From Date </label> <input type="text"
										class="form-control" id="fromdate" name="fromdate"
										placeholder="Select Date" />
								</div>
								<div class="form-group col-md-2">
									<label for="name"> To Date </label> <input type="text"
										class="form-control" id="todate" name="todate"
										placeholder="Select Date" />
								</div>
							</form>
							<table class="table icdTable" id="table">
								<thead>
									<tr>
										<th>Patient Name</th>
										<th>Last Name</th>
										<th>Bill Number</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>John</td>
										<td>Taylor</td>
										<td>B7644</td>
										<td>
											<button class="btn btn-success">More Details</button>
										</td>
									</tr>
									<tr>
										<td>Jack</td>
										<td>Domain</td>
										<td>B6632</td>
										<td>
											<button class="btn btn-success">More Details</button>
										</td>
									</tr>
									<tr>
										<td>Bill</td>
										<td>Swift</td>
										<td>B6324</td>
										<td>
											<button class="btn btn-success">More Details</button>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					<div class="tab-pane" id="summary">
						<div id="container2" style="height: 400px; margin: 0 auto"></div>
					</div>
				</div>
				<!--  <p><a class="btn btn-primary btn-lg" href="patientInformation.html">Detect Billing Fraud &raquo;</a></p>-->
			</div>
		</div>
		<script
			src="//rawgithub.com/stidges/jquery-searchable/master/dist/jquery.searchable-1.0.0.min.js"></script>
	</div>
	<!-- /container -->
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
	<script src="js/vendor/bootstrap.min.js"></script>
	<script src="js/highcharts.js"></script>
	<script src="js/modules/exporting.js"></script>
	<script type="text/javascript" src="js/jquery.calendars.min.js"></script>
	<script type="text/javascript" src="js/jquery.calendars.plus.min.js"></script>
	<script type="text/javascript" src="js/jquery.calendars.picker.js"></script>
	<script src="js/billingFraudDetection.js"></script>
</body>

</html>
