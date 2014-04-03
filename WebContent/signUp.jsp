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
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Services<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="prescriptionToRecord.jsp"> Prescription To Record</a></li>
							<li><a href="searchICD10.jsp"> ICD10 Code Generation</a></li>
							<li><a href="billingFraudDetection.jsp"> Billing Fraud Detection</a></li>
						</ul></li>
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
			<!--/.navbar-collapse -->
		</div>
	</div>

	<div class="container" id="wrap">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<form action="r" method="post" accept-charset="utf-8" class="form"
					role="form">
					<legend>Sign Up</legend>
					<div class="row">
						<div class="col-xs-6 col-md-6">
							<input type="text" name="firstname" value=""
								class="form-control input-lg" placeholder="First Name" />
						</div>
						<div class="col-xs-6 col-md-6">
							<input type="text" name="lastname" value=""
								class="form-control input-lg" placeholder="Last Name" />
						</div>
					</div>
					<input type="text" name="email" value=""
						class="form-control input-lg" placeholder="Your Email" /> <input
						type="password" name="password" value=""
						class="form-control input-lg" placeholder="Password" /> <input
						type="password" name="confirm_password" value=""
						class="form-control input-lg" placeholder="Confirm Password" /> <br />
					<span class="help-block">By clicking Create my account, you
						agree to our Terms.</span>
					<button class="btn btn-lg btn-primary btn-block signup-btn"
						type="submit">Create my account</button>
				</form>
			</div>
		</div>
		<footer>
			<p>&copy; SJSU Cmpe295 Group25 2013</p>
		</footer>
	</div>
	<!-- /container -->
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
	<script src="js/vendor/bootstrap.min.js"></script>
	<script src="js/main.js"></script>
</body>

</html>
