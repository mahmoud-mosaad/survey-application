$(document).ready(function () {

    function validateEmail(email)
    {
        var regex = /[+-,?!#$%^&*()=/\\]/i;
        return regex.test(email);
    }
    

    function validation(inputTagId, isValid, errorMsg, errorTagId)
    {
        if (isValid === false)
        {
            $(errorTagId).text(errorMsg);
            $(errorTagId).css('display', 'block');

            if ($(inputTagId).hasClass('is-valid')) {
                $(inputTagId).removeClass('is-valid');
            }
            if (!($(inputTagId).hasClass('is-invalid'))) {
                $(inputTagId).addClass('is-invalid');
            }

        } else
        {
            $(errorTagId).text(errorMsg);
            $(errorTagId).css('display', 'none');

            if ($(inputTagId).hasClass('is-invalid')) {
                $(inputTagId).removeClass('is-invalid');
            }
            if (!($(inputTagId).hasClass('is-valid'))) {
                $(inputTagId).addClass('is-valid');
            }

        }
    }


    $('#userEmail').on('change', function () {
        var userEmail = $('#userEmail').val();

        if (userEmail.length < 30 && userEmail.length !== 0 && !validateEmail(userEmail))
        {
            validation('#userEmail', true, "ok", '#emailAuth');
        } else
        {
            validation('#userEmail', false, " Client Side Email error", '#emailAuth');
        }
    });

    $('#userPassword').on("change", function ()
    {
        var userPassword = $('#userPassword').val();
        if (userPassword.length === 0 || userPassword.length > 25)
        {
            validation('#userPassword', false, "client side error Msg ", '#passwordAuth');
        } else
        {
            uPassword = true;
            validation('#userPassword', true, "ok", '#passwordAuth');
            

        }
        
        
    });

    $('.Sign_In_Form').on('submit', function (e) {
        $('.Sign_In_Form').find('input').each(function () {
            if ($(this).hasClass("is-invalid")) {
                e.preventDefault();
            }else{
            }
        });
    });

$('#suspended-user-button').on('click',function (){
   var email = $('#user-suspend-response-email').val();
   var msg = $('#user-suspend-response-body').val();
   
        var request = new XMLHttpRequest();
        request.open("GET", "AdminController?userResponseMsg=" + msg +"&userREmail="+email, true);
        request.send();
        
        request.onreadystatechange = function ()
        {
            if (request.status === 200 && request.readyState === 4)
            {
                if(request.responseText === "ok"){
                    $('#user-suspend-response-email').val("");
                    $('#user-suspend-response-body').val("");
                    location.reload("SignIn.jsp");
                }
            }
        };
   
});




});