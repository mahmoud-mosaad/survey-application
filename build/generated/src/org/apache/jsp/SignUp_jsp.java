package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Model.User;

public final class SignUp_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("  ");

        session = request.getSession(false);
        if (session.getAttribute("currentUser") != null) {
            response.sendRedirect("HomePage.jsp");
        } else {
    
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css\\bootstrap.min.css\"/>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css\\signUp.css\"/>\r\n");
      out.write("        <title>Sign-UP</title>\r\n");
      out.write("    </head>\r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write("    <body class=\"Sign_Up\">\r\n");
      out.write("        <div class=\"test\"></div>\r\n");
      out.write("        <form action=\"SignUp\" method=\"POST\" class=\"Sign_Up_Form\">\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("                <input type=\"text\" class=\"form-control\" name=\"userName\" id=\"userName\" placeholder=\"Enter your Name\" required=\"true\">\r\n");
      out.write("                <div id=\"nameAuth\" class=\"form-text invalid-feedback error\"></div>  \r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("                <input type=\"email\" class=\"form-control\" name=\"userEmail\" id=\"userEmail\" aria-describedby=\"emailHelp\" placeholder=\"Enter your E-mail\" required=\"true\">\r\n");
      out.write("                <small id=\"emailAuth\" class=\"form-text invalid-feedback error\"></small>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("                <input type=\"password\" class=\"form-control\" name=\"userPassword\" id=\"userPassword\" placeholder=\"Enter your Password\" required=\"true\">\r\n");
      out.write("                <small id=\"passwordAuth\" class=\"form-text invalid-feedback error\"></small>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("                <input type=\"number\" class=\"form-control\" name=\"userAge\" id=\"userAge\" placeholder=\"Enter your Age\" required=\"true\" min=\"16\" max=\"100\">\r\n");
      out.write("                <small id=\"ageAuth\" class=\"form-text invalid-feedback error\"></small>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div>\r\n");
      out.write("\r\n");
      out.write("                <label>Gender</label>\r\n");
      out.write("\r\n");
      out.write("                <label class=\"custom-control custom-radio block\">\r\n");
      out.write("\r\n");
      out.write("                    <input id=\"gender\" name=\"Gender\" type=\"radio\" class=\"custom-control-input\" value=\"male\">\r\n");
      out.write("                    <span class=\"custom-control-indicator\"></span>\r\n");
      out.write("                    <span class=\"custom-control-description\">Male</span>\r\n");
      out.write("\r\n");
      out.write("                </label>\r\n");
      out.write("\r\n");
      out.write("                <label class=\"custom-control custom-radio block\">\r\n");
      out.write("\r\n");
      out.write("                    <input id=\"gender\" name=\"Gender\" type=\"radio\" class=\"custom-control-input\" value=\"female\">\r\n");
      out.write("                    <span class=\"custom-control-indicator\"></span>\r\n");
      out.write("                    <span class=\"custom-control-description\">Female</span>\r\n");
      out.write("\r\n");
      out.write("                </label>\r\n");
      out.write("                <input type=\"text\" name=\"gender\" id=\"userGender\" hidden>\r\n");
      out.write("                <small id=\"genderAuth\" class=\"form-text invalid-feedback error\"></small>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <input id=\"sign_up_button\" type=\"submit\" class=\"btn btn-primary Sign_Up_Button\" value=\"SIGN UP\"/>\r\n");
      out.write("            <button id=\"sign_in_button\" onclick=\"window.location.href = 'SignIn.jsp'\" type=\"button\" class=\"btn btn-danger Sign_In_Button\">SIGN IN</button>\r\n");
      out.write("            <div class=\"clear\"></div>\r\n");
      out.write("        </form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/javascript\" src=\"js\\jQuery.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"js\\signUp.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("\r\n");
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
