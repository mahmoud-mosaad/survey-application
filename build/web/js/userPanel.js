$('.collapse').collapse();

function suspend($id) {

    var surveyID = $('#suspend-survey-button-' + $id).data('surveyid');
    console.log(surveyID);
    var request = new XMLHttpRequest();

    request.open("POST", "SurveyController?suspend=" + surveyID, true);
    request.send();
    request.onreadystatechange = function ()
    {
        if (request.status === 200 && request.readyState === 4)
        {
            if (request.responseText == "ok") {
                console.log("suspended success");
                disableAllInputs($id);
            } else
            {
                console.log("suspended not success");
            }
        }
    };


};

function charts($id,$males,$females,$anonymous){
  
            // Load the Visualization API and the corechart package.
            google.charts.load('current', {'packages':['corechart']});

            // Set a callback to run when the Google Visualization API is loaded.
            google.charts.setOnLoadCallback(drawChart);

            // Callback that creates and populates a data table,
            // instantiates the pie chart, passes in the data and
            // draws it.
            function drawChart() {

              // Create the data table.
              var data = new google.visualization.DataTable();
              data.addColumn('string', 'Topping');
              data.addColumn('number', 'Slices');
              data.addRows([
                ['Males', $males],
                ['Females', $females],
                ['Anonymous', $anonymous],
              ]);

              // Set chart options
              var options = {'title':'Percentage of males and females for this survey',
                             'width':400,
                             'height':300};

              // Instantiate and draw our chart, passing in some options.
              var chart = new google.visualization.PieChart(document.getElementById('chart_div_'+$id));
              chart.draw(data, options);
              
            }
};

