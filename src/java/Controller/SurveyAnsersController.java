/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "SurveyAnsersController", urlPatterns = {"/SurveyAnsersController"})
public class SurveyAnsersController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String survey[] = request.getParameter("surveyNumber").split("~");
            String surveyNumber = survey[0];
            String surveyID = survey[1];
            out.print(surveyID);
            String mcq = request.getParameter("mcq-" + surveyNumber);
            String checkbox = request.getParameter("checkbox-" + surveyNumber);
            String freeAnswer = request.getParameter("freeanswer-" + surveyNumber);

            for (int i = 0; i < Integer.parseInt(mcq); i++) {
                out.print(request.getParameter("mcq-answer-value-" + surveyNumber + "-" + String.valueOf(i)));
                
            }

            for (int i = 0; i < Integer.parseInt(checkbox); i++) {
                out.print(request.getParameter("checkbox-answer-value-" + surveyNumber + "-" + String.valueOf(i)));
                out.print("<br>");
            }
            
            for (int i = 0; i < Integer.parseInt(freeAnswer); i++) {
                out.print(request.getParameter("freeanswer-answer-value1-" + surveyNumber + "-" + String.valueOf(i)));
                out.print("<br>");             
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
