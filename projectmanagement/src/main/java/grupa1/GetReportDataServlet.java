package grupa1;

import grupa1.Entity.Project;
import grupa1.Entity.Status;
import grupa1.Entity.Task;
import grupa1.Entity.User;
import grupa1.persistence.DataProvider;
import grupa1.persistence.HibernateDataProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet(name = "Report Data", urlPatterns = {"/admin/report", "/user/report"})
public class GetReportDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userIdentifier = request.getParameter("username");
        DataProvider dataProvider = new HibernateDataProvider();
        List<User> users = dataProvider.getAllUsers();
        request.setAttribute("users", users);
        User loggedInUser = dataProvider.getUserByUsername((String) request.getSession().getAttribute("username"));
        Integer userId = null;
        try {
            userId = Integer.parseInt(userIdentifier);
        } catch (NumberFormatException ex) {
            if (!(loggedInUser != null && !loggedInUser.isAdmin())) {
                String baseURI = request.getRequestURI().replace("/report", "");
                request.getRequestDispatcher(baseURI + "/generate_report.jsp").forward(request, response);
                return;
            }
        }
        User user;

        if (loggedInUser.isAdmin()) {
            user = dataProvider.getUserById(userId);
        } else {
            user = loggedInUser;
            request.setAttribute("users", null);
        }

        if (user == null) {
            String baseURI = request.getRequestURI().replace("/report", "");
            request.getRequestDispatcher(baseURI + "/generate_report.jsp").forward(request, response);
            return;
        }
        List<Task> tasks = user.getTasks();
        List<Status> statuses = tasks.stream().map(task -> task.getStatus()).collect(Collectors.toList());


        List<String> statusNames = statuses.stream().map(status -> status.getStatusName()).collect(Collectors.toList());
        Map<String, Integer> statusCounts = new HashMap<>();
        for (String statusName : statusNames) {
            statusCounts.put(statusName, 0);
        }

        for (Task task : tasks) {
            String status = task.getStatus().getStatusName();
            statusCounts.put(status, statusCounts.get(status) + 1);
        }
        dataProvider.commitChanges();

        //List<Integer> counts = new ArrayList<>();
        //statusNames.forEach(s -> counts.add(statusCounts.get(s)));
        //request.setAttribute("statuses", statusNames);
        //request.setAttribute("counts", counts);
        request.setAttribute("statusCounts", statusCounts.entrySet());
        System.out.println(statusCounts);
        String baseURI = request.getRequestURI().replace("/report", "");
        request.getRequestDispatcher(baseURI + "/generate_report.jsp").forward(request, response);
    }
}
