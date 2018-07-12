package persistence;

import Entity.User;
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

    public int addUser(User user) {
        session.beginTransaction();
        int id = (int) session.save(user);
        session.getTransaction().commit();
        return id;
    }

    public User getUserByUsername(String username) {
        session.beginTransaction();
        List<User> result = session
                .createQuery("from User u where u.userName = :username", User.class)
                .setParameter("username", username)
                .list();

        User user = (User)Iterables.getOnlyElement(result, null);
        session.getTransaction().commit();
        return user;
    }
}
