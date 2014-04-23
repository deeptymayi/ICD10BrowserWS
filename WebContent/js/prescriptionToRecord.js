$(function () {

	$.validator.setDefaults({
		debug: true,
		success: "valid"
	});
	
	$(function() {
	    $( "#birthdate" ).calendarsPicker({yearRange: 'any'});
	});
	
	$(function() {
	    $( "#billingDate" ).calendarsPicker({yearRange: 'any'});
	});
	
	$("#patientInformationForm").validate({
		rules: {
			firstname: {
				required: true,
				number: false
			},
			lastname: {
				required: true,
				number: false
			},
			billnumber: {
				required: true,
			},
			totalbill: {
				required: true,
				number: true
			}
		}
	});
	
	
	$("#submitPrescription").click(function() {
        if ($('#patientInformationForm').valid()) {
        	
        	var date;
        	var billingDate;
        	var birthDate;
        	
        	if($("#billingDate").val()){
        		date = new Date($("#billingDate").val());
        		billingDate = date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
        	}
        	
        	if($("#birthdate").val()){
        		date = new Date($("#birthdate").val());
        		birthDate = date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
        	}        	
            var reqData ={
            		firstName : $("#firstname").val() || "Steve1",
            		lastName : $("#lastname").val() || "Jobs",
                	gender : $("#sex").val() || "M",
                	dob : birthDate || "0987654321",
                	phoneNumber : $("#phoneNum").val() || "1234567890", 
                	diagnosis : $("#diseasename").val() || "Cholera",
                	icdCode : $("#icdcode").val() || "A00",
                	addressLine1 : $("#addressline1").val() || "addressLine1",
                	addressLine2 : $("#addressline2").val() || "addressLine2",
                	city : $("#addressline1").val() || "San Jose",
                	state : $("#state").val() || "CA",
                	zipCode : $("#zip").val() || "12345",
                	medicines : $("#medicines").val() || "many medicines",
                	dosage : $("#dosage").val() || "Twice a day",
                	billingDate : billingDate, 
                	billNumber : $("#billnumber").val() || "2",
                	billAmount : $("#totalbill").val() || "1500"
                };
                
                $.ajax({
                    type: "POST",
                    url: "/ICD10BrowserWS/rest/ptrservice/pres/",
                    headers: {"Accept": "text/html", "Content-Type" : "application/json"},
                    dataType: 'json',
                    data: JSON.stringify(reqData),
                    success: function(response, textStatus, xhr) {
                    	$("#ptrModalSuccess").modal({
                  		   show:true,
                  		   backdrop:'static'
                  		}); 
                        $('#patientInformationForm').trigger("reset");
                    },
                    error: function(xhr, textStatus, errorThrown) {
                    	$("#ptrModalError").modal({
                 		   show:true,
                 		   backdrop:'static'
                 		});
                    }
                }); 
        }
        return false;
    });
});

