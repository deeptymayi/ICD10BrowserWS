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
			<div class="col-xs-10 col-sm-10 col-md-10 well well-sm">
				<legend>
					<a href="http://www.jquery2dotnet.com"><i
						class="glyphicon glyphicon-globe"></i></a> Prescription To Record
				</legend>
				<form action="#" method="post" class="form" role="form">
					<div class="row">
						<div class="col-xs-6 col-md-6">
							<input class="form-control" name="firstname"
								placeholder="First Name" type="text" required autofocus />
						</div>
						<div class="col-xs-6 col-md-6">
							<input class="form-control" name="lastname"
								placeholder="Last Name" type="text" required />
						</div>
					</div>
					<input class="form-control" name="Patientemail"
						placeholder="Patient's Email" type="email" /> <label for="">
						Birth Date</label>
					<div class="row">
						<div class="col-xs-4 col-md-4">
							<select class="form-control">
								<option value="Month">Month</option>
								<option value="January">January</option>
								<option value="February">February</option>
								<option value="March">March</option>
								<option value="April">April</option>
								<option value="May">May</option>
								<option value="June">June</option>
								<option value="July">July</option>
								<option value="August">August</option>
								<option value="September">September</option>
								<option value="October">October</option>
								<option value="Novemeber">November</option>
								<option value="December">December</option>
							</select>
						</div>
						<div class="col-xs-4 col-md-4">
							<select class="form-control">
								<option value="Day">Day</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
								<option value="10">10</option>
								<option value="11">11</option>
								<option value="12">12</option>
								<option value="13">13</option>
								<option value="14">14</option>
								<option value="15">15</option>
								<option value="16">16</option>
								<option value="17">17</option>
								<option value="18">18</option>
								<option value="19">19</option>
								<option value="20">20</option>
								<option value="21">21</option>
								<option value="22">22</option>
								<option value="23">23</option>
								<option value="24">24</option>
								<option value="25">25</option>
								<option value="26">26</option>
								<option value="27">27</option>
								<option value="28">28</option>
								<option value="29">29</option>
								<option value="30">30</option>
								<option value="31">31</option>
							</select>
						</div>
						<div class="col-xs-4 col-md-4">
							<select class="form-control">
								<option value="Year">Year</option>
								<option value="1910">1910</option>
								<option value="1911">1911</option>
								<option value="1912">1912</option>
								<option value="1913">1913</option>
								<option value="1914">1914</option>
								<option value="1915">1915</option>
								<option value="1916">1916</option>
								<option value="1917">1917</option>
								<option value="1918">1918</option>
								<option value="1919">1919</option>
								<option value="1920">1920</option>
								<option value="1921">1921</option>
								<option value="1922">1922</option>
								<option value="1923">1923</option>
								<option value="1924">1924</option>
								<option value="1925">1925</option>
								<option value="1926">1926</option>
								<option value="1927">1927</option>
								<option value="1928">1928</option>
								<option value="1929">1929</option>
								<option value="1930">1930</option>
								<option value="1931">1931</option>
								<option value="1932">1932</option>
								<option value="1933">1933</option>
								<option value="1934">1934</option>
								<option value="1935">1935</option>
								<option value="1936">1936</option>
								<option value="1937">1937</option>
								<option value="1938">1938</option>
								<option value="1939">1939</option>
								<option value="1940">1940</option>
								<option value="1941">1941</option>
								<option value="1942">1942</option>
								<option value="1943">1943</option>
								<option value="1944">1944</option>
								<option value="1945">1945</option>
								<option value="1946">1946</option>
								<option value="1947">1947</option>
								<option value="1948">1948</option>
								<option value="1949">1949</option>
								<option value="1950">1950</option>
								<option value="1951">1951</option>
								<option value="1952">1952</option>
								<option value="1953">1953</option>
								<option value="1954">1954</option>
								<option value="1955">1955</option>
								<option value="1956">1956</option>
								<option value="1957">1957</option>
								<option value="1958">1958</option>
								<option value="1959">1959</option>
								<option value="1960">1960</option>
								<option value="1961">1961</option>
								<option value="1962">1962</option>
								<option value="1963">1963</option>
								<option value="1964">1964</option>
								<option value="1965">1965</option>
								<option value="1966">1966</option>
								<option value="1967">1967</option>
								<option value="1968">1968</option>
								<option value="1969">1969</option>
								<option value="1970">1970</option>
								<option value="1971">1971</option>
								<option value="1972">1972</option>
								<option value="1973">1973</option>
								<option value="1974">1974</option>
								<option value="1975">1975</option>
								<option value="1976">1976</option>
								<option value="1977">1977</option>
								<option value="1978">1978</option>
								<option value="1979">1979</option>
								<option value="1980">1980</option>
								<option value="1981">1981</option>
								<option value="1982">1982</option>
								<option value="1983">1983</option>
								<option value="1984">1984</option>
								<option value="1985">1985</option>
								<option value="1986">1986</option>
								<option value="1987">1987</option>
								<option value="1988">1988</option>
								<option value="1989">1989</option>
								<option value="1990">1990</option>
								<option value="1991">1991</option>
								<option value="1992">1992</option>
								<option value="1993">1993</option>
								<option value="1994">1994</option>
								<option value="1995">1995</option>
								<option value="1996">1996</option>
								<option value="1997">1997</option>
								<option value="1998">1998</option>
								<option value="1999">1999</option>
								<option value="2000">2000</option>
								<option value="2001">2001</option>
								<option value="2002">2002</option>
								<option value="2003">2003</option>
								<option value="2004">2004</option>
								<option value="2005">2005</option>
								<option value="2006">2006</option>
								<option value="2007">2007</option>
								<option value="2008">2008</option>
								<option value="2009">2009</option>
								<option value="2010">2010</option>
								<option value="2011">2011</option>
								<option value="2012">2012</option>
								<option value="2013">2013</option>
								<option value="2014">2014</option>
								<option value="2015">2015</option>
								<option value="2016">2016</option>
								<option value="2017">2017</option>
								<option value="2018">2018</option>
								<option value="2019">2019</option>
								<option value="2020">2020</option>
								<option value="2021">2021</option>
								<option value="2022">2022</option>
								<option value="2023">2023</option>
								<option value="2024">2024</option>
								<option value="2025">2025</option>
								<option value="2026">2026</option>
								<option value="2027">2027</option>
								<option value="2028">2028</option>
								<option value="2029">2029</option>
								<option value="2030">2030</option>
								<option value="2031">2031</option>
								<option value="2032">2032</option>
								<option value="2033">2033</option>
								<option value="2034">2034</option>
							</select>
						</div>
					</div>
					<label class="radio-inline"> <input type="radio" name="sex"
						id="inlineCheckbox1" value="male" />Male
					</label> <label class="radio-inline"> <input type="radio"
						name="sex" id="inlineCheckbox2" value="female" />Female
					</label> <br /> <br />
					<!--Disease Details-->
					<!--<div class="control-group">-->
					<table>
						<tr>
							<td width=50%><label class="control-label">Diagnosed
									With</label></td>
							<td>
								<div class="controls">
									<input id="Disease Name" name="Disease Name" type="text"
										placeholder="Disease Name" class="input-xlarge">
								</div>
							</td>
						</tr>
					</table>
					<!--</div>-->
					<br />
					<!-- ICD10 CODE Details-->
					<!--    <div class="control-group"> -->
					<table>
						<tr>
							<td><label class="control-label">ICD10 Code</label></td>
							<td width=50%>
								<div class="controls">
									<input id="ICD10" name="ICD10" type="text" placeholder="ICD10"
										class="input-xlarge">
								</div>
							</td>
						</tr>
					</table>
					<!--</div>-->
					<br />
					<!--Medicine Details-->
					<!--<div class="control-group">-->
					<table>
						<tr>
							<td width=50%><label class="control-label">Prescribed
									Medicines</label></td>
							<td>
								<div class="controls">
									<input id="Medicines" name="Medicines" type="text"
										placeholder="Medicine" class="input-xlarge">
								</div>
							</td>
						</tr>
					</table>
					<!--</div>-->
					<br />
					<!--Dosage Details-->
					<!--<div class="control-group">-->
					<table>
						<tr>
							<td width=50%><label class="control-label">Dosage</label></td>
							<td>
								<div class="controls">
									<input id="Dosage" name="Dosage" type="text"
										placeholder="Dosage" class="input-xlarge">
								</div>
							</td>
						</tr>
					</table>
					<br />
					<table>
						<tr>
							<td width=50%><label class="control-label">Bill
									Number</label></td>
							<td>
								<div class="controls">
									<input id="Bill Amount" name="billNumber" type="text"
										placeholder="Bill Number" class="input-xlarge">
								</div>
							</td>
						</tr>
					</table>
					<br />
					<table>
						<tr>
							<td width=50%><label class="control-label">Total
									Bill</label></td>
							<td>
								<div class="controls">
									<input id="Bill Amount" name="totalBill" type="text"
										placeholder="Bill Amount" class="input-xlarge">
								</div>
							</td>
						</tr>
					</table>
					<!--</div>-->
					<br />
					<!-- address-line1 input-->
					<div class="control-group">
						<label class="control-label">Address Line 1</label>
						<div class="controls">
							<input id="address-line1" name="address-line1" type="text"
								placeholder="Street Name, P.O box" class="input-xlarge">
						</div>
					</div>
					<br />
					<!-- address-line2 input-->
					<div class="control-group">
						<label class="control-label">Address Line 2</label>
						<div class="controls">
							<input id="address-line2" name="address-line2" type="text"
								placeholder="Apartment, suite, Floor etc" class="input-xlarge">
						</div>
					</div>
					<br />
					<!-- city input-->
					<div class="control-group">
						<label class="control-label">City / Town</label>
						<div class="controls">
							<input id="city" name="city" type="text" placeholder="city"
								class="input-xlarge">
							<p class="help-block"></p>
						</div>
					</div>
					<!-- region input-->
					<div class="control-group">
						<label class="control-label">State / Province / Region</label>
						<div class="controls">
							<input id="region" name="region" type="text"
								placeholder="state / province / region" class="input-xlarge">
							<p class="help-block"></p>
						</div>
					</div>
					<!-- postal-code input-->
					<div class="control-group">
						<label class="control-label">Zip / Postal Code</label>
						<div class="controls">
							<input id="postal-code" name="postal-code" type="text"
								placeholder="zip or postal code" class="input-xlarge">
							<p class="help-block"></p>
						</div>
					</div>
					<!-- country select -->
					<div class="control-group">
						<label class="control-label">Country</label>
						<div class="controls">
							<select id="country" name="country" class="input-xlarge">
								<option value="" selected="selected">(please select a
									country)</option>
								<option value="AF">Afghanistan</option>
								<option value="AL">Albania</option>
								<option value="DZ">Algeria</option>
								<option value="AS">American Samoa</option>
								<option value="AD">Andorra</option>
								<option value="AO">Angola</option>
								<option value="AI">Anguilla</option>
								<option value="AQ">Antarctica</option>
								<option value="AG">Antigua and Barbuda</option>
								<option value="AR">Argentina</option>
								<option value="AM">Armenia</option>
								<option value="AW">Aruba</option>
								<option value="AU">Australia</option>
								<option value="AT">Austria</option>
								<option value="AZ">Azerbaijan</option>
								<option value="BS">Bahamas</option>
								<option value="BH">Bahrain</option>
								<option value="BD">Bangladesh</option>
								<option value="BB">Barbados</option>
								<option value="BY">Belarus</option>
								<option value="BE">Belgium</option>
								<option value="BZ">Belize</option>
								<option value="BJ">Benin</option>
								<option value="BM">Bermuda</option>
								<option value="BT">Bhutan</option>
								<option value="BO">Bolivia</option>
								<option value="BA">Bosnia and Herzegowina</option>
								<option value="BW">Botswana</option>
								<option value="BV">Bouvet Island</option>
								<option value="BR">Brazil</option>
								<option value="IO">British Indian Ocean Territory</option>
								<option value="BN">Brunei Darussalam</option>
								<option value="BG">Bulgaria</option>
								<option value="BF">Burkina Faso</option>
								<option value="BI">Burundi</option>
								<option value="KH">Cambodia</option>
								<option value="CM">Cameroon</option>
								<option value="CA">Canada</option>
								<option value="CV">Cape Verde</option>
								<option value="KY">Cayman Islands</option>
								<option value="CF">Central African Republic</option>
								<option value="TD">Chad</option>
								<option value="CL">Chile</option>
								<option value="CN">China</option>
								<option value="CX">Christmas Island</option>
								<option value="CC">Cocos (Keeling) Islands</option>
								<option value="CO">Colombia</option>
								<option value="KM">Comoros</option>
								<option value="CG">Congo</option>
								<option value="CD">Congo, the Democratic Republic of
									the</option>
								<option value="CK">Cook Islands</option>
								<option value="CR">Costa Rica</option>
								<option value="CI">Cote d'Ivoire</option>
								<option value="HR">Croatia (Hrvatska)</option>
								<option value="CU">Cuba</option>
								<option value="CY">Cyprus</option>
								<option value="CZ">Czech Republic</option>
								<option value="DK">Denmark</option>
								<option value="DJ">Djibouti</option>
								<option value="DM">Dominica</option>
								<option value="DO">Dominican Republic</option>
								<option value="TP">East Timor</option>
								<option value="EC">Ecuador</option>
								<option value="EG">Egypt</option>
								<option value="SV">El Salvador</option>
								<option value="GQ">Equatorial Guinea</option>
								<option value="ER">Eritrea</option>
								<option value="EE">Estonia</option>
								<option value="ET">Ethiopia</option>
								<option value="FK">Falkland Islands (Malvinas)</option>
								<option value="FO">Faroe Islands</option>
								<option value="FJ">Fiji</option>
								<option value="FI">Finland</option>
								<option value="FR">France</option>
								<option value="FX">France, Metropolitan</option>
								<option value="GF">French Guiana</option>
								<option value="PF">French Polynesia</option>
								<option value="TF">French Southern Territories</option>
								<option value="GA">Gabon</option>
								<option value="GM">Gambia</option>
								<option value="GE">Georgia</option>
								<option value="DE">Germany</option>
								<option value="GH">Ghana</option>
								<option value="GI">Gibraltar</option>
								<option value="GR">Greece</option>
								<option value="GL">Greenland</option>
								<option value="GD">Grenada</option>
								<option value="GP">Guadeloupe</option>
								<option value="GU">Guam</option>
								<option value="GT">Guatemala</option>
								<option value="GN">Guinea</option>
								<option value="GW">Guinea-Bissau</option>
								<option value="GY">Guyana</option>
								<option value="HT">Haiti</option>
								<option value="HM">Heard and Mc Donald Islands</option>
								<option value="VA">Holy See (Vatican City State)</option>
								<option value="HN">Honduras</option>
								<option value="HK">Hong Kong</option>
								<option value="HU">Hungary</option>
								<option value="IS">Iceland</option>
								<option value="IN">India</option>
								<option value="ID">Indonesia</option>
								<option value="IR">Iran (Islamic Republic of)</option>
								<option value="IQ">Iraq</option>
								<option value="IE">Ireland</option>
								<option value="IL">Israel</option>
								<option value="IT">Italy</option>
								<option value="JM">Jamaica</option>
								<option value="JP">Japan</option>
								<option value="JO">Jordan</option>
								<option value="KZ">Kazakhstan</option>
								<option value="KE">Kenya</option>
								<option value="KI">Kiribati</option>
								<option value="KP">Korea, Democratic People's Republic
									of</option>
								<option value="KR">Korea, Republic of</option>
								<option value="KW">Kuwait</option>
								<option value="KG">Kyrgyzstan</option>
								<option value="LA">Lao People's Democratic Republic</option>
								<option value="LV">Latvia</option>
								<option value="LB">Lebanon</option>
								<option value="LS">Lesotho</option>
								<option value="LR">Liberia</option>
								<option value="LY">Libyan Arab Jamahiriya</option>
								<option value="LI">Liechtenstein</option>
								<option value="LT">Lithuania</option>
								<option value="LU">Luxembourg</option>
								<option value="MO">Macau</option>
								<option value="MK">Macedonia, The Former Yugoslav
									Republic of</option>
								<option value="MG">Madagascar</option>
								<option value="MW">Malawi</option>
								<option value="MY">Malaysia</option>
								<option value="MV">Maldives</option>
								<option value="ML">Mali</option>
								<option value="MT">Malta</option>
								<option value="MH">Marshall Islands</option>
								<option value="MQ">Martinique</option>
								<option value="MR">Mauritania</option>
								<option value="MU">Mauritius</option>
								<option value="YT">Mayotte</option>
								<option value="MX">Mexico</option>
								<option value="FM">Micronesia, Federated States of</option>
								<option value="MD">Moldova, Republic of</option>
								<option value="MC">Monaco</option>
								<option value="MN">Mongolia</option>
								<option value="MS">Montserrat</option>
								<option value="MA">Morocco</option>
								<option value="MZ">Mozambique</option>
								<option value="MM">Myanmar</option>
								<option value="NA">Namibia</option>
								<option value="NR">Nauru</option>
								<option value="NP">Nepal</option>
								<option value="NL">Netherlands</option>
								<option value="AN">Netherlands Antilles</option>
								<option value="NC">New Caledonia</option>
								<option value="NZ">New Zealand</option>
								<option value="NI">Nicaragua</option>
								<option value="NE">Niger</option>
								<option value="NG">Nigeria</option>
								<option value="NU">Niue</option>
								<option value="NF">Norfolk Island</option>
								<option value="MP">Northern Mariana Islands</option>
								<option value="NO">Norway</option>
								<option value="OM">Oman</option>
								<option value="PK">Pakistan</option>
								<option value="PW">Palau</option>
								<option value="PA">Panama</option>
								<option value="PG">Papua New Guinea</option>
								<option value="PY">Paraguay</option>
								<option value="PE">Peru</option>
								<option value="PH">Philippines</option>
								<option value="PN">Pitcairn</option>
								<option value="PL">Poland</option>
								<option value="PT">Portugal</option>
								<option value="PR">Puerto Rico</option>
								<option value="QA">Qatar</option>
								<option value="RE">Reunion</option>
								<option value="RO">Romania</option>
								<option value="RU">Russian Federation</option>
								<option value="RW">Rwanda</option>
								<option value="KN">Saint Kitts and Nevis</option>
								<option value="LC">Saint LUCIA</option>
								<option value="VC">Saint Vincent and the Grenadines</option>
								<option value="WS">Samoa</option>
								<option value="SM">San Marino</option>
								<option value="ST">Sao Tome and Principe</option>
								<option value="SA">Saudi Arabia</option>
								<option value="SN">Senegal</option>
								<option value="SC">Seychelles</option>
								<option value="SL">Sierra Leone</option>
								<option value="SG">Singapore</option>
								<option value="SK">Slovakia (Slovak Republic)</option>
								<option value="SI">Slovenia</option>
								<option value="SB">Solomon Islands</option>
								<option value="SO">Somalia</option>
								<option value="ZA">South Africa</option>
								<option value="GS">South Georgia and the South Sandwich
									Islands</option>
								<option value="ES">Spain</option>
								<option value="LK">Sri Lanka</option>
								<option value="SH">St. Helena</option>
								<option value="PM">St. Pierre and Miquelon</option>
								<option value="SD">Sudan</option>
								<option value="SR">Suriname</option>
								<option value="SJ">Svalbard and Jan Mayen Islands</option>
								<option value="SZ">Swaziland</option>
								<option value="SE">Sweden</option>
								<option value="CH">Switzerland</option>
								<option value="SY">Syrian Arab Republic</option>
								<option value="TW">Taiwan, Province of China</option>
								<option value="TJ">Tajikistan</option>
								<option value="TZ">Tanzania, United Republic of</option>
								<option value="TH">Thailand</option>
								<option value="TG">Togo</option>
								<option value="TK">Tokelau</option>
								<option value="TO">Tonga</option>
								<option value="TT">Trinidad and Tobago</option>
								<option value="TN">Tunisia</option>
								<option value="TR">Turkey</option>
								<option value="TM">Turkmenistan</option>
								<option value="TC">Turks and Caicos Islands</option>
								<option value="TV">Tuvalu</option>
								<option value="UG">Uganda</option>
								<option value="UA">Ukraine</option>
								<option value="AE">United Arab Emirates</option>
								<option value="GB">United Kingdom</option>
								<option value="US">United States</option>
								<option value="UM">United States Minor Outlying Islands</option>
								<option value="UY">Uruguay</option>
								<option value="UZ">Uzbekistan</option>
								<option value="VU">Vanuatu</option>
								<option value="VE">Venezuela</option>
								<option value="VN">Viet Nam</option>
								<option value="VG">Virgin Islands (British)</option>
								<option value="VI">Virgin Islands (U.S.)</option>
								<option value="WF">Wallis and Futuna Islands</option>
								<option value="EH">Western Sahara</option>
								<option value="YE">Yemen</option>
								<option value="YU">Yugoslavia</option>
								<option value="ZM">Zambia</option>
								<option value="ZW">Zimbabwe</option>
							</select>
						</div>
					</div>
					<br /> <br />
					<button class="btn btn-lg btn-primary btn-block" type="submit">
						Submit</button>
				</form>
			</div>
		</div>
	</div>
		<script	src="//rawgithub.com/stidges/jquery-searchable/master/dist/jquery.searchable-1.0.0.min.js"></script>
	<!-- /container -->
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
	<script src="js/vendor/bootstrap.min.js"></script>
	<script src="js/main.js"></script>
</body>
</html>