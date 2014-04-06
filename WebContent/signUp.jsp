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
						<input type="text" placeholder="Username" id="loginusername" class="form-control" type="text" required >
					</div>
					<div class="form-group">
						<input type="password" placeholder="Password" id="loginpassword" class="form-control" type="text" required >
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
				<form id="signUpForm" action="" method="post" accept-charset="utf-8"
					class="form" role="form">
					<legend>Sign Up</legend>
					<div class="row">
						<div class="col-xs-6 col-md-6">
							<input type="text" name="firstname" id="firstname" value=""
								class="form-control input-lg" placeholder="First Name"
								type="text" required />
						</div>
						<div class="col-xs-6 col-md-6">
							<input type="text" name="lastname" id="lastname" value=""
								class="form-control input-lg" placeholder="Last Name"
								type="text" required />
						</div>
					</div>
					<input type="text" name="username" id="username" value=""
						class="form-control input-lg" placeholder="Username" type="text"
						required /> 
					<input type="password" name="password" id="password"
						value="" class="form-control input-lg" placeholder="Password"
						type="password" required /> 
					<input type="password" name="confirm_password" 
						value="" class="form-control input-lg"
						placeholder="Confirm Password" type="password" required /> <br />
					<span class="help-block">By clicking Create my account, you
						agree to our Terms.</span>
					<button class="btn btn-lg btn-primary btn-block signup-btn"
						type="submit">Create my account</button>
				</form>
			</div>
		</div>
		<div class="modal fade" id="signUpSuccess">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
		        <h4 class="modal-title">Signup successfully</h4>
		      </div>
		      <div class="modal-body">
		        <p> Congratulations. User account created successfully !!! </p>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		      </div>
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
		</div><!-- /.modal -->	
		<div class="modal fade" id="signUpError">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
		        <h4 class="modal-title">Signup Error</h4>
		      </div>
		      <div class="modal-body">
		        <p> Server issues. Please try again later !!!</p>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		      </div>
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
		</div><!-- /.modal -->	
		<div class="modal fade" id="loginError">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
		        <h4 class="modal-title">Login Error</h4>
		      </div>
		      <div class="modal-body">
		        <p> Server issues. Please try again later !!!</p>
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
	<script src="js/signUp.js"></script>
</body>

</html>
