package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Model.Survey;
import Model.User;
import Model.SurveyCounter;
import java.util.ArrayList;
import Model.SurveyAnswers;

public final class UserPanel_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("    ");

        User currentUser = new User();
        session = request.getSession(false);
        if (session.getAttribute("currentUser") == null) {
            response.sendRedirect("SignIn.jsp");
        } else {
            currentUser = (User) session.getAttribute("currentUser");
            if (currentUser.getType() == 1) {
                response.sendRedirect("HomePage.jsp");
            } else {

    
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <meta name='viewport' content='width=device-width, initial-scale=1, shrink-to-fit=no'>\r\n");
      out.write("        <link rel='stylesheet' href='css\\bootstrap.min.css'/>\r\n");
      out.write("        <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css'/>\r\n");
      out.write("        <link rel='stylesheet' href='css\\userPanel.css'/>\r\n");
      out.write("        <title>User Page</title>\r\n");
      out.write("        <script type='text/javascript' src='jQuery.js'></script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
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
      out.write("                    <li class='nav-item'>\r\n");
      out.write("                        <a class='nav-link' href='HomePage.jsp'>Home</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("\r\n");
      out.write("                    <li class='nav-item'>\r\n");
      out.write("                        <a class='nav-link' data-toggle=\"tooltip\" title=\"Profile\" href='Profile.jsp'>Profile</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("\r\n");
      out.write("                    <li class='nav-item active'>\r\n");
      out.write("                        <a class='nav-link' data-toggle=\"tooltip\" title=\"Admin Panel\" href='#'>My Panel</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("                <form action=\"SignOut\" method=\"POST\">\r\n");
      out.write("                    <input class=\"btn btn-outline-secondary sign-out-button\" style=\"box-shadow:none;\" type=\"submit\" value=\"Sign-Out\">\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </nav>\r\n");
      out.write("\r\n");
      out.write("        <!--End of Nav Bar-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div id=\"accordion\" role=\"tablist\">\r\n");
      out.write("\r\n");
      out.write("            <span>Name of survey</span>\r\n");
      out.write("            <span class=\"float-right\"># of submission</span>\r\n");
      out.write("            ");

                SurveyCounter sc = new SurveyCounter();
                SurveyCounter sc1 = new SurveyCounter();
                Survey s = new Survey();
                ArrayList<SurveyCounter> surveyCounters = new ArrayList<SurveyCounter>();
                ArrayList<Survey> surveys = new ArrayList<Survey>();
                surveys = s.getSurveys();
                surveyCounters = sc.getSubmitedSurvey();
                for(int i=0 ; i<surveys.size() ; i++)
                {
                    int ii=0;
                    if(surveys.get(i).getUserID().equals(currentUser.getId()))
                    {
                        sc = sc.getSingleSubmitedSurveysCount(surveys.get(i).getId());
                        
            
      out.write("\r\n");
      out.write("\r\n");
      out.write("            \r\n");
      out.write("            <div class=\"card\">\r\n");
      out.write("                \r\n");
      out.write("                <div class=\"card-header row\" role=\"tab\" id=\"\">\r\n");
      out.write("                    <div class=\"col-lg-11\">\r\n");
      out.write("                    <h5 class=\"mb-0 collapse\">\r\n");
      out.write("                        <a data-toggle=\"collapse\" href=\"#collapseOne-");
      out.print(i);
      out.write("\" aria-expanded=\"true\" aria-controls=\"collapseOne\">\r\n");
      out.write("                            ");
      out.print( surveys.get(i).getName());
      out.write("\r\n");
      out.write("                        </a>\r\n");
      out.write("                        <span class=\"float-right\" style=\"color:blue\">\r\n");
      out.write("                            \r\n");
      out.write("                          ");
      out.print( sc.getSubmitedSurveyCount());
      out.write("\r\n");
      out.write("                            \r\n");
      out.write("                        </span> \r\n");
      out.write("                    </h5>\r\n");
      out.write("                    </div>\r\n");
      out.write("                          <div class=\"col-lg-1\">Suspend</div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div id=\"collapseOne-");
      out.print(i);
      out.write("\" class=\"collapse show\" role=\"tabpanel\" aria-labelledby=\"headingOne\" data-parent=\"#accordion\">\r\n");
      out.write("                    <div class=\"card-body\">\r\n");
      out.write("                        <table class=\"padding display-inline\">\r\n");
      out.write("                            \r\n");
      out.write("                            <tr id=\"table-row\">\r\n");
      out.write("                                <th id=\"table-head\">#</th>\r\n");
      out.write("                                <th id=\"table-head\">User-Name</th>\r\n");
      out.write("                                <th id=\"table-head\">Age</th>\r\n");
      out.write("                                <th id=\"table-head\">Gender</th>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                            \r\n");
      out.write("                            ");

                                for(int h=0 ; h<surveyCounters.size() ; h++)
                                {
                                    
                                    if(surveyCounters.get(h).getSurevyID().equals(surveys.get(i).getId()))
                                    {
                                        
                                    User user = new User();
                                    if(!surveyCounters.get(h).getUserID().equals("mina")){
                                    user = user.getUserByID(surveyCounters.get(h).getUserID());
                                    }
                                
                            
      out.write("\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <th id=\"table-head\">");
      out.print( ++ii);
      out.write("</th>\r\n");
      out.write("                                <th id=\"table-head\">");
      out.print( user.getName());
      out.write("</th>\r\n");
      out.write("                                <th id=\"table-head\">");
      out.print( user.getAge());
      out.write("</th>\r\n");
      out.write("                                <th id=\"table-head\">");
      out.print( user.getGender());
      out.write("</th>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                            \r\n");
      out.write("                            ");
}}
      out.write("\r\n");
      out.write("                            \r\n");
      out.write("                        </table>\r\n");
      out.write("                            <img src=\"http://via.placeholder.com/500x150\" class=\"img\" style=\"vertical-align: top;\">\r\n");
      out.write("                        <!--<div class=\"padding display-inline\"></div>-->\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            ");
}}
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        ");
}
            }
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <script type='text/javascript' src='jQuery.js'></script>\r\n");
      out.write("        <script type='text/javascript' src='popper.js'></script>\r\n");
      out.write("        <script type='text/javascript' src='bootstrap.js'></script>\r\n");
      out.write("        <script type='text/javascript' src='userPanel.js'></script>\r\n");
      out.write("    </body>\r\n");
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
