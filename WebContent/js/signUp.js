$(function () {

	$.validator.setDefaults({
		debug: true,
		success: "valid"
	});
	
	$("#signUpForm").validate({
		rules: {
			firstname: {
				required: true,
				number: false
			},
			lastname: {
				required: true,
				number: false
			},
			username: {
				required: true,
				minlength: 3,
				maxlength: 8
			},
			password: {
				required: true,
				minlength: 5,
				maxlength: 8
			}
		},
        //perform an AJAX on success
        submitHandler: function() {        	
        	 
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
            return false;
        }
	});
		
	$("#loginForm").validate({
		
        submitHandler: function() {        	
        	 
            var reqData ={
            	username : $("#loginusername").val(),
            	password : $("#loginpassword").val()
            };
            
            $.ajax({
                type: "POST",
                url: "/ICD10BrowserWS/rest/login",
                dataType: 'json',
                data: reqData,
                success: function(response, textStatus, xhr) {
                    alert("success");
                },
                error: function(xhr, textStatus, errorThrown) {
                    alert("error");
                }
            });
            return false;
        }
	});
	
});
