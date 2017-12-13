package Controller;

import Model.Answer;
import Model.Question;
import Model.Survey;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AddSurvey", urlPatterns = {"/AddSurvey"})
public class AddSurvey extends HttpServlet {
    private int[] toInt(String []str)
    {
        int intArr[] = new int[str.length];
        
        for(int i=0 ; i<str.length ; i++)
        {
            int tmp = Integer.parseInt(str[i]);
            intArr[i] = tmp;
        }
        
        return intArr;
    }
    
    private Survey addSurvey(HttpServletRequest request , String userID)
    {
            String surveyID = UUID.randomUUID().toString().replace("-", "");
            Survey survey = new Survey();
            survey.setId(surveyID);
            survey.setName(request.getParameter("surveyName"));
            survey.setDesc(request.getParameter("surveyDesc"));
            survey.setUserID(userID);
            survey.setSuspend(0);
            survey.addSurvey(survey);
            
        return survey;    
    }
    
    private void addFreeAnswer(HttpServletRequest request,int questionCount ,String surveyID , String questionTag )
    {
         for(int i=1 ; i<=questionCount ; i++)
            {
                String mainQuestion = request.getParameter(questionTag+i);
                Question question = new Question();
                String questionID = UUID.randomUUID().toString().replace("-", "");
                question.setId(questionID);
                question.setValue(mainQuestion);
                question.setType("freeanswer");
                question.setSurveyID(surveyID);
                question.addQuestion(question);
            }
    }
    
    private void addMultDimensionQuestion(HttpServletRequest request , int questionCount[] , String questionType , String surveyID , String questionTag , String answerTag)
    {
        for(int i=1 ; i<=questionCount[0] ; i++)
            {
                String mainQuestion = request.getParameter(questionTag+i);
                Question question = new Question();
                String questionID = UUID.randomUUID().toString().replace("-", "");
                question.setId(questionID);
                question.setValue(mainQuestion);
                question.setType(questionType);
                question.setSurveyID(surveyID);
                question.addQuestion(question);
                for(int j=1 ; j<=questionCount[i] ; j++)
                {
                    String subAnswers = request.getParameter(answerTag+i+"-"+j);
                    Answer answer = new Answer();
                    String answerID = UUID.randomUUID().toString().replace("-", "");
                    answer.setId(answerID);
                    answer.setValue(subAnswers);
                    answer.setType(questionType);
                    answer.setQuetionID(question.getId());
                    answer.addAnswer(answer);
                }
            }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            User user = new User();
            HttpSession session = request.getSession(false);
            user = (User)session.getAttribute("currentUser");
            String userID = user.getId();
            Survey survey = new Survey();
            survey = addSurvey(request, userID);
            
            String mcq[] = request.getParameter("mcq").split("-");
            String checkbox[] = request.getParameter("checkBox").split("-");
            String freeAnswer = request.getParameter("freeAnswer");
            
            int MCQ[]       = toInt(mcq);
            int CHECKBOX[]  = toInt(checkbox);
            int FREEANSWER  = Integer.parseInt(freeAnswer);
            
            addMultDimensionQuestion(request,MCQ,"mcq", survey.getId(),"mcq-question-","mcq-number-");
            addMultDimensionQuestion(request,CHECKBOX,"checkbox", survey.getId(),"checkbox-question-","checkbox-answer-");
            addFreeAnswer(request, FREEANSWER, survey.getId(), "free-answer-question-");
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
