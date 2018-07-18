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

import grupa1.model.UserModel;

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
            UserModel userModel = new UserModel(user);
            HttpSession newSession = request.getSession(true);
            newSession.setMaxInactiveInterval(5*60);
            newSession.setAttribute("username",user.getUserName());

            if(user.isAdmin()) {
                UserModel UserModel = new UserModel(user);
                request.getSession().setAttribute(UserModel.KEY, userModel);
                response.sendRedirect("admin/index_admin.jsp");
            }
            else{
                response.sendRedirect("user/index_user.jsp");
            }
        }

        else {
            response.sendRedirect("index.jsp");
        }

    }
}
