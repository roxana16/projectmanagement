package grupa1.persistence;

import grupa1.Entity.*;
import com.google.common.collect.Iterables;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;

import java.sql.SQLException;
import java.util.List;

public class HibernateDataProvider implements DataProvider {
    private static final SessionFactory sessionFactory = buildSessionFactory();
    private Session session;

    public HibernateDataProvider() {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
    }

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }


    public void commitChanges() {
        if(session.isOpen()) {
            if(session.getTransaction().isActive())
                session.getTransaction().commit();
            session.close();
        }
    }

    private Integer addObjectWithConstraintViolationChecks(Object objectToAdd) {
        Integer id = null;
        try {
            id = (Integer) session.save(objectToAdd);
        }
        catch (ConstraintViolationException ex) {
            session.getTransaction().rollback();
            session.close();
            id = null;
        }
        return id;
    }

    public Integer addUser(User user) {
        return addObjectWithConstraintViolationChecks(user);
    }

    public Integer addProject(Project project) {
        return addObjectWithConstraintViolationChecks(project);
    }

    public Integer addStatus(Status status) {
        return addObjectWithConstraintViolationChecks(status);
    }

    public Integer addTask(Task task) {
        return addObjectWithConstraintViolationChecks(task);
    }

    public Integer addComment(Comment comment) {
        return addObjectWithConstraintViolationChecks(comment);
    }

    public User getUserById(Integer id) {
        return session.get(User.class, id);
    }

    public Project getProjectById(Integer id) {
        return session.get(Project.class, id);
    }

    public Task getTaskById(Integer id) {
        return session.get(Task.class, id);
    }

    public Status getStatusById(Integer id) {
        return session.get(Status.class, id);
    }

    public Comment getCommentById(Integer id) {
        return session.get(Comment.class, id);
    }

    public User getUserByUsername(String username) {
        List<User> result = session
                .createQuery("from User u where u.userName = :username", User.class)
                .setParameter("username", username)
                .list();

        User user = Iterables.getOnlyElement(result, null);
        return user;
    }

    public List<Status> getAllStatuses() {
        List<Status> statuses = session.createQuery("from Status", Status.class).list();
        return statuses;
    }

    public List<Project> getAllProjects() {
        List<Project> projects = session.createQuery("from Project", Project.class).list();
        return projects;
    }

    public List<Task> getAllTasks() {
        List<Task> tasks = session.createQuery("from Task", Task.class).list();
        return tasks;
    }
}
