<%@page import="Model.Answer"%>
<%@page import="Model.Question"%>
<%@page import="Model.Spam"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Survey"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
        <meta name='viewport' content='width=device-width, initial-scale=1, shrink-to-fit=no'>
        <link rel='stylesheet' href='css\bootstrap.min.css'/>
        <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css'/>
        <link rel='stylesheet' href='css\home.css'/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="card-columns custome-card-columns">
                    <%
                        Survey survey = new Survey();
                        Spam spam = new Spam();
                        ArrayList<Survey> surveys = new ArrayList<Survey>();
                        ArrayList<Spam> spammedSurveys = new ArrayList<Spam>();
                        survey.setId("e6763929a7c44a529438f4a673903d40");
//                        survey.setName("min");
                        survey.setUserID("8440c64388c04686b37d13650419da32");
//                        survey.setSuspend(0);
                        surveys.add(survey);
                        spammedSurveys = spam.getSpamedSurveys();

                        for (int i = 0; i < surveys.size(); i++) {
                    %>        



                    <div class="card bg-primary text-white text-center p-3" data-surveyid="<%= surveys.get(i).getId()%>"  name="survey-body-<%= i%>" id="survey-body-<%= i%>"
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
                                <div class="modal-body">

                                    <form  action="SurveyAnsersController?surveyNumber=<%= i%>~<%= surveys.get(i).getId()%>" method="POST" id="survey-form-<%= i%>">

                                        <%
                                            Question q = new Question();
                                            surveys.get(i).setMcqQuestions(q.getQuestions(surveys.get(i).getId(), "mcq"));
                                            surveys.get(i).setCheckboxQuestions(q.getQuestions(surveys.get(i).getId(), "checkbox"));
                                            surveys.get(i).setFreeanswerQuestions(q.getQuestions(surveys.get(i).getId(), "freeanswer"));
                                            for (int j = 0; j < surveys.get(i).getMcqQuestions().size(); j++) {
                                                Answer a = new Answer();
                                                surveys.get(i).getMcqQuestions().get(j).setMcqAnswers(a.getAnswer(surveys.get(i).getMcqQuestions().get(j).getId()));

                                        %>
                                        <div class="alert alert-secondary mcq-<%= i%> mcq-parent-question-<%= i%>-<%= j%>" data-questionid="<%= surveys.get(i).getMcqQuestions().get(j).getId()%>">
                                            <div style="font-weight: bold;" ><%= surveys.get(i).getMcqQuestions().get(j).getValue()%></div>
                                            <%
                                                for (int o = 0; o < surveys.get(i).getMcqQuestions().get(j).getMcqAnswers().size(); o++) {
                                            %>
                                            <input type="radio" onclick="submitAnswer('<%= i%>')" id="mcq-answer-<%= i%>-<%= j%>-<%= o%>" name="mcq-answer-<%= i%>-<%= j%>" value="<%= surveys.get(i).getMcqQuestions().get(j).getMcqAnswers().get(o).getValue()%>">

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

                                        %>
                                        <div class="alert alert-primary checkbox-<%= i%> checkbox-parent-question-<%= i%>-<%= j%>" data-questionid="<%= surveys.get(i).getCheckboxQuestions().get(j).getId()%>">
                                            <div style="font-weight: bold;" ><%= surveys.get(i).getCheckboxQuestions().get(j).getValue()%></div>

                                            <%
                                                for (int o = 0; o < surveys.get(i).getCheckboxQuestions().get(j).getCheckboxAnswers().size(); o++) {
                                            %>
                                            <input type="checkbox" onclick="submitAnswer('<%= i%>')" class="checkbox-answer-<%= i%>-<%= j%>" id="checkbox-answer-<%= i%>-<%= j%>-<%= o%>" name="checkbox-answer-<%= j%>" value="<%= surveys.get(i).getCheckboxQuestions().get(j).getCheckboxAnswers().get(o).getValue()%>">
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
                                        %>
                                        <div  class="alert alert-light freeanswer-parent-question-<%= i%>-<%= j%>" data-questionid="<%= surveys.get(i).getFreeanswerQuestions().get(j).getId()%>">
                                            <div  style="font-weight: bold;"><%= surveys.get(i).getFreeanswerQuestions().get(j).getValue()%></div>
                                            <textarea onmouseleave="submitAnswer('<%= i%>')" class="freeAnswer-<%= i%> form-control freeanswer-<%= j%>" rows="2" id="freeanswer-answer-value0-<%= i%>-<%= j%>" name="freeanswer-answer-value-<%= i%>-<%= j%>" placeholder="Your Answer"></textarea>
                                            <input type="text" id="freeanswer-answer-value-<%= i%>-<%= j%>" name="freeanswer-answer-value1-<%= i%>-<%= j%>" hidden="true">
                                        </div>
                                        <%
                                            }
                                        %>



                                        <div class="modal-footer">

                                            <%
                                                if (!surveys.get(i).getUserID().equals("")) {
                                                    if (spammedSurveys.size() > 0) {
                                                        for (int j = 0; j < spammedSurveys.size(); j++) {
                                                            if (!spammedSurveys.get(j).getUserID().equals("")) {


                                            %>

                                            <button type="button" class="btn btn-danger" data-surveyid="<%= surveys.get(i).getId()%>"  id="spam-survey-button-<%= i%>" onclick="spam('<%= i%>')" style="cursor: pointer; box-shadow: none;">Spam!</button>
                                            <%}
                                                }
                                            } else {%>
                                            <button type="button" class="btn btn-danger" data-surveyid="<%= surveys.get(i).getId()%>"  id="spam-survey-button-<%= i%>" onclick="spam('<%= i%>')" style="cursor: pointer; box-shadow: none;">Spam!</button>
                                            <%

                                                    }
                                                }%>













                                            <%
                                                if ((surveys.get(i).getUserID().equals(""))) {
                                            %>
                                            <button type="button" class="btn btn-danger" data-surveyid="<%= surveys.get(i).getId()%>" id="suspend-survey-button-<%= i%>" onclick="suspend('<%= i%>')" style="cursor: pointer;box-shadow: none;">Suspend</button>

                                            <button type="button" class="btn btn-warning" data-surveyid="<%= surveys.get(i).getId()%>" id="remove-survey-button-<%= i%>" onclick="remove('<%= i%>')" style="cursor: pointer;box-shadow: none;">Remove</button>
                                            <%}%>

                                            <button type="button" class="btn btn-secondary" data-dismiss="modal" style="cursor: pointer;box-shadow: none;">Close</button>
                                            <%
                                                if (!(surveys.get(i).getUserID().equals(""))) {
                                            %>
                                            <input type="submit" class="btn btn-primary" data-surveyid="<%= surveys.get(i).getId()%>" id="submit-survey-button-<%= i%>" onclick="submit('<%= i%>')"  value="Submit" style="cursor: pointer;box-shadow: none;">
                                            <%}%>
                                        </div>

                                        <input type="text" hidden="true"  class="mcqHidden-<%= i%>" name="mcq-<%= i%>"/>
                                        <input type="text" hidden="true"  class="checkBoxHidden-<%= i%>" name="checkbox-<%= i%>"/>
                                        <input type="text" hidden="true"  class="freeAnswerHidden-<%= i%>" name="freeanswer-<%= i%>"/>


                                    </form>

                                </div>

                            </div>
                        </div>
                    </div>

                    <script type='text/javascript' src='jQuery.js'></script>
                    <%
                        if (surveys.get(i).getSuspend() == 1) {
                    %>
                    <script type="text/javascript">
                                                $id = <%=i%>;

                                                $("#survey-form-" + $id + " :radio").attr('disabled', 'true');
                                                $("#survey-form-" + $id + " :checkbox").attr('disabled', 'true');
                                                $("#survey-form-" + $id + " textarea").attr('disabled', 'true');
                                                $('#submit-survey-button-' + $id).attr('disabled', 'true');

                    </script>
                    <%}%>
                    <%          }

                    %>


                    <!--End of Home Body-->

                </div>
    </body>
    
    
    <script type='text/javascript' src='popper.js'></script>
        <script type='text/javascript' src='bootstrap.js'></script>
        <script type='text/javascript' src='home.js'></script>
</html>
