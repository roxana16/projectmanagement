package grupa1;

import grupa1.Entity.Comment;
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


@WebServlet(name = "addComment", urlPatterns = {"/admin/addcomment", "/user/addcomment"})
public class AddCommentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String commentContent = request.getParameter("commentcontent");
        String taskIdentifier = request.getParameter("taskid");
        int taskId = Integer.parseInt(taskIdentifier);
        System.out.println("username = " + (String) request.getSession().getAttribute("username"));
        DataProvider dataProvider = new HibernateDataProvider();
        User user = dataProvider.getUserByUsername((String) request.getSession().getAttribute("username"));
        if(user == null) {
            String baseURI = request.getRequestURI().replace("/addcomment", "");
            response.sendRedirect(baseURI + "/task?taskid=" + taskId);
            return;
        }


        Task task = dataProvider.getTaskById(taskId);
        Comment comment = new Comment(commentContent);
        comment.setUser(user);
        System.out.println("user    =  " + user);
        task.addComment(comment);
        dataProvider.addComment(comment);
        dataProvider.commitChanges();

        System.out.println("task ID: " + taskIdentifier);
        //response.sendRedirect("/admin/tasks");

        String baseURI = request.getRequestURI().replace("/addcomment", "");
        //response.sendRedirect(baseURI + "/task?taskid=" + taskId);
        response.sendRedirect(baseURI + "/task?taskid=" + taskId);
        //request.getRequestDispatcher(baseURI + "/task?taskid=" + taskId).forward(request, response);

    }
}
