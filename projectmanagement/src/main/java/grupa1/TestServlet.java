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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@WebServlet(name = "Test", urlPatterns = {"/test"})
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("test servlet called.");
        //addProject();
        //addUser();
        //addStatus();
        //verifyLogin();
        //addTask();
        //getTasksForProject();
        //assignTaskToUser();
        //getTasksForUser();
        //updateTask();
        //addCommentToTask();
        //getCommentsForTask();
    }

    private void addUser() {
        DataProvider provider = new HibernateDataProvider();
        User user = new User("test2", "Tester", "The Second", "tester@mail.com", "test");
        Integer userId = provider.addUser(user);
        if(userId == null)
            System.out.println("Couldn't add user. Most likely because a user with that username already exists");
        provider.commitChanges();
    }

    private void verifyLogin() {
        DataProvider provider = new HibernateDataProvider();
        String username = "testUser";
        String password = "test";
        User user = provider.getUserByUsername(username);
        provider.commitChanges();
        if (user != null && user.hasPassword(password)) {
            System.out.println("Login successful.");
        } else {
            System.out.println("Incorrect username or password.");
        }
    }

    private void updateTask() {
        DataProvider provider = new HibernateDataProvider();
        List<Project> projects = provider.getAllProjects();
        Project theProject = projects.get(1);
        Task task = theProject.getTasks().get(2);
        task.setTaskName("A New Task Name");
        task.setTaskContent("This is a generic description of the task that was updated.");
        provider.commitChanges();
    }

    private void addCommentToTask() {
        DataProvider provider = new HibernateDataProvider();
        List<Project> projects = provider.getAllProjects();
        Project theProject = projects.get(1);
        Task task = theProject.getTasks().get(2);
        Comment comment = new Comment("Test comment");
        User user = provider.getUserByUsername("test");
        comment.setUser(user);
        task.addComment(comment);
        provider.addComment(comment); // !

        provider.commitChanges();
    }

    private void getCommentsForTask() {
        DataProvider provider = new HibernateDataProvider();
        List<Project> projects = provider.getAllProjects();
        Project theProject = projects.get(1);
        Task task = theProject.getTasks().get(2);
        for (Comment comment :
                task.getComments()) {
            System.out.println(comment);
        }

        provider.commitChanges();
    }

    private void addProject() {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date;
        try {
            date = format.parse("2023-06-02");
        } catch (ParseException ex) {
            //handle incorrect time format
            return;
        }
        Project project = new Project(
                "Project number 3",
                "Another project created for testing purposes only.\nNot a real project.",
                date
        );
        DataProvider provider = new HibernateDataProvider();
        int projectId = provider.addProject(project);
        provider.commitChanges();
    }

    private void addStatus() {
        Status status = new Status("Closed");
        DataProvider provider = new HibernateDataProvider();
        int statusId = provider.addStatus(status);
        provider.commitChanges();
    }

    private void addTask() {
        DataProvider provider = new HibernateDataProvider();

        List<Project> projects = provider.getAllProjects();
        Project theProject = projects.get(1);
        Status status = provider.getAllStatuses().get(2);
        Task task = new Task("Another new task", "Fourth task for the 1st project...");
        task.setStatus(status);
        theProject.addTask(task);
        provider.commitChanges();
    }

    private void assignTaskToUser() {
        String username = "user";
        DataProvider provider = new HibernateDataProvider();
        User user = provider.getUserByUsername(username);
        List<Project> projects = provider.getAllProjects();
        Project theProject = projects.get(1);
        Task task = theProject.getTasks().get(3);
        user.assignTask(task);
        provider.commitChanges();
    }

    private void getTasksForProject() {
        DataProvider provider = new HibernateDataProvider();
        List<Project> projects = provider.getAllProjects();
        Project theProject = projects.get(1);

        for (Task task :
                theProject.getTasks()) {
            System.out.println("project " + theProject.getProjectTitle() + " > " + task);
        }
        provider.commitChanges();
    }

    private void getTasksForUser() {
        String username = "test";
        DataProvider provider = new HibernateDataProvider();
        User user = provider.getUserByUsername(username);
        for (Task task :
                user.getTasks()) {
            System.out.println(task);
        }
        provider.commitChanges();
    }
}
