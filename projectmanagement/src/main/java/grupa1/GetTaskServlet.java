package grupa1;

import grupa1.Entity.*;
import grupa1.persistence.DataProvider;
import grupa1.persistence.HibernateDataProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "Task", urlPatterns = {"/admin/task", "/user/task"})
public class GetTaskServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        /*String remainingTime = request.getParameter("remainingtime");
        String taskContent = request.getParameter("taskcontent");
        String taskIdentifier = request.getParameter("taskid");
        String selectedStatus = request.getParameter("status");


        int statusId = Integer.parseInt(selectedStatus);
        int taskId = Integer.parseInt(taskIdentifier);
        int remainingHours = Integer.parseInt(remainingTime);

        DataProvider dataProvider = new HibernateDataProvider();

        Status status = dataProvider.getStatusById(statusId);

        Task task = dataProvider.getTaskById(taskId);
        task.setStatus(status);
        task.setTaskContent(taskContent);
        task.setHoursLeft(remainingHours);
        dataProvider.commitChanges();*/
        DataProvider dataProvider = new HibernateDataProvider();
        String taskId = request.getParameter("taskid");
        System.out.println("task id = " + taskId);
        Task task = dataProvider.getTaskById(Integer.parseInt(taskId));
        System.out.println("read task " + task + "from DB.");
        List<Status> statuses = dataProvider.getAllStatuses();

        dataProvider.commitChanges();
        request.setAttribute("task", task);
        request.setAttribute("statuses", statuses);
        //response.sendRedirect("/admin/tasks");

        String baseURI = request.getRequestURI().replace("/task", "");
        request.getRequestDispatcher(baseURI + "/task.jsp").forward(request, response);

    }
}
