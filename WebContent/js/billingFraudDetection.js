$(function () {
    var summaryDetails;
    $('#tabs').tab();      
	$( "#fromdate" ).calendarsPicker({yearRange: 'any'});	
	$( "#todate" ).calendarsPicker({yearRange: 'any'});
	
    var billingFraudDetection= function() {
		var fromDate;
		var toDate;
		
		if($("#fromdate").val()){
    		date = new Date($("#fromdate").val());
    		fromDate = date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
    	}
    	
    	if($("#todate").val()){
    		date = new Date($("#todate").val());
    		toDate = date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
    	}
		    	
		$.ajax({
			type: "GET",
			url: "/ICD10BrowserWS/rest/bfr/fetchByRange/" + fromDate + "_" + toDate,
			headers: {"Accept": "application/json", "Content-Type" : "application/json"},
			dataType: 'json',
			success: function(data) {
				var aaData = JSON.parse(data).bills;
				for(var i=0; i<aaData.length; i++){
					aaData[i]["button"] = "<button class='btn btn-success' id='#moreDetails'>More Details</button>";
				}
				$('#billingFraudResult').dataTable({
					"aaData": aaData,
					"aoColumns": [
		              {"mData": "firstName", sDefaultContent: "",  "sTitle": "Patient First Name", "sWidth": "25%" },
		              {"mData": "lastName", sDefaultContent: "", "sTitle" : "Patient First Name", "sWidth": "25%" },
		              {"mData": "billNumber", sDefaultContent: "",  "sTitle": "Bill Number", "sWidth": "25%" },
		              {"mData": "button", sDefaultContent: "", "sTitle": "More Details",  "sWidth": "25%"}
		            ],
		            "bDestroy": true
				});
			},
			error: function(xhr, textStatus, errorThrown) {
				alert("error");
			}
		});		
		
		$.ajax({
			type: "GET",
			url: "/ICD10BrowserWS/rest/bfr/fetchSummaryForRange/" + fromDate + "_" + toDate,
			headers: {"Accept": "application/json", "Content-Type" : "application/json"},
			dataType: 'json',
			success: function(data) {
				alert("hi");
				summaryDetails = JSON.parse(data);
			},
			error: function(xhr, textStatus, errorThrown) {
				alert("error");
			}
		}).done(function(){	
		
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
		            name: 'Percentage',
		            data: [
		                ['Correct Billing',  (typeof summaryDetails.correctBills != "undefined") ? (summaryDetails.correctBills/summaryDetails.totalBills) : 0 ],//35.5],
		                {
		                    name: 'Billing Fraud',
		                    y: (typeof summaryDetails.fraudBills != "undefined")  ? (summaryDetails.fraudBills/summaryDetails.totalBills) : 0 , //54,
		                    sliced: true,
		                    selected: true
		                },
		                ['Bill not generated',   (typeof summaryDetails.billNotGenerated != "undefined")  ? (summaryDetails.billNotGenerated/summaryDetails.totalBills) : 0 ] // 9.5]
		            ]
		        }]
		    });    
		});
	};
	
	$( "#searchBillingFraud" ).click(billingFraudDetection);
});