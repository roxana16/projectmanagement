package grupa1;

import grupa1.Entity.User;
import grupa1.persistence.DataProvider;
import grupa1.persistence.HibernateDataProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Test", urlPatterns = {"/test"})
public class TestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("test servlet called.");
        verifyLogin();
    }

    private void addUser() {
        DataProvider provider = new HibernateDataProvider();
        User user = new User("testUser", "testf", "testl", "email@test.com", "test");
        int userId = provider.addUser(user);
    }
    private void verifyLogin() {
        DataProvider provider = new HibernateDataProvider();
        String username = "testUser";
        String password = "test";
        User user = provider.getUserByUsername(username);
        if(user != null && user.hasPassword(password)) {
            System.out.println("Login successful.");
        }
        else {
            System.out.println("Incorrect username or password.");
        }
    }
}
