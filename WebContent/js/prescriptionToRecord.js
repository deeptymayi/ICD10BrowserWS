$(function () {

	$.validator.setDefaults({
		debug: true,
		success: "valid"
	});
	
	$(function() {
	    $( "#birthdate" ).datepicker();
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
            var reqData ={
                	firstname : $("#firstname").val() || "",
                	lastname : $("#lastname").val() || "",
                	email : $("#email").val() || "",
                	sex : $("#sex").val() || "",
                	birthdate : $("#birthdate").val() || "",
                	diseasename : $("#diseasename").val() || "",
                	icdcode : $("#icdcode").val() || "",
                	medicines : $("#medicines").val() || "",
                	dosage : $("#dosage").val() || "",
                	billnumber : $("#billnumber").val() || "",
                	totalbill : $("#totalbill").val() || "",
                	addressline1 : $("#addressline1").val() || "",
                	addressline2 : $("#addressline2").val() || "",
                	city : $("#city").val() || "",
                	state : $("#state").val() || "",
                	zip : $("#zip").val() || ""
                };
                
                $.ajax({
                    type: "POST",
                    url: "/ICD10BrowserWS/rest/prescriptionToRecord",
                    dataType: 'json',
                    data: reqData,
                    success: function(response, textStatus, xhr) {
                    	$("#ptrModalSuccess").modal({
                  		   show:true,
                  		   backdrop:'static'
                  		});                       
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

