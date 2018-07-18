package grupa1;

import grupa1.Entity.Project;
import grupa1.Entity.Status;
import grupa1.Entity.User;
import grupa1.persistence.DataProvider;
import grupa1.persistence.HibernateDataProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;


@WebServlet(name = "GenerateReport", urlPatterns = {"/generatereport"})
public class GenerateReport extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataProvider dataProvider = new HibernateDataProvider();

        List<Status> statuses = dataProvider.getAllStatuses();
        List<User> users = dataProvider.getAllUsers();
        //user.getUserName();
        dataProvider.commitChanges();

        //System.out.println("read Statuses from DB.");
        //request.setAttribute("statuses", statuses);
        System.out.println("read Users from DB.");
        request.setAttribute("users", users);

        request.getRequestDispatcher("/admin/generate_report.jsp").forward(request, response);

    }
}
