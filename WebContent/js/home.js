$(function () {

	$.validator.setDefaults({
		debug: true,
		success: "valid"
	});
		
	$("#loginForm").validate({
		
        submitHandler: function() {        	
        	 
            var reqData ={
            	userName : $("#loginusername").val(),
            	password : $("#loginpassword").val()
            };
            
            $.ajax({
                type: "POST",
                url: "/ICD10BrowserWS/rest/accountservice/login/",
                headers: {"Accept": "text/html", "Content-Type" : "application/json"},
                dataType: 'json',
                data: JSON.stringify(reqData),
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
