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

@WebServlet(name = "Project", urlPatterns = {"/admin/project", "/user/project"})
public class GetProjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataProvider dataProvider = new HibernateDataProvider();
        String projectId = request.getParameter("projectid");
        System.out.println("project id = " + projectId);
        Project project = dataProvider.getProjectById(Integer.parseInt(projectId));
        System.out.println("read project " + project + "from DB.");
        request.setAttribute("project", project);
        String baseURI = request.getRequestURI().replace("/project", "");
        request.getRequestDispatcher(baseURI + "/project.jsp").forward(request, response);
    }
}
