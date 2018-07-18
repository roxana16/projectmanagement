package grupa1;

import grupa1.Entity.Assistance;
import grupa1.persistence.DataProvider;
import grupa1.persistence.HibernateDataProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Assistance", urlPatterns = {"/help"})
public class AssistanceServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        String email = req.getParameter("email");
        String subject = req.getParameter("subject");

        Assistance assist = new Assistance(
                firstName,
                lastName,
                email,
                subject
        );

        DataProvider dataProvider = new HibernateDataProvider();
        Integer newAssistId = dataProvider.addAssistance(assist);
        dataProvider.commitChanges();

        res.sendRedirect("/index.jsp");
    }
}