//$('document').ready(function(){

function disableAllInputs($id)
{
    $("#survey-form-" + $id + " :radio").attr('disabled', 'true');
    $("#survey-form-" + $id + " :checkbox").attr('disabled', 'true');
    $("#survey-form-" + $id + " textarea").attr('disabled', 'true');
    $('#submit-survey-button-' + $id).attr('disabled', 'true');
}
;

function removeSurvey($id) {
    $('#survey-body-' + $id).remove();
    $('#survey-model-' + $id).remove();
}
;

$('.add-survey').on('click', function () {
    window.location = "AddSurvey.jsp";
});

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

function remove($id) {
    var surveyID = $('#remove-survey-button-' + $id).data('surveyid');
    console.log(surveyID);
    var request = new XMLHttpRequest();

    request.open("POST", "SurveyController?remove=" + surveyID, true);
    request.send();
    request.onreadystatechange = function ()
    {
        if (request.status === 200 && request.readyState === 4)
        {
            if (request.responseText == "ok") {
                console.log("remove success");
                $('#survey-model-' + $id).modal('hide');
                $('.modal-backdrop').remove();
                removeSurvey($id);
            } else
            {
                console.log("remove not success");
            }
        }
    };


}
;
 
function spam($id)
{
    var userID = $('#spam-survey-button-' + $id).data('userid');
    var surveyID = $('#spam-survey-button-' + $id).data('surveyid');

    var request = new XMLHttpRequest();
    request.open("POST", "SurveyController?spam=" + surveyID + "-" + userID, true);
    request.send();
    request.onreadystatechange = function ()
    {
        if (request.status === 200 && request.readyState === 4)
        {
            if (request.responseText == "ok") {
                console.log("spam success");
                $('#spam-survey-button-' + $id).attr('disabled','disabled');
            } else
            {
                console.log("spam not success");
            }
        }
    };
}

//function submit($id)
//{
//    
//    var mcq   = String($('.mcq').length);
//    var freeanswer  = String($('.freeAnswer').length);
//    var checkbox = String($('.checkbox').length);
//    $('.mcqHidden').attr('name','mcq'+$id);
//    $('.mcqHidden').attr('value',mcq);
//    $('.checkBoxHidden').attr('value',checkbox);
//    $('#freeanswer-answer-value-5-0').attr('value','10');
//    
//}

function submitAnswer($id)
{
    var mcq = String($('.mcq-' + $id).length);
    var freeanswer = String($('.freeAnswer-' + $id).length);
    var checkbox = String($('.checkbox-' + $id).length);
    
//    var mcq_questionID = $('.mcq-' + $id).data('questionid');
    for (j = 0; j < $('.mcq-' + $id).length; j++) {
        var mcq_questionID = $('.mcq-parent-question-' + $id+'-'+j).data('questionid');
        var v = $('input[name=mcq-answer-' + $id + '-' + j + ']:checked', '.mcq-' + $id).val();
        v = mcq_questionID + "~" + v;
        $('#mcq-answer-value-' + $id + '-' + j).attr('value', v);
    }
    
    
    for(j=0 ; j<$('.checkbox-' + $id).length ; j++)
    {
        var checkbox_questionID = $('.checkbox-parent-question-' + $id+'-'+j).data('questionid');
        var v = $('.checkbox-answer-'+$id+'-'+j).length;
        var cc = "";
        for(o=0 ; o<v  ; o++)
        {
            var checked = $('#checkbox-answer-'+$id+'-'+j+'-'+o +':checked').val();
            cc = cc+checked;
            if(o!=v-1){cc+='~';}
            
        }
        cc = checkbox_questionID + "~" + cc;
        $('#checkbox-answer-value-'+$id+'-'+j).attr('value',cc);
    }
    
    for (j = 0; j < $('.freeAnswer-' + $id).length; j++) {
        var free_questionID = $('.freeanswer-parent-question-' + $id+'-'+j).data('questionid');
        var v = $('#freeanswer-answer-value0-'+$id+'-'+j).val();
        v = free_questionID + "~" + v;
        console.log("----------"+v);
        $('#freeanswer-answer-value-' + $id + '-' + j).attr('value', v);
    }
    
    
    $('.mcqHidden-' + $id).attr('value', mcq);
    $('.checkBoxHidden-' + $id).attr('value', checkbox);
    $('.freeAnswerHidden-' + $id).attr('value', freeanswer);
}


//});

//setTimeout(function(){
//   window.location.reload(1);
//}, 5000);


