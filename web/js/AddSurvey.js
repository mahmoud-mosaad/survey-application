//$('document').ready(function(){
var freeAnswerCounter = 0;
var mcqCount = 0;
var checkBoxes = 0;
var mcqAnswerCount = 0;
var checkBoxesAnswer = 0;

function addFreeAnswer(count) {
    var freeAnswer = '<div class="row margin-button-20 free-answer-textarea' + count + '">' +
            '<div class="col-lg-10">' +
            '<div class="input-group">' +
            '<input type="text" class="form-control freeAnswer" name="free-answer-question-' + count + '" aria-label="Text input with dropdown button" id="free-answer-question' + count + '"' + ' placeholder="Write Your Question">' +
            '<div class="input-group-btn">' +
            '<button type="button" class="btn btn-danger cursor-pointer" aria-haspopup="true" onclick="deleteMyParents(this.id)" id="free-answer-delete-button' + count + '"' + ' aria-expanded="false" style="box-shadow: none">' +
            'Delete' +
            '</button>' +
            '</div>' +
            '</div>' +
            '<textarea class="form-control free-answer-textarea" rows="2" id="comment" disabled="true" placeholder="Your Answer"></textarea>' +
            '</div>' +
            '</div>';
    return freeAnswer;
}

function mcqHTMLBody(mcqCounter)
{
    var mcq = '<div class="row margin-button-20 mcq-parent mcq-parent-number-' + mcqCounter + '">' +
            '<div class="col-lg-10 margin-7 mcq-subparent-number-' + mcqCounter + '">' +
            '<div class="input-group">' +
            '<input type="text" name="mcq-question-' + mcqCounter + '" placeholder="Write your Question Here" class="form-control mcq"  aria-label="Text input with dropdown button">' +
            '<div class="input-group-btn">' +
            '<button type="button" class="btn btn-secondary dropdown-toggle cursor-pointer" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="box-shadow:none;">' +
            'Setting' +
            '</button>' +
            '<div class="dropdown-menu">' +
            '<span class="dropdown-item cursor-pointer" id="mcq-number-' + mcqCounter + '"' + 'onclick="addMCQAnswer(this.id)">Add Answer</span>' +
            '<div role="separator" class="dropdown-divider"></div>' +
            '<span class="dropdown-item cursor-pointer" id="mcq-number-' + mcqCounter + '"' + ' onclick="deleteMCQQuestion(this.id)">DELETE</span>' +
            '</div>' +
            '</div>' +
            '</div>' +
            '</div>' +
            '</div>';
    return mcq;
}

function addRadioButton(id)
{
    var subAnswerID = $('.mcq-parent-number-' + id + ' input[type="text"]').length;
    var answer = '<div class="col-lg-10 margin-3 mcq-answer-number-' + id + '">' +
            '<div class="input-group" name="mcq-parent-'+id+'">' +
            '<span class="input-group-addon radiobutton-background">' +
            '<input type="radio" id="mcq-answer-group-number-' + id + '" name="mcq-answer-group-number-' + id + '"  aria-label="Radio button for following text input">' +
            '</span>' +
            '<input type="text" name="mcq-number-' + id + '-' + subAnswerID + '" placeholder="Write Answer Here" class="form-control" aria-label="Text input with radio button">' +
            '<span class="input-group-btn">' +
            '<button class="btn btn-secondary" type="button" id="mcq-delete-answer-btn-'+id+'" onclick="deleteMCQAnswer('+id+')">delete</button>' +
            '</span>' +
            '</div>' +
            '</div>';
    return answer;

}

function deleteMCQAnswer($id)
{
    console.log("hhhhhhhhhhhhhhhhhhhhhhh");
    $(".mcq-answer-number-"+$id).remove();
}

function checkBoxHTMLBody(checkboxCounter)
{
    var mcq = '<div class="row margin-button-20 checkbox-parent check-box-question checkbox-parent-number-' + checkboxCounter + '">' +
            '<div class="col-lg-10 margin-7 checkbox-subparent-number-' + checkboxCounter + '">' +
            '<div class="input-group">' +
            '<input type="text" name="checkbox-question-' + checkboxCounter + '" placeholder="Write your Question Here" class="form-control checkbox"  aria-label="Text input with dropdown button">' +
            '<div class="input-group-btn">' +
            '<button type="button" class="btn btn-primary dropdown-toggle cursor-pointer" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="box-shadow:none;">' +
            'Setting' +
            '</button>' +
            '<div class="dropdown-menu">' +
            '<span class="dropdown-item cursor-pointer" id="checkbox-number-' + checkboxCounter + '"' + 'onclick="addCheckBoxAnswer(this.id)">Add Answer</span>' +
            '<div role="separator" class="dropdown-divider"></div>' +
            '<span class="dropdown-item cursor-pointer" id="checkbox-number-' + checkboxCounter + '"' + ' onclick="deleteCheckBoxQuestion(this.id)">DELETE</span>' +
            '</div>' +
            '</div>' +
            '</div>' +
            '</div>' +
            '</div>';
    return mcq;
}

