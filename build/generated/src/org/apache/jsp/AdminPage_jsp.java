package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Model.Survey;
import java.util.ArrayList;
import Model.User;
import Model.Spam;

public final class AdminPage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    \n");
      out.write("    ");

            User currentUser = new User();
            session = request.getSession(false);
            if (session.getAttribute("currentUser") == null) {
                response.sendRedirect("SignIn.jsp");
            } else {
                currentUser = (User) session.getAttribute("currentUser");
                if(currentUser.getType()==0){response.sendRedirect("HomePage.jsp");}else{

        
      out.write("\n");
      out.write("    \n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name='viewport' content='width=device-width, initial-scale=1, shrink-to-fit=no'>\n");
      out.write("        <link rel='stylesheet' href='css\\bootstrap.min.css'/>\n");
      out.write("        <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css'/>\n");
      out.write("        <link rel='stylesheet' href='css\\AdminPage.css'/>\n");
      out.write("        <title>Admin Page</title>\n");
      out.write("        <script type='text/javascript' src='jQuery.js'></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        ");

            Spam spam = new Spam();
            ArrayList<Spam> spamSurveys = new ArrayList<Spam>();
            spamSurveys = spam.getSpamedSurveysByCount();
        
      out.write("\n");
      out.write("\n");
      out.write("        <!-- Start of Nav Bar -->\n");
      out.write("        <nav class='navbar navbar-expand-lg navbar-light bg-light'>\n");
      out.write("            <a class='navbar-brand logo' href='#'>HI, ");
      out.print( currentUser.getName());
      out.write("</a>\n");
      out.write("            <button class='navbar-toggler' type='button' data-toggle='collapse' data-target='#collapsedNav' aria-controls='navbarSupportedContent' aria-expanded='false' aria-label='Toggle navigation'>\n");
      out.write("                <span class='navbar-toggler-icon'></span>\n");
      out.write("            </button>\n");
      out.write("\n");
      out.write("            <div class='collapse navbar-collapse' id='collapsedNav'>\n");
      out.write("                <ul class='navbar-nav mr-auto'>\n");
      out.write("\n");
      out.write("                    <li class='nav-item'>\n");
      out.write("                        <a class='nav-link' href='HomePage.jsp'>Home</a>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li class='nav-item'>\n");
      out.write("                        <a class='nav-link' data-toggle=\"tooltip\" title=\"Profile\" href='Profile.jsp'>Profile</a>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li class='nav-item active'>\n");
      out.write("                        <a class='nav-link' data-toggle=\"tooltip\" title=\"Admin Panel\" href='#'>My Panel</a>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li class='nav-item dropdown'>\n");
      out.write("                        <a class='nav-link dropdown-toggle' href='#' id='navbarDropdown' role='button' data-toggle='dropdown' aria-haspopup='true' aria-expanded='false'>\n");
      out.write("                            Notifications\n");
      out.write("                        </a>\n");
      out.write("                        <div class='dropdown-menu' aria-labelledby='navbarDropdown' style=\"width: 238px;\">\n");
      out.write("                            <table>\n");
      out.write("\n");
      out.write("                                <tr style=\"text-align: center;\">\n");
      out.write("                                    <th>survey Name</th>\n");
      out.write("                                    <th>spam count</th>\n");
      out.write("                                </tr>\n");
      out.write("\n");
      out.write("                                ");

                                    for (int ii = 0; ii < spamSurveys.size(); ii++) {
                                        Survey survey = new Survey();
                                        survey = survey.getSurvey(spamSurveys.get(ii).getSurveyID());
                                
      out.write("\n");
      out.write("\n");
      out.write("                                <tr>\n");
      out.write("                                    <th><a class='dropdown-item' data-surveyid=\"");
      out.print( spamSurveys.get(ii).getSurveyID());
      out.write("\" href='#'>");
      out.print( survey.getName());
      out.write("</a></th>\n");
      out.write("                                    <th style=\"text-align: center;\">");
      out.print( spamSurveys.get(ii).getSpamCount());
      out.write("</th>\n");
      out.write("                                </tr>\n");
      out.write("\n");
      out.write("\n");
      out.write("                           ");
}
      out.write("\n");
      out.write("                           \n");
      out.write("                           </table>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("                <button style=\"box-shadow:none;\" class='btn btn-light my-2 my-sm-0 add-survey' onclick=\"location.href = 'AddSurvey.jsp';\" id='border-raduis-0' type='button'>ADD SUREVEY</button>\n");
      out.write("                <form action=\"SignOut\" method=\"POST\">\n");
      out.write("                    <input class=\"btn btn-outline-secondary sign-out-button\" style=\"box-shadow:none;\" type=\"submit\" value=\"Sign-Out\">\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <!--End of Nav Bar-->\n");
      out.write("\n");
      out.write("        ");

            User user = new User();
            int cc = 0;
            ArrayList<User> users = new ArrayList<User>();
            users = user.getUsers();
        
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"form-group form-inline\">\n");
      out.write("            <input type=\"text\" class=\"form-control\" name=\"\" id=\"admin-msg-all\"  placeholder=\"Enter your Msg here\" style=\"border-radius: 0px; width: 90%\">\n");
      out.write("            <button  class=\"btn btn-primary\"  onclick=\"sendMsgToAll()\" id=\"\" style=\"border-radius: 0px; box-shadow: none\">Go All</button>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <table class=\"users-table\">\n");
      out.write("            <tr id=\"user-table-head\">\n");
      out.write("                <th id=\"user-table-head-row\">#</th>\n");
      out.write("                <th id=\"user-table-head-row\">Name</th>\n");
      out.write("                <th id=\"user-table-head-row\">Email</th>\n");
      out.write("                <th id=\"user-table-head-row\">Change Password</th>\n");
      out.write("                <th id=\"user-table-head-row\">Gender</th>\n");
      out.write("                <th id=\"user-table-head-row\">Age</th>\n");
      out.write("                <th id=\"user-table-head-row\">Type</th>\n");
      out.write("                <th id=\"user-table-head-row\">Suspended!</th>\n");
      out.write("                <th id=\"user-table-head-row\">State</th>\n");
      out.write("                <th id=\"user-table-head-row\">Make Admin</th>\n");
      out.write("                <th id=\"user-table-head-row\">Msg To</th>\n");
      out.write("            </tr>\n");
      out.write("\n");
      out.write("            ");

                for (int i = 0; i < users.size(); i++) {
                   if(users.get(i).getId().equals(currentUser.getId())==false){
            
      out.write("\n");
      out.write("\n");
      out.write("            <tr id=\"user-table-head\">\n");
      out.write("                <th id=\"user-table-head-row\">");
      out.print( cc++);
      out.write("</th>\n");
      out.write("                <th id=\"user-table-head-row\">");
      out.print( users.get(i).getName());
      out.write("</th>\n");
      out.write("                <th id=\"user-table-head-row\">");
      out.print( users.get(i).getEmail());
      out.write("</th>\n");
      out.write("                <th id=\"user-table-head-row\">\n");
      out.write("                    <form action=\"AdminController\" method=\"POST\" class=\"form-inline\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <input type=\"password\" class=\"form-control\" name=\"user-new-password\" id=\"exampleInputEmail1\"  placeholder=\"Enter New User Password\" style=\"border-radius: 0px;\">\n");
      out.write("                            <input type=\"text\" class=\"form-control\" name=\"user-email\" hidden=\"true\" id=\"user-id\" value=\"");
      out.print( users.get(i).getEmail());
      out.write("\" >\n");
      out.write("                            <small id=\"emailHelp\" class=\"form-text\" hidden=\"true\"></small>\n");
      out.write("                        </div>\n");
      out.write("                        <input type=\"submit\" class=\"btn btn-primary\" value=\"Go\" id=\"change-password-button\" style=\"border-radius: 0px;\">\n");
      out.write("                    </form> \n");
      out.write("                </th>\n");
      out.write("                <th id=\"user-table-head-row\">");
      out.print( users.get(i).getGender());
      out.write("</th>\n");
      out.write("                <th id=\"user-table-head-row\">");
      out.print( users.get(i).getAge());
      out.write("</th>\n");
      out.write("                <th id=\"user-table-head-row\">");
      out.print( users.get(i).getType());
      out.write("</th>\n");
      out.write("                <th id=\"user-table-head-row\">\n");
      out.write("                    <button id=\"admin-suspend-button-");
      out.print( i);
      out.write("\"  onclick=\"suspendManager('");
      out.print( 1 - users.get(i).isSuspended());
      out.write("', this.id, '");
      out.print( users.get(i).getEmail());
      out.write("')\" type=\"button\" class=\"btn btn-danger\" style=\"cursor: pointer; box-shadow: none\">\n");
      out.write("\n");
      out.write("                        ");

                            if (users.get(i).isSuspended() == 0) {
                                out.print("Suspend");
                            } else {
                                out.print("Undo");
                            }
                        
      out.write("\n");
      out.write("                    </button>\n");
      out.write("                </th>\n");
      out.write("\n");
      out.write("                <th id=\"user-table-head-row\">\n");
      out.write("                    ");

                        if (users.get(i).getState() == 0) {
                            out.print("offline");
                        } else {
                            out.print("<span style='color:#11e711'>online</span>");
                        }
                    
      out.write("\n");
      out.write("\n");
      out.write("                </th>\n");
      out.write("\n");
      out.write("                <th id=\"user-table-head-row\">\n");
      out.write("                    <button id=\"make-admin-button-");
      out.print( i);
      out.write("\"  onclick=\"makeAdmin('");
      out.print( 1 - users.get(i).getType());
      out.write("', this.id, '");
      out.print( users.get(i).getEmail());
      out.write("')\" type=\"button\" class=\"btn btn-danger\" style=\"cursor: pointer; box-shadow: none\">\n");
      out.write("\n");
      out.write("                        ");

                            if (users.get(i).getType() == 0) {
                                out.print("Make Admin");
                            } else {
                                out.print("Undo");
                            }
                        
      out.write("\n");
      out.write("                    </button>\n");
      out.write("                </th>\n");
      out.write("\n");
      out.write("                <th id=\"user-table-head-row\">\n");
      out.write("                    <div class=\"form-group form-inline\" style=\"margin: auto;\">\n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"\" id=\"admin-msg-");
      out.print( i);
      out.write("\"  placeholder=\"Enter your Msg here\" style=\"border-radius: 0px;\">\n");
      out.write("                        <button  class=\"btn btn-primary\" onclick=\"sendMsg('");
      out.print( users.get(i).getEmail());
      out.write("', '");
      out.print( i);
      out.write("', '");
      out.print( users.get(i).getId());
      out.write("')\" id=\"change-password-button\" style=\"border-radius: 0px; box-shadow: none\">Go</button>\n");
      out.write("                    </div>\n");
      out.write("                </th>\n");
      out.write("\n");
      out.write("\n");
      out.write("            </tr>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            ");
}}
      out.write("\n");
      out.write("\n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script type='text/javascript' src='popper.js'></script>\n");
      out.write("        <script type='text/javascript' src='bootstrap.js'></script>\n");
      out.write("        <script type='text/javascript' src='AdminPage.js'></script>\n");
      out.write("    </body>\n");
      out.write("    \n");
      out.write("    ");
}}
      out.write("\n");
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
