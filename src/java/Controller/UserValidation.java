package Controller;

import Model.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "UserValidation", urlPatterns = {"/UserValidation"})
public class UserValidation extends HttpServlet {

    private String encryptPassword(String password) {
        MessageDigest md;
        String encrypted = "";
        try {
            md = MessageDigest.getInstance("SHA-256");

            md.update(password.getBytes());

            byte byteData[] = md.digest();

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
                encrypted = sb.toString();
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UserValidation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return encrypted;
    }

    protected void serverValidation(HttpServletRequest request, HttpServletResponse response, PrintWriter out) {

        if (request.getParameter("userName") != null) {
            String userName = request.getParameter("userName");
            User user = new User();

            if (!user.checkUserName(userName)) {
                out.print("ok");
            } else {
                out.print("user name found plz choose another one.");
            }
        }

        if (request.getParameter("userEmail") != null) {
            String userEmail = request.getParameter("userEmail");
            User user = new User();

            if (!user.checkUserEmail(userEmail)) {
                out.print("ok");
            } else {
                out.print("email found plz choose another one.");
            }
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            serverValidation(request, response, out);

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
