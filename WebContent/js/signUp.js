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
				firstName : $("#firstname").val(),
				lastName : $("#lastname").val(),
				userName : $("#username").val(),
				password : $("#password").val(),
			};

			$.ajax({
				type : "POST",
				url : "/ICD10BrowserWS/rest/accountservice/signup",
				headers: {"Accept": "text/html", "Content-Type" : "application/json"},
				dataType : 'json',
				data : JSON.stringify(reqData),
				success : function(response, textStatus, xhr) {
					$("#signUpSuccess").modal({
						show : true,
						backdrop : 'static'
					});
					setTimeout(function () {
                        window.location.href = "/ICD10BrowserWS/home.jsp";
                     }, 3000);
				},
				error : function(xhr, textStatus, errorThrown) {
					
					if( JSON.parse(xhr.responseText).message == "User already exists"){
						$("#userExistsError").modal({
							show : true,
							backdrop : 'static'
						});
					}else{
						$("#signUpError").modal({
							show : true,
							backdrop : 'static'
						});
					}
				}
			});
			return false;
		}
	});

	$("#loginForm").validate({

		submitHandler : function() {

			var reqData = {
				userName : $("#loginusername").val(),
				password : $("#loginpassword").val()
			};

			$.ajax({
				type : "POST",
				url : "/ICD10BrowserWS/rest/accountservice/login/",
				headers: {"Accept": "text/html", "Content-Type" : "application/json"},
				dataType : 'json',
				data : JSON.stringify(reqData),
				success : function(response, textStatus, xhr) {
					$("#loginSuccess").modal({
              		   show:true,
              		   backdrop:'static'
              		}); 
                    setTimeout(function () {
                        window.location.href = "/ICD10BrowserWS/searchICD10.jsp";
                     }, 2000);
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
