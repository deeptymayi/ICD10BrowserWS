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
<link href="//datatables.net/download/build/nightly/jquery.dataTables.css" rel="stylesheet" type="text/css" />
<style>
body {
	padding-top: 50px;
	padding-bottom: 20px;
}
</style>
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/main.css">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
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
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Services<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="prescriptionToRecord.jsp"> Prescription To	Record</a></li>
							<li><a href="searchICD10.jsp"> ICD10 Code Generation</a></li>
							<li><a href="searchICD10TextAnalytics.jsp"> ICD10 Code Generation with Text Analytics</a></li>
							<li><a href="billingFraudDetection.jsp"> Billing Fraud Detection</a></li>
						</ul>
					</li>
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
							<form id="fraudDetectionForm">
							<div class="form-group col-md-2">
								<label for="name"> From Date </label> <input type="text"
									class="form-control" id="fromdate" name="fromdate" required
									placeholder="Select Date" />
							</div>
							<div class="form-group col-md-2">
								<label for="name"> To Date </label> <input type="text"
									class="form-control" id="todate" name="todate" required
									placeholder="Select Date" />
							</div>	
							</form>													
							<div class="col-lg-6" style="margin-top:23px;">
								<button class="btn btn-success" id="searchBillingFraud" >Search</button>
							</div>
						</div>
						<div class="row" style="margin-top:20px;">
							<div class="col-lg-12">
							    <table cellpadding="0" cellspacing="0" border="0" class="display" id="billingFraudResult"></table>
								<hr>
							</div>
						</div>
					</div>
					<div class="tab-pane" id="summary">
						<div id="container2" style="height: 400px; margin: 0 auto"></div>
					</div>
				</div>
				<!--  <p><a class="btn btn-primary btn-lg" href="patientInformation.html">Detect Billing Fraud &raquo;</a></p>-->
			</div>
		</div>
		<div class="modal fade" id="moreDetails">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
		        <h3 class="modal-title">Patient Billing Details</h3>
		      </div>
		      <div class="modal-body">
		        <p>Patient First Name : <span id="firstName"> </span></p>
		        <p>Patient Last Name : <span id="lastName"> </span></p>
		        <p>Bill Number : <span id="billNumber"> </span></p>
		        <p>Symptoms : <span id="symptoms"> </span></p>
		        <p>Billed ICD10 Code : <span id="billIcd"> </span></p>
		        <p>Possible ICD10 Codes : <span id="suggestedIcd"> </span></p>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		      </div>
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
		</div><!-- /.modal -->	
		<div class="modal fade" id="dateRangeError">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
		        <h4 class="modal-title">Input Date Error !!!</h4>
		      </div>
		      <div class="modal-body">
		        <p> <b>To date</b> must be greater than <b>From date</b></br>
		            Please enter the correct date values and re-submit
		         </p>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		      </div>
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
		<script src="//rawgithub.com/stidges/jquery-searchable/master/dist/jquery.searchable-1.0.0.min.js"></script>
	</div>
	<!-- /container -->
	<script	src="//ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
	<script src="js/vendor/bootstrap.min.js"></script>
	<script src="js/highcharts.js"></script><script src="//datatables.net/download/build/nightly/jquery.dataTables.js"></script>
	<script src="js/modules/exporting.js"></script>
	<script type="text/javascript" src="js/jquery.calendars.min.js"></script>
	<script type="text/javascript" src="js/jquery.calendars.plus.min.js"></script>
	<script type="text/javascript" src="js/jquery.calendars.picker.js"></script>
	<script src="js/billingFraudDetection.js"></script>
</body>

</html>
