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
<link rel="stylesheet" href="http://jquery.bassistance.de/validate/demo/site-demos.css">
<script type="text/javascript" src="js/jquery.calendars.min.js"></script> 
<script type="text/javascript" src="js/jquery.calendars.plus.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/jquery.calendars.picker.css"> 
<script type="text/javascript" src="js/jquery.calendars.picker.js"></script>
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
					<form id="patientInformationForm" action="" method="post" accept-charset="utf-8" class="form" role="form">
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="name"> First Name</label> <input type="text"
										class="form-control" id="firstname" name="firstname"
										placeholder=" Patient's First Name" required/>
										<p id="errors" style="height:9px;"></p>
								</div>
								<div class="form-group">
									<label for="name"> Last Name</label> <input type="text"
										class="form-control" id="lastname" name="lastname"
										placeholder=" Patient's Last Name" required/>
										<p id="errors" style="height:9px;"></p>
								</div>
								<!-- 
								<div class="form-group">
									<label for="email"> Email Address</label><br />
									<div class="input-group">
										<span class="input-group-addon"><span
											class="glyphicon glyphicon-envelope"></span> </span> <input
											type="email" class="form-control" id="email" name="email"
											placeholder="Patient's email" />
									</div>
								</div>
								-->
								<div class="form-group">
									<label for="subject"> Gender</label> <select id="sex"
										name="subject" class="form-control">
										<option value="na" selected="">Choose One:</option>
										<option value="male">Male</option>
										<option value="female">Female</option>
									</select>
								</div>
								<div class="form-group">
									<label for="name"> Date of Birth </label> <input type="text"
										class="form-control" id="birthdate" name="birthdate"
										placeholder="Select Date" />
								</div>
								<div class="form-group">
									<label for="name"> Phone Number </label> <input type="text"
										class="form-control" id="phoneNum" name="phoneNum"
										placeholder="Phone Number" required/>
										<p id="errors" style="height:9px;"></p>
								</div>
								<div class="form-group">
									<label for="name"> Patient Id</label> <input type="text"
										class="form-control" id="patientId" name="patientId"
										placeholder=" Patient's Id " required />
										<p id="errors" style="height:9px;"></p>
								</div>
								<div class="form-group">
									<label for="name"> Diagnosis </label> <input type="text"
										class="form-control" id="diseasename" name="diseasename"
										placeholder="Disease Name" />
								</div>
								<div class="form-group">
									<label for="name"> ICD10 Code </label> <input type="text"
										class="form-control" id="icdcode" name="icdcode" placeholder="ICD10 Code"/>
								</div>
								<div class="form-group">
									<label for="name"> Prescribed Medicines </label> <input
										type="text" class="form-control" id="medicines" name="medicines"
										placeholder="Medicines comma separated" />
								</div>
								<div class="form-group">
									<label for="name"> Dosage </label> <input type="text"
										class="form-control" id="dosage"  name ="dosage" placeholder="Dosage"/>
								</div>
								<div class="form-group">
									<label for="name"> Bill Number </label> <input type="text"
										class="form-control" id="billnumber" name="billnumber" placeholder="Bill Number" required />
									<p id="errors" style="height:9px;"></p>
								</div>
								<div class="form-group">
									<label for="name"> Billing Date </label> <input type="text"
										class="form-control" id="billingDate" name="billingDate"
										placeholder="Select Date" required/>
										<p id="errors" style="height:9px;"></p>
								</div>
								<div class="form-group">
									<label for="name"> Bill Amount </label> <input type="text"
										class="form-control" id="totalbill" name="totalbill"  placeholder="Total Bill" required />
									<p id="errors" style="height:9px;"></p>
								</div>
							</div>
							<div class="col-md-4">
								<form id="patientAddressForm">
									<legend>Patient Address</legend>
									<div class="form-group">
										<label for="name"> Address Line 1 </label> <input type="text"
											class="form-control" id="addressline1" name="addressline1"
											placeholder="Address Line 1" />
									</div>
									<div class="form-group">
										<label for="name"> Address Line 2 </label> <input type="text"
											class="form-control" id="addressline2" name="addressline2"
											placeholder="Address Line 2" />
									</div>
									<div class="form-group">
										<label for="name"> City / Town </label> <input type="text"
											class="form-control" id="city" name="city" placeholder="City / Town" />
									</div>
									<div class="form-group">
										<label for="name"> State / Province / Region </label> <input
											type="text" class="form-control" id="state" name="state"
											placeholder="State / Province / Region" />
									</div>
									<div class="form-group">
										<label for="name"> Zip / Postal Code </label> <input
											type="text" class="form-control" id="zip" name="zip"
											placeholder=" Zip / Postal Code" />
									</div>
								</form>
							</div>
						</div>
						<button class="btn btn-primary btn-block" id="submitPrescription" type="submit">Submit</button>						
					</form>
				</div>
			</div>
		</div>
		<div class="modal fade" id="ptrModalSuccess">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
		        <h4 class="modal-title">Patient prescriptions updated successfully</h4>
		      </div>
		      <div class="modal-body">
		        <p> Congratulations. Patient prescriptions updated successfully !!! </p>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		      </div>
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
		</div><!-- /.modal -->	
		<div class="modal fade" id="ptrModalError">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
		        <h4 class="modal-title">Error updating patient's prescription record</h4>
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
	</div>
	<!-- /container -->
	<script src="js/vendor/bootstrap.min.js"></script>
	<script src="http://jquery.bassistance.de/validate/jquery.validate.js"></script>
	<script	src="http://jquery.bassistance.de/validate/additional-methods.js"></script>	
	<script src="js/prescriptionToRecord.js"></script>	
</body>
</html>