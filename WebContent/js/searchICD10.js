$(function () {
	
	$( "#search" ).click(function() {
		var search = $("#search").val();
		$.ajax({
			type: "GET",
			url: "/ICD10BrowserWS/rest/icdservice/fetchByTag/injury" + search,
			dataType: 'json',
			success: function(data) {
				var aaData = data.diseases;
				//alert("success");
				$('#searchIcdResult').dataTable({
					"aaData": aaData,
					"aoColumns": [
		              //{ "icdCode": "Engine" },
		              //{ "description": "Browser" }
		              {"mData": "icdCode", sDefaultContent: ""},
		              {"mData": "description", sDefaultContent: ""} 
		            ]
				});
			},
			error: function(xhr, textStatus, errorThrown) {
				alert("error");
			}
		});
		
		/*var oTable = $('#icdTable').dataTable({
		     bProcessing  : true,
		     sProcessing  : true,
		     bServerSide  : true,
		     sAjaxSource  : "/ICD10BrowserWS/rest/icdservice/fetchByTag/injury" + search,
		     "fnServerData": function ( sSource, aoData, fnCallback ) {
	            // Add some extra data to the sender 
	            aoData.push( { "name": "quizid", "value": quizid } );
	            aoData.push( { "name": "question_id", "value": question_id } );
	            $.getJSON( sSource, aoData, function () { 
	                 Do whatever additional processing you want on the callback, then tell DataTables 
	            	alert("Success");
	            }).done(function(json){
	                fnCallback(json);
	                        }).fail(function(xhr, err){ 
	                var responseTitle= $(xhr.responseText).filter('title').get(0);
	                alert($(responseTitle).text() + "\n" + formatErrorMessage(xhr, err) ); 
	            });
	        },      
		});*/
		
	});	

});
