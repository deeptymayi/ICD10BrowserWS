$(function () {

	$.validator.setDefaults({
		debug: true,
		success: "valid"
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
                headers: {"Accept": "application/json", "Content-Type" : "application/json"},
                dataType: 'json',
                data: reqData,
                success: function(response, textStatus, xhr) {
                    alert("success");
                },
                error: function(xhr, textStatus, errorThrown) {
                	$("#loginError").modal({
             		   show:true,
             		   backdrop:'static'
             		}); 
                }
            });
            return false;
        }
	});
	
});
