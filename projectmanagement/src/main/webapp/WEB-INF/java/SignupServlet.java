import Entity.User;
import persistence.DataProvider;
import persistence.HibernateDataProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Register", urlPatterns = {"/register"})
public class SignupServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        String email = req.getParameter("email");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        DataProvider dataProvider = new HibernateDataProvider();
        User user = new User(
                username,
                firstName,
                lastName,
                email,
                password
        );
        if(dataProvider.addUser(user) != null) {
            resp.sendRedirect("user/index_user.html");
        }
        else {
            resp.sendRedirect("signup.html");
        }

    }
}

