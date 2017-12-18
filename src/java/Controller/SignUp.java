package Controller;



import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SignUp", urlPatterns = {"/SignUp"})
public class SignUp extends HttpServlet {

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
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return encrypted;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String uniqueID = UUID.randomUUID().toString().replace("-", "");
            User user = new User();
            user.setId(uniqueID);
            user.setName(request.getParameter("userName"));
            user.setEmail(request.getParameter("userEmail"));
            user.setPassword(encryptPassword(request.getParameter("userPassword")));
            user.setGender(request.getParameter("gender"));
            user.setAge(Integer.parseInt(request.getParameter("userAge")));
            user.setsuspendMsg("");
            user.setType(0);         //user 
            user.setSuspended(0);   // not suspended
            user.setState(1);      // online
            
            
            if(user.addUser(user)){
            HttpSession session = request.getSession(true);
            session.setAttribute("currentUser", user);
//            session.setMaxInactiveInterval(4*60);
            user.changeState(user.getEmail(), 1);
            response.sendRedirect("HomePage.jsp");
            }else
            {
                response.sendRedirect("SignUp.jsp");
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
