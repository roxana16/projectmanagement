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
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


@WebServlet(name = "CreateProject", urlPatterns = {"/admin/createproject"})
public class CreateProjectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String projectTitle = request.getParameter("title");
        String projectDescription = request.getParameter("description");
        String releasedate = request.getParameter("releasedate");
        System.out.println(projectTitle + " , " + projectDescription + " , " + releasedate);
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH);

        Date projectDate = new Date();
        try {
            projectDate = format.parse(releasedate);
        } catch (ParseException e) {
            System.out.println("Illegal date format!");
            request.setAttribute("error", "Illegal date format.");

            request.getRequestDispatcher("projects").forward(request, response); // Forward to JSP page to redisplay login form with error.
            return;
        }

        Project project = new Project(projectTitle, projectDescription, projectDate);
        DataProvider dataProvider = new HibernateDataProvider();
        Integer newProjectId = dataProvider.addProject(project);
        dataProvider.commitChanges();
        if(newProjectId != null) {
            System.out.println("REDIRECTING TO PROJECTS");
            //response.sendRedirect("index.jsp");
            request.getRequestDispatcher("projects").forward(request, response);
            return;
        }
        else {
            System.out.println("could not create project!");
            request.setAttribute("error", "Unable to create project.");
            request.getRequestDispatcher("projects").forward(request, response); // Forward to JSP page to redisplay login form with error.
        }
    }
}
