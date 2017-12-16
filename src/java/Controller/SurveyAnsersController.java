package Controller;

import Model.SurveyAnswers;
import Model.SurveyCounter;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SurveyAnsersController", urlPatterns = {"/SurveyAnsersController"})
public class SurveyAnsersController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            HttpSession session = request.getSession(false);
            User currentUser = new User();
//            SurveyAnswers sa = new SurveyAnswers();
            SurveyCounter SubmitedSurveyCount = new SurveyCounter();
            currentUser = (User) session.getAttribute("currentUser");
            String userID = "";
            String survey[] = request.getParameter("surveyNumber").split("~");
            String surveyNumber = survey[0];
            String surveyID = survey[1];
            String mcq = request.getParameter("mcq-" + surveyNumber);
            String checkbox = request.getParameter("checkbox-" + surveyNumber);
            String freeAnswer = request.getParameter("freeanswer-" + surveyNumber);
            
            if(mcq == null || mcq.equals("")){mcq="0";}
            if(checkbox == null || checkbox.equals("")){checkbox="0";}
            if(freeAnswer == null || freeAnswer.equals("")){freeAnswer="0";}
            
            System.out.print("==========================================");
            System.out.print(mcq);
            System.out.print(checkbox);
            System.out.print(freeAnswer);
            System.out.print("===========================================");

            
            if (request.getParameter("anonymous-" + surveyNumber) != null) {
                userID = "anonymous";
            } else {
                userID = currentUser.getId();
            }

            if (request.getParameter("update-" + surveyNumber) != null) {
                for (int i = 0; i < Integer.parseInt(mcq); i++) {
                    SurveyAnswers sa = new SurveyAnswers();
                    String radioValue[] = request.getParameter("mcq-answer-value-" + surveyNumber + "-" + String.valueOf(i)).split("~");
                    if (!radioValue[1].equals("undefined")) {
                        sa.setUserID(userID);
                        sa.setSurveyID(surveyID);
                        sa.setQuestionID(radioValue[0]);
                        sa.setAnswer(radioValue[1]);
                        System.out.println(sa.getAnswer());
                        sa.updateAnswer(sa);

                    }
                }

                for (int i = 0; i < Integer.parseInt(checkbox); i++) {

                    String checkBox[] = request.getParameter("checkbox-answer-value-" + surveyNumber + "-" + String.valueOf(i)).split("~");
                    String questionID = checkBox[0];
                    for (int ii = 1; ii < checkBox.length; ii++) {
                        if (!checkBox[ii].equals("undefined")) {
                            SurveyAnswers sa = new SurveyAnswers();
                            sa.setUserID(userID);
                            sa.setSurveyID(surveyID);
                            sa.setQuestionID(questionID);
                            sa.setAnswer(checkBox[ii]);
                            System.out.println(sa.getAnswer());
                            sa.updateAnswer(sa);

                        }
                    }

                }

                for (int i = 0; i < Integer.parseInt(freeAnswer); i++) {

                    String freeAns[] = request.getParameter("freeanswer-answer-value1-" + surveyNumber + "-" + String.valueOf(i)).split("~");
                    if (freeAns.length > 1) {
                        out.print(request.getParameter("freeanswer-answer-value1-" + surveyNumber + "-" + String.valueOf(i)) + "<br>");
                        if (!freeAns[1].equals("") || !freeAns[1].equals("undefined")) {
                            SurveyAnswers ss = new SurveyAnswers();
                            ss.setUserID(userID);
                            ss.setSurveyID(surveyID);
                            ss.setQuestionID(freeAns[0]);
                            ss.setAnswer(freeAns[1]);
                            System.out.println(ss.getAnswer());
                            ss.updateAnswer(ss);

                        }

                    }
                }

            }

            if (request.getParameter("submit-" + surveyNumber) != null || request.getParameter("anonymous-" + surveyNumber) != null) {
                SubmitedSurveyCount.setUserID(userID);
                SubmitedSurveyCount.setSurevyID(surveyID);
                SubmitedSurveyCount.submitSurvey(SubmitedSurveyCount);

                for (int i = 0; i < Integer.parseInt(mcq); i++) {

                    String radioValue[] = request.getParameter("mcq-answer-value-" + surveyNumber + "-" + String.valueOf(i)).split("~");
                    if (!radioValue[1].equals("undefined")) {
                        SurveyAnswers sa = new SurveyAnswers();
                        sa.setUserID(userID);
                        sa.setSurveyID(surveyID);
                        sa.setQuestionID(radioValue[0]);
                        sa.setAnswer(radioValue[1]);
                        sa.addAnswer(sa);
                    }
                }

                for (int i = 0; i < Integer.parseInt(checkbox); i++) {

                    String checkBox[] = request.getParameter("checkbox-answer-value-" + surveyNumber + "-" + String.valueOf(i)).split("~");
                    String questionID = checkBox[0];
                    for (int ii = 1; ii < checkBox.length; ii++) {
                        if (!checkBox[ii].equals("undefined")) {
                            SurveyAnswers sa = new SurveyAnswers();
                            sa.setUserID(userID);

                            sa.setSurveyID(surveyID);
                            sa.setQuestionID(questionID);
                            sa.setAnswer(checkBox[ii]);
                            sa.addAnswer(sa);
                        }
                    }

                }

                for (int i = 0; i < Integer.parseInt(freeAnswer); i++) {

                    String freeAns[] = request.getParameter("freeanswer-answer-value1-" + surveyNumber + "-" + String.valueOf(i)).split("~");
                    if (freeAns.length > 1) {
                        out.print(request.getParameter("freeanswer-answer-value1-" + surveyNumber + "-" + String.valueOf(i)) + "<br>");
                        if (!freeAns[1].equals("") || !freeAns[1].equals("undefined")) {
                            SurveyAnswers ss = new SurveyAnswers();
                            ss.setUserID(userID);
                            ss.setSurveyID(surveyID);
                            ss.setQuestionID(freeAns[0]);
                            ss.setAnswer(freeAns[1]);
                            ss.addAnswer(ss);
                        }

                    }
                }
            }

            response.sendRedirect("HomePage.jsp");

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
