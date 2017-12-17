package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Model.User;

public final class AddSurvey_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    \r\n");
      out.write("    ");

            User currentUser = new User();
            session = request.getSession(false);
            if (session.getAttribute("currentUser") == null) {
                response.sendRedirect("SignIn.jsp");
            } else {
                currentUser = (User) session.getAttribute("currentUser");
                if(currentUser.isSuspended()==1){response.sendRedirect("HomePage.jsp");}else{


        
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    <head>\r\n");
      out.write("        <title>ADD SUREVY</title>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css\\bootstrap.min.css\"/>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css\\AddSurevy.css\"/>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <form action=\"AddSurvey\" method=\"POST\" class=\"\" id='Surevy_Form'>\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-lg-2 Add_Surevy_Form1\">\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"surveyName\" id=\"surveyName\" placeholder=\"Enter Survey Name\" required=\"true\">\r\n");
      out.write("                        <div id=\"surveyNameAuth\" class=\"form-text invalid-feedback error\"></div>  \r\n");
      out.write("                    </div>\r\n");
      out.write("                    \r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <textarea type=\"text\" class=\"form-control\" name=\"surveyDesc\" id=\"surveyDesc\" placeholder=\"Enter Survey Description\" rows=\"5\"></textarea>\r\n");
      out.write("                        <div id=\"surveyDescAuth\" class=\"form-text invalid-feedback error\"></div>  \r\n");
      out.write("                    </div>   \r\n");
      out.write("                </div>\r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("                <div class=\"col-lg-9 Add_Surevy_Form2\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-md-4 survey-questions-buttons-div\"><button type=\"button\" class=\"btn btn-secondary survey-questions-buttons\" id=\"mcq-question\" style=\"box-shadow: none;\">MCQ</button></div>\r\n");
      out.write("                        <div class=\"col-md-4 survey-questions-buttons-div\"><button type=\"button\" class=\"btn btn-primary survey-questions-buttons\" id=\"checkbox-question\" style=\"box-shadow: none;\">CHECK BOX</button></div>\r\n");
      out.write("                        <div class=\"col-md-4 survey-questions-buttons-div\"><button type=\"button\" class=\"btn btn-danger survey-questions-buttons\" id=\"free-question\" style=\"box-shadow: none;\">FREE ANSWER</button></div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"row add-survey-body\">\r\n");
      out.write("                        <div class=\"left-side col-lg-6\"></div>\r\n");
      out.write("                        <div class=\"right-side col-lg-6\"></div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <input type=\"text\" hidden=\"true\" name=\"mcq\" class=\"mcqHidden\"/>\r\n");
      out.write("                    <input type=\"text\" hidden=\"true\" name=\"checkBox\" class=\"checkBoxHidden\"/>\r\n");
      out.write("                    <input type=\"text\" hidden=\"true\" name=\"freeAnswer\" class=\"freeAnswerHidden\"/>\r\n");
      out.write("                    <input type='submit' class='btn btn-primary right-float' value=\"SAVE\" id='survey-submit-button'>\r\n");
      out.write("                    <button class='btn btn-secondary right-float' onclick=\"location.href = 'HomePage.jsp';\" id='survey-cancel-button'>Cancel</button>\r\n");
      out.write("                    <div class=\"clear\"></div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <script type='text/javascript' src='js\\jQuery.js'></script>\r\n");
      out.write("        <script type='text/javascript' src='js\\popper.js'></script>\r\n");
      out.write("        <script type='text/javascript' src='js\\bootstrap.js'></script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"js\\AddSurvey.js\"></script>\r\n");
      out.write("    </body>\r\n");
      out.write("    \r\n");
      out.write("    ");
}}
      out.write("\r\n");
      out.write("</html>\r\n");
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
