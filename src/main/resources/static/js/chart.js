    $(function(){
    Highcharts.chart('at&t-container', {
    chart: {
        type: 'column'
    },
    title: {
        text: 'LTE RSRP Counts(AT&T)'
    },
    xAxis: {
        categories: [
            '<:-105',
            '-105:-100',
            '-100:-95',
            '-95:-90',
            '-85:-80',
            '-80:-75',
            '-75:-70',
            '-70:-65',
            '-65:-60',
            '-60:-55',
            '-55:-50',
            '-50>'
        ]
    },
    yAxis: {
        min: 0,
        title: {
            text: 'Count'
        }
    },
    tooltip: {
        headerFormat: '<span style="font-size:50px">{point.key}</span><table>',
        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
            '<td style="padding:0"><b>{point.y:.1f} mm</b></td></tr>',
        footerFormat: '</table>',
        shared: true,        useHTML: true
    },
    plotOptions: {
        column: {
            pointPadding: 0.2,
            borderWidth: 0,
             zones: [{
                value: 10, // Values up to 10 (not including) ...
                color: 'blue' // ... have the color blue.
                },{
                    color: 'red' // Values from 10 (including) and up have the color red
                }
             ]
        }
    },
    series: [{
        data: [[${surveyMap}]]
    }]
});
    });

    $(function(){
    Highcharts.chart('t-mobile-container', {
    chart: {
        type: 'column'
    },
    title: {
        text: 'LTE RSRP Counts(T-Mobile)'
    },
    xAxis: {
        categories: [
            '<:-105',
            '-105:-100',
            '-100:-95',
            '-95:-90',
            '-85:-80',
            '-80:-75',
            '-75:-70',
            '-70:-65',
            '-65:-60',
            '-60:-55',
            '-55:-50',
            '-50>'
        ]
    },
    yAxis: {
        min: 0,
        title: {
            text: 'Count'
        }
    },
    tooltip: {
        headerFormat: '<span style="font-size:50px">{point.key}</span><table>',
        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
            '<td style="padding:0"><b>{point.y:.1f} mm</b></td></tr>',
        footerFormat: '</table>',
        shared: true,        useHTML: true
    },
    plotOptions: {
        column: {
            pointPadding: 0.2,
            borderWidth: 0
        }
    },
    series: [{
            name: 'Tokyo',
            data: [[${surveyMap}]]
        }]
    });
});

    $(function(){
    Highcharts.chart('verizon-container', {
    chart: {
        type: 'column'
    },
    title: {
        text: 'LTE RSRP Counts(AT&T)'
    },
    xAxis: {
        categories: [
            '<:-105',
            '-105:-100',
            '-100:-95',
            '-95:-90',
            '-85:-80',
            '-80:-75',
            '-75:-70',
            '-70:-65',
            '-65:-60',
            '-60:-55',
            '-55:-50',
            '-50>'
        ],
        crosshair: true
    },
    yAxis: {
        min: 0,
        title: {
            text: 'Count'
        }
    },
    tooltip: {
        headerFormat: '<span style="font-size:50px">{point.key}</span><table>',
        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
            '<td style="padding:0"><b>{point.y:.1f} mm</b></td></tr>',
        footerFormat: '</table>',
        shared: true,        useHTML: true
    },
    plotOptions: {
        column: {
            pointPadding: 0.2,
            borderWidth: 0
        }
    },
    series: [{
            name: 'Tokyo',
            data: [[${surveyMap}]]
        }]
    });
});
