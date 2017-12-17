<%@page import="Model.SurveyAnswers"%>
<%@page import="Model.SurveyCounter"%>
<%@page import="Model.Spam"%>
<%@page import="Model.User"%>
<%@page import="Model.Answer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Question"%>
<%@page import="Model.Survey"%>
<%@page contentType='text/html' pageEncoding='UTF-8'%>
<!DOCTYPE html>

<%
    session = request.getSession(false);
    if (session.getAttribute("currentUser") == null) {
        response.sendRedirect("SignIn.jsp");
    } else {

        User currentUser = new User();
        currentUser = (User) session.getAttribute("currentUser");
        if (currentUser.isSuspended() == 1) {
            response.sendRedirect("SignOut");
        }


%>

<html>
    <head>
        <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
        <meta name='viewport' content='width=device-width, initial-scale=1, shrink-to-fit=no'>
        <link rel='stylesheet' href='css\bootstrap.min.css'/>
        <link rel='stylesheet' href='css\font-awesome.min.css'/>
        <link rel='stylesheet' href='css\home.css'/>
        <script type='text/javascript' src='js\jQuery.js'></script>
        <title>Home</title>
    </head>



    <body>


        <%            Spam spam1 = new Spam();
            ArrayList<Spam> spamSurveys = new ArrayList<Spam>();
            spamSurveys = spam1.getSpamedSurveysByCount();
        %>

        <!-- Start of Nav Bar -->
        <nav class='navbar navbar-expand-lg navbar-light bg-light'>
            <a class='navbar-brand logo' href='#'>HI, <%= currentUser.getName()%></a>
            <button class='navbar-toggler' type='button' data-toggle='collapse' data-target='#collapsedNav' aria-controls='navbarSupportedContent' aria-expanded='false' aria-label='Toggle navigation'>
                <span class='navbar-toggler-icon'></span>
            </button>

            <div class='collapse navbar-collapse' id='collapsedNav'>
                <ul class='navbar-nav mr-auto'>

                    <li class='nav-item active'>
                        <a class='nav-link' href='HomePage.jsp'>Home</a>
                    </li>

                    <li class='nav-item'>
                        <a class='nav-link' data-toggle="tooltip" title="Profile" href='Profile.jsp'>Profile</a>
                    </li>

                    <li class='nav-item'>
                        <a class='nav-link' data-toggle="tooltip" title="my Panel" href='UserPanel.jsp'>My Panel</a>
                    </li>
                    <%
                        if(currentUser.getType()==1){
                    %>
                    <li class='nav-item'>
                        <a class='nav-link' data-toggle="tooltip" title="my Panel" href='AdminPage.jsp'>Admin Panel</a>
                    </li>
                    
                    <%}%>

                    <%
                        if (currentUser.getType() == 1) {
                    %>
                    <li class='nav-item dropdown'>
                        <a class='nav-link dropdown-toggle' href='#' id='navbarDropdown' role='button' data-toggle='dropdown' aria-haspopup='true' aria-expanded='false'>
                            Notifications
                        </a>
                        <div class='dropdown-menu' aria-labelledby='navbarDropdown' style="width: 238px;">
                            <table>

                                <tr style="text-align: center;">
                                    <th>survey Name</th>
                                    <th>spam count</th>
                                </tr>

                                <%
                                    for (int ii = 0; ii < spamSurveys.size(); ii++) {
                                        Survey survey = new Survey();
                                        survey = survey.getSurvey(spamSurveys.get(ii).getSurveyID());
                                %>

                                <tr>
                                    <th>
                                        <form action="Survey.jsp?spammedSurveyNumber=<%= ii%>" method="POST">
                                            <input class='dropdown-item' type="submit" data-surveyid="<%= spamSurveys.get(ii).getSurveyID()%>" value="<%=survey.getName()%>"/>   
                                            <input name='surveyID-<%= ii%>' value="<%= spamSurveys.get(ii).getSurveyID()%>" type="text" hidden="true"/>
                                            
                                        </form>
                                    </th>
                                    <th style="text-align: center;"><%= spamSurveys.get(ii).getSpamCount()%></th>
                                </tr>


                                <%}%>

                            </table>
                        </div>
                    </li>
                    <%}%>

                </ul>

                <%
                    if (currentUser.isSuspended() == 0) {
                %>
                <button style="box-shadow:none;" class='btn btn-light my-2 my-sm-0 add-survey' onclick="location.href = 'AddSurvey.jsp';" id='border-raduis-0' type='button'>ADD SUREVEY</button>
                <%}%>

                <form action="SignOut" method="POST">
                    <input class="btn btn-outline-secondary sign-out-button" style="box-shadow:none;" type="submit" value="Sign-Out">
                </form>
            </div>
        </nav>

        <!--End of Nav Bar-->

        <!--Start of Home Body-->

        <div class="posts">
            <div class="container-fluid">
                
                
                
                <div class="card-columns custome-card-columns">
                    <%
                        Survey survey = new Survey();
                        Spam spam = new Spam();
                        ArrayList<Survey> surveys = new ArrayList<Survey>();
                        ArrayList<Spam> spammedSurveys = new ArrayList<Spam>();
                        surveys = survey.getSurveys();
                        spammedSurveys = spam.getSpamedSurveys();

                        for (int i = 0; i < surveys.size(); i++) {
                    %>        



                    <div  class="card bg-primary text-white text-center p-3" data-surveyid="<%= surveys.get(i).getId()%>"  name="survey-body-<%= i%>" id="survey-body-<%= i%>"
                         data-toggle="modal" data-target="#survey-model-<%= i%>" data-backdrop="static" style="cursor: pointer">
                        <div class="card-body">
                            <h4 class="card-title"><%= surveys.get(i).getName()%></h4>
                            <p class="card-text"><%= surveys.get(i).getDesc()%></p>
                        </div>
                    </div>
                    <div class="modal fade" id="survey-model-<%= i%>"  tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel"><%= surveys.get(i).getName()%></h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                    <%if(surveys.get(i).getUserID().equals(currentUser.getId())){
                                        
                                    %>
                                    <div style="font-size: 11px;">http://localhost:8080/survey-application/Survey.jsp?spammedSurveyNumber=<%= i%>&surveyID-<%= i%>=<%=surveys.get(i).getId()%></div>
                                    <%}%>
                                    
                                    <div class="modal-body">
                                    
                                    <form   action="SurveyAnsersController?surveyNumber=<%= i%>~<%= surveys.get(i).getId()%>" method="POST" id="survey-form-<%= i%>">

                                        <%
                                            Question q = new Question();
                                            surveys.get(i).setMcqQuestions(q.getQuestions(surveys.get(i).getId(), "mcq"));
                                            surveys.get(i).setCheckboxQuestions(q.getQuestions(surveys.get(i).getId(), "checkbox"));
                                            surveys.get(i).setFreeanswerQuestions(q.getQuestions(surveys.get(i).getId(), "freeanswer"));
                                            for (int j = 0; j < surveys.get(i).getMcqQuestions().size(); j++) {
                                                Answer a = new Answer();
                                                SurveyAnswers SA = new SurveyAnswers();
                                                String expectedAnswer = SA.getAnswer(currentUser.getId(),surveys.get(i).getMcqQuestions().get(j).getId());
                                                
                                                surveys.get(i).getMcqQuestions().get(j).setMcqAnswers(a.getAnswer(surveys.get(i).getMcqQuestions().get(j).getId()));

                                        %>
                                        <div class="alert alert-secondary mcq-<%= i%> mcq-parent-question-<%= i%>-<%= j%>" data-questionid="<%= surveys.get(i).getMcqQuestions().get(j).getId()%>">
                                            <div style="font-weight: bold;" ><%= surveys.get(i).getMcqQuestions().get(j).getValue()%></div>
                                            <%
                                                for (int o = 0; o < surveys.get(i).getMcqQuestions().get(j).getMcqAnswers().size(); o++) {
                                                    String actualAnswer = surveys.get(i).getMcqQuestions().get(j).getMcqAnswers().get(o).getValue();
                                                
                                            %>
                                            <input type="radio" <% if(expectedAnswer.equals(actualAnswer)){out.print("checked='true'");} %>  onclick="submitAnswer('<%= i%>')" id="mcq-answer-<%= i%>-<%= j%>-<%= o%>" name="mcq-answer-<%= i%>-<%= j%>" value="<%= surveys.get(i).getMcqQuestions().get(j).getMcqAnswers().get(o).getValue()%>">
                                            
                                            <div  style="display: inline"><%= surveys.get(i).getMcqQuestions().get(j).getMcqAnswers().get(o).getValue()%></div>
                                            <br>
                                            <%
                                                }
                                            %>
                                            <input type="text" id="mcq-answer-value-<%= i%>-<%= j%>" name="mcq-answer-value-<%= i%>-<%= j%>" hidden="true">
                                        </div>
                                        <%
                                            }

                                            for (int j = 0; j < surveys.get(i).getCheckboxQuestions().size(); j++) {
                                                
                                                Answer a = new Answer();
                                                surveys.get(i).getCheckboxQuestions().get(j).setCheckboxAnswers(a.getAnswer(surveys.get(i).getCheckboxQuestions().get(j).getId()));
                                                SurveyAnswers SACheck = new SurveyAnswers();
                                                ArrayList<String> checks = new ArrayList<String>(); 
                                                checks  = SACheck.getCheckBoxes(currentUser.getId(),surveys.get(i).getCheckboxQuestions().get(j).getId());
                                        
                                                
//                                                       for(int yy=0 ; yy<checks.size() ; yy++)
//                                                       {
//                                                          String g = checks.get(yy); 
//                                                          out.print(g);
//                                                       }
                                                   
                                        %>
                                        <div class="alert alert-primary checkbox-<%= i%> checkbox-parent-question-<%= i%>-<%= j%>" data-questionid="<%= surveys.get(i).getCheckboxQuestions().get(j).getId()%>">
                                            <div style="font-weight: bold;" ><%= surveys.get(i).getCheckboxQuestions().get(j).getValue()%></div>

                                            <%
                                                for (int o = 0; o < surveys.get(i).getCheckboxQuestions().get(j).getCheckboxAnswers().size(); o++) {
                                                    String accutalAnswer = surveys.get(i).getCheckboxQuestions().get(j).getCheckboxAnswers().get(o).getValue();
                                            %>
                                            
                                            <input type="checkbox"   
                                                   <%
                                                       for(int yy=0 ; yy<checks.size() ; yy++)
                                                       {
                                                           if(accutalAnswer.equals(checks.get(yy))){
                                                               out.print(" checked='true' ");
                                                               break;
                                                           }       
                                                       }
                                                   %>
                                                   
                                                   onclick="submitAnswer('<%= i%>')" class="checkbox-answer-<%= i%>-<%= j%>" id="checkbox-answer-<%= i%>-<%= j%>-<%= o%>" name="checkbox-answer-<%= j%>" value="<%= surveys.get(i).getCheckboxQuestions().get(j).getCheckboxAnswers().get(o).getValue()%>">
                                            <div style="display: inline;"><%= surveys.get(i).getCheckboxQuestions().get(j).getCheckboxAnswers().get(o).getValue()%></div>
                                            <br>
                                            <%
                                                }
                                            %>
                                            <input type="text" id="checkbox-answer-value-<%= i%>-<%= j%>" name="checkbox-answer-value-<%= i%>-<%= j%>" hidden="true">
                                        </div>
                                        <%
                                            }
                                            for (int j = 0; j < surveys.get(i).getFreeanswerQuestions().size(); j++) {
                                            
                                            SurveyAnswers SAA = new SurveyAnswers();
                                            String expectedFreeAnswer; 
                                            expectedFreeAnswer  = SAA.getAnswer(currentUser.getId(),surveys.get(i).getFreeanswerQuestions().get(j).getId());
                                        %>
                                        <div  class="alert alert-light freeanswer-parent-question-<%= i%>-<%= j%>" data-questionid="<%= surveys.get(i).getFreeanswerQuestions().get(j).getId()%>">
                                            <div  style="font-weight: bold;"><%= surveys.get(i).getFreeanswerQuestions().get(j).getValue()%></div>
                                            <textarea onmouseleave="submitAnswer('<%= i%>')" class="freeAnswer-<%= i%> form-control freeanswer-<%= j%>" rows="2" id="freeanswer-answer-value0-<%= i%>-<%= j%>" name="freeanswer-answer-value-<%= i%>-<%= j%>" placeholder="Your Answer"><%
                                                if(expectedFreeAnswer != null || !expectedFreeAnswer.equals(""))
                                                {
                                                    out.print(expectedFreeAnswer);
                                                }
                                            %></textarea>
                                            <input type="text" id="freeanswer-answer-value-<%= i%>-<%= j%>" name="freeanswer-answer-value1-<%= i%>-<%= j%>" hidden="true">
                                        </div>
                                        <%
                                            }
                                        %>



                                        <div class="modal-footer">

                                            <%
                                                if (surveys.get(i).getUserID().equals(currentUser.getId()) == false) {
                                                    
                                                    if (spammedSurveys.size() > 0) {
                                                           Spam checkSpammed = new Spam();
                                                           if(checkSpammed.checkIfSpammed(currentUser.getId() , surveys.get(i).getId()) == false)
                                                           {
                                            %>
                                            <button type="button" class="btn btn-danger" data-surveyid="<%= surveys.get(i).getId()%>" data-userid="<%= currentUser.getId()%>" id="spam-survey-button-<%= i%>" onclick="spam('<%= i%>')" style="cursor: pointer; box-shadow: none; border-radius: 0px; margin: 0px;">Spam!</button>        
                                            <%
                                                           }
                                                    }else
                                                    {
                                            %>            
                                            <button type="button" class="btn btn-danger" data-surveyid="<%= surveys.get(i).getId()%>" data-userid="<%= currentUser.getId()%>" id="spam-survey-button-<%= i%>" onclick="spam('<%= i%>')" style="cursor: pointer; box-shadow: none; border-radius: 0px; margin: 0px;">Spam!</button>
                                                       
                                                        
                                                    <%}%>
                                            <%}%>
                                            <%
                                                if ((surveys.get(i).getUserID().equals(currentUser.getId())) || (currentUser.getType() == 1)) {
                                            %>
                                            <button type="button" class="btn btn-danger" data-surveyid="<%= surveys.get(i).getId()%>" id="suspend-survey-button-<%= i%>" onclick="suspend('<%= i%>')" style="cursor: pointer;box-shadow: none; border-radius: 0px; margin: 0px;">Suspend</button>

                                            <button type="button" class="btn btn-warning" data-surveyid="<%= surveys.get(i).getId()%>" id="remove-survey-button-<%= i%>" onclick="remove('<%= i%>')" style="cursor: pointer;box-shadow: none; border-radius: 0px; margin: 0px;">Remove</button>
                                            <%}%>

                                            <%
                                                if (!(surveys.get(i).getUserID().equals(currentUser.getId()))) {
                                            %>
                                            
                                            <%
                                                SurveyCounter sc = new SurveyCounter();
                                                if(!sc.checkIfSubumittedBefore(currentUser.getId(), surveys.get(i).getId())){
                                                
                                            %>
                                            
                                            <input type="submit" class="btn btn-primary" data-surveyid="<%= surveys.get(i).getId()%>" name="anonymous-<%= i%>" id="submit-survey-abutton-<%= i%>"  value="As lik Annonynas" style="cursor: pointer;box-shadow: none; border-radius: 0px; margin: 0px;">
                                            <input type="submit" class="btn btn-primary" data-surveyid="<%= surveys.get(i).getId()%>" name="submit-<%= i%>" id="submit-survey-button-<%= i%>"  value="Submit" style="cursor: pointer;box-shadow: none; border-radius: 0px; margin: 0px;">
                                            <%}else{%>
                                            
                                            <input type="submit" class="btn btn-primary" data-surveyid="<%= surveys.get(i).getId()%>" name="anonymous-<%= i%>" id="submit-survey-abutton-<%= i%>"  onmouseenter="submitAnswer('<%= i%>')" value="As Annonynas" style="cursor: pointer;box-shadow: none; border-radius: 0px; margin: 0px;">
                                            <input type="submit" class="btn btn-primary" data-surveyid="<%= surveys.get(i).getId()%>" id="submit-survey-button-<%= i%>" name="update-<%= i%>" onmouseenter="submitAnswer('<%= i%>')"  value="Update" style="cursor: pointer;box-shadow: none; border-radius: 0px; margin: 0px;">
                                            <%}}%>
                                        </div>

                                        <input type="text" hidden="true"  class="mcqHidden-<%= i%>" name="mcq-<%= i%>"/>
                                        <input type="text" hidden="true"  class="checkBoxHidden-<%= i%>" name="checkbox-<%= i%>"/>
                                        <input type="text" hidden="true"  class="freeAnswerHidden-<%= i%>" name="freeanswer-<%= i%>"/>
                             
                                    </form>

                                </div>

                            </div>
                        </div>
                    </div>

                    
                    <%
                        if (surveys.get(i).getSuspend() == 1) {
                    %>
                    <script type="text/javascript">
                                                $id = <%=i%>;

                                                $("#survey-form-" + $id + " :radio").attr('disabled', 'true');
                                                $("#survey-form-" + $id + " :checkbox").attr('disabled', 'true');
                                                $("#survey-form-" + $id + " textarea").attr('disabled', 'true');
                                                $('#submit-survey-button-' + $id).attr('disabled', 'true');
                                                $('#submit-survey-abutton-' + $id).attr('disabled', 'true');

                    </script>
                    <%}%>
                    <%          }

                    %>


                    <!--End of Home Body-->

                </div>
                          
            </div>
        </div>


        <script type='text/javascript' src='js\popper.js'></script>
        <script type='text/javascript' src='js\bootstrap.js'></script>
        <script type='text/javascript' src='js\home.js'></script>
    </body>
</html>
<%}%>