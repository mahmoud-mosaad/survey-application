<%@page import="Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <%
            User currentUser = new User();
            session = request.getSession(false);
            if (session.getAttribute("currentUser") == null) {
                response.sendRedirect("SignIn.jsp");
            } else {
                currentUser = (User) session.getAttribute("currentUser");
                if(currentUser.isSuspended()==1){response.sendRedirect("HomePage.jsp");}else{


        %>
    
    <head>
        <title>ADD SUREVY</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="css\bootstrap.min.css"/>
        <link rel="stylesheet" href="css\AddSurevy.css"/>
    </head>
    <body>
        <form action="AddSurvey" method="POST" class="" id='Surevy_Form'>
            <div class="row">
                <div class="col-lg-2 Add_Surevy_Form1">
                    <div class="form-group">
                        <input type="text" class="form-control" name="surveyName" id="surveyName" placeholder="Enter Survey Name" required="true">
                        <div id="surveyNameAuth" class="form-text invalid-feedback error"></div>  
                    </div>
                    
                    <div class="form-group">
                        <textarea type="text" class="form-control" name="surveyDesc" id="surveyDesc" placeholder="Enter Survey Description" rows="5"></textarea>
                        <div id="surveyDescAuth" class="form-text invalid-feedback error"></div>  
                    </div>   
                </div>
                
                
                <div class="col-lg-9 Add_Surevy_Form2">
                    <div class="row">
                        <div class="col-md-4 survey-questions-buttons-div"><button type="button" class="btn btn-secondary survey-questions-buttons" id="mcq-question" style="box-shadow: none;">MCQ</button></div>
                        <div class="col-md-4 survey-questions-buttons-div"><button type="button" class="btn btn-primary survey-questions-buttons" id="checkbox-question" style="box-shadow: none;">CHECK BOX</button></div>
                        <div class="col-md-4 survey-questions-buttons-div"><button type="button" class="btn btn-danger survey-questions-buttons" id="free-question" style="box-shadow: none;">FREE ANSWER</button></div>
                    </div>

                    <div class="row add-survey-body">
                        <div class="left-side col-lg-6"></div>
                        <div class="right-side col-lg-6"></div>
                    </div>

                    <input type="text" hidden="true" name="mcq" class="mcqHidden"/>
                    <input type="text" hidden="true" name="checkBox" class="checkBoxHidden"/>
                    <input type="text" hidden="true" name="freeAnswer" class="freeAnswerHidden"/>
                    <input type='submit' class='btn btn-primary right-float' value="SAVE" id='survey-submit-button'>
                    <button class='btn btn-secondary right-float' onclick="location.href = 'HomePage.jsp';" id='survey-cancel-button'>Cancel</button>
                    <div class="clear"></div>
                </div>
            </div>
        </form>


        <script type='text/javascript' src='js\jQuery.js'></script>
        <script type='text/javascript' src='js\popper.js'></script>
        <script type='text/javascript' src='js\bootstrap.js'></script>
        <script type="text/javascript" src="js\AddSurvey.js"></script>
    </body>
    
    <%}}%>
</html>
