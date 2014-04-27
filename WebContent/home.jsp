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
<link rel="stylesheet" href="http://jquery.bassistance.de/validate/demo/site-demos.css">
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
				</ul>
				<form id="loginForm" class="navbar-form navbar-right">
					<div class="form-group">
						<input type="text" placeholder="Username" id="loginusername" name="loginusername" class="form-control" type="text"  >
					</div>
					<div class="form-group">
						<input type="password" placeholder="Password" id="loginpassword" name="loginpassword" class="form-control" type="text"  >
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
				<a class="btn btn-primary btn-lg" href="signUp.jsp">Sign up &raquo;</a>
			</p>
		</div>
	</div>

	<div class="container">
		<!-- Example row of columns -->
		<div class="row">
			<div class="col-lg-4">
				<h2>What is ICD-10 ?</h2>				
				<p>The ICD-10 (the 10th revision of the International Statistical Classification of Diseases and Related 
				<br/>Health Problems) is a list of diagnostic codes <br/>provided by WHO and used by medical
					professionals across the world.</p>
				<!-- <p>
					<a class="btn btn-default" href="#">View details &raquo;</a>
				</p> -->
				<img src="<%=request.getContextPath()%>/img/icd-10.jpg" alt="ICD10" style="width:280px;height:200px">
			</div>
			<div class="col-lg-4">
				<h2>Need for Context Browser</h2>
				<p>The ICD10 Context Browser helps medical professionals by correctly classifying patient's
					diagnosis according to the international ICD-10 standards.
				</p>
				<!-- <p>
					<a class="btn btn-default" href="#">View details &raquo;</a>
				</p> -->
				<img src="<%=request.getContextPath()%>/img/icd10codes.png" alt="ICD10" style="width:350px;height:250px">
			</div>
			<div class="col-lg-4">
				<h2>Billing Fraud and Impact</h2>
				<p>The EHR Billing Fraud Detection feature can match the ICD-10
					code on a patient's medical bill with the ICD-10 code returned by
					running text analytics on the patient's log and validate them
					against billing fraud.</p>
				<!-- <p>
					<a class="btn btn-default" href="#">View details &raquo;</a>
				</p> -->
				<img src="<%=request.getContextPath()%>/img/billing.png" alt="ICD10" style="width:300px;height:200px; border-radius:25px; margin-top:15px;">
			</div>
		</div>

		<hr>
		<div class="modal fade" id="loginError">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
		        <h4 class="modal-title">Login Error</h4>
		      </div>
		      <div class="modal-body">
		        <p> Please enter valid username / password.</p>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		      </div>
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
		</div><!-- /.modal -->	
		<div class="modal fade" id="loginSuccess">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
		        <h4 class="modal-title">Welcome. Login Successful !!!</h4>
		      </div>
		      <div class="modal-body">
		        <p> You are being directed to the Services page ... </p>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		      </div>
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
		<footer>
			<p>&copy; SJSU Cmpe295 Group25 2013</p>
		</footer>
	</div>
	<!-- /container -->
	<script	src="//ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>	
	<script src="http://jquery.bassistance.de/validate/jquery.validate.js"></script>
	<script	src="http://jquery.bassistance.de/validate/additional-methods.js"></script>
	<script src="js/vendor/bootstrap.min.js"></script>
	<script src="js/home.js"></script>
</body>

</html>