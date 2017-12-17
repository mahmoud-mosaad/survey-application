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


}
;


