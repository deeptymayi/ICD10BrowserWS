$(function() {

	$.validator.setDefaults({
		debug : true,
		success : "valid"
	});

	jQuery.validator.addMethod( "textonly", function(value, element) {
			valid = false;
			check = /[^-\.a-zA-Z\s\u00C0-\u00D6\u00D8-\u00F6\u00F8-\u02AE]/
					.test(value);
			if (check == false)
				valid = true;
			return this.optional(element) || valid;
		},jQuery.format("Please only enter letters.")
	);

	$("#signUpForm").validate({
		rules : {
			firstname : {
				required : true,
				textonly : true
			},
			lastname : {
				required : true,
				textonly : true
			},
			username : {
				required : true,
				minlength : 3,
				maxlength : 8
			},
			password : {
				required : true,
				minlength : 5,
				maxlength : 8
			},
			confirmPassword : {
				equalTo: "#password"
			}
		},
		//perform an AJAX on success
		submitHandler : function() {

			var reqData = {
				firstname : $("#firstname").val(),
				lastname : $("#lastname").val(),
				username : $("#username").val(),
				password : $("#password").val(),
			};

			$.ajax({
				type : "POST",
				url : "/ICD10BrowserWS/rest/signUp",
				headers: {"Accept": "application/json", "Content-Type" : "application/json"},
				dataType : 'json',
				data : reqData,
				success : function(response, textStatus, xhr) {
					$("#signUpSuccess").modal({
						show : true,
						backdrop : 'static'
					});
				},
				error : function(xhr, textStatus, errorThrown) {
					$("#signUpError").modal({
						show : true,
						backdrop : 'static'
					});
				}
			});
			return false;
		}
	});

	$("#loginForm").validate({

		submitHandler : function() {

			var reqData = {
				username : $("#loginusername").val(),
				password : $("#loginpassword").val()
			};

			$.ajax({
				type : "POST",
				url : "/ICD10BrowserWS/rest/login",
				headers: {"Accept": "application/json", "Content-Type" : "application/json"},
				dataType : 'json',
				data : reqData,
				success : function(response, textStatus, xhr) {
					alert("success");
				},
				error : function(xhr, textStatus, errorThrown) {
					$("#loginError").modal({
						show : true,
						backdrop : 'static'
					});
				}
			});
			return false;
		}
	});

});
