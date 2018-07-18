package grupa1;

import grupa1.Entity.User;
import grupa1.persistence.DataProvider;
import grupa1.persistence.HibernateDataProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Login", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        DataProvider dataProvider = new HibernateDataProvider();
        User user = dataProvider.getUserByUsername(username);
        System.out.println("login. user: " + user);
        if(user != null && user.hasPassword(password)) {
            HttpSession oldSession = request.getSession(false);
            if (oldSession != null) {
                oldSession.invalidate();
            }
            HttpSession newSession = request.getSession(true);
            newSession.setMaxInactiveInterval(5*60);
            newSession.setAttribute("username",user.getUserName());
            if(user.isAdmin()) {
                response.sendRedirect("/admin/index.jsp");
            }
            else{
                response.sendRedirect("/user/index.jsp");
            }
        }

        else {
            response.sendRedirect("index.jsp");
        }

    }
}
