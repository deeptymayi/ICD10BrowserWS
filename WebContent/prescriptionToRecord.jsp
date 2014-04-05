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
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
<script src="js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>

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
			<!--/.navbar-collapse -->
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="page-header">
					<h1>
						<a href="http://www.jquery2dotnet.com"><i
							class="glyphicon glyphicon-globe"></i> </a>Prescription To Record
					</h1>
				</div>
			</div>
			<div class="col-md-8">
				<div class="well">
					<form id="patientInformation">
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="name"> First Name</label> <input type="text"
										class="form-control" id="firstname" placeholder=" patient's First Name"
										required="required" />
								</div>
								<div class="form-group">
									<label for="name"> Last Name</label> <input type="text"
										class="form-control" id="lastname" placeholder="Patient's Last Name"
										required="required" />
								</div>
								<div class="form-group">
									<label for="email"> Email Address</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="glyphicon glyphicon-envelope"></span> </span> <input
											type="email" class="form-control" id="email"
											placeholder="Patient's email" required="required" />
									</div>
								</div>
								<div class="form-group">
									<label for="subject"> Sex</label> <select id="sex"
										name="subject" class="form-control" required="required">
										<option value="na" selected="">Choose One:</option>
										<option value="male">Male</option>
										<option value="female">Female</option>
									</select>
								</div>
								<div class="form-group">
									<label for="name"> Birth Date </label> <input type="text" 
									class="form-control" id="birthdate" required="required" />
								</div>						
								<div class="form-group">
									<label for="name"> Diagnosed With </label> <input type="text"
										class="form-control" id="diseasename" placeholder="Disease Name"
										required="required" />
								</div>
								<div class="form-group">
									<label for="name"> ICD10 Code </label> <input type="text"
										class="form-control" id="icdcode" placeholder="ICD10 Code"
										required="required" />
								</div>
								<div class="form-group">
									<label for="name"> Prescribed Medicines </label> <input type="text"
										class="form-control" id="medicines" placeholder="Medicines comma separated"
										required="required" />
								</div>
								<div class="form-group">
									<label for="name"> Dosage </label> <input type="text"
										class="form-control" id="dosage" placeholder="Dosage"
										required="required" />
								</div>
								<div class="form-group">
									<label for="name"> Bill Number </label> <input type="text"
										class="form-control" id="billnumber" placeholder="Bill Number"
										required="required" />
								</div>
								<div class="form-group">
									<label for="name"> Total Bill </label> <input type="text"
										class="form-control" id="totalbill" placeholder="Total Bill"
										required="required" />
								</div>
							</div>
							<div class="col-md-4">
					            <form id="patientAddress">
					            <legend>�Patient Address</legend>
						           <div class="form-group">
									<label for="name"> Address Line 1 </label> <input type="text"
										class="form-control" id="addressline1" placeholder="Address Line 1"
										required="required" />
									</div>
									<div class="form-group">
									<label for="name"> Address Line 2 </label> <input type="text"
										class="form-control" id="addressline2" placeholder="Address Line 2"
										required="required" />
									</div>
									<div class="form-group">
									<label for="name"> City / Town </label> <input type="text"
										class="form-control" id="city" placeholder="City / Town"
										required="required" />
									</div>
									<div class="form-group">
									<label for="name"> State / Province / Region </label> <input type="text"
										class="form-control" id="state" placeholder="State / Province / Region"
										required="required" />
									</div>
									<div class="form-group">
									<label for="name"> Zip / Postal Code </label> <input type="text"
										class="form-control" id="zip" placeholder=" Zip / Postal Code"
										required="required" />
									</div>
					            </form>
					        </div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- /container -->
	<script src="js/prescriptionToRecord.js"></script>
</body>
</html>