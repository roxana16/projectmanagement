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


@WebServlet(name = "CreateTask", urlPatterns = {"/createtask"})
public class CreateTaskServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String taskName = request.getParameter("taskname");
        String remainingTime = request.getParameter("remainingtime");
        String taskContent = request.getParameter("taskcontent");
        String selectedUser = request.getParameter("username");
        String selectedProject = request.getParameter("projectname");
        String selectedStatus = request.getParameter("status");
        System.out.println(taskName + " , " + remainingTime + " , " + taskContent + " " + selectedUser + " " + selectedProject + " " + selectedStatus);

        int statusId = Integer.parseInt(selectedStatus);
        int userId = Integer.parseInt(selectedUser);
        int projectId = Integer.parseInt(selectedProject);
        DataProvider dataProvider = new HibernateDataProvider();

        User user = dataProvider.getUserById(userId);
        Status status = dataProvider.getStatusById(statusId);
        Project project = dataProvider.getProjectById(projectId);
        if(user == null || status == null || project == null) {
            request.setAttribute("error", "Unable to create project.");
            request.getRequestDispatcher("/admin/tasks.jsp").forward(request, response); // Forward to JSP page to redisplay l
            return;
        }
        Task task = new Task(taskName, taskContent,Integer.parseInt(remainingTime));
        task.setUser(user);
        task.setStatus(status);
        task.setProject(project);

        Integer newTaskId = dataProvider.addTask(task);
        dataProvider.commitChanges();
        if(newTaskId != null) {
            response.sendRedirect("/admin/tasks");
        }
        else {
            request.setAttribute("error", "Unable to create project.");
            request.getRequestDispatcher("/admin/tasks.jsp").forward(request, response); // Forward to JSP page to redisplay login form with error.
        }
    }
}
