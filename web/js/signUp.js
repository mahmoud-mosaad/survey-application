$(document).ready(function () {
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

    function validateEmail(email)
    {
        var regex = /[+-,?!#$%^&*()=/\\]/i;
        return regex.test(email);
    }

    $("#userName").on("blur", function ()
    {
        var clientSideValidation = false;
        var userName = $('#userName').val();
        var request = new XMLHttpRequest();
        request.open("GET", "UserValidation?userName=" + userName, true);
        request.send();

        if (userName.length < 16 && userName.length !== 0)
        {
            clientSideValidation = true;
            
        } else
        {
            clientSideValidation = false;
            validation('#userName', false, "client server error Msg", '#nameAuth');
        }

        if (clientSideValidation) {
            request.onreadystatechange = function ()
            {
                if (request.status === 200 && request.readyState === 4)
                {

                    validation('#userName', request.responseText === "ok", request.responseText, '#nameAuth');
                }
            };
        }

    });

    $("#userEmail").on("blur", function ()
    {
        var clientSideValidation = false;
        var userEmail = $('#userEmail').val();
        var request = new XMLHttpRequest();
        request.open("GET", "UserValidation?userEmail=" + userEmail, true);
        request.send();

        if (userEmail.length < 30 && userEmail.length !== 0 && !validateEmail(userEmail))
        {
            clientSideValidation = true;
            
        } else
        {
            clientSideValidation = false;
            validation('#userEmail', false, " Client Side Email error", '#emailAuth');
        }

        if (clientSideValidation) {
            request.onreadystatechange = function ()
            {
                if (request.status === 200 && request.readyState === 4)
                {
                    validation('#userEmail', request.responseText === "ok", request.responseText, '#emailAuth');
                }
            };

        }

    });

    $('#userPassword').on("blur", function ()
    {
        var userPassword = $('#userPassword').val();
        if (userPassword.length === 0 || userPassword.length > 25)
        {
            validation('#userPassword', false, "client side error Msg ", '#passwordAuth');
        } else
        {
            validation('#userPassword', true, "ok", '#passwordAuth');
        }
    });

    $('.Sign_Up_Form').on('submit',function (e) {
//        e.preventDefault();
        if (!$('input[name=Gender]').is(':checked')) {
            $('#genderAuth').text('must choose gender type');
            $('#genderAuth').css('display', 'block');
            e.preventDefault();
        } else
        {
            $('#genderAuth').css('display', 'none');
            $('#userGender').attr('value',$('input[name=Gender]:checked').attr('value'));
        }
        $('.Sign_Up_Form').find(':input').each(function () {
            if ($(this).hasClass("is-invalid")) {
                e.preventDefault();
            }
        });

    });
});


