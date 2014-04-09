$(function () {
	
	var searchICD10Handler= function() {
		var search = $("#searchInput").val();
		$.ajax({
			type: "GET",
			url: "/ICD10BrowserWS/rest/icdservice/fetchByTag/" + search,
			headers: {"Accept": "application/json", "Content-Type" : "application/json"},
			dataType: 'json',
			success: function(data) {
				var aaData = data.diseases;
				//alert("success");
				$('#searchIcdResult').dataTable({
					"aaData": aaData,
					"aoColumns": [
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
	};
	$( "#search" ).click(searchICD10Handler);
	$("#searchInput").keyup(function(event){
	    if(event.keyCode == 13){
	    	searchICD10Handler();
	    }
	});

});
