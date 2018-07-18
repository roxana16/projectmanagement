package grupa1;

import grupa1.Entity.Status;
import grupa1.Entity.Task;
import grupa1.persistence.DataProvider;
import grupa1.persistence.HibernateDataProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "UpdateTask", urlPatterns = {"/admin/updatetask", "/user/updatetask"})
public class UpdateTaskServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("UPDATE TASK");

        String remainingTime = request.getParameter("remainingtime");
        String taskContent = request.getParameter("taskcontent");
        String selectedStatus = request.getParameter("status");
        String taskIdentifier = request.getParameter("taskid");

        System.out.println("task ID: " + taskIdentifier);
        System.out.println("task Content: " + taskContent);
        System.out.println("status index: " + selectedStatus);
        System.out.println("remaining time: " + remainingTime);
        int statusId = Integer.parseInt(selectedStatus);
        int taskId = Integer.parseInt(taskIdentifier);
        int remainingHours = Integer.parseInt(remainingTime);


        DataProvider dataProvider = new HibernateDataProvider();

        Status status = dataProvider.getStatusById(statusId);

        Task task = dataProvider.getTaskById(taskId);
        task.setStatus(status);
        task.setTaskContent(taskContent);
        task.setHoursLeft(remainingHours);
        dataProvider.commitChanges();

        //response.sendRedirect("/admin/tasks");

        String baseURI = request.getRequestURI().replace("/updatetask", "");
        response.sendRedirect(baseURI + "/task?taskid=" + taskId);
        //request.getRequestDispatcher(baseURI + "/task?taskid=" + taskId).forward(request, response);

    }
}
