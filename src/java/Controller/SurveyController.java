package Controller;

import Model.Spam;
import Model.Survey;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SurveyController", urlPatterns = {"/SurveyController"})
public class SurveyController extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            if(request.getParameter("suspend") != null)
            {
                String surveyID = request.getParameter("suspend");
                Survey survey = new Survey();
                if(survey.suspend(surveyID))
                {
                    out.print("ok");
                }else
                {
                    out.print("no");
                }
            }
            
            if(request.getParameter("remove") != null)
            {
                String surveyID = request.getParameter("remove");
                Survey survey = new Survey();
                if(survey.deleteSurvey(surveyID))
                {
                    out.print("ok");
                }else
                {
                    out.print("no");
                }
            }
            
            if(request.getParameter("spam") != null)
            {
                String IDs[] = request.getParameter("spam").split("-");
                String surveyID = IDs[0];
                String userID = IDs[1];
                
                Spam spam = new Spam();
                spam.setUserID(userID);
                spam.setSurveyID(surveyID);
                spam.setIsSpam(1);
                if(spam.spamIt(spam))
                {
                    out.print("ok");
                }else
                {
                    out.print("no");
                }
            } 
            
            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
