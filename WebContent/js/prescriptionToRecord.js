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
                	firstname : $("#firstname").val(),
                	lastname : $("#lastname").val(),
                	username : $("#username").val(),
                	password : $("#password").val(),
                };
                
                $.ajax({
                    type: "POST",
                    url: "/ICD10BrowserWS/rest/signUp",
                    dataType: 'json',
                    data: reqData,
                    success: function(response, textStatus, xhr) {
                        alert("success");
                    },
                    error: function(xhr, textStatus, errorThrown) {
                        alert("error");
                    }
                });  
        }
        return false;
    });
});