function addCheckBox(id)
{
    var subAnswerID = $('.checkbox-parent-number-' + id + ' input[type="text"]').length;
    var answer = '<div class="col-lg-10 check-box-answer margin-3 checkbox-answer-number-' + id + '">' +
            '<div class="input-group" name="checkbox-parent-'+id+'">' +
            '<span class="input-group-addon checkbox-background">' +
            '<input type="checkbox" id="checkbox-answer-group-number-' + id + '" name="checkbox-answer-group-number-' + id + '"  aria-label="Checkbox  button for following text input">' +
            '</span>' +
            '<input type="text" name="checkbox-answer-' + id + '-' + subAnswerID + '" placeholder="Write Answer Here" class="form-control" aria-label="Text input with radio button">' +
            '<span class="input-group-btn">' +
            '<button class="btn btn-primary" type="button" id="mcq-answer" onclick="deleteCheckBoxAnswer('+id+')">delete</button>' +
            '</span>' +
            '</div>' +
            '</div>';
    return answer;
}

function deleteCheckBoxAnswer($id)
{
    $(".checkbox-answer-number-"+$id).remove();
}

$('#free-question').on('click', function ()
{
    freeAnswerCounter++;
    $('.right-side').append(addFreeAnswer(freeAnswerCounter));
});

function deleteMyParents(id)
{
    var parentClass = '.free-answer-textarea' + id[id.length - 1];
    $(parentClass).remove();
}

$('#mcq-question').on('click', function () {
    mcqCount++;
    $('.left-side').append(mcqHTMLBody(mcqCount));
});

$('#checkbox-question').on('click', function () {
    checkBoxes++;
    $('.left-side').append(checkBoxHTMLBody(checkBoxes));
});

function addMCQAnswer(id)
{
    var parentClass = '.mcq-parent-number-' + id[id.length - 1];
    $(parentClass).append(addRadioButton(id[id.length - 1]));
}

function deleteMCQQuestion(id)
{
    var parentClass = '.mcq-parent-number-' + id[id.length - 1];
    $(parentClass).remove();
}



function addCheckBoxAnswer(id)
{
    var parentClass = '.checkbox-parent-number-' + id[id.length - 1];
    $(parentClass).append(addCheckBox(id[id.length - 1]));
}

function deleteCheckBoxQuestion(id)
{
    var parentClass = '.checkbox-parent-number-' + id[id.length - 1];
    $(parentClass).remove();
}

$('#Surevy_Form').on('submit', function (e) {
//    e.preventDefault();

    var mcq   = String($('.mcq').length);
    var freeanswer  = String($('.freeAnswer').length);
    var checkbox = String($('.checkbox').length);

    if($("input[type='text']").length < 5 ){e.preventDefault();}
    if($(".mcq").length > 0  ){
    if($("input[type='radio']").length < $(".mcq").length*2 ){e.preventDefault();}
    }
    
    if($(".checkbox").length > 0  ){
    if($("input[type='checkbox']").length < $(".checkbox").length*2 ){e.preventDefault();}
    }
    
    
    for(i=1 ; i<= $('.mcq').length ; i++)
    {
        mcq = mcq + "-" + String($('div[name="mcq-parent-'+i+'"]').length);
    }
    
    for(i=1 ; i<= $('.mcq').length ; i++)
    {
        mcq = mcq + "-" + String($('div[name="mcq-parent-'+i+'"]').length);
    }
    
    for(i=1 ; i<= $('.checkbox').length ; i++)
    {
        checkbox = checkbox + "-" + String($('div[name="checkbox-parent-'+i+'"]').length);
    }
    
    $('.mcqHidden').attr('value',mcq);
    $('.checkBoxHidden').attr('value',checkbox);
    $('.freeAnswerHidden').attr('value',freeanswer);


});

//$('#survey-cancel-button').on('click', function () {
//    window.location = "HomePage.jsp";
//});



//});