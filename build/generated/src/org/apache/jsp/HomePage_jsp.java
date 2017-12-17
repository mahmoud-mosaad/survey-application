package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Model.SurveyAnswers;
import Model.SurveyCounter;
import Model.Spam;
import Model.User;
import Model.Answer;
import java.util.ArrayList;
import Model.Question;
import Model.Survey;

public final class HomePage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");

    session = request.getSession(false);
    if (session.getAttribute("currentUser") == null) {
        response.sendRedirect("SignIn.jsp");
    } else {

        User currentUser = new User();
        currentUser = (User) session.getAttribute("currentUser");
        if (currentUser.isSuspended() == 1) {
            response.sendRedirect("SignOut");
        }



      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>\r\n");
      out.write("        <meta name='viewport' content='width=device-width, initial-scale=1, shrink-to-fit=no'>\r\n");
      out.write("        <link rel='stylesheet' href='css\\bootstrap.min.css'/>\r\n");
      out.write("        <link rel='stylesheet' href='css\\font-awesome.min.css'/>\r\n");
      out.write("        <link rel='stylesheet' href='css\\home.css'/>\r\n");
      out.write("        <script type='text/javascript' src='js\\jQuery.js'></script>\r\n");
      out.write("        <title>Home</title>\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        ");
            Spam spam1 = new Spam();
            ArrayList<Spam> spamSurveys = new ArrayList<Spam>();
            spamSurveys = spam1.getSpamedSurveysByCount();
        
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!-- Start of Nav Bar -->\r\n");
      out.write("        <nav class='navbar navbar-expand-lg navbar-light bg-light'>\r\n");
      out.write("            <a class='navbar-brand logo' href='#'>HI, ");
      out.print( currentUser.getName());
      out.write("</a>\r\n");
      out.write("            <button class='navbar-toggler' type='button' data-toggle='collapse' data-target='#collapsedNav' aria-controls='navbarSupportedContent' aria-expanded='false' aria-label='Toggle navigation'>\r\n");
      out.write("                <span class='navbar-toggler-icon'></span>\r\n");
      out.write("            </button>\r\n");
      out.write("\r\n");
      out.write("            <div class='collapse navbar-collapse' id='collapsedNav'>\r\n");
      out.write("                <ul class='navbar-nav mr-auto'>\r\n");
      out.write("\r\n");
      out.write("                    <li class='nav-item active'>\r\n");
      out.write("                        <a class='nav-link' href='HomePage.jsp'>Home</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("\r\n");
      out.write("                    <li class='nav-item'>\r\n");
      out.write("                        <a class='nav-link' data-toggle=\"tooltip\" title=\"Profile\" href='Profile.jsp'>Profile</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("\r\n");
      out.write("                    <li class='nav-item'>\r\n");
      out.write("                        <a class='nav-link' data-toggle=\"tooltip\" title=\"my Panel\" href='UserPanel.jsp'>My Panel</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    ");

                        if(currentUser.getType()==1){
                    
      out.write("\r\n");
      out.write("                    <li class='nav-item'>\r\n");
      out.write("                        <a class='nav-link' data-toggle=\"tooltip\" title=\"my Panel\" href='AdminPage.jsp'>Admin Panel</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    \r\n");
      out.write("                    ");
}
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    ");

                        if (currentUser.getType() == 1) {
                    
      out.write("\r\n");
      out.write("                    <li class='nav-item dropdown'>\r\n");
      out.write("                        <a class='nav-link dropdown-toggle' href='#' id='navbarDropdown' role='button' data-toggle='dropdown' aria-haspopup='true' aria-expanded='false'>\r\n");
      out.write("                            Notifications\r\n");
      out.write("                        </a>\r\n");
      out.write("                        <div class='dropdown-menu' aria-labelledby='navbarDropdown' style=\"width: 238px;\">\r\n");
      out.write("                            <table>\r\n");
      out.write("\r\n");
      out.write("                                <tr style=\"text-align: center;\">\r\n");
      out.write("                                    <th>survey Name</th>\r\n");
      out.write("                                    <th>spam count</th>\r\n");
      out.write("                                </tr>\r\n");
      out.write("\r\n");
      out.write("                                ");

                                    for (int ii = 0; ii < spamSurveys.size(); ii++) {
                                        Survey survey = new Survey();
                                        survey = survey.getSurvey(spamSurveys.get(ii).getSurveyID());
                                
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <th>\r\n");
      out.write("                                        <form action=\"Survey.jsp?spammedSurveyNumber=");
      out.print( ii);
      out.write("\" method=\"POST\">\r\n");
      out.write("                                            <input class='dropdown-item' type=\"submit\" data-surveyid=\"");
      out.print( spamSurveys.get(ii).getSurveyID());
      out.write("\" value=\"");
      out.print(survey.getName());
      out.write("\"/>   \r\n");
      out.write("                                            <input name='surveyID-");
      out.print( ii);
      out.write("' value=\"");
      out.print( spamSurveys.get(ii).getSurveyID());
      out.write("\" type=\"text\" hidden=\"true\"/>\r\n");
      out.write("                                            \r\n");
      out.write("                                        </form>\r\n");
      out.write("                                    </th>\r\n");
      out.write("                                    <th style=\"text-align: center;\">");
      out.print( spamSurveys.get(ii).getSpamCount());
      out.write("</th>\r\n");
      out.write("                                </tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                ");
}
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            </table>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    ");
}
      out.write("\r\n");
      out.write("\r\n");
      out.write("                </ul>\r\n");
      out.write("\r\n");
      out.write("                ");

                    if (currentUser.isSuspended() == 0) {
                
      out.write("\r\n");
      out.write("                <button style=\"box-shadow:none;\" class='btn btn-light my-2 my-sm-0 add-survey' onclick=\"location.href = 'AddSurvey.jsp';\" id='border-raduis-0' type='button'>ADD SUREVEY</button>\r\n");
      out.write("                ");
}
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <form action=\"SignOut\" method=\"POST\">\r\n");
      out.write("                    <input class=\"btn btn-outline-secondary sign-out-button\" style=\"box-shadow:none;\" type=\"submit\" value=\"Sign-Out\">\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </nav>\r\n");
      out.write("\r\n");
      out.write("        <!--End of Nav Bar-->\r\n");
      out.write("\r\n");
      out.write("        <!--Start of Home Body-->\r\n");
      out.write("\r\n");
      out.write("        <div class=\"posts\">\r\n");
      out.write("            <div class=\"container-fluid\">\r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("                <div class=\"card-columns custome-card-columns\">\r\n");
      out.write("                    ");

                        Survey survey = new Survey();
                        Spam spam = new Spam();
                        ArrayList<Survey> surveys = new ArrayList<Survey>();
                        ArrayList<Spam> spammedSurveys = new ArrayList<Spam>();
                        surveys = survey.getSurveys();
                        spammedSurveys = spam.getSpamedSurveys();

                        for (int i = 0; i < surveys.size(); i++) {
                    
      out.write("        \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    <div  class=\"card bg-primary text-white text-center p-3\" data-surveyid=\"");
      out.print( surveys.get(i).getId());
      out.write("\"  name=\"survey-body-");
      out.print( i);
      out.write("\" id=\"survey-body-");
      out.print( i);
      out.write("\"\r\n");
      out.write("                         data-toggle=\"modal\" data-target=\"#survey-model-");
      out.print( i);
      out.write("\" data-backdrop=\"static\" style=\"cursor: pointer\">\r\n");
      out.write("                        <div class=\"card-body\">\r\n");
      out.write("                            <h4 class=\"card-title\">");
      out.print( surveys.get(i).getName());
      out.write("</h4>\r\n");
      out.write("                            <p class=\"card-text\">");
      out.print( surveys.get(i).getDesc());
      out.write("</p>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"modal fade\" id=\"survey-model-");
      out.print( i);
      out.write("\"  tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("                        <div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("                            <div class=\"modal-content\">\r\n");
      out.write("                                <div class=\"modal-header\">\r\n");
      out.write("                                    <h5 class=\"modal-title\" id=\"exampleModalLabel\">");
      out.print( surveys.get(i).getName());
      out.write("</h5>\r\n");
      out.write("                                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n");
      out.write("                                        <span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("                                    </button>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                    ");
if(surveys.get(i).getUserID().equals(currentUser.getId())){
                                        
                                    
      out.write("\r\n");
      out.write("                                    <div style=\"font-size: 11px;\">http://localhost:8080/survey-application/Survey.jsp?spammedSurveyNumber=");
      out.print( i);
      out.write("&surveyID-");
      out.print( i);
      out.write('=');
      out.print(surveys.get(i).getId());
      out.write("</div>\r\n");
      out.write("                                    ");
}
      out.write("\r\n");
      out.write("                                    \r\n");
      out.write("                                    <div class=\"modal-body\">\r\n");
      out.write("                                    \r\n");
      out.write("                                    <form   action=\"SurveyAnsersController?surveyNumber=");
      out.print( i);
      out.write('~');
      out.print( surveys.get(i).getId());
      out.write("\" method=\"POST\" id=\"survey-form-");
      out.print( i);
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("                                        ");

                                            Question q = new Question();
                                            surveys.get(i).setMcqQuestions(q.getQuestions(surveys.get(i).getId(), "mcq"));
                                            surveys.get(i).setCheckboxQuestions(q.getQuestions(surveys.get(i).getId(), "checkbox"));
                                            surveys.get(i).setFreeanswerQuestions(q.getQuestions(surveys.get(i).getId(), "freeanswer"));
                                            for (int j = 0; j < surveys.get(i).getMcqQuestions().size(); j++) {
                                                Answer a = new Answer();
                                                SurveyAnswers SA = new SurveyAnswers();
                                                String expectedAnswer = SA.getAnswer(currentUser.getId(),surveys.get(i).getMcqQuestions().get(j).getId());
                                                
                                                surveys.get(i).getMcqQuestions().get(j).setMcqAnswers(a.getAnswer(surveys.get(i).getMcqQuestions().get(j).getId()));

                                        
      out.write("\r\n");
      out.write("                                        <div class=\"alert alert-secondary mcq-");
      out.print( i);
      out.write(" mcq-parent-question-");
      out.print( i);
      out.write('-');
      out.print( j);
      out.write("\" data-questionid=\"");
      out.print( surveys.get(i).getMcqQuestions().get(j).getId());
      out.write("\">\r\n");
      out.write("                                            <div style=\"font-weight: bold;\" >");
      out.print( surveys.get(i).getMcqQuestions().get(j).getValue());
      out.write("</div>\r\n");
      out.write("                                            ");

                                                for (int o = 0; o < surveys.get(i).getMcqQuestions().get(j).getMcqAnswers().size(); o++) {
                                                    String actualAnswer = surveys.get(i).getMcqQuestions().get(j).getMcqAnswers().get(o).getValue();
                                                
                                            
      out.write("\r\n");
      out.write("                                            <input type=\"radio\" ");
 if(expectedAnswer.equals(actualAnswer)){out.print("checked='true'");} 
      out.write("  onclick=\"submitAnswer('");
      out.print( i);
      out.write("')\" id=\"mcq-answer-");
      out.print( i);
      out.write('-');
      out.print( j);
      out.write('-');
      out.print( o);
      out.write("\" name=\"mcq-answer-");
      out.print( i);
      out.write('-');
      out.print( j);
      out.write("\" value=\"");
      out.print( surveys.get(i).getMcqQuestions().get(j).getMcqAnswers().get(o).getValue());
      out.write("\">\r\n");
      out.write("                                            \r\n");
      out.write("                                            <div  style=\"display: inline\">");
      out.print( surveys.get(i).getMcqQuestions().get(j).getMcqAnswers().get(o).getValue());
      out.write("</div>\r\n");
      out.write("                                            <br>\r\n");
      out.write("                                            ");

                                                }
                                            
      out.write("\r\n");
      out.write("                                            <input type=\"text\" id=\"mcq-answer-value-");
      out.print( i);
      out.write('-');
      out.print( j);
      out.write("\" name=\"mcq-answer-value-");
      out.print( i);
      out.write('-');
      out.print( j);
      out.write("\" hidden=\"true\">\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        ");

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
                                                   
                                        
      out.write("\r\n");
      out.write("                                        <div class=\"alert alert-primary checkbox-");
      out.print( i);
      out.write(" checkbox-parent-question-");
      out.print( i);
      out.write('-');
      out.print( j);
      out.write("\" data-questionid=\"");
      out.print( surveys.get(i).getCheckboxQuestions().get(j).getId());
      out.write("\">\r\n");
      out.write("                                            <div style=\"font-weight: bold;\" >");
      out.print( surveys.get(i).getCheckboxQuestions().get(j).getValue());
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("                                            ");

                                                for (int o = 0; o < surveys.get(i).getCheckboxQuestions().get(j).getCheckboxAnswers().size(); o++) {
                                                    String accutalAnswer = surveys.get(i).getCheckboxQuestions().get(j).getCheckboxAnswers().get(o).getValue();
                                            
      out.write("\r\n");
      out.write("                                            \r\n");
      out.write("                                            <input type=\"checkbox\"   \r\n");
      out.write("                                                   ");

                                                       for(int yy=0 ; yy<checks.size() ; yy++)
                                                       {
                                                           if(accutalAnswer.equals(checks.get(yy))){
                                                               out.print(" checked='true' ");
                                                               break;
                                                           }       
                                                       }
                                                   
      out.write("\r\n");
      out.write("                                                   \r\n");
      out.write("                                                   onclick=\"submitAnswer('");
      out.print( i);
      out.write("')\" class=\"checkbox-answer-");
      out.print( i);
      out.write('-');
      out.print( j);
      out.write("\" id=\"checkbox-answer-");
      out.print( i);
      out.write('-');
      out.print( j);
      out.write('-');
      out.print( o);
      out.write("\" name=\"checkbox-answer-");
      out.print( j);
      out.write("\" value=\"");
      out.print( surveys.get(i).getCheckboxQuestions().get(j).getCheckboxAnswers().get(o).getValue());
      out.write("\">\r\n");
      out.write("                                            <div style=\"display: inline;\">");
      out.print( surveys.get(i).getCheckboxQuestions().get(j).getCheckboxAnswers().get(o).getValue());
      out.write("</div>\r\n");
      out.write("                                            <br>\r\n");
      out.write("                                            ");

                                                }
                                            
      out.write("\r\n");
      out.write("                                            <input type=\"text\" id=\"checkbox-answer-value-");
      out.print( i);
      out.write('-');
      out.print( j);
      out.write("\" name=\"checkbox-answer-value-");
      out.print( i);
      out.write('-');
      out.print( j);
      out.write("\" hidden=\"true\">\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        ");

                                            }
                                            for (int j = 0; j < surveys.get(i).getFreeanswerQuestions().size(); j++) {
                                            
                                            SurveyAnswers SAA = new SurveyAnswers();
                                            String expectedFreeAnswer; 
                                            expectedFreeAnswer  = SAA.getAnswer(currentUser.getId(),surveys.get(i).getFreeanswerQuestions().get(j).getId());
                                        
      out.write("\r\n");
      out.write("                                        <div  class=\"alert alert-light freeanswer-parent-question-");
      out.print( i);
      out.write('-');
      out.print( j);
      out.write("\" data-questionid=\"");
      out.print( surveys.get(i).getFreeanswerQuestions().get(j).getId());
      out.write("\">\r\n");
      out.write("                                            <div  style=\"font-weight: bold;\">");
      out.print( surveys.get(i).getFreeanswerQuestions().get(j).getValue());
      out.write("</div>\r\n");
      out.write("                                            <textarea onmouseleave=\"submitAnswer('");
      out.print( i);
      out.write("')\" class=\"freeAnswer-");
      out.print( i);
      out.write(" form-control freeanswer-");
      out.print( j);
      out.write("\" rows=\"2\" id=\"freeanswer-answer-value0-");
      out.print( i);
      out.write('-');
      out.print( j);
      out.write("\" name=\"freeanswer-answer-value-");
      out.print( i);
      out.write('-');
      out.print( j);
      out.write("\" placeholder=\"Your Answer\">");

                                                if(expectedFreeAnswer != null || !expectedFreeAnswer.equals(""))
                                                {
                                                    out.print(expectedFreeAnswer);
                                                }
                                            
      out.write("</textarea>\r\n");
      out.write("                                            <input type=\"text\" id=\"freeanswer-answer-value-");
      out.print( i);
      out.write('-');
      out.print( j);
      out.write("\" name=\"freeanswer-answer-value1-");
      out.print( i);
      out.write('-');
      out.print( j);
      out.write("\" hidden=\"true\">\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        ");

                                            }
                                        
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                        <div class=\"modal-footer\">\r\n");
      out.write("\r\n");
      out.write("                                            ");

                                                if (surveys.get(i).getUserID().equals(currentUser.getId()) == false) {
                                                    
                                                    if (spammedSurveys.size() > 0) {
                                                           Spam checkSpammed = new Spam();
                                                           if(checkSpammed.checkIfSpammed(currentUser.getId() , surveys.get(i).getId()) == false)
                                                           {
                                            
      out.write("\r\n");
      out.write("                                            <button type=\"button\" class=\"btn btn-danger\" data-surveyid=\"");
      out.print( surveys.get(i).getId());
      out.write("\" data-userid=\"");
      out.print( currentUser.getId());
      out.write("\" id=\"spam-survey-button-");
      out.print( i);
      out.write("\" onclick=\"spam('");
      out.print( i);
      out.write("')\" style=\"cursor: pointer; box-shadow: none; border-radius: 0px; margin: 0px;\">Spam!</button>        \r\n");
      out.write("                                            ");

                                                           }
                                                    }else
                                                    {
                                            
      out.write("            \r\n");
      out.write("                                            <button type=\"button\" class=\"btn btn-danger\" data-surveyid=\"");
      out.print( surveys.get(i).getId());
      out.write("\" data-userid=\"");
      out.print( currentUser.getId());
      out.write("\" id=\"spam-survey-button-");
      out.print( i);
      out.write("\" onclick=\"spam('");
      out.print( i);
      out.write("')\" style=\"cursor: pointer; box-shadow: none; border-radius: 0px; margin: 0px;\">Spam!</button>\r\n");
      out.write("                                                       \r\n");
      out.write("                                                        \r\n");
      out.write("                                                    ");
}
      out.write("\r\n");
      out.write("                                            ");
}
      out.write("\r\n");
      out.write("                                            ");

                                                if ((surveys.get(i).getUserID().equals(currentUser.getId())) || (currentUser.getType() == 1)) {
                                            
      out.write("\r\n");
      out.write("                                            <button type=\"button\" class=\"btn btn-danger\" data-surveyid=\"");
      out.print( surveys.get(i).getId());
      out.write("\" id=\"suspend-survey-button-");
      out.print( i);
      out.write("\" onclick=\"suspend('");
      out.print( i);
      out.write("')\" style=\"cursor: pointer;box-shadow: none; border-radius: 0px; margin: 0px;\">Suspend</button>\r\n");
      out.write("\r\n");
      out.write("                                            <button type=\"button\" class=\"btn btn-warning\" data-surveyid=\"");
      out.print( surveys.get(i).getId());
      out.write("\" id=\"remove-survey-button-");
      out.print( i);
      out.write("\" onclick=\"remove('");
      out.print( i);
      out.write("')\" style=\"cursor: pointer;box-shadow: none; border-radius: 0px; margin: 0px;\">Remove</button>\r\n");
      out.write("                                            ");
}
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                            ");

                                                if (!(surveys.get(i).getUserID().equals(currentUser.getId()))) {
                                            
      out.write("\r\n");
      out.write("                                            \r\n");
      out.write("                                            ");

                                                SurveyCounter sc = new SurveyCounter();
                                                if(!sc.checkIfSubumittedBefore(currentUser.getId(), surveys.get(i).getId())){
                                                
                                            
      out.write("\r\n");
      out.write("                                            \r\n");
      out.write("                                            <input type=\"submit\" class=\"btn btn-primary\" data-surveyid=\"");
      out.print( surveys.get(i).getId());
      out.write("\" name=\"anonymous-");
      out.print( i);
      out.write("\" id=\"submit-survey-abutton-");
      out.print( i);
      out.write("\"  value=\"As lik Annonynas\" style=\"cursor: pointer;box-shadow: none; border-radius: 0px; margin: 0px;\">\r\n");
      out.write("                                            <input type=\"submit\" class=\"btn btn-primary\" data-surveyid=\"");
      out.print( surveys.get(i).getId());
      out.write("\" name=\"submit-");
      out.print( i);
      out.write("\" id=\"submit-survey-button-");
      out.print( i);
      out.write("\"  value=\"Submit\" style=\"cursor: pointer;box-shadow: none; border-radius: 0px; margin: 0px;\">\r\n");
      out.write("                                            ");
}else{
      out.write("\r\n");
      out.write("                                            \r\n");
      out.write("                                            <input type=\"submit\" class=\"btn btn-primary\" data-surveyid=\"");
      out.print( surveys.get(i).getId());
      out.write("\" name=\"anonymous-");
      out.print( i);
      out.write("\" id=\"submit-survey-abutton-");
      out.print( i);
      out.write("\"  onmouseenter=\"submitAnswer('");
      out.print( i);
      out.write("')\" value=\"As Annonynas\" style=\"cursor: pointer;box-shadow: none; border-radius: 0px; margin: 0px;\">\r\n");
      out.write("                                            <input type=\"submit\" class=\"btn btn-primary\" data-surveyid=\"");
      out.print( surveys.get(i).getId());
      out.write("\" id=\"submit-survey-button-");
      out.print( i);
      out.write("\" name=\"update-");
      out.print( i);
      out.write("\" onmouseenter=\"submitAnswer('");
      out.print( i);
      out.write("')\"  value=\"Update\" style=\"cursor: pointer;box-shadow: none; border-radius: 0px; margin: 0px;\">\r\n");
      out.write("                                            ");
}}
      out.write("\r\n");
      out.write("                                        </div>\r\n");
      out.write("\r\n");
      out.write("                                        <input type=\"text\" hidden=\"true\"  class=\"mcqHidden-");
      out.print( i);
      out.write("\" name=\"mcq-");
      out.print( i);
      out.write("\"/>\r\n");
      out.write("                                        <input type=\"text\" hidden=\"true\"  class=\"checkBoxHidden-");
      out.print( i);
      out.write("\" name=\"checkbox-");
      out.print( i);
      out.write("\"/>\r\n");
      out.write("                                        <input type=\"text\" hidden=\"true\"  class=\"freeAnswerHidden-");
      out.print( i);
      out.write("\" name=\"freeanswer-");
      out.print( i);
      out.write("\"/>\r\n");
      out.write("                             \r\n");
      out.write("                                    </form>\r\n");
      out.write("\r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    \r\n");
      out.write("                    ");

                        if (surveys.get(i).getSuspend() == 1) {
                    
      out.write("\r\n");
      out.write("                    <script type=\"text/javascript\">\r\n");
      out.write("                                                $id = ");
      out.print(i);
      out.write(";\r\n");
      out.write("\r\n");
      out.write("                                                $(\"#survey-form-\" + $id + \" :radio\").attr('disabled', 'true');\r\n");
      out.write("                                                $(\"#survey-form-\" + $id + \" :checkbox\").attr('disabled', 'true');\r\n");
      out.write("                                                $(\"#survey-form-\" + $id + \" textarea\").attr('disabled', 'true');\r\n");
      out.write("                                                $('#submit-survey-button-' + $id).attr('disabled', 'true');\r\n");
      out.write("                                                $('#submit-survey-abutton-' + $id).attr('disabled', 'true');\r\n");
      out.write("\r\n");
      out.write("                    </script>\r\n");
      out.write("                    ");
}
      out.write("\r\n");
      out.write("                    ");
          }

                    
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    <!--End of Home Body-->\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("                          \r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <script type='text/javascript' src='js\\popper.js'></script>\r\n");
      out.write("        <script type='text/javascript' src='js\\bootstrap.js'></script>\r\n");
      out.write("        <script type='text/javascript' src='js\\home.js'></script>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
}
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
