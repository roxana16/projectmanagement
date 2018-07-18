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
import java.util.List;

@WebServlet(name = "All Tasks", urlPatterns = {"/admin/tasks", "/user/tasks"})
    public class GetAllTasksServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DataProvider dataProvider = new HibernateDataProvider();
        List<Project> projects = dataProvider.getAllProjects();
        List<User> users = dataProvider.getAllUsers();
        List<Status> statuses = dataProvider.getAllStatuses();
        List<Task> tasks = dataProvider.getAllTasks();
        dataProvider.commitChanges();
        System.out.println("read tasks from DB.");
        request.setAttribute("projects", projects);
        request.setAttribute("users", users);
        request.setAttribute("statuses", statuses);
        request.setAttribute("tasks", tasks);
        String baseURI = request.getRequestURI().replace("/tasks", "");
        request.getRequestDispatcher(baseURI + "/tasks.jsp").forward(request, response);
        //request.getRequestDispatcher("/admin/tasks.jsp").forward(request, response);;


    }
}
