import Entity.User;
import persistence.DataProvider;
import persistence.HibernateDataProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Login", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        DataProvider dataProvider = new HibernateDataProvider();
        User user = dataProvider.getUserByUsername(username);
        if(user != null && user.hasPassword(password)) {
            resp.sendRedirect("user/index_user.html");
        }
        else {
            resp.sendRedirect("index.html");
        }

    }
}
