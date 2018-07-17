package grupa1;

import grupa1.Entity.Project;
import grupa1.Entity.User;
import grupa1.persistence.DataProvider;
import grupa1.persistence.HibernateDataProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "All Projects", urlPatterns = {"/getallprojects"})
public class GetAllProjectsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DataProvider dataProvider = new HibernateDataProvider();
        List<Project> projects = dataProvider.getAllProjects();
        dataProvider.commitChanges();
        System.out.println("read projects from DB.");
        request.setAttribute("projects", projects);
        request.getRequestDispatcher("admin/all_projects_admin.jsp").forward(request, response);;


    }
}
