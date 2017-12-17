$('document').ready(function () {
    var pass1 = true;
    var pass2 = true;
    
    $('#sign_up_button').hide();
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


    $('#userCurrentPassword').on("blur", function ()
    {
        var userPassword = $('#userCurrentPassword').val();
        if (userPassword.length === 0 || userPassword.length > 25)
        {
            validation('#userCurrentPassword', false, "client side error Msg ", '#currentPasswordAuth');
            pass1 = true;
        } else
        {
            validation('#userCurrentPassword', true, "ok", '#currentPasswordAuth');
            pass1 = false;
        }
    });
    
    $('#userNewPassword').on("blur", function ()
    {
        var userPassword = $('#userNewPassword').val();
        if (userPassword.length === 0 || userPassword.length > 25)
        {
            validation('#userNewPassword', false, "client side error Msg ", '#newPasswordAuth');
            $('#sign_up_button').hide();
            pass2 = true;
        } else
        {
            validation('#userNewPassword', true, "ok", '#newPasswordAuth');
            $('#sign_up_button').show();
            pass2 = false;
        }
});      

$('.Sign_Up_Form').on('submit',function (e) {
//        e.preventDefault();
       if(pass1 || pass2 )
       {
        e.preventDefault();   
       }

    });
    

});