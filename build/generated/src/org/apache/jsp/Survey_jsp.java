package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Model.Answer;
import Model.Question;
import Model.Spam;
import java.util.ArrayList;
import Model.Survey;

public final class Survey_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>\n");
      out.write("        <meta name='viewport' content='width=device-width, initial-scale=1, shrink-to-fit=no'>\n");
      out.write("        <link rel='stylesheet' href='css\\bootstrap.min.css'/>\n");
      out.write("        <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css'/>\n");
      out.write("        <link rel='stylesheet' href='css\\home.css'/>\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"card-columns custome-card-columns\">\n");
      out.write("                    ");

                        Survey survey = new Survey();
                        Spam spam = new Spam();
                        ArrayList<Survey> surveys = new ArrayList<Survey>();
                        ArrayList<Spam> spammedSurveys = new ArrayList<Spam>();
                        surveys = survey.getSurveys();
                        spammedSurveys = spam.getSpamedSurveys();

                        for (int i = 0; i < surveys.size(); i++) {
                    
      out.write("        \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <div class=\"card bg-primary text-white text-center p-3\" data-surveyid=\"");
      out.print( surveys.get(i).getId());
      out.write("\"  name=\"survey-body-");
      out.print( i);
      out.write("\" id=\"survey-body-");
      out.print( i);
      out.write("\"\n");
      out.write("                         data-toggle=\"modal\" data-target=\"#survey-model-");
      out.print( i);
      out.write("\" data-backdrop=\"static\" style=\"cursor: pointer\">\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                            <h4 class=\"card-title\">");
      out.print( surveys.get(i).getName());
      out.write("</h4>\n");
      out.write("                            <p class=\"card-text\">");
      out.print( surveys.get(i).getDesc());
      out.write("</p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal fade\" id=\"survey-model-");
      out.print( i);
      out.write("\"  tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("                        <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("                            <div class=\"modal-content\">\n");
      out.write("                                <div class=\"modal-header\">\n");
      out.write("                                    <h5 class=\"modal-title\" id=\"exampleModalLabel\">");
      out.print( surveys.get(i).getName());
      out.write("</h5>\n");
      out.write("                                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                                        <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                                    </button>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"modal-body\">\n");
      out.write("\n");
      out.write("                                    <form  action=\"SurveyAnsersController?surveyNumber=");
      out.print( i);
      out.write('~');
      out.print( surveys.get(i).getId());
      out.write("\" method=\"POST\" id=\"survey-form-");
      out.print( i);
      out.write("\">\n");
      out.write("\n");
      out.write("                                        ");

                                            Question q = new Question();
                                            surveys.get(i).setMcqQuestions(q.getQuestions(surveys.get(i).getId(), "mcq"));
                                            surveys.get(i).setCheckboxQuestions(q.getQuestions(surveys.get(i).getId(), "checkbox"));
                                            surveys.get(i).setFreeanswerQuestions(q.getQuestions(surveys.get(i).getId(), "freeanswer"));
                                            for (int j = 0; j < surveys.get(i).getMcqQuestions().size(); j++) {
                                                Answer a = new Answer();
                                                surveys.get(i).getMcqQuestions().get(j).setMcqAnswers(a.getAnswer(surveys.get(i).getMcqQuestions().get(j).getId()));

                                        
      out.write("\n");
      out.write("                                        <div class=\"alert alert-secondary mcq-");
      out.print( i);
      out.write(" mcq-parent-question-");
      out.print( i);
      out.write('-');
      out.print( j);
      out.write("\" data-questionid=\"");
      out.print( surveys.get(i).getMcqQuestions().get(j).getId());
      out.write("\">\n");
      out.write("                                            <div style=\"font-weight: bold;\" >");
      out.print( surveys.get(i).getMcqQuestions().get(j).getValue());
      out.write("</div>\n");
      out.write("                                            ");

                                                for (int o = 0; o < surveys.get(i).getMcqQuestions().get(j).getMcqAnswers().size(); o++) {
                                            
      out.write("\n");
      out.write("                                            <input type=\"radio\" onclick=\"submitAnswer('");
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
      out.write("\">\n");
      out.write("\n");
      out.write("                                            <div  style=\"display: inline\">");
      out.print( surveys.get(i).getMcqQuestions().get(j).getMcqAnswers().get(o).getValue());
      out.write("</div>\n");
      out.write("                                            <br>\n");
      out.write("                                            ");

                                                }
                                            
      out.write("\n");
      out.write("                                            <input type=\"text\" id=\"mcq-answer-value-");
      out.print( i);
      out.write('-');
      out.print( j);
      out.write("\" name=\"mcq-answer-value-");
      out.print( i);
      out.write('-');
      out.print( j);
      out.write("\" hidden=\"true\">\n");
      out.write("                                        </div>\n");
      out.write("                                        ");

                                            }

                                            for (int j = 0; j < surveys.get(i).getCheckboxQuestions().size(); j++) {
                                                Answer a = new Answer();
                                                surveys.get(i).getCheckboxQuestions().get(j).setCheckboxAnswers(a.getAnswer(surveys.get(i).getCheckboxQuestions().get(j).getId()));

                                        
      out.write("\n");
      out.write("                                        <div class=\"alert alert-primary checkbox-");
      out.print( i);
      out.write(" checkbox-parent-question-");
      out.print( i);
      out.write('-');
      out.print( j);
      out.write("\" data-questionid=\"");
      out.print( surveys.get(i).getCheckboxQuestions().get(j).getId());
      out.write("\">\n");
      out.write("                                            <div style=\"font-weight: bold;\" >");
      out.print( surveys.get(i).getCheckboxQuestions().get(j).getValue());
      out.write("</div>\n");
      out.write("\n");
      out.write("                                            ");

                                                for (int o = 0; o < surveys.get(i).getCheckboxQuestions().get(j).getCheckboxAnswers().size(); o++) {
                                            
      out.write("\n");
      out.write("                                            <input type=\"checkbox\" onclick=\"submitAnswer('");
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
      out.write("\">\n");
      out.write("                                            <div style=\"display: inline;\">");
      out.print( surveys.get(i).getCheckboxQuestions().get(j).getCheckboxAnswers().get(o).getValue());
      out.write("</div>\n");
      out.write("                                            <br>\n");
      out.write("                                            ");

                                                }
                                            
      out.write("\n");
      out.write("                                            <input type=\"text\" id=\"checkbox-answer-value-");
      out.print( i);
      out.write('-');
      out.print( j);
      out.write("\" name=\"checkbox-answer-value-");
      out.print( i);
      out.write('-');
      out.print( j);
      out.write("\" hidden=\"true\">\n");
      out.write("                                        </div>\n");
      out.write("                                        ");

                                            }
                                            for (int j = 0; j < surveys.get(i).getFreeanswerQuestions().size(); j++) {
                                        
      out.write("\n");
      out.write("                                        <div  class=\"alert alert-light freeanswer-parent-question-");
      out.print( i);
      out.write('-');
      out.print( j);
      out.write("\" data-questionid=\"");
      out.print( surveys.get(i).getFreeanswerQuestions().get(j).getId());
      out.write("\">\n");
      out.write("                                            <div  style=\"font-weight: bold;\">");
      out.print( surveys.get(i).getFreeanswerQuestions().get(j).getValue());
      out.write("</div>\n");
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
      out.write("\" placeholder=\"Your Answer\"></textarea>\n");
      out.write("                                            <input type=\"text\" id=\"freeanswer-answer-value-");
      out.print( i);
      out.write('-');
      out.print( j);
      out.write("\" name=\"freeanswer-answer-value1-");
      out.print( i);
      out.write('-');
      out.print( j);
      out.write("\" hidden=\"true\">\n");
      out.write("                                        </div>\n");
      out.write("                                        ");

                                            }
                                        
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                        <div class=\"modal-footer\">\n");
      out.write("\n");
      out.write("                                            ");

                                                if (!surveys.get(i).getUserID().equals("")) {
                                                    if (spammedSurveys.size() > 0) {
                                                        for (int j = 0; j < spammedSurveys.size(); j++) {
                                                            if (!spammedSurveys.get(j).getUserID().equals("")) {


                                            
      out.write("\n");
      out.write("\n");
      out.write("                                            <button type=\"button\" class=\"btn btn-danger\" data-surveyid=\"");
      out.print( surveys.get(i).getId());
      out.write("\"  id=\"spam-survey-button-");
      out.print( i);
      out.write("\" onclick=\"spam('");
      out.print( i);
      out.write("')\" style=\"cursor: pointer; box-shadow: none;\">Spam!</button>\n");
      out.write("                                            ");
}
                                                }
                                            } else {
      out.write("\n");
      out.write("                                            <button type=\"button\" class=\"btn btn-danger\" data-surveyid=\"");
      out.print( surveys.get(i).getId());
      out.write("\"  id=\"spam-survey-button-");
      out.print( i);
      out.write("\" onclick=\"spam('");
      out.print( i);
      out.write("')\" style=\"cursor: pointer; box-shadow: none;\">Spam!</button>\n");
      out.write("                                            ");


                                                    }
                                                }
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                            ");

                                                if ((surveys.get(i).getUserID().equals(""))) {
                                            
      out.write("\n");
      out.write("                                            <button type=\"button\" class=\"btn btn-danger\" data-surveyid=\"");
      out.print( surveys.get(i).getId());
      out.write("\" id=\"suspend-survey-button-");
      out.print( i);
      out.write("\" onclick=\"suspend('");
      out.print( i);
      out.write("')\" style=\"cursor: pointer;box-shadow: none;\">Suspend</button>\n");
      out.write("\n");
      out.write("                                            <button type=\"button\" class=\"btn btn-warning\" data-surveyid=\"");
      out.print( surveys.get(i).getId());
      out.write("\" id=\"remove-survey-button-");
      out.print( i);
      out.write("\" onclick=\"remove('");
      out.print( i);
      out.write("')\" style=\"cursor: pointer;box-shadow: none;\">Remove</button>\n");
      out.write("                                            ");
}
      out.write("\n");
      out.write("\n");
      out.write("                                            <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\" style=\"cursor: pointer;box-shadow: none;\">Close</button>\n");
      out.write("                                            ");

                                                if (!(surveys.get(i).getUserID().equals(""))) {
                                            
      out.write("\n");
      out.write("                                            <input type=\"submit\" class=\"btn btn-primary\" data-surveyid=\"");
      out.print( surveys.get(i).getId());
      out.write("\" id=\"submit-survey-button-");
      out.print( i);
      out.write("\" onclick=\"submit('");
      out.print( i);
      out.write("')\"  value=\"Submit\" style=\"cursor: pointer;box-shadow: none;\">\n");
      out.write("                                            ");
}
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("                                        <input type=\"text\" hidden=\"true\"  class=\"mcqHidden-");
      out.print( i);
      out.write("\" name=\"mcq-");
      out.print( i);
      out.write("\"/>\n");
      out.write("                                        <input type=\"text\" hidden=\"true\"  class=\"checkBoxHidden-");
      out.print( i);
      out.write("\" name=\"checkbox-");
      out.print( i);
      out.write("\"/>\n");
      out.write("                                        <input type=\"text\" hidden=\"true\"  class=\"freeAnswerHidden-");
      out.print( i);
      out.write("\" name=\"freeanswer-");
      out.print( i);
      out.write("\"/>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                    </form>\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <script type='text/javascript' src='jQuery.js'></script>\n");
      out.write("                    ");

                        if (surveys.get(i).getSuspend() == 1) {
                    
      out.write("\n");
      out.write("                    <script type=\"text/javascript\">\n");
      out.write("                                                $id = ");
      out.print(i);
      out.write(";\n");
      out.write("\n");
      out.write("                                                $(\"#survey-form-\" + $id + \" :radio\").attr('disabled', 'true');\n");
      out.write("                                                $(\"#survey-form-\" + $id + \" :checkbox\").attr('disabled', 'true');\n");
      out.write("                                                $(\"#survey-form-\" + $id + \" textarea\").attr('disabled', 'true');\n");
      out.write("                                                $('#submit-survey-button-' + $id).attr('disabled', 'true');\n");
      out.write("\n");
      out.write("                    </script>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                    ");
          }

                    
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <!--End of Home Body-->\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("    </body>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <script type='text/javascript' src='popper.js'></script>\n");
      out.write("        <script type='text/javascript' src='bootstrap.js'></script>\n");
      out.write("        <script type='text/javascript' src='home.js'></script>\n");
      out.write("</html>\n");
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
