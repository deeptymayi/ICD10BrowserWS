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
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script type="text/javascript">
$(function () {
    $('#container2').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: 'Billing Fraud Summary'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    color: '#000000',
                    connectorColor: '#000000',
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %'
                }
            }
        },
        series: [{
            type: 'pie',
            name: 'Browser share',
            data: [
                ['Correct Billing',   35.5],
                {
                    name: 'Billing Fraud',
                    y: 54,
                    sliced: true,
                    selected: true
                },
                ['Bill not generated',    9.5]
            ]
        }]
    });
});
    

        </script>
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
			</div>
			<!--/.navbar-collapse -->
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="span12">

				<hr>

				<p class="lead">Billing Fraud Detection</p>
				<div id="tab" class="btn-group" data-toggle="buttons-radio">
					<a href="#detectBillingFraud" class="btn btn-large btn-info active"
						data-toggle="tab"" >Detect Billing Fraud</a> <a href="#summary"
						class="btn btn-large btn-info" data-toggle="tab"
						style="background: lightgrey;">Billing Summary</a>
				</div>

				<div class="tab-content" style="padding-left: 20px;">
					<div class="tab-pane active" id="detectBillingFraud">
						<br>

						<div class="row">
							<form>

								<div id="fromDate">
									<p>
										<label for=""> From Date</label>
									</p>

									<div>
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
									<div>
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
									<div>
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
								<div id="toDate">
									<p>
										<label for=""> To Date</label>
									</p>

									<div>
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
									<div>
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
									<div>
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
									<button class="btn btn-success" style="margin-left: 20px;">
										Search</button>
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
</body>

</html>
