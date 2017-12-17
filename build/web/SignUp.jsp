<%@page import="Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    session = request.getSession(false);
    if (session.getAttribute("currentUser") != null) {
        response.sendRedirect("HomePage.jsp");
    } else {
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="css\bootstrap.min.css"/>
        <link rel="stylesheet" href="css\signUp.css"/>
        <title>Sign-UP</title>
    </head>
    
    <body class="Sign_Up">
        <div class="test"></div>
        <form action="SignUp" method="POST" class="Sign_Up_Form">
            <div class="form-group">
                <input type="text" class="form-control" name="userName" id="userName" placeholder="Enter your Name" required="true">
                <div id="nameAuth" class="form-text invalid-feedback error"></div>  
            </div>

            <div class="form-group">
                <input type="email" class="form-control" name="userEmail" id="userEmail" aria-describedby="emailHelp" placeholder="Enter your E-mail" required="true">
                <small id="emailAuth" class="form-text invalid-feedback error"></small>
            </div>

            <div class="form-group">
                <input type="password" class="form-control" name="userPassword" id="userPassword" placeholder="Enter your Password" required="true">
                <small id="passwordAuth" class="form-text invalid-feedback error"></small>
            </div>

            <div class="form-group">
                <input type="number" class="form-control" name="userAge" id="userAge" placeholder="Enter your Age" required="true" min="16" max="100">
                <small id="ageAuth" class="form-text invalid-feedback error"></small>
            </div>

            <div>

                <label>Gender</label>

                <label class="custom-control custom-radio block">

                    <input id="gender" name="Gender" type="radio" class="custom-control-input" value="male">
                    <span class="custom-control-indicator"></span>
                    <span class="custom-control-description">Male</span>

                </label>

                <label class="custom-control custom-radio block">

                    <input id="gender" name="Gender" type="radio" class="custom-control-input" value="female">
                    <span class="custom-control-indicator"></span>
                    <span class="custom-control-description">Female</span>

                </label>
                <input type="text" name="gender" id="userGender" hidden>
                <small id="genderAuth" class="form-text invalid-feedback error"></small>
            </div>

            <input id="sign_up_button" type="submit" class="btn btn-primary Sign_Up_Button" value="SIGN UP"/>
            <button id="sign_in_button" onclick="window.location.href = 'SignIn.jsp'" type="button" class="btn btn-danger Sign_In_Button">SIGN IN</button>
            <div class="clear"></div>
        </form>

        <script type="text/javascript" src="js\jQuery.js"></script>
        <script type="text/javascript" src="js\signUp.js"></script>

    </body>

</html>
<%}%>