package grupa1.persistence;

import grupa1.Entity.*;

import java.util.List;

public interface DataProvider {

    Integer addUser(User user);
    User getUserByUsername(String username);
    Integer addProject(Project project);
    Integer addStatus(Status status);
    Integer addTask(Task task);
    Integer addComment(Comment comment);
    List<Status> getAllStatuses();
    List<Project> getAllProjects();
    List<User> getAllUsers();
    void commitChanges();

}
