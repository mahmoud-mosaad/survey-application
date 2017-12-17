<%@page import="Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="css\bootstrap.min.css"/>
        <link rel="stylesheet" href="css\signIn.css"/>
        <title>Sign In</title>
    </head>
    <body>

        <%
            session = request.getSession(false);
            if (session.getAttribute("currentUser") != null) {
                response.sendRedirect("HomePage.jsp");
            } else {
              String display = "hidden";
              String msg=" ";
            if(request.getParameter("suspended")!=null){
                      display = "show";
                      msg = request.getParameter("suspended");
            }
        %>


        <div class="Sign_In_Form-all">
            <div class="alert alert-danger <%= display%>" role="alert" id="">
                <%= msg%>

                
                    <input type="text" class="form-control" id="user-suspend-response-email" data-userid="" placeholder="Write ur email" name="user-suspended-response-email">
                    <div class="input-group" style="margin-top: 5px">
                    <input type="text" class="form-control"  id="user-suspend-response-body" data-userid="" placeholder="Write somthing back to Admin" name="user-suspended-response-body">
                    <span class="input-group-btn float-right ">
                        <button class="btn btn-secondary" id="suspended-user-button" type="button" style="cursor: pointer; box-shadow: none">Send</button>
                    </span>
                    <div class="clear"></div>
                </div>

            </div>

            <form action="SignIn" method="POST" class="Sign_In_Form">
                <div class="form-group">
                    <input type="email" name="userEmail" class="form-control userEmail" id="userEmail" aria-describedby="emailHelp" placeholder="Enter your E-mail" required="true">
                    <small id="emailAuth" class="form-text invalid-feedback error"></small>
                </div>

                <div class="form-group">
                    <input type="password" name="userPassword" class="form-control userPassword" id="userPassword" placeholder="Enter your Password" required="true">
                    <small id="passwordAuth" class="form-text invalid-feedback error"></small>
                </div>

                <small id="generalAuth" class="form-text invalid-feedback error">email or password are worng</small>
                <input id="sign_in_button" type="submit" class="btn btn-primary Sign_In_Button" value="SIGN IN"/>
                <button id="sign_up_button" onclick="window.location.href = 'SignUp.jsp'" type="button" class="btn btn-danger Sign_Up_Button">SIGN UP</button>
                <div class="clear"></div>

            </form>
        </div>

        <%}%>
        <script type="text/javascript" src="js\jQuery.js"></script>
        <script type="text/javascript" src="js\signIn.js"></script>
    </body>
</html>
