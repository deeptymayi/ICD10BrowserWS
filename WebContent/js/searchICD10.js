$(function () {
	
	$( "#search" ).click(function() {
		var search = $("#searchInput").val();
		$.ajax({
			type: "GET",
			url: "/ICD10BrowserWS/rest/icdservice/fetchByTag/" + search,
			dataType: 'json',
			success: function(data) {
				var aaData = data.diseases;
				//alert("success");
				$('#searchIcdResult').dataTable({
					"aaData": aaData,
					"aoColumns": [
		              //{ "icdCode": "Engine" },
		              //{ "description": "Browser" }
		              {"mData": "icdCode", sDefaultContent: "",  "sTitle": "ICD 10 Code", "sWidth": "25%" },
		              {"mData": "description", sDefaultContent: "", "sTitle" : "Description", "sWidth": "75%" } 
		            ],
		            "bDestroy": true
				});
			},
			error: function(xhr, textStatus, errorThrown) {
				alert("error");
			}
		});
		
	});	

});
