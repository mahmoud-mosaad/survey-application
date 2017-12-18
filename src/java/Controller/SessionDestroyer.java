package Controller;
import Model.User;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;
import javax.servlet.http.HttpSessionListener;


public class SessionDestroyer implements HttpSessionListener{

    @Override
    public void sessionCreated(HttpSessionEvent se) {
            System.out.print("session created-----------------------------------");
            se.getSession().setMaxInactiveInterval(60*60);

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.print("session ended-----------------------------------");
        User user = (User)se.getSession().getAttribute("currentUser");
        user.changeState(user.getEmail(), 0);
        System.out.print("-----------------------------------"+user.getName());
    }
    
  

}
