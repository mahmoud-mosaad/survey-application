package Controller;

import Model.AdminMsg;
import Model.SuspendedUserResponse;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AdminController", urlPatterns = {"/AdminController"})
public class AdminController extends HttpServlet {

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
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            User user = new User();
            AdminMsg msg = new AdminMsg();
            if(request.getParameter("user-new-password") != null)
            {
                String newPassword = encryptPassword(request.getParameter("user-new-password"));
                String userEmail   = request.getParameter("user-email");
                user.changePassword(userEmail, newPassword);
                response.sendRedirect("AdminPage.jsp");
            }
            
            if(request.getParameter("suspendUser") != null)
            {
                String userEmail = request.getParameter("suspendUser");
                String suspendMsg = request.getParameter("suspendMsg");
                if(suspendMsg.equals(""))
                {
                    if(user.suspendUser(userEmail)){out.print("ok");}else{out.print("no");}
                    
                }else
                {
                     if(user.sendSuspendMsg(userEmail, suspendMsg)){out.print("ok");}else{out.print("no");}
                }
            }
            
            if(request.getParameter("unSuspendUser") != null)
            {
                SuspendedUserResponse message = new SuspendedUserResponse();
                User u = new User();
                String userEmail = request.getParameter("unSuspendUser");
                u = u.getUser(userEmail);
                if(user.unSuspendUser(userEmail)){
                    message.deleteResponse(u.getId());
                    out.print("ok");
                }else{
                    out.print("no");
                }
            }
            
            if(request.getParameter("makeAdmin") != null)
            {
                String userEmail = request.getParameter("makeAdmin");
                if(user.makeAdmin(userEmail , 1)){out.print("ok");}else{out.print("no");}
            }
            
            if(request.getParameter("undoAdmin") != null)
            {
                String userEmail = request.getParameter("undoAdmin");
                if(user.makeAdmin(userEmail , 0)){out.print("ok");}else{out.print("no");}
            }
            
            if(request.getParameter("adminMsg") != null)
            {
                AdminMsg message = new AdminMsg();
                String adminMsg = request.getParameter("adminMsg");
                String userID   = request.getParameter("userID");
                String userMail   = request.getParameter("mail");
                msg.setUserID(userID);
                msg.setMsg(adminMsg);
                if(msg.addMsg(msg)){out.print("ok");}else{out.print("no");}
            }
            
            
                    
            if(request.getParameter("userResponseMsg") != null)
            {
                SuspendedUserResponse message = new SuspendedUserResponse();
                String adminMsg = request.getParameter("userResponseMsg");
                String userID   = "";
                String userMail   = request.getParameter("userREmail");
                userID = user.getUser(userMail).getId();
                message.setUserID(userID);
                message.setMsg(adminMsg);
                if(message.addMsg(message)){out.print("ok");}else{out.print("no");}
            }        
                    
            
            if(request.getParameter("adminMsgAll") != null)
            {
                AdminMsg message = new AdminMsg();
                ArrayList<User> users = new ArrayList<User>();
                users = user.getUsers();
                String adminMsg = request.getParameter("adminMsgAll");
                
                for(int i=0 ; i<users.size() ; i++)
                {
                    msg.setUserID(users.get(i).getId());
                    msg.setMsg(adminMsg);
                    msg.addMsg(msg);
                }
                out.print("ok");
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
