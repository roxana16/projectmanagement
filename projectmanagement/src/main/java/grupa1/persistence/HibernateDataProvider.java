package grupa1.persistence;

import grupa1.Entity.*;
import com.google.common.collect.Iterables;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public void commitChanges() {
        session.getTransaction().commit();
        session.close();
    }

    public Integer addUser(User user) {
        Integer id = (Integer) session.save(user);
        return id;
    }

    public Integer addProject(Project project) {
        Integer id = (Integer) session.save(project);
        return id;
    }

    public Integer addStatus(Status status) {
        Integer id = (Integer) session.save(status);
        return id;
    }

    public Integer addTask(Task task) {
        Integer id = (Integer) session.save(task);
        return id;
    }

    public Integer addComment(Comment comment) {
        Integer id = (Integer) session.save(comment);
        return id;
    }

    public User getUserByUsername(String username) {
        List<User> result = session
                .createQuery("from User u where u.userName = :username", User.class)
                .setParameter("username", username)
                .list();

        User user = (User)Iterables.getOnlyElement(result, null);
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
}
