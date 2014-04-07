$(function () {
	
	$( "#fromdate" ).calendarsPicker({yearRange: 'any'});
	
	$( "#todate" ).calendarsPicker({yearRange: 'any'});
	
    $('#container2').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: 'Billing Fraud Summary'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    color: '#000000',
                    connectorColor: '#000000',
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %'
                }
            }
        },
        series: [{
            type: 'pie',
            name: 'Browser share',
            data: [
                ['Correct Billing',   35.5],
                {
                    name: 'Billing Fraud',
                    y: 54,
                    sliced: true,
                    selected: true
                },
                ['Bill not generated',    9.5]
            ]
        }]
    });
    
    $('#tabs').tab();
});