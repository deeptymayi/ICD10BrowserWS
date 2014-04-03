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
				<form class="navbar-form navbar-right">
					<div class="form-group">
						<input type="text" placeholder="Email" class="form-control">
					</div>
					<div class="form-group">
						<input type="password" placeholder="Password" class="form-control">
					</div>
					<button type="submit" class="btn btn-success">Sign in</button>
				</form>
			</div>
		</div>
	</div>

	<!-- Main jumbotron for a primary marketing message or call to action -->
	<div class="jumbotron">
		<div class="container">
			<h1>ICD10 Context Browser !</h1>
			<p>
				<a class="btn btn-primary btn-lg" href="signUp.jsp">Sign up
					&raquo;</a>
			</p>
		</div>
	</div>

	<div class="container">
		<!-- Example row of columns -->
		<div class="row">
			<div class="col-lg-4">
				<h2>What is ICD-10 ?</h2>
				<p>The ICD-10 (the 10th revision of the International
					Statistical Classification of Diseases and Related Health Problems)
					is a list of diagnostic codes provided by WHO and used by medical
					professionals across the world. ICD-10 is widely used to classify
					diseases and compute the international statistics of mortality rate
					or cause of death.</p>
				<p>
					<a class="btn btn-default" href="#">View details &raquo;</a>
				</p>
			</div>
			<div class="col-lg-4">
				<h2>Need for Context Browser</h2>
				<p>The ICD10 Context Browser will correctly classify patient's
					diagnosis according to the international ICD-10 standards.The
					ICD-10 code generator will be used to generate and identify the
					ICD-10 codes after carrying out text analytics on the patient's log
					written by the doctors. Several diseases with almost similar
					symptoms have entirely different ICD-10 codes; hence determining
					the correct codes from patient diagnosis logs is important and
					needs the use of artificial intelligence, feature detection and
					clustering. Efficiently determining the ICD-10 codes will help
					doctors to select the most appropriate code associated with a
					patient's symptom.</p>
				<p>
					<a class="btn btn-default" href="#">View details &raquo;</a>
				</p>
			</div>
			<div class="col-lg-4">
				<h2>Billing Fraud and Impact</h2>
				<p>The EHR Billing Fraud Detection feature can match the ICD-10
					code on a patient's medical bill with the ICD-10 code returned by
					running text analytics on the patient's log and validate them
					against billing fraud. As per the estimates by American Society of
					Business and Behavioral Science around 80% of the health care
					frauds are due to incorrect claims and billing inconsistencies.
					These features, when integrated with the existing EHR systems will
					not only facilitate faster and optimal ICD-10 codes suggestions but
					will also help in minimizing the health care fraud due to
					inaccurate billing.</p>
				<p>
					<a class="btn btn-default" href="#">View details &raquo;</a>
				</p>
			</div>
		</div>

		<hr>

		<footer>
			<p>&copy; SJSU Cmpe295 Group25 2013</p>
		</footer>
	</div>
	<!-- /container -->
	<script	src="//ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
	<script src="js/vendor/bootstrap.min.js"></script>
	<script src="js/main.js"></script>
</body>

</html>